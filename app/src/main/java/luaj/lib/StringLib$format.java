package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$format extends luaj.lib.VarArgFunction {
    StringLib$format() {
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:47:0x0106  */
    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        java.lang.String strG0 = null;
        luaj.LuaString luaStringH = varargs.H(1);
        int iS1 = luaStringH.s1();
        gg_f.a aVar = new gg_f.a(iS1);
        luaj.lib.StringLib$a stringLib$a = null;
        int i = 0;
        int i2 = 1;
        while (i < iS1) {
            int i3 = i + 1;
            int iG3 = luaStringH.g3(i);
            if (iG3 != 10) {
                if (iG3 != 37) {
                    aVar.a((byte) iG3);
                } else if (i3 < iS1) {
                    if (luaStringH.g3(i3) != 37) {
                        i2++;
                        luaj.lib.StringLib$a stringLib$a2 = new luaj.lib.StringLib$a(varargs, luaStringH, i3);
                        i3 += stringLib$a2.i;
                        int i4 = stringLib$a2.h;
                        switch (i4) {
                            case 65:
                            case 69:
                            case 71:
                            case 97:
                                stringLib$a2.b(aVar, varargs.B(i2));
                                break;
                            case 88:
                            case 105:
                            case 111:
                            case 117:
                            case 120:
                                stringLib$a2.c(aVar, varargs.F(i2));
                                break;
                            case 113:
                                luaj.LuaValue luaValueV = varargs.v(i2);
                                int iC2 = luaValueV.C2();
                                if (iC2 == 0 || iC2 == 1) {
                                    strG0 = luaValueV.g0();
                                } else if (iC2 == 3) {
                                    if (luaValueV instanceof luaj.LuaDouble) {
                                        if (stringLib$a == null) {
                                            stringLib$a = new luaj.lib.StringLib$a(varargs, luaj.LuaString.K2("%a"), 1);
                                        }
                                        stringLib$a.b(aVar, luaValueV.x0());
                                    } else if ((luaValueV instanceof luaj.LuaLong) && luaValueV.z2() == Long.MIN_VALUE) {
                                        strG0 = "0x8000000000000000";
                                    } else {
                                        aVar.d(luaValueV);
                                    }
                                } else if (iC2 == 4) {
                                    luaj.lib.StringLib.X2(aVar, varargs.H(i2));
                                } else {
                                    luaj.LuaValue.l0(i2, "string.format", "'" + luaValueV + "': value has no literal form");
                                }
                                break;
                            case 115:
                                luaj.LuaString luaStringD3 = luaj.lib.BaseLib.d3(varargs.v(i2));
                                if (stringLib$a2.f1777g == -1 && luaStringD3.s1() >= 100) {
                                    aVar.c(luaStringD3);
                                } else {
                                    stringLib$a2.d(aVar, luaStringD3.G0());
                                }
                                break;
                            default:
                                switch (i4) {
                                    case 99:
                                        stringLib$a2.a(aVar, (byte) varargs.D(i2));
                                        break;
                                    case 100:
                                        stringLib$a2.c(aVar, varargs.F(i2));
                                        break;
                                    case 101:
                                    case 102:
                                    case 103:
                                        stringLib$a2.b(aVar, varargs.B(i2));
                                        break;
                                    default:
                                        luaj.LuaValue.R0("invalid option '%" + ((char) stringLib$a2.h) + "' to 'string.format'");
                                        break;
                                }
                                break;
                        }
                    } else {
                        i += 2;
                        aVar.a((byte) 37);
                    }
                }
                i = i3;
            } else {
                strG0 = "\n";
            }
            aVar.b(strG0);
            i = i3;
        }
        return aVar.l();
    }
}
