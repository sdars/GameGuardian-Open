#!/usr/bin/env python3
"""Report the exception handlers of the smali methods of one class.

For every method of the smali file the tool prints

  * the back edges of the loops (a goto to a label that was defined earlier),
  * every catch handler with the instruction that leaves it.

It is used to check the java translation of a method against the dex it came
from - a handler that leaves the loop in the dex has to leave the loop in the
java code as well.

    python3 tools/repair/smali_handlers.py <smali-file> [method-name]
"""

import os
import re
import sys


def methods(path):
    out = []
    cur = None
    for raw in open(path, encoding='utf-8', errors='replace'):
        line = raw.rstrip('\n')
        if line.startswith('.method'):
            cur = {'head': line, 'ins': []}
            out.append(cur)
            continue
        if cur is None:
            continue
        if line.startswith('.end method'):
            cur = None
            continue
        cur['ins'].append(line)
    return out


def analyse(m):
    ins = m['ins']
    labels = {}
    for i, line in enumerate(ins):
        s = line.strip()
        if s.startswith(':') and not s.startswith(':'):
            name = s.split()[0].rstrip(':')
            labels[name] = i
    back = []
    for i, line in enumerate(ins):
        s = line.strip()
        mo = re.match(r'goto(?:/\d+)? (:\w+)', s)
        if mo and mo.group(1)[1:] in labels and labels[mo.group(1)[1:]] < i:
            back.append((i, mo.group(1)))
    handlers = []
    for i, line in enumerate(ins):
        s = line.strip()
        if s.startswith('.catch'):
            handlers.append(i)
    return ins, labels, back, handlers


def main():
    if len(sys.argv) < 2:
        print(__doc__)
        return 2
    path = sys.argv[1]
    want = sys.argv[2] if len(sys.argv) > 2 else None
    for m in methods(path):
        head = m['head']
        name = head.split('(')[0].split()[-1] if '(' in head else head
        if want and want not in head:
            continue
        ins, labels, back, handlers = analyse(m)
        if not handlers:
            continue
        print('=' * 78)
        print(head)
        for i, target in back:
            print('  loop back edge  line %4d  -> %-12s (body starts at line %d)' % (
                i + 1, target, labels[target[1:]] + 1))
        for h in handlers:
            print('  handler at line %d:' % (h + 1))
            for j in range(h, min(h + 12, len(ins))):
                s = ins[j].strip()
                if not s:
                    continue
                print('      %5d %s' % (j + 1, s))
                mo = re.match(r'(goto(?:/\d+)? :\w+|return.*|throw .*)', s)
                if mo and not s.startswith('.catch'):
                    break


if __name__ == '__main__':
    sys.exit(main())

