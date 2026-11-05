#!/usr/bin/env python3
"""Remove the files that a broken shell quoting left in the tree."""
import os

ROOT = '/root/gameguardian'

for name in sorted(os.listdir(ROOT)):
    if name.startswith(' ') or name.startswith(chr(92)):
        path = os.path.join(ROOT, name)
        if os.path.isfile(path):
            print('removing %r' % name)
            os.unlink(path)
