#!/usr/bin/env python3
"""Print every node of a uiautomator dump with class / resource-id / text."""
import re
import sys

path = sys.argv[1]
data = open(path, encoding='utf-8').read()
for m in re.finditer(r'<node[^>]*>', data):
    s = m.group(0)

    def g(key):
        r = re.search(key + r'="([^"]*)"', s)
        return r.group(1) if r else ''

    print('%-26s %-34s %-18s %s' % (g('class'), g('resource-id'), g('text'), g('bounds')))
