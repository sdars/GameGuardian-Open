#!/usr/bin/env python3
"""Drive the speed hack of the panel against a live target and measure it.

    python3 tools/speed_run.py [package] [seconds]

The panel of the app is a floating window, uiautomator does not dump the
overlays of another application, so the row of the floating icon is found in
``dumpsys window``.  The row holds the icon and, after a long press, the two
buttons of the speed hack.  The geometry of the row is known from the layout
of the app (``res/layout/hot_point_view.xml``):

    [speed_dec 48dp + 10dp][hot_frame 48dp][10dp + speed_inc 48dp]

so the icon sits in the middle of the row and the button of the faster clock
is the last 48dp of the row.

The test bed of the freeze (``com.gg.freezeprobe``) prints the clock of its
own process every second, the ratio of the growth of that clock to the growth
of the real time of the device is the factor of the speed hack.
"""
import os
import re
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402
import gg_attach  # noqa: E402

APP = gg_attach.APP
PROBE = 'com.gg.freezeprobe'


def log(msg):
    print('    %s' % msg, flush=True)


def su(cmd, timeout=120):
    quoted = cmd.replace("'", "'\\''")
    return adlib.adb('shell', "su -c '%s'" % quoted, timeout=timeout).stdout


def target_pid(pkg):
    out = su('pidof %s' % pkg).strip()
    return out.split()[0] if out else None


def density():
    """the scale of the screen: the layout of the row is measured in dp"""
    out = adlib.sh('wm density').strip()
    # the app runs with the density that the device is set to, the physical
    # density of the panel is the other one
    m = re.search(r'Override density:\s*(\d+)', out)
    if not m:
        m = re.search(r'Physical density:\s*(\d+)', out)
    if not m:
        m = re.search(r'(\d+)', out)
    if not m:
        return 2.0
    return int(m.group(1)) / 160.0


def hot_row(pkg):
    """the frame of the row of the floating icon

    The row is the window of the app in the top left corner that is not
    hidden, see ``adlib.float_row``.
    """
    return adlib.float_row(pkg)


def icon_point(row):
    x1, y1, x2, y2 = row
    return (x1 + x2) // 2, (y1 + y2) // 2


def speed_inc_point(row, d):
    x1, y1, x2, y2 = row
    return x1 + (x2 - x1) - int(24 * d), (y1 + y2) // 2


def open_speed_panel(d):
    """the buttons of the speed hack open with a long press on the icon"""
    # the row of the icon only exists while the panel of the app is closed,
    # the button in the corner of the panel closes it
    xml = adlib.dump('spd', 'panel')
    back = adlib.find(xml, rid='back_btn')
    if back is not None:
        log('close the panel with the button at %d,%d' % adlib.centre(back))
        adlib.tap(*adlib.centre(back))
        time.sleep(4)
    for _ in range(6):
        row = hot_row(APP)
        if row is None:
            log('   (no floating icon)')
            time.sleep(3)
            continue
        wide = row[2] - row[0]
        if wide > 200:
            log('the row of the icon is open: %s' % (row,))
            return row
        x, y = icon_point(row)
        log('the floating icon at %d,%d (row %s)' % (x, y, row))
        adlib.sh('input swipe %d %d %d %d 1200' % (x, y, x, y))
        time.sleep(4)
    return None


def clock_samples():
    out = adlib.logcat('GGFreezeProbe')
    return re.findall(r'CLOCK virtual=([0-9]+) mono=([0-9]+)', out)


def dismiss_dialogs():
    """the panel of the app reports the crash of a target with a dialog"""
    for _ in range(3):
        xml = adlib.dump('spd', 'dlg')
        node = None
        for n in adlib.nodes(xml):
            if n['text'].strip() in ('确定', 'OK') and n['bounds']:
                node = n
                break
        if node is None:
            return
        log('close the dialog of the crash report')
        adlib.tap(*adlib.centre(node))
        time.sleep(4)


def main():
    pkg = sys.argv[1] if len(sys.argv) > 1 else PROBE
    seconds = int(sys.argv[2]) if len(sys.argv) > 2 else 45
    global APP
    if len(sys.argv) > 3:
        APP = sys.argv[3] if len(sys.argv) > 3 else gg_attach.detect_app()
    log('the app of the panel: %s' % APP)
    d = density()
    log('the scale of the screen is %.2f' % d)

    adlib.sh('am force-stop %s' % pkg)
    time.sleep(1)
    adlib.sh('am start -n %s/.FreezeProbeActivity' % pkg)
    time.sleep(4)
    pid = target_pid(pkg)
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
    dismiss_dialogs()

    row = open_speed_panel(d)
    if row is None:
        log('!! the buttons of the speed hack did not come up')
        return 1
    inc = speed_inc_point(row, d)
    log('the button of the faster clock at %d,%d' % inc)

    adlib.logcat_clear()
    before = clock_samples()
    log('press the faster button')
    adlib.tap(*inc)
    started = time.time()
    dead = False
    seen = set()
    while time.time() - started < seconds:
        for _ in range(25):
            time.sleep(0.2)
            tracer = su('cat /proc/%s/status | grep TracerPid' % pid).strip()
            val = tracer.split(':')[-1].strip()
            if val and val != '0':
                seen.add(val)
        alive = su('pidof %s' % pkg).strip() or 'DEAD'
        log('alive=%-8s tracer=%s' % (alive, ','.join(sorted(seen)) or '0'))
        if alive == 'DEAD':
            dead = True
            break
    after = clock_samples()
    samples = before + after
    factor = None
    if len(samples) > 1:
        v0, m0 = int(samples[0][0]), int(samples[0][1])
        v1, m1 = int(samples[-1][0]), int(samples[-1][1])
        if m1 > m0:
            factor = (v1 - v0) / float(m1 - m0)
            log('FACTOR %.3f' % factor)
    else:
        log('!! no clock samples')

    out = adlib.logcat()
    with open('/tmp/spd_daemon.log', 'w') as fh:
        fh.write(out)
    keep = [l for l in out.splitlines()
            if 'android-daemon' in l or 'AndroidService' in l]
    for l in keep[-40:]:
        log(l[:200])
    log('the target died: %s' % dead)
    return 0


if __name__ == '__main__':
    sys.exit(main())
