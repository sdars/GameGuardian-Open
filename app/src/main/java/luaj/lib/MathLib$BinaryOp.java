package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
abstract class MathLib$BinaryOp extends luaj.lib.TwoArgFunction {
    protected MathLib$BinaryOp() {
    }

    protected abstract double X2(double d2, double d3);

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return luaj.LuaValue.J2(X2(luaj.lib.MathLib.X2(this, 1, luaValue), luaj.lib.MathLib.X2(this, 2, luaValue2)));
    }
}
