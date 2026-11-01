package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$log extends luaj.lib.TwoArgFunction {
    MathLib$log() {
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        double dLog = java.lang.Math.log(luaj.lib.MathLib.X2(this, 1, luaValue));
        double dA3 = luaj.lib.MathLib.a3(this, 2, luaValue2, 2.718281828459045d);
        if (dA3 != 2.718281828459045d) {
            dLog /= java.lang.Math.log(dA3);
        }
        return luaj.LuaValue.J2(dLog);
    }
}
