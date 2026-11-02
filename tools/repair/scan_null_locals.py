#!/usr/bin/env python3
"""Find local variables that are used before they are assigned.

jadx sometimes loses an assignment - the variable keeps its `= null`
initialiser and the first use of it throws a NullPointerException on the
device.  The scanner reports every local that is declared with `= null` and
dereferenced before it is assigned.

    python3 tools/repair/scan_null_locals.py [file ...]
"""

import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import java_lexer  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

DECL = re.compile(r'(?:^|[({;])\s*([A-Za-z_$][\w$.<>\[\]]*)\s+([a-z][\w$]*)\s*=\s*null\s*;')
ASSIGN = re.compile(r'(?<![=!<>]){0}\s*=(?!=)')
USE = re.compile(r'(?<![\w$]){0}\s*\.')


def scan(path):
    text = open(path, encoding='utf-8').read()
    masked = java_lexer.code_mask(text)
    offs = java_lexer.line_offsets(text)
    lines = text.split('\n')
    hits = []
    for i, line in enumerate(lines):
        m = DECL.search(masked[offs[i]:offs[i] + len(line)])
        if not m:
            continue
        name = m.group(2)
        assign = re.compile(ASSIGN.pattern.format(re.escape(name)))
        use = re.compile(USE.pattern.format(re.escape(name)))
        for j in range(i + 1, len(lines)):
            seg = masked[offs[j]:offs[j] + len(lines[j])]
            if assign.search(seg):
                break
            if use.search(seg):
                hits.append((i + 1, j + 1, name, line.strip()))
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
        for decl, use, name, text in hits:
            print('%-60s %s declared at line %d, used at line %d' % (rel, name, decl, use))
            total += 1
    print()
    print('%d local(s) used before they are assigned' % total)


if __name__ == '__main__':
    main()

