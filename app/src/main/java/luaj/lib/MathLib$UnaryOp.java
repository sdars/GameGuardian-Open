package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
abstract class MathLib$UnaryOp extends luaj.lib.OneArgFunction {
    protected MathLib$UnaryOp() {
    }

    protected abstract double X2(double d2);

    @Override // luaj.lib.OneArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaj.LuaValue.J2(X2(luaj.lib.MathLib.X2(this, 1, luaValue)));
    }
}
