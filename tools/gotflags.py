#!/usr/bin/env python3
"""Find the places of the daemon that read or write a flag of its bss
through the table of the global variables.

    tools/gotflags.py <file>

The flags of the daemon are global variables, the code reaches them through
the table of the global variables (the got).  The script reports every
place that loads such a pointer and reads or writes a byte through it.
"""
import sys

from elftools.elf.elffile import ELFFile
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM
from capstone.arm64 import ARM64_OP_IMM, ARM64_OP_MEM, ARM64_OP_REG

GOT_PAGE = 0x3e5000


def main():
    path = sys.argv[1]
    data = open(path, 'rb').read()
    elf = ELFFile(open(path, 'rb'))
    text = elf.get_section_by_name('.text')
    blob = text.data()
    base = text['sh_addr']
    md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    md.detail = True
    md.skipdata = True
    got = {}        # register -> the slot of the got it holds
    pages = {}      # register -> the page an adrp built
    for i in md.disasm(blob, base):
        m = i.mnemonic
        ops = i.operands
        if m == 'adrp' and len(ops) == 2:
            reg = [o for o in ops if o.type == ARM64_OP_REG]
            imm = [o for o in ops if o.type == ARM64_OP_IMM]
            if reg and imm:
                pages[reg[0].reg] = imm[0].imm
            continue
        if m == 'ldr' and len(ops) >= 2 and ops[0].type == ARM64_OP_REG:
            mem = ops[1]
            if mem.type == ARM64_OP_MEM and mem.mem.disp and mem.mem.base in pages:
                if pages[mem.mem.base] == GOT_PAGE:
                    got[ops[0].reg] = GOT_PAGE + mem.mem.disp
            continue
        if m in ('strb', 'ldrb', 'strh', 'ldrh') and ops:
            mem = ops[-1]
            if mem.type == ARM64_OP_MEM and mem.mem.base in got:
                print('0x%x  %-6s %-34s got 0x%x' % (i.address, m,
                      i.op_str, got[mem.mem.base]))
                print('        value %s' % i.op_str)
    return 0


if __name__ == '__main__':
    sys.exit(main())
