#!/usr/bin/env python3
"""Switch the SELinux mode of the app on the device.

    tools/sel_mode.py <package> <0|1>

1 = work with SELinux: the daemon stays inside the rules of the policy, it
    copies its helper library into the directory of the target.
0 = work without SELinux: the daemon turns the enforcement off.  This is
    the mode of the original application that is needed when the policy
    refuses the injection into a target.
"""
import os
import subprocess
import sys
import time

ROOT = '/root/gameguardian'
ADB = os.path.join(ROOT, 'tmp/tools/platform-tools/adb')
SERIAL = os.environ.get('GG_SERIAL', '8.162.0.198:30138')


def sh(cmd, timeout=90):
    return subprocess.run([ADB, '-s', SERIAL, 'shell', 'su', '-c', cmd],
                          capture_output=True, text=True, timeout=timeout)


def main():
    pkg, mode = sys.argv[1], sys.argv[2]
    prefs = '/data/data/%s/shared_prefs/%s_preferences.xml' % (pkg, pkg)
    sh('am force-stop ' + pkg)
    time.sleep(2)
    sh('sed -i \'s/name="selinux" value="[01]"/name="selinux" value="%s"/\' %s'
       % (mode, prefs))
    print(sh('grep -a selinux ' + prefs).stdout.strip())
    print(sh('getenforce').stdout.strip())
    return 0


if __name__ == '__main__':
    sys.exit(main())
