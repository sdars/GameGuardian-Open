#!/usr/bin/env python3
"""Read the warp configuration of the injected library out of a target.

    python3 tools/cfgdump.py <package>

The daemon injects lib6.so into the target and writes the speed into the
'_config' structure of that library (the symbol is exported, the daemon
looks it up in the symbol table of the file it injects).  This tool reads
that structure out of the memory of the target and prints what the daemon
wrote into it.
"""
import struct
import subprocess
import sys

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'

CONFIG_OFF = 0x2b7d0          # the symbol _config of lib6.so
CONFIG_SIZE = 4920
RECORD_STRIDE = 0x598
COUNT_OFF = 0x170
RECORD_OFF = 0x178


def sh(cmd, timeout=120):
    p = subprocess.run([ADB, 'shell', 'su', '-c', cmd],
                       capture_output=True, text=True, timeout=timeout,
                       errors='replace')
    return p.stdout + p.stderr


def target_pid(pkg):
    out = sh('pidof %s' % pkg).strip().split()
    return out[0] if out else None


def lib6_base(pid):
    """the load base of the injected library

    The library is mapped in three pieces: the code (r-xp), the read only
    data (r--p) and the data (rw-p).  The base of the object is the start
    of the first of them, so the lowest address of the file wins.
    """
    out = sh('cat /proc/%s/maps' % pid)
    best = None
    for line in out.splitlines():
        if 'lib6.so' in line:
            start = int(line.split('-')[0], 16)
            if best is None or start < best:
                best = start
    return best


def read(pid, addr, size):
    page = addr & ~0xfff
    off = addr - page
    want = size + off
    cmd = ('dd if=/proc/%s/mem bs=4096 skip=%d count=%d 2>/dev/null '
           '| od -A n -v -t x1' % (pid, page >> 12, (want + 4095) // 4096))
    out = sh(cmd)
    hexs = ''.join(out.split())
    try:
        data = bytes.fromhex(hexs)
    except ValueError:
        return b''
    return data[off:off + size]


def main():
    pkg = sys.argv[1] if len(sys.argv) > 1 else 'com.gg.freezeprobe'
    pid = target_pid(pkg)
    if not pid:
        print('the target %s does not run' % pkg)
        return 1
    base = lib6_base(pid)
    if base is None:
        print('the target %s has no lib6.so' % pkg)
        return 1
    cfg = read(pid, base + CONFIG_OFF, CONFIG_SIZE)
    if len(cfg) < CONFIG_SIZE:
        print('cannot read the config of %s (pid %s)' % (pkg, pid))
        return 1
    print('target %s pid %s lib6 base 0x%x' % (pkg, pid, base))
    enabled = [i for i in range(0xB0) if cfg[i]]
    print('  enabled flags   : %s' % (enabled,))
    used = [i for i in range(0xB8, 0x170) if cfg[i]]
    print('  used flags      : %s' % ([i - 0xB8 for i in used],))
    count = struct.unpack('<i', cfg[COUNT_OFF:COUNT_OFF + 4])[0]
    print('  count           : %d' % count)
    for c in range(0, 4):
        off = c * RECORD_STRIDE + RECORD_OFF
        if off + 0x20 > CONFIG_SIZE:
            break
        num, den = struct.unpack('<ii', cfg[off:off + 8])
        slots = []
        for i in range(0, 0x176):
            v = struct.unpack('<q', cfg[off + 0x10 + i * 8:off + 0x18 + i * 8])[0]
            if v:
                slots.append((i, v))
        print('  record %d        : num=%d den=%d slots=%s'
              % (c, num, den, slots[:8]))
    return 0


if __name__ == '__main__':
    sys.exit(main())
