#!/usr/bin/env python3
"""Drive the speed panel of a GameGuardian build and report the result.

The floating overlay of the app holds the speed buttons (speed_dec / speed_inc)
in the same window as the icon.  The icon window is found with dumpsys window,
a long press on the icon expands the window and the fast forward button is
pressed at its place (the layout puts it 48dp wide at the right end of the
window, 10dp apart from the icon).

    tools/speed_panel_ab.py <package> <tag> <pid>

The script prints what the app showed (the dialog of the error) and what the
daemon logged, so that the original and the reconstruction can be compared.
"""
import os
import re
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

ROOT = "/root/gameguardian"
adb = adlib.adb
sh = adlib.sh
tap = adlib.tap
dump = adlib.dump
nodes = adlib.nodes
find = adlib.find
centre = adlib.centre

TAG = "x"
PKG = ""


def windows():
    """the APPLICATION_OVERLAY windows of the app with their frames"""
    out = sh("dumpsys window windows | grep -E 'Window #|ty=APPLICATION_OVERLAY|mFrame='",
             timeout=240)
    res = []
    state = {"name": None, "attrs": None, "frame": None}

    def flush():
        if state["name"] and state["attrs"] and state["frame"]:
            res.append((state["name"], state["attrs"], state["frame"]))

    for line in out.splitlines():
        m = re.match(r"\s*Window #\d+ Window\{(.*?)\}", line)
        if m:
            flush()
            state["name"] = m.group(1)
            state["attrs"] = None
            state["frame"] = None
            continue
        if state["name"] is None:
            continue
        if "ty=APPLICATION_OVERLAY" in line:
            state["attrs"] = line.strip()
        m = re.search(r"mFrame=\[(\d+),(\d+)\]\[(\d+),(\d+)\]", line)
        if m and state["frame"] is None:
            state["frame"] = tuple(int(x) for x in m.groups())
    flush()
    return [r for r in res if PKG in r[0]]


def top_left(win):
    """the overlays of the app in the top left corner of the screen"""
    out = []
    for name, attrs, frame in win:
        if 'gr=TOP LEFT CENTER' not in attrs:
            continue
        x1, y1, x2, y2 = frame
        if x1 < 0 or y1 < 0 or x2 > 720 or y2 > 1280:
            continue
        if '10000,10000' in attrs:
            continue
        out.append((name, attrs, frame))
    return out


def icon_window(win):
    """the smallest overlay in the top left corner is the floating icon"""
    cands = top_left(win)
    if not cands:
        return None
    return min(cands, key=lambda c: (c[2][2] - c[2][0]) * (c[2][3] - c[2][1]))


def panel_window(win):
    """the widest overlay in the top left corner holds the speed buttons"""
    cands = top_left(win)
    if not cands:
        return None
    return max(cands, key=lambda c: c[2][2] - c[2][0])


def main():
    global TAG, PKG
    PKG = sys.argv[1]
    TAG = sys.argv[2]
    pid = sys.argv[3]
    print("== attach to %s" % pid, flush=True)
    adlib.attach(TAG, PKG, pid)
    # the button in the top right corner of the panel hides the panel and leaves
    # the floating icon on the screen
    xml = dump(TAG, "panel")
    btn = find(xml, rid="back_btn")
    if btn is not None:
        bx, by = centre(btn)
        print("== hide the panel with back_btn at %d,%d" % (bx, by), flush=True)
        tap(bx, by)
        time.sleep(4)
    win = windows()
    icon = None
    for _ in range(5):
        print("== the overlay windows", flush=True)
        for name, attrs, frame in win:
            print("   %-30s %-58s %s" % (name[:30], attrs[:58], frame), flush=True)
        icon = icon_window(win)
        if icon is not None:
            break
        print("   (the window list was incomplete, retry)", flush=True)
        time.sleep(4)
        win = windows()
    if icon is None:
        print("!! no floating icon window", flush=True)
        return 1
    x1, y1, x2, y2 = icon[2]
    x, y = (x1 + x2) // 2, (y1 + y2) // 2
    print("== the floating icon at %d,%d" % (x, y), flush=True)
    print("== long press", flush=True)
    sh("input swipe %d %d %d %d 1500" % (x, y, x, y))
    time.sleep(5)
    win = windows()
    for name, attrs, frame in win:
        print("   %-30s %-58s %s" % (name[:30], attrs[:58], frame), flush=True)
    icon = panel_window(win)
    if icon is None:
        print("!! the floating icon vanished", flush=True)
        return 1
    x1, y1, x2, y2 = icon[2]
    print("== the panel is now %s" % (icon[2],), flush=True)
    if x2 - x1 < 200:
        print("!! the speed panel did not open", flush=True)
        return 1
    bx = x2 - 58
    by = (y1 + y2) // 2
    print("== tap speed_inc at %d,%d" % (bx, by), flush=True)
    tap(bx, by)
    time.sleep(8)
    adlib.screencap(TAG)
    xml = dump(TAG, "after")
    print("== the screen after the speed change", flush=True)
    for node in nodes(xml):
        if node["text"].strip():
            print("   %-46s %s" % (node["text"][:46], node["bounds"]), flush=True)
    print("== the log of the app and the daemon", flush=True)
    log = adb("logcat", "-d", "-v", "time", timeout=240).stdout
    with open(os.path.join(ROOT, "build", "flow", "lc_%s.txt" % TAG), "w", encoding="utf-8") as fh:
        fh.write(log)
    for line in log.splitlines():
        if re.search(r"AndroidService|android-daemon", line) and re.search(
                r"speed|Send code|>>|<<|107|TE get|elf_hook|find all|hook |rror|fail|package name|Libs path|Region list|_reader|Fake long|Real long",
                line):
            print("   " + line[:230], flush=True)
    return 0


if __name__ == "__main__":
    sys.exit(main())
