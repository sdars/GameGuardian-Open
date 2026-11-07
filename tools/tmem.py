#!/usr/bin/env python3
"""Read and write the memory of a process on the device.

    tools/tmem.py read <pid> <addr> <size>
    tools/tmem.py maps <pid>
    tools/tmem.py write <pid> <addr> <hex bytes>

The device has a root shell, so /proc/<pid>/mem can be read and written.
The helper is used to look at the state that the daemon writes into the
target: the warp configuration of the injected library, the hook points
and the values of the frozen list.
"""
import subprocess
import sys

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'


def sh(cmd, timeout=120):
    p = subprocess.run([ADB, 'shell', 'su', '-c', cmd],
                       capture_output=True, text=True, timeout=timeout,
                       errors='replace')
    return p.stdout + p.stderr


def read(pid, addr, size):
    page = addr & ~0xfff
    off = addr - page
    want = size + off
    cmd = ('dd if=/proc/%d/mem bs=4096 skip=%d count=%d 2>/dev/null '
           '| od -A n -v -t x1' % (pid, page >> 12, (want + 4095) // 4096))
    out = sh(cmd)
    hexs = ''.join(c for c in out.split() if len(c) == 2)
    try:
        data = bytes.fromhex(hexs)
    except ValueError:
        return b''
    return data[off:off + size]


def write(pid, addr, data):
    # the helper writes through a temporary file: the shell of the device
    # has no way to push raw bytes into dd
    sh('printf %s > /data/local/tmp/.tmem.bin' % ''.join('\\x%s' % b for b in data))
    cmd = ('dd if=/data/local/tmp/.tmem.bin of=/proc/%d/mem bs=1 seek=%d '
           'conv=notrunc 2>&1' % (pid, addr))
    return sh(cmd)


def main():
    what = sys.argv[1]
    if what == 'maps':
        print(sh('cat /proc/%s/maps' % sys.argv[2]))
        return 0
    pid = int(sys.argv[2])
    addr = int(sys.argv[3], 0)
    if what == 'read':
        size = int(sys.argv[4], 0)
        data = read(pid, addr, size)
        print('%d bytes at 0x%x of pid %d' % (len(data), addr, pid))
        for i in range(0, len(data), 16):
            chunk = data[i:i + 16]
            print('%08x  %s' % (addr + i, ' '.join('%02x' % b for b in chunk)))
        return 0
    if what == 'write':
        data = bytes.fromhex(sys.argv[4].replace(' ', ''))
        print(write(pid, addr, data))
        return 0
    print('unknown command')
    return 1


if __name__ == '__main__':
    sys.exit(main())
