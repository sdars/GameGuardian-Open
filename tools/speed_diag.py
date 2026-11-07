#!/usr/bin/env python3
"""Diagnose the speed hack of the panel against a live target.

    python3 tools/speed_diag.py [package] [seconds]

The script attaches the panel of the app to the test bed, opens the row of
the floating icon, presses the button of the faster clock and watches:

    * the warp configuration of the injected library, byte by byte, before
      and after the press - that is what the daemon writes into the target
    * the clock of the test bed, to measure the factor that reached the app
    * the log of the daemon and the log of the target, to see the crash
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


def log(msg):
    print('    %s' % msg, flush=True)


def su(cmd, timeout=120):
    quoted = cmd.replace("'", "'\\''")
    return adlib.adb('shell', "su -c '%s'" % quoted, timeout=timeout).stdout


def daemon_pids():
    script = ('for p in /proc/[0-9]*; do if grep -qs lib5.so '
              '$p/maps 2>/dev/null; then echo ${p#/proc/}; fi; done')
    return [x for x in su(script).split() if x.isdigit()]


def density():
    out = adlib.sh('wm density').strip()
    m = re.search(r'Override density:\s*(\d+)', out) or \
        re.search(r'Physical density:\s*(\d+)', out) or re.search(r'(\d+)', out)
    return (int(m.group(1)) / 160.0) if m else 2.0


def cfg_bytes(pid):
    base = cfgdump.lib6_base(pid)
    if base is None:
        return None, None
    return base, cfgdump.read(pid, base + cfgdump.CONFIG_OFF, cfgdump.CONFIG_SIZE)


def diff_cfg(a, b):
    """the bytes that the daemon changed in the configuration"""
    out = []
    if not a or not b:
        return out
    for i in range(min(len(a), len(b))):
        if a[i] != b[i]:
            out.append((i, a[i], b[i]))
    return out


def describe(cfg):
    if not cfg:
        return 'no config'
    enabled = [i for i in range(0xB0) if cfg[i]]
    used = [i - 0xB8 for i in range(0xB8, 0x170) if cfg[i]]
    count = struct.unpack('<i', cfg[0x170:0x174])[0]
    recs = []
    for c in range(0, 4):
        off = c * 0x598 + 0x178
        num, den = struct.unpack('<ii', cfg[off:off + 8])
        recs.append((num, den))
    head = struct.unpack('<8i', cfg[0x170:0x190])
    return ('count=%d head=%s recs=%s enabled(%d)=%s used(%d)=%s'
            % (count, head, recs, len(enabled), enabled[:24],
               len(used), used[:24]))


def main():
    pkg = sys.argv[1] if len(sys.argv) > 1 else PROBE
    seconds = int(sys.argv[2]) if len(sys.argv) > 2 else 40
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
    inc = (row[0] + (row[2] - row[0]) - int(24 * d), (row[1] + row[3]) // 2)
    log('the button of the faster clock at %d,%d' % inc)

    base, before = cfg_bytes(pid)
    log('the config before the press: %s' % describe(before))

    fh = open('/tmp/speed_diag_daemon.log', 'wb')
    cap = subprocess.Popen([adlib.ADB, '-s', adlib.SERIAL, 'logcat', '-v',
                            'time', '-s', 'android-daemon:I'], stdout=fh,
                           stderr=subprocess.STDOUT)
    time.sleep(1)
    log('press the faster button')
    adlib.tap(*inc)
    started = time.time()
    after = None
    while time.time() - started < seconds:
        time.sleep(2)
        alive = su('pidof %s' % pkg).strip() or 'DEAD'
        base, cur = cfg_bytes(pid)
        if after is None and cur and any(cur[0x170:0x190]):
            after = cur
            log('the config after the press: %s' % describe(cur))
            d2 = diff_cfg(before, cur)
            log('changed bytes (%d): %s' % (len(d2), d2[:48]))
        log('alive=%-8s daemon=%-10s cfg=%s' % (
            alive, ','.join(daemon_pids()) or 'GONE', describe(cur)))
        if alive == 'DEAD':
            break
    cap.terminate()
    time.sleep(1)
    out = adlib.logcat()
    with open('/tmp/speed_diag_all.log', 'w') as f:
        f.write(out)
    samples = [(int(v), int(m), int(n)) for v, m, n in
               re.findall(r'CLOCK virtual=([0-9]+) mono=([0-9]+) native=([0-9]+)', out)]
    samples.sort(key=lambda s: s[1])
    if len(samples) > 1:
        v0, m0, n0 = samples[0]
        v1, m1, n1 = samples[-1]
        if n1 > n0:
            log('FACTOR %.4f  (%d samples, %d ms of hooked time, %d ms of real time)'
                % (float(n1 - n0) / float((m1 - m0) // 1000000), len(samples),
                   n1 - n0, (m1 - m0) // 1000000))
        if m1 > m0:
            log('ART clock grew %d ms in %d ms of real time (not hooked, factor %.4f)'
                % (v1 - v0, (m1 - m0) // 1000000,
                   (v1 - v0) * 1e6 / float(m1 - m0)))
    else:
        log('!! no clock samples')
    return 0


if __name__ == '__main__':
    sys.exit(main())
