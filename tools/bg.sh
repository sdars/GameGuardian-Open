#!/bin/bash
# start a command in the background, detached from the shell of the caller
#   tools/bg.sh <logfile> <command...>
set -u
LOG=$1
shift
cd /root/gameguardian
setsid nohup "$@" >"$LOG" 2>&1 </dev/null &
echo "started: $* -> $LOG"
