package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$unpack extends luaj.lib.VarArgFunction {
    StringLib$unpack() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaValue luaValueJ2;
        long jE3;
        byte b2 = 1;
        java.lang.String strE = varargs.E(1);
        luaj.LuaString luaStringH = varargs.H(2);
        int iS1 = luaStringH.s1();
        char c2 = 3;
        int iC3 = luaj.lib.StringLib.c3(varargs.Y(3, 1), iS1);
        int i = iC3 - 1;
        x(i >= 0 && i <= iS1, 3, "initial position (" + iC3 + ") out of string (length = " + iS1 + ")");
        luaj.lib.StringLib$c stringLib$c = new luaj.lib.StringLib$c(strE);
        int length = strE.length();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (stringLib$c.f1789e < length) {
            byte bY2 = luaj.lib.StringLib.Y2(stringLib$c, i);
            int i2 = stringLib$c.h;
            int i3 = stringLib$c.i;
            int i4 = i + i2;
            int i5 = i4 + i3;
            if (i5 > iS1) {
                java.lang.Object[] objArr = new java.lang.Object[4];
                objArr[0] = java.lang.Integer.valueOf(iS1);
                objArr[b2] = java.lang.Character.valueOf(stringLib$c.f1790f);
                objArr[2] = java.lang.Integer.valueOf(i5);
                objArr[c2] = java.lang.Integer.valueOf(stringLib$c.f1789e);
                luaj.LuaValue.k0(2, android.ext.t2.f("data string too short (%d) for option '%c' (need %d) at pos %d", objArr));
            }
            switch (bY2) {
                case 1:
                case 2:
                    arrayList.add(luaj.LuaLong.I2(luaj.lib.StringLib.e3(stringLib$c, luaStringH, i4, bY2 == b2)));
                    break;
                case 3:
                    luaValueJ2 = luaj.LuaDouble.J2(java.lang.Float.intBitsToFloat((int) luaj.lib.StringLib.e3(stringLib$c, luaStringH, i4, false)));
                    arrayList.add(luaValueJ2);
                    b2 = 1;
                    break;
                case 4:
                    luaValueJ2 = luaStringH.j3(i4, i5);
                    arrayList.add(luaValueJ2);
                    b2 = 1;
                    break;
                case 5:
                    int iE3 = (int) luaj.lib.StringLib.e3(stringLib$c, luaStringH, i4, false);
                    i4 += iE3;
                    int i6 = i4 + i3;
                    x(i6 <= iS1, 2, "data string too short (" + iS1 + " but need " + i6 + ") at pos " + stringLib$c.f1789e);
                    luaValueJ2 = luaStringH.j3(i5, iE3 + i5);
                    arrayList.add(luaValueJ2);
                    b2 = 1;
                    break;
                case 6:
                    int iC4 = luaStringH.c3((byte) 0, i4);
                    boolean z = iC4 != -1;
                    java.lang.Object[] objArr2 = new java.lang.Object[2];
                    objArr2[0] = java.lang.Character.valueOf(stringLib$c.f1790f);
                    objArr2[b2] = java.lang.Integer.valueOf(stringLib$c.f1789e);
                    x(z, 2, android.ext.t2.f("zero char not found for option '%c' at pos %d", objArr2));
                    arrayList.add(luaStringH.j3(i4, iC4));
                    i4 = iC4 + 1;
                    break;
                case 9:
                    jE3 = luaj.lib.StringLib.e3(stringLib$c, luaStringH, i4, false);
                    arrayList.add(luaj.LuaDouble.J2(java.lang.Double.longBitsToDouble(jE3)));
                    break;
                case 10:
                    stringLib$c.i = 8;
                    jE3 = luaj.lib.StringLib.e3(stringLib$c, luaStringH, i4, false);
                    stringLib$c.i = b2;
                    long jUnpackFlag = luaj.lib.StringLib.e3(stringLib$c, luaStringH, i4 + 8, false);
                    luaj.LuaValue luaValueI2 = jUnpackFlag == 1 ? luaj.LuaLong.I2(jE3) : luaj.LuaDouble.J2(java.lang.Double.longBitsToDouble(jE3));
                    arrayList.add(luaValueI2);
                    break;
            }
            i = i4 + i3;
            c2 = 3;
        }
        arrayList.add(luaj.LuaValue.I2(i + b2));
        return luaj.LuaValue.O2((luaj.LuaValue[]) arrayList.toArray(new luaj.LuaValue[arrayList.size()]));
    }
}
