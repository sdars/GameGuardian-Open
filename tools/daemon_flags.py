#!/usr/bin/env python3
"""Find the places in the daemon of the app that use a flag of its bss.

    tools/daemon_flags.py <file> <flag vaddr> [more flags]

The daemon keeps its state in the bss of the process.  The flags are read
and written with an adrp/add pair that builds the address of the flag, so
the script scans the code of the daemon for those pairs and prints every
place that touches the flag together with the adrp that belongs to it.
"""
import re
import sys

from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM


def instructions(data, end):
    md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    md.detail = False
    md.skipdata = True
    return list(md.disasm(data[0:end], 0))


def recent(pages, reg):
    """the adrp instructions of a register that are still in reach

    Only the last few adrp instructions of a register can build the
    address of a flag - the pair adrp/add is a few bytes long - so the
    list of the pages of a register stays short.
    """
    return pages.get(reg, [])[-4:]


def main():
    path = sys.argv[1]
    flags = set(int(a, 0) for a in sys.argv[2:])
    data = open(path, 'rb').read()
    end = 0x3e0c60
    ins = instructions(data, end)
    pages = {}
    hits = {}
    for x in ins:
        if x.mnemonic == 'adrp':
            m = re.match(r'(x\d+), #(0x[0-9a-f]+)', x.op_str)
            if m:
                pages.setdefault(m.group(1), []).append(
                    (x.address, int(m.group(2), 16)))
            continue
        m = re.search(r'\[x(\d+)(?:, #0x([0-9a-f]+))?\]', x.op_str)
        if not m:
            continue
        reg = 'x' + m.group(1)
        off = int(m.group(2) or '0', 16)
        for adrp_addr, val in recent(pages, reg):
            a = val + off
            if a in flags:
                hits.setdefault(a, []).append(
                    (x.address, x.mnemonic, x.op_str, adrp_addr))
    for a in sorted(hits):
        print('== flag 0x%x' % a)
        for e in hits[a]:
            print('   %08x  %-6s %-34s adrp 0x%x' % e)


if __name__ == '__main__':
    main()
