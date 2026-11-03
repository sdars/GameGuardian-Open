#!/usr/bin/env bash
# Publish the release APK as a github release asset.
#
#   tools/publish_release_asset.sh <release-id> [asset-file]
#
# The token is taken from the origin url of the repository
# (https://<token>@github.com/<owner>/<repo>.git).  An asset of the same name
# that is already attached to the release is replaced: github does not allow
# two assets with the same name, so the old one is deleted first.  The script
# prints the digest github computed for the uploaded file, it has to be equal
# to the sha256 of the local file.
set -uo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
REPO="${GG_REPO:-sdars/GameGuardian-Open}"
cd "$ROOT"

RELEASE_ID="${1:?usage: publish_release_asset.sh <release-id> [asset-file]}"
ASSET="${2:-$ROOT/release/GameGuardian-101.4-open.apk}"
NAME="$(basename "$ASSET")"
API="https://api.github.com/repos/$REPO"

TOKEN="$(git remote get-url origin | sed -n 's#https://\([^@]*\)@.*#\1#p')"
if [ -z "$TOKEN" ]; then
    echo "no token in the origin url" >&2
    exit 2
fi

OLD_ID="$(curl -s -H "Authorization: token $TOKEN" \
    "$API/releases/$RELEASE_ID/assets" \
    | python3 -c 'import json,sys
d=json.load(sys.stdin)
for a in d if isinstance(d,list) else []:
    if a["name"] == "'"$NAME"'":
        print(a["id"], a.get("digest", ""), a["size"])
        break')"

if [ -n "$OLD_ID" ]; then
    echo "==> delete the previous asset: $OLD_ID"
    curl --fail --silent --show-error -X DELETE \
        -H "Authorization: token $TOKEN" \
        "$API/releases/assets/$(echo "$OLD_ID" | cut -d' ' -f1)" \
        -o /dev/null
    echo "    rc=$?"
fi

echo "==> upload $ASSET ($(stat -c %s "$ASSET") bytes) as $NAME"
curl --fail --silent --show-error \
    -X POST \
    -H "Authorization: token $TOKEN" \
    -H "Content-Type: application/octet-stream" \
    --data-binary "@$ASSET" \
    "https://uploads.github.com/repos/$REPO/releases/$RELEASE_ID/assets?name=$NAME" \
    -o /tmp/gg_release_asset.json
echo "    rc=$?"

echo "==> state after the upload"
bash "$ROOT/tools/gh_asset_digest.sh" "$RELEASE_ID"
echo "==> local sha256"
sha256sum "$ASSET"
