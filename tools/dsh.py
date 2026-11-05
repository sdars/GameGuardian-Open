#!/usr/bin/env python3
"""Run a shell script on the device as root.

    python3 tools/dsh.py <local script> [remote name]

The script is pushed to /data/local/tmp/gg_<name>.sh and started with
su.  The link to the device is flaky, so the push and the run are done
through ``adlib``, which reconnects and retries.
"""
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402


def main():
    if len(sys.argv) < 2:
        print(__doc__)
        return 1
    script = sys.argv[1]
    name = sys.argv[2] if len(sys.argv) > 2 else os.path.basename(script).rsplit('.', 1)[0]
    remote = '/data/local/tmp/gg_%s.sh' % name
    r = adlib.adb('push', script, remote, timeout=300)
    if r.returncode != 0:
        print('push failed: %s' % r.stderr)
        return 1
    print('### push %s -> %s' % (script, remote), flush=True)
    out = adlib.adb('shell', 'su -c "sh %s"' % remote, timeout=600)
    print(out.stdout, flush=True)
    if out.stderr.strip():
        print(out.stderr, flush=True)
    print('### rc=%d' % out.returncode, flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())
