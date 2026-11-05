#!/usr/bin/env python3
"""Small helpers to look inside the native daemon of the app.

    tools/dasm.py strings <file> <substring>       - where is a string
    tools/dasm.py xrefs  <file> <file offset>       - who uses it
    tools/dasm.py disas  <file> <vaddr> [count]    - disassemble
"""
import sys

from elftools.elf.elffile import ELFFile
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM


def load(path):
    with open(path, 'rb') as fh:
        data = fh.read()
    fh = ELFFile(open(path, 'rb'))
    return data, fh


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


def strings(path, needle):
    data, elf = load(path)
    out = []
    start = 0
    while True:
        i = data.find(needle.encode(), start)
        if i < 0:
            break
        end = data.find(b'\x00', i)
        out.append((i, vaddr_of(elf, i), data[i:end].decode('latin1')))
        start = i + 1
    for off, va, s in out:
        print('0x%x 0x%x  %r' % (off, va or 0, s))


def disas(path, vaddr, count=80):
    data, elf = load(path)
    off = off_of(elf, vaddr)
    if off is None:
        print('no segment for 0x%x' % vaddr)
        return
    md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    md.detail = False
    for i, ins in enumerate(md.disasm(data[off:off + count * 4], vaddr)):
        print('%08x  %-10s %s' % (ins.address, ins.mnemonic, ins.op_str))
        if i > count:
            break


def xrefs(path, target_va):
    """find the adrp/add pairs that build target_va in the code"""
    data, elf = load(path)
    text = None
    for sec in elf.iter_sections():
        if sec['sh_flags'] & 2 and sec['sh_size'] > 0x1000:
            text = sec
            break
    if text is None:
        print('no text segment')
        return
    base = text['sh_addr']
    body = data[text['sh_offset']:text['sh_offset'] + text['sh_size']]
    md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
    md.detail = True
    md.skipdata = True
    import re
    insns = list(md.disasm(body, base))
    print('# %d instructions, text 0x%x-0x%x' % (len(insns), base, base + len(body)))
    pages = {}
    for i, ins in enumerate(insns):
        if ins.mnemonic == 'adrp':
            m = re.match(r'(x\d+), #(0x[0-9a-f]+)', ins.op_str)
            if m:
                pages[m.group(1)] = int(m.group(2), 16)
        else:
            m = re.match(r'(x\d+), (x\d+), #(0x[0-9a-f]+)', ins.op_str)
            if m and m.group(2) in pages:
                val = pages[m.group(2)] + int(m.group(3), 16)
                if val == target_va:
                    print('xref at 0x%x: %s %s' % (ins.address, ins.mnemonic, ins.op_str))
                    for j in range(max(0, i - 8), i + 1):
                        print('    %08x  %-8s %s' % (insns[j].address, insns[j].mnemonic, insns[j].op_str))


if __name__ == '__main__':
    cmd = sys.argv[1]
    if cmd == 'strings':
        strings(sys.argv[2], sys.argv[3])
    elif cmd == 'disas':
        disas(sys.argv[2], int(sys.argv[3], 0), int(sys.argv[4]) if len(sys.argv) > 4 else 80)
    elif cmd == 'xrefs':
        xrefs(sys.argv[2], int(sys.argv[3], 0))
