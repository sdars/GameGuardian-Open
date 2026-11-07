#!/usr/bin/env python3
"""Read the flags of the daemon of the app out of its memory.

    python3 tools/dflags.py [count]

The daemon keeps the choice of its memory functions in the bss of its
process.  The script finds the daemon, reads the block of the flags and
prints it, so that the state of the daemon can be watched while it works.
"""
import os
import subprocess
import sys
import time

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'
SERIAL = '8.162.0.198:30138'
FLAG_BASE = 0x3f4b60
FLAG_SIZE = 0x30


def adb(*args, **kw):
    return subprocess.run([ADB, '-s', SERIAL] + list(args), capture_output=True,
                          text=True, timeout=kw.get('timeout', 90))


def sh(cmd, timeout=90):
    return adb('shell', cmd, timeout=timeout).stdout


def su(cmd, timeout=120):
    quoted = cmd.replace("'", "'\\''")
    return adb('shell', "su -c '%s'" % quoted, timeout=timeout).stdout


def daemon_pid():
    script = ('for p in /proc/[0-9]*; do if grep -qs GG-cKrg/lib5.so '
              '$p/maps 2>/dev/null; then echo ${p#/proc/}; fi; done')
    out = su(script)
    pids = [x for x in out.split() if x.isdigit()]
    return pids[0] if pids else None


def base_of(pid):
    out = su('head -1 /proc/%s/maps' % pid)
    line = out.strip().splitlines()
    if not line:
        return None
    return int(line[0].split('-')[0], 16)


def read(pid, addr, size):
    page = addr & ~0xfff
    off = addr - page
    want = size + off
    cmd = ('dd if=/proc/%s/mem bs=4096 skip=%d count=%d 2>/dev/null '
           '| od -A n -v -t x1' % (pid, page >> 12, (want + 4095) // 4096))
    out = su(cmd)
    hexs = ''.join(out.split())
    try:
        data = bytes.fromhex(hexs)
    except ValueError:
        return b''
    return data[off:off + size]


def main():
    count = int(sys.argv[1]) if len(sys.argv) > 1 else 1
    names = {0x05: 'flag65', 0x08: 'flag68', 0x0c: 'flag6c(read)',
             0x10: 'flag70(write)', 0x14: 'flag74'}
    for _ in range(count):
        pid = daemon_pid()
        if not pid:
            print('no daemon')
            return 1
        base = base_of(pid)
        if base is None:
            print('no base')
            return 1
        data = read(pid, base + FLAG_BASE, FLAG_SIZE)
        vals = []
        for i in range(len(data)):
            if data[i]:
                vals.append('0x%x=%d%s' % (FLAG_BASE + i, data[i],
                                           (' ' + names[i]) if i in names else ''))
        print('daemon %s base 0x%x: %s' % (pid, base, ' '.join(vals)))
        sys.stdout.flush()
        time.sleep(0.05)
    return 0


if __name__ == '__main__':
    sys.exit(main())

