#!/system/bin/sh
# scan_pattern.sh <pid> <hex pattern>
#
# Reads the memory of the process on the device and prints every place
# where the pattern (a string of hex byte pairs) shows up:
#
#   region  address
#
# The scan runs on the device, only the hits travel over the link.
PID=$1
PAT=$2
OUT=/data/local/tmp/scan_pattern.txt
: > "$OUT"
for MAP in `su -c "cat /proc/$PID/maps" | grep ' rw-p ' | awk '{print $1}'`; do
    START=`echo $MAP | cut -d- -f1`
    END=`echo $MAP | cut -d- -f2`
    SIZE=$(( 0x$END - 0x$START ))
    BLOCKS=$(( SIZE / 4096 ))
    [ "$BLOCKS" -lt 1 ] && continue
    su -c "dd if=/proc/$PID/mem bs=4096 skip=$(( 0x$START / 4096 )) count=$BLOCKS 2>/dev/null | xxd -p | tr -d '\n' | grep -bo $PAT" | while read OFF REST; do
        BYTES=$(( ${OFF%%:*} / 2 ))
        ADDR=$( printf '%x' $(( 0x$START + BYTES )) )
        echo "$MAP $ADDR" >> "$OUT"
    done
done
echo DONE >> "$OUT"
