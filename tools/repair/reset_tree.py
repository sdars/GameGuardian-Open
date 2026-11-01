#!/usr/bin/env python3
"""Reset app/src/main/java from the pristine jadx output.

The R classes jadx emits are kept out of the tree on purpose: the Android
Gradle Plugin generates the real ones from app/src/main/res, and shipping a
second copy would produce "duplicate class" errors.  The jadx copies live in
tools/stubs/java and are only used by the javac based verification script.
"""
import os
import shutil

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'analysis', '2026-11-01', 'decompilers', 'jadx-final', 'sources')
DST = os.path.join(ROOT, 'app', 'src', 'main', 'java')

for name in sorted(os.listdir(DST)):
    p = os.path.join(DST, name)
    if os.path.isdir(p):
        shutil.rmtree(p)
    else:
        os.remove(p)

n = 0
for dirpath, _dirs, names in os.walk(SRC):
    for nm in names:
        if not nm.endswith('.java'):
            continue
        rel = os.path.relpath(os.path.join(dirpath, nm), SRC)
        if rel.startswith('catch_/me_/if_/you_/can_/R'):
            continue
        out = os.path.join(DST, rel)
        os.makedirs(os.path.dirname(out), exist_ok=True)
        shutil.copy2(os.path.join(dirpath, nm), out)
        n += 1
print('reset: %d source files restored from jadx-final' % n)
