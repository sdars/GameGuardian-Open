#!/usr/bin/env python3
"""Regenerate the three translated methods in the pure source tree.

The translation itself lives in smali_to_java.py; this script drives it over
the ground truth smali of the original dex (build/puresrc/original) and
splices the freshly generated block into the java file, so the source tree
never needs the smali overlay again.

Two rewrites are applied to the smali before it is translated, exactly like
the old smali overlay did:

  * the obfuscator packages a..g were renamed to gg_a..gg_g in the Java tree,
  * jadx renamed every member whose name collides with a class of the same
    package (f1676f instead of f, ...).

    python3 tools/repair/regen_overlay.py           # rewrite the java files
    python3 tools/repair/regen_overlay.py --check   # only report
"""

import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import overlay_smali as O  # noqa: E402
import smali_to_java as S  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

SPECS = [
    {
        'name': 'android.ext.m.e',
        'smali': 'build/puresrc/original/android/ext/m.smali',
        'sig': 'e(Landroid/ext/n;[IJLjava/lang/String;I)I',
        'java': 'app/src/main/java/android/ext/m.java',
        'prefix': 'mE',
        'chunk': 1200,
    },
    {
        'name': 'android.ext.n$a.a',
        'smali': 'build/puresrc/original/android/ext/n$a.smali',
        'sig': 'a(Landroid/ext/n;JLjava/lang/String;I)I',
        'java': 'app/src/main/java/android/ext/n$a.java',
        'prefix': 'naA',
        'chunk': 1200,
    },
    {
        'name': 'luaj.LuaClosure.Y2',
        'smali': 'build/puresrc/original/luaj/LuaClosure.smali',
        'sig': 'Y2([Lluaj/LuaValue;Lluaj/Varargs;Z)Lluaj/Varargs;',
        'java': 'app/src/main/java/luaj/LuaClosure.java',
        'prefix': 'lcY2',
        'chunk': 1200,
    },
]

MARK = '/* ------------------------------------------------------------- *'


def build_smali(spec, memmap):
    """The rewritten smali of the target method, with a .class header."""
    path = os.path.join(ROOT, spec['smali'])
    block = O.extract_method(path, spec['sig'])
    header = ''
    with open(path, encoding='utf-8', errors='replace') as fh:
        for line in fh:
            if line.startswith('.class'):
                header = line
                break
    if not header:
        raise SystemExit('no .class line in ' + path)
    return O.rewrite(header + block, memmap)


def find_block(lines, prefix):
    """Locate the generated block: (start, signature index, end)."""
    start = -1
    for i, line in enumerate(lines):
        if line.strip().startswith(MARK[:20]):
            start = i
            break
    if start < 0:
        raise SystemExit('no generated block found')
    sig = -1
    for i in range(start, len(lines)):
        if lines[i].strip().endswith('*/'):
            sig = i + 1
            break
    end = -1
    for i, line in enumerate(lines):
        if line.strip().startswith('private static int %s_handler(' % prefix):
            depth = 0
            for j in range(i, len(lines)):
                depth += lines[j].count('{') - lines[j].count('}')
                if depth == 0 and j > i:
                    end = j
                    break
            break
    if end < 0:
        raise SystemExit('no %s_handler method found' % prefix)
    return start, sig, end


def rewrite(spec, memmap, tmpdir):
    java_path = os.path.join(ROOT, spec['java'])
    with open(java_path, encoding='utf-8') as fh:
        lines = fh.read().split('\n')
    start, sig, end = find_block(lines, spec['prefix'])
    java_sig = lines[sig].strip()[:-1].strip()
    smali_path = os.path.join(tmpdir, spec['prefix'] + '.smali')
    with open(smali_path, 'w', encoding='utf-8') as fh:
        fh.write(build_smali(spec, memmap))
    m = S.parse(smali_path, spec['sig'])
    is_static = 'static' in m.access
    gen = S.Generator(m, spec['prefix'], [], 'int', is_static,
                      chunk_size=spec['chunk'])
    _prefix, _name, params = S.parse_java_sig(java_sig)
    body = gen.generate(java_sig, params)
    out = lines[:start] + body + lines[end + 1:]
    return out, m, gen


def main(argv):
    check = '--check' in argv
    memmap = O.load_map()
    tmpdir = os.path.join(ROOT, 'build', 'regen')
    os.makedirs(tmpdir, exist_ok=True)
    for spec in SPECS:
        out, m, gen = rewrite(spec, memmap, tmpdir)
        path = os.path.join(ROOT, spec['java'])
        if not check:
            with open(path, 'w', encoding='utf-8') as fh:
                fh.write('\n'.join(out))
        print('%-24s %5d instructions  %6d lines  ambiguous=%d' % (
            spec['name'], len(m.insns), len(out), len(gen.an.ambiguous)))
        for entry in gen.an.ambiguous[:5]:
            print('    ambiguous comparison at %r' % (entry,))
    return 0


if __name__ == '__main__':
    sys.exit(main(sys.argv))
