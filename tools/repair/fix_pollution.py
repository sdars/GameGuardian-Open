#!/usr/bin/env python3
"""Undo the damage left by the broken definite-assignment fixer.

The old fixer inserted the initialiser *before the semicolon of the following
statement* instead of before the semicolon of the declaration it had found.
The result looks like

    java.lang.String str4 = 0 = 0;            (declaration, no initialiser)
    Display d = this.b.getDefaultDisplay() = 0;   (declaration, with initialiser)
    b(c2) = 0 = 0 = 0;                        (expression statement)

javac reports those as "unexpected type" or "incompatible types", so the
repair is driven by the compiler diagnostics: for every offending statement the
trailing chain of default literals (``= 0`` / ``= null`` / ...) is removed,
which restores the original dex statement.
"""
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
ERRLOG = '/tmp/ggjc_err.log'

LIT = r'(?:0|null|false|0L|0\.0f|0\.0)'
CHAIN = re.compile(r'(?: = ' + LIT + r')+$')

ERR_RE = re.compile(r'^(?P<file>.+?):(?P<line>\d+): error: (?P<msg>.*)$')
WANTED = ('unexpected type', 'incompatible types:')


def mask(text):
    out = list(text)
    i, n = 0, len(text)
    while i < n:
        c = text[i]
        if c == '/' and i + 1 < n and text[i + 1] == '/':
            j = text.find('\n', i)
            j = n if j < 0 else j
            for k in range(i, j):
                out[k] = ' '
            i = j
        elif c == '/' and i + 1 < n and text[i + 1] == '*':
            j = text.find('*/', i + 2)
            j = n if j < 0 else j + 2
            for k in range(i, j):
                if out[k] != '\n':
                    out[k] = ' '
            i = j
        elif c == '"':
            j = i + 1
            while j < n:
                if text[j] == '\\':
                    j += 2
                    continue
                if text[j] == '"':
                    j += 1
                    break
                j += 1
            for k in range(i, min(j, n)):
                if out[k] != '\n':
                    out[k] = ' '
            i = j
        elif c == "'":
            j = i + 1
            while j < n:
                if text[j] == '\\':
                    j += 2
                    continue
                if text[j] == "'":
                    j += 1
                    break
                j += 1
            for k in range(i, min(j, n)):
                if out[k] != '\n':
                    out[k] = ' '
            i = j
        else:
            i += 1
    return ''.join(out)


def statement_span(masked, offset):
    """Return (start, end) of the statement containing ``offset`` (end = ';')."""
    start = offset
    while start > 0 and masked[start - 1] not in ';{}':
        start -= 1
    end = masked.find(';', offset)
    if end < 0:
        return None
    return start, end


def main():
    if not os.path.exists(ERRLOG):
        print('no javac log at', ERRLOG)
        return 1
    per_file = {}
    for line in open(ERRLOG, encoding='utf-8', errors='replace'):
        m = ERR_RE.match(line.rstrip('\n'))
        if not m:
            continue
        if not m.group('msg').startswith(WANTED):
            continue
        per_file.setdefault(m.group('file'), set()).add(int(m.group('line')))

    total = 0
    for path, linenos in per_file.items():
        if not os.path.isabs(path):
            path = os.path.join(ROOT, path)
        if not os.path.exists(path):
            continue
        text = open(path, encoding='utf-8').read()
        masked = mask(text)
        lines = text.split('\n')
        offsets = []
        pos = 0
        for ln in lines:
            offsets.append(pos)
            pos += len(ln) + 1
        edits = []
        for lineno in sorted(linenos):
            if lineno - 1 >= len(offsets):
                continue
            off = offsets[lineno - 1]
            span = statement_span(masked, off)
            if span is None:
                continue
            s, e = span
            stmt = text[s:e]
            stripped = CHAIN.sub('', stmt)
            if stripped == stmt:
                continue
            # keep the leading indentation of the statement
            edits.append((s, e, stripped))
        if not edits:
            continue
        out = text
        for s, e, new in sorted(edits, reverse=True):
            out = out[:s] + new + out[e:]
        open(path, 'w', encoding='utf-8').write(out)
        total += len(edits)
    print('polluted statements repaired:', total)
    return 0


if __name__ == '__main__':
    sys.exit(main())
