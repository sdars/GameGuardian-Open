#!/usr/bin/env python3
"""Watch the warp object of the injected library while the speed hack runs.

    python3 tools/speed_watch.py [package] [seconds] [app]

The library that the daemon injects keeps one object per clock id.  The
object of CLOCK_MONOTONIC carries the factor that the daemon wrote into
the configuration and the virtual time that the hook has built up.  The
script reads that object out of the memory of the target while the panel
changes the speed, so that the effect of the speed hack can be measured
without a native test bed.
"""
import os
import re
import struct
import subprocess
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402
import gg_attach  # noqa: E402

APP = gg_attach.APP
PROBE = 'com.gg.freezeprobe'
TABLE = 0x25f80          # the table of the clock objects of the library


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
    addrs = [int(l.split('-')[0], 16) for l in out.splitlines() if 'lib6.so' in l]
    return min(addrs) if addrs else None


def clock_object(pid, clock=1):
    base = lib6_base(pid)
    if base is None:
        return None
    tab = mem(pid, base + TABLE, 12 * 8)
    if tab is None:
        return None
    obj = struct.unpack('<Q', tab[clock * 8:clock * 8 + 8])[0]
    data = mem(pid, obj, 0x50)
    if data is None:
        return None
    return {
        'obj': obj,
        'num': struct.unpack('<i', data[0x08:0x0c])[0],
        'den': struct.unpack('<i', data[0x0c:0x10])[0],
        'last': struct.unpack('<q', data[0x20:0x28])[0],
        'base': struct.unpack('<q', data[0x28:0x30])[0],
        'acc': struct.unpack('<q', data[0x30:0x38])[0],
        'index': struct.unpack('<i', data[0x38:0x3c])[0],
        'flag': data[0x18],
    }


def main():
    global APP
    pkg = sys.argv[1] if len(sys.argv) > 1 else PROBE
    seconds = int(sys.argv[2]) if len(sys.argv) > 2 else 60
    if len(sys.argv) > 3:
        APP = sys.argv[3] if len(sys.argv) > 3 else gg_attach.detect_app()
    log('the app of the panel: %s' % APP)

    adlib.sh('am force-stop %s' % pkg)
    time.sleep(1)
    adlib.sh('am start -n %s/.FreezeProbeActivity' % pkg)
    time.sleep(5)
    pid = su('pidof %s' % pkg).strip().split()
    pid = pid[0] if pid else None
    if not pid:
        log('!! the test bed does not run')
        return 1
    log('target %s pid %s' % (pkg, pid))
    adlib.sh('am broadcast -a com.gg.freezeprobe.MODE --es mode clock')
    time.sleep(2)

    if gg_attach.attach(pkg, pid, APP) != 0:
        log('!! the panel was not attached')
        return 1
    time.sleep(3)

    row = None
    for _ in range(8):
        xml = adlib.dump('spd', 'panel')
        back = adlib.find(xml, rid='back_btn')
        if back is not None:
            adlib.tap(*adlib.centre(back))
            time.sleep(4)
            continue
        row = adlib.float_row(APP)
        if row is None:
            time.sleep(3)
            continue
        if row[2] - row[0] > 200:
            break
        x, y = (row[0] + row[2]) // 2, (row[1] + row[3]) // 2
        adlib.sh('input swipe %d %d %d %d 1200' % (x, y, x, y))
        time.sleep(4)
    if row is None or row[2] - row[0] <= 200:
        log('!! the buttons of the speed hack did not come up')
        return 1
    d = 2.0
    inc = (row[0] + (row[2] - row[0]) - int(24 * d), (row[1] + row[3]) // 2)
    log('the button of the faster clock at %d,%d' % inc)

    press_at = 15
    started = time.time()
    prev = None
    pressed = False
    while time.time() - started < seconds:
        now = time.time() - started
        st = clock_object(pid)
        if st:
            line = ('t=%5.1f obj=0x%x flag=%d index=%3d num=%d den=%d base=%.3f acc=%d last=%.3f'
                    % (now, st['obj'], st['flag'], st['index'], st['num'], st['den'],
                       st['base'] / 1e9, st['acc'], st['last'] / 1e9))
            if prev:
                db = (st['base'] - prev['base']) / 1e9
                dl = (st['last'] - prev['last']) / 1e9
                line += '  dbase=%.3f dlast=%.3f' % (db, dl)
            log(line)
            prev = st
        if not pressed and now > press_at:
            log('press the faster button')
            adlib.tap(*inc)
            pressed = True
        time.sleep(3)
    return 0


if __name__ == '__main__':
    sys.exit(main())
