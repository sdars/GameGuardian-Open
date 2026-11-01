package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class MathLib$frexp extends luaj.lib.VarArgFunction {
    MathLib$frexp() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        double dB = varargs.B(1);
        if (dB == 0.0d) {
            luaj.LuaNumber luaNumber = luaj.LuaValue.f1677g;
            return luaj.LuaValue.N2(luaNumber, luaNumber);
        }
        long jDoubleToLongBits = java.lang.Double.doubleToLongBits(dB);
        return luaj.LuaValue.N2(luaj.LuaValue.J2(((4503599627370495L & jDoubleToLongBits) + 4503599627370496L) * (jDoubleToLongBits >= 0 ? 1.1102230246251565E-16d : -1.1102230246251565E-16d)), luaj.LuaValue.J2((((int) (jDoubleToLongBits >> 52)) & 2047) - 1022));
    }
}
