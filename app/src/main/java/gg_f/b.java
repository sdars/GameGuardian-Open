package gg_f;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public luaj.LuaString f1558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1560c;

    public b(luaj.LuaString luaString, int i, int i2) {
        this.f1558a = luaString;
        this.f1559b = i;
        this.f1560c = i2;
    }

    public java.lang.String a() {
        return "" + this.f1558a + ' ' + this.f1559b + '-' + this.f1560c;
    }

    public java.lang.String toString() {
        return a();
    }
}
