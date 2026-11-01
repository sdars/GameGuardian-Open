package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class BaseLib$d extends java.io.InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final luaj.LuaValue f1743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    byte[] f1744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1746d = 0;

    BaseLib$d(luaj.LuaValue luaValue) {
        this.f1743a = luaValue;
    }

    @Override // java.io.InputStream
    public int read() {
        int i = this.f1746d;
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            luaj.LuaValue luaValueCall = this.f1743a.call();
            if (luaValueCall.l1()) {
                this.f1746d = -1;
                return -1;
            }
            luaj.LuaString luaStringQ2 = luaValueCall.q2();
            this.f1744b = luaStringQ2.P;
            this.f1745c = luaStringQ2.Q;
            int i2 = luaStringQ2.R;
            this.f1746d = i2;
            if (i2 <= 0) {
                return -1;
            }
        }
        this.f1746d--;
        byte[] bArr = this.f1744b;
        int i3 = this.f1745c;
        this.f1745c = i3 + 1;
        return bArr[i3] & 255;
    }
}
