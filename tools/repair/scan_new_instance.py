#!/usr/bin/env python3
"""Report the methods whose "new-instance" register is shuffled.

The dex code allocates an object with

    new-instance v2, Landroid/ext/z1$d;
    ...
    invoke-direct {v14 .. v21}, Landroid/ext/z1$d;-><init>(...)V

The register that holds the new object is not always the register the
constructor is called on - here the object is moved into v14 first.  The
java translation of tools/repair/smali_to_java.py builds the object at the
position of the constructor call, so every register that was filled with the
new object before that call has to receive it as well.  A register that is
left behind keeps the "null" of the new-instance and the reconstruction
then adds a null to a list where the original dex adds the object.

This script lists every method of the original dex that uses the pattern.

    python3 tools/repair/scan_new_instance.py [smali-root]
"""
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import smali_to_java as S  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))


def groups_of(m):
    """Return {instruction index: [registers]} for every <init> call."""
    pending = {}
    members = {}
    res = {}
    for i, (op, args) in enumerate(m.insns):
        if op == 'new-instance':
            reg = S.regnum(args[0], m)
            pending[reg] = reg
            members.setdefault(reg, [reg])
            continue
        if op in ('move-object', 'move-object/from16', 'move-object/16'):
            dst = S.regnum(args[0], m)
            src = S.regnum(args[1], m)
            if src in pending:
                g = pending[src]
                pending[dst] = g
                if dst not in members[g]:
                    members[g].append(dst)
            else:
                pending.pop(dst, None)
            continue
        if op.startswith('invoke-direct') and '<init>' in args[-1]:
            regs = S.reglist(args[0], m)
            if regs:
                g = pending.get(regs[0])
                if g is not None:
                    res[i] = members[g]
                    for r in members[g]:
                        pending.pop(r, None)
            continue
        for (r, _k) in S.defs_of(op, args, m):
            pending.pop(r, None)
    return res


def reads_after(m, index, reg):
    """True when the register is read by an instruction after index."""
    for op, args in m.insns[index + 1:]:
        if op.startswith('invoke-') or op.startswith('filled-new-array'):
            regs = S.reglist(args[0], m)
            if reg in regs[1:]:
                return True
            continue
        defined = set(r for (r, _k) in S.defs_of(op, args, m))
        if reg in defined:
            continue
        if op in ('move', 'move/from16', 'move/16', 'move-wide', 'move-wide/from16',
                  'move-wide/16', 'move-object', 'move-object/from16',
                  'move-object/16'):
            if S.regnum(args[1], m) == reg:
                return True
            continue
        for tok in args:
            if isinstance(tok, str) and tok.startswith('v'):
                try:
                    if S.regnum(tok, m) == reg:
                        return True
                except Exception:  # noqa: BLE001
                    continue
    return False


def method_signatures(text):
    out = []
    for block in text.split('.method ')[1:]:
        sig = block.split(chr(10), 1)[0].strip()
        if sig:
            out.append((sig.split()[-1], block))
    return out


def main(argv):
    root = argv[1] if len(argv) > 1 else os.path.join(
        ROOT, 'build', 'puresrc', 'original')
    hits = 0
    tmp = os.path.join(ROOT, 'build', 'scan_new_instance.smali')
    os.makedirs(os.path.dirname(tmp), exist_ok=True)
    for dirpath, _dirs, names in os.walk(root):
        for name in sorted(names):
            if not name.endswith('.smali'):
                continue
            path = os.path.join(dirpath, name)
            with open(path, encoding='utf-8', errors='replace') as fh:
                text = fh.read()
            cls = ''
            for line in text.split(chr(10)):
                if line.startswith('.class '):
                    cls = line
                    break
            for sig, block in method_signatures(text):
                with open(tmp, 'w', encoding='utf-8') as fh:
                    fh.write(cls + chr(10) + '.method ' + block)
                try:
                    m = S.parse(tmp, sig)
                except Exception as exc:  # noqa: BLE001
                    print('?? %s %s: %s' % (name, sig, exc))
                    continue
                for i, regs in groups_of(m).items():
                    if len(regs) > 1 and reads_after(m, i, regs[0]):
                        hits += 1
                        names_ = ', '.join('v%d' % r for r in regs)
                        rel = os.path.relpath(path, ROOT)
                        print('%s: %s -> registers %s' % (rel, sig, names_))
    print('==> %d method(s) with a shuffled new-instance' % hits)
    return 0


if __name__ == '__main__':
    sys.exit(main(sys.argv))
