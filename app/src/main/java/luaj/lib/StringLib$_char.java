package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$_char extends luaj.lib.VarArgFunction {
    StringLib$_char() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        int iU = varargs.U();
        byte[] bArr = new byte[iU];
        int i = 0;
        int i2 = 1;
        while (i < iU) {
            int iD = varargs.D(i2);
            if (iD < 0 || iD >= 256) {
                luaj.LuaValue.k0(i2, "invalid value for string.char [0; 255]: " + iD);
            }
            bArr[i] = (byte) iD;
            i++;
            i2++;
        }
        return luaj.LuaString.o3(bArr);
    }
}
