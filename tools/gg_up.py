#!/usr/bin/env python3
"""Bring the panel of the app up with a running daemon.

    python3 tools/gg_up.py

The daemon of the app is started by the service of the app.  A daemon that
was killed leaves the app with the file descriptors of the old fifos, so
the app is restarted and the fifos are removed when the daemon is not
running.
"""
import os
import re
import subprocess
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402

ADB = adlib.ADB
APP = os.environ.get('GG_APP', '')
DIR = ''


def log(msg):
    print('    %s' % msg, flush=True)


def sh(cmd, timeout=120):
    """run one command as root on the device

    The arguments of "adb shell" are joined by the tool without quoting, so
    the whole command has to be one string that carries its own quotes.
    """
    quoted = cmd.replace("'", "'\''")
    return adlib.adb('shell', "su -c '%s'" % quoted, timeout=timeout).stdout


def daemons():
    """the daemon renames its process, so it is found by its binary"""
    text = sh('ls -l /proc/*/exe 2>/dev/null')
    pids = []
    for line in text.splitlines():
        m = re.search(r'/proc/(\d+)/exe -> (.*lib5\.so)', line)
        if m:
            pids.append(int(m.group(1)))
    return pids


def detect():
    """the package and the directory of the daemon of the newest install"""
    global APP, DIR
    if APP and DIR:
        return APP, DIR
    script = ('for d in /data/user/0/*/files/GG-*; do '
              '[ -d "$d" ] && echo "$(stat -c %Y "$d") ${d}"; done')
    out = sh(script)
    best = None
    for line in out.splitlines():
        parts = line.split()
        if len(parts) < 2 or not parts[1].startswith('/'):
            continue
        try:
            stamp = int(parts[0])
        except ValueError:
            stamp = 0
        if best is None or stamp > best[0]:
            best = (stamp, parts[1].split('/')[-3], parts[1])
    if best is None:
        raise RuntimeError('no install of the app on the device')
    APP = APP or best[1]
    DIR = DIR or best[2]
    log('the panel package is %s, the daemon directory is %s' % (APP, DIR))
    return APP, DIR


def tap_start():
    xml = adlib.dump('up', 'screen')
    for n in adlib.nodes(xml):
        if n['text'].strip() == '开始' and n['bounds']:
            x, y = adlib.centre(n)
            log('press the start button at %d,%d' % (x, y))
            adlib.tap(x, y)
            time.sleep(8)
            return True
    return False


def main():
    detect()
    for _ in range(4):
        pids = daemons()
        if pids:
            log('the daemon runs: %s' % pids)
            tap_start()
            return 0
        log('no daemon, restart the app')
        adlib.sh('am force-stop %s' % APP)
        time.sleep(2)
        sh('rm -f %s/i %s/o %s/e' % (DIR, DIR, DIR))
        sh('pkill -f lib5.so')
        adlib.logcat_clear()
        adlib.sh('am start -n %s/.MainActivity' % APP)
        time.sleep(10)
        tap_start()
        time.sleep(6)
    pids = daemons()
    if not pids:
        print('!! the daemon does not run', flush=True)
        return 1
    log('the daemon runs: %s' % pids)
    return 0


if __name__ == '__main__':
    sys.exit(main())
