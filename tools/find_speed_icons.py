import importlib.util
import sys

spec = importlib.util.spec_from_file_location('png_rgba', '/root/gameguardian/tools/png_rgba.py')
m = importlib.util.module_from_spec(spec)
spec.loader.exec_module(m)


def template(path):
    w, h, px = m.load(path)
    pts = []
    for y in range(h):
        for x in range(w):
            i = (y * w + x) * 4
            if px[i + 3] > 100:
                pts.append((x, y))
    return w, h, pts


def main():
    shot = sys.argv[1]
    tmpls = sys.argv[2:]
    x0, y0, x1, y1 = 0, 0, 0, 0
    if len(tmpls) > 1 and tmpls[-1].count(',') == 3:
        x0, y0, x1, y1 = [int(v) for v in tmpls[-1].split(',')]
        tmpls = tmpls[:-1]
    sw, sh, spx = m.load(shot)
    if x1:
        x1 = min(x1, sw)
        y1 = min(y1, sh)
    else:
        x1, y1 = sw, sh
    for t in tmpls:
        tw, th, pts = template(t)
        best = (0, 0, 0)
        for oy in range(y0, max(y0 + 1, y1 - th)):
            for ox in range(x0, max(x0 + 1, x1 - tw)):
                hit = 0
                for (tx, ty) in pts:
                    i = ((oy + ty) * sw + ox + tx) * 4
                    if spx[i] > 110 and spx[i + 1] > 110 and spx[i + 2] > 110:
                        hit += 1
                if hit > best[0]:
                    best = (hit, ox, oy)
        tot = len(pts)
        print('%s: %.0f%% at (%d,%d)  (%d/%d)' % (
            t.split('/')[-1], 100.0 * best[0] / tot if tot else 0, best[1], best[2], best[0], tot))


if __name__ == '__main__':
    main()
