package luaj;

/* JADX INFO: loaded from: classes.dex */
abstract class LuaTable$o extends luaj.LuaTable$e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final luaj.LuaValue f1664b;

    LuaTable$o(luaj.LuaValue luaValue) {
        this.f1664b = luaValue;
    }

    @Override // luaj.LuaTable$e, luaj.LuaTable$m
    public final int b(int i) {
        return luaj.LuaTable.j3(this.f1664b, i);
    }

    @Override // luaj.LuaTable$e, luaj.LuaTable$n
    public final luaj.LuaValue i() {
        return this.f1664b;
    }

    @Override // luaj.LuaTable$e, luaj.LuaTable$m
    public final boolean s(luaj.LuaValue luaValue) {
        return luaValue.T1(this.f1664b);
    }
}
