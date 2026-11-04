#!/usr/bin/env python3
# Compare the constants of every method of our dex with the original dex.
#
#     python3 tools/verify/const_diff.py <ours-smali-dir> <orig-smali-dir>
#
# The instruction order of a method is the business of the compiler, but the
# constants it uses are not: a port that replaced a register by a literal
# (a process id that became 0, a mask that became 0xffffffff) produces the
# same shape of code with a different behaviour.  This tool prints every
# method whose sequence of constant operands differs.
import os
import re
import sys
from collections import Counter

METHOD_RE = re.compile(r'^\.method\s+(.*?)\s+(\S+)$')
CONST_RE = re.compile(r'^(const(?:/4|/16|/32|/high16|-wide(?:/16|/32)?)?|sconst(?:/4|/16)?)\s+(.+)$')


def consts(root):
    tree = {}
    for dirpath, _dirs, files in os.walk(root):
        for name in files:
            if not name.endswith('.smali'):
                continue
            path = os.path.join(dirpath, name)
            rel = os.path.relpath(path, root)[:-len('.smali')]
            rel = re.sub(r'(^|/)gg_([a-g])(/|$)',
                        lambda m: m.group(1) + m.group(2) + m.group(3), rel)
            cur = None
            body = []
            with open(path, 'r', encoding='utf-8', errors='replace') as fh:
                for raw in fh:
                    s = raw.strip()
                    if s.startswith('.method '):
                        m = METHOD_RE.match(s)
                        cur = m.group(2) if m else s
                        body = []
                        continue
                    if s.startswith('.end method'):
                        if cur is not None:
                            tree.setdefault(rel, {})[cur] = body
                        cur = None
                        continue
                    if cur is None:
                        continue
                    m = CONST_RE.match(s)
                    if not m:
                        continue
                    op, rest = m.group(1), m.group(2)
                    rest = rest.split(',')
                    if len(rest) > 1:
                        rest = rest[1:]
                    body.append(op + ' ' + ' '.join(x.strip() for x in rest))
    return tree


def main():
    if len(sys.argv) < 3:
        sys.exit('usage: const_diff.py <ours-smali-dir> <orig-smali-dir>')
    ours = consts(sys.argv[1])
    orig = consts(sys.argv[2])
    diffs = []
    checked = 0
    for cls, methods in sorted(orig.items()):
        if cls not in ours:
            continue
        for sig, body in methods.items():
            if sig not in ours[cls]:
                continue
            checked += 1
            if Counter(body) == Counter(ours[cls][sig]):
                continue
            only_orig = Counter(body) - Counter(ours[cls][sig])
            only_ours = Counter(ours[cls][sig]) - Counter(body)
            diffs.append((cls, sig, body, ours[cls][sig]))
    print('methods compared: %d   different constants: %d' % (checked, len(diffs)))
    for cls, sig, obody, nbody in diffs:
        print('  %s %s' % (cls, sig))
        only_orig = Counter(obody) - Counter(nbody)
        only_ours = Counter(nbody) - Counter(obody)
        if only_orig:
            print('      only in original : %s' % (' | '.join('%s x%d' % (k, v)
                                                     for k, v in only_orig.items())))
        if only_ours:
            print('      only in ours     : %s' % (' | '.join('%s x%d' % (k, v)
                                                     for k, v in only_ours.items())))
    return 0


if __name__ == '__main__':
    sys.exit(main())
