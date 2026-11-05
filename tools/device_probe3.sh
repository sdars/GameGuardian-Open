#!/usr/bin/env bash
# Which activities does the original helper expose and what does the daemon
# answer when the speed hack is requested?
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
S=8.162.0.198:30138

echo "=== the activities of the original helper"
adb -s $S shell "dumpsys package com.utnciuwv.ldcsra | grep -aE 'Activity|com.utnciuwv' | head -30" 2>&1 | tr -d '\r'
echo "=== the activities of our helper"
adb -s $S shell "dumpsys package com.wrw | grep -aE 'Activity|com.wrw' | head -30" 2>&1 | tr -d '\r'
echo "=== the installed launcher packages"
adb -s $S shell "pm list packages | grep -aE 'catch_|com.jmwal|com.gbuff|com.wrw|utnciuwv'" 2>&1 | tr -d '\r'
echo "=== the process list of the original helper"
adb -s $S shell "pm path com.utnciuwv.ldcsra; pm path com.wrw" 2>&1 | tr -d '\r'
echo "=== done"
