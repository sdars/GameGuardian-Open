#!/usr/bin/env python3
"""Read the warp objects of the injected library out of a target.

    python3 tools/lib6obj.py [package]

The library that the daemon injects into the target keeps one object per
hooked function.  Every object holds the factor that the hook applies:
the numerator is at the offset 8, the denominator at the offset 0xc and
the index of the timer at the offset 0x38.  The script finds those
objects in the memory of the target and prints them, so that the factor
that really reached the hook can be seen.
"""
import struct
import subprocess
import sys

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'
SERIAL = '8.162.0.198:30138'
VT_RANGE = (0x25d80, 0x25f00)


def sh(cmd, timeout=120):
    p = subprocess.run([ADB, '-s', SERIAL, 'shell', 'su', '-c', cmd],
                       capture_output=True, text=True, timeout=timeout,
                       errors='replace')
    return p.stdout


def main():
    pkg = sys.argv[1] if len(sys.argv) > 1 else 'com.gg.freezeprobe'
    pid = sh('pidof %s' % pkg).strip().split()
    if not pid:
        print('the target %s does not run' % pkg)
        return 1
    pid = pid[0]
    segs = []
    base = None
    for line in sh('cat /proc/%s/maps' % pid).splitlines():
        if 'lib6.so' not in line:
            continue
        parts = line.split()
        a, b = parts[0].split('-')
        segs.append((int(a, 16), int(b, 16), parts[1]))
        s = int(a, 16)
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

    lo = base + VT_RANGE[0]
    hi = base + VT_RANGE[1]
    print('target %s pid %s lib6 base 0x%x' % (pkg, pid, base))
    found = 0
    for a, b, perm in segs:
        if 'x' in perm:
            continue
        data = read(a, b - a)
        for off in range(0, max(0, len(data) - 8), 8):
            v = struct.unpack('<Q', data[off:off + 8])[0]
            if not (lo <= v < hi):
                continue
            obj = a + off
            d = read(obj, 0x60)
            if len(d) < 0x50:
                continue
            num = struct.unpack('<i', d[8:12])[0]
            den = struct.unpack('<i', d[12:16])[0]
            index = struct.unpack('<i', d[0x38:0x3c])[0]
            flag = d[0x18]
            print('  object 0x%-12x vtable 0x%x  num=%d den=%d index=%d flag=%d'
                  % (obj, v, num, den, index, flag))
            found += 1
    if not found:
        print('  no warp object found')
    return 0


if __name__ == '__main__':
    sys.exit(main())

