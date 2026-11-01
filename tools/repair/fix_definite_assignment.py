#!/usr/bin/env python3
"""Give the locals of the decompiled code their dex default value.

jadx turns the dex registers into Java locals that are only assigned on some
paths, so javac rejects them with

    variable x might not have been initialized

A dex register that was never written holds 0 / 0L / false / null, so the
faithful repair is to initialise the local with the default value of its
type.  The script reads the javac log, finds the declaration of every
offending local and adds the initialiser *to that very declaration*.

Locals that are captured by a lambda become "final" instead: initialising
them would break the "effectively final" requirement of the capture.
"""
import bisect
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
ERRLOG = '/tmp/ggjc_err.log'

ERR_RE = re.compile(r'^(?P<file>.+?):(?P<line>\d+): error: variable (?P<name>[A-Za-z_$][\w$]*) might not have been initialized')

PRIM = {
    'boolean': 'false',
    'byte': '0',
    'short': '0',
    'int': '0',
    'char': '0',
    'long': '0L',
    'float': '0.0f',
    'double': '0.0',
}

# keywords that may introduce a parenthesised block which is NOT a method body
NON_METHOD_KW = ('catch', 'if', 'while', 'for', 'switch', 'synchronized', 'new')
MODIFIERS = ('public', 'private', 'protected', 'static', 'abstract', 'native',
             'synchronized', 'transient', 'volatile', 'strictfp')


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


def _skip_throws(masked, j):
    """Walk back over a "throws A, B" clause; return the new j or None."""
    k = j
    while k >= 0:
        while k >= 0 and masked[k] in ' \t\r\n':
            k -= 1
        if k < 0:
            return None
        c = masked[k]
        if c.isalnum() or c in '_$':
            e = k
            while e >= 0 and (masked[e].isalnum() or masked[e] in '_$'):
                e -= 1
            word = masked[e + 1:k + 1]
            if word == 'throws':
                k = e
                break
            k = e
            continue
        if c in ',.':
            k -= 1
            continue
        return None
    while k >= 0 and masked[k] in ' \t\r\n':
        k -= 1
    return k


def build_blocks(masked):
    """Collect the brace blocks of the file.

    Every block remembers whether it introduces a scope (a method body, a
    class body or a static initialiser) and which keyword opened it.  The
    keyword is needed to find the loop a "return;" belongs to.
    """
    blocks = []
    stack = []
    for i, c in enumerate(masked):
        if c == '{':
            b = {'open': i, 'close': None, 'parent': stack[-1] if stack else None,
                 'scope': False, 'kw': None}
            blocks.append(b)
            stack.append(b)
        elif c == '}':
            if stack:
                stack.pop()['close'] = i
    for b in blocks:
        j = b['open'] - 1
        while j >= 0 and masked[j] in ' \t\r\n':
            j -= 1
        if j < 0:
            continue
        if masked[j] == ')':
            depth = 0
            k = j
            while k >= 0:
                if masked[k] == ')':
                    depth += 1
                elif masked[k] == '(':
                    depth -= 1
                    if depth == 0:
                        break
                k -= 1
            word = None
            if k > 0:
                m = re.search(r'([A-Za-z_$][\w$]*)\s*$', masked[max(0, k - 60):k])
                if m:
                    word = m.group(1)
            if word is not None and word not in NON_METHOD_KW:
                b['scope'] = True
                b['kw'] = word
        elif masked[max(0, j - 5):j + 1] == 'static':
            b['scope'] = True
            b['kw'] = 'static'
        else:
            # a method may declare "throws IOException" - skip the clause
            j2 = _skip_throws(masked, j)
            if j2 is not None and j2 >= 0 and masked[j2] == ')':
                depth = 0
                k = j2
                while k >= 0:
                    if masked[k] == ')':
                        depth += 1
                    elif masked[k] == '(':
                        depth -= 1
                        if depth == 0:
                            break
                    k -= 1
                word = None
                if k > 0:
                    m = re.search(r'([A-Za-z_$][\w$]*)\s*$', masked[max(0, k - 60):k])
                    if m:
                        word = m.group(1)
                if word is not None and word not in NON_METHOD_KW:
                    b['scope'] = True
                    b['kw'] = word
            else:
                m = re.search(r'([A-Za-z_$][\w$]*)\s*$', masked[max(0, j - 30):j + 1])
                if m:
                    b['kw'] = m.group(1)
    return blocks


def lambda_bodies(masked, blocks, meth):
    """Return the list of (start, end) character ranges of lambda bodies."""
    out = []
    body = masked[meth['open']:meth['close']]
    pos = 0
    while True:
        k = body.find('->', pos)
        if k < 0:
            break
        pos = k + 2
        p = meth['open'] + k + 2
        while p < meth['close'] and masked[p] in ' \t\r\n':
            p += 1
        if p >= meth['close']:
            break
        if masked[p] == '{':
            depth = 0
            q = p
            while q < meth['close']:
                if masked[q] == '{':
                    depth += 1
                elif masked[q] == '}':
                    depth -= 1
                    if depth == 0:
                        break
                q += 1
            out.append((p, min(q, meth['close'])))
        else:
            depth = 0
            q = p
            while q < meth['close']:
                ch = masked[q]
                if ch in '([{':
                    depth += 1
                elif ch in ')]}':
                    if depth == 0:
                        break
                    depth -= 1
                elif ch in ';,' and depth == 0:
                    break
                q += 1
            out.append((p, q))
    return out


def main():
    if not os.path.exists(ERRLOG):
        print('no javac log at', ERRLOG)
        return 1
    per_file = {}
    for line in open(ERRLOG, encoding='utf-8', errors='replace'):
        m = ERR_RE.match(line.rstrip('\n'))
        if m:
            per_file.setdefault(m.group('file'), set()).add((int(m.group('line')), m.group('name')))

    decl_re = re.compile(
        r'(?m)^(?P<lead>[ \t]*)'
        r'(?P<mods>(?:(?:public|private|protected|static|final|abstract|native|'
        r'synchronized|transient|volatile|strictfp)[ \t]+)*)'
        r'(?P<type>[A-Za-z_$][\w.$]*(?:<[^;{}=]*>)?(?:\[\])*)[ \t]+'
        r'(?P<name>[A-Za-z_$][\w$]*)(?P<rest>[^;{}=]*)(?P<after>[;=])')

    total = 0
    finals = 0
    unresolved = []
    for path, wanted in per_file.items():
        if not os.path.isabs(path):
            path = os.path.join(ROOT, path)
        if not os.path.exists(path):
            continue
        text = open(path, encoding='utf-8').read()
        masked = mask(text)
        blocks = build_blocks(masked)
        opens = [b['open'] for b in blocks]
        lines = text.split('\n')
        offsets = []
        pos = 0
        for ln in lines:
            offsets.append(pos)
            pos += len(ln) + 1

        def block_at(off):
            i = bisect.bisect_left(opens, off) - 1
            if i < 0:
                return None
            b = blocks[i]
            while b is not None and b['close'] is not None and b['close'] <= off:
                b = b['parent']
            return b

        def scope_of(b):
            while b is not None:
                if b['scope']:
                    return b
                b = b['parent']
            return None

        def is_descendant(db, anc):
            while db is not None:
                if db is anc:
                    return True
                db = db['parent']
            return False

        decls = {}
        for m in decl_re.finditer(masked):
            mods = m.group('mods')
            if re.search(r'\b(public|private|protected|static|abstract|native|'
                         r'synchronized|transient|volatile|strictfp)\b', mods):
                continue
            m = m if not re.search(r'\bfinal\b', mods) else None
            if m is None:
                continue
            decls.setdefault(m.group('name'), []).append(m)

        edits = {}
        for lineno, name in sorted(wanted):
            if lineno - 1 >= len(offsets):
                continue
            use_off = offsets[lineno - 1]
            ub = block_at(use_off)
            if ub is None:
                continue
            meth = scope_of(ub)
            if meth is None:
                unresolved.append((path, lineno, name, 'no-scope'))
                continue
            best = None
            for m in decls.get(name, []):
                if m.start() >= use_off:
                    continue
                db = block_at(m.start())
                if db is None or not is_descendant(db, meth):
                    continue
                if db['close'] is None or ub['close'] is None:
                    continue
                if not (db['open'] <= ub['open'] and db['close'] >= ub['close']):
                    continue
                if best is None or m.start() > best.start():
                    best = m
            if best is None:
                unresolved.append((path, lineno, name, 'no-decl'))
                continue
            if best.group('after') == '=':
                unresolved.append((path, lineno, name, 'has-init'))
                continue
            captured = False
            for (a, b) in lambda_bodies(masked, blocks, meth):
                if re.search(r'\b' + re.escape(name) + r'\b', masked[a:b]):
                    captured = True
                    break
            if captured:
                edits.setdefault(('final', best.start()), best)
                finals += 1
                continue
            typ = best.group('type')
            base = typ.split('<')[0].split('.')[-1].strip()
            default = PRIM.get(base, 'null')
            semi = best.end() - 1
            if semi in edits:
                continue
            edits[semi] = ' = ' + default
            total += 1
        if edits:
            out = text
            for key in sorted(edits, key=lambda k: (k if isinstance(k, int) else k[1]), reverse=True):
                if isinstance(key, int):
                    out = out[:key] + edits[key] + out[key:]
                else:
                    m = edits[key]
                    out = out[:m.start('type')] + 'final ' + out[m.start('type'):]
            open(path, 'w', encoding='utf-8').write(out)

    print('locals initialised:', total, ' turned final:', finals)
    if unresolved:
        print('unresolved:', len(unresolved))
        for u in unresolved[:40]:
            print('  ', u[0].split('/java/')[-1], u[1], u[2], u[3])
    return 0


if __name__ == '__main__':
    sys.exit(main())
