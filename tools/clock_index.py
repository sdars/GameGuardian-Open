#!/usr/bin/env python3
"""Find the timer of the clock in the configuration of the target.

    python3 tools/clock_index.py <package> [original clock_gettime]

The daemon saves the original function of every timer in the configuration
of the injected library, at the offset 0x1020 of the slot of the timer.
The script reads those slots and reports the timer whose original
function is the clock of the system, together with the state of the
flags of that timer: the flag at the offset 0 says if the timer is
switched on and the byte at the offset 0xb8 says if the hook of the
timer was called.
"""
import struct
import subprocess
import sys

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'
SERIAL = '8.162.0.198:30138'
CONFIG_OFF = 0x2b7d0


def sh(cmd, timeout=120):
    p = subprocess.run([ADB, '-s', SERIAL, 'shell', 'su', '-c', cmd],
                       capture_output=True, text=True, timeout=timeout,
                       errors='replace')
    return p.stdout


def main():
    pkg = sys.argv[1] if len(sys.argv) > 1 else 'com.gg.freezeprobe'
    want = int(sys.argv[2], 0) if len(sys.argv) > 2 else None
    pid = sh('pidof %s' % pkg).strip().split()
    if not pid:
        print('the target %s does not run' % pkg)
        return 1
    pid = pid[0]
    base = None
    for line in sh('cat /proc/%s/maps' % pid).splitlines():
        if 'lib6.so' in line:
            s = int(line.split('-')[0], 16)
            if base is None or s < base:
                base = s
    if base is None:
        print('the target %s has no lib6.so' % pkg)
        return 1

    def read(addr, n):
        page = addr & ~0xfff
        off = addr - page
        out = sh('dd if=/proc/%s/mem bs=4096 skip=%d count=%d 2>/dev/null'
                ' | od -A n -v -t x1' % (pid, page >> 12, (n + off + 4095) // 4096))
        h = ''.join(out.split())
        try:
            d = bytes.fromhex(h)
        except ValueError:
            return b''
        return d[off:off + n]

    cfg = read(base + CONFIG_OFF, 4920)
    print('target %s pid %s lib6 base 0x%x' % (pkg, pid, base))
    count = struct.unpack('<i', cfg[0x170:0x174])[0]
    print('  the count of the records: %d' % count)
    for i in range(4):
        o = 0x178 + i * 0x598
        if o + 0x10 > len(cfg):
            break
        num = struct.unpack('<i', cfg[o:o + 4])[0]
        den = struct.unpack('<i', cfg[o + 8:o + 12])[0]
        print('  record %d: num=%d den=%d' % (i, num, den))
    hits = []
    for i in range(99):
        o = 0x1020 + i * 8
        if o + 8 > len(cfg):
            break
        v = struct.unpack('<Q', cfg[o:o + 8])[0]
        if v and (want is None or v == want):
            on = cfg[i]
            used = cfg[0xb8 + i] if 0xb8 + i < len(cfg) else 0
            hits.append((i, v, on, used))
    for i, v, on, used in hits:
        print('  timer %3d: the original is 0x%x  switched on=%d  called=%d'
              % (i, v, on, used))
    if not hits:
        print('  no timer with a saved function')
    return 0


if __name__ == '__main__':
    sys.exit(main())

