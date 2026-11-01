package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$packsize extends luaj.lib.VarArgFunction {
    StringLib$packsize() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        java.lang.String strE = varargs.E(1);
        luaj.lib.StringLib$c stringLib$c = new luaj.lib.StringLib$c(strE);
        int length = strE.length();
        int i = 0;
        while (stringLib$c.f1789e < length) {
            byte bY2 = luaj.lib.StringLib.Y2(stringLib$c, i);
            int i2 = stringLib$c.i + stringLib$c.h;
            x(i <= Integer.MAX_VALUE - i2, 1, "format result too large at pos " + stringLib$c.f1789e);
            i += i2;
            if (bY2 == 5 || bY2 == 6) {
                luaj.LuaValue.k0(1, android.ext.t2.f("variable-length format option '%c' at pos %d", java.lang.Character.valueOf(stringLib$c.f1790f), java.lang.Integer.valueOf(stringLib$c.f1789e)));
            }
        }
        return luaj.LuaValue.I2(i);
    }
}
