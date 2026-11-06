#!/system/bin/sh
# helpers for the daemon of GameGuardian on the device
#
#   tools/ggq.sh status <pid>      the tracer and the state of a process
#   tools/ggq.sh flags <pid>       the mapping of the daemon
#   tools/ggq.sh diag              the log of the app
#   tools/ggq.sh daemon            the daemon of the app
#
case "$1" in
  status)
    PID=$2
    grep -E 'TracerPid|State|Name' /proc/$PID/status
    ;;
  flags)
    PID=$2
    grep -E 'lib5.so' /proc/$PID/maps
    ;;
  diag)
    tail -40 /data/data/com.dwgibmeuyozjuswy/files/gg-diag.log
    ;;
  daemon)
    for p in /proc/[0-9]*; do
      if grep -qa 'GG-cKrg/lib5.so' $p/maps 2>/dev/null; then
        echo "daemon pid ${p#/proc/}"
      fi
    done
    ;;
  *)
    echo "usage: ggq.sh status|flags|diag|daemon" >&2
    exit 1
    ;;
esac
