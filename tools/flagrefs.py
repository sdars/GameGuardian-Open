#!/usr/bin/env python3
"""Every place of the daemon that reads or writes one of the flag bytes.

    tools/flagrefs.py <file> <vaddr> [<vaddr> ...]
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
    prev = []
    count = 0
    for i in md.disasm(blob, base):
        count += 1
        ops = i.operands
        m = i.mnemonic
        if m == 'adrp' and len(ops) == 2:
            # capstone puts the destination register first for adrp
            reg = [o for o in ops if o.type == ARM64_OP_REG]
            imm = [o for o in ops if o.type == ARM64_OP_IMM]
            if reg and imm:
                regs[reg[0].reg] = imm[0].imm
        elif m == 'add' and len(ops) == 3 and ops[0].type == ARM64_OP_REG \
                and ops[1].type == ARM64_OP_REG and ops[2].type == ARM64_OP_IMM:
            got = regs.get(ops[1].reg)
            if got is not None:
                regs[ops[0].reg] = got + ops[2].imm
        prev.append((i.address, m, i.op_str))
        if len(prev) > 4:
            prev.pop(0)
        if m in ('strb', 'ldrb', 'str', 'ldr', 'ldrh', 'strh'):
            for op in ops:
                if op.type != ARM64_OP_MEM:
                    continue
                base_reg = op.mem.base
                val = regs.get(base_reg)
                if val is not None:
                    val += op.mem.disp
                if val in wanted:
                    print('0x%x  %-6s %-30s (target 0x%x)'
                          % (i.address, m, i.op_str, val))
                    for a, mm, oo in prev:
                        print('        0x%x %-6s %s' % (a, mm, oo))
    print('scanned %d instructions' % count)


if __name__ == '__main__':
    main()
