package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$getmetatable extends luaj.lib.LibFunction {
    DebugLib$getmetatable() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        luaj.LuaValue luaValueV0 = luaValue.V0();
        return luaValueV0 != null ? luaValueV0 : luaj.LuaValue.f1673c;
    }
}
