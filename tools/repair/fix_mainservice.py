#!/usr/bin/env python3
"""Hand reconstructions of the MainService methods where jadx lost the flow.

Every method below was rebuilt from the smali of the original dex
(tmp/analysis/2026-11-01/apktool_src/smali/android/ext/MainService.smali).
The comment in front of each method names the dex construct it restores.

The script is idempotent: it replaces a whole method body, so running it
twice produces the same tree.
"""
import os
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')
TARGET = os.path.join(SRC, 'android', 'ext', 'MainService.java')


def _scan_body(text, start):
    """Return the index of the '}' that closes the method body at `start`.

    `start` points at the opening '{'.  String literals, character literals
    and comments are skipped so that braces inside them do not confuse the
    nesting counter.
    """
    i = start
    depth = 0
    n = len(text)
    while i < n:
        c = text[i]
        if c == '"':
            i += 1
            while i < n and text[i] != '"':
                if text[i] == '\\':
                    i += 1
                i += 1
            i += 1
            continue
        if c == "'":
            i += 1
            while i < n and text[i] != "'":
                if text[i] == '\\':
                    i += 1
                i += 1
            i += 1
            continue
        if c == '/' and i + 1 < n and text[i + 1] == '/':
            j = text.find('\n', i)
            i = n if j < 0 else j
            continue
        if c == '/' and i + 1 < n and text[i + 1] == '*':
            j = text.find('*/', i + 2)
            i = n if j < 0 else j + 2
            continue
        if c == '{':
            depth += 1
        elif c == '}':
            depth -= 1
            if depth == 0:
                return i
        i += 1
    raise ValueError('unbalanced method body')


def replace_method(text, header, new_method):
    """Replace the method starting at the line `header` with `new_method`."""
    i = text.index(header)
    j = text.index('{', i + len(header) - 1)
    k = _scan_body(text, j)
    return text[:i] + new_method + text[k + 1:]



FRAG = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'fragments')

METHODS = [
    ('    public void L(java.lang.Long l, java.lang.String str, java.lang.CharSequence charSequence) {',
     'MainService_L.java'),
    ('    public void Z() {', 'MainService_Z.java'),
    ('    public void b1() {', 'MainService_b1.java'),
    ('    public void k0(int i) {', 'MainService_k0.java'),
    ('    public void l0(android.ext.w wVar) throws java.lang.Throwable {', 'MainService_l0.java'),
    ('    public void onClick(android.view.View view) {', 'MainService_onClick.java'),
]


def main():
    if not os.path.exists(TARGET):
        print('MISSING', TARGET)
        return 1
    text = open(TARGET, encoding='utf-8').read()
    for header, name in METHODS:
        path = os.path.join(FRAG, name)
        body = open(path, encoding='utf-8').read().rstrip('\n')
        text = replace_method(text, header, body)
    open(TARGET, 'w', encoding='utf-8').write(text)
    print('MainService: rebuilt %d methods' % len(METHODS))
    return 0


if __name__ == '__main__':
    sys.exit(main())
