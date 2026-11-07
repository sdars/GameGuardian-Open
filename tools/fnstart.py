#!/usr/bin/env python3
"""Print the function prologue that encloses an address.

    tools/fnstart.py <file> <addr>
"""
import sys

from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM
from elftools.elf.elffile import ELFFile


def main():
    path = sys.argv[1]
    addr = int(sys.argv[2], 0)
    data = open(path, 'rb').read()
    elf = ELFFile(open(path, 'rb'))
    md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    md.detail = False
    md.skipdata = True
    text = None
    for seg in elf.iter_segments():
        if seg['p_type'] == 'PT_LOAD' and seg['p_flags'] & 1:
            text = seg
            break
    base = text['p_vaddr']
    blob = data[text['p_offset']:text['p_offset'] + text['p_filesz']]
    start = base
    ins = list(md.disasm(blob, base))
    for i, x in enumerate(ins):
        if x.address > addr:
            break
        if x.mnemonic == 'stp' and 'x29' in x.op_str and 'x30' in x.op_str and x.op_str.endswith(']!'):
            start = x.address
    print('function start 0x%x  (target 0x%x)' % (start, addr))
    for x in ins:
        if x.address >= start and x.address <= addr:
            print('%08x  %-8s %s' % (x.address, x.mnemonic, x.op_str))


main()
