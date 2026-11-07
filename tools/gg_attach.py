#!/usr/bin/env python3
"""Attach the panel of the app to a running process.

    python3 tools/gg_attach.py <package> [pid]

The panel of the app is a floating window.  The list of the processes is
inside a dialog of the app, so the dialog is opened with a tap on the
floating icon; the list is long and the target is often not on the first
screen, so the list is walked through one screen at a time.
"""
import os
import re
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402

APP = os.environ.get('GG_APP', '')
NOISE = ('com.dianjiqi', 'com.utnciuwv.ldcsra', 'com.wrw')


def detect_app():
    """the package of the panel.

    Every install of the app gets a random package name and owns its own
    directory of the daemon.  The newest directory is the install that the
    panel of the device is running, so the scripts never talk to a stale
    install that was left behind by an earlier run.
    """
    global APP
    if APP:
        return APP
    script = ('for d in /data/user/0/*/files/GG-*; do '
              '[ -d "$d" ] && echo "$(stat -c %Y "$d") ${d}"; done')
    out = adlib.adb('shell', "su -c '%s'" % script.replace("'", "'\\''"),
                    timeout=120).stdout
    best = None
    for line in out.splitlines():
        parts = line.split()
        if len(parts) < 2 or not parts[1].startswith('/'):
            continue
        pkg = parts[1].split('/')[-3]
        try:
            stamp = int(parts[0])
        except ValueError:
            stamp = 0
        if best is None or stamp > best[0]:
            best = (stamp, pkg)
    if best is None:
        raise RuntimeError('no install of the app on the device')
    APP = best[1]
    log('the panel package is %s' % APP)
    return APP


def log(msg):
    print('    %s' % msg, flush=True)


def find_row(xml, pid):
    for n in adlib.nodes(xml):
        if n['bounds'] and ('[%s]' % pid) in n['text']:
            return n
    return None


def press_start(tag):
    """the starter screen of the app holds the button that starts the panel"""
    xml = adlib.dump(tag, 'start')
    for n in adlib.nodes(xml):
        t = n['text'].strip()
        if not n['bounds']:
            continue
        if t in ('忽略', 'Ignore', 'Skip'):
            log('the dialog of SELinux: ignore')
            adlib.tap(*adlib.centre(n))
            time.sleep(6)
            return True
        if t in ('已阅读并同意', '同意并继续', '我同意'):
            log('the agreement: accept')
            adlib.tap(*adlib.centre(n))
            time.sleep(6)
            return True
        if t == '开始':
            log('press the start button')
            adlib.tap(*adlib.centre(n))
            time.sleep(10)
            return True
    return False


def open_dialog(app):
    """the dialog with the list of the processes"""
    xml = adlib.dump('ga', 'dlg0')
    if adlib.find(xml, rid='alertTitle'):
        return xml
    icon = adlib.float_icon(app)
    if icon is not None:
        log('the floating icon at %d,%d' % icon)
        adlib.tap(*icon)
        time.sleep(5)
        xml = adlib.dump('ga', 'dlg1')
        if adlib.find(xml, rid='alertTitle'):
            return xml
    return xml


def attach(pkg, pid=None, app=None):
    app = app or detect_app()
    if pid is None:
        out = adlib.sh('pidof %s' % pkg).strip().split()
        pid = out[0] if out else None
    if not pid:
        log('!! the target does not run')
        return 1
    log('target %s pid %s' % (pkg, pid))

    for other in NOISE:
        adlib.sh('am force-stop %s' % other)
    adlib.sh('am start -n %s/.MainActivity' % app)
    time.sleep(8)
    press_start('ga')

    for attempt in range(80):
        xml = adlib.dump('ga', 'state%d' % attempt)
        # the panel reports the crash of a target with a dialog, the dialog
        # covers the whole screen and has to go away first
        crashed = None
        ok = None
        for n in adlib.nodes(xml):
            if not n['bounds']:
                continue
            if n['text'].strip() == '游戏崩溃了':
                crashed = n
            if n['text'].strip() == '确定':
                ok = n
        if crashed is not None and ok is not None:
            log('close the dialog of the crash report')
            adlib.tap(*adlib.centre(ok))
            time.sleep(4)
            continue
        nm = adlib.find(xml, rid='app_name')
        if nm and ('[%s]' % pid) in nm['text']:
            log('the panel is attached to the target: %r' % nm['text'][:60])
            return 0
        row = find_row(xml, pid)
        if row is not None:
            log('the row of the target: %r' % row['text'][:60])
            adlib.tap(*adlib.centre(row))
            time.sleep(6)
            continue
        if adlib.find(xml, rid='alertTitle'):
            # the list of the processes is long, the target is walked to
            log('the target is not on the screen, scroll the list')
            adlib.sh('input swipe 360 1100 360 300 200')
            time.sleep(1.2)
            continue
        back = adlib.find(xml, rid='back_btn')
        if back is not None:
            log('close the panel of the app')
            adlib.tap(*adlib.centre(back))
            time.sleep(4)
            continue
        icon = adlib.float_icon(app)
        if icon is not None:
            log('the floating icon at %d,%d' % icon)
            adlib.tap(*icon)
            time.sleep(5)
            continue
        log('   (no floating icon)')
        press_start('ga')
        time.sleep(3)
    log('!! the list of the processes never showed the target')
    return 1


def main():
    return attach(sys.argv[1], sys.argv[2] if len(sys.argv) > 2 else None)


if __name__ == '__main__':
    sys.exit(main())
