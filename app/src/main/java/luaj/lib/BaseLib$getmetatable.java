package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$getmetatable extends luaj.lib.LibFunction {
    BaseLib$getmetatable() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call() {
        return luaj.LuaValue.k0(1, "value expected");
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        luaj.LuaValue luaValueV0 = luaValue.V0();
        return luaValueV0 != null ? luaValueV0.V1(luaj.LuaValue.p).M1(luaValueV0) : luaj.LuaValue.f1673c;
    }
}
