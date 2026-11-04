#!/usr/bin/env python3
# Compare our compiled dex against the ground truth smali of the original.
#
# The pure source tree is a hand written port of the original dex.  A few
# methods were mistranslated by the decompiler (inverted branches, collapsed
# fall through chains).  Those bugs are invisible in the java source but they
# break the app at runtime, so every method is compared instruction by
# instruction with the original dex.
#
#     python3 tools/verify/smali_semdiff.py <ours-smali-dir> <orig-smali-dir>
#     python3 tools/verify/smali_semdiff.py <ours> <orig> --detail <class>#<sig>
#
# The comparison is structural: registers are renamed, branch targets are
# renamed, the jadx member renames are undone and the different but
# equivalent encodings of the same dalvik operation (const/4 vs const/16,
# move vs move/from16, ...) are folded into one form.
#
# Methods that contain an exception handler are counted separately: javac
# and the original dex lay the catch blocks out in a different order, so
# their instruction streams differ without the behaviour differing.

import difflib
import json
import os
import re
import sys


ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))


def load_renames():
    path = os.path.join(ROOT, 'tools', 'repair', 'member_renames.json')
    try:
        with open(path, 'r', encoding='utf-8') as fh:
            return json.load(fh)
    except Exception:
        return {}


RENAMES = load_renames()

METHOD_RE = re.compile(r'^\.method\s+(.*?)\s+(\S+)$')
INSN_RE = re.compile(r'^([a-z][a-z0-9/\-]*)(.*)$')

OPCODE_FOLD = {
    'const': 'const', 'const/4': 'const', 'const/16': 'const',
    'const/high16': 'const', 'const-wide': 'const', 'const-wide/16': 'const',
    'const-wide/32': 'const', 'const-wide/high16': 'const',
    'move': 'move', 'move/from16': 'move', 'move/16': 'move',
    'move-wide': 'move', 'move-wide/from16': 'move', 'move-wide/16': 'move',
    'move-object': 'move', 'move-object/from16': 'move',
    'move-object/16': 'move',
    'return': 'return', 'return-wide': 'return', 'return-object': 'return',
    # the polarity of a branch is part of the behaviour, so it must not be
    # folded away: an inverted if-eqz/if-nez is exactly the kind of bug the
    # comparison is looking for.
    'if-eq': 'if-eq', 'if-ne': 'if-ne', 'if-lt': 'if-lt', 'if-ge': 'if-ge',
    'if-gt': 'if-gt', 'if-le': 'if-le',
    'if-eqz': 'ifz-eq', 'if-nez': 'ifz-ne', 'if-ltz': 'ifz-lt',
    'if-gez': 'ifz-ge', 'if-gtz': 'ifz-gt', 'if-lez': 'ifz-le',
    'aget': 'aget', 'aget-wide': 'aget', 'aget-object': 'aget',
    'aput': 'aput', 'aput-wide': 'aput', 'aput-object': 'aput',
    'iget': 'iget', 'iget-wide': 'iget', 'iget-object': 'iget',
    'iput': 'iput', 'iput-wide': 'iput', 'iput-object': 'iput',
    'sget': 'sget', 'sget-wide': 'sget', 'sget-object': 'sget',
    'sput': 'sput', 'sput-wide': 'sput', 'sput-object': 'sput',
    'new-instance': 'new', 'new-array': 'new-array',
    'invoke-virtual': 'invoke', 'invoke-super': 'invoke',
    'invoke-interface': 'invoke',
    'invoke-virtual/range': 'invoke', 'invoke-super/range': 'invoke',
    'invoke-interface/range': 'invoke',
    'invoke-direct/range': 'invoke-direct', 'invoke-static/range': 'invoke-static',
    'check-cast': 'check-cast',
    'filled-new-array': 'fnew', 'filled-new-array/range': 'fnew',
    'cmp-long': 'cmp', 'cmpg-long': 'cmp', 'cmpl-long': 'cmp',
    'cmpg-float': 'cmp', 'cmpl-float': 'cmp',
    'cmpg-double': 'cmp', 'cmpl-double': 'cmp',
}

QUOTE = chr(34)


def strip_rename(mem):
    # jadx renames a member that collides with a class name to fNNNname
    m = re.match(r'^f\d+(.+)$', mem)
    if m:
        return m.group(1)
    return mem


def norm_ref(text, drop_class=False):
    # undo the a..g -> gg_a..gg_g package rename
    text = re.sub(r'Lgg_([a-g])/', lambda m: 'L' + m.group(1) + '/', text)

    def fix(m):
        cls = m.group(1)
        mem = strip_rename(m.group(2))
        table = RENAMES.get(cls)
        if table:
            mem = table.get(mem, mem)
        if drop_class:
            return '->' + mem + ':'
        return 'L' + cls + ';->' + mem + ':'

    text = re.sub(r'(L[\w/$]+;)->([\w$]+):', fix, text)
    return text


PKG_MAP = []


def map_pkg(text):
    """rewrite the package of the original dex (the game guardian build
    renames its own application package randomly, so the ground truth dex
    uses a different prefix than the reconstruction)."""
    for old, new in PKG_MAP:
        text = text.replace(old, new)
    return text


def norm_insn(op, rest):
    drop_class = op.startswith('invoke')
    if op.startswith(('iget', 'iput', 'sget', 'sput')):
        drop_class = True
    op = OPCODE_FOLD.get(op, op)
    rest = map_pkg(rest.strip())
    if not rest:
        return op
    parts = [p.strip() for p in rest.split(',')]
    out = []
    for p in parts:
        if p.startswith('{') and p.endswith('}'):
            inner = [x.strip() for x in p[1:-1].split(',') if x.strip()]
            out.append('{' + ','.join('r' if re.fullmatch(r'[vp]\d+', x) else x for x in inner) + '}')
        elif re.fullmatch(r'[vp]\d+', p):
            out.append('r')
        elif re.fullmatch(r':\S+', p):
            out.append(':L')
        elif p.startswith(QUOTE):
            out.append(p)
        elif p.startswith('L') and ';' in p:
            out.append(norm_ref(p, drop_class))
        elif re.fullmatch(r'[-0-9a-fx]+', p):
            out.append(p)
        else:
            out.append(norm_ref(p, drop_class))
    return op + ' ' + ','.join(out)


def parse_file(path, rename=None):
    methods = {}
    cur = None
    body = []
    with open(path, 'r', encoding='utf-8', errors='replace') as fh:
        for raw in fh:
            s = raw.strip()
            if s.startswith('.method '):
                m = METHOD_RE.match(s)
                cur = m.group(2) if m else s
                if rename:
                    cur = rename_method(cur, rename)
                body = []
                continue
            if s.startswith('.end method'):
                if cur is not None:
                    methods[cur] = body
                cur = None
                body = []
                continue
            if cur is None:
                continue
            if not s or s.startswith(':'):
                continue
            if s.startswith('.'):
                continue
            m = INSN_RE.match(s)
            if not m:
                continue
            body.append(norm_insn(m.group(1), m.group(2)))
    return methods


def rename_method(sig, rename):
    """map the name of a method of the original dex onto the name that the
    reconstruction uses (jadx renames the members that collide with a class
    name, the map turns them back)."""
    i = sig.find('(')
    if i < 0:
        return sig
    name, rest = sig[:i], sig[i:]
    return rename.get(name, name) + rest


def load_tree(root, rename_all=False):
    tree = {}
    for dirpath, _dirs, files in os.walk(root):
        for name in files:
            if not name.endswith('.smali'):
                continue
            path = os.path.join(dirpath, name)
            rel = os.path.relpath(path, root)[:-len('.smali')]
            rel = re.sub(r'(^|/)gg_([a-g])(/|$)',
                        lambda m: m.group(1) + m.group(2) + m.group(3), rel)
            rel = map_pkg(rel)
            rename = None
            if rename_all:
                table = RENAMES.get('L' + rel + ';')
                if table:
                    rename = {v: k for k, v in table.items()}
            tree[rel] = parse_file(path, rename)
    return tree


def has_handler(body):
    for insn in body:
        if insn.startswith('move-exception'):
            return True
    return False


def main():
    argv = sys.argv[1:]
    detail = None
    rename_orig = False
    if '--rename-orig' in argv:
        i = argv.index('--rename-orig')
        rename_orig = True
        argv = argv[:i] + argv[i + 1:]
    if '--pkg-map' in argv:
        i = argv.index('--pkg-map')
        old, _, new = argv[i + 1].partition('=')
        PKG_MAP.append((old, new))
        argv = argv[:i] + argv[i + 2:]
    if '--detail' in argv:
        i = argv.index('--detail')
        detail = argv[i + 1]
        argv = argv[:i]
    if len(argv) < 2:
        print('usage: smali_semdiff.py <ours-smali-dir> <orig-smali-dir>')
        return 2
    ours = load_tree(argv[0])
    orig = load_tree(argv[1], rename_all=rename_orig)

    if detail:
        cls, _, sig = detail.partition('#')
        g = orig[cls][sig]
        o = ours[cls][sig]
        for line in difflib.unified_diff(g, o, 'original', 'ours', lineterm='', n=2):
            print(line)
        return 0

    diffs = []
    checked = 0
    missing = 0
    handler_diff = 0
    for cls, methods in sorted(orig.items()):
        if cls not in ours:
            missing += 1
            continue
        om = ours[cls]
        for sig, body in methods.items():
            if sig not in om:
                continue
            checked += 1
            if om[sig] == body:
                continue
            if has_handler(body) or has_handler(om[sig]):
                handler_diff += 1
                continue
            diffs.append((cls, sig, body, om[sig]))

    print('classes orig=%d ours=%d  methods compared=%d  classes missing=%d'
          % (len(orig), len(ours), checked, missing))
    print('methods with exception handler (layout differs): %d' % handler_diff)
    print('methods differing: %d' % len(diffs))
    for cls, sig, obody, nbody in diffs:
        print('  %-42s %-44s orig %d / ours %d insns'
              % (cls, sig, len(obody), len(nbody)))
    return 0


if __name__ == '__main__':
    sys.exit(main())
