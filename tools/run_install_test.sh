#!/usr/bin/env bash
# Drive the GameGuardian self-install flow on the attached device.
#
# The tool session kills background jobs, so the flow is split into short
# phases that each fit into a single command window:
#
#   tools/run_install_test.sh start   # launch the app, dump the ui tree
#   tools/run_install_test.sh tap     # answer the "install mode" dialog
#   tools/run_install_test.sh check   # print the diagnostics + crash log
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
PKG=catch_.me_.if_.you_.can_
case "${1:-start}" in
  start)
    adb shell am force-stop "$PKG" >/dev/null 2>&1
    adb logcat -c >/dev/null 2>&1
    adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
    sleep 7
    adb shell uiautomator dump /sdcard/ui_now.xml >/dev/null 2>&1
    adb pull /sdcard/ui_now.xml "$ROOT/build/ui_now.xml" >/dev/null 2>&1
    python3 "$ROOT/tools/uix.py" "$ROOT/build/ui_now.xml" | head -30
    ;;
  tap)
    python3 - "$ROOT/build/ui_now.xml" <<'PY'
import re, subprocess, sys
try:
    body = open(sys.argv[1], encoding="utf-8", errors="replace").read()
except OSError:
    sys.exit(0)
for m in re.finditer(r'<node[^>]*text="([^"]*)"[^>]*bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', body):
    txt, x1, y1, x2, y2 = m.group(1), *map(int, m.groups()[1:])
    if txt in ("默认", "OK", "Ok"):
        cx, cy = (x1 + x2) // 2, (y1 + y2) // 2
        print("tap %r at (%d,%d)" % (txt, cx, cy))
        subprocess.run(["adb", "shell", "input", "tap", str(cx), str(cy)])
        break
PY
    ;;
  check)
    echo "=== gg-diag.log"
    adb shell su -mm -c "cat /data/data/$PKG/files/gg-diag.log" 2>/dev/null | tail -25
    echo "=== self-install.stage"
    adb shell su -mm -c "cat /data/data/$PKG/files/self-install.stage" 2>/dev/null
    echo "=== installed copies"
    adb shell su -mm -c "pm list packages | grep -i catch_" 2>/dev/null
    echo "=== crash check"
    adb logcat -d -v time -t 900 2>/dev/null | grep -E "FATAL EXCEPTION|Caused by:|at android.ext|at luaj" | tail -20
    ;;
  *)
    echo "usage: $0 {start|tap|check}"
    ;;
esac
