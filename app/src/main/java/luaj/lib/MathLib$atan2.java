package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$atan2 extends luaj.lib.TwoArgFunction {
    MathLib$atan2() {
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return luaj.LuaValue.J2(java.lang.Math.atan2(luaj.lib.MathLib.X2(this, 1, luaValue), luaj.lib.MathLib.a3(this, 2, luaValue2, 1.0d)));
    }
}
