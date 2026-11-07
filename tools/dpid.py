#!/usr/bin/env python3
"""Find the daemon of the app on the device.

The daemon renames its process (it shows up as "[rcwbwb]" or "[vif]"),
so it can not be found by its name.  It keeps the link to its binary, so
the daemon is the process whose /proc/<pid>/exe points at lib5.so.

    tools/dpid.py            -> the pid of the daemon
"""
import os
import re
import subprocess
import sys

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'


def sh(cmd, timeout=90):
    p = subprocess.run([ADB, 'shell', 'su', '-c', cmd], capture_output=True,
                       text=True, timeout=timeout, errors='replace')
    return p.stdout + p.stderr


def daemons():
    """the pids of the daemons of the app (there is one per architecture)"""
    out = sh('ls -l /proc/*/exe 2>/dev/null')
    pids = []
    for line in out.splitlines():
        m = re.search(r'/proc/(\d+)/exe -> (.*lib5\.so)', line)
        if m:
            pids.append(int(m.group(1)))
    return pids


def main():
    pids = daemons()
    for p in pids:
        print(p)
    return 0 if pids else 1


if __name__ == '__main__':
    sys.exit(main())
