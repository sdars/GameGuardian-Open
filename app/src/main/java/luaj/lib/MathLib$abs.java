package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$abs extends luaj.lib.OneArgFunction {
    MathLib$abs() {
    }

    @Override // luaj.lib.OneArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaValue.j1() ? luaj.LuaValue.I2(java.lang.Math.abs(luaValue.z2())) : luaj.LuaValue.J2(java.lang.Math.abs(luaj.lib.MathLib.X2(this, 1, luaValue)));
    }
}
