package luaj;

/* JADX INFO: loaded from: classes.dex */
class f implements luaj.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final luaj.LuaValue f1715a;

    public f(luaj.LuaValue luaValue) {
        this.f1715a = luaValue;
    }

    @Override // luaj.e
    public luaj.LuaValue e() {
        return this.f1715a;
    }

    @Override // luaj.e
    public luaj.LuaValue g(luaj.LuaValue luaValue) {
        return luaValue;
    }

    @Override // luaj.e
    public luaj.LuaTable$m k(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return luaj.LuaTable.Z2(luaValue, luaValue2);
    }

    @Override // luaj.e
    public luaj.LuaValue o(luaj.LuaValue[] luaValueArr, int i) {
        return luaValueArr[i];
    }

    @Override // luaj.e
    public boolean p() {
        return false;
    }

    @Override // luaj.e
    public boolean q() {
        return false;
    }
}
