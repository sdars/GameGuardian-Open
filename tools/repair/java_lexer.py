#!/usr/bin/env python3
"""A very small Java scanner.

The decompiled sources contain string literals with braces, character
literals, line comments and block comments.  Every tool that has to know
where a block starts and where it ends has to look at those, otherwise the
brace counting drifts apart.  This module provides the scanner that all the
structural repair tools share.

The scanner never rewrites the text, it only reports positions.
"""


def _scan(text):
    """Return a list of (kind, start, end) regions."""
    regions = []
    n = len(text)
    i = 0
    code_start = 0
    while i < n:
        c = text[i]
        if c == '"':
            if i > code_start:
                regions.append(('code', code_start, i))
            j = i + 1
            while j < n:
                if text[j] == chr(92):
                    j += 2
                    continue
                if text[j] == '"':
                    j += 1
                    break
                if text[j] == chr(10):
                    break
                j += 1
            regions.append(('str', i, j))
            i = code_start = j
        elif c == "'":
            if i > code_start:
                regions.append(('code', code_start, i))
            j = i + 1
            while j < n:
                if text[j] == chr(92):
                    j += 2
                    continue
                if text[j] == "'":
                    j += 1
                    break
                if text[j] == chr(10):
                    break
                j += 1
            regions.append(('chr', i, j))
            i = code_start = j
        elif c == '/' and i + 1 < n and text[i + 1] in '/*':
            if i > code_start:
                regions.append(('code', code_start, i))
            if text[i + 1] == '/':
                j = text.find(chr(10), i)
                j = n if j < 0 else j
            else:
                j = text.find('*/', i + 2)
                j = n if j < 0 else j + 2
            regions.append(('comment', i, j))
            i = code_start = j
        else:
            i += 1
    if code_start < n:
        regions.append(('code', code_start, n))
    return regions


def code_mask(text):
    """A copy of the text where literals and comments are blanked out.

    The length of the result is identical to the length of the input, so
    every offset stays valid.
    """
    out = list(text)
    for kind, s, e in _scan(text):
        if kind == 'code':
            continue
        for k in range(s, e):
            if out[k] != chr(10):
                out[k] = ' '
    return ''.join(out)


def depth_map(text, base=0):
    """Return a list with the brace depth after every character."""
    co = code_mask(text)
    depth = base
    res = []
    for c in co:
        if c == '{':
            depth += 1
        elif c == '}':
            depth -= 1
        res.append(depth)
    return res


def line_offsets(text):
    """offset of the first character of every line"""
    offs = [0]
    for i, c in enumerate(text):
        if c == chr(10):
            offs.append(i + 1)
    return offs


def offset_to_line(offs, off):
    lo, hi = 0, len(offs) - 1
    while lo < hi:
        mid = (lo + hi + 1) // 2
        if offs[mid] <= off:
            lo = mid
        else:
            hi = mid - 1
    return lo


def find_matching(text, open_off, dm=None):
    """Given the offset of a '{' return the offset of the matching '}'"""
    if dm is None:
        dm = depth_map(text)
    target = dm[open_off]
    for i in range(open_off + 1, len(text)):
        if text[i] == '}' and dm[i] == target - 1:
            return i
    return -1
