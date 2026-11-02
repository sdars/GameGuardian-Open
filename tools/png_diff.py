import sys

src = open('tools/png_probe.py').read().split('w, h, px = load(')[0]
ns = {}
exec(src, ns)

a = sys.argv[1]
b = sys.argv[2]
wa, ha, pa = ns['load'](a)
wb, hb, pb = ns['load'](b)

if wa != wb or ha != hb:
    print('size differs: %dx%d vs %dx%d' % (wa, ha, wb, hb))

w = min(wa, wb)
h = min(ha, hb)
diff = 0
first = []
for y in range(h):
    for x in range(w):
        i = (y * wa + x) * 4
        j = (y * wb + x) * 4
        if pa[i:i + 3] != pb[j:j + 3]:
            diff += 1
            if len(first) < 12:
                first.append((x, y, tuple(pa[i:i + 3]), tuple(pb[j:j + 3])))
total = w * h
print('%s vs %s: %d/%d pixels differ (%.3f%%)' % (a, b, diff, total, 100.0 * diff / total))
for f in first:
    print('   at (%d,%d) %s != %s' % f)
