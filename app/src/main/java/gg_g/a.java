package gg_g;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends luaj.b {
    protected a() {
    }

    public static void A(d dVar, int i) {
        y(dVar, i + 131071);
    }

    public static void B(d dVar, int i) {
        dVar.b((i & 63) | (dVar.a() & (-64)));
    }

    protected static void C(boolean z) {
        if (!z) {
            throw new luaj.d("compiler assert failed");
        }
    }

    static g$f[] D(g$f[] g_fArr, int i) {
        if (g_fArr == null) {
            return new g$f[2];
        }
        return g_fArr.length < i ? I(g_fArr, g_fArr.length * 2) : g_fArr;
    }

    static char[] E(char[] cArr, int i) {
        char[] cArr2 = new char[i];
        if (cArr != null) {
            java.lang.System.arraycopy(cArr, 0, cArr2, 0, java.lang.Math.min(cArr.length, i));
        }
        return cArr2;
    }

    static int[] F(int[] iArr, int i) {
        int[] iArr2 = new int[i];
        if (iArr != null) {
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, java.lang.Math.min(iArr.length, i));
        }
        return iArr2;
    }

    static gg_f.b[] G(gg_f.b[] bVarArr, int i) {
        gg_f.b[] bVarArr2 = new gg_f.b[i];
        if (bVarArr != null) {
            java.lang.System.arraycopy(bVarArr, 0, bVarArr2, 0, java.lang.Math.min(bVarArr.length, i));
        }
        return bVarArr2;
    }

    static gg_f.d[] H(gg_f.d[] dVarArr, int i) {
        gg_f.d[] dVarArr2 = new gg_f.d[i];
        if (dVarArr != null) {
            java.lang.System.arraycopy(dVarArr, 0, dVarArr2, 0, java.lang.Math.min(dVarArr.length, i));
        }
        return dVarArr2;
    }

    static g$f[] I(g$f[] g_fArr, int i) {
        g$f[] g_fArr2 = new g$f[i];
        if (g_fArr != null) {
            java.lang.System.arraycopy(g_fArr, 0, g_fArr2, 0, java.lang.Math.min(g_fArr.length, i));
        }
        return g_fArr2;
    }

    static g$j[] J(g$j[] g_jArr, int i) {
        g$j[] g_jArr2 = new g$j[i];
        if (g_jArr != null) {
            java.lang.System.arraycopy(g_jArr, 0, g_jArr2, 0, java.lang.Math.min(g_jArr.length, i));
        }
        return g_jArr2;
    }

    static luaj.LuaValue[] K(luaj.LuaValue[] luaValueArr, int i) {
        luaj.LuaValue[] luaValueArr2 = new luaj.LuaValue[i];
        if (luaValueArr != null) {
            java.lang.System.arraycopy(luaValueArr, 0, luaValueArr2, 0, java.lang.Math.min(luaValueArr.length, i));
        }
        return luaValueArr2;
    }

    static luaj.h[] L(luaj.h[] hVarArr, int i) {
        luaj.h[] hVarArr2 = new luaj.h[i];
        if (hVarArr != null) {
            java.lang.System.arraycopy(hVarArr, 0, hVarArr2, 0, java.lang.Math.min(hVarArr.length, i));
        }
        return hVarArr2;
    }

    public static int s(int i, int i2, int i3, int i4) {
        return (i & 63) | ((i2 << 6) & 16320) | ((i3 << 23) & (-8388608)) | ((i4 << 14) & 8372224);
    }

    public static int t(int i, int i2, int i3) {
        return (i & 63) | ((i2 << 6) & 16320) | ((i3 << 14) & (-16384));
    }

    public static int u(int i, int i2) {
        return (i & 63) | ((i2 << 6) & (-64));
    }

    public static void v(d dVar, int i) {
        dVar.b(((i << 6) & 16320) | (dVar.a() & (-16321)));
    }

    public static void w(int[] iArr, int i, int i2) {
        iArr[i] = ((i2 << 6) & 16320) | (iArr[i] & (-16321));
    }

    public static void x(d dVar, int i) {
        dVar.b(((i << 23) & (-8388608)) | (dVar.a() & 8388607));
    }

    public static void y(d dVar, int i) {
        dVar.b(((i << 14) & (-16384)) | (dVar.a() & 16383));
    }

    public static void z(d dVar, int i) {
        dVar.b(((i << 14) & 8372224) | (dVar.a() & (-8372225)));
    }
}
