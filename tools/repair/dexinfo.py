import struct, sys

d = open('tmp/analysis/2026-11-01/classes.dex', 'rb').read()


def u32(o):
    return struct.unpack_from('<I', d, o)[0]


def u16(o):
    return struct.unpack_from('<H', d, o)[0]


string_ids_off = u32(60)
type_ids_off = u32(68)
proto_ids_off = u32(76)
method_ids_off = u32(92)
class_defs_off = u32(100)
class_defs_size = u32(96)


def sstr(i):
    off = u32(string_ids_off + i * 4)
    p = off
    while True:
        b = d[p]
        p += 1
        if b < 0x80:
            break
    end = d.index(b'\x00', p)
    return d[p:end].decode('utf-8', 'replace')


def tystr(i):
    return sstr(u32(type_ids_off + i * 4))


def proto_str(pi):
    o = proto_ids_off + pi * 12
    ret = tystr(u32(o + 4))
    params_off = u32(o + 8)
    ps = []
    if params_off:
        n = u32(params_off)
        ps = [tystr(u16(params_off + 4 + 2 * i)) for i in range(n)]
    return '(' + ''.join(ps) + ')' + ret


def uleb(pos):
    r = 0
    sh = 0
    while True:
        b = d[pos]
        pos += 1
        r |= (b & 0x7f) << sh
        sh += 7
        if b < 0x80:
            break
    return r, pos


targets = {}
if len(sys.argv) > 1:
    for a in sys.argv[1:]:
        if '|' in a:
            cls, name, pr = a.split('|')
            targets[(cls, name, pr)] = True
        else:
            targets[a] = True
else:
    targets = {
        ('Landroid/ext/m;', 'e', '(Landroid/ext/n;[IJLjava/lang/String;)I'): True,
        ('Landroid/ext/n$a;', 'a', '(Landroid/ext/n;JLjava/lang/String;)I'): True,
        ('Lluaj/LuaClosure;', 'Y2', '([Lluaj/LuaValue;Lluaj/Varargs;Z)Lluaj/Varargs;'): True,
    }


for ci in range(class_defs_size):
    o = class_defs_off + ci * 32
    cls = tystr(u32(o))
    cdo = u32(o + 24)
    if cdo == 0:
        continue
    p = cdo
    sf, p = uleb(p)
    inf, p = uleb(p)
    dm, p = uleb(p)
    vm, p = uleb(p)
    fidx = 0
    for _ in range(sf):
        d1, p = uleb(p)
        fidx += d1
        _, p = uleb(p)
    fidx = 0
    for _ in range(inf):
        d1, p = uleb(p)
        fidx += d1
        _, p = uleb(p)
    for kind in range(2):
        cnt = dm if kind == 0 else vm
        midx = 0
        for _ in range(cnt):
            d1, p = uleb(p)
            midx += d1
            idx = midx
            af, p = uleb(p)
            code, p = uleb(p)
            mo = method_ids_off + idx * 8
            mcls_i = u16(mo)
            mproto_i = u16(mo + 2)
            mname_i = u32(mo + 4)
            mcls = tystr(mcls_i)
            mname = sstr(mname_i)
            mpr = proto_str(mproto_i)
            if mcls in targets:
                print('  ', mcls, mname, mpr, 'codeoff', hex(code))
            if (mcls, mname, mpr) in targets:
                if code == 0:
                    print(mcls, mname, mpr, '-> no code')
                    continue
                regs = u16(code)
                ins = u16(code + 2)
                outs = u16(code + 4)
                tries = u16(code + 6)
                dbg = u32(code + 8)
                insns_size = u32(code + 12)
                insns_off = code + 16
                print('%s->%s%s regs=%d ins=%d outs=%d tries=%d debug_off=%s insns_size=%d' % (
                    mcls, mname, mpr, regs, ins, outs, tries, hex(dbg), insns_size))
