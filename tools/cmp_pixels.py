import importlib.util
import sys
from collections import Counter

spec = importlib.util.spec_from_file_location('png_crop', '/root/gameguardian/tools/png_crop.py')
m = importlib.util.module_from_spec(spec)
spec.loader.exec_module(m)


def stats(path, box, label):
    w, h, px = m.load(path)
    x0, y0, x1, y1 = box
    c = Counter()
    total = 0
    for y in range(y0, min(y1, h)):
        for x in range(x0, min(x1, w)):
            i = (y * w + x) * 4
            c[(px[i], px[i + 1], px[i + 2])] += 1
            total += 1
    print(label, path, 'size', w, h, 'box', box)
    for col, n in c.most_common(4):
        print('    ', col, n, str(round(100.0 * n / total, 1)) + '%')


if __name__ == '__main__':
    boxes = {
        'value_field(100)': (300, 95, 640, 140),
        'addr_field_area': (250, 150, 640, 210),
        'label_area': (40, 100, 200, 135),
        'dialog_bg': (40, 640, 660, 700),
    }
    for name, b in boxes.items():
        stats(sys.argv[1], b, 'OURS  ' + name)
        stats(sys.argv[2], b, 'ORIG  ' + name)
        print('')
