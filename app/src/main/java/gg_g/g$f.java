package gg_g;

/* JADX INFO: loaded from: classes.dex */
class g$f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    luaj.LuaString f1611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    short f1614d;

    public g$f(luaj.LuaString luaString, int i, int i2, short s) {
        this.f1611a = luaString;
        this.f1612b = i;
        this.f1613c = i2;
        this.f1614d = s;
    }

    public java.lang.String toString() {
        return "Labeldesc [name=" + this.f1611a + ", pc=" + this.f1612b + ", line=" + this.f1613c + ", nactvar=" + ((int) this.f1614d) + ']';
    }
}
