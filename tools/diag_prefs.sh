#!/usr/bin/env bash
# Collect the preferences of every GameGuardian build on the device together
# with the timestamps, so that the copy that happens during the self install
# can be reconstructed.
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
OUT=$ROOT/build/diag
mkdir -p "$OUT"

adb shell 'su -c "ls -l /data/user/0/*/shared_prefs/*_preferences.xml 2>/dev/null"' > "$OUT/ls.txt" 2>&1
for p in com.utnciuwv.ldcsra com.uyileqmdfw com.n.sowvcdkhh com.wrw com.fqqvbgr com.xzqwitnufxpj com.oyn com.xplwru com.zijosy com.hdzj.yopvkq com.vygybmu com.gdkmke com.rhbqjlp; do
    adb shell "su -c 'cat /data/user/0/$p/shared_prefs/${p}_preferences.xml 2>/dev/null'" > "$OUT/$p.xml" 2>&1
    echo "== $p" >> "$OUT/all.txt"
    cat "$OUT/$p.xml" >> "$OUT/all.txt"
done
adb logcat -d -v time > "$OUT/logcat.txt" 2>&1
echo done
