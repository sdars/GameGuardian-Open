#!/usr/bin/env python3
"""Print the C string that starts at a file offset of the daemon.

    tools/cstr.py <file> <offset> [<offset> ...]
"""
import sys


def main():
    path = sys.argv[1]
    data = open(path, 'rb').read()
    for arg in sys.argv[2:]:
        off = int(arg, 0)
        end = data.find(b'\x00', off)
        print('0x%x  %r' % (off, data[off:end].decode('latin1')))


if __name__ == '__main__':
    main()
