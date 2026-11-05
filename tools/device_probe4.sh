#!/usr/bin/env bash
# Compare the daemon files of the reconstruction with the ones of the original
# helper: names, sizes and digests.
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
S=8.162.0.198:30138

echo "=== the digests of the daemon files of our helper"
adb -s $S shell "su -c 'sha256sum /data/user/0/com.wrw/files/GG-*/*'" 2>&1 | tr -d '\r'
echo "=== the digests of the daemon files of the original helper"
adb -s $S shell "su -c 'sha256sum /data/user/0/com.utnciuwv.ldcsra/files/GG-*/*'" 2>&1 | tr -d '\r'
echo "=== the content of the marker files"
adb -s $S shell "su -c 'echo -n ours:; cat /data/user/0/com.wrw/files/GG-*/gr; echo; echo -n orig:; cat /data/user/0/com.utnciuwv.ldcsra/files/GG-*/gr; echo; cat /data/user/0/com.utnciuwv.ldcsra/files/GG-*/FC.txt'" 2>&1 | tr -d '\r'
echo "=== done"
