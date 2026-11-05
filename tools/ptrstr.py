#!/usr/bin/env python3
"""Print the string a pointer in the daemon points to.

    tools/ptrstr.py <file> <offset> [<offset> ...]
"""
import struct
import sys


def main():
    path = sys.argv[1]
    data = open(path, 'rb').read()
    for arg in sys.argv[2:]:
        off = int(arg, 0)
        ptr = struct.unpack_from('<Q', data, off)[0]
        end = data.find(b'\x00', ptr)
        print('0x%x -> 0x%x  %r' % (off, ptr, data[ptr:end].decode('latin1')))


if __name__ == '__main__':
    main()
