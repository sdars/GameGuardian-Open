#!/usr/bin/env python3
"""Scan an aarch64 binary for the adrp/add pairs that build an address.

    tools/dref.py <file> <address> [<address> ...]
"""
import struct
import sys


def sx(value, bits):
    if value & (1 << (bits - 1)):
        value -= 1 << bits
    return value


def main():
    path = sys.argv[1]
    targets = set(int(x, 0) for x in sys.argv[2:])
    data = open(path, 'rb').read()
    words = struct.unpack('<%dI' % (len(data) // 4), data[:len(data) // 4 * 4])
    pages = {}
    for idx, w in enumerate(words):
        addr = idx * 4
        if (w & 0x9F000000) == 0x90000000:
            immlo = (w >> 29) & 3
            immhi = (w >> 5) & 0x7FFFF
            imm = sx((immhi << 2) | immlo, 21)
            rd = w & 0x1F
            pages[rd] = ((addr & ~0xFFF) + (imm << 12)) & 0xFFFFFFFFFFFFFFFF
            continue
        if (w & 0x7F800000) == 0x11000000 and (w & 0x20000000) == 0:
            rn = (w >> 5) & 0x1F
            imm12 = (w >> 10) & 0xFFF
            shift = (w >> 22) & 3
            val = imm12 << (12 if shift == 1 else 0)
            rd = w & 0x1F
            if rn in pages:
                full = (pages[rn] + val) & 0xFFFFFFFFFFFFFFFF
                if full in targets:
                    print('0x%x: add -> 0x%x (adrp at 0x%x)' % (addr, full, addr - 4))
        if (w & 0x3B000000) == 0x39000000:
            rn = (w >> 5) & 0x1F
            imm12 = (w >> 10) & 0xFFF
            for scale in (1, 8):
                if rn in pages:
                    full = (pages[rn] + imm12 * scale) & 0xFFFFFFFFFFFFFFFF
                    if full in targets:
                        print('0x%x: ldr -> 0x%x (adrp at 0x%x)' % (addr, full, addr - 4))


if __name__ == '__main__':
    main()
