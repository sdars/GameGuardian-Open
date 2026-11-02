#!/usr/bin/env python3
"""Update the body of a github release.

    tools/gh_update_release_body.py <release-id> <body-file>

The token is taken from the origin url of the repository.
"""
import json
import subprocess
import sys
import urllib.request


def token():
    url = subprocess.check_output(
        ["git", "remote", "get-url", "origin"], text=True).strip()
    return url.split("https://", 1)[1].split("@", 1)[0]


def main():
    if len(sys.argv) != 3:
        sys.exit("usage: gh_update_release_body.py <release-id> <body-file>")
    release_id, body_file = sys.argv[1], sys.argv[2]
    body = open(body_file, encoding="utf-8").read()
    url = ("https://api.github.com/repos/sdars/GameGuardian-Open/releases/"
           + release_id)
    data = json.dumps({"body": body}).encode()
    req = urllib.request.Request(url, data=data, method="PATCH", headers={
        "Authorization": "token " + token(),
        "Content-Type": "application/json",
        "Accept": "application/vnd.github+json",
    })
    with urllib.request.urlopen(req) as resp:
        d = json.load(resp)
    print(d["html_url"], len(d["body"]), "chars")


if __name__ == "__main__":
    main()
