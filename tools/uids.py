#!/usr/bin/env python3
"""Print the resource ids and the clickable nodes of a ui dump.

    python3 tools/uids.py <file.xml>
"""
import re
import sys

data = open(sys.argv[1], encoding='utf-8', errors='replace').read()
for m in re.finditer(r'<node[^>]*>', data):
    n = m.group(0)
    rid = re.search(r'resource-id="([^"]*)"', n)
    txt = re.search(r'text="([^"]*)"', n)
    click = 'clickable="true"' in n
    bnd = re.search(r'bounds="([^"]*)"', n)
    label = (txt.group(1) if txt else '').replace(chr(10), ' ')[:40]
    print('%-40s %-6s %-42s %s' % (
        (rid.group(1) if rid else '').split('/')[-1],
        'CLICK' if click else '',
        label,
        bnd.group(1) if bnd else ''))
