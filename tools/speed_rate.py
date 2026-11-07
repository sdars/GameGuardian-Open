import sys, struct, time
sys.path.insert(0, '/root/gameguardian/tools')
import adlib


def su(cmd):
    q = cmd.replace("'", "'\\''")
    return adlib.adb('shell', "su -c '%s'" % q, timeout=180).stdout


def mem(pid, addr, size):
    out = su('dd if=/proc/%s/mem bs=1 skip=%d count=%d 2>/dev/null | od -A n -v -t x1' % (pid, addr, size))
    hexs = out.split()
    if len(hexs) < size:
        return None
    return bytes(int(x, 16) for x in hexs)


def clocks(pid):
    out = su('cat /proc/%s/maps' % pid)
    libs = [l for l in out.splitlines() if 'lib6.so' in l]
    if not libs:
        return []
    base = min(int(l.split('-')[0], 16) for l in libs)
    tab = mem(pid, base + 0x25f80, 16 * 8)
    if tab is None:
        return []
    res = []
    for i in range(16):
        obj = struct.unpack('<Q', tab[i * 8:i * 8 + 8])[0]
        if obj == 0:
            continue
        d = mem(pid, obj, 0x40)
        if d is None:
            continue
        num, den = struct.unpack('<ii', d[0x08:0x10])
        flag = d[0x18]
        last = struct.unpack('<q', d[0x20:0x28])[0]
        cur = struct.unpack('<q', d[0x28:0x30])[0]
        acc = struct.unpack('<q', d[0x30:0x38])[0]
        res.append(dict(slot=i, obj=obj, num=num, den=den, flag=flag,
                        last=last, cur=cur, acc=acc))
    return res


pid = sys.argv[1]
dur = float(sys.argv[2]) if len(sys.argv) > 2 else 60.0

a = clocks(pid)
if not a:
    print('no clock object in the target'); raise SystemExit(1)
t0 = time.time()
time.sleep(dur)
b = clocks(pid)
t1 = time.time()
wall = t1 - t0
print('wall %.1f s' % wall)
for x, y in zip(a, b):
    if x['obj'] != y['obj']:
        continue
    dcur = (y['cur'] - x['cur']) / 1e9
    dlast = (y['last'] - x['last']) / 1e9
    dacc = y['acc'] - x['acc']
    factor = dcur / dlast if dlast else 0
    print('slot %2d num=%d/%d flag=%d  virtual %+.3f s  real %+.3f s  factor %.4f  acc %+d' %
          (x['slot'], x['num'], x['den'], x['flag'], dcur, dlast, factor, dacc))
