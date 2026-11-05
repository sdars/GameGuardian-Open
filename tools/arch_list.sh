#!/bin/sh
# list the running processes of the device with the class of their binary
for p in /proc/[0-9]*; do
  e=$p/exe
  [ -r "$e" ] || continue
  m=$(od -An -tx1 -N5 "$e" 2>/dev/null | tr -d ' \n')
  case "$m" in
    7f454c4601*) a=32 ;;
    7f454c4602*) a=64 ;;
    *) a=other ;;
  esac
  n=$(cat "$p/comm" 2>/dev/null)
  echo "$a $n"
done | sort -u
