#!/usr/bin/env python3
# Control flow graph comparison of two dalvik method bodies.
#
# The linear instruction stream of two dex files never matches: the register
# allocation and the block order are the compilers business, not the
# programs.  What has to match is the control flow graph and the operation
# that every block performs.  This tool therefore
#
#   * splits a method into basic blocks,
#   * normalises the registers away,
#   * computes a canonical label for every block with a Weisfeiler-Lehman
#     style refinement over the block graph,
#   * compares the resulting multiset of block labels.
#
# A method whose blocks have the same labels is equivalent to its
# counterpart up to register allocation and block order.

#     python3 tools/verify/smali_cfgdiff.py <ours-smali-dir> <orig-smali-dir>

import hashlib
import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import smali_semdiff as S  # noqa: E402


TERMINATORS = ('goto', 'return', 'throw', 'if-', 'switch', 'packed-switch',
               'sparse-switch')

CATCH_RE = re.compile(r'^\.catch\s+(\S+)\s*\{\s*(:\S+)\s+\.\.\s+(:\S+)\s*\}\s*(:\S+)')


class Method:
    def __init__(self):
        self.insns = []       # list of (op, rest)
        self.labels = {}      # label -> instruction index
        self.catches = []     # (start, end, handler) instruction indexes


def parse_method(lines):
    m = Method()
    index = {}
    for raw in lines:
        s = raw.strip()
        if not s:
            continue
        if s.startswith(':') and not s.startswith(':pswitch'):
            name = s.split()[0]
            index[name] = len(m.insns)
            m.labels[name] = len(m.insns)
            continue
        if s.startswith('.catch '):
            cm = CATCH_RE.match(s)
            if cm:
                m.catches.append((cm.group(2), cm.group(3), cm.group(4)))
            continue
        if s.startswith(':'):
            continue
        if s.startswith('.'):
            continue
        mm = S.INSN_RE.match(s)
        if not mm:
            continue
        m.insns.append((mm.group(1), mm.group(2)))
    return m


def is_term(op):
    for t in TERMINATORS:
        if op == t or op.startswith(t):
            return True
    return False


def branch_targets(op, rest, labels):
    out = []
    for part in rest.split(','):
        part = part.strip()
        if part.startswith(':'):
            out.append(part)
    return out


def build_cfg(method):
    insns = method.insns
    n = len(insns)
    if n == 0:
        return None
    # block start indexes
    starts = set(method.labels.values())
    for i, (op, _rest) in enumerate(insns):
        if is_term(op) and i + 1 < n:
            starts.add(i + 1)
    starts.add(0)
    starts = sorted(s for s in starts if 0 <= s < n)
    block_of = {}
    for bi, s in enumerate(starts):
        e = starts[bi + 1] if bi + 1 < len(starts) else n
        for i in range(s, e):
            block_of[i] = bi
    blocks = []
    for bi, s in enumerate(starts):
        e = starts[bi + 1] if bi + 1 < len(starts) else n
        body = []
        for i in range(s, e):
            op, rest = insns[i]
            if op == 'nop':
                continue
            body.append(S.norm_insn(op, rest))
        blocks.append(body)
    edges = set()
    for bi, s in enumerate(starts):
        e = starts[bi + 1] if bi + 1 < len(starts) else n
        last = None
        for i in range(s, e):
            op, rest = insns[i]
            if is_term(op):
                last = (i, op, rest)
        if last is None:
            if bi + 1 < len(starts):
                edges.add((bi, bi + 1))
            continue
        i, op, rest = last
        tgts = branch_targets(op, rest, method.labels)
        if op.startswith('if-') and len(tgts) == 1:
            tgt = method.labels.get(tgts[0])
            if tgt is not None:
                edges.add((bi, block_of.get(tgt, -1)))
            edges.add((bi, bi + 1) if bi + 1 < len(starts) else (bi, bi))
        elif op.startswith('goto') and len(tgts) == 1:
            tgt = method.labels.get(tgts[0])
            if tgt is not None:
                edges.add((bi, block_of.get(tgt, -1)))
        elif op in ('return', 'throw'):
            pass
        else:
            for t in tgts:
                tgt = method.labels.get(t)
                if tgt is not None:
                    edges.add((bi, block_of.get(tgt, -1)))
    # exception handlers: every block that overlaps the protected range
    for start, end, handler in method.catches:
        si = method.labels.get(start)
        ei = method.labels.get(end)
        hi = method.labels.get(handler)
        if si is None or ei is None or hi is None:
            continue
        hb = block_of.get(hi, -1)
        for i in range(si, min(ei, n) + 1):
            b = block_of.get(i)
            if b is not None and b >= 0:
                edges.add((b, hb))
    return blocks, sorted(edges)


def canonical(blocks, edges, rounds=6):
    succ = defaultdict(list)
    for a, b in edges:
        succ[a].append(b)
    labels = []
    for b in blocks:
        h = hashlib.sha1(('|'.join(b)).encode('utf-8')).hexdigest()
        labels.append(h)
    for _ in range(rounds):
        new = []
        for i, b in enumerate(blocks):
            h = hashlib.sha1((labels[i] + '#' + ','.join(sorted(labels[s] for s in succ[i]))).encode('utf-8')).hexdigest()
            new.append(h)
        labels = new
    return sorted(labels)


def main():
    if len(sys.argv) < 3:
        print('usage: smali_cfgdiff.py <ours-smali-dir> <orig-smali-dir>')
        return 2
    ours_root, orig_root = sys.argv[1], sys.argv[2]
    ours = load_methods(ours_root)
    orig = load_methods(orig_root)
    diffs = []
    checked = 0
    for cls, methods in sorted(orig.items()):
        if cls not in ours:
            continue
        om = ours[cls]
        for sig, lines in methods.items():
            if sig not in om:
                continue
            checked += 1
            a = cfg_hash(lines)
            b = cfg_hash(om[sig])
            if a is None or b is None:
                continue
            if a != b:
                diffs.append((cls, sig))
    print('methods compared: %d   control flow differing: %d' % (checked, len(diffs)))
    for cls, sig in diffs:
        print('  %-42s %s' % (cls, sig))
    return 0


def cfg_hash(lines):
    m = parse_method(lines)
    cfg = build_cfg(m)
    if cfg is None:
        return None
    blocks, edges = cfg
    return canonical(blocks, edges)


def load_methods(root):
    tree = {}
    for dirpath, _dirs, files in os.walk(root):
        for name in files:
            if not name.endswith('.smali'):
                continue
            path = os.path.join(dirpath, name)
            rel = os.path.relpath(path, root)[:-len('.smali')]
            rel = re.sub(r'(^|/)gg_([a-g])(/|$)',
                        lambda m: m.group(1) + m.group(2) + m.group(3), rel)
            tree[rel] = read_methods(path)
    return tree


def read_methods(path):
    methods = {}
    cur = None
    body = []
    with open(path, 'r', encoding='utf-8', errors='replace') as fh:
        for raw in fh:
            s = raw.strip()
            if s.startswith('.method '):
                mm = S.METHOD_RE.match(s)
                cur = mm.group(2) if mm else s
                body = []
                continue
            if s.startswith('.end method'):
                if cur is not None:
                    methods[cur] = body
                cur = None
                body = []
                continue
            if cur is not None:
                body.append(raw.rstrip('\n'))
    return methods


from collections import defaultdict  # noqa: E402


if __name__ == '__main__':
    sys.exit(main())
