import re
import sys

path = sys.argv[1]
pat = sys.argv[2]
src = open(path).read()
blocks = re.findall(r"(\.method[^\n]*\n.*?\.end method)", src, re.S)
for b in blocks:
    head = b.split("\n")[0]
    if re.search(pat, head):
        print(b.rstrip())
        print()
