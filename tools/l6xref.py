import re, sys
sys.path.insert(0, '/root/gameguardian/tools')
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_ARM
from elftools.elf.elffile import ELFFile

path = sys.argv[1]
targets = set(int(a, 0) for a in sys.argv[2:])
data = open(path, 'rb').read()
elf = ELFFile(open(path, 'rb'))
md = Cs(CS_ARCH_ARM64, CS_MODE_ARM)
md.detail = False
md.skipdata = True

for seg in elf.iter_segments():
    if seg['p_type'] != 'PT_LOAD':
        continue
    if not (seg['p_flags'] & 1):
        continue
    vaddr = seg['p_vaddr']
    blob = data[seg['p_offset']:seg['p_offset'] + seg['p_filesz']]
    pages = {}
    for x in md.disasm(blob, vaddr):
        if x.mnemonic == 'adrp':
            m = re.match(r'(x\d+), #(0x[0-9a-f]+)', x.op_str)
            if m:
                pages.setdefault(m.group(1), []).append((x.address, int(m.group(2), 16)))
            continue
        m = re.match(r'(x\d+), (x\d+), #(0x[0-9a-f]+)', x.op_str)
        if not m:
            continue
        reg = m.group(2)
        if reg not in pages:
            continue
        adrp_addr, val = pages[reg][-1]
        full = val + int(m.group(3), 16)
        if full in targets:
            print('%08x  %-6s %s   (adrp at %08x)' % (x.address, x.mnemonic, x.op_str, adrp_addr))
