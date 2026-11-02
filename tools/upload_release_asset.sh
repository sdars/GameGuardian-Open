#!/usr/bin/env bash
# Upload the release APK to a github release.
#
#   tools/upload_release_asset.sh <release-id> [asset-file]
#
# The token is taken from the origin url of the repository
# (https://<token>@github.com/<owner>/<repo>.git).
set -uo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"

RELEASE_ID="${1:?usage: upload_release_asset.sh <release-id> [asset-file]}"
ASSET="${2:-$ROOT/release/GameGuardian-101.4-open.apk}"

TOKEN="$(git remote get-url origin | sed -n 's#https://\([^@]*\)@.*#\1#p')"
if [ -z "$TOKEN" ]; then
    echo "no token in the origin url" >&2
    exit 2
fi

NAME="$(basename "$ASSET")"
echo "==> upload $ASSET ($(stat -c %s "$ASSET") bytes) as $NAME"
curl --fail --silent --show-error \
    -X POST \
    -H "Authorization: token $TOKEN" \
    -H "Content-Type: application/octet-stream" \
    --data-binary "@$ASSET" \
    "https://uploads.github.com/repos/sdars/GameGuardian-Open/releases/$RELEASE_ID/assets?name=$NAME" \
    -o /tmp/gg_release_asset.json
echo "rc=$?"
python3 - <<'PY'
import json
d = json.load(open('/tmp/gg_release_asset.json'))
print('asset:', d.get('name'), d.get('size'), d.get('state'))
print('url  :', d.get('browser_download_url'))
print('msg  :', d.get('message'))
PY
