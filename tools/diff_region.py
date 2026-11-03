import importlib.util
import sys

spec = importlib.util.spec_from_file_location('png_rgba', '/root/gameguardian/tools/png_rgba.py')
m = importlib.util.module_from_spec(spec)
spec.loader.exec_module(m)


def main():
    a = sys.argv[1]
    b = sys.argv[2]
    x0, y0, x1, y1 = [int(v) for v in sys.argv[3].split(',')]
    wa, ha, pa = m.load(a)
    wb, hb, pb = m.load(b)
    x1 = min(x1, wa, wb)
    y1 = min(y1, ha, hb)
    diff = 0
    total = 0
    minx, miny, maxx, maxy = x1, y1, x0, y0
    for y in range(y0, y1):
        for x in range(x0, x1):
            i = (y * wa + x) * 4
            total += 1
            if (pa[i], pa[i + 1], pa[i + 2]) != (pb[i], pb[i + 1], pb[i + 2]):
                diff += 1
                minx = min(minx, x)
                maxx = max(maxx, x)
                miny = min(miny, y)
                maxy = max(maxy, y)
    print('box (%d,%d)-(%d,%d)  %d px' % (x0, y0, x1, y1, total))
    if diff:
        print('  different: %d (%.2f%%)  bbox (%d,%d)-(%d,%d)' % (
            diff, 100.0 * diff / total, minx, miny, maxx + 1, maxy + 1))
    else:
        print('  identical')


if __name__ == '__main__':
    main()
