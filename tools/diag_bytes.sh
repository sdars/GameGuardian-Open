#!/usr/bin/env bash
# dump the exact bytes of the preferences of the GameGuardian builds and of a
# couple of ordinary applications, so that the format of the file can be
# compared.
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
OUT=$ROOT/build/diag
mkdir -p "$OUT"

adb shell 'su -c "cat /data/user/0/com.wrw/shared_prefs/com.wrw_preferences.xml"' > "$OUT/ours_raw.xml" 2>&1
adb shell 'su -c "cat /data/user/0/com.utnciuwv.ldcsra/shared_prefs/com.utnciuwv.ldcsra_preferences.xml"' > "$OUT/orig_raw.xml" 2>&1
adb shell 'su -c "ls /data/user/0/com.android.adbkeyboard/shared_prefs/ 2>/dev/null; cat /data/user/0/com.android.adbkeyboard/shared_prefs/*.xml 2>/dev/null | head -30"' > "$OUT/other_raw.xml" 2>&1
adb shell 'su -c "ls /data/user/0/ | grep -c ."' > "$OUT/count.txt" 2>&1
echo done
