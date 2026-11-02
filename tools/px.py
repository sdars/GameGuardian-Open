import sys

exec(open('/root/gameguardian/tools/png_probe.py').read().split('w, h, px = load')[0])

w, h, px = load(sys.argv[1])
for arg in sys.argv[2:]:
    x, y = [int(v) for v in arg.split(',')]
    i = (y * w + x) * 4
    print('(%d,%d) = %3d,%3d,%3d,%3d' % (x, y, px[i], px[i + 1], px[i + 2], px[i + 3]))
