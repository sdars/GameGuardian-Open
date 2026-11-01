package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class Utf8Lib$offset extends luaj.lib.VarArgFunction {
    Utf8Lib$offset() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaString luaStringH = varargs.H(1);
        int i = luaStringH.R;
        int iD = varargs.D(2);
        int iC3 = luaj.lib.StringLib.c3(varargs.Y(3, iD >= 0 ? 1 : i + 1), i);
        if (iC3 < 1 || iC3 > i + 1) {
            luaj.lib.Utf8Lib.a3(T2(), 3, iC3, i);
        }
        byte[] bArr = luaStringH.P;
        int i2 = luaStringH.Q;
        int i3 = iC3 - 1;
        if (iD == 0) {
            while (i3 > 0 && i3 < i && (bArr[i2 + i3] & 192) == 128) {
                i3--;
            }
        } else {
            if (i3 < i) {
                int i4 = i2 + i3;
                if ((bArr[i4] & 192) == 128) {
                    throw new luaj.d("initial position (" + i3 + ") is a continuation byte (0x" + java.lang.Integer.toHexString(bArr[i4] & 255) + ")");
                }
            }
            if (iD < 0) {
                while (iD < 0 && i3 > 0) {
                    do {
                        i3--;
                        if (i3 <= 0 || i3 >= i) {
                            break;
                        }
                    } while ((bArr[i2 + i3] & 192) == 128);
                    iD++;
                }
            } else {
                while (true) {
                    iD--;
                    if (iD <= 0 || i3 >= i) {
                        break;
                    }
                    do {
                        i3++;
                        if (i3 < 0 || i3 >= i) {
                            break;
                        }
                    } while ((bArr[i2 + i3] & 192) == 128);
                }
            }
        }
        return iD == 0 ? luaj.LuaValue.I2(i3 + 1) : luaj.LuaValue.f1673c;
    }
}
