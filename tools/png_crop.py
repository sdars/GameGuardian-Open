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
            w, h, bd, ct = struct.unpack_from('>IIBB', data[:10])
        elif typ == b'IDAT':
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
                b = prev[i]
                c = (a + b) >> 1
                line[i] = (line[i] + c) & 255
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


def save(path, w, h, px):
    raw = bytearray()
    for y in range(h):
        raw.append(0)
        raw += px[y * w * 4:(y + 1) * w * 4]
    comp = zlib.compress(bytes(raw), 6)

    def chunk(typ, data):
        c = struct.pack('>I', len(data)) + typ + data
        return c + struct.pack('>I', zlib.crc32(typ + data) & 0xffffffff)

    out = b'\x89PNG\r\n\x1a\n'
    out += chunk(b'IHDR', struct.pack('>IIBBBBB', w, h, 8, 6, 0, 0, 0))
    out += chunk(b'IDAT', comp)
    out += chunk(b'IEND', b'')
    open(path, 'wb').write(out)


if __name__ == '__main__':
    src = sys.argv[1]
    x0, y0, x1, y1 = [int(v) for v in sys.argv[2].split(',')]
    dst = sys.argv[3]
    scale = int(sys.argv[4]) if len(sys.argv) > 4 else 1
    w, h, px = load(src)
    x0 = max(0, min(w, x0))
    x1 = max(x0, min(w, x1))
    y0 = max(0, min(h, y0))
    y1 = max(y0, min(h, y1))
    cw, ch = x1 - x0, y1 - y0
    ow, oh = cw * scale, ch * scale
    out = bytearray(ow * oh * 4)
    for y in range(oh):
        sy = y0 + y // scale
        for x in range(ow):
            sx = x0 + x // scale
            si = (sy * w + sx) * 4
            di = (y * ow + x) * 4
            out[di:di + 4] = px[si:si + 4]
    save(dst, ow, oh, out)
    print('wrote', dst, ow, oh)
