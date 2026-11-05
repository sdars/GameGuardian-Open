#!/bin/bash
# run a shell script on the device as root and store the answer on the host
#   tools/dsh.sh <local script> [out name]
set -u
ROOT=/root/gameguardian
A=$ROOT/tmp/tools/platform-tools/adb
S=$1
OUT=${2:-$(basename "$S" .sh)}
LOG=$ROOT/build/flow/${OUT}.out
rm -f "$LOG"
{
  echo "### push $S"
  $A -s 8.162.0.198:30138 push "$S" /data/local/tmp/gg_$OUT.sh
  echo "### run"
  timeout 600 $A -s 8.162.0.198:30138 shell "su -c sh /data/local/tmp/gg_$OUT.sh"
  echo "### rc=$?"
} >"$LOG" 2>&1
echo done >>"$LOG"
