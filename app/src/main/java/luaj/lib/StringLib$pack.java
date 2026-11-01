package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$pack extends luaj.lib.VarArgFunction {
    StringLib$pack() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0036. Please report as an issue. */
    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        boolean z;
        java.lang.String str;
        long jFloatToRawIntBits;
        int iS1;
        java.lang.String strE = varargs.E(1);
        luaj.lib.StringLib$c stringLib$c = new luaj.lib.StringLib$c(strE);
        gg_f.a aVar = new gg_f.a();
        int length = strE.length();
        byte b2 = 0;
        int i = 0;
        int i2 = 1;
        while (stringLib$c.f1789e < length) {
            byte bY2 = luaj.lib.StringLib.Y2(stringLib$c, i);
            int i3 = stringLib$c.h;
            int i4 = stringLib$c.i;
            int i5 = i + i3 + i4;
            if (i3 > 0) {
                aVar.e(new byte[i3], b2, i3);
            }
            int i6 = i2 + 1;
            switch (bY2) {
                case 0:
                case 8:
                    i5 = i5;
                    i = i5;
                    break;
                case 1:
                case 2:
                    long jF = varargs.F(i6);
                    if (i4 < 8) {
                        int i7 = i4 * 8;
                        if (bY2 == 1) {
                            long j = 1 << (i7 - 1);
                            z = (-j) <= jF && jF < j;
                            str = "integer overflow";
                        } else {
                            z = ((~((1 << i7) - 1)) & jF) == 0;
                            str = "unsigned overflow";
                        }
                        x(z, i6, str);
                    }
                    luaj.lib.StringLib.b3(stringLib$c, aVar, jF);
                    i2 = i6;
                    i = i5;
                    break;
                case 3:
                    jFloatToRawIntBits = java.lang.Float.floatToRawIntBits((float) varargs.B(i6));
                    luaj.lib.StringLib.b3(stringLib$c, aVar, jFloatToRawIntBits);
                    i2 = i6;
                    i = i5;
                    break;
                case 4:
                    luaj.LuaString luaStringH = varargs.H(i6);
                    int iS2 = luaStringH.s1();
                    x(iS2 <= i4, i6, "string longer (" + iS2 + ") than given size (" + i4 + ")");
                    aVar.c(luaStringH);
                    int i8 = i4 - iS2;
                    if (i8 > 0) {
                        aVar.e(new byte[i8], b2, i8);
                    }
                    i2 = i6;
                    i = i5;
                    break;
                case 5:
                    luaj.LuaString luaStringH2 = varargs.H(i6);
                    iS1 = luaStringH2.s1();
                    x(i4 >= stringLib$c.f1785a || ((long) iS1) < (1 << (i4 * 8)), i6, "string length (" + iS1 + ") does not fit in given size (" + i4 + " bytes)");
                    luaj.lib.StringLib.b3(stringLib$c, aVar, (long) iS1);
                    aVar.c(luaStringH2);
                    i = i5 + iS1;
                    i2 = i6;
                    break;
                case 6:
                    luaj.LuaString luaStringH3 = varargs.H(i6);
                    int iS3 = luaStringH3.s1();
                    x(luaStringH3.g0().indexOf(b2) == -1, i6, "string contains zeros");
                    aVar.c(luaStringH3);
                    aVar.a(b2);
                    iS1 = iS3 + 1;
                    i = i5 + iS1;
                    i2 = i6;
                    break;
                case 7:
                    aVar.a(b2);
                    i5 = i5;
                    i = i5;
                    break;
                case 9:
                    jFloatToRawIntBits = java.lang.Double.doubleToRawLongBits(varargs.B(i6));
                    luaj.lib.StringLib.b3(stringLib$c, aVar, jFloatToRawIntBits);
                    i2 = i6;
                    i = i5;
                    break;
                case 10:
                    luaj.LuaNumber luaNumberG = varargs.G(i6);
                    stringLib$c.i = 8;
                    boolean z2 = luaNumberG instanceof luaj.LuaLong;
                    luaj.lib.StringLib.b3(stringLib$c, aVar, z2 ? luaNumberG.z2() : java.lang.Double.doubleToRawLongBits(luaNumberG.x2()));
                    stringLib$c.i = 1;
                    luaj.lib.StringLib.b3(stringLib$c, aVar, z2 ? 1L : 0L);
                    i2 = i6;
                    i = i5;
                    break;
                default:
                    i2 = i6;
                    i = i5;
                    break;
            }
            b2 = 0;
        }
        return aVar.l();
    }
}
