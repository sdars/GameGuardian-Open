"""Print the centre coordinates of a widget of a uiautomator dump.

usage: find_widget.py <dump.xml> <type_button|value_field|by_text>
"""
import re
import sys


def nodes(path):
    s = open(path).read()
    out = []
    for m in re.finditer(r"<node[^>]*>", s):
        t = m.group(0)
        txt = re.search(r'text="([^"]*)"', t)
        cls = re.search(r'class="([^"]*)"', t)
        b = re.search(r'bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', t)
        if not b:
            continue
        out.append({
            "text": txt.group(1) if txt else "",
            "class": cls.group(1) if cls else "",
            "rid": (re.search(r'resource-id="([^"]*)"', t).group(1)
                    if re.search(r'resource-id="([^"]*)"', t) else ""),
            "box": [int(v) for v in b.groups()],
        })
    return out


def centre(box):
    return ((box[0] + box[2]) // 2, (box[1] + box[3]) // 2)


def main():
    path, what = sys.argv[1], sys.argv[2]
    ns = nodes(path)
    if what == "by_text":
        want = sys.argv[3]
        for n in ns:
            if want in n["text"]:
                x, y = centre(n["box"])
                print(x, y, len(n["text"]))
                return
        sys.exit(1)
    if what == "type_button":
        for n in ns:
            if n["rid"].endswith("/id/type"):
                x, y = centre(n["box"])
                print(x, y)
                return
        for i, n in enumerate(ns):
            if n["text"].strip() == "类型：" and i + 1 < len(ns):
                x, y = centre(ns[i + 1]["box"])
                print(x, y)
                return
    elif what == "value_field":
        for n in ns:
            if n["rid"].endswith("/id/number"):
                x, y = centre(n["box"])
                print(x, y, len(n["text"]))
                return
        for n in ns:
            if n["class"].endswith("EditText") and n["box"][2] - n["box"][0] > 200 \
                    and n["box"][1] > 150:
                x, y = centre(n["box"])
                print(x, y, len(n["text"]))
                return
    sys.exit(1)


if __name__ == "__main__":
    main()
