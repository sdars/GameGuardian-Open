#!/usr/bin/env python3
"""Measure the speed hack of the panel against a native target.

    python3 tools/native_speed.py <package> [seconds] [steps]

The target of the test is an app that carries its own native libraries.
The daemon installs the hook of the clock into the libraries of the target
and writes the factor into the configuration of the injected library.
The script attaches the panel to the target, presses the button of the
faster clock of the floating icon and then reads the clock object of the
injected library out of the memory of the target: the object holds the
factor that the hook uses and the virtual time that the hook has built up,
so the script can prove that the hook runs and that the factor is the one
of the panel.
"""
import os
import struct
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402
import gg_ui  # noqa: E402

APP = ''
TABLE = 0x25f80


def log(msg):
    print('    %s' % msg, flush=True)


def su(cmd, timeout=180):
    return gg_ui.su(cmd, timeout=timeout)


def mem(pid, addr, size):
    out = su('dd if=/proc/%s/mem bs=1 skip=%d count=%d 2>/dev/null | od -A n -v -t x1'
             % (pid, addr, size))
    hexs = out.split()
    if len(hexs) < size:
        return None
    return bytes(int(x, 16) for x in hexs)


def lib6_base(pid):
    out = su('cat /proc/%s/maps' % pid)
    libs = [l for l in out.splitlines() if 'lib6.so' in l]
    return min(int(l.split('-')[0], 16) for l in libs) if libs else None


def clocks(pid):
    """the clock objects of the injected library of the target"""
    base = lib6_base(pid)
    if base is None:
        return []
    tab = mem(pid, base + TABLE, 16 * 8)
    if tab is None:
        return []
    out = []
    for i in range(16):
        obj = struct.unpack('<Q', tab[i * 8:i * 8 + 8])[0]
        if not obj:
            continue
        d = mem(pid, obj, 0x40)
        if d is None:
            continue
        num, den = struct.unpack('<ii', d[0x08:0x10])
        acc = struct.unpack('<q', d[0x30:0x38])[0]
        index = struct.unpack('<i', d[0x38:0x3c])[0]
        if num != 1 or den != 1 or acc:
            out.append((i, index, num, den, acc))
    return out


def alive(pid):
    out = su('ls -d /proc/%s' % pid)
    return ('/proc/%s' % pid) in out


def main():
    global APP
    pkg = sys.argv[1] if len(sys.argv) > 1 else 'bin.mt.plus.canary'
    seconds = int(sys.argv[2]) if len(sys.argv) > 2 else 60
    steps = int(sys.argv[3]) if len(sys.argv) > 3 else 1
    APP = sys.argv[4] if len(sys.argv) > 4 else gg_ui.detect_app()
    log('the app of the panel: %s' % APP)
    pid = su('pidof %s' % pkg).strip().split()
    pid = pid[0] if pid else None
    if not pid:
        log('!! the target %s does not run' % pkg)
        return 1
    log('the native target is %s, pid %s' % (pkg, pid))

    if not gg_ui.select_process(APP, pid):
        log('!! the panel was not attached')
        return 1
    time.sleep(4)
    log('the clocks before the speed hack: %s' % clocks(pid))

    if not gg_ui.speed_step(APP, steps):
        return 1
    time.sleep(3)
    log('the clocks right after the speed hack: %s' % clocks(pid))

    started = time.time()
    while time.time() - started < seconds:
        now = time.time() - started
        st = clocks(pid)
        log('t=%5.1f  hooks=%s  alive=%s' % (now, st, alive(pid)))
        time.sleep(5)
    return 0


if __name__ == '__main__':
    sys.exit(main())
