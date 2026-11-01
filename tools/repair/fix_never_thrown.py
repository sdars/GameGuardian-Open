#!/usr/bin/env python3
"""Keep the dex exception handlers alive for javac.

The dex format has no checked exceptions: a handler matches the runtime type
of the failure, no matter what the Java signatures declare.  jadx therefore
keeps handlers for exception types that javac considers unreachable
("exception X is never thrown in body of corresponding try statement").

The repair inserts a guarded throw of exactly the handled type into the try
block:

    if (android.ext.GgNoop.never) {
        throw new java.io.IOException();
    }

GgNoop.never is a plain (non final) static field, so javac cannot fold the
condition away: the statement stays reachable for the compiler while it never
executes at run time.  The dex handler therefore survives the translation
unchanged and keeps its original runtime behaviour.
"""
import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from fix_definite_assignment import build_blocks, mask   # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

KEEP = 'android.ext.GgNoop.keep();'

# exception types that need constructor arguments
CTOR_ARGS = {
    'luaj.lib.IoLib$c': '""',
    'gg_e.b': 'null, ""',
    'gg_e.d': '""',
}


def catch_types(masked, try_block):
    """Return the exception types handled by the try block."""
    out = []
    i = try_block['close'] + 1
    n = len(masked)
    while i < n:
        while i < n and masked[i] in ' \t\r\n':
            i += 1
        m = re.match(r'catch\s*\(', masked[i:])
        if not m:
            break
        j = i + m.end()
        depth = 1
        k = j
        while k < n:
            if masked[k] == '(':
                depth += 1
            elif masked[k] == ')':
                depth -= 1
                if depth == 0:
                    break
            k += 1
        if k >= n:
            break
        out.append(masked[j:k].strip())
        # skip the catch block
        b = masked.find('{', k)
        if b < 0:
            break
        d = 0
        while b < n:
            if masked[b] == '{':
                d += 1
            elif masked[b] == '}':
                d -= 1
                if d == 0:
                    break
            b += 1
        i = b + 1
    return out


def main():
    apply = '--apply' in sys.argv
    total = 0
    for dirpath, _dirs, files in os.walk(SRC):
        for fn in files:
            if not fn.endswith('.java'):
                continue
            path = os.path.join(dirpath, fn)
            text = open(path, encoding='utf-8').read()
            if KEEP not in text:
                continue
            masked = mask(text)
            blocks = build_blocks(masked)
            edits = []
            pos = 0
            while True:
                k = text.find(KEEP, pos)
                if k < 0:
                    break
                pos = k + len(KEEP)
                inner = None
                for b in blocks:
                    if b.get('kw') != 'try':
                        continue
                    if b['open'] < k and (b['close'] is None or k < b['close']):
                        if inner is None or b['open'] > inner['open']:
                            inner = b
                if inner is None:
                    print('  no enclosing try:', path, text[:k].count(chr(10)) + 1)
                    continue
                types = catch_types(masked, inner)
                picked = None
                for t in types:
                    base = t.split('|')[0].strip()
                    base = re.sub(r'\bfinal\b', '', base).strip()
                    parts = base.split()
                    if len(parts) > 1:
                        base = parts[0]
                    if not re.fullmatch(r'[A-Za-z_$][\w.$]*', base):
                        continue
                    if base in ('java.lang.Throwable', 'java.lang.Error'):
                        continue
                    if base.startswith('java.lang.RuntimeException'):
                        continue
                    picked = base
                    break
                if picked is None:
                    # a catch of Throwable already covers the marker
                    if any(re.split(r'\s+', t.split('|')[0].strip())[0] == 'java.lang.Throwable'
                           for t in types):
                        continue
                    print('  unhandled catch types:', path, types)
                    continue
                args = CTOR_ARGS.get(picked, '')
                new = ('if (android.ext.GgNoop.never) {\n'
                       '                        throw new %s(%s);\n'
                       '                    }' % (picked, args))
                edits.append((k, k + len(KEEP), new))
                total += 1
            if not edits:
                continue
            out = text
            for s, e, new in sorted(edits, reverse=True):
                out = out[:s] + new + out[e:]
            if apply:
                open(path, 'w', encoding='utf-8').write(out)
    print('never-thrown markers rewritten:', total, '(apply=%s)' % apply)
    return 0


if __name__ == '__main__':
    sys.exit(main())
