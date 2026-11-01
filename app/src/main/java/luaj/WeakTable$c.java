package luaj;

/* JADX INFO: loaded from: classes.dex */
public abstract class WeakTable$c implements luaj.LuaTable$m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.lang.Object f1692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected java.lang.Object f1693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected luaj.LuaTable$m f1694c;

    protected WeakTable$c(java.lang.Object obj, java.lang.Object obj2, luaj.LuaTable$m luaTable$m) {
        this.f1692a = obj;
        this.f1693b = obj2;
        this.f1694c = luaTable$m;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m a() {
        return this.f1694c;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m d(luaj.LuaTable$m luaTable$m) {
        luaj.LuaTable$m luaTable$m2 = this.f1694c;
        if (luaTable$m2 != null) {
            luaTable$m = luaTable$m2.d(luaTable$m);
        }
        this.f1694c = luaTable$m;
        return (k() == null || m() == null) ? this.f1694c : this;
    }

    protected abstract luaj.WeakTable$c e(luaj.LuaTable$m luaTable$m);

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$n f(luaj.LuaValue luaValue) {
        luaj.LuaTable$n luaTable$nL = l();
        if (luaTable$nL != null) {
            return luaTable$nL.f(luaValue);
        }
        return null;
    }

    public abstract luaj.LuaTable$m g(luaj.LuaValue luaValue);

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m h(luaj.LuaTable$n luaTable$n) {
        luaj.LuaValue luaValueK = k();
        if (luaValueK == null) {
            return this.f1694c.h(luaTable$n);
        }
        if (luaTable$n.s(luaValueK)) {
            this.f1693b = null;
            return this;
        }
        this.f1694c = this.f1694c.h(luaTable$n);
        return this;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m j(luaj.LuaTable$n luaTable$n, luaj.LuaValue luaValue) {
        luaj.LuaValue luaValueK = k();
        if (luaValueK != null && luaTable$n.f(luaValueK) != null) {
            return g(luaValue);
        }
        if (luaValueK == null) {
            return this.f1694c.j(luaTable$n, luaValue);
        }
        this.f1694c = this.f1694c.j(luaTable$n, luaValue);
        return this;
    }

    public luaj.LuaValue k() {
        return (luaj.LuaValue) this.f1692a;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$n l() {
        luaj.LuaValue luaValueK = k();
        luaj.LuaValue luaValueM = m();
        if (luaValueK != null && luaValueM != null) {
            return new luaj.LuaTable$l(luaValueK, luaValueM);
        }
        this.f1692a = null;
        this.f1693b = null;
        return null;
    }

    public luaj.LuaValue m() {
        return (luaj.LuaValue) this.f1693b;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m n(luaj.LuaTable$m luaTable$m) {
        if (k() == null || m() == null) {
            return luaTable$m;
        }
        return (luaTable$m == null && this.f1694c == null) ? this : e(luaTable$m);
    }

    @Override // luaj.LuaTable$m
    public int r(int i) {
        return 0;
    }

    @Override // luaj.LuaTable$m
    public boolean s(luaj.LuaValue luaValue) {
        luaj.LuaTable$n luaTable$nL = l();
        return luaTable$nL != null && luaTable$nL.s(luaValue);
    }
}
