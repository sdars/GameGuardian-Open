#!/usr/bin/env python3
"""Find the places of a library that use an exported global through the GOT.

    tools/gotrefs.py <file> <got vaddr> [<got vaddr> ...]

The exported globals of the shared libraries of GameGuardian (the injected
lib6.so for example) are reached through the global offset table, so the
code loads the address of the symbol with one load from the GOT.
"""
import sys

from elftools.elf.elffile import ELFFile
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM
from capstone.arm64 import ARM64_OP_IMM, ARM64_OP_MEM, ARM64_OP_REG


def main():
    path = sys.argv[1]
    wanted = set(int(a, 0) for a in sys.argv[2:])
    data = open(path, 'rb').read()
    elf = ELFFile(open(path, 'rb'))
    text = elf.get_section_by_name('.text')
    blob = text.data()
    base = text['sh_addr']
    md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    md.detail = True
    md.skipdata = True
    regs = {}
    for i in md.disasm(blob, base):
        ops = i.operands
        m = i.mnemonic
        if m == 'adrp':
            reg = [o for o in ops if o.type == ARM64_OP_REG]
            imm = [o for o in ops if o.type == ARM64_OP_IMM]
            if reg and imm:
                regs[reg[0].reg] = imm[0].imm
        elif m == 'add' and len(ops) == 3 and ops[0].type == ARM64_OP_REG \
                and ops[1].type == ARM64_OP_REG and ops[2].type == ARM64_OP_IMM:
            got = regs.get(ops[1].reg)
            if got is not None:
                regs[ops[0].reg] = got + ops[2].imm
        for op in ops:
            if op.type != ARM64_OP_MEM:
                continue
            val = regs.get(op.mem.base)
            if val is None:
                continue
            if (val + op.mem.disp) in wanted:
                print('0x%x %-6s %-34s got=0x%x disp=%d'
                      % (i.address, m, i.op_str, val, op.mem.disp))


if __name__ == '__main__':
    main()
