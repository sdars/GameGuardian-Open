import sys

exec(open('/root/gameguardian/tools/png_probe.py').read().split('w, h, px = load')[0])

w, h, px = load(sys.argv[1])
x0 = int(sys.argv[2]) if len(sys.argv) > 2 else 38
x1 = int(sys.argv[3]) if len(sys.argv) > 3 else 62
rows = []
for y in range(h):
    bright = 0
    for x in range(x0, min(x1, w)):
        i = (y * w + x) * 4
        r, g, b = px[i], px[i + 1], px[i + 2]
        if r > 150 and g > 150 and b > 150:
            bright += 1
    rows.append(bright)

run = None
for y, v in enumerate(rows):
    if v > 0 and run is None:
        run = y
    elif v == 0 and run is not None:
        print('icon rows %d-%d center=%d' % (run, y - 1, (run + y - 1) // 2))
        run = None
if run is not None:
    print('icon rows %d-%d center=%d' % (run, h - 1, (run + h - 1) // 2))
