package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$setmetatable extends luaj.lib.TableLibFunction {
    BaseLib$setmetatable() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaj.LuaValue.k0(2, "nil or table expected");
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaValue luaValueV0 = luaValue.H0().V0();
        if (luaValueV0 != null && !luaValueV0.V1(luaj.LuaValue.p).l1()) {
            luaj.LuaValue.R0("cannot change a protected metatable");
        }
        return luaValue.k2(luaValue2.l1() ? null : luaValue2.H0());
    }
}
