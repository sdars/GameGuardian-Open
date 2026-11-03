import importlib.util
import sys

spec = importlib.util.spec_from_file_location('png_rgba', '/root/gameguardian/tools/png_rgba.py')
m = importlib.util.module_from_spec(spec)
spec.loader.exec_module(m)


def main():
    path = sys.argv[1]
    x0, y0, x1, y1 = [int(v) for v in sys.argv[2].split(',')]
    step = int(sys.argv[3]) if len(sys.argv) > 3 else 4
    thr = int(sys.argv[4]) if len(sys.argv) > 4 else 150
    w, h, px = m.load(path)
    x1 = min(x1, w)
    y1 = min(y1, h)
    print('%s  region %s  step %d' % (path, (x0, y0, x1, y1), step))
    hdr = '     '
    for x in range(x0, x1, step):
        hdr += '%d' % ((x // step) % 10)
    print(hdr)
    for y in range(y0, y1, step):
        row = '%4d ' % y
        for x in range(x0, x1, step):
            n = 0
            tot = 0
            for yy in range(y, min(y + step, y1)):
                for xx in range(x, min(x + step, x1)):
                    i = (yy * w + xx) * 4
                    tot += 1
                    if px[i] > thr and px[i + 1] > thr and px[i + 2] > thr:
                        n += 1
            frac = n / float(tot or 1)
            row += '#' if frac > 0.5 else ('+' if frac > 0.15 else ('.' if frac > 0.02 else ' '))
        print(row)


if __name__ == '__main__':
    main()
