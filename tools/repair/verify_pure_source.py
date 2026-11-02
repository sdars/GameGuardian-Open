#!/usr/bin/env python3
"""Check that the release build is pure java source.

The three methods that used to be shipped as a smali overlay are plain java
now, so the build must not contain any smali any more and the produced dex
must contain the java translation of the three methods.

Checks:

  1. no .smali file is left in app/src and no smali source set is configured
     in build.gradle - the build input is app/src/main/java only,
  2. the three methods exist in the release dex,
  3. the release dex is not the original dex any more: the entry point of
     every target is a dispatcher into the java state machine, so the
     original smali body is not in the release any more,
  4. no class of the release dex is still an undecompiled stub.

Usage: verify_pure_source.py [release classes.dex] [original classes.dex]
"""

import os
import re
import subprocess
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
LIB = os.path.join(ROOT, 'tools', 'lib')
WORK = os.path.join(ROOT, 'build', 'puresrc')

# rel path, descriptor, prefix of the generated java state machine methods
TARGETS = [
    ('android/ext/m.smali', 'e(Landroid/ext/n;[IJLjava/lang/String;I)I', 'mE_'),
    ('android/ext/n$a.smali', 'a(Landroid/ext/n;JLjava/lang/String;I)I', 'naA_'),
    ('luaj/LuaClosure.smali', 'Y2([Lluaj/LuaValue;Lluaj/Varargs;Z)Lluaj/Varargs;', 'lcY2_'),
]

RE_METHOD = re.compile(r'^\.method\s+(.*?)\s*([^\s(]+)(\(.*)$')


def disassemble(dex, outdir):
    if not os.path.isdir(outdir):
        subprocess.run(['java', '-cp', LIB + '/*', 'org.jf.baksmali.Main', 'd', dex, '-o', outdir],
                       check=True, capture_output=True)


def method_index(path):
    """Return {(name, descriptor): (instruction count, body)} of one smali file."""
    lines = open(path, encoding='utf-8').read().splitlines()
    out = {}
    for i, line in enumerate(lines):
        if not line.startswith('.method '):
            continue
        m = RE_METHOD.match(line)
        if not m:
            continue
        name, desc = m.group(2), m.group(3)
        count = 0
        for j in range(i + 1, len(lines)):
            s = lines[j].strip()
            if s == '.end method':
                break
            if s and not s.startswith('.') and not s.startswith('#'):
                count += 1
        out[(name, desc)] = count
    return out


def split_sig(sig):
    """Split 'name(descriptor)' into the (name, descriptor) tuple."""
    name, desc = sig.split('(', 1)
    return name, '(' + desc

def check_no_smali():
    ok = True
    src = os.path.join(ROOT, 'app', 'src')
    for dirpath, _dirs, files in os.walk(src):
        for name in files:
            if name.endswith('.smali'):
                print('SMALI     %s' % os.path.join(dirpath, name))
                ok = False
    gradle = os.path.join(ROOT, 'app', 'build.gradle')
    text = open(gradle, encoding='utf-8').read()
    if 'smali' in text:
        print('SMALI     app/build.gradle still mentions smali')
        ok = False
    if not ok:
        print('FAILED    the build must not contain smali')
    else:
        print('OK        no smali in app/src and none in app/build.gradle')
    return ok


def check_dex(rel_dex, orig_dex):
    new_dir = os.path.join(WORK, 'release')
    old_dir = os.path.join(WORK, 'original')
    disassemble(rel_dex, new_dir)
    have_orig = bool(orig_dex) and os.path.exists(orig_dex)
    if have_orig:
        disassemble(orig_dex, old_dir)

    ok = True
    print()
    print('%-14s %-10s %10s %12s %12s' % ('method', 'entry', 'original', 'release', 'state machine'))
    for rel, sig, impl in TARGETS:
        new = method_index(os.path.join(new_dir, rel))
        key = split_sig(sig)
        if key not in new:
            print('MISSING   %-26s %s' % (rel, sig))
            ok = False
            continue
        impl_count = sum(c for (n, _d), c in new.items() if n.startswith(impl))
        old_count = -1
        if have_orig:
            old = method_index(os.path.join(old_dir, rel))
            old_count = old.get(key, -1)
        print('%-14s %-10s %10s %12s %12s' % (rel.split('/')[-1], 'entry', old_count, new[key], impl_count))
        if impl_count <= 0:
            print('          the java state machine %s* is missing from the release dex' % impl)
            ok = False
        elif old_count > 0 and new[key] == old_count:
            print('          the release body is identical to the original dex - that is the old smali overlay')
            ok = False
    print()
    stubs = 0
    for dirpath, _dirs, files in os.walk(new_dir):
        for name in files:
            if not name.endswith('.smali'):
                continue
            text = open(os.path.join(dirpath, name), encoding='utf-8', errors='replace').read()
            stubs += text.count('Method not decompiled')
    if stubs:
        print('FAILED    %d undecompiled stub(s) left in the release dex' % stubs)
        ok = False
    else:
        print('OK        no undecompiled stub left in the release dex')
    return ok


def main():
    rel_dex = sys.argv[1] if len(sys.argv) > 1 else os.path.join(ROOT, 'build', 'release', 'classes.dex')
    orig_dex = sys.argv[2] if len(sys.argv) > 2 else os.path.join(ROOT, 'tmp', 'analysis', '2026-11-01', 'classes.dex')
    print('release dex : %s' % rel_dex)
    print('original dex: %s' % orig_dex)
    ok = check_no_smali()
    ok = check_dex(rel_dex, orig_dex) and ok
    print()
    print('RESULT: %s' % ('the release build is pure java source' if ok else 'problems found'))
    sys.exit(0 if ok else 1)


if __name__ == '__main__':
    main()
