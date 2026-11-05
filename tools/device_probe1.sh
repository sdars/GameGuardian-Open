#!/usr/bin/env bash
# Collect the state of the daemon and of the helper packages on the device.
#
#   tools/device_probe1.sh
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
S=8.162.0.198:30138

echo "=== the diagnostic log of our helper"
adb -s $S shell "su -c 'cat /data/user/0/com.wrw/files/gg-diag.log'" 2>&1 | tr -d '\r'

echo "=== the daemon files of our helper"
adb -s $S shell "su -c 'ls -l /data/user/0/com.wrw/files/GG-*/*'" 2>&1 | tr -d '\r'

echo "=== the daemon files of the original helper"
adb -s $S shell "su -c 'ls -l /data/user/0/com.utnciuwv.ldcsra/files/GG-*/*'" 2>&1 | tr -d '\r'

echo "=== the sha256 of the daemon of both helpers"
adb -s $S shell "su -c 'sha256sum /data/user/0/com.wrw/files/GG-*/* /data/user/0/com.utnciuwv.ldcsra/files/GG-*/*'" 2>&1 | tr -d '\r'

echo "=== the processes"
adb -s $S shell "ps -A -o USER,PID,PPID,NAME | grep -aE 'com.wrw|utnciuwv|abitest|lib5'" 2>&1 | tr -d '\r'

echo "=== the state of the target process"
adb -s $S shell "cat /proc/2418/status | grep -aE 'Name|Uid|Gid|TracerPid'" 2>&1 | tr -d '\r'
adb -s $S shell "ls -l /proc/2418/exe /proc/2418/maps | head -5" 2>&1 | tr -d '\r'
echo "=== done"
