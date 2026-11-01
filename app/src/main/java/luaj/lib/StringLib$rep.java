package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$rep extends luaj.lib.VarArgFunction {
    StringLib$rep() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaString luaStringH = varargs.H(1);
        int iD = varargs.D(2);
        if (iD <= 0) {
            return luaj.LuaValue.L;
        }
        luaj.LuaString luaStringB0 = varargs.b0(3, luaj.LuaValue.L);
        int iS1 = luaStringH.s1();
        int iS2 = luaStringB0.s1();
        int i = iS1 + iS2;
        if (i < iS1 || i > Integer.MAX_VALUE / iD) {
            throw new luaj.d("resulting string too large");
        }
        byte[] bArr = new byte[(i * (iD - 1)) + iS1];
        byte[] bArr2 = luaStringH.P;
        int i2 = luaStringH.Q;
        byte[] bArr3 = luaStringB0.P;
        int i3 = luaStringB0.Q;
        int i4 = 0;
        while (true) {
            int i5 = iD - 1;
            java.lang.System.arraycopy(bArr2, i2, bArr, i4, iS1);
            if (iD <= 1) {
                return luaj.LuaString.o3(bArr);
            }
            i4 += iS1;
            if (iS2 > 0) {
                java.lang.System.arraycopy(bArr3, i3, bArr, i4, iS2);
                i4 += iS2;
            }
            iD = i5;
        }
    }
}
