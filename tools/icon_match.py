import importlib.util
import sys

spec = importlib.util.spec_from_file_location('png_crop', '/root/gameguardian/tools/png_crop.py')
m = importlib.util.module_from_spec(spec)
spec.loader.exec_module(m)


def alpha_mask(path):
    w, h, px = m.load(path)
    pts = []
    for y in range(h):
        for x in range(w):
            i = (y * w + x) * 4
            if px[i + 3] > 100:
                pts.append((x, y, px[i], px[i + 1], px[i + 2]))
    return w, h, pts


def match(shot, box, tmpl):
    sw, sh, spx = m.load(shot)
    tw, th, tpts = alpha_mask(tmpl)
    if not tpts:
        return 0, 0
    x0, y0, x1, y1 = box
    best = (0, 0, 0)
    for oy in range(y0, y1 - th):
        for ox in range(x0, x1 - tw):
            hit = 0
            for (tx, ty, r, g, b) in tpts:
                i = ((oy + ty) * sw + ox + tx) * 4
                if spx[i] > 120 and spx[i + 1] > 120 and spx[i + 2] > 120:
                    hit += 1
            if hit > best[0]:
                best = (hit, ox, oy)
    return best, len(tpts)


if __name__ == '__main__':
    shot = sys.argv[1]
    box = tuple(int(v) for v in sys.argv[2].split(','))
    for tmpl in sys.argv[3:]:
        best, total = match(shot, box, tmpl)
        print('%-46s hit %4d/%4d at (%d,%d)  %.1f%%' % (
            tmpl.split('/')[-1], best[0], total, best[1], best[2],
            100.0 * best[0] / total if total else 0))
