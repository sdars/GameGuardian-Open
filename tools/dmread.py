#!/usr/bin/env python3
"""Read a slice of the memory of the daemon of the app on the device.

    tools/dmread.py <vaddr> <size> [count]

The daemon renames its process, so it is found by the link of its binary
(/proc/<pid>/exe).  It is a position independent executable, so the runtime
address of a vaddr of the file is the load base of the process plus the
vaddr.  The load base is the start of the first mapping of the file.
"""
import re
import subprocess
import sys

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'


def sh(cmd, timeout=120):
    p = subprocess.run([ADB, 'shell', 'su', '-c', cmd],
                       capture_output=True, text=True, timeout=timeout,
                       errors='replace')
    return p.stdout + p.stderr


def daemon_pid():
    """the daemon renames its process, so it is found by its binary"""
    out = sh('ls -l /proc/*/exe 2>/dev/null')
    for line in out.splitlines():
        m = re.search(r'/proc/(\d+)/exe -> (.*lib5\.so)', line)
        if m:
            return int(m.group(1))
    raise SystemExit('the daemon does not run')


def base_of(pid):
    """the load base of the daemon: the start of its first mapping"""
    out = sh('cat /proc/%d/maps' % pid)
    best = None
    for line in out.splitlines():
        m = re.match(r'([0-9a-f]+)-([0-9a-f]+)\s', line)
        if not m:
            continue
        if 'lib5.so' not in line:
            continue
        start = int(m.group(1), 16)
        if best is None or start < best:
            best = start
    return best


def read(pid, addr, size):
    """read size bytes at addr out of /proc/<pid>/mem"""
    page = addr & ~0xfff
    off = addr - page
    want = size + off
    cmd = ('dd if=/proc/%d/mem bs=4096 skip=%d count=%d 2>/dev/null '
           '| od -A n -v -t x1' % (pid, page >> 12, (want + 4095) // 4096))
    out = sh(cmd)
    data = bytes.fromhex(''.join(out.split()))
    return data[off:off + size]


def main():
    va = int(sys.argv[1], 0)
    size = int(sys.argv[2], 0) if len(sys.argv) > 2 else 16
    count = int(sys.argv[3], 0) if len(sys.argv) > 3 else 1
    pid = daemon_pid()
    base = base_of(pid)
    print('pid %d base 0x%x' % (pid, base))
    for i in range(count):
        v = va + i * size
        addr = base + v
        data = read(pid, addr, size)
        print('0x%x -> 0x%x  %s' % (v, addr, ' '.join('%02x' % b for b in data)))


if __name__ == '__main__':
    main()
