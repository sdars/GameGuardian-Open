#!/usr/bin/env python3
"""Print the structure of one method of one class.

    python3 tools/repair/analyze_method.py android/ext/m.java g
"""
import os
import re
import sys
import collections

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import java_lexer as JL  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))


def method_body(src, name):
    dm = JL.depth_map(src)
    offs = JL.line_offsets(src)
    for i, l in enumerate(src.split(chr(10))):
        if re.search(r'\b' + re.escape(name) + r'\s*\(', l):
            bo = src.index('{', offs[i])
            be = JL.find_matching(src, bo, dm)
            return bo, be, dm
    return None


def main():
    path = os.path.join(ROOT, 'app', 'src', 'main', 'java', sys.argv[1])
    name = sys.argv[2]
    src = open(path, encoding='utf-8').read()
    bo, be, dm = method_body(src, name)
    body = src[bo + 1:be]
    bdm = JL.depth_map(body)
    blines = body.split(chr(10))
    starts = []
    s = 0
    for l in blines:
        starts.append(s)
        s += len(l) + 1
    depths = [bdm[so] if so < len(bdm) else 1 for so in starts]
    print('body lines %d, chars %d' % (len(blines), len(body)))

    decl = re.compile(r'^\s*(?:final\s+)?([A-Za-z_$][\w.$]*(?:<[^>]*>)?(?:\[\])*)\s+'
                      r'([A-Za-z_$][\w$]*)\s*(=[^;]*)?;\s*$')
    cnt = collections.Counter()
    special = []
    for idx, l in enumerate(blines):
        st = l.strip()
        if st.startswith('for (') or st.startswith('catch (') or st.startswith('} catch'):
            special.append((idx + 1, st[:70]))
            continue
        m = decl.match(l)
        if m:
            cnt[m.group(2)] += 1
    dups = [(k, v) for k, v in cnt.items() if v > 1]
    print('declared names: %d, duplicated: %d' % (len(cnt), len(dups)))
    for k, v in sorted(dups):
        print('  DUP %s x%d' % (k, v))
    for ln, st in special:
        print('  SPECIAL line %d: %s' % (ln, st))

    sw = collections.Counter()
    cur = None
    for idx, l in enumerate(blines):
        st = l.strip()
        if st.startswith('switch ('):
            cur = idx + 1
            sw[cur] = 0
        if st.startswith('case ') and cur:
            sw[cur] += 1
    print('switches: %d, cases %d' % (len(sw), sum(sw.values())))

    br = collections.Counter()
    for idx, l in enumerate(blines):
        st = l.strip()
        if st.startswith('break'):
            br['break'] += 1
        if st.startswith('continue'):
            br['continue'] += 1
        if st.startswith('return'):
            br['return'] += 1
    print('statements: %r' % dict(br))


if __name__ == '__main__':
    main()
