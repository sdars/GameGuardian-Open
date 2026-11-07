#!/usr/bin/env python3
"""Reproduce the speed hack on the test bed and watch the target.

    python3 tools/spd.py [package] [seconds]

The script drives the real build on the phone: it brings the panel up,
attaches it to the test bed, turns the speed hack on and then watches the
target - the clock of the test bed, the log of the daemon and the state of
the target process.
"""
import os
import re
import subprocess
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402

ADB = adlib.ADB
PROBE = 'com.gg.freezeprobe'


def log(msg):
    print('    %s' % msg, flush=True)


def sh(cmd, timeout=120):
    return subprocess.run([ADB, 'shell', 'su', '-c', cmd],
                          capture_output=True, text=True, timeout=timeout).stdout


def daemon_pid():
    """the daemon renames its process, so it is found by its binary"""
    out = sh('ls -l /proc/*/exe 2>/dev/null')
    for line in out.splitlines():
        m = re.search(r'/proc/(\d+)/exe -> (.*lib5\.so)', line)
        if m:
            return int(m.group(1))
    return None


def target_pid(pkg):
    out = sh('pidof %s' % pkg).strip().split()
    return out[0] if out else None


def start_app():
    """start the app and press the start button so the panel appears"""
    adlib.sh('am start -n com.dwgibmeuyozjuswy/.MainActivity')
    time.sleep(8)
    for _ in range(4):
        xml = adlib.dump('sp', 'main')
        hit = False
        for n in adlib.nodes(xml):
            t = n['text'].strip()
            if t in ('忽略', 'Ignore', 'Skip') or 'SELinux' in t:
                adlib.tap(*adlib.centre(n))
                time.sleep(6)
                hit = True
                break
            if t in ('已阅读并同意', '同意并继续', '我同意'):
                adlib.tap(*adlib.centre(n))
                time.sleep(6)
                hit = True
                break
        if hit:
            continue
        for n in adlib.nodes(xml):
            if n['text'].strip() == '开始':
                log('press the start button')
                adlib.tap(*adlib.centre(n))
                time.sleep(8)
                hit = True
                break
        if hit:
            continue
        if adlib.find(xml, rid='hot_point_icon') or adlib.find(xml, rid='hot_frame'):
            return True
        time.sleep(2)
    return False


def attach(pkg, pid):
    """pick the target in the list of the processes of the panel"""
    xml = adlib.dump('sp', 'ov')
    icon = adlib.find(xml, rid='hot_point_icon') or adlib.find(xml, rid='hot_frame')
    if icon is None:
        app_icon = adlib.find(xml, rid='app_icon')
        if app_icon is not None:
            adlib.tap(*adlib.centre(app_icon))
            time.sleep(4)
            xml = adlib.dump('sp', 'ov2')
            icon = adlib.find(xml, rid='hot_point_icon') or adlib.find(xml, rid='hot_frame')
    if icon is None:
        log('!! no floating icon')
        for n in adlib.nodes(xml):
            if n['bounds'] and n['pkg'] != 'com.android.launcher3':
                log('   %-22s %-16s %s' % (n['rid'], n['cls'], n['bounds']))
        return False
    x, y = adlib.centre(icon)
    log('the floating icon at %d,%d' % (x, y))
    # a tap opens the panel, a long press opens the speed panel
    adlib.sh('input swipe %d %d %d %d 900' % (x, y, x, y))
    time.sleep(5)
    xml = adlib.dump('sp', 'panel')
    nm = adlib.find(xml, rid='app_name')
    log('the panel shows %r' % (nm['text'] if nm else '?'))
    if nm and ('[%s]' % pid) in nm['text']:
        return True
    # the picker of the processes
    for _ in range(3):
        xml = adlib.dump('sp', 'panel')
        row = None
        for n in adlib.nodes(xml):
            if ('[%s]' % pid) in n['text']:
                row = n
                break
        if row is not None:
            adlib.tap(*adlib.centre(row))
            time.sleep(6)
            break
        if adlib.find(xml, rid='select_dialog_listview'):
            adlib.sh('input swipe 360 1000 360 400 300')
            time.sleep(2)
        else:
            adlib.tap(48, 104)
            time.sleep(5)
    xml = adlib.dump('sp', 'panel2')
    nm = adlib.find(xml, rid='app_name')
    log('the panel shows %r' % (nm['text'] if nm else '?'))
    return nm is not None and ('[%s]' % pid) in nm['text']


def open_speed_panel():
    xml = adlib.dump('sp', 'ov')
    icon = adlib.find(xml, rid='hot_point_icon') or adlib.find(xml, rid='hot_frame')
    if icon is None:
        log('!! no floating icon')
        return None
    x, y = adlib.centre(icon)
    log('long press the icon at %d,%d' % (x, y))
    adlib.sh('input swipe %d %d %d %d 900' % (x, y, x, y))
    time.sleep(5)
    xml = adlib.dump('sp', 'speed')
    inc = adlib.find(xml, rid='speed_inc')
    if inc is None:
        log('!! the speed panel did not open')
        for n in adlib.nodes(xml):
            if n['bounds'] and n['pkg'] != 'com.android.launcher3':
                log('   %-22s %-16s %s' % (n['rid'], n['cls'], n['bounds']))
        return None
    return adlib.centre(inc)


def main():
    pkg = sys.argv[1] if len(sys.argv) > 1 else PROBE
    seconds = int(sys.argv[2]) if len(sys.argv) > 2 else 60
    adlib.sh('am start -n %s/.FreezeProbeActivity' % pkg)
    time.sleep(3)
    pid = target_pid(pkg)
    if not pid:
        log('!! the test bed does not run')
        return 1
    log('target %s pid %s' % (pkg, pid))
    adlib.sh('am broadcast -a com.gg.freezeprobe.MODE --es mode clock')
    if not start_app():
        log('!! the panel did not come up')
        return 1
    dp = daemon_pid()
    log('the daemon is %s' % dp)
    if not attach(pkg, pid):
        log('!! the attach failed')
        return 1
    time.sleep(4)
    pos = open_speed_panel()
    if pos is None:
        return 1
    adlib.logcat_clear()
    log('press the faster button at %d,%d' % pos)
    adlib.tap(*pos)
    started = time.time()
    while time.time() - started < seconds:
        time.sleep(5)
        alive = sh('pidof %s' % pkg).strip() or 'DEAD'
        tracer = sh('cat /proc/%s/status | grep TracerPid' % pid).strip()
        log('alive=%s %s' % (alive, ' '.join(tracer.split())))
        if alive == 'DEAD':
            break
    probe = adlib.logcat('GGFreezeProbe')
    clocks = re.findall(r'CLOCK virtual=([0-9]+) mono=([0-9]+)', probe)
    if len(clocks) > 1:
        v0, m0 = int(clocks[0][0]), int(clocks[0][1])
        v1, m1 = int(clocks[-1][0]), int(clocks[-1][1])
        if m1 > m0:
            log('FACTOR = %.3f' % ((v1 - v0) / float(m1 - m0)))
    else:
        log('!! no clock samples')
    out = adlib.logcat()
    with open('/tmp/spd_daemon.log', 'w') as fh:
        fh.write(out)
    keep = [l for l in out.splitlines()
            if 'android-daemon' in l or 'AndroidService' in l]
    for l in keep[-60:]:
        log(l[:200])
    return 0


if __name__ == '__main__':
    sys.exit(main())
