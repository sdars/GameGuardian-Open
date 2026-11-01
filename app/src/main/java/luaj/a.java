package luaj;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final luaj.Globals$d l = new luaj.a$c(null);
    public static java.lang.String m = null;
    public static final byte[] n = {27, 76, 117, 97};
    public static final byte[] o = {25, -109, 13, 10, 26, 10};
    private static final luaj.LuaValue[] p = new luaj.LuaValue[0];
    private static final luaj.h[] q = new luaj.h[0];
    private static final gg_f.b[] r = new gg_f.b[0];
    private static final gg_f.d[] s = new gg_f.d[0];
    private static final int[] t = new int[0];
    public static volatile boolean u = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1700f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1701g;
    private int h;
    public final java.io.DataInputStream i;
    java.lang.String j;
    private byte[] k = new byte[512];

    private a(java.io.InputStream inputStream, java.lang.String str) {
        this.j = str;
        this.i = new java.io.DataInputStream(inputStream);
    }

    private static luaj.h a(luaj.h hVar, luaj.LuaString luaString) {
        if (hVar.f1729g == null) {
            hVar.f1729g = luaString;
        }
        int i = 0;
        while (true) {
            luaj.h[] hVarArr = hVar.f1725c;
            if (i >= hVarArr.length) {
                return hVar;
            }
            a(hVarArr[i], hVar.f1729g);
            i++;
        }
    }

    public static java.lang.String b(java.lang.String str) {
        if (str.startsWith("@") || str.startsWith("=")) {
            return str.substring(1);
        }
        return str.startsWith("\u001b") ? "=?" : str;
    }

    public static void c(luaj.Globals globals) {
        globals.l0 = l;
    }

    public static luaj.LuaValue n(long j) {
        if ((Long.MAX_VALUE & j) == 0) {
            return luaj.LuaValue.f1677g;
        }
        int i = ((int) ((j >> 52) & 2047)) - 1023;
        if (i >= 0 && i < 31) {
            long j2 = 4503599627370495L & j;
            int i2 = 52 - i;
            if ((j2 & ((1 << i2) - 1)) == 0) {
                int i3 = ((int) (j2 >> i2)) | (1 << i);
                return luaj.LuaLong.I2((j >> 63) != 0 ? -i3 : i3);
            }
        }
        return luaj.LuaValue.J2(java.lang.Double.longBitsToDouble(j));
    }

    public static luaj.h o(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException {
        java.lang.String strB = str == null ? null : b(str);
        luaj.a aVar = new luaj.a(inputStream, strB);
        aVar.g();
        if (str == null) {
            return null;
        }
        int i = aVar.h;
        if (i == 0 || i == 1 || i == 4) {
            return a(aVar.f(), luaj.LuaString.K2(strB));
        }
        throw new luaj.d("unsupported int size: " + aVar.h);
    }

    void d(luaj.h hVar) throws java.io.IOException {
        int iH = h();
        luaj.LuaValue[] luaValueArr = iH > 0 ? new luaj.LuaValue[iH] : p;
        for (int i = 0; i < iH; i++) {
            byte b2 = this.i.readByte();
            if (b2 == -2) {
                luaValueArr[i] = luaj.LuaLong.I2(h());
            } else if (b2 == 0) {
                luaValueArr[i] = luaj.LuaValue.f1673c;
            } else if (b2 == 1) {
                luaValueArr[i] = this.i.readUnsignedByte() != 0 ? luaj.LuaValue.f1674d : luaj.LuaValue.f1675e;
            } else if (b2 == 3) {
                luaValueArr[i] = k();
            } else {
                if (b2 != 4) {
                    throw new java.lang.IllegalStateException("bad constant");
                }
                luaValueArr[i] = l();
            }
        }
        hVar.f1723a = luaValueArr;
        int iH2 = h();
        luaj.h[] hVarArr = iH2 > 0 ? new luaj.h[iH2] : q;
        for (int i2 = 0; i2 < iH2; i2++) {
            hVarArr[i2] = f();
        }
        hVar.f1725c = hVarArr;
    }

    void e(luaj.h hVar) throws java.io.IOException {
        luaj.LuaString luaStringL = l();
        if (luaStringL != null) {
            hVar.f1729g = luaStringL;
        }
        hVar.f1726d = j();
        int iH = h();
        hVar.f1727e = iH > 0 ? new gg_f.b[iH] : r;
        for (int i = 0; i < iH; i++) {
            hVar.f1727e[i] = new gg_f.b(l(), h(), h());
        }
        int iH2 = h();
        for (int i2 = 0; i2 < iH2; i2++) {
            hVar.f1728f[i2].f1565a = l();
        }
    }

    public luaj.h f() throws java.io.IOException {
        luaj.h hVar = new luaj.h();
        hVar.h = h();
        hVar.i = h();
        hVar.j = this.i.readUnsignedByte();
        hVar.k = this.i.readUnsignedByte();
        int unsignedByte = this.i.readUnsignedByte();
        hVar.l = unsignedByte;
        if (unsignedByte >= hVar.j) {
            hVar.f1724b = j();
            d(hVar);
            m(hVar);
            e(hVar);
            return hVar;
        }
        throw new luaj.d("Damaged script 2: .maxstacksize (" + hVar.l + ") < .numparams (" + hVar.j + ")");
    }

    public void g() throws java.io.IOException {
        this.f1695a = this.i.readByte() & 255;
        this.f1696b = this.i.readByte() & 255;
        byte b2 = this.i.readByte();
        int i = 0;
        this.f1697c = b2 != 0;
        this.f1698d = this.i.readByte() & 255;
        this.f1699e = this.i.readByte() & 255;
        this.f1700f = this.i.readByte() & 255;
        this.f1701g = this.i.readByte() & 255;
        this.h = this.i.readByte() & 255;
        java.lang.String string = "";
        if (this.f1695a != 82) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("");
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.unknown_version));
            sb.append(" ");
            sb.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.expected_found), "'" + java.lang.Integer.toHexString(82) + "'", "'" + java.lang.Integer.toHexString(this.f1695a) + "'"));
            sb.append("\n");
            string = sb.toString();
        }
        if (this.f1696b != 0) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(string);
            sb2.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.unknown_format));
            sb2.append(" ");
            sb2.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.expected_found), "'0'", "'" + this.f1696b + "'"));
            sb2.append("\n");
            string = sb2.toString();
        }
        if (b2 != 0 && b2 != 1) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(string);
            sb3.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.unknown_endianness));
            sb3.append(" ");
            sb3.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.expected_found), "'0' " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.or) + " '1'", "'" + (b2 & 255) + "'"));
            sb3.append("\n");
            string = sb3.toString();
        }
        if (this.f1698d != 4) {
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append(string);
            sb4.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.unknown_size_s), "int"));
            sb4.append(" ");
            sb4.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.expected_found), "'4'", "'" + this.f1698d + "'"));
            sb4.append("\n");
            string = sb4.toString();
        }
        if (this.f1699e != 4) {
            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
            sb5.append(string);
            sb5.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.unknown_size_s), "size_t"));
            sb5.append(" ");
            sb5.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.expected_found), "'4'", "'" + this.f1699e + "'"));
            sb5.append("\n");
            string = sb5.toString();
        }
        if (this.f1700f != 4) {
            java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
            sb6.append(string);
            sb6.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.unknown_size_instr));
            sb6.append(" ");
            sb6.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.expected_found), "'4'", "'" + this.f1700f + "'"));
            sb6.append("\n");
            string = sb6.toString();
        }
        int i2 = this.f1701g;
        if (i2 != 4 && i2 != 8) {
            java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
            sb7.append(string);
            sb7.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.unknown_size_num));
            sb7.append(" ");
            sb7.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.expected_found), "'4' " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.or) + " '8'", "'" + this.f1701g + "'"));
            sb7.append("\n");
            string = sb7.toString();
        }
        if (string.length() > 0) {
            if (u || android.ext.n2.e()) {
                java.lang.String str = "-------------------\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.invalid_header_1).trim() + "\n\n" + string + "\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.invalid_header_3).trim() + "\n-------------------\n";
                android.ext.Tools.K1(str.trim(), 1);
                luaj.g.f1716b.println(str);
            } else {
                u = true;
                luaj.a$b a_b = new luaj.a$b();
                a_b.f1706a = string.trim();
                synchronized (a_b) {
                    try {
                        android.ext.n2.i(new luaj.a$a(this, a_b));
                        try {
                            a_b.wait();
                            if (a_b.f1706a != null) {
                                throw new luaj.d(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.invalid_header_1).trim() + "\n\n" + string + "\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.invalid_header_3).trim());
                            }
                        } catch (java.lang.InterruptedException e2) {
                            android.ext.e1.s("Interrupted wait", e2);
                            java.lang.Thread.currentThread().interrupt();
                            throw new luaj.d(e2);
                        }
                    } catch (java.lang.Throwable th_c_c_c) {
                        throw th_c_c_c;
                    }
                }
            }
        }
        while (true) {
            byte[] bArr = o;
            if (i >= bArr.length) {
                return;
            }
            byte b3 = this.i.readByte();
            if (b3 != bArr[i]) {
                throw new luaj.d("Unexpected byte in luac tail of header, index = " + i + " (" + (b3 & 255) + ", not " + (bArr[i] & 255) + ")");
            }
            i++;
        }
    }

    int h() throws java.io.IOException {
        int i;
        byte b2;
        this.i.readFully(this.k, 0, 4);
        if (this.f1697c) {
            byte[] bArr = this.k;
            i = ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | (bArr[3] << 24);
            b2 = bArr[0];
        } else {
            byte[] bArr2 = this.k;
            i = ((bArr2[1] & 255) << 16) | (bArr2[0] << 24) | ((bArr2[2] & 255) << 8);
            b2 = bArr2[3];
        }
        return (b2 & 255) | i;
    }

    long i() throws java.io.IOException {
        int iH;
        int iH2;
        if (this.f1697c) {
            iH2 = h();
            iH = h();
        } else {
            iH = h();
            iH2 = h();
        }
        return (((long) iH) << 32) | (((long) iH2) & 4294967295L);
    }

    int[] j() throws java.io.IOException {
        int i;
        byte b2;
        int iH = h();
        if (iH == 0) {
            return t;
        }
        int i2 = iH << 2;
        if (this.k.length < i2) {
            this.k = new byte[i2];
        }
        int i3 = 0;
        this.i.readFully(this.k, 0, i2);
        int[] iArr = new int[iH];
        int i4 = 0;
        while (i3 < iH) {
            if (this.f1697c) {
                byte[] bArr = this.k;
                i = (bArr[i4 + 3] << 24) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8);
                b2 = bArr[i4];
            } else {
                byte[] bArr2 = this.k;
                i = (bArr2[i4] << 24) | ((bArr2[i4 + 1] & 255) << 16) | ((bArr2[i4 + 2] & 255) << 8);
                b2 = bArr2[i4 + 3];
            }
            iArr[i3] = (b2 & 255) | i;
            i3++;
            i4 += 4;
        }
        return iArr;
    }

    luaj.LuaValue k() {try {

        return this.h == 1 ? luaj.LuaLong.I2(h()) : n(i());
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    luaj.LuaString l() throws java.io.IOException {
        int i = this.f1699e == 8 ? (int) i() : h();
        if (i == 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.i.readFully(bArr, 0, i);
        return luaj.LuaString.p3(bArr, 0, i - 1);
    }

    void m(luaj.h hVar) throws java.io.IOException {
        int iH = h();
        hVar.f1728f = iH > 0 ? new gg_f.d[iH] : s;
        for (int i = 0; i < iH; i++) {
            hVar.f1728f[i] = new gg_f.d(null, this.i.readByte() != 0, this.i.readByte() & 255);
        }
    }
}
