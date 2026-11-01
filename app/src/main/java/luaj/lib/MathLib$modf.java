package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class MathLib$modf extends luaj.lib.VarArgFunction {
    MathLib$modf() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaValue luaValueW = varargs.w();
        double d2 = 0.0d;
        if (!luaValueW.k1()) {
            double dX0 = luaValueW.x0();
            double dFloor = dX0 > 0.0d ? java.lang.Math.floor(dX0) : java.lang.Math.ceil(dX0);
            d2 = dX0 != dFloor ? dX0 - dFloor : 0.0d;
            luaValueW = luaj.LuaValue.J2(dFloor);
        }
        return luaj.LuaValue.N2(luaValueW, luaj.LuaValue.J2(d2));
    }
}
