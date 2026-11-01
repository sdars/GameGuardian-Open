package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$ult extends luaj.lib.TwoArgFunction {
    MathLib$ult() {
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        long jY2 = luaj.lib.MathLib.Y2(this, 1, luaValue);
        long jY3 = luaj.lib.MathLib.Y2(this, 2, luaValue2);
        return (((jY2 > 0L ? 1 : (jY2 == 0L ? 0 : -1)) < 0) ^ ((jY2 > jY3 ? 1 : (jY2 == jY3 ? 0 : -1)) < 0)) ^ (jY3 < 0) ? luaj.LuaValue.f1674d : luaj.LuaValue.f1675e;
    }
}
