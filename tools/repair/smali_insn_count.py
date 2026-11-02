import os
import re
import sys

root = sys.argv[1]
rows = []
for dirpath, _dirs, files in os.walk(root):
    for fn in files:
        if not fn.endswith('.smali'):
            continue
        path = os.path.join(dirpath, fn)
        cls = os.path.relpath(path, root)[:-len('.smali')].replace(os.sep, '.')
        cur = None
        count = 0
        for line in open(path, encoding='utf-8', errors='replace'):
            s = line.strip()
            if s.startswith('.method'):
                if cur is not None:
                    rows.append((count, cls, cur))
                cur = s
                count = 0
            elif s.startswith('.end method'):
                if cur is not None:
                    rows.append((count, cls, cur))
                cur = None
                count = 0
            elif cur is not None and s and not s.startswith('.'):
                count += 1
rows.sort(reverse=True)
for c, cls, sig in rows[:25]:
    print('%6d  %-40s %s' % (c, cls, sig[:90]))
