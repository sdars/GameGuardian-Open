package luaj;

/* JADX INFO: loaded from: classes.dex */
abstract class LuaTable$e extends luaj.Varargs implements luaj.LuaTable$n {
    LuaTable$e() {
    }

    @Override // luaj.Varargs
    public int U() {
        return 2;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m a() {
        return null;
    }

    @Override // luaj.LuaTable$m
    public abstract int b(int i);

    @Override // luaj.LuaTable$n
    public luaj.Varargs c() {
        return this;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m d(luaj.LuaTable$m luaTable$m) {
        return new luaj.LuaTable$j(this, luaTable$m);
    }

    @Override // luaj.Varargs
    public luaj.Varargs e0(int i) {
        if (i != 1) {
            return i != 2 ? luaj.LuaValue.f1676f : t();
        }
        return this;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$n f(luaj.LuaValue luaValue) {
        if (s(luaValue)) {
            return this;
        }
        return null;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m h(luaj.LuaTable$n luaTable$n) {
        return new luaj.LuaTable$c(i(), null, null);
    }

    @Override // luaj.LuaTable$n
    public abstract luaj.LuaValue i();

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m j(luaj.LuaTable$n luaTable$n, luaj.LuaValue luaValue) {
        return j0(luaValue);
    }

    abstract luaj.LuaTable$e j0(luaj.LuaValue luaValue);

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$n l() {
        return this;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m n(luaj.LuaTable$m luaTable$m) {
        return luaTable$m != null ? new luaj.LuaTable$j(this, luaTable$m) : this;
    }

    @Override // luaj.LuaTable$m
    public int r(int i) {
        return 0;
    }

    @Override // luaj.LuaTable$m
    public abstract boolean s(luaj.LuaValue luaValue);

    public abstract luaj.LuaValue t();

    @Override // luaj.Varargs
    public luaj.LuaValue v(int i) {
        if (i != 1) {
            return i != 2 ? luaj.LuaValue.f1673c : t();
        }
        return i();
    }

    @Override // luaj.Varargs
    public luaj.LuaValue w() {
        return i();
    }
}
