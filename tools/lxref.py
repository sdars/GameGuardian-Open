#!/usr/bin/env python3
"""Find the places in a shared object that build the address of a symbol.

    tools/lxref.py <file> <vaddr> [<vaddr> ...] [--ctx N]

The object is stripped, so the only way to find the code that touches a
global is to look for the adrp / add (or movw / movt) pair that builds its
address.  Every hit is printed with the surrounding instructions.
"""
import re
import sys

from capstone import Cs, CS_ARCH_ARM64, CS_ARCH_ARM, CS_MODE_ARM, CS_MODE_LITTLE_ENDIAN

from mdis import arch_of, off_of
from elftools.elf.elffile import ELFFile


def load_code(path):
    data = open(path, 'rb').read()
    elf = ELFFile(open(path, 'rb'))
    md = arch_of(elf)
    md.detail = False
    md.skipdata = True
    text = None
    for seg in elf.iter_segments():
        if seg['p_type'] == 'PT_LOAD' and seg['p_flags'] & 1:
            text = seg
            break
    blob = data[text['p_offset']:text['p_offset'] + text['p_filesz']]
    return md, blob, text['p_vaddr'], text['p_filesz']


def main():
    path = sys.argv[1]
    ctx = 10
    args = sys.argv[2:]
    if '--ctx' in args:
        i = args.index('--ctx')
        ctx = int(args[i + 1])
        del args[i:i + 2]
    targets = set(int(a, 0) for a in args)
    md, blob, base, size = load_code(path)
    insns = list(md.disasm(blob, base))
    pages = {}
    hits = []
    for i, x in enumerate(insns):
        if md.arch == CS_ARCH_ARM64:
            m = re.match(r'(x\d+), #(0x[0-9a-f]+)', x.op_str)
            if x.mnemonic == 'adrp' and m:
                pages.setdefault(m.group(1), []).append((x.address, int(m.group(2), 16)))
                continue
            m = re.match(r'(x\d+), (x\d+), #(0x[0-9a-f]+)', x.op_str)
            if not m:
                continue
            reg = m.group(2)
            if reg not in pages:
                continue
            adrp_addr, val = pages[reg][-1]
            if adrp_addr + 4 != x.address:
                continue
            addr = val + int(m.group(3), 16)
        elif md.arch == CS_ARCH_ARM:
            m = re.match(r'(r\d+), #(0x[0-9a-f]+)', x.op_str)
            if x.mnemonic == 'movw' and m:
                pages.setdefault(m.group(1), []).append((x.address, int(m.group(2), 16)))
                continue
            m = re.match(r'(r\d+), (r\d+), #(0x[0-9a-f]+)', x.op_str)
            if not m:
                continue
            reg = m.group(2)
            if reg not in pages:
                continue
            adrp_addr, val = pages[reg][-1]
            addr = val + int(m.group(3), 16)
        else:
            continue
        if addr in targets:
            hits.append((i, addr))
    for i, addr in hits:
        print('== xref to 0x%x at 0x%x' % (addr, insns[i].address))
        for j in range(max(0, i - ctx), min(len(insns), i + ctx + 1)):
            mark = '>>' if j == i else '  '
            print('  %s %08x  %-8s %s' % (mark, insns[j].address,
                                         insns[j].mnemonic, insns[j].op_str))


if __name__ == '__main__':
    sys.exit(main())
