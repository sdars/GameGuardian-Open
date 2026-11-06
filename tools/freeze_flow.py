#!/usr/bin/env python3
'''Freeze a value of a real process on the device and watch what happens.

    python3 tools/freeze_flow.py <package> <pid> [seconds]

The script drives the real GameGuardian build on the phone: it attaches to
the target process, searches the value of the test bed
(com.gg.freezeprobe, the seed is read out of the log of the target), puts
the result into the saved list, freezes it and then watches the target.

What it reports

* the address of the frozen value and the type that the app used,
* the poison line of the test bed - the daemon has to write the value back,
* the canary of the test bed - a freeze that writes more bytes than the
  type of the value asks for destroys the words behind it,
* every death, ANR or fatal signal of the target.
'''
import re
import subprocess
import sys
import time

sys.path.insert(0, '/root/gameguardian/tools')
import adlib  # noqa: E402

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'

# the places of the floating panel
ICON = (48, 104)
TAB_SEARCH = (294, 104)
TAB_SAVED = (426, 104)
MORE_BTN = (675, 254)
CRASH_OK = (360, 892)


def log(msg):
    print('    %s' % msg, flush=True)


def nodes(xml):
    return adlib.nodes(xml)


def by_id(xml, rid):
    return adlib.find(xml, rid=rid)


def by_text(xml, text, exact=True):
    for n in nodes(xml):
        t = n['text'].strip()
        if not t:
            continue
        if (t == text) if exact else (text in t):
            return n
    return None


def tap_node(n, what):
    x, y = adlib.centre(n)
    log('tap %s at %d,%d' % (what, x, y))
    adlib.tap(x, y)
    time.sleep(1.5)


def shell(cmd, timeout=120):
    return subprocess.run([ADB, 'shell', 'su', '-c', cmd],
                          capture_output=True, text=True, timeout=timeout).stdout


def read_mem(pid, addr, count=16):
    '''read count bytes at addr of the target with the root of the phone'''
    out = shell('dd if=/proc/%s/mem bs=1 skip=%d count=%d 2>/dev/null | xxd -p'
                % (pid, addr, count))
    return bytes.fromhex(''.join(out.split()))


def rows_of(xml, rid_addr='address', rid_type='addr_item_type'):
    '''the rows of a list of values: (address, type)'''
    rows = []
    addr = None
    for n in nodes(xml):
        rid = n['rid'].split('/')[-1]
        t = n['text'].strip()
        if rid == rid_addr:
            addr = t.rstrip(':')
        elif rid == rid_type and addr:
            rows.append((addr, t, n['bounds']))
            addr = None
    return rows


def checked_rows(xml):
    """the rows whose checkbox is checked"""
    out = []
    addr = None
    for n in nodes(xml):
        rid = n['rid'].split('/')[-1]
        if rid == 'address':
            addr = n['text'].strip().rstrip(':').lower().lstrip('0')
        elif rid == 'ch' and 'checked="true"' in n['raw']:
            out.append(addr)
    return out


def checkbox_of(xml, addr):
    """the checkbox of the row with the address

    The list of the results scrolls with an elastic edge, so the bounds of
    the rows move for a moment after a swipe.  The dump is repeated until
    the bounds do not change any more, otherwise the tap lands on the row
    that is one line above.
    """
    key = addr.lower().lstrip('0')
    last = None
    for _ in range(8):
        for n in nodes(xml):
            if n['rid'].split('/')[-1] != 'ch' or not n['bounds']:
                continue
            for m in nodes(xml):
                if m['rid'].split('/')[-1] != 'address' or not m['bounds']:
                    continue
                if m['text'].strip().rstrip(':').lower().lstrip('0') != key:
                    continue
                if n['bounds'][1] < m['bounds'][3] and m['bounds'][1] < n['bounds'][3]:
                    if last == n['bounds']:
                        return n
                    last = n['bounds']
                    break
        time.sleep(1.5)
        xml = adlib.dump('fz', 'stable')
    return None


def lock_of(xml, addr):
    """the lock of the row with the address in the saved list"""
    key = addr.lower().lstrip('0')
    last = None
    for _ in range(8):
        for n in nodes(xml):
            if n['rid'].split('/')[-1] != 'freeze' or not n['bounds']:
                continue
            for m in nodes(xml):
                if m['rid'].split('/')[-1] != 'address' or not m['bounds']:
                    continue
                if m['text'].strip().rstrip(':').lower().lstrip('0') != key:
                    continue
                if n['bounds'][1] < m['bounds'][3] and m['bounds'][1] < n['bounds'][3]:
                    if last == n['bounds']:
                        return n
                    last = n['bounds']
                    break
        time.sleep(1.5)
        xml = adlib.dump('fz', 'stable2')
    return None


def crash_dialog(xml):
    for n in nodes(xml):
        if n['rid'].split('/')[-1] == 'alertTitle' and '崩溃' in n['text']:
            return True
    return False


def set_mode(mode):
    """switch the test bed between "search" and "test"

    In the mode "search" the value of the test bed stays the same, so the
    search of the panel finds it.  In the mode "test" the value is poisoned
    every tick: a frozen value is written back by the daemon.
    """
    for attempt in range(4):
        adlib.sh('am broadcast -a com.gg.freezeprobe.MODE --es mode %s '
                 '-p com.gg.freezeprobe' % mode)
        time.sleep(2)
        out = adlib.logcat('GGFreezeProbe')
        modes = [l.split('mode=')[-1].strip() for l in out.splitlines() if 'mode=' in l]
        if modes and modes[-1] == mode:
            log('the test bed is in the mode %r' % mode)
            return True
        log('the test bed did not take the mode %r, try again' % mode)
    print('!! the test bed does not take the mode %r' % mode, flush=True)
    return False


def dismiss_crash(xml):
    '''the overlay shows a dialog when the target dies - close it'''
    if crash_dialog(xml):
        log('the overlay reports a crash of the target')
        adlib.tap(*CRASH_OK)
        time.sleep(3)
        return True
    return False


def is_panel(xml):
    """the panel shows the tabs and the name of the target"""
    for n in nodes(xml):
        if n['rid'].split('/')[-1] in ('app_name', 'number', 'search_tab',
                                       'saved_tab', 'config_tab', 'memory_tab'):
            return True
    return False


def open_panel():
    """bring the floating panel up and return its dump

    The panel hides itself while a search runs and while another window has
    the focus.  The icon of the panel opens it again - but as long as the
    panel is up the same icon opens the picker with the processes, so the
    state of the panel has to be checked before the icon is used.
    """
    xml = adlib.dump('fz', 'panel')
    if crash_dialog(xml):
        dismiss_crash(xml)
        xml = adlib.dump('fz', 'panel')
    if is_panel(xml):
        return xml
    for _ in range(4):
        adlib.tap(*ICON)
        time.sleep(4)
        xml = adlib.dump('fz', 'panel')
        if crash_dialog(xml):
            dismiss_crash(xml)
            xml = adlib.dump('fz', 'panel')
        if is_panel(xml):
            return xml
        if '选择应用进程' in xml:
            # the picker opened instead of the panel
            adlib.sh('input keyevent KEYCODE_BACK')
            time.sleep(2)
    return xml


def attach(pkg, pid):
    xml = open_panel()
    nm = by_id(xml, 'app_name')
    if nm and ('[%s]' % pid) in nm['text']:
        log('already attached to %r' % nm['text'])
        return True
    # the icon of the panel opens the picker with the processes
    for _ in range(3):
        adlib.tap(*ICON)
        time.sleep(4)
        xml = adlib.dump('fz', 'procs')
        if '选择应用进程' in xml:
            break
        log('the picker did not open, try again')
    row = None
    for _ in range(12):
        xml = adlib.dump('fz', 'procs')
        for n in nodes(xml):
            if ('[%s]' % pid) in n['text']:
                row = n
                break
        if row is not None:
            break
        log('the target is not on the screen, scroll the process list')
        adlib.sh('input swipe 360 1000 360 400 400')
        time.sleep(3)
    if row is None:
        print('!! the process %s is not in the list' % pid, flush=True)
        return False
    tap_node(row, 'the target process')
    time.sleep(10)
    xml = open_panel()
    nm = by_id(xml, 'app_name')
    log('attached to %r' % (nm['text'] if nm else '?'))
    return nm is not None and ('[%s]' % pid) in nm['text']


def search_dialog():
    '''the dialog of the search, it is part of the panel'''
    xml = open_panel()
    if by_id(xml, 'number') is not None:
        return xml
    adlib.tap(*TAB_SEARCH)
    time.sleep(3)
    xml = adlib.dump('fz', 'searchtab')
    if by_id(xml, 'number') is not None:
        return xml
    adlib.tap(*MORE_BTN)
    time.sleep(4)
    xml = adlib.dump('fz', 'menu')
    entry = by_text(xml, '已知（精确）搜索', exact=False)
    if entry is None:
        entry = by_text(xml, '搜索', exact=False)
    if entry is None:
        print('!! the more menu has no search entry', flush=True)
        return None
    tap_node(entry, 'the exact search')
    time.sleep(5)
    xml = adlib.dump('fz', 'dialog')
    if by_id(xml, 'number') is None:
        print('!! the search dialog is not open', flush=True)
        return None
    return xml


def type_the_value(xml, value):
    '''put the value into the number field of the search dialog'''
    num = by_id(xml, 'number')
    if num['text'].strip() == value:
        log('the field already holds %s' % value)
        return True
    tap_node(num, 'the number field')
    time.sleep(2)
    adlib.sh('input keyevent 123')
    time.sleep(1)
    for _ in range(16):
        adlib.sh('input keyevent 67')
        time.sleep(0.2)
    adlib.sh('input text %s' % value)
    time.sleep(2)
    xml = adlib.dump('fz', 'typed')
    num = by_id(xml, 'number')
    log('the field is %r' % (num['text'] if num else '?'))
    return num is not None and num['text'].strip() == value


def pick_the_type(xml):
    '''the type of the search has to be Dword'''
    t = by_id(xml, 'type')
    if t and 'Dword' in t['text']:
        log('the type is already %r' % t['text'][:40])
        return True
    tap_node(t, 'the type')
    time.sleep(4)
    xml = adlib.dump('fz', 'typelist')
    item = by_text(xml, 'D: Dword', exact=False)
    if item is None:
        print('!! the type list has no Dword', flush=True)
        return False
    tap_node(item, 'the type Dword')
    time.sleep(3)
    return True


def run_the_search(value, timeout=180):
    '''start the search and wait until the daemon has finished it'''
    xml = search_dialog()
    if xml is None:
        return False
    if not type_the_value(xml, value):
        return False
    if not pick_the_type(xml):
        return False
    xml = adlib.dump('fz', 'dlg2')
    btn = by_text(xml, '新搜索')
    if btn is None:
        btn = by_text(xml, '改善')
    if btn is None:
        print('!! the search dialog has no start button', flush=True)
        return False
    adlib.logcat_clear()
    tap_node(btn, 'the start of the search')
    started = time.time()
    while time.time() - started < timeout:
        time.sleep(5)
        out = adlib.logcat()
        if 'searchDone' in out:
            log('the search is done')
            time.sleep(3)
            return True
    print('!! the search did not finish in %d seconds' % timeout, flush=True)
    return False


def result_rows():
    '''the list of the results - the panel hides itself while a search runs'''
    xml = open_panel()
    if by_id(xml, 'number') is not None:
        # the dialog of the search is in the way
        btn = by_text(xml, '取消')
        if btn is not None:
            tap_node(btn, 'the cancel of the search dialog')
            time.sleep(3)
            xml = adlib.dump('fz', 'results')
    return xml


def collect_rows(max_scrolls=25):
    """every row of the list of the results

    The list is longer than the screen, so it is scrolled until the rows
    do not change any more.
    """
    xml = result_rows()
    rows = {}
    for _ in range(max_scrolls):
        for a, t, b in rows_of(xml):
            rows.setdefault(a.lower().lstrip('0'), (a, t, b))
        before = len(rows)
        adlib.sh('input swipe 360 1000 360 400 400')
        time.sleep(2)
        xml = adlib.dump('fz', 'scroll')
        for a, t, b in rows_of(xml):
            rows.setdefault(a.lower().lstrip('0'), (a, t, b))
        if len(rows) == before:
            break
    return xml, list(rows.values())


def scroll_to_address(xml, addr):
    """scroll the list of the results until the address is on the screen"""
    key = addr.lower().lstrip('0')
    for _ in range(25):
        for a, t, b in rows_of(xml):
            if a.lower().lstrip('0') == key:
                return xml
        adlib.sh('input swipe 360 1000 360 400 400')
        time.sleep(2)
        xml = adlib.dump('fz', 'scroll2')
    return xml


def live_address(pid, rows, wait=1.5):
    """the address of the live copy of the array of the test bed

    The search finds the copies of the array that the garbage collector
    left in the heap.  The live one is the copy whose counter changes.
    """
    candidates = []
    for a, t, b in rows:
        try:
            addr = int(a, 16)
        except ValueError:
            continue
        mem = read_mem(pid, addr, 16)
        if len(mem) < 16:
            continue
        if mem[4:8] == b'\xa4\xa3\xa2\xa1':
            candidates.append((a, t, addr))
    log('%d of %d results carry the canary' % (len(candidates), len(rows)))
    for a, t, addr in candidates:
        first = read_mem(pid, addr, 16)
        time.sleep(wait)
        second = read_mem(pid, addr, 16)
        if len(first) < 16 or len(second) < 16:
            continue
        if first[12:16] != second[12:16]:
            log('the address of the test bed is %s (type %s)' % (a, t))
            return a, t, addr
    return None


def main():
    pkg = sys.argv[1]
    pid = sys.argv[2]
    watch = int(sys.argv[3]) if len(sys.argv) > 3 else 120

    # the seed of the test bed is in the log of the target
    out = adlib.logcat('GGFreezeProbe')
    seed = None
    want = None
    for line in out.splitlines():
        m = re.search(r'seed=(\d+)', line)
        if m:
            seed = m.group(1)
        m = re.search(r'addr=([0-9a-fA-F]+)', line)
        if m:
            want = m.group(1).lower().lstrip('0') or '0'
    if seed is None:
        print('!! the log of the target has no seed', flush=True)
        return 1
    log('the seed of the test bed is %s' % seed)
    log('the address of the test bed is %s' % (want or '?'))

    print('==> attach to %s (%s)' % (pkg, pid), flush=True)
    if not attach(pkg, pid):
        return 1

    set_mode('search')

    print('==> the value search for %s' % seed, flush=True)
    if not run_the_search(seed):
        return 1
    xml, rows = collect_rows()
    for a, t, _b in rows[:12]:
        log('result %s type %s' % (a, t))
    fc = by_id(xml, 'found_count')
    log('found_count is %r' % (fc['text'] if fc else '?'))
    if not rows:
        print('!! the search found nothing', flush=True)
        return 1

    # the live copy of the array of the test bed
    target = live_address(pid, rows)
    if target is None:
        print('!! the address of the test bed is not in the result list', flush=True)
        return 1

    print('==> save the result', flush=True)
    xml = scroll_to_address(adlib.dump('fz', 'results2'), target[0])
    sel = checkbox_of(xml, target[0])
    if sel is None:
        print('!! the result list has no checkbox for %s' % target[0], flush=True)
        return 1
    tap_node(sel, 'the checkbox of %s' % target[0])
    time.sleep(2)
    # the tap has to land on the row of the target, the list is checked
    # again and the tap is repeated when it did not
    for _ in range(3):
        xml = adlib.dump('fz', 'checked')
        done = checked_rows(xml)
        if target[0].lower().lstrip('0') in done:
            log('the row %s is checked' % target[0])
            break
        log('the row %s is not checked, the tap is repeated' % target[0])
        box = checkbox_of(xml, target[0])
        if box is None:
            print('!! the checkbox of %s is gone' % target[0], flush=True)
            return 1
        tap_node(box, 'the checkbox of %s' % target[0])
        time.sleep(2)
    adlib.tap(*MORE_BTN)
    time.sleep(4)
    xml = adlib.dump('fz', 'menu2')
    entry = by_text(xml, '保存所选')
    if entry is None:
        print('!! the more menu has no save entry', flush=True)
        return 1
    tap_node(entry, 'save the selected')
    time.sleep(5)

    print('==> freeze it', flush=True)
    adlib.tap(*TAB_SAVED)
    time.sleep(4)
    xml = adlib.dump('fz', 'saved')
    lock = lock_of(xml, target[0])
    if lock is None:
        print('!! the saved list has no row for %s' % target[0], flush=True)
        for n in nodes(xml):
            if n['rid'].split('/')[-1] in ('name', 'address'):
                log('%s %r' % (n['rid'].split('/')[-1], n['text']))
        return 1
    tap_node(lock, 'the lock of the saved value')
    time.sleep(4)

    set_mode('test')

    # the daemon has to write the value back into the memory of the target
    want = int(seed).to_bytes(4, 'little', signed=False)
    written = 0
    for _ in range(12):
        time.sleep(1)
        mem = read_mem(pid, target[2], 4)
        if mem == want:
            written += 1
    log('the daemon wrote the frozen value back %d of 12 times' % written)

    print('==> watch the target for %d seconds' % watch, flush=True)
    started = time.time()
    tracer = ''
    while time.time() - started < watch:
        time.sleep(2)
        tr = shell('cat /proc/%s/status | grep -E "TracerPid|State"' % pid)
        if tr != tracer:
            log('the state of the target: %s' % ' '.join(tr.split()))
            tracer = tr
        out = adlib.logcat('GGFreezeProbe')
        poison = [l for l in out.splitlines() if 'FREEZE' in l]
        canary = [l for l in out.splitlines() if 'CORRUPTION' in l]
        status = [l for l in out.splitlines() if 'status ticks' in l]
        alive = shell('pidof %s' % pkg).strip()
        log('alive=%s freeze=%d canary=%d %s'
            % (alive or 'DEAD',
               len(poison),
               len(canary),
               (status[-1].split('GGFreezeProbe:')[-1].strip() if status else '-')))
        if not alive:
            break

    print('==> the log of the device', flush=True)
    out = adlib.logcat()
    for line in out.splitlines():
        if re.search(r'GGFreezeProbe|FATAL|ANR in|has died|Force finishing|am_crash|am_kill',
                     line):
            print('      %s' % line, flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())
