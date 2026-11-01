#!/usr/bin/env python3
"""Generate the javac-visible stubs for marker classes jadx refuses to emit.

In the dex, several classes exist only as *marker* types: they are declared
`abstract synthetic`, carry no fields and no methods and are referenced from
the signature of a synthetic constructor.  jadx drops such a class from its
Java output (there is nothing to decompile) but keeps the constructor that
mentions it, so javac then reports "cannot find symbol: class X$a".

This script walks the smali tree, finds every class that is
`abstract synthetic` and member-less, and writes the matching Java file.
The bodies stay empty on purpose - the class exists only so that the type of
the synthetic accessor is nameable.

Package renaming (a..g -> gg_a..gg_g) is applied here as well so the script
matches the layout produced by tools/repair/rename_packages.py.
"""
import os
import re
import shutil
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')
SMALI = os.path.join(ROOT, 'tmp', 'analysis', '2026-11-01', 'apktool_src', 'smali')

PKG_ALIAS = {p: 'gg_' + p for p in 'abcdefg'}

CLASS_RE = re.compile(r'^\.class\s+(?P<flags>[^;]*?)(?P<desc>L[^;]+);', re.M)
MEMBER_RE = re.compile(r'^\.(?:method|field)\b', re.M)


def collect():
    """Yield (package, simple-class-name) for every member-less synthetic class."""
    if not os.path.isdir(SMALI):
        return
    for dirpath, _dirs, names in os.walk(SMALI):
        for nm in names:
            if not nm.endswith('.smali'):
                continue
            p = os.path.join(dirpath, nm)
            txt = open(p, encoding='utf-8', errors='replace').read()
            m = CLASS_RE.search(txt)
            if not m:
                continue
            head = m.group('flags')
            if 'abstract' not in head or 'synthetic' not in head:
                continue
            if MEMBER_RE.search(txt):
                continue
            desc = m.group('desc')                   # e.g. Lg/g$a;
            rel = os.path.relpath(p, SMALI)
            parts = os.path.dirname(rel).split(os.sep) if os.path.dirname(rel) else []
            parts = [PKG_ALIAS.get(x, x) for x in parts if x]
            # desc is the type descriptor without the trailing ';' - the
            # leading 'L' is the only character that has to go.
            simple = desc[1:].replace('/', '.')
            yield '.'.join(parts), simple, nm[:-6]


def main():
    written = 0
    skipped = 0
    for pkg, simple, _stem in sorted(collect()):
        out = os.path.join(SRC, *pkg.split('.')) if pkg else SRC
        out = os.path.join(out, simple.split('.')[-1] + '.java')
        if os.path.exists(out):
            skipped += 1
            continue
        os.makedirs(os.path.dirname(out), exist_ok=True)
        body = [
            'package %s;' % pkg if pkg else None,
            '',
            '/* JADX INFO: loaded from: classes.dex */',
            'abstract class %s {' % simple.split('.')[-1],
            '}',
            '',
        ]
        with open(out, 'w', encoding='utf-8') as fh:
            fh.write('\n'.join(x for x in body if x is not None))
        written += 1
    print('synthetic stubs: %d written, %d already present' % (written, skipped))


if __name__ == '__main__':
    main()
