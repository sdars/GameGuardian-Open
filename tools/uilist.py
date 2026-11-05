#!/usr/bin/env python3
"""Print the texts of the last ui dumps of one tag.

    python3 tools/uilist.py <tag> [count]
"""
import glob
import os
import re
import sys

ROOT = '/root/gameguardian'
tag = sys.argv[1] if len(sys.argv) > 1 else 'rel'
count = int(sys.argv[2]) if len(sys.argv) > 2 else 2

files = sorted(glob.glob(os.path.join(ROOT, 'build/flow/ui_%s_*.xml' % tag)),
               key=os.path.getmtime)
for f in files[-count:] if count else files:
    data = open(f, encoding='utf-8', errors='replace').read()
    texts = [t for t in re.findall(r'text="([^"]*)"', data) if t.strip()]
    print('%s (%d bytes)' % (os.path.basename(f), len(data)))
    if len(sys.argv) > 3:
        first = next((t for t in texts if t.startswith('[')), '(no list)')
        print('    first: %s' % first.replace(chr(10), ' ')[:60])
    else:
        for t in texts:
            print('   ', t)
