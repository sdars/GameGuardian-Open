#!/usr/bin/env python3
"""Disassemble any architecture of the daemon.

    tools/mdis.py <file> <vaddr> [count]

The architecture is taken from the header of the file, the addresses that
are built by the code (adrp/add, movw/movt, rip relative loads) are shown
as a comment.
"""
import sys

from elftools.elf.elffile import ELFFile
from capstone import (Cs, CS_ARCH_ARM64, CS_ARCH_ARM, CS_ARCH_X86,
                      CS_MODE_ARM, CS_MODE_LITTLE_ENDIAN, CS_MODE_32, CS_MODE_64)
from capstone.arm64 import ARM64_OP_IMM, ARM64_OP_MEM, ARM64_OP_REG
from capstone.arm import ARM_OP_IMM, ARM_OP_MEM
from capstone.x86 import X86_OP_IMM, X86_OP_MEM


def arch_of(elf):
    m = elf['e_machine']
    if m == 'EM_AARCH64':
        return Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    if m == 'EM_ARM':
        return Cs(CS_ARCH_ARM, CS_MODE_ARM | CS_MODE_LITTLE_ENDIAN)
    if m == 'EM_386':
        return Cs(CS_ARCH_X86, CS_MODE_32 | CS_MODE_LITTLE_ENDIAN)
    return Cs(CS_ARCH_X86, CS_MODE_64 | CS_MODE_LITTLE_ENDIAN)


def off_of(elf, vaddr):
    for seg in elf.iter_segments():
        if seg['p_type'] == 'PT_LOAD' and seg['p_vaddr'] <= vaddr < seg['p_vaddr'] + seg['p_filesz']:
            return seg['p_offset'] + (vaddr - seg['p_vaddr'])
    return None


def main():
    path = sys.argv[1]
    start = int(sys.argv[2], 0)
    count = int(sys.argv[3]) if len(sys.argv) > 3 else 40
    data = open(path, 'rb').read()
    elf = ELFFile(open(path, 'rb'))
    md = arch_of(elf)
    md.detail = True
    off = off_of(elf, start)
    if off is None:
        print('no mapping for 0x%x' % start)
        return
    blob = data[off:off + count * 8]
    regs = {}
    for i in md.disasm(blob, start):
        ann = ''
        m = i.mnemonic
        ops = i.operands
        if md.arch == CS_ARCH_ARM64:
            if m == 'adrp' and len(ops) == 2:
                reg = [o for o in ops if o.type == ARM64_OP_REG]
                imm = [o for o in ops if o.type == ARM64_OP_IMM]
                if reg and imm:
                    regs[reg[0].reg] = imm[0].imm
            elif m == 'add' and len(ops) >= 3 and ops[1].type == ARM64_OP_REG \
                    and ops[2].type == ARM64_OP_IMM:
                got = regs.get(ops[1].reg)
                if got is not None:
                    regs[ops[0].reg] = got + ops[2].imm
                    ann = '  ; -> 0x%x' % regs[ops[0].reg]
            elif m in ('ldr', 'ldrb', 'str', 'strb', 'ldrh', 'strh') and ops:
                o = ops[-1]
                if o.type == ARM64_OP_MEM and o.mem.base in regs:
                    ann = '  ; [0x%x]' % (regs[o.mem.base] + o.mem.disp)
        elif md.arch == CS_ARCH_ARM:
            if m in ('movw', 'movt') and len(ops) >= 2:
                reg = ops[0].reg
                imm = ops[1].imm
                if m == 'movw':
                    regs[reg] = imm
                else:
                    regs[reg] = (regs.get(reg, 0) & 0xffff) | ((imm & 0xffff) << 16)
                ann = '  ; -> 0x%x' % regs[reg]
            elif m in ('ldr', 'ldrb', 'str', 'strb') and ops:
                o = ops[-1]
                if o.type == ARM_OP_MEM and o.mem.base in regs:
                    ann = '  ; [0x%x]' % (regs[o.mem.base] + o.mem.disp)
        else:
            if m == 'lea' and len(ops) == 2 and ops[1].type == X86_OP_MEM \
                    and ops[1].mem.base == 0 and ops[1].mem.index == 0:
                ann = '  ; -> 0x%x' % ops[1].mem.disp
            elif m in ('mov', 'cmp', 'test') and len(ops) == 2 and ops[1].type == X86_OP_IMM:
                ann = '  ; -> 0x%x' % ops[1].imm
            elif m in ('movzx', 'movsx', 'cmp', 'mov') and ops:
                o = ops[-1]
                if o.type == X86_OP_MEM and o.mem.base == 0 and o.mem.index == 0:
                    ann = '  ; [0x%x]' % o.mem.disp
        print('0x%x  %-8s %-40s%s' % (i.address, m, i.op_str, ann))


if __name__ == '__main__':
    main()

