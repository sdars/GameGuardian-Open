package luaj;

/* JADX INFO: loaded from: classes.dex */
class WeakTable$a extends luaj.WeakTable$c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1690d;

    protected WeakTable$a(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaTable$m luaTable$m) {
        super(luaj.WeakTable.b(luaValue), luaj.WeakTable.b(luaValue2), luaTable$m);
        this.f1690d = luaValue.hashCode();
    }

    protected WeakTable$a(luaj.WeakTable$a weakTable$a, luaj.LuaTable$m luaTable$m) {
        super(weakTable$a.f1692a, weakTable$a.f1693b, luaTable$m);
        this.f1690d = weakTable$a.f1690d;
    }

    @Override // luaj.LuaTable$m
    public int b(int i) {
        return luaj.LuaTable.l3(this.f1690d, i);
    }

    @Override // luaj.WeakTable$c
    protected luaj.WeakTable$c e(luaj.LuaTable$m luaTable$m) {
        return new luaj.WeakTable$a(this, luaTable$m);
    }

    @Override // luaj.WeakTable$c
    public luaj.LuaTable$m g(luaj.LuaValue luaValue) {
        this.f1693b = luaj.WeakTable.b(luaValue);
        return this;
    }

    @Override // luaj.WeakTable$c
    public luaj.LuaValue k() {
        return luaj.WeakTable.a(this.f1692a);
    }

    @Override // luaj.WeakTable$c
    public luaj.LuaValue m() {
        return luaj.WeakTable.a(this.f1693b);
    }
}
