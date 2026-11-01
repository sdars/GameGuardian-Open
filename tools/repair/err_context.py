#!/usr/bin/env python3
"""Print, for every javac diagnostic, the enclosing method and statement."""
import re
import sys
import collections

sys.path.insert(0, __file__.rsplit('/', 1)[0])
from fix_definite_assignment import mask, build_blocks   # noqa: E402

ERRLOG = '/tmp/ggjc_err.log'
cache = {}


def load(f):
    if f not in cache:
        cache[f] = open(f, encoding='utf-8', errors='replace').read()
    return cache[f]


def analyse(f):
    text = load(f)
    masked = mask(text)
    blocks = build_blocks(masked)
    offs = []
    pos = 0
    for ln in text.split('\n'):
        offs.append(pos)
        pos += len(ln) + 1

    def block_at(off):
        best = None
        for b in blocks:
            if b['open'] <= off and (b['close'] is None or off < b['close']):
                if best is None or b['open'] > best['open']:
                    best = b
        return best

    def scope_of(b):
        while b is not None:
            if b['scope']:
                return b
            b = b['parent']
        return None
    return text, masked, offs, block_at, scope_of


def main():
    want = sys.argv[1] if len(sys.argv) > 1 else 'unreported'
    seen = set()
    for line in open(ERRLOG, encoding='utf-8', errors='replace'):
        m = re.match(r'^(?P<f>.+?):(?P<l>\d+): error: (?P<msg>.*)$', line.rstrip())
        if not m:
            continue
        msg = m.group('msg')
        if want == 'unreported' and not msg.startswith('unreported'):
            continue
        if want == 'unreachable' and msg != 'unreachable statement':
            continue
        f, l = m.group('f'), int(m.group('l'))
        text, masked, offs, block_at, scope_of = analyse(f)
        off = offs[l - 1]
        b = block_at(off)
        sc = scope_of(b)
        if sc is None:
            sig = '<no scope>'
        else:
            sig = text[max(0, sc['open'] - 300):sc['open']].strip().split('\n')[-1].strip()
        # statement text
        st = off
        while st > 0 and masked[st - 1] not in ';{}':
            st -= 1
        en = masked.find(';', off)
        stmt = text[st:en].strip()
        key = (sig[:60], re.sub(r'\s+', ' ', stmt)[:60])
        if key in seen:
            continue
        seen.add(key)
        print('---', f.split('/java/')[-1], l)
        print('   sig :', sig[:150])
        print('   stmt:', stmt[:150])


if __name__ == '__main__':
    main()

