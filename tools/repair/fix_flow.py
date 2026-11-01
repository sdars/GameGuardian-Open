#!/usr/bin/env python3
"""Repair the remaining flow-analysis defects of the decompiled code.

Three groups are handled:

* "exception X is never thrown in body of corresponding try statement"
  jadx keeps a catch clause for an exception the try block cannot raise.
  The clause is dead code and is removed.

* "unreachable statement"
  jadx duplicates the "break" of a loop or emits a statement after an
  unconditional throw.  The dead statement is removed.

* "variable X might already have been assigned" / "cannot assign a value to
  static final variable X"
  the field is written more than once, so it cannot be final.
"""
import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from fix_checked_exceptions import mask, statement_start, statement_end   # noqa: E402
from fix_definite_assignment import build_blocks                        # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
ERRLOG = '/tmp/ggjc_err.log'

NEVER = re.compile(r'^(?P<file>.+?):(?P<line>\d+): error: exception .* is never thrown in body of corresponding try statement')
UNREACH = re.compile(r'^(?P<file>.+?):(?P<line>\d+): error: unreachable statement')
ASSIGNED = re.compile(r'^(?P<file>.+?):(?P<line>\d+): error: variable (?P<name>[A-Za-z_$][\w$]*) might already have been assigned')
FINALASSIGN = re.compile(r'^(?P<file>.+?):(?P<line>\d+): error: cannot assign a value to static final variable (?P<name>[A-Za-z_$][\w$]*)')
MISSINGRET = re.compile(r'^(?P<file>.+?):(?P<line>\d+): error: missing return statement')

DEFAULT_RET = {
    'int': '0', 'short': '0', 'byte': '0', 'char': "'\\0'", 'long': '0L',
    'float': '0.0f', 'double': '0.0', 'boolean': 'false',
}


def method_of(masked, blocks, off):
    best = None
    for b in blocks:
        if b['open'] <= off and (b['close'] is None or off < b['close']):
            if b['scope'] and (best is None or b['open'] > best['open']):
                best = b
    return best


def main():
    if not os.path.exists(ERRLOG):
        print('no javac log at', ERRLOG)
        return 1
    never, unreach, assigned, finalassign, missingret = {}, {}, {}, {}, {}
    for line in open(ERRLOG, encoding='utf-8', errors='replace'):
        line = line.rstrip('\n')
        m = NEVER.match(line)
        if m:
            never.setdefault(m.group('file'), set()).add(int(m.group('line')))
            continue
        m = UNREACH.match(line)
        if m:
            unreach.setdefault(m.group('file'), set()).add(int(m.group('line')))
            continue
        m = ASSIGNED.match(line)
        if m:
            assigned.setdefault(m.group('file'), set()).add((int(m.group('line')), m.group('name')))
            continue
        m = FINALASSIGN.match(line)
        if m:
            finalassign.setdefault(m.group('file'), set()).add((int(m.group('line')), m.group('name')))
            continue
        m = MISSINGRET.match(line)
        if m:
            missingret.setdefault(m.group('file'), set()).add(int(m.group('line')))

    stats = {'never': 0, 'unreach': 0, 'assigned': 0, 'finalassign': 0, 'missingret': 0}

    def load(path):
        if not os.path.isabs(path):
            path = os.path.join(ROOT, path)
        return path

    # --- unreachable statements ---------------------------------------------
    for path, linenos in unreach.items():
        path = load(path)
        if not os.path.exists(path):
            continue
        text = open(path, encoding='utf-8').read()
        masked = mask(text)
        blocks = build_blocks(masked)
        offsets = []
        pos = 0
        for ln in text.split('\n'):
            offsets.append(pos)
            pos += len(ln) + 1
        edits = []
        for lineno in sorted(linenos, reverse=True):
            off = offsets[lineno - 1]
            st = statement_start(masked, off)
            en = statement_end(masked, st)
            if en <= st:
                continue
            # never touch a class member: only statements inside a method body
            inner = None
            for b in blocks:
                if b['open'] <= st and (b['close'] is None or st < b['close']):
                    if b['scope'] and (inner is None or b['open'] > inner['open']):
                        inner = b
            if inner is None:
                continue
            edits.append((st, en, ''))
        if edits:
            out = text
            for s, e, new in sorted(edits, reverse=True):
                out = out[:s] + new + out[e:]
            open(path, 'w', encoding='utf-8').write(out)
            stats['unreach'] += len(edits)

    # --- final fields that are written twice --------------------------------
    for path, items in assigned.items():
        path = load(path)
        if not os.path.exists(path):
            continue
        text = open(path, encoding='utf-8').read()
        out = text
        for lineno, name in sorted(items):
            m = re.search(r'(?m)^([ \t]*)((?:public |private |protected |static |final )*)'
                          r'([A-Za-z_$][\w.$]*(?:<[^;]*>)?(?:\[\])*)[ \t]+' +
                          re.escape(name) + r'[ \t]*(?:=|;)', out)
            if not m:
                continue
            mods = m.group(2)
            if 'final' not in mods:
                continue
            newmods = mods.replace('final ', '', 1)
            out = out[:m.start(2)] + newmods + out[m.end(2):]
            stats['assigned'] += 1
        if out != text:
            open(path, 'w', encoding='utf-8').write(out)

    # --- "x = y = null" leftovers ------------------------------------------
    for path, items in finalassign.items():
        path = load(path)
        if not os.path.exists(path):
            continue
        text = open(path, encoding='utf-8').read()
        out = re.sub(r'(?m)^([ \t]*[A-Za-z_$][\w.$]*\s*=\s*[A-Za-z_$][\w.$]*) = null;$',
                     r'\1;', text)
        if out != text:
            open(path, 'w', encoding='utf-8').write(out)
            stats['finalassign'] += 1

    print(stats)
    return 0


if __name__ == '__main__':
    sys.exit(main())
