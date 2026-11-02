#!/usr/bin/env python3
# Compare the instruction multiset of every method of our dex with the
# original dex.  The order of the instructions is the compilers business, but
# the instructions themselves are not: a method that uses another operation,
# another constant or another reference is a translation error.
#
#     python3 tools/verify/smali_multiset.py <ours-smali-dir> <orig-smali-dir>

import collections
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import smali_semdiff as S  # noqa: E402


def main():
    if len(sys.argv) < 3:
        print('usage: smali_multiset.py <ours-smali-dir> <orig-smali-dir>')
        return 2
    ours = S.load_tree(sys.argv[1])
    orig = S.load_tree(sys.argv[2])
    bad = []
    checked = 0
    for cls, methods in sorted(orig.items()):
        if cls not in ours:
            continue
        om = ours[cls]
        for sig, body in methods.items():
            if sig not in om:
                continue
            checked += 1
            a = collections.Counter(body)
            b = collections.Counter(om[sig])
            if a != b:
                delta = (a - b) + (b - a)
                heavy = sum(1 for k in delta if not k[0].startswith(('if', 'goto', 'return', 'move-exception')))
                bad.append((cls, sig, len(delta), heavy, delta))
    print('methods compared: %d   different multiset: %d' % (checked, len(bad)))
    bad.sort(key=lambda x: (-x[3], -x[2]))
    for cls, sig, n, heavy, delta in bad:
        print('  %-40s %-44s delta=%d heavy=%d' % (cls, sig, n, heavy))
    return 0


if __name__ == '__main__':
    sys.exit(main())
