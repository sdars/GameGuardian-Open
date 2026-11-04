#!/usr/bin/env bash
# Create a github release for a tag and print its id.
#
#   tools/gh_create_release.sh <tag> <name> <body-file>
#
# The token is taken from the origin url of the repository, the repository
# itself is taken from $GG_REPO (default sdars/GameGuardian-Open).
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
REPO="${GG_REPO:-sdars/GameGuardian-Open}"
cd "$ROOT"

TAG="${1:?usage: gh_create_release.sh <tag> <name> <body-file>}"
NAME="${2:?usage: gh_create_release.sh <tag> <name> <body-file>}"
BODY_FILE="${3:?usage: gh_create_release.sh <tag> <name> <body-file>}"

TOKEN="$(git remote get-url origin | sed -n 's#https://\([^@]*\)@.*#\1#p')"
if [ -z "$TOKEN" ]; then
    echo "no token in the origin url" >&2
    exit 2
fi

python3 - "$TAG" "$NAME" "$BODY_FILE" "$TOKEN" "$REPO" <<'PY'
import json
import sys
import urllib.request

tag, name, body_file, token, repo = sys.argv[1:6]
body = open(body_file, encoding='utf-8').read()
data = json.dumps({
    'tag_name': tag,
    'name': name,
    'body': body,
    'draft': False,
    'prerelease': False,
}).encode()
req = urllib.request.Request(
    'https://api.github.com/repos/%s/releases' % repo, data=data, method='POST',
    headers={'Authorization': 'token ' + token,
             'Accept': 'application/vnd.github+json',
             'Content-Type': 'application/json'})
with urllib.request.urlopen(req) as fh:
    d = json.load(fh)
print(d['id'])
print(d['html_url'])
PY
