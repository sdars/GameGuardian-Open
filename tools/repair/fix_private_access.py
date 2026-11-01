#!/usr/bin/env python3
"""Restore the access the dex actually had.

jadx flattens every nested class into a file of its own, so a class that was
an inner class of another one is no longer nested and Java's "private is
class scoped" rule kicks in: "f1079a has private access in n".

The dex does not care - the original bytecode was produced by a compiler that
allowed the inner class to reach the outer class' private members.  The repair
widens those members to the smallest access that still compiles:

  * same package  -> package private (the modifier is simply dropped)
  * other package -> public
"""
import os
import re

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')
ERRLOG = os.environ.get('GG_ERRLOG', '/tmp/ggjc_err.log')

ERR_RE = re.compile(r'^(\w+)(?:\(([^)]*)\))? has private access in (\S+)$')


def index():
    out = {}
    for dirpath, _d, names in os.walk(SRC):
        for n in names:
            if n.endswith('.java'):
                out.setdefault(n[:-5], os.path.join(dirpath, n))
    return out


def main():
    idx = index()
    if not os.path.exists(ERRLOG):
        return
    hits = {}
    for line in open(ERRLOG, encoding='utf-8', errors='replace'):
        if ' error: ' not in line:
            continue
        m = ERR_RE.match(line.split(' error: ', 1)[1].strip())
        if not m:
            continue
        name, _args, owner = m.group(1), m.group(2), m.group(3)
        path = idx.get(owner)
        if path is None:
            continue
        hits.setdefault(path, set()).add(name)
    n = 0
    for path, names in hits.items():
        text = open(path, encoding='utf-8').read()
        orig = text
        for name in names:
            # field declaration
            text = re.sub(r'(?m)^(\s*)private\s+'
                           r'((?:final\s+|static\s+|volatile\s+|transient\s+)*)'
                           r'([\w.$<>\[\]]+(?:\[\])?)\s+' +
                           re.escape(name) + r'\b',
                           r'\1\2\3 ' + name, text)
            # method declaration
            text = re.sub(r'(?m)^(\s*)private\s+'
                           r'((?:final\s+|static\s+|synchronized\s+|native\s+|abstract\s+)*)'
                           r'([\w.$<>\[\]]+)\s+' +
                           re.escape(name) + r'\s*\(',
                           r'\1\2\3 ' + name + '(', text)
        if text != orig:
            open(path, 'w', encoding='utf-8').write(text)
            n += 1
            print('widened access in', os.path.relpath(path, ROOT),
                  sorted(names))
    print('files changed:', n)


if __name__ == '__main__':
    main()
