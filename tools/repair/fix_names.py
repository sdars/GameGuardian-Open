#!/usr/bin/env python3
"""Normalise class references in the flattened GameGuardian source tree.

jadx's "one class per file" mode renames every nested class to <Outer>$<Inner>.
It writes references to *this project's* classes fully qualified
("a.a$b") and references to framework nested classes with a '$'
("android.view.View$OnClickListener") - neither spelling is valid Java in the
position jadx puts it:

  * framework nested classes need the '.' notation,
  * this project's own classes must not be package-qualified when the file
    already lives in that package (the package name is shadowed by a class of
    the same name - every obfuscated package a..g contains classes a..g).

Every change is driven by a real javac diagnostic and re-verified by the next
compile round.
"""
import os, re, sys, zipfile, collections

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')
SDK = os.environ.get('GG_SDK', '/root/gameguardian/tmp/tools/android-sdk')
ERRLOG = '/tmp/ggjc_err.log'

IDENT = re.compile(r'[A-Za-z_$][\w$]*')

# the obfuscator produced packages a..g that each contain classes a..g, so the
# package name is shadowed by a class of the same name.  Those packages are
# renamed to gg_a..gg_g (see tools/repair/rename_packages.py).
RENAME_PKG = {'a': 'gg_a', 'b': 'gg_b', 'c': 'gg_c', 'd': 'gg_d',
              'e': 'gg_e', 'f': 'gg_f', 'g': 'gg_g'}


def build_index():
    files, pkgs = {}, set()
    simple = collections.defaultdict(set)
    for dirpath, _dirs, names in os.walk(SRC):
        rel = os.path.relpath(dirpath, SRC)
        pkg = '' if rel == '.' else rel.replace(os.sep, '.')
        if pkg:
            pkgs.add(pkg)
        for n in names:
            if n.endswith('.java'):
                files[(pkg + '.' + n[:-5]) if pkg else n[:-5]] = os.path.join(dirpath, n)
                simple[pkg].add(n[:-5].split('$')[0])
    return files, pkgs, simple


def sdk_classes():
    out = set()
    jar = os.path.join(SDK, 'platforms', 'android-34', 'android.jar')
    with zipfile.ZipFile(jar) as z:
        for n in z.namelist():
            if n.endswith('.class'):
                out.add(n[:-6].replace('/', '.'))
    return out


def pkg_of(path):
    d = os.path.dirname(os.path.relpath(path, SRC))
    return '' if d == '.' else d.replace(os.sep, '.')


def parse_errors():
    errs = []
    lines = open(ERRLOG, encoding='utf-8', errors='replace').read().split('\n')
    i = 0
    while i < len(lines):
        m = re.match(r'^(?P<file>/?[^:]+\.java):(?P<line>\d+): error: (?P<msg>.*)$', lines[i])
        if not m:
            i += 1
            continue
        e = dict(file=m.group('file'), line=int(m.group('line')), msg=m.group('msg'), col=None,
                 symbol=None, loc=None, src='')
        if i + 2 < len(lines) and lines[i + 1].strip() and '^' in lines[i + 2]:
            e['src'] = lines[i + 1]
            e['col'] = lines[i + 2].index('^') + 1
        j = i + 3
        while j < len(lines) and not re.match(r'^[^:]+\.java:\d+: error:', lines[j]):
            ms = re.match(r'\s*symbol:\s+(.*)$', lines[j])
            ml = re.match(r'\s*location:\s+(.*)$', lines[j])
            if ms: e['symbol'] = ms.group(1).strip()
            if ml: e['loc'] = ml.group(1).strip()
            j += 1
        errs.append(e)
        i = j
    return errs


def span_of(src_line, col):
    """Span (start, end) of the qualified name that covers the 1-based col."""
    i = min(max(col - 1, 0), len(src_line) - 1)
    if not (src_line[i].isalnum() or src_line[i] in '_$'):
        j = i
        while j > 0 and (src_line[j - 1].isalnum() or src_line[j - 1] in '_$.'):
            j -= 1
        if j == i:
            return None
        i = j
    start = i
    while start > 0 and (src_line[start - 1].isalnum() or src_line[start - 1] in '_$.'):
        start -= 1
    end = i
    while end < len(src_line) and (src_line[end].isalnum() or src_line[end] in '_$.'):
        end += 1
    name = src_line[start:end]
    if not IDENT.match(name) or not re.fullmatch(r'[A-Za-z_$][\w$]*(?:\.[A-Za-z_$][\w$]*)*', name):
        return None
    return start, end, name


def resolve_class(q, pkg, files, pkgs, sdk, simple):
    """Resolve one class reference q -> (new_text, kind)."""
    if q in files:                                # one of this project's classes
        p, _, c = q.rpartition('.')
        if p and pkg == p:
            return c, 'own_depkg'
        if p in RENAME_PKG and pkg != p:          # shadowed package -> renamed package
            return RENAME_PKG[p] + '.' + c, 'pkg_renamed'
        return q, 'own_ok'
    if q in sdk:                                  # framework class written with '$'
        head, _, tail = q.rpartition('$')
        return head + '.' + tail, 'framework_nested'
    head, _, tail = q.rpartition('.')
    if head in pkgs and (head + '.' + tail) in files:   # package qualified, shadowed?
        if pkg == head:
            return tail, 'own_depkg'
        if head in RENAME_PKG:                         # package a..g is renamed
            return RENAME_PKG[head] + '.' + tail, 'pkg_renamed'
        if head in simple.get(pkg, ()):
            return None, 'shadowed_cross_pkg'
        return q, 'cross_pkg_ok'
    if head and (head + '$' + tail) in files:
        return head + '$' + tail, 'own_nested_dollar'
    return None, 'unresolved'


def resolve(run, pkg, files, pkgs, sdk, simple):
    """Resolve a dotted run; only the class prefix is rewritten."""
    parts = run.split('.')
    for k in range(len(parts), 0, -1):
        prefix = '.'.join(parts[:k])
        suffix = '.'.join(parts[k:])
        new, kind = resolve_class(prefix, pkg, files, pkgs, sdk, simple)
        if new is not None:
            return (new + ('.' + suffix if suffix else '')), kind
    return None, 'unresolved'


def main():
    files, pkgs, simple = build_index()
    sdk = sdk_classes()
    errs = parse_errors()
    edits = collections.defaultdict(list)
    stats = collections.Counter()

    for e in errs:
        if e['msg'].startswith('package ') and e['msg'].endswith('does not exist'):
            path = e['file']
            if not os.path.isabs(path):
                path = os.path.join(SRC, path)
            if not path.startswith(SRC):
                continue
            pkg = pkg_of(path)
            sp = span_of(e['src'], e['col'] or 1)
            if not sp:
                continue
            start, end, run = sp
            new, kind = resolve(run, pkg, files, pkgs, sdk, simple)
            stats[kind] += 1
            if new is None or new == run:
                continue
            edits[path].append((e['line'], start, end, run, new, kind))
            continue
        if not e['msg'].startswith('cannot find symbol'):
            continue
        sym = e['symbol'] or ''
        if not (sym.startswith('class ') or sym.startswith('variable ')):
            continue
        path = e['file']
        if not os.path.isabs(path):
            path = os.path.join(SRC, path)
        if not path.startswith(SRC):
            continue
        pkg = pkg_of(path)
        sp = span_of(e['src'], e['col'] or 1)
        if not sp:
            continue
        start, end, q = sp
        if sym.startswith('variable '):
            # the compiler points at the member; look for a package qualified name
            last = sym.split(' ', 1)[1]
            m = None
            for cand in re.finditer(r'[A-Za-z_$][\w$]*(?:\.[A-Za-z_$][\w$]*)*\.' + re.escape(last) + r'\b', e['src']):
                if cand.start() <= (e['col'] or 1) - 1 <= cand.end() or m is None:
                    m = cand
                    if cand.start() <= (e['col'] or 1) - 1 <= cand.end():
                        break
            if not m:
                continue
            q = m.group(0)
            start, end = m.start(), m.end()
        new, kind = resolve(q, pkg, files, pkgs, sdk, simple)
        stats[kind] += 1
        if new is None or new == q:
            continue
        edits[path].append((e['line'], start, end, q, new, kind))

    changed = 0
    for path, es in edits.items():
        lines = open(path, encoding='utf-8').read().split('\n')
        for line, start, end, old, new, kind in sorted(set(es), key=lambda t: (-t[0], -t[1])):
            s = lines[line - 1]
            if s[start:end] != old:
                print('SKIP:', path, line, repr(old), '->', new)
                continue
            lines[line - 1] = s[:start] + new + s[end:]
            changed += 1
        open(path, 'w', encoding='utf-8').write('\n'.join(lines))
    print('edits applied:', changed)
    for k, v in stats.most_common():
        print('  %s: %d' % (k, v))


if __name__ == '__main__':
    main()
