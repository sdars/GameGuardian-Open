import struct
import zlib


def load(path):
    """Decode a PNG into (w, h, rgba bytes) supporting colour types 0/2/3/4/6."""
    d = open(path, 'rb').read()
    p = 8
    idat = b''
    w = h = 0
    ct = 6
    bd = 8
    plte = b''
    trns = b''
    while p < len(d):
        ln = struct.unpack_from('>I', d, p)[0]
        typ = d[p + 4:p + 8]
        data = d[p + 8:p + 8 + ln]
        if typ == b'IHDR':
            w, h, bd, ct = struct.unpack_from('>IIBB', data[:10])
        elif typ == b'PLTE':
            plte = data
        elif typ == b'tRNS':
            trns = data
        elif typ == b'IDAT':
            idat += data
        p += 12 + ln
    raw = zlib.decompress(idat)
    channels = {0: 1, 2: 3, 3: 1, 4: 2, 6: 4}[ct]
    bpp = channels
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
                c = prev[i - bpp] if i >= bpp else 0
                b = prev[i]
                pp = a + b - c
                pa, pb, pc = abs(pp - a), abs(pp - b), abs(pp - c)
                pr = a if (pa <= pb and pa <= pc) else (b if pb <= pc else c)
                line[i] = (line[i] + pr) & 255
        out[y * stride:(y + 1) * stride] = line
        prev = line
    rgba = bytearray(w * h * 4)
    for y in range(h):
        for x in range(w):
            i = y * stride + x * bpp
            o = (y * w + x) * 4
            if ct == 6:
                rgba[o:o + 4] = out[i:i + 4]
            elif ct == 2:
                rgba[o:o + 3] = out[i:i + 3]
                rgba[o + 3] = 255
            elif ct == 0:
                v = out[i]
                rgba[o:o + 3] = bytes((v, v, v))
                rgba[o + 3] = 255
            elif ct == 4:
                v = out[i]
                rgba[o:o + 3] = bytes((v, v, v))
                rgba[o + 3] = out[i + 1]
            elif ct == 3:
                idx = out[i]
                rgba[o:o + 3] = plte[idx * 3:idx * 3 + 3]
                rgba[o + 3] = trns[idx] if idx < len(trns) else 255
    return w, h, rgba
