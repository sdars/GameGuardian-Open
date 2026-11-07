#!/bin/bash
# Run a few adb shell commands on the device and keep the screen shot.
#
#     tools/dev.sh <prefix> <shell command> [<shell command> ...]
#
# The link to the phone is slow, so the commands run in the background and
# the result is read from /tmp/<prefix>.out, /tmp/<prefix>.png and
# /tmp/<prefix>.flag.
A=/root/gameguardian/tmp/tools/platform-tools/adb
PRE=$1
shift
O=/tmp/$PRE.out
: > "$O"
for c in "$@"; do
  echo "### $c" >> "$O"
  timeout 45 $A shell "$c" >> "$O" 2>&1
  echo "### rc=$?" >> "$O"
done
timeout 45 $A exec-out screencap -p > /tmp/$PRE.png 2>/dev/null
echo done > /tmp/$PRE.flag
