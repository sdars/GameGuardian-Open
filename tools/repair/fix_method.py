#!/usr/bin/env python3
"""Replace one java method with a mechanical translation of the dex code.

jadx sometimes mis-decompiles a method (inverted branches, duplicated
blocks).  Where that happens the pure source tree silently disagrees with the
original dex.  This script takes the ground truth smali of the original dex,
applies the same renames the smali overlay used (packages a..g -> gg_a..gg_g
and the jadx member renames) and splices a mechanically translated method
into the java file.

    python3 tools/repair/fix_method.py <smali> <method-sig> <java-file> \\
            <java-method-name> <prefix>
"""

import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import java_lexer
import overlay_smali as O  # noqa: E402
from java_clean import drop_generated  # noqa: E402
import smali_to_java as S  # noqa: E402
import re  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

# the package rename also has to reach the type descriptors that appear
# inside method references ("Lg/g$h;" -> "Lgg_g/g$h;")
RE_DESC = re.compile(r'L([a-g])/')


def rewrite_all(text, memmap):
    text = O.rewrite(text, memmap)
    return RE_DESC.sub(r'Lgg_\1/', text)


def java_class_name(lines):
    """The simple name of the class declared in a java source file."""
    for line in lines:
        s = line.strip()
        if not s.startswith('class ') and not s.startswith('public class '):
            continue
        rest = s.split('class ', 1)[1]
        name = rest.split()[0].split('<')[0].split('{')[0].strip()
        return name.split('.')[-1]
    return None


MODIFIERS = ('public', 'private', 'protected', 'static', 'final', 'abstract',
             'synchronized', 'native', 'strictfp', 'default', 'transient',
             'volatile')


def java_is_constructor(head):
    """True when a method head declares a constructor (no return type)."""
    words = head[:head.find('(')].strip().split()
    if len(words) < 2:
        return False
    return all(w in MODIFIERS for w in words[:-1])


def java_signature(line):
    """The declaration of a java method without the opening brace.

    jadx sometimes puts the opening brace of a try block on the same line
    as the declaration (``public void f() {try {``); only the signature
    itself is of interest here.
    """
    line = line.strip()
    i = line.find('(')
    if i < 0:
        return line
    depth = 0
    for j in range(i, len(line)):
        if line[j] == '(':
            depth += 1
        elif line[j] == ')':
            depth -= 1
            if depth == 0:
                sig = line[:j + 1].strip()
                # the throws clause belongs to the signature: a subclass
                # may only narrow the exceptions of the method it overrides
                rest = line[j + 1:]
                brace = rest.find('{')
                if brace >= 0:
                    thr = rest[:brace].strip()
                    if thr.startswith('throws'):
                        sig = sig + ' ' + thr
                return sig
    return line


def java_method_bounds(lines, name, skip=None):
    """(signature index, body end index) of the java method with that name."""
    start = -1
    for i, line in enumerate(lines):
        stripped = line.strip()
        if not stripped.endswith('{'):
            continue
        head = stripped[:-1].strip()
        if '(' not in head:
            continue
        mname = head[:head.find('(')].strip().split()[-1]
        if skip is not None and mname == skip and java_is_constructor(head):
            # the constructor carries the class name
            continue
        if mname != name:
            continue
        start = i
        break
    if start < 0:
        raise SystemExit('method %s not found' % name)
    # The decompiled sources carry jadx warnings with unbalanced braces
    # inside the comments, so the counting has to ignore comments and
    # literals - java_lexer blanks them out for us.
    text = chr(10).join(lines)
    masked = java_lexer.code_mask(text)
    offs = java_lexer.line_offsets(text)
    depth = 0
    started = False
    for j in range(start, len(lines)):
        seg = masked[offs[j]:offs[j] + len(lines[j])]
        for ch in seg:
            if ch == '{':
                depth += 1
                started = True
            elif ch == '}':
                depth -= 1
                if started and depth == 0:
                    return start, j
    raise SystemExit('unbalanced braces for ' + name)


def main(argv):
    if len(argv) != 6:
        print(__doc__)
        return 2
    smali_rel, sig, java_rel, java_name, prefix = argv[1:6]
    smali_path = os.path.join(ROOT, smali_rel)
    java_path = os.path.join(ROOT, java_rel)
    memmap = O.load_map()

    block = O.extract_method(smali_path, sig)
    header = ''
    with open(smali_path, encoding='utf-8', errors='replace') as fh:
        for line in fh:
            if line.startswith('.class'):
                header = line
                break
    tmpdir = os.path.join(ROOT, 'build', 'fixmethod')
    os.makedirs(tmpdir, exist_ok=True)
    tmp = os.path.join(tmpdir, prefix + '.smali')
    with open(tmp, 'w', encoding='utf-8') as fh:
        fh.write(rewrite_all(header + block, memmap))

    with open(java_path, encoding='utf-8') as fh:
        lines = fh.read().split('\n')
    lines = drop_generated(lines, prefix)
    start, end = java_method_bounds(lines, java_name)
    java_sig = lines[start].strip()[:-1].strip()

    # the package rename also affects the method descriptor
    rewritten_sig = rewrite_all(sig, memmap)
    m = S.parse(tmp, rewritten_sig)
    gen = S.Generator(m, prefix, [], 'int', 'static' in m.access, chunk_size=600)
    _prefix, _name, params = S.parse_java_sig(java_sig)
    body = gen.generate(java_sig, params)
    out = lines[:start] + body + lines[end + 1:]
    with open(java_path, 'w', encoding='utf-8') as fh:
        fh.write('\n'.join(out))
    print('replaced %s.%s: %d instructions -> %d lines' % (
        java_rel, java_name, len(m.insns), len(body)))
    return 0


if __name__ == '__main__':
    sys.exit(main(sys.argv))
