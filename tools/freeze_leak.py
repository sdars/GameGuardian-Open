#!/usr/bin/env python3
"""Show that a frozen value survives the detach of its target.

    python3 tools/freeze_leak.py <package> <pid>

The script reads the table of the frozen values out of the memory of the
daemon of the panel, attaches the panel to another process and reads the
table again.  A value that is still in the table belongs to the process
that was detached - the daemon writes it into every process that is
attached later on.
"""
import subprocess
import sys
import time

sys.path.insert(0, '/root/gameguardian/tools')
import freeze_flow as ff  # noqa: E402

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'


def sh(cmd, timeout=120):
    return subprocess.run([ADB, 'shell', 'su', '-c', cmd],
                          capture_output=True, text=True, timeout=timeout).stdout


def daemon_pid():
    """the process of the daemon: a child of the app of the panel"""
    out = sh('ps -A -o PID,PPID,NAME 2>/dev/null')
    app = None
    for line in out.splitlines():
        if 'com.dwgibmeuyozjuswy' in line:
            app = int(line.split()[0])
            break
    for line in out.splitlines():
        parts = line.split()
        if len(parts) >= 3 and parts[1] == str(app) and parts[2].startswith('['):
            return app, int(parts[0])
    return app, None


def base_of(pid):
    """the load address of the daemon of the panel"""
    out = sh('cat /proc/%d/maps' % pid)
    for line in out.splitlines():
        if 'lib5.so' in line and 'r-xp' in line:
            return int(line.split('-')[0], 16)
    return None


def read(pid, addr, count):
    out = sh('dd if=/proc/%d/mem bs=1 skip=%d count=%d 2>/dev/null | xxd -p'
             % (pid, addr, count))
    try:
        return bytes.fromhex(''.join(out.split()))
    except ValueError:
        return b''


def table(pid, base):
    """the frozen values of the daemon: (address, value, length) of every row"""
    count = int.from_bytes(read(pid, base + 0x3ea7c0, 8), 'little')
    array = int.from_bytes(read(pid, base + 0x3ea7b0, 8), 'little')
    out = []
    for i in range(min(count, 16)):
        row = read(pid, array + i * 0x30, 0x30)
        if len(row) < 0x20:
            break
        addr = int.from_bytes(row[0:8], 'little')
        value = int.from_bytes(row[8:16], 'little')
        length = int.from_bytes(row[16:20], 'little')
        out.append((addr, value, length))
    return count, out


def main():
    pkg = sys.argv[1]
    pid = int(sys.argv[2])

    app, daemon = daemon_pid()
    print('the app of the panel is %s, the daemon is %s' % (app, daemon), flush=True)
    if daemon is None:
        print('!! the daemon of the panel was not found', flush=True)
        return 1
    base = base_of(daemon)
    print('the daemon is loaded at 0x%x' % base, flush=True)

    count, rows = table(daemon, base)
    print('the daemon holds %d frozen values' % count, flush=True)
    for a, v, l in rows:
        print('    address 0x%x value 0x%x length %d' % (a, v, l), flush=True)
    target = int.from_bytes(read(daemon, base + 0x3ea740, 4), 'little')
    print('the target of the daemon is %d' % target, flush=True)

    print('==> attach the panel to %s (%d)' % (pkg, pid), flush=True)
    if not ff.attach(pkg, pid):
        return 1
    time.sleep(5)

    count2, rows2 = table(daemon, base)
    print('the daemon holds %d frozen values now' % count2, flush=True)
    for a, v, l in rows2:
        print('    address 0x%x value 0x%x length %d' % (a, v, l), flush=True)
    target2 = int.from_bytes(read(daemon, base + 0x3ea740, 4), 'little')
    print('the target of the daemon is %d' % target2, flush=True)

    for a, v, l in rows2:
        if a == 0:
            continue
        mem = read(pid, a, 8)
        print('the memory of the new target at 0x%x is %s' % (a, mem.hex()), flush=True)
        print('the value of the frozen row was 0x%x' % v, flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())
