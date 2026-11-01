package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$setmetatable extends luaj.lib.TwoArgFunction {
    DebugLib$setmetatable() {
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaTable luaTableL1 = luaValue2.L1(null);
        int iC2 = luaValue.C2();
        if (iC2 == 0) {
            luaj.LuaNil.P = luaTableL1;
        } else if (iC2 == 1) {
            luaj.LuaBoolean.Q = luaTableL1;
        } else if (iC2 == 3) {
            luaj.LuaNumber.P = luaTableL1;
        } else if (iC2 == 4) {
            luaj.LuaString.U = luaTableL1;
        } else if (iC2 == 6) {
            luaj.LuaFunction.P = luaTableL1;
        } else if (iC2 != 8) {
            luaValue.k2(luaTableL1);
        } else {
            luaj.LuaThread.T = luaTableL1;
        }
        return luaValue;
    }
}
