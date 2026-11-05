#!/usr/bin/env bash
# list the releases of the repositories of the project
set -uo pipefail
cd /root/gameguardian
TOKEN="$(git remote get-url origin | sed -n 's#https://\([^@]*\)@.*#\1#p')"
for repo in sdars/GameGuardian-Open-Source sdars/GameGuardian-Open; do
    echo "=== $repo"
    curl -s -H "Authorization: token $TOKEN" \
        "https://api.github.com/repos/$repo/releases" >/tmp/gg_rel_list.json
    python3 - /tmp/gg_rel_list.json <<'PY'
import json
import sys

data = json.load(open(sys.argv[1]))
if isinstance(data, list):
    for r in data:
        print(r['tag_name'], r['id'], r['name'], r.get('published_at'))
else:
    print(data)
PY
done
