#!/usr/bin/env python3
"""Compare the *effects* of every method of our dex with the original dex.

The interesting part of a method is what it touches: the methods it calls,
the fields it reads and writes, the strings it uses and the constants it
compares against.  Register allocation and the order of the instructions
are the business of the compiler, the effects are not, so a method whose
effect list differs is a translation error.

    python3 tools/verify/sem_effects.py <ours-smali-dir> <orig-smali-dir> [class-filter]
"""
import collections
import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import smali_semdiff as S  # noqa: E402

EFFECT_RE = re.compile(r'^(invoke|iget|iput|sget|sput|const-string|const)\b')
REG_RE = re.compile(r'^[vp]\d+$')


def effects(body):
    out = collections.Counter()
    for insn in body:
        if not EFFECT_RE.match(insn):
            continue
        op = insn.split(' ', 1)[0]
        rest = insn[len(op):].strip()
        parts = [p.strip() for p in rest.split(',')]
        keep = []
        for p in parts:
            if REG_RE.fullmatch(p) or p.startswith('{') or p.startswith(':L'):
                continue
            keep.append(p)
        out[op + ' ' + ','.join(keep)] += 1
    return out


def main():
    ours = S.load_tree(sys.argv[1])
    orig = S.load_tree(sys.argv[2])
    filt = sys.argv[3] if len(sys.argv) > 3 else ''
    bad = []
    checked = 0
    for cls, methods in sorted(orig.items()):
        if filt and filt not in cls:
            continue
        if cls not in ours:
            continue
        om = ours[cls]
        for sig, body in methods.items():
            if sig not in om:
                continue
            checked += 1
            a = effects(body)
            b = effects(om[sig])
            if a != b:
                delta = (a - b) + (b - a)
                bad.append((cls, sig, delta))
    print('methods compared: %d   different effects: %d' % (checked, len(bad)))
    for cls, sig, delta in bad:
        print('  %-44s %-46s %s' % (cls, sig, list(delta.elements())[:8]))
    return 0


if __name__ == '__main__':
    sys.exit(main())
