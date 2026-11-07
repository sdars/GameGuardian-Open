#!/usr/bin/env python3
"""List the eor instructions of the code part of a shared object.

    tools/eorscan.py <file> <code_start> <code_end>
"""
import sys

from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM
from elftools.elf.elffile import ELFFile


def main():
    path = sys.argv[1]
    lo = int(sys.argv[2], 0)
    hi = int(sys.argv[3], 0)
    data = open(path, 'rb').read()
    elf = ELFFile(open(path, 'rb'))
    md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    md.detail = False
    md.skipdata = True
    off = None
    for seg in elf.iter_segments():
        if seg['p_type'] == 'PT_LOAD' and seg['p_vaddr'] <= lo < seg['p_vaddr'] + seg['p_filesz']:
            off = seg['p_offset'] + (lo - seg['p_vaddr'])
            break
    if off is None:
        print('no mapping')
        return
    blob = data[off:off + (hi - lo)]
    for x in md.disasm(blob, lo):
        if x.mnemonic == 'eor':
            print('%08x  %-8s %s' % (x.address, x.mnemonic, x.op_str))


main()
