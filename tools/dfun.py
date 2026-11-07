#!/usr/bin/env python3
"""Dump a code region of an aarch64 shared object.

    tools/dfun.py <file> <addr> [back_bytes] [fwd_bytes]
"""
import sys

from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM
from elftools.elf.elffile import ELFFile


def disasm_all(path, start, end):
    data = open(path, 'rb').read()
    elf = ELFFile(open(path, 'rb'))
    md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    md.detail = False
    md.skipdata = True
    off = None
    for seg in elf.iter_segments():
        if seg['p_type'] == 'PT_LOAD' and seg['p_vaddr'] <= start < seg['p_vaddr'] + seg['p_filesz']:
            off = seg['p_offset'] + (start - seg['p_vaddr'])
            break
    if off is None:
        return []
    return list(md.disasm(data[off:off + (end - start)], start))


def main():
    path = sys.argv[1]
    addr = int(sys.argv[2], 0)
    back = int(sys.argv[3], 0) if len(sys.argv) > 3 else 0x400
    fwd = int(sys.argv[4], 0) if len(sys.argv) > 4 else 0x400
    for x in disasm_all(path, addr - back, addr + fwd):
        mark = '>>' if x.address == addr else '  '
        print('%s %08x  %-8s %s' % (mark, x.address, x.mnemonic, x.op_str))


main()
