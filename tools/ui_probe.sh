#!/bin/bash
# Drive the panel of the app on the device and keep the results.
#
#   tools/ui_probe.sh <prefix> <step> ...
#
# A step is one of
#
#   tap <x> <y>          a tap on the screen
#   press <x> <y>        a long press on the screen
#   swipe <x1> <y1> <x2> <y2> <ms>
#   shell <command>      a shell command on the device
#   dump <name>          a uiautomator dump, the ids are printed
#   shot <name>          a screen shot
#   sleep <seconds>
#
# The link to the phone is slow, so the script runs in the background and
# the caller reads /tmp/<prefix>.out when /tmp/<prefix>.flag shows up.
A=/root/gameguardian/tmp/tools/platform-tools/adb
PRE=$1
shift
O=/tmp/$PRE.out
: > "$O"
shot() {
  timeout 60 $A exec-out screencap -p > /tmp/$PRE.$1.png 2>/dev/null
  echo "-- shot $1" >> "$O"
}
dump() {
  P=/sdcard/ui_$PRE_$1.xml
  timeout 90 $A shell "rm -f $P; uiautomator dump $P" >> "$O" 2>&1
  timeout 90 $A exec-out cat $P > /tmp/$PRE.$1.xml 2>/dev/null
  echo "-- dump $1" >> "$O"
  grep -o 'resource-id="[^"]*" text="[^"]*" [^>]*bounds="[^"]*"' /tmp/$PRE.$1.xml | head -80 >> "$O"
}
while [ $# -gt 0 ]; do
  case "$1" in
    tap)   timeout 45 $A shell "input tap $2 $3" >> "$O" 2>&1; sleep 2 ;;
    press) timeout 45 $A shell "input swipe $2 $3 $2 $3 900" >> "$O" 2>&1; sleep 2 ;;
    swipe) timeout 45 $A shell "input swipe $2 $3 $4 $5 $6" >> "$O" 2>&1; sleep 2 ;;
    shell) timeout 45 $A shell "$2" >> "$O" 2>&1 ;;
    dump)  dump "$2" ;;
    shot)  shot "$2" ;;
    sleep) sleep "$2" ;;
    *) echo "unknown step $1" >> "$O" ;;
  esac
  shift
}
echo done > /tmp/$PRE.flag
