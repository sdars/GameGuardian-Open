import struct
import sys
import zlib


def load(path):
    d = open(path, 'rb').read()
    p = 8
    idat = b''
    w = h = 0
    while p < len(d):
        ln = struct.unpack_from('>I', d, p)[0]
        typ = d[p + 4:p + 8]
        data = d[p + 8:p + 8 + ln]
        if typ == b'IHDR':
            w, h, bd, ct = struct.unpack('>IIBB', data[:10])
        if typ == b'IDAT':
            idat += data
        p += 12 + ln
    raw = zlib.decompress(idat)
    bpp = 4
    stride = w * bpp
    out = bytearray(h * stride)
    prev = bytearray(stride)
    pos = 0
    for y in range(h):
        ft = raw[pos]
        pos += 1
        line = bytearray(raw[pos:pos + stride])
        pos += stride
        if ft == 1:
            for i in range(bpp, stride):
                line[i] = (line[i] + line[i - bpp]) & 255
        elif ft == 2:
            for i in range(stride):
                line[i] = (line[i] + prev[i]) & 255
        elif ft == 3:
            for i in range(stride):
                a = line[i - bpp] if i >= bpp else 0
                line[i] = (line[i] + ((a + prev[i]) >> 1)) & 255
        elif ft == 4:
            for i in range(stride):
                a = line[i - bpp] if i >= bpp else 0
                b = prev[i]
                c = prev[i - bpp] if i >= bpp else 0
                pa = abs(b - c)
                pb = abs(a - c)
                pc = abs(a + b - 2 * c)
                pr = a if (pa <= pb and pa <= pc) else (b if pb <= pc else c)
                line[i] = (line[i] + pr) & 255
        out[y * stride:(y + 1) * stride] = line
        prev = line
    return w, h, out


w, h, px = load(sys.argv[1])
print('size', w, h)
colors = {}
for y in range(0, h, 4):
    for x in range(0, w, 4):
        i = (y * w + x) * 4
        c = (px[i], px[i + 1], px[i + 2])
        colors[c] = colors.get(c, 0) + 1
top = sorted(colors.items(), key=lambda kv: -kv[1])[:8]
for c, n in top:
    print('color', c, 'count', n)
for arg in sys.argv[2:]:
    x, y = [int(v) for v in arg.split(',')]
    i = (y * w + x) * 4
    print('pixel', x, y, (px[i], px[i + 1], px[i + 2], px[i + 3]))
