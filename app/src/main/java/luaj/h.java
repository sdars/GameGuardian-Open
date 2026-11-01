package luaj;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private static final gg_f.d[] n = new gg_f.d[0];
    private static final luaj.h[] o = new luaj.h[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public luaj.LuaValue[] f1723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f1724b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f1726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gg_f.b[] f1727e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public luaj.LuaString f1729g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    int m = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public luaj.h[] f1725c = o;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gg_f.d[] f1728f = n;

    public luaj.LuaString a(int i, int i2) {
        int i3 = 0;
        while (true) {
            gg_f.b[] bVarArr = this.f1727e;
            if (i3 >= bVarArr.length) {
                return null;
            }
            gg_f.b bVar = bVarArr[i3];
            if (bVar.f1559b > i2) {
                return null;
            }
            if (i2 < bVar.f1560c && (i = i - 1) == 0) {
                return bVar.f1558a;
            }
            i3++;
        }
    }

    public java.lang.String b() {
        luaj.LuaString luaString = this.f1729g;
        if (luaString == null) {
            return "null";
        }
        java.lang.String strG0 = luaString.g0();
        if ((!strG0.startsWith("/") || !new java.io.File(strG0).exists()) && strG0.length() > 124) {
            strG0 = strG0.substring(0, 124) + "...";
        }
        if (strG0.startsWith("@") || strG0.startsWith("=")) {
            return strG0.substring(1);
        }
        return strG0.startsWith("\u001b") ? "=?" : strG0;
    }

    public java.lang.String toString() {
        return "" + this.f1729g + ':' + this.h + '-' + this.i;
    }
}
