#!/usr/bin/env python3
"""Turn the checked exceptions of the decompiled code into unchecked ones.

The dex format has no checked exceptions: a method that fails propagates the
failure to its caller no matter what the signature says.  jadx reconstructs the
Java signatures from the bytecode and therefore produces calls to methods that
declare "throws IOException" inside methods that do not declare it, which
javac rejects with

    unreported exception IOException; must be caught or declared to be thrown

The faithful repair is to catch the failure at the call site and re-throw it
as a RuntimeException, which is exactly what the dex runtime does.
"""
import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from fix_definite_assignment import build_blocks   # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
ERRLOG = '/tmp/ggjc_err.log'

ERR_RE = re.compile(r'^(?P<file>.+?):(?P<line>\d+): error: unreported exception .*?; must be caught or declared to be thrown')

CATCH_TMPL = ('try {{\n{stmt}\n{ind}}} catch (java.lang.RuntimeException e) {{\n{ind}    throw e;\n'
              '{ind}}} catch (java.lang.Throwable e) {{\n{ind}    throw new java.lang.RuntimeException(e);\n{ind}}}')


def mask(text):
    out = list(text)
    i, n = 0, len(text)
    while i < n:
        c = text[i]
        if c == '/' and i + 1 < n and text[i + 1] == '/':
            j = text.find('\n', i)
            j = n if j < 0 else j
            for k in range(i, j):
                out[k] = ' '
            i = j
        elif c == '/' and i + 1 < n and text[i + 1] == '*':
            j = text.find('*/', i + 2)
            j = n if j < 0 else j + 2
            for k in range(i, j):
                if out[k] != '\n':
                    out[k] = ' '
            i = j
        elif c == '"':
            j = i + 1
            while j < n:
                if text[j] == '\\':
                    j += 2
                    continue
                if text[j] == '"':
                    j += 1
                    break
                j += 1
            for k in range(i, min(j, n)):
                if out[k] != '\n':
                    out[k] = ' '
            i = j
        elif c == "'":
            j = i + 1
            while j < n:
                if text[j] == '\\':
                    j += 2
                    continue
                if text[j] == "'":
                    j += 1
                    break
                j += 1
            for k in range(i, min(j, n)):
                if out[k] != '\n':
                    out[k] = ' '
            i = j
        else:
            i += 1
    return ''.join(out)


def statement_start(masked, off):
    s = off
    while s > 0 and masked[s - 1] not in ';{}':
        s -= 1
    return s


def statement_end(masked, start):
    i = start
    n = len(masked)
    depth = 0
    while i < n:
        c = masked[i]
        if c in '([':
            depth += 1
        elif c in ')]':
            depth -= 1
        elif depth == 0:
            if c == ';':
                return i + 1
            if c == '{':
                d = 0
                j = i
                while j < n:
                    if masked[j] == '{':
                        d += 1
                    elif masked[j] == '}':
                        d -= 1
                        if d == 0:
                            break
                    j += 1
                i = j
                k = i + 1
                while k < n and masked[k] in ' \t\r\n':
                    k += 1
                m = re.match(r'[A-Za-z_$][\w$]*', masked[k:])
                if m and m.group(0) in ('else', 'catch', 'finally', 'while'):
                    i = k + len(m.group(0))
                    continue
                return i + 1
        i += 1
    return n


DECL_RE = re.compile(r'^(?P<head>[A-Za-z_$][\w.$]*(?:<[^=;]*>)?(?:\[\])*)\s+'
                     r'(?P<name>[A-Za-z_$][\w$]*)\s*=\s*(?P<init>.+)$', re.S)


def top_level_comma(s):
    depth = 0
    for c in s:
        if c in '([{':
            depth += 1
        elif c in ')]}':
            depth -= 1
        elif c == ',' and depth == 0:
            return True
    return False


def main():
    if not os.path.exists(ERRLOG):
        print('no javac log at', ERRLOG)
        return 1
    per_file = {}
    for line in open(ERRLOG, encoding='utf-8', errors='replace'):
        m = ERR_RE.match(line.rstrip('\n'))
        if m:
            per_file.setdefault(m.group('file'), set()).add(int(m.group('line')))

    total = 0
    skipped = []
    for path, linenos in per_file.items():
        if not os.path.isabs(path):
            path = os.path.join(ROOT, path)
        if not os.path.exists(path):
            continue
        text = open(path, encoding='utf-8').read()
        masked = mask(text)
        blocks = build_blocks(masked)
        offsets = []
        pos = 0
        for ln in text.split('\n'):
            offsets.append(pos)
            pos += len(ln) + 1

        edits = {}
        for lineno in sorted(linenos):
            if lineno - 1 >= len(offsets):
                continue
            off = offsets[lineno - 1]
            st = statement_start(masked, off)
            en = statement_end(masked, st)
            if st in edits:
                continue
            stmt = text[st:en]
            body = stmt.rstrip()
            if body.endswith(';'):
                body = body[:-1]
            # sanity: the statement has to be a real statement inside a method
            if not body.strip() or body.lstrip().startswith('}'):
                skipped.append((path, lineno, 'empty:' + body[:40]))
                continue
            inner = None
            for b in blocks:
                if b['open'] <= st and (b['close'] is None or st < b['close']):
                    if b['scope'] and (inner is None or b['open'] > inner['open']):
                        inner = b
            if inner is None:
                skipped.append((path, lineno, 'not-in-method:' + body[:40]))
                continue
            ind = re.match(r'[ \t]*', text[st:]).group(0)
            d = re.match(r'\s*(?P<k>if|for|while|switch|do|try|synchronized)\b', body)
            dm = DECL_RE.match(body)
            if dm and not d and not body.startswith('return') and not body.startswith('throw'):
                init = dm.group('init')
                if top_level_comma(init) or 'final' in dm.group('head'):
                    skipped.append((path, lineno, body[:60]))
                    continue
                new = ('%s %s;\n%s' % (dm.group('head'), dm.group('name'), ind) +
                       CATCH_TMPL.format(stmt='%s%s = %s;' % (ind, dm.group('name'), init.strip()),
                                         ind=ind))
            else:
                tail = '' if body.rstrip().endswith('}') else ';'
                new = CATCH_TMPL.format(stmt=ind + body + tail, ind=ind)
            edits[st] = (en, new)
            total += 1
        if edits:
            out = text
            for st in sorted(edits, reverse=True):
                en, new = edits[st]
                out = out[:st] + new + out[en:]
            open(path, 'w', encoding='utf-8').write(out)

    print('statements wrapped:', total)
    if skipped:
        print('skipped (manual):', len(skipped))
        for s in skipped[:30]:
            print('  ', s[0].split('/java/')[-1], s[1], '|', s[2])
    return 0


if __name__ == '__main__':
    sys.exit(main())
