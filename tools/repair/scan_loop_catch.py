#!/usr/bin/env python3
"""Find java methods whose exception handler inside a loop does not leave it.

jadx sometimes moves the catch clause of a loop into the loop body.  When the
original dex leaves the loop in the handler, the java translation continues
the loop instead - an endless loop or a repeated side effect.

The scanner reports every catch clause that sits inside a loop body and does
not contain a break/return/throw of its own.  Each hit has to be compared
with the smali of the original dex.

    python3 tools/repair/scan_loop_catch.py [file ...]
"""

import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import java_lexer  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

LOOPS = ('while (true)', 'while(true)', 'for (;;)', 'for(;;)')


def masked_lines(path):
    text = open(path, encoding='utf-8').read()
    masked = java_lexer.code_mask(text)
    offs = java_lexer.line_offsets(text)
    lines = text.split('\n')
    ml = []
    for i, line in enumerate(lines):
        ml.append(masked[offs[i]:offs[i] + len(line)])
    return lines, ml


def block_end(ml, start_line, col):
    """Index of the line that closes the brace opened at (start_line, col)."""
    depth = 0
    for j in range(start_line, len(ml)):
        for ch in ml[j]:
            if ch == '{':
                depth += 1
            elif ch == '}':
                depth -= 1
                if depth == 0:
                    return j
    return None


def scan(path):
    lines, ml = masked_lines(path)
    out = []
    for i, line in enumerate(lines):
        if not any(loop in line for loop in LOOPS):
            continue
        col = ml[i].find('{')
        if col < 0:
            continue
        end = block_end(ml, i, col)
        if end is None:
            continue
        # every catch clause inside the loop body
        for j in range(i, end + 1):
            if 'catch' not in ml[j]:
                continue
            k = ml[j].find('catch')
            c = ml[j].find('{', k)
            if c < 0:
                continue
            cend = block_end(ml, j, c)
            if cend is None:
                continue
            body = ' '.join(lines[j:cend + 1])
            if 'break' in body or 'return' in body or 'throw' in body:
                continue
            out.append((j + 1, cend + 1))
    return out


def main():
    args = sys.argv[1:]
    if args:
        files = args
    else:
        files = []
        for dirpath, _dirs, names in os.walk(SRC):
            for name in names:
                if name.endswith('.java'):
                    files.append(os.path.join(dirpath, name))
    total = 0
    for path in sorted(files):
        hits = scan(path)
        if not hits:
            continue
        rel = os.path.relpath(path, ROOT)
        for start, end in hits:
            print('%-72s catch at lines %d-%d' % (rel, start, end))
            total += 1
    print()
    print('%d catch clause(s) inside a loop without break/return/throw' % total)


if __name__ == '__main__':
    main()

