#!/usr/bin/env python3
"""Compare the shifts of every method of the reconstruction with the shifts
of the original dex.

Java masks the distance of an int shift to five bits, so ``1 << 32`` is 1
and not 0x100000000.  A port that loses the type of a shift therefore
computes a different constant - the value it is applied to silently becomes
0.  The comparison is per method and the shifts are listed in the order in
which they appear, so a swapped pair is found as well.

    python3 tools/verify/shift_methods.py <ours-smali-dir> <orig-smali-dir>
                              [--pkg-map old=new] [--rename-orig]
"""
import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import smali_semdiff as sd  # noqa: E402


SHIFT_RE = re.compile(r'^\s+(shl|shr|ushr)-(int|long)\b')
METHOD_RE = re.compile(r'^\.method\s+(.*?)\s+(\S+)$')


def shifts_of(path):
    out = {}
    cur = None
    with open(path, 'r', encoding='utf-8', errors='replace') as fh:
        for raw in fh:
            s = raw.strip()
            if s.startswith('.method '):
                m = METHOD_RE.match(s)
                cur = m.group(2) if m else s
                out[cur] = []
                continue
            if s.startswith('.end method'):
                cur = None
                continue
            if cur is None:
                continue
            m = SHIFT_RE.match(raw)
            if m:
                out[cur].append(m.group(1) + '-' + m.group(2))
    return out


def main():
    argv = sys.argv[1:]
    rename_orig = False
    if '--rename-orig' in argv:
        i = argv.index('--rename-orig')
        rename_orig = True
        argv = argv[:i] + argv[i + 1:]
    if '--pkg-map' in argv:
        i = argv.index('--pkg-map')
        old, _, new = argv[i + 1].partition('=')
        sd.PKG_MAP.append((old, new))
        argv = argv[:i] + argv[i + 2:]
    if len(argv) < 2:
        print(__doc__)
        return 2
    ours_root, orig_root = argv[0], argv[1]

    ours = {}
    for dirpath, _dirs, files in os.walk(ours_root):
        for name in files:
            if name.endswith('.smali'):
                path = os.path.join(dirpath, name)
                rel = os.path.relpath(path, ours_root)[:-len('.smali')]
                rel = sd.map_pkg(rel)
                ours[rel] = shifts_of(path)
    orig = {}
    for dirpath, _dirs, files in os.walk(orig_root):
        for name in files:
            if name.endswith('.smali'):
                path = os.path.join(dirpath, name)
                rel = os.path.relpath(path, orig_root)[:-len('.smali')]
                rel = sd.map_pkg(rel)
                table = sd.RENAMES.get('L' + rel + ';')
                rename = {v: k for k, v in table.items()} if (table and rename_orig) else None
                out = {}
                for sig, lst in shifts_of(path).items():
                    if rename:
                        j = sig.find('(')
                        if j > 0:
                            sig = rename.get(sig[:j], sig[:j]) + sig[j:]
                    out[sig] = lst
                orig[rel] = out

    diffs = 0
    for cls, methods in sorted(orig.items()):
        if cls not in ours:
            continue
        for sig, sh in methods.items():
            if not sh or sig not in ours[cls]:
                continue
            if ours[cls][sig] != sh:
                diffs += 1
                print('  %-44s %-40s orig %s | ours %s'
                      % (cls, sig, ','.join(sh), ','.join(ours[cls][sig])))
    print('methods with a differing shift sequence: %d' % diffs)
    return 0


if __name__ == '__main__':
    sys.exit(main())
