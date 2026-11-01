#!/usr/bin/env python3
"""Undo the over-eager package rename (it also hit Java keywords)."""
import os, re

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

pat = re.compile(r'gg_([a-g])')
fixed = 0
for dirpath, _d, names in os.walk(SRC):
    for n in names:
        if not n.endswith('.java'):
            continue
        p = os.path.join(dirpath, n)
        out = []
        changed = False
        for line in open(p, encoding='utf-8').read().split('\n'):
            stripped = line.strip()
            if stripped.startswith('package ') or stripped.startswith('import '):
                out.append(line)
                continue
            def repl(m):
                global changed
                end = m.end()
                if end < len(line) and line[end] == '.':
                    return m.group(0)
                changed = True
                return m.group(1)
            out.append(pat.sub(repl, line))
        if changed:
            open(p, 'w', encoding='utf-8').write('\n'.join(out))
            fixed += 1
print('reverted corruption in %d files' % fixed)
