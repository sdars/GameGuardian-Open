#!/usr/bin/env python3
"""Repair the class initialisers that jadx turned into "return" statements.

A dex static initialiser cannot return, but jadx reconstructs the early exit
of the enclosing loop as a "return".  javac rejects the initialiser with

    initializer must be able to complete normally

and marks every following member of the class as unreachable.  The repair
turns the "return" into the "break" of the loop it belongs to, which is what
the dex code did.
"""
import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from fix_checked_exceptions import mask      # noqa: E402
from fix_definite_assignment import build_blocks   # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
ERRLOG = '/tmp/ggjc_err.log'

ERR = re.compile(r'^(?P<file>.+?):(?P<line>\d+): error: initializer must be able to complete normally')
RET = re.compile(r'\breturn\b')


def main():
    if not os.path.exists(ERRLOG):
        print('no javac log at', ERRLOG)
        return 1
    per_file = {}
    for line in open(ERRLOG, encoding='utf-8', errors='replace'):
        m = ERR.match(line.rstrip('\n'))
        if m:
            per_file.setdefault(m.group('file'), set()).add(int(m.group('line')))

    total = 0
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
        edits = []
        for lineno in sorted(linenos):
            off = offsets[lineno - 1]
            # the static initialiser block
            k = masked.find('{', off)
            if k < 0:
                continue
            depth = 0
            e = k
            while e < len(masked):
                if masked[e] == '{':
                    depth += 1
                elif masked[e] == '}':
                    depth -= 1
                    if depth == 0:
                        break
                e += 1
            body = masked[k:e]
            # every "return" inside the initialiser
            for m in RET.finditer(body):
                p = k + m.start()
                # "return <expr>;" -> find the end of the statement
                q = masked.find(';', p)
                if q < 0 or q > e:
                    continue
                stmt = text[p:q + 1]
                if stmt.strip() != 'return;':
                    # a "return <expr>" is only legal in a method, keep it
                    continue
                # is the return inside a loop?
                inner = None
                for b in blocks:
                    if b['open'] <= p < (b['close'] or 0):
                        if inner is None or b['open'] > inner['open']:
                            inner = b
                repl = 'break;'
                if inner is not None:
                    j = inner['open'] - 1
                    while j >= 0 and masked[j] in ' \t\r\n':
                        j -= 1
                    word = re.search(r'([A-Za-z_$][\w$]*)\s*$', masked[max(0, j - 20):inner['open']])
                    if word is None or word.group(1) not in ('while', 'for', 'do'):
                        repl = ''
                edits.append((p, q + 1, repl))
        if edits:
            out = text
            for s, e, new in sorted(edits, reverse=True):
                out = out[:s] + new + out[e:]
            open(path, 'w', encoding='utf-8').write(out)
            total += len(edits)
    print('initialiser returns repaired:', total)
    return 0


if __name__ == '__main__':
    sys.exit(main())

