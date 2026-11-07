#!/usr/bin/env python3
"""Drive the speed hack of the panel and watch the target while it runs.

    python3 tools/speed_probe.py [package] [seconds]

The script presses the "faster" button of the floating panel, keeps the log
of the daemon and reads the warp configuration of the injected library out
of the target every second, so that the effect of the speed hack and the
state that the daemon wrote into the target can be seen side by side.
"""
import os
import re
import struct
import subprocess
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402
import cfgdump  # noqa: E402
import gg_attach  # noqa: E402

APP = gg_attach.APP
PROBE = 'com.gg.freezeprobe'
LOG = '/tmp/speed_probe_daemon.log'


def log(msg):
    print('    %s' % msg, flush=True)


def su(cmd, timeout=120):
    quoted = cmd.replace("'", "'\\''")
    return adlib.adb('shell', "su -c '%s'" % quoted, timeout=timeout).stdout


def daemon_pids():
    """the processes that run the daemon of the app"""
    script = ('for p in /proc/[0-9]*; do if grep -qs GG-cKrg/lib5.so '
              '$p/maps 2>/dev/null; then echo ${p#/proc/}; fi; done')
    out = su(script)
    return [x for x in out.split() if x.isdigit()]


def density():
    out = adlib.sh('wm density').strip()
    m = re.search(r'Override density:\s*(\d+)', out)
    if not m:
        m = re.search(r'Physical density:\s*(\d+)', out)
    if not m:
        m = re.search(r'(\d+)', out)
    if not m:
        return 2.0
    return int(m.group(1)) / 160.0


def icon_point(row):
    x1, y1, x2, y2 = row
    return (x1 + x2) // 2, (y1 + y2) // 2


def speed_inc_point(row, d):
    x1, y1, x2, y2 = row
    return x1 + (x2 - x1) - int(24 * d), (y1 + y2) // 2


def open_speed_panel():
    xml = adlib.dump('spd', 'panel')
    back = adlib.find(xml, rid='back_btn')
    if back is not None:
        log('close the panel with the button at %d,%d' % adlib.centre(back))
        adlib.tap(*adlib.centre(back))
        time.sleep(4)
    for _ in range(8):
        row = adlib.float_row(APP)
        if row is None:
            log('   (no floating icon)')
            time.sleep(3)
            continue
        if row[2] - row[0] > 200:
            log('the row of the icon is open: %s' % (row,))
            return row
        x, y = icon_point(row)
        log('the floating icon at %d,%d (row %s)' % (x, y, row))
        adlib.sh('input swipe %d %d %d %d 1200' % (x, y, x, y))
        time.sleep(4)
    return None


def start_capture():
    fh = open(LOG, 'wb')
    proc = subprocess.Popen(
        [adlib.ADB, '-s', adlib.SERIAL, 'logcat', '-v', 'time', '-s',
         'android-daemon:I'],
        stdout=fh, stderr=subprocess.STDOUT)
    return proc


def reader_state(pid):
    """the command byte of the reader thread of the injected library"""
    base = cfgdump.lib6_base(pid)
    if base is None:
        return None
    data = cfgdump.read(pid, base + 0x2f268, 0x10)
    if len(data) < 0x10:
        return None
    return struct.unpack('<IIII', data)


def warp_state(pid):
    """the warp configuration that the daemon wrote into the target"""
    base = cfgdump.lib6_base(pid)
    if base is None:
        return None
    cfg = cfgdump.read(pid, base + cfgdump.CONFIG_OFF, cfgdump.CONFIG_SIZE)
    if len(cfg) < cfgdump.CONFIG_SIZE:
        return None
    enabled = [i for i in range(0xB0) if cfg[i]]
    count = struct.unpack('<i', cfg[cfgdump.COUNT_OFF:cfgdump.COUNT_OFF + 4])[0]
    recs = []
    for c in range(0, 4):
        off = c * cfgdump.RECORD_STRIDE + cfgdump.RECORD_OFF
        num, den = struct.unpack('<ii', cfg[off:off + 8])
        if num or den:
            recs.append((c, num, den))
    return {'enabled': enabled, 'count': count, 'records': recs}


def main():
    pkg = sys.argv[1] if len(sys.argv) > 1 else PROBE
    seconds = int(sys.argv[2]) if len(sys.argv) > 2 else 45
    global APP
    if len(sys.argv) > 3:
        APP = sys.argv[3] if len(sys.argv) > 3 else gg_attach.detect_app()
    log('the app of the panel: %s' % APP)
    d = density()

    adlib.sh('am force-stop %s' % pkg)
    time.sleep(1)
    adlib.sh('am start -n %s/.FreezeProbeActivity' % pkg)
    time.sleep(4)
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

    row = open_speed_panel()
    if row is None:
        log('!! the buttons of the speed hack did not come up')
        return 1
    inc = speed_inc_point(row, d)
    log('the button of the faster clock at %d,%d' % inc)

    log('the daemon runs in %s' % (daemon_pids() or 'NO PROCESS'))
    capture = start_capture()
    time.sleep(1)
    log('press the faster button')
    adlib.tap(*inc)
    started = time.time()
    dead = False
    while time.time() - started < seconds:
        time.sleep(2)
        alive = su('pidof %s' % pkg).strip() or 'DEAD'
        dpids = daemon_pids()
        state = reader_state(pid)
        warp = warp_state(pid)
        log('alive=%-8s daemon=%-10s reader=%s warp=%s' % (
            alive, ','.join(dpids) or 'GONE', state, warp))
        if alive == 'DEAD':
            dead = True
            break
    capture.terminate()
    out = adlib.logcat()
    with open('/tmp/speed_probe_probe.log', 'w') as fh:
        fh.write(out)
    with open('/tmp/speed_probe_all.log', 'w') as fh:
        fh.write(out)
    samples = [(int(v), int(m)) for v, m in
                re.findall(r'CLOCK virtual=([0-9]+) mono=([0-9]+)', out)]
    samples.sort(key=lambda s: s[1])
    if len(samples) > 1:
        v0, m0 = samples[0]
        v1, m1 = samples[-1]
        if m1 > m0:
            log('FACTOR %.4f  (%d samples, %d ms of wall clock)'
                % ((v1 - v0) / float(m1 - m0), len(samples), (v1 - v0)))
    else:
        log('!! no clock samples')
    log('the target died: %s' % dead)
    return 0


if __name__ == '__main__':
    sys.exit(main())
