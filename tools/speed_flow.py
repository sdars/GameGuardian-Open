#!/usr/bin/env python3
"""Put the speed hack of the panel on a live target and measure it.

    python3 tools/speed_flow.py [package] [steps]

The script starts the test bed, attaches the panel of the app to it, turns
the speed hack on and reads the factor of the speed hack out of the log of
the test bed.
"""
import os
import re
import subprocess
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402
import freeze_flow as ff  # noqa: E402

ADB = adlib.ADB
PROBE = 'com.gg.freezeprobe'


def log(msg):
    print('    %s' % msg, flush=True)


def shell(cmd, timeout=120):
    return subprocess.run([ADB, 'shell', 'su', '-c', cmd],
                          capture_output=True, text=True, timeout=timeout).stdout


def daemon_pid():
    """the daemon renames its process, so it is found by its binary"""
    out = shell('ls -l /proc/*/exe 2>/dev/null')
    for line in out.splitlines():
        m = re.search(r'/proc/(\d+)/exe -> (.*lib5\.so)', line)
        if m:
            return int(m.group(1))
    return None


def main():
    pkg = sys.argv[1] if len(sys.argv) > 1 else PROBE
    steps = int(sys.argv[2]) if len(sys.argv) > 2 else 3
    adlib.sh('am start -n %s/.FreezeProbeActivity' % pkg)
    time.sleep(3)
    pid = shell('pidof %s' % pkg).strip().split()
    if not pid:
        print('!! the test bed does not run', flush=True)
        return 1
    pid = pid[0]
    log('target %s pid %s' % (pkg, pid))
    adlib.sh('am broadcast -a com.gg.freezeprobe.MODE --es mode clock')
    adlib.sh('am start -n com.dwgibmeuyozjuswy/.MainActivity')
    for _ in range(20):
        time.sleep(2)
        if daemon_pid():
            break
    log('daemon pid %s' % daemon_pid())
    if not ff.attach(pkg, pid):
        print('!! the attach failed', flush=True)
        return 1
    adlib.logcat_clear()
    xml = adlib.dump('sp', 'overlay')
    icon = adlib.find(xml, rid='hot_point_icon') or adlib.find(xml, rid='hot_frame')
    if icon is None:
        print('!! no floating icon', flush=True)
        for n in adlib.nodes(xml):
            if n['bounds'] and n['pkg'] != 'com.android.launcher3':
                log('%-24s %s' % (n['rid'], n['bounds']))
        return 1
    x, y = adlib.centre(icon)
    log('long press the icon at %d,%d' % (x, y))
    adlib.sh('input swipe %d %d %d %d 900' % (x, y, x, y))
    time.sleep(5)
    xml = adlib.dump('sp', 'panel')
    inc = adlib.find(xml, rid='speed_inc')
    if inc is None:
        print('!! the speed panel did not open', flush=True)
        for n in adlib.nodes(xml):
            if n['bounds'] and n['pkg'] != 'com.android.launcher3':
                log('%-24s %s' % (n['rid'], n['bounds']))
        return 1
    x, y = adlib.centre(inc)
    for i in range(steps):
        log('press the faster button at %d,%d' % (x, y))
        adlib.tap(x, y)
        time.sleep(3)
    time.sleep(20)
    probe = adlib.logcat('GGFreezeProbe')
    with open('/tmp/speed_probe.log', 'w') as fh:
        fh.write(probe)
    clocks = re.findall(r'CLOCK virtual=([0-9]+) mono=([0-9]+)', probe)
    if len(clocks) < 2:
        log('the test bed did not report the clock: %d samples' % len(clocks))
    else:
        v0, m0 = int(clocks[0][0]), int(clocks[0][1])
        v1, m1 = int(clocks[-1][0]), int(clocks[-1][1])
        log('virtual %d -> %d, mono %d -> %d' % (v0, v1, m0, m1))
        if m1 > m0:
            log('FACTOR = %.3f' % ((v1 - v0) / float(m1 - m0)))
    daemon = adlib.logcat()
    with open('/tmp/speed_daemon.log', 'w') as fh:
        fh.write(daemon)
    keep = [l for l in daemon.splitlines()
            if 'android-daemon' in l and ('hook' in l or 'used' in l or 'error' in l
                                         or 'Error' in l or 'Send code' in l or 'fail' in l)]
    log('the daemon says:')
    for l in keep[-40:]:
        log(l)
    return 0


if __name__ == '__main__':
    sys.exit(main())
