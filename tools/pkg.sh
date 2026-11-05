#!/bin/bash
# print the package of the helper that the last deployment installed
set -u
STATE=/root/gameguardian/build/deploy.state
if [ -f "$STATE" ]; then
    tail -1 "$STATE"
fi
