#!/usr/bin/env python3
"""End to end test of the speed hack of the panel.

    python3 tools/speed_test.py [package] [seconds]

The script starts the test bed, attaches the panel of the app to it, opens
the row of the floating icon with a long press, presses the button of the
faster clock and watches the target while the speed hack is on:

    * the log of the daemon shows what the daemon does with the request
    * the warp configuration of the injected library shows what the daemon
      wrote into the target
    * the clock of the test bed shows the effect on the target
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
DAEMON_LOG = '/tmp/speed_test_daemon.log'


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


def start_capture():
    fh = open(DAEMON_LOG, 'wb')
    proc = subprocess.Popen(
        [adlib.ADB, '-s', adlib.SERIAL, 'logcat', '-v', 'time', '-s',
         'android-daemon:I'],
        stdout=fh, stderr=subprocess.STDOUT)
    return proc


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
    rd = cfgdump.read(pid, base + 0x2f268, 0x10)
    reader = struct.unpack('<IIII', rd) if len(rd) >= 0x10 else None
    return {'enabled': enabled, 'count': count, 'records': recs,
            'reader': reader}


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

    # the row of the floating icon carries the two buttons of the speed hack
    row = None
    for _ in range(8):
        xml = adlib.dump('spd', 'panel')
        back = adlib.find(xml, rid='back_btn')
        if back is not None:
            log('close the panel with the button at %d,%d' % adlib.centre(back))
            adlib.tap(*adlib.centre(back))
            time.sleep(4)
            continue
        row = adlib.float_row(APP)
        if row is None:
            log('   (no floating icon)')
            time.sleep(3)
            continue
        if row[2] - row[0] > 200:
            break
        x, y = (row[0] + row[2]) // 2, (row[1] + row[3]) // 2
        log('the floating icon at %d,%d' % (x, y))
        adlib.sh('input swipe %d %d %d %d 1200' % (x, y, x, y))
        time.sleep(4)
    if row is None or row[2] - row[0] <= 200:
        log('!! the buttons of the speed hack did not come up')
        return 1
    log('the row of the icon is open: %s' % (row,))
    inc = (row[0] + (row[2] - row[0]) - int(24 * d), (row[1] + row[3]) // 2)
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
        state = warp_state(pid)
        log('alive=%-8s daemon=%-10s warp=%s' % (
            alive, ','.join(dpids) or 'GONE', state))
        if alive == 'DEAD':
            dead = True
            break
    capture.terminate()
    time.sleep(1)
    out = adlib.logcat()
    with open('/tmp/speed_test_all.log', 'w') as fh:
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
    log('the log of the daemon: %s' % DAEMON_LOG)
    return 0


if __name__ == '__main__':
    sys.exit(main())
