#!/usr/bin/env python3
"""Find the offsets of a pointer value inside a file.

    tools/findptr.py <file> <addr> [size]
"""
import struct
import sys


def main():
    path = sys.argv[1]
    addr = int(sys.argv[2], 0)
    size = int(sys.argv[3], 0) if len(sys.argv) > 3 else 8
    data = open(path, 'rb').read()
    needle = addr.to_bytes(size, 'little')
    pos = 0
    while True:
        i = data.find(needle, pos)
        if i < 0:
            break
        print('file offset 0x%x' % i)
        pos = i + 1


main()
