#!/usr/bin/env python3
"""Repair jadx '??' placeholders (unresolved local-variable types) in the
flattened GameGuardian source tree.

Every fix was cross-checked against
  * the smali of the original dex (register types), and
  * the second jadx pass kept in analysis/2026-11-01/decompilers (nested-class form)
so the rebuilt bytecode keeps the original semantics.

Idempotent: running it twice is a no-op.
"""
import os, re, sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')


def patch(rel, pairs, regexes=()):
    path = os.path.join(SRC, rel)
    with open(path, encoding='utf-8') as fh:
        text = fh.read()
    orig = text
    for old, new, cnt in pairs:
        n = text.count(old)
        if n == 0:
            continue  # already applied
        if cnt is not None and n != cnt:
            raise SystemExit(f'{rel}: expected {cnt} occurrences of {old!r}, found {n}')
        text = text.replace(old, new)
    for pat, new, cnt in regexes:
        text, n = re.subn(pat, new, text, flags=re.M)
        if cnt is not None and n != cnt:
            raise SystemExit(f'{rel}: regex {pat!r} matched {n} times, expected {cnt}')
    if text != orig:
        with open(path, 'w', encoding='utf-8') as fh:
            fh.write(text)
        print(f'patched {rel}')
    else:
        print(f'no-op   {rel}')


# a/d.java : LayoutInflater.inflate(int, ViewGroup, boolean) resource id
patch('a/d.java', [
    ('        ?? Inflate = i;\n', '        int Inflate = i;\n', 1),
])

# MainService$g0$a$a : reinstall flow, F is the result string of the helper
patch('android/ext/MainService$g0$a$a.java', [
    ('        ?? F = 2131296893;\n', '        java.lang.String F = "";\n', 1),
    ('F = android.ext.b2.f(F) + "\\n" + e2.getMessage();',
     'F = android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.reinstall_failed) + "\\n" + e2.getMessage();', 1),
])

# Tools.a1 : r1 = resource id, r3 = the closeable to release in finally
patch('android/ext/Tools.java', [
    ('        ?? r1;\n', '        int r1;\n', 1),
    ('        ?? r3 = 0;\n', '        java.io.Closeable r3 = null;\n', 1),
])

# f0.h0 : r15 = message fragment (String), r16 was merged from 'self' (f0) and 'size' (String)
patch('android/ext/f0.java', [
    ('        ?? r15;\n', '        java.lang.String r15;\n', 1),
    ('        ?? r16 = this;\n',
     '        f0 r16 = this;\n        java.lang.String size = ", size: ";\n', 1),
    ('r16 = ", size: ";', 'size = ", size: ";', 3),
    ('java.lang.Object obj = ", size: ";', 'java.lang.String obj = ", size: ";', 1),
    ('r16 = obj;', 'size = obj;', 2),
    ('                r15 = r16;\n', '                r15 = size;\n', 1),
])

# o0$b.onClick : bit flags for the checkbox triple
patch('android/ext/o0$b.java', [
    ('        ?? r0;\n        ?? r1;\n', '        int r0;\n        int r1;\n', 1),
])

# luaj.Globals.P3 : the stream handed to the undumper / assembler
patch('luaj/Globals.java', [
    ('        ?? r10;\n', '        java.io.InputStream r10;\n', 1),
])

# n$g : ARM64 decoder scratch registers (all int)
patch('android/ext/n$g.java', [], [
    (r'^([ \t]*)\?\? (r\d+)( = [^;\n]*)?;$', lambda m: f'{m.group(1)}int {m.group(2)}{m.group(3) or ""};', None),
])

print('done')
