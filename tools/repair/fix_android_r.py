#!/usr/bin/env python3
"""Repair jadx's rendering of Android framework resource constants.

jadx prints a framework resource id as "android.R$id.text1" or
"android.R$style.Theme.DeviceDefault".  In Java the nested class has to be
written with a dot and the style names are joined with an underscore, so the
references become "android.R.id.text1" / "android.R.style.Theme_DeviceDefault".

One reference is a decompiler artefact: in android/ext/n$a.java jadx turned
the literal 17825792 into "android.R$raw.loaderror" (android.R$raw has no
such field).  The real value was read back out of the original dex
(tmp/analysis/2026-11-01/apktool_src/smali/android/ext/n$a.smali, :array_0,
element 488) and is restored as the literal it always was.
"""
import os
import re

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

# jadx's bogus rendering -> the literal the dex actually held
LITERALS = {
    'android.R$raw.loaderror': '17825792',
}


def style_fix(m):
    tail = m.group(2).lstrip('.').replace('.', '_')
    return 'android.R.style.' + m.group(1) + '_' + tail


n_files = 0
for dirpath, _dirs, names in os.walk(SRC):
    for nm in names:
        if not nm.endswith('.java'):
            continue
        path = os.path.join(dirpath, nm)
        text = orig = open(path, encoding='utf-8').read()
        for bad, good in LITERALS.items():
            if bad in text:
                text = text.replace(bad, good)
        text = re.sub(r'android\.R\$style\.([A-Za-z_][A-Za-z_0-9]*)((?:\.[A-Za-z][A-Za-z_0-9]*)+)',
                      style_fix, text)
        text = re.sub(r'android\.R\$([A-Za-z]+)\.', r'android.R.\1.', text)
        # an earlier run of this script joined the parts with two underscores
        text = text.replace('android.R.style.Theme__', 'android.R.style.Theme_')
        if text != orig:
            open(path, 'w', encoding='utf-8').write(text)
            n_files += 1
            print('patched', os.path.relpath(path, ROOT))
print('files changed: %d' % n_files)
