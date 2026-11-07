#!/usr/bin/env python3
"""Find the place of the daemon that reads a flag byte of its bss.

    tools/dispatch_scan.py <file> <flag address> [<flag address> ...]

The daemon keeps the choice between the ptrace and the process_vm_
implementation of its memory access in a few bytes of its bss.  The self
test of the daemon writes those bytes, the dispatcher of the memory access
reads them.  This script reports every place of the code that reads one of
them, with the code around it, so that the dispatcher can be found in every
architecture of the daemon.
"""
import sys
from collections import deque

from elftools.elf.elffile import ELFFile
from capstone import (Cs, CS_ARCH_ARM64, CS_MODE_ARM, CS_ARCH_X86,
                      CS_MODE_ARM, CS_MODE_LITTLE_ENDIAN, CS_MODE_32,
                      CS_MODE_64)
from capstone.arm64 import ARM64_OP_IMM, ARM64_OP_MEM, ARM64_OP_REG
from capstone.arm import ARM_OP_IMM, ARM_OP_MEM
from capstone.x86 import X86_OP_IMM, X86_OP_MEM

BACK = 18
FWD = 22


def md_of(elf):
    m = elf['e_machine']
    if m == 'EM_AARCH64':
        return Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    if m == 'EM_ARM':
        return Cs(CS_ARCH_ARM, CS_MODE_ARM | CS_MODE_LITTLE_ENDIAN)
    if m == 'EM_386':
        return Cs(CS_ARCH_X86, CS_MODE_32 | CS_MODE_LITTLE_ENDIAN)
    return Cs(CS_ARCH_X86, CS_MODE_64 | CS_MODE_LITTLE_ENDIAN)


def exec_blob(elf, data):
    text = elf.get_section_by_name('.text')
    if text is not None:
        return text.data(), text['sh_addr']
    for seg in elf.iter_segments():
        if seg['p_type'] == 'PT_LOAD' and seg['p_flags'] & 1:
            off = seg['p_offset']
            return data[off:off + seg['p_filesz']], seg['p_vaddr']
    return b'', 0


def literal(elf, data, where):
    for seg in elf.iter_segments():
        if seg['p_type'] == 'PT_LOAD' and seg['p_vaddr'] <= where < seg['p_vaddr'] + seg['p_filesz']:
            off = seg['p_offset'] + (where - seg['p_vaddr'])
            return int.from_bytes(data[off:off + 4], 'little')
    return None


def run(path, wanted):
    data = open(path, 'rb').read()
    elf = ELFFile(open(path, 'rb'))
    blob, base = exec_blob(elf, data)
    md = md_of(elf)
    md.detail = True
    md.skipdata = True
    regs = {}
    win = deque(maxlen=BACK + 1)
    pending = []
    for i in md.disasm(blob, base):
        m = i.mnemonic
        ops = i.operands
        addr = None
        if md.arch == CS_ARCH_ARM64:
            if m == 'adrp' and len(ops) == 2:
                reg = [o for o in ops if o.type == ARM64_OP_REG]
                imm = [o for o in ops if o.type == ARM64_OP_IMM]
                if reg and imm:
                    regs[reg[0].reg] = imm[0].imm
            elif m == 'add' and len(ops) == 3 and ops[1].type == ARM64_OP_REG and ops[2].type == ARM64_OP_IMM:
                got = regs.get(ops[1].reg)
                if got is not None:
                    regs[ops[0].reg] = got + ops[2].imm
            elif m in ('ldrb', 'ldrsb') and ops:
                o = ops[-1]
                if o.type == ARM64_OP_MEM and o.mem.base in regs:
                    addr = regs[o.mem.base] + o.mem.disp
        elif md.arch == CS_ARCH_ARM:
            if m in ('movw', 'movt') and len(ops) >= 2:
                reg = ops[0].reg
                if m == 'movw':
                    regs[reg] = ops[1].imm
                else:
                    regs[reg] = (regs.get(reg, 0) & 0xffff) | ((ops[1].imm & 0xffff) << 16)
            elif m == 'ldr' and len(ops) == 2 and ops[1].type == ARM_OP_MEM and ops[1].mem.base == 15:
                where = (i.address + 8 + ops[1].mem.disp) & ~3
                val = literal(elf, data, where)
                if val is not None:
                    regs[ops[0].reg] = val
            elif m == 'add' and len(ops) == 3 and ops[1].type == ARM_OP_REG:
                got = regs.get(ops[1].reg)
                if got is not None:
                    regs[ops[0].reg] = i.address + 8 + got
            elif m in ('ldrb', 'ldrsb') and ops:
                o = ops[-1]
                if o.type == ARM_OP_MEM and o.mem.base in regs:
                    addr = regs[o.mem.base] + o.mem.disp
        else:
            if m == 'lea' and len(ops) == 2 and ops[1].type == X86_OP_MEM and ops[1].mem.base == 0 and ops[1].mem.index == 0:
                regs[ops[0].reg] = i.address + i.size + ops[1].mem.disp
            elif m in ('movzx', 'movsx') and ops:
                o = ops[-1]
                if o.type == X86_OP_MEM and o.mem.base in regs:
                    addr = regs[o.mem.base] + o.mem.disp
        win.append(i)
        if addr is not None and addr in wanted:
            pending.append((list(win), addr, i.address))
            win = deque(maxlen=BACK + 1)
        if pending and len(pending[0][0]) < BACK + FWD:
            pass
    for before, addr, at in pending:
        print('=== the flag 0x%x is read at 0x%x ===' % (addr, at))
        for k in before:
            mark = '>>' if k.address == at else '  '
            print('%s %08x  %-8s %s' % (mark, k.address, k.mnemonic, k.op_str))
        print()


def main():
    path = sys.argv[1]
    wanted = set(int(a, 0) for a in sys.argv[2:])
    run(path, wanted)


if __name__ == '__main__':
    main()
