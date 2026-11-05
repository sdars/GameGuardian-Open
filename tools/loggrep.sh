#!/bin/sh
# grep the log of the device
logcat -d -v time | grep -a -i -e 'setenforce' -e 'SELinux (' -e 'android-daemon' -e 'Daemon:' | tail -60
