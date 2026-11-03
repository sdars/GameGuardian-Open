import importlib.util
import sys

spec = importlib.util.spec_from_file_location('png_rgba', '/root/gameguardian/tools/png_rgba.py')
m = importlib.util.module_from_spec(spec)
spec.loader.exec_module(m)


def main():
    path = sys.argv[1]
    x0, y0, x1, y1 = [int(v) for v in sys.argv[2].split(',')]
    thr = int(sys.argv[3]) if len(sys.argv) > 3 else 170
    w, h, px = m.load(path)
    x1 = min(x1, w)
    y1 = min(y1, h)
    runs = []
    start = None
    for x in range(x0, x1):
        n = 0
        for y in range(y0, y1):
            i = (y * w + x) * 4
            if px[i] > thr and px[i + 1] > thr and px[i + 2] > thr:
                n += 1
        if n and start is None:
            start = x
        elif not n and start is not None:
            runs.append((start, x))
            start = None
    if start is not None:
        runs.append((start, x1))
    print(path, 'bright columns in', (x0, y0, x1, y1))
    for a, b in runs:
        print('    x %d..%d  (%d px wide)' % (a, b, b - a))


if __name__ == '__main__':
    main()
