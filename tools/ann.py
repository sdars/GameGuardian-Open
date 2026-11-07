#!/usr/bin/env python3
"""Annotated disassembler: resolves ADRP/ADD pairs to static addresses.

    tools/ann.py <file> <vaddr> [count]
"""
import sys

from elftools.elf.elffile import ELFFile
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM
from capstone.arm64 import ARM64_OP_IMM


def load(path):
    data = open(path, 'rb').read()
    elf = ELFFile(open(path, 'rb'))
    return data, elf


def vaddr_of(elf, off):
    for seg in elf.iter_segments():
        if seg['p_type'] == 'PT_LOAD' and seg['p_offset'] <= off < seg['p_offset'] + seg['p_filesz']:
            return seg['p_vaddr'] + (off - seg['p_offset'])
    return None


def off_of(elf, vaddr):
    for seg in elf.iter_segments():
        if seg['p_type'] == 'PT_LOAD' and seg['p_vaddr'] <= vaddr < seg['p_vaddr'] + seg['p_filesz']:
            return seg['p_offset'] + (vaddr - seg['p_vaddr'])
    return None


def main():
    path = sys.argv[1]
    start = int(sys.argv[2], 0)
    count = int(sys.argv[3]) if len(sys.argv) > 3 else 40
    data, elf = load(path)
    off = off_of(elf, start)
    if off is None:
        print('no mapping for 0x%x' % start)
        return
    md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    md.detail = True
    blob = data[off:off + count * 4]
    regs = {}
    lines = []
    for i in md.disasm(blob, start):
        ann = ''
        m = i.mnemonic
        ops = i.operands
        if m == 'adrp' and len(ops) == 2 and ops[0].type == ARM64_OP_IMM:
            regs[ops[1].reg] = ops[0].imm
        elif m == 'add' and len(ops) >= 3 and ops[0].type == ARM64_OP_IMM:
            base = ops[1].reg
            if base in regs:
                val = regs[base] + ops[2].imm
                regs[ops[0].reg] = val
                ann = '  ; -> 0x%x' % val
        elif m == 'ldr' and len(ops) >= 2 and ops[1].type == ARM64_OP_IMM:
            if ops[1].imm in regs:
                ann = '  ; [0x%x]' % regs[ops[1].imm]
        lines.append('0x%x  %-8s %-40s%s' % (i.address, m, i.op_str, ann))
    print('\n'.join(lines))


if __name__ == '__main__':
    main()
