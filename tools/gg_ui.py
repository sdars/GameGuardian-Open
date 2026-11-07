#!/usr/bin/env python3
"""Drive the interface of the panel of the app on the device.

The panel of the app is a floating window that is built out of three
windows: the hot point (the icon of the app with the two buttons of the
speed hack next to it), the text of the speed hack below the icon and the
interface itself (the window with the tabs of the search, of the values and
of the configuration).  The interface is a normal window, so its widgets
are listed by ``uiautomator`` with their resource id; the hot point is an
overlay, so its place is taken from ``dumpsys window``.

The module knows where every button of the hot point is: the row of the hot
point holds the button that slows the clock down, the icon of the app and
the button that speeds the clock up.  The position of the window is taken
from the requested position of the window, the window manager clamps it to
the screen when it lies outside of it.
"""
import os
import re
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402

SCREEN_W = 720
SCREEN_H = 1280

# the row of the hot point: the button that slows the clock down, the icon
# of the app and the button that speeds the clock up
ROW = 328
SLOW_AT = 48
ICON_AT = 164
FAST_AT = 280
ROW_MID = 48


def log(msg):
    print('    %s' % msg, flush=True)


def detect_app():
    """the package of the panel that runs on the device

    Every install of the app gets a random package name and owns its own
    directory of the daemon, so the newest of those directories belongs to
    the install that is running now.
    """
    out = su('for d in /data/user/0/*/files/GG-*; do '
             '[ -d "$d" ] && echo "$(stat -c %Y "$d") ${d}"; done')
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
            best = (stamp, parts[1].split('/')[-3])
    if best is None:
        raise RuntimeError('no install of the app on the device')
    log('the panel package is %s' % best[1])
    return best[1]


def su(cmd, timeout=180):
    quoted = cmd.replace("'", "'\\''")
    return adlib.adb('shell', "su -c '%s'" % quoted, timeout=timeout).stdout


def overlays(pkg):
    """the overlay windows of the app with their frames

    ``dumpsys window`` prints the requested position of a window and the
    frame that the window manager gave to it.  The two differ when the
    window lies outside of the screen: the frame is clamped to the screen
    while the content of the window keeps its place.
    """
    out = adlib.sh('dumpsys window windows | grep -aE "Window #|mAttrs=|mFrame="',
                   timeout=240)
    res = []
    name = None
    for line in out.splitlines():
        m = re.match(r'\s*Window #\d+ Window\{(.*?)\}', line)
        if m:
            name = m.group(1)
            continue
        if not name or pkg not in name:
            continue
        m = re.search(r'mAttrs=\{\((-?\d+),(-?\d+)\)\((\d+)x(\d+)\)', line)
        if m is None:
            m = re.search(r'mAttrs=\{\((-?\d+),(-?\d+)\)\((\w+)\)', line)
        if m:
            try:
                w, h = int(m.group(3)), int(m.group(4))
            except ValueError:
                w, h = 0, 0
            res.append({'name': name, 'x': int(m.group(1)), 'y': int(m.group(2)),
                        'w': w, 'h': h, 'frame': None})
            continue
        m = re.search(r'mFrame=\[(\d+),(\d+)\]\[(\d+),(\d+)\]', line)
        if m and res and res[-1]['name'] == name and res[-1]['frame'] is None:
            res[-1]['frame'] = tuple(int(x) for x in m.groups())
    return res


def hot_point(pkg):
    """the window of the hot point of the app or None

    The hot point is the only overlay of the app that is wide enough to
    hold the row of the icon and the two buttons of the speed hack.
    """
    best = None
    for win in overlays(pkg):
        frame = win['frame'] or (0, 0, 0, 0)
        wide = frame[2] - frame[0]
        if wide < 250 or (frame[3] - frame[1]) > 200:
            continue
        if best is None or wide > (best['frame'][2] - best['frame'][0]):
            best = win
    return best


def icon_window(pkg):
    """the place of the floating icon of the app on the screen

    The icon lives in a window of its own that is square, the window of the
    text of the speed hack below it is not.
    """
    best = None
    for win in overlays(pkg):
        frame = win['frame']
        if not frame:
            continue
        w, h = frame[2] - frame[0], frame[3] - frame[1]
        if w < 40 or h < 40 or w > 220 or h > 220:
            continue
        if abs(w - h) > 12:
            continue
        if best is None or w * h < best[0]:
            best = (w * h, (frame[0] + frame[2]) // 2, (frame[1] + frame[3]) // 2)
    return best[1:] if best else None


def hot_point_at(pkg, offset):
    """the place of a button of the hot point on the screen

    The offset is the place of the button inside the row of the hot point.
    The window manager clamps the window to the screen, so the place of a
    button outside of the screen is not reachable and the hot point has to
    be moved before.
    """
    win = hot_point(pkg)
    if win is None:
        return None
    # the window manager clamps the window to the screen, so the place of a
    # button comes from the frame of the window and not from the position
    # that was asked for.
    frame = win['frame'] or (win['x'], win['y'], win['x'], win['y'])
    x = frame[0] + offset
    y = frame[1] + ROW_MID
    if x < 0 or x >= SCREEN_W or y < 0 or y >= SCREEN_H:
        return None
    return (x, y)


def interface_xml(tag='gi'):
    """the widgets of the interface of the app

    The interface is only dumped when it is the window in front, so the
    result is empty when the interface is closed.
    """
    return adlib.dump(tag, 'iface')


def interface_open(pkg=None):
    xml = interface_xml()
    return any(('/%s' % pkg) in n['pkg'] or n['pkg'] == pkg
               for n in adlib.nodes(xml) if pkg)


def open_interface(pkg):
    """open the interface of the app with the icon of the hot point"""
    xml = interface_xml()
    if adlib.find(xml, rid='config_tab') or adlib.find(xml, rid='app_name'):
        return True
    at = hot_point_at(pkg, ICON_AT)
    if at is None:
        log('the icon of the hot point is not on the screen')
        return False
    log('open the interface with the icon at %d,%d' % at)
    adlib.tap(*at)
    time.sleep(5)
    xml = interface_xml()
    return bool(adlib.find(xml, rid='config_tab') or adlib.find(xml, rid='app_name'))


def close_interface():
    xml = interface_xml()
    back = adlib.find(xml, rid='back_btn')
    if back is None:
        return False
    adlib.tap(*adlib.centre(back))
    time.sleep(4)
    return True


def tap_id(rid, xml=None):
    """press a widget of the interface and report whether it was there"""
    xml = xml if xml is not None else interface_xml()
    node = adlib.find(xml, rid=rid)
    if node is None:
        return False
    adlib.tap(*adlib.centre(node))
    time.sleep(3)
    return True


def select_process(pkg, pid, tries=40):
    """attach the app to the process with that pid

    The list of the processes is a dialog that holds a few entries at a
    time, so the list is scrolled until the pid of the target shows up.
    """
    if not open_interface(pkg):
        log('!! the interface did not come up')
        return False
    xml = interface_xml()
    if not tap_id('config_tab', xml):
        log('!! the tab of the configuration is missing')
        return False
    xml = interface_xml()
    if not tap_id('config_reset', xml):
        log('!! the entry that selects the process is missing')
        return False
    for attempt in range(tries):
        xml = interface_xml()
        row = None
        for node in adlib.nodes(xml):
            if node['bounds'] and ('[%s]' % pid) in node['text']:
                row = node
                break
        if row is not None:
            log('the process of the target: %r' % row['text'][:48])
            adlib.tap(*adlib.centre(row))
            time.sleep(6)
            xml = interface_xml()
            name = adlib.find(xml, rid='app_name')
            if name and ('[%s]' % pid) in name['text']:
                log('the app is attached to %r' % name['text'][:48])
                return True
            log('the app did not take the target')
            return False
        if not adlib.find(xml, rid='select_dialog_listview'):
            log('!! the list of the processes did not come up')
            return False
        adlib.sh('input swipe 360 1100 360 500 300')
        time.sleep(1.5)
    log('!! the process %s is not in the list' % pid)
    return False


def attached_name():
    xml = interface_xml()
    name = adlib.find(xml, rid='app_name')
    return name['text'] if name else ''


def speed_step(pkg, times=1):
    """press the button of the hot point that speeds the clock up

    The hot point is hidden while the interface is open, so the interface
    is closed before the button is pressed.
    """
    close_interface()
    win = hot_point(pkg)
    if win is None:
        log('!! the hot point is not on the screen')
        return False
    at = hot_point_at(pkg, FAST_AT)
    if at is None:
        log('!! the button of the speed hack is not on the screen')
        return False
    log('the button of the speed hack at %d,%d' % at)
    for i in range(times):
        adlib.tap(*at)
        time.sleep(2.5)
    return True


def move_hot_point(pkg, x, y):
    """drag the icon of the hot point to that place on the screen"""
    win = hot_point(pkg)
    if win is None:
        return False
    at = hot_point_at(pkg, ICON_AT)
    if at is None:
        return False
    adlib.sh('input swipe %d %d %d %d 600' % (at[0], at[1], x, y))
    time.sleep(2)
    win = hot_point(pkg)
    log('the hot point is now at %s,%s' % (win['x'] if win else '?', win['y'] if win else '?'))
    return win is not None


if __name__ == '__main__':
    pkg = sys.argv[1] if len(sys.argv) > 1 else ''
    for win in overlays(pkg):
        print(win)
    print('hot point:', hot_point(pkg))
