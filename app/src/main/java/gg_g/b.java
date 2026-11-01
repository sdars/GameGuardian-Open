package gg_g;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    java.io.DataOutputStream f1571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f1572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f1573f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1568a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1569b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1570c = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1574g = 0;

    public b(java.io.OutputStream outputStream, boolean z, boolean z2) {
        this.f1571d = new java.io.DataOutputStream(outputStream);
        this.f1572e = z;
        this.f1573f = z2;
    }

    public static int a(luaj.h hVar, java.io.OutputStream outputStream, boolean z, boolean z2) {
        b bVar = new b(outputStream, z, z2);try {

        bVar.h();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}try {

        bVar.g(hVar, null);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        return bVar.f1574g;
    }

    void b(int i) throws java.io.IOException {
        this.f1571d.write(i);
    }

    void c(luaj.h hVar) throws java.io.IOException {
        int[] iArr = hVar.f1724b;
        int length = iArr.length;
        i(length);
        boolean z = this.f1573f;
        if (z) {
            iArr = new int[length];
        }
        if (z) {
            luaj.g.x(hVar, iArr);
        }
        for (int i = 0; i < length; i++) {
            i(iArr[i]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    void d(luaj.h hVar) throws java.io.IOException {
        java.io.DataOutputStream dataOutputStream = this.f1571d;
        luaj.LuaValue[] luaValueArr = hVar.f1723a;
        i(luaValueArr.length);
        for (luaj.LuaValue luaValue : luaValueArr) {
            int iC2 = luaValue.C2();
            if (iC2 == 0) {
                dataOutputStream.write(0);
            } else if (iC2 == 1) {
                dataOutputStream.write(1);
                b(luaValue.w2() ? 1 : 0);
            } else if (iC2 == 3) {
                int i = this.f1569b;
                if (i == 0) {
                    dataOutputStream.write(3);
                    f(luaValue.x2());
                } else {
                    if (i != 1) {
                        if (i != 4) {
                            throw new java.lang.IllegalArgumentException("number format not supported: " + this.f1569b);
                        }
                        if (luaValue.h1()) {
                            dataOutputStream.write(-2);
                        } else {
                            dataOutputStream.write(3);
                            f(luaValue.x2());
                        }
                    } else {
                        if (!luaValue.h1()) {
                            throw new java.lang.IllegalArgumentException("not an integer: " + luaValue);
                        }
                        dataOutputStream.write(3);
                    }
                    i(luaValue.y2());
                }
            } else {
                if (iC2 != 4) {
                    throw new java.lang.IllegalArgumentException("bad type for " + luaValue);
                }
                dataOutputStream.write(4);
                j((luaj.LuaString) luaValue);
            }
        }
        int length = hVar.f1725c.length;
        i(length);
        for (int i2 = 0; i2 < length; i2++) {
            g(hVar.f1725c[i2], hVar.f1729g);
        }
    }

    void e(luaj.h hVar, luaj.LuaString luaString) throws java.io.IOException {
        if (this.f1572e || (luaString != null && luaString.P0(hVar.f1729g))) {
            i(0);
        } else {
            j(hVar.f1729g);
        }
        int[] iArr = hVar.f1726d;
        int length = this.f1572e ? 0 : iArr.length;
        i(length);
        for (int i = 0; i < length; i++) {
            i(iArr[i]);
        }
        gg_f.b[] bVarArr = hVar.f1727e;
        int length2 = this.f1572e ? 0 : bVarArr.length;
        i(length2);
        for (int i2 = 0; i2 < length2; i2++) {
            gg_f.b bVar = bVarArr[i2];
            j(bVar.f1558a);
            i(bVar.f1559b);
            i(bVar.f1560c);
        }
        gg_f.d[] dVarArr = hVar.f1728f;
        int length3 = this.f1572e ? 0 : dVarArr.length;
        i(length3);
        for (int i3 = 0; i3 < length3; i3++) {
            j(dVarArr[i3].f1565a);
        }
    }

    void f(double d2) throws java.io.IOException {
        long jDoubleToLongBits = java.lang.Double.doubleToLongBits(d2);
        if (this.f1568a) {
            jDoubleToLongBits = java.lang.Long.reverseBytes(jDoubleToLongBits);
        }
        this.f1571d.writeLong(jDoubleToLongBits);
    }

    void g(luaj.h hVar, luaj.LuaString luaString) throws java.io.IOException {
        i(hVar.h);
        i(hVar.i);
        b(hVar.j);
        b(hVar.k);
        b(hVar.l);
        c(hVar);
        d(hVar);
        k(hVar);
        e(hVar, luaString);
    }

    void h() throws java.io.IOException {
        java.io.DataOutputStream dataOutputStream = this.f1571d;
        dataOutputStream.write(luaj.a.n);
        dataOutputStream.write(82);
        dataOutputStream.write(0);
        dataOutputStream.write(this.f1568a ? 1 : 0);
        dataOutputStream.write(4);
        dataOutputStream.write(4);
        dataOutputStream.write(4);
        dataOutputStream.write(this.f1570c);
        dataOutputStream.write(this.f1569b);
        dataOutputStream.write(luaj.a.o);
    }

    void i(int i) throws java.io.IOException {
        java.io.DataOutputStream dataOutputStream = this.f1571d;
        if (this.f1568a) {
            i = java.lang.Integer.reverseBytes(i);
        }
        dataOutputStream.writeInt(i);
    }

    void j(luaj.LuaString luaString) throws java.io.IOException {
        if (luaString == null) {
            luaString = luaj.LuaValue.K2("");
        }
        int iY2 = luaString.r1().y2();
        i(iY2 + 1);
        luaString.q3(this.f1571d, 0, iY2);
        this.f1571d.write(0);
    }

    void k(luaj.h hVar) throws java.io.IOException {
        java.io.DataOutputStream dataOutputStream = this.f1571d;
        gg_f.d[] dVarArr = hVar.f1728f;
        i(dVarArr.length);
        for (gg_f.d dVar : dVarArr) {
            dataOutputStream.writeByte(dVar.f1566b ? 1 : 0);
            dataOutputStream.writeByte(dVar.f1567c);
        }
    }
}
