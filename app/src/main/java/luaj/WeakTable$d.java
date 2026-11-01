package luaj;

/* JADX INFO: loaded from: classes.dex */
class WeakTable$d extends luaj.WeakTable$c {
    protected WeakTable$d(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaTable$m luaTable$m) {
        super(luaValue, luaj.WeakTable.b(luaValue2), luaTable$m);
    }

    protected WeakTable$d(luaj.WeakTable$d weakTable$d, luaj.LuaTable$m luaTable$m) {
        super(weakTable$d.f1692a, weakTable$d.f1693b, luaTable$m);
    }

    @Override // luaj.LuaTable$m
    public int b(int i) {
        return luaj.LuaTable.j3(k(), i);
    }

    @Override // luaj.WeakTable$c
    protected luaj.WeakTable$c e(luaj.LuaTable$m luaTable$m) {
        return new luaj.WeakTable$d(this, luaTable$m);
    }

    @Override // luaj.WeakTable$c
    public luaj.LuaTable$m g(luaj.LuaValue luaValue) {
        this.f1693b = luaj.WeakTable.b(luaValue);
        return this;
    }

    @Override // luaj.WeakTable$c
    public luaj.LuaValue m() {
        return luaj.WeakTable.a(this.f1693b);
    }
}
