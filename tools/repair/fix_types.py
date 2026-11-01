#!/usr/bin/env python3
"""Repair jadx's boolean/int type confusion, driven by the javac diagnostics.

jadx renders the dalvik "any int" registers in two different ways depending on
how it guessed the type:

  * a boolean register compared against zero  ->  "x != 0"   (x is boolean)
  * a boolean register used as a value       ->  "x == true ? 1 : 0"
  * an int register truncated to a short     ->  plain assignment

Java needs the real types back.  The transformations below keep the dex
semantics exactly:

  * "x != 0"  (x boolean)          ->  "x"
  * "x == 0"  (x boolean)          ->  "!x"
  * "x == true" (x int, 0/1)       ->  "x != 0"
  * boolean expression -> int      ->  "(expr ? 1 : 0)"
  * int expression -> short        ->  "(short) expr"
  * "cond ? 0 : 1" -> boolean      ->  "cond"

Every edit is guarded by the exact text javac complained about, so a stale
error log can never corrupt the tree: the script simply does not apply the
edit any more.
"""
import os
import re

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
ERRLOG = os.environ.get('GG_ERRLOG', '/tmp/ggjc_err.log')

IDENT = re.compile(r'[A-Za-z_$][\w$]*')
NUMBER = re.compile(r'(?:0[xX][0-9a-fA-F]+|\d+(?:\.\d+)?[fFdDlL]?)')

BINOPS = ('&&', '||', '==', '!=', '<=', '>=', '<<', '>>', '>>>',
          '<', '>', '+', '-', '*', '/', '%', '&', '|', '^')


def parse_errors(path):
    errs = []
    if not os.path.exists(path):
        return errs
    lines = open(path, encoding='utf-8', errors='replace').read().split('\n')
    i = 0
    while i < len(lines):
        m = re.match(r'^(?P<file>[^:]+\.java):(?P<line>\d+): error: (?P<msg>.*)$', lines[i])
        if not m:
            i += 1
            continue
        e = {'file': m.group('file'), 'line': int(m.group('line')),
             'msg': m.group('msg'), 'src': '', 'col': 0}
        if i + 2 < len(lines) and lines[i + 1].strip() and '^' in lines[i + 2]:
            e['src'] = lines[i + 1]
            e['col'] = lines[i + 2].index('^')
        errs.append(e)
        i += 3
    return errs


def skip_ws(line, i):
    while i < len(line) and line[i] in ' \t':
        i += 1
    return i


def scan_operand(line, i):
    """Scan one operand starting at i, return the index just after it."""
    i = skip_ws(line, i)
    if i >= len(line):
        return None
    if line[i] == '(':
        depth = 0
        while i < len(line):
            if line[i] == '(':
                depth += 1
            elif line[i] == ')':
                depth -= 1
                if depth == 0:
                    return i + 1
            i += 1
        return None
    m = IDENT.match(line, i)
    if m:
        end = m.end()
        # member access chain: "this.D0", "a.b.c"
        while True:
            j = skip_ws(line, end)
            if j < len(line) and line[j] == '.':
                m2 = IDENT.match(line, j + 1)
                if not m2:
                    break
                end = m2.end()
                continue
            # array access: "a[i]"
            if j < len(line) and line[j] == '[':
                k = line.find(']', j)
                if k < 0:
                    break
                end = k + 1
                continue
            break
        return end
    m = NUMBER.match(line, i)
    if m:
        return m.end()
    if line[i] == '!':
        return scan_operand(line, i + 1)
    if line[i] in '"\'':
        q = line[i]
        j = i + 1
        while j < len(line) and line[j] != q:
            j += 2 if line[j] == '\\' else 1
        return j + 1
    return None


def scan_expr(line, i):
    """Scan a full (possibly compound) expression starting at i."""
    i = skip_ws(line, i)
    end = scan_operand(line, i)
    if end is None:
        return None
    while True:
        j = skip_ws(line, end)
        op = None
        for cand in BINOPS:
            if line.startswith(cand, j):
                op = cand
                break
        if op is None:
            if line.startswith('?', j):
                k = scan_expr(line, j + 1)
                if k is None:
                    return end
                j = skip_ws(line, k)
                if line.startswith(':', j):
                    k2 = scan_expr(line, j + 1)
                    if k2 is None:
                        return end
                    end = k2
                    continue
                return end
            return end
        nxt = scan_operand(line, j + len(op))
        if nxt is None:
            return end
        end = nxt


def operand_left(line, op_start):
    """(start, end) of the operand that ends right before the operator."""
    i = op_start
    while i > 0 and line[i - 1] in ' \t':
        i -= 1
    end = i
    while end > 0 and (line[end - 1].isalnum() or line[end - 1] in '_$.'):
        end -= 1
    return end, i


def operand_right(line, op_start):
    """(start, end) of the operand that starts right after the operator."""
    i = skip_ws(line, op_start + 2)
    start = i
    if line[i:i + 4] == 'true':
        return start, start + 4
    if line[i:i + 5] == 'false':
        return start, start + 5
    m = IDENT.match(line, i)
    if m:
        return start, m.end()
    m = NUMBER.match(line, i)
    if m:
        return start, m.end()
    return None


def assignment_rhs(line, col):
    """(start, end) of the right hand side of the assignment the caret is in."""
    eq = -1
    depth = 0
    i = 0
    while i < len(line) and i < col:
        c = line[i]
        if c in '([{':
            depth += 1
        elif c in ')]}':
            depth -= 1
        elif c == '=' and depth == 0:
            if line[i:i + 2] in ('==', '!=', '<=', '>=', '+=', '-=', '*=', '/='):
                i += 2
                continue
            eq = i
        i += 1
    if eq < 0:
        return None
    start = skip_ws(line, eq + 1)
    end = scan_expr(line, start)
    if end is None:
        return None
    return start, end


def main():
    errs = parse_errors(ERRLOG)
    files = {}
    for e in errs:
        msg = e['msg']
        path = e['file']
        if not os.path.isabs(path):
            path = os.path.join(ROOT, 'app', 'src', 'main', 'java', path)
        if not os.path.exists(path):
            continue
        line = e['src']
        col = e['col']
        if not line:
            continue
        edits = []

        if msg.startswith('incomparable types: boolean and int'):
            # "x != 0" / "x == 0" where x is a boolean
            op = line[col:col + 2]
            if op not in ('==', '!='):
                continue
            ls, le = operand_left(line, col)
            rs = operand_right(line, col)
            if rs and line[rs[0]:rs[1]] in ('0',):
                name = line[ls:le]
                old = line[ls:rs[1]]
                edits.append((ls, rs[1], old, name if op == '!=' else '!' + name))
        elif msg.startswith('incomparable types: int and boolean'):
            # "x == true" where x is an int register holding 0/1
            op = line[col:col + 2]
            if op not in ('==', '!='):
                continue
            ls, le = operand_left(line, col)
            rs = operand_right(line, col)
            if rs and line[rs[0]:rs[1]] in ('true', 'false'):
                name = line[ls:le]
                truth = line[rs[0]:rs[1]] == 'true'
                old = line[ls:rs[1]]
                if op == '==':
                    new = name + (' != 0' if truth else ' == 0')
                else:
                    new = name + (' == 0' if truth else ' != 0')
                edits.append((ls, rs[1], old, new))
        elif msg.startswith('incompatible types: boolean cannot be converted to'):
            sp = assignment_rhs(line, col)
            if sp:
                old = line[sp[0]:sp[1]]
                edits.append((sp[0], sp[1], old, '(' + old + ' ? 1 : 0)'))
        elif msg.startswith('incompatible types: possible lossy conversion from int to'):
            sp = assignment_rhs(line, col)
            if sp:
                old = line[sp[0]:sp[1]]
                edits.append((sp[0], sp[1], old, '(short) ' + old))
        elif msg.startswith('incompatible types: int cannot be converted to boolean'):
            m = re.match(r'^(?P<pre>.*?)\s*\?\s*(?:0|1)\s*:\s*(?:0|1)\s*;?\s*$', line)
            if m:
                pre = m.group('pre')
                edits.append((m.start('pre'), len(line.rstrip()),
                              line[m.start('pre'):len(line.rstrip())], pre + ';'))
        if not edits:
            continue
        files.setdefault(path, []).append((e['line'], edits))

    n = 0
    skipped = 0
    for path, per_line in files.items():
        text = open(path, encoding='utf-8').read()
        lines = text.split('\n')
        for lineno, edits in per_line:
            idx = lineno - 1
            if idx >= len(lines):
                continue
            s = lines[idx]
            changed = False
            for st, en, old, rep in sorted(edits, key=lambda t: -t[0]):
                if s[st:en] != old:
                    skipped += 1
                    continue
                s = s[:st] + rep + s[en:]
                changed = True
            if changed:
                lines[idx] = s
                n += 1
        open(path, 'w', encoding='utf-8').write('\n'.join(lines))
    print('lines rewritten: %d (skipped %d stale edits)' % (n, skipped))


if __name__ == '__main__':
    main()
