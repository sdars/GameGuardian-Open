#!/usr/bin/env python3
"""Find every place in the daemon that builds the address of a string.

    tools/xref.py <file> <vaddr> [<vaddr> ...]

The daemon is a stripped ELF, so the only way to find the code that uses a
string is to look for the adrp / add pair that builds its address.
"""
import re
import sys

from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM

from dasm import load


def main():
    path = sys.argv[1]
    targets = set(int(a, 0) for a in sys.argv[2:])
    data, elf = load(path)
    md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    md.detail = False
    md.skipdata = True
    insns = list(md.disasm(data[0:0x3e0c60], 0))
    pages = {}
    for i, x in enumerate(insns):
        if x.mnemonic == 'adrp':
            m = re.match(r'(x\d+), #(0x[0-9a-f]+)', x.op_str)
            if m:
                key = m.group(1)
                val = int(m.group(2), 16)
                pages.setdefault(key, []).append((x.address, val))
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
        if addr not in targets:
            continue
        print('== xref to 0x%x at 0x%x' % (addr, x.address))
        for j in range(max(0, i - 6), min(len(insns), i + 14)):
            mark = '>>' if j == i else '  '
            print('  %s %08x  %-8s %s' % (mark, insns[j].address,
                                         insns[j].mnemonic, insns[j].op_str))


if __name__ == '__main__':
    sys.exit(main())
