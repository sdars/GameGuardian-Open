#!/usr/bin/env bash
# Show the releases and tags of the repository (token comes from the origin url).
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"
TOKEN="$(git remote get-url origin | sed -n 's#https://\([^@]*\)@.*#\1#p')"
echo "== releases =="
curl -s -H "Authorization: token $TOKEN" \
    https://api.github.com/repos/sdars/GameGuardian-Open/releases \
    | python3 -c 'import json,sys
d=json.load(sys.stdin)
if isinstance(d,list):
    for r in d:
        print(r["id"], r["tag_name"], repr(r["name"]), "draft=%s" % r["draft"], "pre=%s" % r["prerelease"], r["published_at"], r["html_url"])
        for a in r.get("assets",[]):
            print("    asset:", a["name"], a["size"], a["state"], a["browser_download_url"])
else:
    print(d)'
echo "== tags =="
curl -s -H "Authorization: token $TOKEN" \
    https://api.github.com/repos/sdars/GameGuardian-Open/tags \
    | python3 -c 'import json,sys
d=json.load(sys.stdin)
print([t["name"] for t in d] if isinstance(d,list) else d)'
