package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$getinfo extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.DebugLib T;

    DebugLib$getinfo(luaj.lib.DebugLib debugLib) {
        this.T = debugLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaThread luaThreadJ;
        int i;
        luaj.lib.DebugLib$a debugLib$aC;
        luaj.LuaString luaString = null;
        int i2 = 0;
        luaj.LuaValue luaValueI2 = null;
        if (varargs.T(1)) {
            luaThreadJ = varargs.J(1);
            i = 2;
        } else {
            luaThreadJ = this.T.T.f0;
            i = 1;
        }
        luaj.LuaValue luaValueV = varargs.v(i);
        java.lang.String strZ = varargs.Z(i + 1, "flnStu");
        luaj.lib.DebugLib$b debugLib$bZ2 = this.T.Z2(luaThreadJ);
        if (luaValueV.m1()) {
            int iY2 = luaValueV.y2();
            if (debugLib$bZ2.e(1).f1749a == this) {
                iY2++;
            }
            debugLib$aC = debugLib$bZ2.e(iY2);
            if (debugLib$aC == null) {
                return luaj.LuaValue.f1676f;
            }
            luaValueV = debugLib$aC.f1749a;
        } else {
            if (!luaValueV.g1()) {
                return luaj.LuaValue.k0(i, "function or level");
            }
            debugLib$aC = debugLib$bZ2.c(luaValueV);
        }
        luaj.lib.DebugLib$c debugLib$cA = debugLib$bZ2.a(strZ, (luaj.LuaFunction) luaValueV, debugLib$aC);
        luaj.LuaTable luaTable = new luaj.LuaTable();
        for (int i3 = 0; i3 < strZ.length(); i3++) {
            char cCharAt = strZ.charAt(i3);
            if (cCharAt != 'L') {
                if (cCharAt == 'S') {
                    luaTable.j2(luaj.lib.DebugLib.j0, luaj.LuaValue.K2(debugLib$cA.f1760c));
                    luaTable.j2(luaj.lib.DebugLib.k0, luaj.LuaValue.K2(debugLib$cA.f1761d));
                    luaTable.j2(luaj.lib.DebugLib.l0, luaj.LuaValue.K2(debugLib$cA.l));
                    luaTable.j2(luaj.lib.DebugLib.m0, luaj.LuaValue.I2(debugLib$cA.f1763f));
                    luaString = luaj.lib.DebugLib.n0;
                    i2 = debugLib$cA.f1764g;
                } else if (cCharAt != 'f') {
                    if (cCharAt != 'l') {
                        if (cCharAt == 'n') {
                            luaj.LuaString luaString2 = luaj.lib.DebugLib.h0;
                            java.lang.String str = debugLib$cA.f1758a;
                            luaTable.j2(luaString2, str != null ? luaj.LuaValue.K2(str) : luaj.LuaValue.f1673c);
                            luaString = luaj.lib.DebugLib.i0;
                            luaValueI2 = luaj.LuaValue.K2(debugLib$cA.f1759b);
                        } else if (cCharAt == 't') {
                            luaString = luaj.lib.DebugLib.d0;
                            luaValueI2 = luaj.LuaValue.H2(debugLib$cA.k);
                        } else if (cCharAt != 'u') {
                            char cCharAt2 = strZ.charAt(i3);
                            luaj.LuaValue.l0(i + 1, "debug.getinfo", "invalid option: '" + cCharAt2 + "' [0x" + java.lang.Integer.toHexString(cCharAt2) + "] at index " + (i3 + 1) + " in '" + strZ + "'");
                        } else {
                            luaTable.j2(luaj.lib.DebugLib.f0, luaj.LuaValue.I2(debugLib$cA.h));
                            luaTable.j2(luaj.lib.DebugLib.g0, luaj.LuaValue.I2(debugLib$cA.i));
                            luaString = luaj.lib.DebugLib.e0;
                            luaValueI2 = debugLib$cA.j ? luaj.LuaValue.f1674d : luaj.LuaValue.f1675e;
                        }
                        luaTable.j2(luaString, luaValueI2);
                    } else {
                        luaString = luaj.lib.DebugLib.o0;
                        i2 = debugLib$cA.f1762e;
                    }
                } else if (luaValueV != null) {
                    luaTable.j2(luaj.lib.DebugLib.c0, luaValueV);
                }
                luaValueI2 = luaj.LuaValue.I2(i2);
                luaTable.j2(luaString, luaValueI2);
            } else if (luaValueV.f1()) {
                luaj.LuaTable luaTable2 = new luaj.LuaTable();
                luaTable.j2(luaj.lib.DebugLib.p0, luaTable2);
                for (int i4 : luaValueV.w0().R.f1726d) {
                    luaTable2.d2(luaj.LuaValue.I2(i4), luaj.LuaValue.f1674d);
                }
            }
        }
        return luaTable;
    }
}
