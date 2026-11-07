#!/usr/bin/env python3
"""Decode the opcode jump table of a daemon handler.

    tools/jtab.py <file> <table_addr> <base_addr> <first_opcode> <count>
"""
import struct
import sys

from elftools.elf.elffile import ELFFile


def main():
    path = sys.argv[1]
    taddr = int(sys.argv[2], 0)
    base = int(sys.argv[3], 0)
    first = int(sys.argv[4], 0)
    count = int(sys.argv[5], 0)
    data = open(path, 'rb').read()
    elf = ELFFile(open(path, 'rb'))
    off = None
    for seg in elf.iter_segments():
        if seg['p_type'] == 'PT_LOAD' and seg['p_vaddr'] <= taddr < seg['p_vaddr'] + seg['p_filesz']:
            off = seg['p_offset'] + (taddr - seg['p_vaddr'])
            break
    for i in range(count):
        (delta,) = struct.unpack_from('<h', data, off + i * 2)
        print('opcode %3d (0x%02x) -> 0x%08x' % (first + i, first + i, base + delta * 4))


main()
