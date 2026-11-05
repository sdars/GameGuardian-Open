#!/bin/sh
# show the preferences of the installed build
cat /data/data/com.wntyypi/shared_prefs/com.wntyypi_preferences.xml
echo
echo --- files:
ls -la /data/data/com.wntyypi/files/
echo --- enforce:
getenforce
cat /sys/fs/selinux/enforce
