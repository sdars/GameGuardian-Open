#!/usr/bin/env python3
"""Compiler-driven reference resolver for the flattened GameGuardian sources.

jadx's "one class per file" output spells this project's own classes with
their *original* package name ("a.a$b", "f.a", ...) even though the tree was
re-packaged to gg_a..gg_g, and it spells Android framework nested classes with
'\$' ("android.view.View$OnClickListener").  Neither spelling resolves in
Java, so javac reports them as "package a does not exist" / "cannot find
symbol".  This script reads those diagnostics and rewrites exactly the run of
characters the caret points at.

Every edit is driven by a real javac message, so the script is idempotent and
safe to re-run:  bash tools/javac_check.sh && python3 tools/repair/fix_refs.py
"""
import os
import re
import sys
import zipfile
import collections

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')
SDK = os.environ.get('GG_SDK', os.path.join(ROOT, 'tmp', 'tools', 'android-sdk'))
ERRLOG = os.environ.get('GG_ERRLOG', '/tmp/ggjc_err.log')

# obfuscated package -> renamed package (see tools/repair/rename_packages.py)
PKG_ALIAS = {p: 'gg_' + p for p in 'abcdefg'}
PKG_UNALIAS = {v: k for k, v in PKG_ALIAS.items()}

DOTTED = re.compile(r'[A-Za-z_$][\w$]*(?:\.[A-Za-z_$][\w$]*)*')
AUDIT = os.environ.get('GG_AUDIT', '/tmp/gg_refs_audit.log')


def build_index():
    """(pkg, simple-name) -> path, and the set of known packages."""
    files = {}
    pkgs = set()
    for dirpath, _dirs, names in os.walk(SRC):
        rel = os.path.relpath(dirpath, SRC)
        pkg = '' if rel == '.' else rel.replace(os.sep, '.')
        if pkg:
            pkgs.add(pkg)
        for n in names:
            if n.endswith('.java'):
                files[(pkg, n[:-5])] = os.path.join(dirpath, n)
    return files, pkgs


def sdk_classes():
    out = set()
    jar = os.path.join(SDK, 'platforms', 'android-34', 'android.jar')
    if not os.path.exists(jar):
        return out
    with zipfile.ZipFile(jar) as z:
        for n in z.namelist():
            if n.endswith('.class'):
                out.add(n[:-6].replace('/', '.'))
    return out


def parse_errors(path):
    errs = []
    if not os.path.exists(path):
        return errs
    lines = open(path, encoding='utf-8', errors='replace').read().split('\n')
    i = 0
    while i < len(lines):
        m = re.match(r'^(?P<file>[^:]+\.java):(?P<line>\d+): error: (?P<msg>.*)$', lines[i])
        if not m:
            i += 1
            continue
        e = {'file': m.group('file'), 'line': int(m.group('line')),
             'msg': m.group('msg'), 'src': '', 'col': 0, 'symbol': None}
        if i + 2 < len(lines) and lines[i + 1].strip() and '^' in lines[i + 2]:
            e['src'] = lines[i + 1]
            e['col'] = lines[i + 2].index('^')
        j = i + 3
        while j < len(lines) and not re.match(r'^[^:]+\.java:\d+: error:', lines[j]):
            ms = re.match(r'\s*symbol:\s+(.*)$', lines[j])
            if ms:
                e['symbol'] = ms.group(1).strip()
            j += 1
        errs.append(e)
        i = j
    return errs


def run_at(src_line, col):
    """Return (start, end, text) of the dotted run that covers 0-based col."""
    if not src_line:
        return None
    if col >= len(src_line):
        return None
    if not (src_line[col].isalnum() or src_line[col] in '_$'):
        col -= 1
        if col < 0:
            return None
    if not (src_line[col].isalnum() or src_line[col] in '_$'):
        return None
    start = col
    while start > 0 and (src_line[start - 1].isalnum() or src_line[start - 1] in '_$.'):
        start -= 1
    end = col
    while end < len(src_line) and (src_line[end].isalnum() or src_line[end] in '_$.'):
        end += 1
    text = src_line[start:end]
    if not DOTTED.fullmatch(text):
        return None
    return start, end, text


def resolve(run, pkg, files, pkgs, sdk):
    """Resolve a dotted run to a corrected spelling."""
    parts = run.split('.')
    for k in range(len(parts), 0, -1):
        prefix = '.'.join(parts[:k])
        suffix = '.'.join(parts[k:])
        cand = resolve_class(prefix, pkg, files, pkgs, sdk)
        if cand is not None:
            return cand + (('.' + suffix) if suffix else '')
    return None


def resolve_class(q, pkg, files, pkgs, sdk):
    # 1) this project's own class, possibly still using the old package name
    head, _, tail = q.rpartition('.')
    if head:
        newpkg = PKG_ALIAS.get(head)
        if newpkg and (newpkg, tail) in files:
            if newpkg == pkg:
                return tail
            return newpkg + '.' + tail
    if (pkg, q) in files:
        return q
    # 2) framework class spelled with '$' -> use '.' notation
    if q in sdk:
        h, _, t = q.rpartition('$')
        return h + '.' + t
    # 3) own nested class: a$b -> a$b is already fine, but a.b where a is a
    #    project class holding nested class b
    if head and (head, tail) in files:
        if pkg == head:
            return tail
        return head + '.' + tail
    # 4) project class in another package (fully qualified, valid)
    if head in pkgs and (head, tail) in files:
        if pkg == head:
            return tail
        return head + '.' + tail
    # 5) nested class of a project class: Outer$Inner
    if head and (head, '$' + tail) in files:
        return q
    return None


def main():
    files, pkgs = build_index()
    sdk = sdk_classes()
    errs = parse_errors(ERRLOG)
    edits = collections.defaultdict(list)
    stats = collections.Counter()

    for e in errs:
        path = e['file']
        if not os.path.isabs(path):
            path = os.path.join(SRC, path)
        if not path.startswith(SRC) or not os.path.exists(path):
            continue
        pkg = os.path.dirname(os.path.relpath(path, SRC)).replace(os.sep, '.')
        if pkg == '.':
            pkg = ''
        msg = e['msg']
        run = None
        if msg.startswith('package ') and msg.endswith(' does not exist'):
            sp = run_at(e['src'], e['col'])
            if sp:
                run = sp[2]
        elif msg.startswith('cannot find symbol'):
            sym = (e['symbol'] or '')
            sp = run_at(e['src'], e['col'])
            if sym.startswith('class ') and sp:
                run = sp[2]
            elif sym.startswith('variable ') and sp:
                last = sym.split(' ', 1)[1]
                for m in re.finditer(r'[A-Za-z_$][\w$]*(?:\.[A-Za-z_$][\w$]*)*\.' +
                                     re.escape(last) + r'\b', e['src']):
                    if m.start() <= e['col'] < m.end():
                        run = m.group(0)
                        sp = (m.start(), m.end(), run)
                        break
                if run is None:
                    continue
            elif sym.startswith('method ') and sp:
                run = sp[2]
            else:
                continue
        else:
            continue
        if not run:
            continue
        new = resolve(run, pkg, files, pkgs, sdk)
        if new is None or new == run:
            stats['unresolved:' + run] += 1
            continue
        if (new.startswith('.') or new.endswith('.') or '..' in new
                or not DOTTED.fullmatch(new)):
            stats['rejected:' + run + ' -> ' + new] += 1
            continue
        start, end, _ = sp
        edits[path].append((e['line'], start, end, run, new))
        stats['fixed:' + run + ' -> ' + new] += 1

    changed = 0
    for path, es in edits.items():
        lines = open(path, encoding='utf-8').read().split('\n')
        for line, start, end, old, new in sorted(set(es), key=lambda t: (-t[0], -t[1])):
            s = lines[line - 1]
            if s[start:end] != old:
                continue
            lines[line - 1] = s[:start] + new + s[end:]
            changed += 1
        open(path, 'w', encoding='utf-8').write('\n'.join(lines))
    with open(AUDIT, 'a', encoding='utf-8') as fh:
        for path, es in edits.items():
            for line, start, end, old, new in sorted(set(es)):
                fh.write('%s:%d  %s  ->  %s\n' % (
                    os.path.relpath(path, SRC), line, old, new))
    print('edits applied:', changed)
    for k, v in stats.most_common(40):
        print('  %s: %d' % (k, v))


if __name__ == '__main__':
    main()
