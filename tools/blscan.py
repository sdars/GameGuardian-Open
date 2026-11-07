#!/usr/bin/env python3
"""List the call sites of a set of functions in an aarch64 shared object.

    tools/blscan.py <file> <addr> [<addr> ...]
"""
import re
import sys

from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM
from elftools.elf.elffile import ELFFile


def main():
    path = sys.argv[1]
    targets = set(int(a, 0) for a in sys.argv[2:])
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
    blob = data[text['p_offset']:text['p_offset'] + text['p_filesz']]
    for x in md.disasm(blob, text['p_vaddr']):
        if x.mnemonic == 'bl':
            m = re.match(r'#(0x[0-9a-f]+)', x.op_str)
            if m and int(m.group(1), 16) in targets:
                print('%08x  bl #%s' % (x.address, m.group(1)))


main()
