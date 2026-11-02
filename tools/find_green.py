import sys

exec(open('/root/gameguardian/tools/png_probe.py').read().split('w, h, px = load')[0])

w, h, px = load(sys.argv[1])
x0 = int(sys.argv[2]) if len(sys.argv) > 2 else 0
y0 = int(sys.argv[3]) if len(sys.argv) > 3 else 0
x1 = int(sys.argv[4]) if len(sys.argv) > 4 else w
y1 = int(sys.argv[5]) if len(sys.argv) > 5 else h
minx, miny, maxx, maxy, n = w, h, 0, 0, 0
for y in range(y0, min(y1, h)):
    for x in range(x0, min(x1, w)):
        i = (y * w + x) * 4
        r, g, b = px[i], px[i + 1], px[i + 2]
        if g > 110 and g > r + 40 and g > b + 40:
            n += 1
            minx = min(minx, x)
            maxx = max(maxx, x)
            miny = min(miny, y)
            maxy = max(maxy, y)
if n:
    print('green pixels=%d bbox=(%d,%d)-(%d,%d) center=(%d,%d)' % (n, minx, miny, maxx, maxy, (minx + maxx) // 2, (miny + maxy) // 2))
else:
    print('no green pixels in %d,%d-%d,%d' % (x0, y0, x1, y1))
