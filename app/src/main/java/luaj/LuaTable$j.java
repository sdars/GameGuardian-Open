package luaj;

/* JADX INFO: loaded from: classes.dex */
class LuaTable$j implements luaj.LuaTable$n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private luaj.LuaTable$e f1660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private luaj.LuaTable$m f1661b;

    LuaTable$j(luaj.LuaTable$e luaTable$e, luaj.LuaTable$m luaTable$m) {
        this.f1660a = luaTable$e;
        this.f1661b = luaTable$m;
    }

    private luaj.LuaTable$m e(luaj.LuaTable$m luaTable$m) {
        if (luaTable$m == null) {
            return this.f1660a;
        }
        this.f1661b = luaTable$m;
        return this;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m a() {
        return this.f1661b;
    }

    @Override // luaj.LuaTable$m
    public int b(int i) {
        return this.f1660a.b(i);
    }

    @Override // luaj.LuaTable$n
    public luaj.Varargs c() {
        return this.f1660a.c();
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m d(luaj.LuaTable$m luaTable$m) {
        return e(this.f1661b.d(luaTable$m));
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$n f(luaj.LuaValue luaValue) {
        if (this.f1660a.s(luaValue)) {
            return this;
        }
        return null;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m h(luaj.LuaTable$n luaTable$n) {
        if (this == luaTable$n) {
            return new luaj.LuaTable$c(i(), this.f1661b, null);
        }
        this.f1661b = this.f1661b.h(luaTable$n);
        return this;
    }

    @Override // luaj.LuaTable$n
    public luaj.LuaValue i() {
        return this.f1660a.i();
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m j(luaj.LuaTable$n luaTable$n, luaj.LuaValue luaValue) {
        if (luaTable$n != this) {
            return e(this.f1661b.j(luaTable$n, luaValue));
        }
        this.f1660a = this.f1660a.j0(luaValue);
        return this;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$n l() {
        return this.f1660a;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m n(luaj.LuaTable$m luaTable$m) {
        return luaTable$m != null ? new luaj.LuaTable$j(this.f1660a, luaTable$m) : this.f1660a;
    }

    @Override // luaj.LuaTable$m
    public int r(int i) {
        return this.f1660a.r(i);
    }

    @Override // luaj.LuaTable$m
    public boolean s(luaj.LuaValue luaValue) {
        return this.f1660a.s(luaValue);
    }

    @Override // luaj.LuaTable$n
    public luaj.LuaValue t() {
        return this.f1660a.t();
    }

    public java.lang.String toString() {
        return this.f1660a + "; " + this.f1661b;
    }
}
