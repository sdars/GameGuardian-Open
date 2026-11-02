import re
import sys

path = sys.argv[1] if len(sys.argv) > 1 else "/root/gameguardian/build/ui_now.xml"
s = open(path).read()
for m in re.finditer(r'text="([^"]*)"[^>]*bounds="(\[\d+,\d+\]\[\d+,\d+\])"', s):
    if m.group(1).strip():
        b = re.findall(r"\d+", m.group(2))
        print("%-40s %s  center=(%d,%d)" % (m.group(1), m.group(2),
              (int(b[0]) + int(b[2])) // 2, (int(b[1]) + int(b[3])) // 2))
