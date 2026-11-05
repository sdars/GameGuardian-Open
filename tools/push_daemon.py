#!/usr/bin/env python3
"""Install a daemon binary into the data directory of the app.

    python3 tools/push_daemon.py <local daemon> [<local daemon> ...]

The file is pushed to /data/local/tmp/lib5.so and copied over the daemon
that the app unpacked into its data directory.  The app only unpacks the
daemon when the file is missing, so the copy has to be done with the app
stopped (a running daemon gives "Text file busy").
"""
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

REMOTE = '/data/local/tmp/lib5.so'
INSTALL = '/data/local/tmp/ab_daemon.sh'


def main():
    if len(sys.argv) < 2:
        print(__doc__)
        return 1
    for path in sys.argv[1:]:
        r = adlib.adb('push', path, REMOTE, timeout=300)
        if r.returncode != 0:
            print('push failed: %s' % r.stderr)
            return 1
        print('pushed %s' % path, flush=True)
        out = adlib.adb('shell', 'su -c "sh %s"' % INSTALL, timeout=300)
        print(out.stdout, flush=True)
        if out.stderr.strip():
            print(out.stderr, flush=True)
        time.sleep(1)
    return 0


if __name__ == '__main__':
    sys.exit(main())
