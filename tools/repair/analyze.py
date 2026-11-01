#!/usr/bin/env python3
"""Parse javac output into structured errors (file, line, col, kind, detail)."""
import re, sys, collections

ERR = re.compile(r'^(?P<file>[^:]+\.java):(?P<line>\d+): error: (?P<msg>.*)$')

def parse(path):
    errs = []
    lines = open(path, encoding='utf-8', errors='replace').read().split('\n')
    i = 0
    while i < len(lines):
        m = ERR.match(lines[i])
        if not m:
            i += 1
            continue
        e = dict(file=m.group('file'), line=int(m.group('line')), msg=m.group('msg'), col=None,
                 symbol=None, loc=None, src='')
        # source line + caret
        if i + 2 < len(lines) and lines[i + 1].strip() and '^' in lines[i + 2]:
            e['src'] = lines[i + 1]
            e['col'] = lines[i + 2].index('^') + 1
        j = i + 3
        while j < len(lines):
            l = lines[j]
            if ERR.match(l):
                break
            ms = re.match(r'\s*symbol:\s+(.*)$', l)
            ml = re.match(r'\s*location:\s+(.*)$', l)
            if ms: e['symbol'] = ms.group(1).strip()
            if ml: e['loc'] = ml.group(1).strip()
            j += 1
        errs.append(e)
        i = j
    return errs

if __name__ == '__main__':
    errs = parse(sys.argv[1] if len(sys.argv) > 1 else '/tmp/ggjc_err.log')
    print('total errors:', len(errs))
    c = collections.Counter(e['msg'].split(':')[0] for e in errs)
    for k, v in c.most_common():
        print(f'{v:6d}  {k}')
    print('\n--- sample per kind ---')
    seen = set()
    for e in errs:
        k = e['msg'].split(':')[0]
        if k in seen: continue
        seen.add(k)
        print(f"[{e['file']}:{e['line']}:{e['col']}] {e['msg']}")
        if e['symbol']: print('   symbol:', e['symbol'], '| location:', e['loc'])
        if e['src']: print('   src:', e['src'].strip()[:160])
        print('   caret:', ' ' * ((e['col'] or 1) - 1) + '^')
