#!/usr/bin/env python3
"""Print the visible texts of the screen.

    python3 tools/uistate.py [tag]
"""
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402


def main():
    tag = sys.argv[1] if len(sys.argv) > 1 else 'ui'
    xml = adlib.dump(tag, 'state')
    seen = []
    for n in adlib.nodes(xml):
        t = n['text'].strip()
        if t and t not in seen:
            seen.append(t)
    for t in seen:
        print(t)
    return 0


if __name__ == '__main__':
    sys.exit(main())
