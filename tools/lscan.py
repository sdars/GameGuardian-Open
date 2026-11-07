#!/usr/bin/env python3
"""Scan a shared object for instructions that touch a global table.

    tools/lscan.py <file> <mnemonic> <op-regex>

It prints every matching instruction together with the instructions that
built the address it uses, so the layout of a structure in the object can
be read off the disassembly.
"""
import re
import sys

from capstone import Cs
from elftools.elf.elffile import ELFFile

from mdis import arch_of


def main():
    path = sys.argv[1]
    mnemonic = sys.argv[2]
    pattern = re.compile(sys.argv[3])
    ctx = int(sys.argv[4]) if len(sys.argv) > 4 else 8
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
    insns = list(md.disasm(blob, text['p_vaddr']))
    for i, x in enumerate(insns):
        if x.mnemonic == mnemonic and pattern.search(x.op_str):
            for j in range(max(0, i - ctx), min(len(insns), i + ctx + 1)):
                mark = '>>' if j == i else '  '
                print('%s %08x  %-8s %s' % (mark, insns[j].address,
                                           insns[j].mnemonic, insns[j].op_str))
            print('========')


if __name__ == '__main__':
    sys.exit(main())
