#!/usr/bin/env bash
# Regenerate every class of the pure-source tree from the ground truth smali
# of the original dex.
#
#   bash tools/repair/regen_all.sh [package ...]
#
# Without arguments the three packages that make up the lua engine are
# regenerated: gg_g (the compiler), luaj (the vm) and luaj/lib (the
# standard library).
set -u

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
cd "$ROOT"

regen_dir() {
    local smali_dir="$1"
    local java_dir="$2"
    local f b j
    for f in "$smali_dir"/*.smali; do
        [ -e "$f" ] || continue
        b="$(basename "$f" .smali)"
        j="$java_dir/$b.java"
        [ -f "$j" ] || continue
        out="$(python3 tools/repair/regen_class.py "$f" "$j" 2>&1)"
        if printf '%s' "$out" | grep -qE 'FAIL|Traceback'; then
            printf '%s\n' "$out" | grep -E 'FAIL|Traceback|Error'
        fi
    done
}

for pkg in "$@"; do
    case "$pkg" in
        gg_g) regen_dir build/puresrc/original/g app/src/main/java/gg_g ;;
        luaj) regen_dir build/puresrc/original/luaj app/src/main/java/luaj ;;
        luaj/lib) regen_dir build/puresrc/original/luaj/lib app/src/main/java/luaj/lib ;;
        *) echo "unknown package $pkg" >&2; exit 2 ;;
    esac
done

echo 'regen done'
