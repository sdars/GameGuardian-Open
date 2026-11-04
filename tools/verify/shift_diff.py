#!/usr/bin/env python3
"""Find classes where our java port uses a 32 bit shift where the original
dex used a 64 bit one (or the other way round).

Java masks the shift distance of an int shift to five bits, so ``1 << 32``
is 1 and not 0x100000000.  Whenever the original dex used ``shl-long`` and
the java port collapsed to ``shl-int`` the produced constant is wrong and the
value it is applied to silently becomes 0.

    python3 tools/verify/shift_diff.py <ours-smali-dir> <orig-smali-dir>
"""
import os
import re
import sys

SHIFT_RE = re.compile(r'^\s+(shl|shr)-(int|long)')


def counts(root):
    out = {}
    for dirpath, _dirs, files in os.walk(root):
        for name in files:
            if not name.endswith('.smali'):
                continue
            path = os.path.join(dirpath, name)
            cls = os.path.relpath(path, root)[:-len('.smali')]
            n_int = n_long = 0
            with open(path, 'r', encoding='utf-8', errors='replace') as fh:
                for line in fh:
                    m = SHIFT_RE.match(line)
                    if not m:
                        continue
                    if m.group(2) == 'int':
                        n_int += 1
                    else:
                        n_long += 1
            out[cls] = (n_int, n_long)
    return out


def main():
    ours = counts(sys.argv[1])
    orig = counts(sys.argv[2])
    bad = 0
    for cls in sorted(set(ours) | set(orig)):
        o = orig.get(cls)
        n = ours.get(cls)
        if o is None or n is None:
            if o != n:
                print('%-60s only in one tree  orig=%s ours=%s' % (cls, o, n))
                bad += 1
            continue
        if o != n:
            print('%-60s orig int=%d long=%d | ours int=%d long=%d' % (cls, o[0], o[1], n[0], n[1]))
            bad += 1
    print('---')
    print('classes with a differing shift mix: %d' % bad)
    return 0


if __name__ == '__main__':
    sys.exit(main())
