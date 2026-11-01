#!/usr/bin/env python3
"""Summarise the current javac diagnostics grouped by kind."""
import re
import sys
import collections

ERRLOG = '/tmp/ggjc_err.log'
cache = {}


def get(f, l):
    if f not in cache:
        cache[f] = open(f, encoding='utf-8', errors='replace').read().split('\n')
    return cache[f][l - 1].strip()


def kind(msg):
    if msg.startswith('unreported'):
        return 'unreported'
    if 'never thrown in body' in msg:
        return 'neverthrown'
    if msg == 'unreachable statement':
        return 'unreachable'
    if msg.startswith('incompatible'):
        return 'incompat'
    if msg == 'missing return statement':
        return 'missingret'
    if 'might not have been initialized' in msg:
        return 'maybeinit'
    if 'might already have been assigned' in msg:
        return 'assigned'
    if msg.startswith('cannot assign'):
        return 'finalassign'
    return msg


def main():
    groups = collections.defaultdict(list)
    for line in open(ERRLOG, encoding='utf-8', errors='replace'):
        m = re.match(r'^(?P<f>.+?):(?P<l>\d+): error: (?P<msg>.*)$', line.rstrip())
        if not m:
            continue
        groups[kind(m.group('msg'))].append((m.group('f'), int(m.group('l')), m.group('msg')))
    only = sys.argv[1] if len(sys.argv) > 1 else None
    for k, v in groups.items():
        if only and k != only:
            continue
        print('=' * 15, k, len(v))
        seen = set()
        for f, l, msg in v:
            try:
                s = get(f, l)
            except Exception:
                s = '<n/a>'
            kk = re.sub(r'\s+', ' ', s)[:80]
            if kk in seen:
                continue
            seen.add(kk)
            if len(seen) > 10:
                break
            print('  ', f.split('/java/')[-1], l, '|', s[:140])


if __name__ == '__main__':
    main()

