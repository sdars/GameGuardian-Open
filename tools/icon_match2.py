import importlib.util
import sys

spec = importlib.util.spec_from_file_location('png_rgba', '/root/gameguardian/tools/png_rgba.py')
m = importlib.util.module_from_spec(spec)
spec.loader.exec_module(m)


def tpl(path, scale):
    w, h, px = m.load(path)
    pts = []
    for y in range(h):
        for x in range(w):
            i = (y * w + x) * 4
            if px[i + 3] > 100:
                pts.append((x * scale, y * scale))
    return w * scale, h * scale, pts


def score(shot, sw, spx, box, tmpl, scale):
    tw, th, pts = tpl(tmpl, scale)
    x0, y0, x1, y1 = box
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
    return best, len(pts)


if __name__ == '__main__':
    shot = sys.argv[1]
    tmpls = sys.argv[2:]
    sw, sh, spx = m.load(shot)
    for i in range(8):
        x0 = 90 * i + 6
        box = (x0, 210, x0 + 78, 298)
        out = []
        for t in tmpls:
            b, tot = score(shot, sw, spx, box, t, 2)
            out.append('%s=%.0f%%' % (t.split('/')[-1].replace('.png', ''), 100.0 * b[0] / tot if tot else 0))
        print('icon %d [%3d-%3d]: %s' % (i, x0, x0 + 78, '  '.join(out)))
