package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$tointeger extends luaj.lib.OneArgFunction {
    MathLib$tointeger() {
    }

    @Override // luaj.lib.OneArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaValue.k1() ? luaj.LuaValue.I2(luaValue.z2()) : luaj.LuaValue.f1673c;
    }
}
