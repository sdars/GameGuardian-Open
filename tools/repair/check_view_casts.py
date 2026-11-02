#!/usr/bin/env python3
"""Cross-check findViewById() casts in the Java sources against the layout XML.

The reconstruction added a number of casts that the original dex does not
have (the original stores the raw View in a android/view/View field).  Every
such bogus cast is a ClassCastException waiting to happen on device, so this
script lists them all at once.

usage: check_view_casts.py [root-of-the-project]
"""
import os
import re
import sys
import xml.etree.ElementTree as ET

ROOT = sys.argv[1] if len(sys.argv) > 1 else os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, "app/src/main/java")
LAY = os.path.join(ROOT, "app/src/main/res/layout")

ANDROID = "http://schemas.android.com/apk/res/android"


def class_hierarchy():
    """name -> superclass, for every class we ship ourselves."""
    parents = {}
    for dirpath, _dirs, files in os.walk(SRC):
        for fn in files:
            if not fn.endswith(".java"):
                continue
            path = os.path.join(dirpath, fn)
            with open(path, "r", errors="replace") as fh:
                text = fh.read()
            m = re.search(r"\bclass\s+(\w+)(?:\s+extends\s+([\w.]+))?", text)
            if not m:
                continue
            name, parent = m.group(1), m.group(2)
            pkg = os.path.relpath(dirpath, SRC).replace(os.sep, ".")
            full = pkg + "." + name if pkg != "" else name
            parents[full] = parent
    return parents


def android_parents():
    return {
        # framework hierarchy (only the part we can reach from a widget)
        "android.view.View": None,
        "android.view.ViewGroup": "android.view.View",
        "android.widget.TextView": "android.view.View",
        "android.widget.EditText": "android.widget.TextView",
        "android.widget.Button": "android.widget.TextView",
        "android.widget.CompoundButton": "android.widget.Button",
        "android.widget.CheckBox": "android.widget.CompoundButton",
        "android.widget.RadioButton": "android.widget.CompoundButton",
        "android.widget.ToggleButton": "android.widget.CompoundButton",
        "android.widget.ImageView": "android.view.View",
        "android.widget.ImageButton": "android.widget.ImageView",
        "android.widget.ProgressBar": "android.view.View",
        "android.widget.LinearLayout": "android.view.ViewGroup",
        "android.widget.FrameLayout": "android.widget.LinearLayout",
        "android.widget.RelativeLayout": "android.view.ViewGroup",
        "android.widget.ScrollView": "android.widget.FrameLayout",
        "android.widget.HorizontalScrollView": "android.widget.ScrollView",
        "android.widget.AdapterView": "android.view.ViewGroup",
        "android.widget.AbsListView": "android.widget.AdapterView",
        "android.widget.ListView": "android.widget.AbsListView",
        "android.widget.GridView": "android.widget.AbsListView",
        "android.widget.SeekBar": "android.widget.ProgressBar",
        "android.widget.RadioGroup": "android.widget.LinearLayout",
        "android.widget.TabWidget": "android.widget.LinearLayout",
        "android.widget.TabHost": "android.widget.FrameLayout",
        "android.widget.Switch": "android.widget.CompoundButton",
        "android.fix.TextView": "android.widget.TextView",
        "android.fix.TextButtonView": "android.fix.TextView",
        "android.fix.ProgressBar": "android.widget.ProgressBar",
        "android.fix.ImageView": "android.widget.ImageView",
        "android.fix.ImageButtonView": "android.fix.ImageView",
        "android.fix.ImageButton": "android.widget.ImageButton",
        "android.fix.LinearLayout": "android.widget.LinearLayout",
        "android.fix.FrameLayout": "android.widget.FrameLayout",
        "android.fix.ListView": "android.widget.ListView",
        "android.fix.EditText": "android.widget.EditText",
        "android.fix.Button": "android.widget.Button",
        "android.fix.CheckBox": "android.widget.CheckBox",
        "android.fix.RadioButton": "android.widget.RadioButton",
        "android.fix.RadioGroup": "android.widget.RadioGroup",
        "android.fix.ScrollView": "android.widget.ScrollView",
        "android.fix.HorizontalScrollView": "android.widget.HorizontalScrollView",
        "android.fix.SeekBar": "android.widget.SeekBar",
        "android.fix.TabHost": "android.widget.TabHost",
        "android.fix.TabWidget": "android.widget.TabWidget",
        "android.fix.ToolbarButton": "android.widget.ImageButton",
        "android.fix.WrapLayout": "android.widget.LinearLayout",
        "android.ext.EditText": "android.fix.EditText",
    }


def is_a(child, parent, parents):
    seen = 0
    cur = child
    while cur and seen < 20:
        if cur == parent:
            return True
        cur = parents.get(cur)
        seen += 1
    return False


def layout_widgets():
    """id name -> widget class as declared in the layout files."""
    out = {}
    if not os.path.isdir(LAY):
        return out
    tag_re = re.compile(r"<([\w.]+)[^>]*?android:id=\"@id/(\w+)\"")
    for fn in sorted(os.listdir(LAY)):
        if not fn.endswith(".xml"):
            continue
        with open(os.path.join(LAY, fn), "r", errors="replace") as fh:
            body = fh.read()
        for cls, name in tag_re.findall(body):
            out.setdefault(name, cls)
    return out


def main():
    parents = class_hierarchy()
    parents.update(android_parents())
    widgets = layout_widgets()
    cast_re = re.compile(r"\(\s*([\w.]+)\s*\)\s*[\w.\[\]\(\)]*?findViewById\(\s*(?:[\w.]+\.)?R\.id\.(\w+)\s*\)")
    bad = []
    total = 0
    for dirpath, _dirs, files in os.walk(SRC):
        for fn in files:
            if not fn.endswith(".java"):
                continue
            path = os.path.join(dirpath, fn)
            with open(path, "r", errors="replace") as fh:
                lines = fh.readlines()
            for no, line in enumerate(lines, 1):
                for cast, wid in cast_re.findall(line):
                    total += 1
                    actual = widgets.get(wid)
                    if actual is None:
                        continue
                    if not is_a(actual, cast, parents):
                        bad.append((os.path.relpath(path, ROOT), no, cast, wid, actual))
    print("checked %d findViewById casts, %d mismatches" % (total, len(bad)))
    for rel, no, cast, wid, actual in bad:
        print("  %s:%d  cast %s but @id/%s is %s" % (rel, no, cast, wid, actual))
    return 1 if bad else 0


if __name__ == "__main__":
    sys.exit(main())
