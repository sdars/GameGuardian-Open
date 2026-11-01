#!/usr/bin/env python3
"""Rename the obfuscated helper packages a..g to gg_a..gg_g.

The obfuscator emitted packages a..g whose classes are *also* named a..g, so in
every file that lives in one of those packages the simple package name is
shadowed by a class of the same name - "a.e" can never be resolved there and
neither can an import.  Renaming the packages removes the ambiguity for good.

Run once; idempotent (already renamed packages are skipped).
"""
import os, re, shutil, sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')
MAP = {p: 'gg_' + p for p in 'abcdefg'}

for old, new in MAP.items():
    src = os.path.join(SRC, old)
    dst = os.path.join(SRC, new)
    if not os.path.isdir(src):
        continue
    if os.path.isdir(dst):
        print('skip (already renamed):', old)
        continue
    os.makedirs(dst)
    n = 0
    for name in os.listdir(src):
        shutil.move(os.path.join(src, name), os.path.join(dst, name))
        if name.endswith('.java'):
            p = os.path.join(dst, name)
            s = open(p, encoding='utf-8').read()
            s2 = re.sub(r'^package %s;$' % old, 'package %s;' % new, s, count=1, flags=re.M)
            if s2 != s:
                open(p, 'w', encoding='utf-8').write(s2)
            n += 1
    os.rmdir(src)
    print('renamed package %s -> %s (%d files)' % (old, new, n))
print('done')
