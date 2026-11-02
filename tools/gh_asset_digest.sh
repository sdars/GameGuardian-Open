#!/usr/bin/env bash
# Print the sha256 digest GitHub computed for the assets of a release.
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"
TOKEN="$(git remote get-url origin | sed -n 's#https://\([^@]*\)@.*#\1#p')"
RELEASE_ID="${1:?usage: gh_asset_digest.sh <release-id>}"
curl -s -H "Authorization: token $TOKEN" \
    "https://api.github.com/repos/sdars/GameGuardian-Open/releases/$RELEASE_ID/assets" \
    | python3 -c 'import json,sys
d=json.load(sys.stdin)
if isinstance(d,list):
    for a in d:
        print(a["name"], a["size"], a["state"], a.get("digest"), a["browser_download_url"])
else:
    print(d)'
