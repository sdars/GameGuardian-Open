#!/usr/bin/env bash
# Helper for talking to the GameGuardian test device.
export PATH=/root/gameguardian/tmp/tools/platform-tools:$PATH
PKG=catch_.me_.if_.you_.can_

case "$1" in
  stage)   adb shell su -mm -c "cat /data/data/$PKG/files/self-install.stage"; echo ;;
  ready)   adb shell su -mm -c "cat /data/data/$PKG/files/self-install.readiness" ;;
  id)      adb shell su -c id ;;
  su)      adb shell su -mm -c "$2" ;;
  ls)      adb shell su -mm -c "ls -la $2" ;;
  start)   adb shell am start -n $PKG/.MainActivity ;;
  stop)    adb shell am force-stop $PKG ;;
  ui)      adb shell su -mm -c "uiautomator dump /sdcard/ui_now.xml >/dev/null 2>&1";
           adb shell su -mm -c "cat /sdcard/ui_now.xml" | tr ">" "\n" | sed -n "s/.*text=\"\([^\"]*\)\".*/\1/p" | grep -v "^$" ;;
  shot)    adb shell su -mm -c "screencap -p /sdcard/now.png";
           adb pull /sdcard/now.png /root/gameguardian/build/now.png >/dev/null;
           echo /root/gameguardian/build/now.png ;;
  logcat)  adb logcat -d -v time | tail -"${2:-200}" ;;
  *)       echo "usage: $0 {stage|ready|id|su|ls|start|stop|ui|shot|logcat}" ;;
esac
