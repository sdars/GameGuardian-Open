package luaj;

/* JADX INFO: loaded from: classes.dex */
final class Varargs$a extends luaj.Varargs {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final luaj.LuaValue[] f1680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final luaj.Varargs f1682e;

    public Varargs$a(luaj.LuaValue[] luaValueArr, int i, int i2, luaj.Varargs varargs) {
        this.f1680c = luaValueArr;
        this.f1679b = i;
        this.f1681d = i2;
        this.f1682e = varargs;
    }

    @Override // luaj.Varargs
    void L(luaj.LuaValue[] luaValueArr, int i, int i2) {
        int iMin = java.lang.Math.min(this.f1681d, i2);
        java.lang.System.arraycopy(this.f1680c, this.f1679b, luaValueArr, i, iMin);
        this.f1682e.L(luaValueArr, i + iMin, i2 - iMin);
    }

    @Override // luaj.Varargs
    public int U() {
        return this.f1681d + this.f1682e.U();
    }

    @Override // luaj.Varargs
    public luaj.Varargs e0(int i) {
        if (i <= 0) {
            luaj.LuaValue.k0(1, "start must be > 0");
        }
        if (i == 1) {
            return this;
        }
        int i2 = this.f1681d;
        return i > i2 ? this.f1682e.e0(i - i2) : luaj.LuaValue.Q2(this.f1680c, (this.f1679b + i) - 1, i2 - (i - 1), this.f1682e);
    }

    @Override // luaj.Varargs
    public luaj.LuaValue v(int i) {
        if (i < 1) {
            return luaj.LuaValue.f1673c;
        }
        int i2 = this.f1681d;
        return i <= i2 ? this.f1680c[(this.f1679b + i) - 1] : this.f1682e.v(i - i2);
    }

    @Override // luaj.Varargs
    public luaj.LuaValue w() {
        return this.f1681d > 0 ? this.f1680c[this.f1679b] : this.f1682e.w();
    }
}
