package gg_f;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f1553e = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f1554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private luaj.LuaValue f1557d;

    public a() {
        this(64);
    }

    public a(int i) {
        this.f1554a = new byte[i];
        this.f1555b = 0;
        this.f1556c = 0;
        this.f1557d = null;
    }

    public a(luaj.LuaValue luaValue) {
        this.f1554a = f1553e;
        this.f1556c = 0;
        this.f1555b = 0;
        this.f1557d = luaValue;
    }

    private final void i(int i, int i2) {
        byte[] bArr = this.f1554a;
        if (i != bArr.length) {
            byte[] bArr2 = new byte[i];
            java.lang.System.arraycopy(bArr, this.f1556c, bArr2, i2, this.f1555b);
            this.f1554a = bArr2;
            this.f1556c = i2;
        }
    }

    public final a a(byte b2) {
        h(0, 1);
        byte[] bArr = this.f1554a;
        int i = this.f1556c;
        int i2 = this.f1555b;
        this.f1555b = i2 + 1;
        bArr[i + i2] = b2;
        return this;
    }

    public final a b(java.lang.String str) {
        byte[] bytes = str.getBytes();
        return e(bytes, 0, bytes.length);
    }

    public final a c(luaj.LuaString luaString) {
        int i = luaString.R;
        h(0, i);
        luaString.U2(0, this.f1554a, this.f1556c + this.f1555b, i);
        this.f1555b += i;
        return this;
    }

    public final a d(luaj.LuaValue luaValue) {
        c(luaValue.q2());
        return this;
    }

    public final a e(byte[] bArr, int i, int i2) {
        h(0, i2);
        java.lang.System.arraycopy(bArr, i, this.f1554a, this.f1556c + this.f1555b, i2);
        this.f1555b += i2;
        return this;
    }

    public final a f(int i) {
        int i2;
        int i3;
        if (i < 0 || i > 1114111) {
            throw new java.lang.IllegalArgumentException("Code point (" + i + ") out of range [0; 1114111]");
        }
        if (i <= 127) {
            i2 = 1;
            i3 = 0;
        } else if (i <= 2047) {
            i2 = 2;
            i3 = 192;
        } else if (i <= 65535) {
            i2 = 3;
            i3 = 224;
        } else {
            i2 = 4;
            i3 = 240;
        }
        h(0, i2);
        int i4 = this.f1556c + this.f1555b;
        byte[] bArr = this.f1554a;
        for (int i5 = i2 - 1; i5 > 0; i5--) {
            bArr[i4 + i5] = (byte) ((i & 63) | 128);
            i >>= 6;
        }
        bArr[i4] = (byte) (i | i3);
        this.f1555b += i2;
        return this;
    }

    public a g(luaj.LuaValue luaValue) {
        return j(luaValue.K0(m()));
    }

    public final void h(int i, int i2) {
        luaj.LuaValue luaValue = this.f1557d;
        if (luaValue != null) {
            luaj.LuaString luaStringQ2 = luaValue.q2();
            this.f1557d = null;
            int i3 = luaStringQ2.R;
            this.f1555b = i3;
            this.f1556c = i;
            byte[] bArr = new byte[i + i3 + i2];
            this.f1554a = bArr;
            java.lang.System.arraycopy(luaStringQ2.P, luaStringQ2.Q, bArr, i, i3);
            return;
        }
        int i4 = this.f1556c;
        int i5 = this.f1555b;
        if (i4 + i5 + i2 > this.f1554a.length || i4 < i) {
            int i6 = i + i5 + i2;
            if (i6 < 32) {
                i6 = 32;
            } else if (i6 < i5 * 2) {
                i6 = i5 * 2;
            }
            i(i6, i == 0 ? 0 : (i6 - i5) - i2);
        }
    }

    public a j(luaj.LuaValue luaValue) {
        this.f1554a = f1553e;
        this.f1555b = 0;
        this.f1556c = 0;
        this.f1557d = luaValue;
        return this;
    }

    public java.lang.String k() {
        return m().g0();
    }

    public final luaj.LuaString l() {
        i(this.f1555b, 0);
        return luaj.LuaString.L2(this.f1554a, this.f1556c, this.f1555b);
    }

    public luaj.LuaValue m() {
        luaj.LuaValue luaValue = this.f1557d;
        return luaValue != null ? luaValue : l();
    }

    public java.lang.String toString() {
        return k();
    }
}
