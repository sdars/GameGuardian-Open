#!/usr/bin/env python3
# Print a unified diff of the normalised instruction stream of one method.
#
#     python3 tools/verify/detail.py <ours-smali-dir> <orig-smali-dir> <class> <method-name>
import difflib
import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import smali_semdiff as S  # noqa: E402


def find(tree, cls, name):
    methods = tree.get(cls, {})
    out = {}
    for sig, body in methods.items():
        s2 = sig[len('.method '):] if sig.startswith('.method ') else sig
        if s2.rstrip('V').startswith(name + '(') or s2 == name:
            out[sig] = body
    return out


def main():
    ours = S.load_tree(sys.argv[1])
    orig = S.load_tree(sys.argv[2])
    cls = sys.argv[3].replace('/', os.sep)
    name = sys.argv[4]
    o = find(orig, cls, name)
    n = find(ours, cls, name)
    if not o:
        print('original method not found:', cls, name)
        return 1
    if not n:
        print('our method not found:', cls, name)
        return 1
    for sig in sorted(o):
        if sig not in n:
            print('signature missing in ours:', sig)
            continue
        print('=== %s %s ===' % (cls, sig))
        d = list(difflib.unified_diff(o[sig], n[sig], 'original', 'ours', lineterm='', n=3))
        if not d:
            print('    identical')
        else:
            print('\n'.join(d))
    return 0


if __name__ == '__main__':
    sys.exit(main())
