package luaj;

/* JADX INFO: loaded from: classes.dex */
class WeakTable$b extends luaj.WeakTable$c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f1691d;

    protected WeakTable$b(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaTable$m luaTable$m) {
        super(luaj.WeakTable.b(luaValue), luaValue2, luaTable$m);
        this.f1691d = luaValue.hashCode();
    }

    protected WeakTable$b(luaj.WeakTable$b weakTable$b, luaj.LuaTable$m luaTable$m) {
        super(weakTable$b.f1692a, weakTable$b.f1693b, luaTable$m);
        this.f1691d = weakTable$b.f1691d;
    }

    @Override // luaj.LuaTable$m
    public int b(int i) {
        return luaj.LuaTable.l3(this.f1691d, i);
    }

    @Override // luaj.WeakTable$c
    protected luaj.WeakTable$c e(luaj.LuaTable$m luaTable$m) {
        return new luaj.WeakTable$b(this, luaTable$m);
    }

    @Override // luaj.WeakTable$c
    public luaj.LuaTable$m g(luaj.LuaValue luaValue) {
        this.f1693b = luaValue;
        return this;
    }

    @Override // luaj.WeakTable$c
    public luaj.LuaValue k() {
        return luaj.WeakTable.a(this.f1692a);
    }
}
