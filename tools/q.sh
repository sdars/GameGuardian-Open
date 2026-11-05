#!/bin/bash
# run one command on the device as root and print the answer
#   tools/q.sh 'command with quotes'
set -u
ROOT=/root/gameguardian
A=$ROOT/tmp/tools/platform-tools/adb
S=8.162.0.198:30138
CMD=${1:?usage: q.sh 'command'}
printf '%s\n' "$CMD" >/tmp/gg_q.sh
timeout 120 $A -s $S push /tmp/gg_q.sh /data/local/tmp/gg_q.sh >/dev/null 2>&1
timeout 120 $A -s $S shell su -c sh /data/local/tmp/gg_q.sh 2>&1
