#!/usr/bin/env python3
"""Find the loops where a range check is followed by an unconditional break.

jadx flattens the else branch of an if into the code that follows the if
block.  When the if block is a range check (a length of a string or of a
buffer) and the code that follows it reports the bad value and leaves the
loop, the error is reported for every value - the reconstruction then throws
on the first entry instead of only on a malformed one.

The scanner reports every `if (<range check>) { ... }` inside a loop that is
followed by a `break` on the same level.

    python3 tools/repair/scan_flat_break.py [file ...]
"""

import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import java_lexer  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

LOOPS = ('while (true)', 'while(true)', 'for (;;)', 'for(;;)')
RANGE = re.compile(r'>=\s*-?\d+.*<=|>\s*-?\d+.*<\s*-?\d+|>=.*&&.*<=')


def block_end(ml, start_line):
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
    text = open(path, encoding='utf-8').read()
    masked = java_lexer.code_mask(text)
    offs = java_lexer.line_offsets(text)
    lines = text.split('\n')
    ml = [masked[offs[i]:offs[i] + len(line)] for i, line in enumerate(lines)]
    hits = []
    for i, line in enumerate(lines):
        if not any(loop in line for loop in LOOPS):
            continue
        if '{' not in ml[i]:
            continue
        loop_end = block_end(ml, i)
        if loop_end is None:
            continue
        blocks = []
        j = i + 1
        while j < loop_end:
            s = ml[j].strip()
            if s.startswith('if') and '(' in s and '{' in ml[j]:
                end = block_end(ml, j)
                if end is not None:
                    blocks.append((j, end))
            j += 1
        for j, end in blocks:
            indent = len(lines[j]) - len(lines[j].lstrip())
            for k in range(end + 1, min(end + 6, loop_end)):
                if ml[k].strip().startswith('break'):
                    kindent = len(lines[k]) - len(lines[k].lstrip())
                    if kindent == indent and RANGE.search(ml[j]):
                        hits.append((j + 1, end + 1, lines[j].strip()))
                    break
    return hits


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
        for start, end, cond in hits:
            print('%-58s %5d-%-5d %s' % (rel, start, end, cond))
            total += 1
    print()
    print('%d range check(s) followed by an unconditional break' % total)


if __name__ == '__main__':
    main()

