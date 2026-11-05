#!/usr/bin/env python3
"""Find the call sites of the functions inside a range of the daemon.

    tools/bfind.py <file> <lo> <hi>

It prints every ``bl`` in the binary whose target is inside the range.
"""
import struct
import sys


def main():
    path, lo, hi = sys.argv[1], int(sys.argv[2], 0), int(sys.argv[3], 0)
    data = open(path, 'rb').read()
    words = struct.unpack('<%dI' % (len(data) // 4), data[:len(data) // 4 * 4])
    for idx, w in enumerate(words):
        if w & 0xFC000000 == 0x94000000:
            off = w & 0x3FFFFFF
            if off & 0x2000000:
                off -= 0x4000000
            target = (idx * 4 + (off << 2)) & 0xFFFFFFFF
            if lo <= target < hi:
                print('0x%x -> 0x%x' % (idx * 4, target))


if __name__ == '__main__':
    main()
