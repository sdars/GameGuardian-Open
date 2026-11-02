#!/usr/bin/env python3
"""Regenerate a whole class from the ground truth smali of the original dex.

jadx occasionally mis-decompiles a method (merged branches, inverted
conditions).  Instead of hand-fixing every such method, this script
replaces *all* methods of a class with a mechanical translation of the dex
code, which is faithful by construction.

    python3 tools/repair/regen_class.py <smali> <java-file> [--skip a,b,c]
"""

import os
import re
import sys
import traceback

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import overlay_smali as O  # noqa: E402
import smali_to_java as S  # noqa: E402
from java_clean import drop_generated  # noqa: E402
from fix_method import java_method_bounds, rewrite_all  # noqa: E402
from fix_method import java_class_name, java_signature  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))


def smali_methods(path):
    out = []
    with open(path, encoding='utf-8', errors='replace') as fh:
        for line in fh:
            s = line.strip()
            if not s.startswith('.method'):
                continue
            bits = s[len('.method'):].strip().split()
            sig = bits[-1]
            out.append((sig[:sig.index('(')], sig, ' '.join(bits[:-1])))
    return out


def main(argv):
    if len(argv) < 3:
        print(__doc__)
        return 2
    smali_rel, java_rel = argv[1], argv[2]
    skip = set()
    for a in argv[3:]:
        if a.startswith('--skip='):
            skip |= set(x for x in a.split('=', 1)[1].split(',') if x)
    smali_path = os.path.join(ROOT, smali_rel)
    java_path = os.path.join(ROOT, java_rel)
    memmap = O.load_map()

    header = ''
    with open(smali_path, encoding='utf-8', errors='replace') as fh:
        for line in fh:
            if line.startswith('.class'):
                header = line
                break
    tmpdir = os.path.join(ROOT, 'build', 'fixmethod')
    os.makedirs(tmpdir, exist_ok=True)

    with open(java_path, encoding='utf-8') as fh:
        lines = fh.read().split('\n')
    cname = java_class_name(lines)

    done = 0
    skipped = []
    for name, sig, access in smali_methods(smali_path):
        if name in skip or name in ('<init>', '<clinit>'):
            skipped.append(name)
            continue
        if 'abstract' in access or 'native' in access:
            skipped.append(name)
            continue
        prefix = 'xm_' + re.sub(r'[^A-Za-z0-9_]', '_', name)
        lines = drop_generated(lines, prefix)
        try:
            start, end = java_method_bounds(lines, name, skip=cname)
        except SystemExit:
            skipped.append(name)
            continue
        java_sig = java_signature(lines[start])
        block = O.extract_method(smali_path, sig)
        tmp = os.path.join(tmpdir, prefix + '.smali')
        with open(tmp, 'w', encoding='utf-8') as fh:
            fh.write(rewrite_all(header + block, memmap))
        rewritten_sig = rewrite_all(sig, memmap)
        try:
            m = S.parse(tmp, rewritten_sig)
        except SystemExit as exc:
            print('  SKIP %s (%s)' % (name, exc))
            skipped.append(name)
            continue
        gen = S.Generator(m, prefix, [], 'int', 'static' in m.access, chunk_size=600)
        _prefix, _name, params = S.parse_java_sig(java_sig)
        try:
            body = gen.generate(java_sig, params)
        except Exception as exc:
            print('  FAIL %s (%s) java_sig=%r params=%r: %s'
                  % (name, sig, java_sig, params, exc))
            traceback.print_exc()
            skipped.append(name)
            continue
        lines = lines[:start] + body + lines[end + 1:]
        done += 1

    with open(java_path, 'w', encoding='utf-8') as fh:
        fh.write('\n'.join(lines))
    print('%s: regenerated %d methods, skipped %d' % (java_rel, done, len(skipped)))
    if skipped:
        print('  skipped: %s' % ', '.join(sorted(set(skipped))))
    return 0


if __name__ == '__main__':
    sys.exit(main(sys.argv))
