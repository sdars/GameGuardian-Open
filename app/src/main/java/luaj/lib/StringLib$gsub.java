package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$gsub extends luaj.lib.VarArgFunction {
    StringLib$gsub() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaString luaStringH = varargs.H(1);
        int iS1 = luaStringH.s1();
        luaj.LuaString luaStringH2 = varargs.H(2);
        luaj.LuaValue luaValueV = varargs.v(3);
        int iY = varargs.Y(4, iS1 + 1);
        int i = 0;
        int i2 = (luaStringH2.s1() <= 0 || luaStringH2.T2(0) != 94) ? 0 : 1;
        gg_f.a aVar = new gg_f.a(iS1);
        luaj.lib.StringLib$b stringLib$b = new luaj.lib.StringLib$b(varargs, luaStringH, luaStringH2);
        int i3 = 0;
        int i4 = -1;
        while (i < iY) {
            stringLib$b.p();
            int iG = stringLib$b.g(i3, i2);
            if (iG != -1 && iG != i4) {
                i++;
                stringLib$b.b(aVar, i3, iG, luaValueV);
                i3 = iG;
                i4 = i3;
            } else {
                if (i3 >= iS1) {
                    break;
                }
                aVar.a((byte) luaStringH.g3(i3));
                i3++;
            }
            if (i2 != 0) {
                break;
            }
        }
        aVar.c(luaStringH.j3(i3, iS1));
        return luaj.LuaValue.N2(aVar.l(), luaj.LuaValue.I2(i));
    }
}
