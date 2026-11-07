#!/usr/bin/env python3
"""Prove the speed hack of the panel against a real native target.

    python3 tools/speed_e2e.py <app package> <target pid> [seconds]

The script attaches the panel to the target, presses the button of the
faster clock and then reads the clock objects of the library that the
daemon injected into the target.  Every clock object holds the factor that
the hook of the clock uses and the virtual time that the hook has built up,
so the script shows both that the factor arrived and that the hook runs.
The script also watches the target: a target that dies while the clock is
sped up is the failure this test is about.
"""
import os
import struct
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402
import speed_panel_ab  # noqa: E402

TABLE = 0x25f80


def log(msg):
    print('    %s' % msg, flush=True)


def su(cmd, timeout=180):
    quoted = cmd.replace("'", "'\\''")
    return adlib.adb('shell', "su -c '%s'" % quoted, timeout=timeout).stdout


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
    return ('/proc/%s' % pid) in su('ls -d /proc/%s' % pid)


def tombstones():
    out = su('ls -t /data/tombstones 2>/dev/null | head -5')
    return [l.strip() for l in out.splitlines() if l.strip()]


def main():
    app = sys.argv[1]
    pid = sys.argv[2]
    seconds = int(sys.argv[3]) if len(sys.argv) > 3 else 120
    tag = 'e2e'

    keep = []
    for line in adlib.sh('ps -A -o PID,NAME', timeout=90).splitlines():
        parts = line.split()
        if len(parts) >= 2 and parts[0] == str(pid):
            keep.append(parts[1])
            break
    adlib.attach(tag, app, pid, keep=keep)
    xml = adlib.dump(tag, 'panel')
    btn = adlib.find(xml, rid='back_btn')
    if btn is not None:
        adlib.tap(*adlib.centre(btn))
        time.sleep(4)

    speed_panel_ab.PKG = app
    icon = None
    for _ in range(8):
        win = speed_panel_ab.windows()
        icon = speed_panel_ab.icon_window(win)
        if icon is not None:
            break
        time.sleep(4)
    if icon is None:
        log('!! no floating icon')
        return 1
    x1, y1, x2, y2 = icon[2]
    x, y = (x1 + x2) // 2, (y1 + y2) // 2
    log('the floating icon at %d,%d' % (x, y))
    adlib.sh('input swipe %d %d %d %d 1500' % (x, y, x, y))
    time.sleep(5)
    win = speed_panel_ab.windows()
    panel = speed_panel_ab.panel_window(win)
    if panel is None or panel[2][2] - panel[2][0] < 200:
        log('!! the speed panel did not open')
        return 1
    px1, py1, px2, py2 = panel[2]
    log('the speed panel is %s' % (panel[2],))
    log('press the button of the faster clock at %d,%d' % (px2 - 58, (py1 + py2) // 2))
    adlib.tap(px2 - 58, (py1 + py2) // 2)
    time.sleep(6)

    log('the clocks of the target: %s' % clocks(pid))
    first = None
    started = time.time()
    while time.time() - started < seconds:
        st = clocks(pid)
        acc = max([c[4] for c in st], default=0)
        if first is None:
            first = acc
        log('t=%5.1f  acc=%-6s  clocks=%s  alive=%s' % (
            time.time() - started, acc, st, alive(pid)))
        time.sleep(10)
    log('the tombstones of the device: %s' % tombstones())
    return 0


if __name__ == '__main__':
    sys.exit(main())
