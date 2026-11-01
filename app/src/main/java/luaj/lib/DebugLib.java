package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class DebugLib extends luaj.lib.TwoArgFunction {
    public static boolean U;
    public static boolean V;
    private static final luaj.LuaString W;
    private static final luaj.LuaString X;
    private static final luaj.LuaString Y;
    private static final luaj.LuaString Z;
    private static final luaj.LuaString a0;
    private static final luaj.LuaString b0;
    static final luaj.LuaString c0;
    static final luaj.LuaString d0;
    static final luaj.LuaString e0;
    static final luaj.LuaString f0;
    static final luaj.LuaString g0;
    static final luaj.LuaString h0;
    static final luaj.LuaString i0;
    static final luaj.LuaString j0;
    static final luaj.LuaString k0;
    static final luaj.LuaString l0;
    static final luaj.LuaString m0;
    static final luaj.LuaString n0;
    static final luaj.LuaString o0;
    static final luaj.LuaString p0;
    static final luaj.LuaString q0;
    static final luaj.LuaString r0;
    luaj.Globals T;

    static {
        boolean z = true;
        try {
            U = java.lang.System.getProperty("CALLS") != null;
        } catch (java.lang.Exception unused) {
        }
        try {
            if (java.lang.System.getProperty("TRACE") == null) {
                z = false;
            }
            V = z;
        } catch (java.lang.Exception unused2) {
        }
        W = luaj.LuaValue.K2("?");
        X = luaj.LuaValue.K2("call");
        Y = luaj.LuaValue.K2("tail call");
        Z = luaj.LuaValue.K2("line");
        a0 = luaj.LuaValue.K2("count");
        b0 = luaj.LuaValue.K2("return");
        c0 = luaj.LuaValue.K2("func");
        d0 = luaj.LuaValue.K2("istailcall");
        e0 = luaj.LuaValue.K2("isvararg");
        f0 = luaj.LuaValue.K2("nups");
        g0 = luaj.LuaValue.K2("nparams");
        h0 = luaj.LuaValue.K2("name");
        i0 = luaj.LuaValue.K2("namewhat");
        j0 = luaj.LuaValue.K2("what");
        k0 = luaj.LuaValue.K2("source");
        l0 = luaj.LuaValue.K2("short_src");
        m0 = luaj.LuaValue.K2("linedefined");
        n0 = luaj.LuaValue.K2("lastlinedefined");
        o0 = luaj.LuaValue.K2("currentline");
        p0 = luaj.LuaValue.K2("activelines");
        q0 = luaj.LuaValue.K2("(*temporary)");
        r0 = luaj.LuaValue.K2("(*vararg)");
    }

    private static luaj.LuaString a3(gg_f.d dVar, int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(.upval ");
        if (dVar != null) {
            sb.append(dVar.f1566b ? 'v' : 'u');
            sb.append((int) dVar.f1567c);
        } else {
            sb.append("???");
        }
        sb.append(" \"(*no name)\"; u");
        sb.append(i);
        sb.append(')');
        return luaj.LuaString.K2(sb.toString());
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0063  */
    static int b3(luaj.h hVar, int i, int i2) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i) {
            int i5 = hVar.f1724b[i4];
            int i6 = luaj.b.i(i5);
            if (i6 < 47) {
                int iC = luaj.b.c(i5);
                if (i6 == 4) {
                    int iE = luaj.b.e(i5);
                    if (iC <= i2 && i2 <= iC + iE) {
                        i3 = i4;
                    }
                } else if (i6 == 23) {
                    int iH = luaj.b.h(i5);
                    int i7 = i4 + 1 + iH;
                    if (i4 < i7 && i7 <= i) {
                        i4 += iH;
                    }
                } else if (i6 != 27) {
                    if (i6 != 34) {
                        if (i6 != 36) {
                            if (i6 == 29 || i6 == 30) {
                                if (i2 >= iC) {
                                    i3 = i4;
                                }
                            } else if (luaj.b.q(i6) && i2 == iC) {
                                i3 = i4;
                            }
                        } else if (((i5 >> 14) & 511) == 0) {
                            i4++;
                        }
                    } else if (i2 >= iC + 2) {
                        i3 = i4;
                    }
                } else if (i2 == iC) {
                    i3 = i4;
                }
            }
            i4++;
        }
        return i3;
    }

    static luaj.LuaString c3(luaj.LuaClosure luaClosure, int i) {
        luaj.i[] iVarArr = luaClosure.S;
        if (iVarArr == null || i <= 0 || i > iVarArr.length) {
            return null;
        }
        gg_f.d[] dVarArr = luaClosure.R.f1728f;
        if (dVarArr == null || i > dVarArr.length) {
            return a3(null, i);
        }
        gg_f.d dVar = dVarArr[i - 1];
        luaj.LuaString luaString = dVar.f1565a;
        return luaString == null ? a3(dVar, i) : luaString;
    }

    static luaj.lib.DebugLib$d e3(luaj.lib.DebugLib$a debugLib$a) {
        luaj.LuaString luaString;
        if (!debugLib$a.f1749a.f1()) {
            return new luaj.lib.DebugLib$d(debugLib$a.f1749a.S2(), "Java");
        }
        luaj.h hVar = debugLib$a.f1749a.w0().R;
        int i = debugLib$a.f1750b;
        int[] iArr = hVar.f1724b;
        if (i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        switch (luaj.b.i(i2)) {
            case 6:
            case 7:
            case 12:
                luaString = luaj.LuaValue.l;
                break;
            case 8:
            case 10:
                luaString = luaj.LuaValue.m;
                break;
            case 9:
            case 11:
            case 20:
            case 23:
            case 27:
            case 28:
            case 31:
            case 32:
            case 33:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            default:
                return null;
            case 13:
                luaString = luaj.LuaValue.q;
                break;
            case 14:
                luaString = luaj.LuaValue.r;
                break;
            case 15:
                luaString = luaj.LuaValue.t;
                break;
            case 16:
                luaString = luaj.LuaValue.s;
                break;
            case 17:
                luaString = luaj.LuaValue.v;
                break;
            case 18:
                luaString = luaj.LuaValue.u;
                break;
            case 19:
                luaString = luaj.LuaValue.w;
                break;
            case 21:
                luaString = luaj.LuaValue.x;
                break;
            case 22:
                luaString = luaj.LuaValue.C;
                break;
            case 24:
                luaString = luaj.LuaValue.y;
                break;
            case 25:
                luaString = luaj.LuaValue.z;
                break;
            case 26:
                luaString = luaj.LuaValue.A;
                break;
            case 29:
            case 30:
                return g3(hVar, i, luaj.b.c(i2));
            case 34:
                return new luaj.lib.DebugLib$d("for iterator", "for iterator");
            case 40:
                luaString = luaj.LuaValue.D;
                break;
            case 41:
                luaString = luaj.LuaValue.E;
                break;
            case 42:
                luaString = luaj.LuaValue.F;
                break;
            case 43:
                luaString = luaj.LuaValue.G;
                break;
            case 44:
                luaString = luaj.LuaValue.H;
                break;
            case 45:
                luaString = luaj.LuaValue.I;
                break;
            case 46:
                luaString = luaj.LuaValue.J;
                break;
        }
        return new luaj.lib.DebugLib$d(luaString.g0(), "metamethod");
    }

    public static java.lang.String f3(int i, int i2, luaj.h hVar) {
        luaj.lib.DebugLib$d debugLib$dG3 = g3(hVar, i, i2);
        if (debugLib$dG3 == null) {
            return null;
        }
        return debugLib$dG3.toString();
    }

    static luaj.lib.DebugLib$d g3(luaj.h hVar, int i, int i2) {
        luaj.LuaString luaStringA;
        luaj.LuaString luaStringA2 = hVar.a(i2 + 1, i);
        if (luaStringA2 != null) {
            return new luaj.lib.DebugLib$d(luaStringA2.g0(), "local");
        }
        int iB3 = b3(hVar, i, i2);
        if (iB3 != -1) {
            int i3 = hVar.f1724b[iB3];
            int i4 = luaj.b.i(i3);
            if (i4 == 0) {
                int iC = luaj.b.c(i3);
                int iE = luaj.b.e(i3);
                if (iE < iC) {
                    return g3(hVar, iB3, iE);
                }
            } else if (i4 == 1 || i4 == 2) {
                int iF = luaj.b.i(i3) == 1 ? luaj.b.f(i3) : luaj.b.d(hVar.f1724b[iB3 + 1]);
                if (hVar.f1723a[iF].n1()) {
                    return new luaj.lib.DebugLib$d(hVar.f1723a[iF].q2().g0(), "constant");
                }
            } else {
                if (i4 == 5) {
                    int iE2 = luaj.b.e(i3);
                    gg_f.d[] dVarArr = hVar.f1728f;
                    luaj.LuaString luaString = iE2 < dVarArr.length ? dVarArr[iE2].f1565a : W;
                    if (luaString == null) {
                        return null;
                    }
                    return new luaj.lib.DebugLib$d(luaString.g0(), "upvalue");
                }
                if (i4 == 6 || i4 == 7) {
                    int iG = luaj.b.g(i3);
                    int iE3 = luaj.b.e(i3);
                    if (luaj.b.i(i3) == 7) {
                        luaStringA = hVar.a(iE3 + 1, iB3);
                    } else {
                        gg_f.d[] dVarArr2 = hVar.f1728f;
                        luaStringA = iE3 < dVarArr2.length ? dVarArr2[iE3].f1565a : W;
                    }
                    return new luaj.lib.DebugLib$d(h3(hVar, iB3, iG), (luaStringA == null || !luaStringA.P0(luaj.LuaValue.k)) ? "field" : "global");
                }
                if (i4 == 12) {
                    return new luaj.lib.DebugLib$d(h3(hVar, iB3, luaj.b.g(i3)), "method");
                }
            }
        }
        return null;
    }

    static java.lang.String h3(luaj.h hVar, int i, int i2) {
        if (luaj.b.k(i2)) {
            luaj.LuaValue luaValue = hVar.f1723a[luaj.b.j(i2)];
            return luaValue.n1() ? luaValue.g0() : "?";
        }
        luaj.lib.DebugLib$d debugLib$dG3 = g3(hVar, i, i2);
        return (debugLib$dG3 == null || !"constant".equals(debugLib$dG3.f1766b)) ? "?" : debugLib$dG3.f1765a;
    }

    void X2(luaj.LuaThread$a luaThread$a, luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaFunction luaFunction = luaThread$a.f1670f;
        if (luaThread$a.k != 0 || luaFunction == null) {
            return;
        }
        luaThread$a.k = 1;
        try {
            try {
                try {
                    boolean zF1 = true ^ luaFunction.f1();
                    if (zF1) {
                        j3(luaFunction, false);
                    }
                    try {
                        luaFunction.call(luaValue, luaValue2);
                        if (zF1) {
                            l3();
                        }
                        luaThread$a.k = 0;
                    } catch (java.lang.Throwable th_c_c_c) {
                        if (zF1) {
                            l3();
                        }
                        throw th_c_c_c;
                    }
                } catch (java.lang.Throwable th2_c_c_c) {
                    luaThread$a.k = 0;
                    throw th2_c_c_c;
                }
            } catch (luaj.d e2_c_c_c) {
                throw e2_c_c_c;
            }
        } catch (java.lang.RuntimeException e3) {
            throw new luaj.d$a(e3);
        }
    }

    luaj.lib.DebugLib$b Y2() {
        return Z2(this.T.f0);
    }

    luaj.lib.DebugLib$b Z2(luaj.LuaThread luaThread) {
        if (luaThread.Q == null) {
            luaThread.Q = new luaj.lib.DebugLib$b();
        }
        return (luaj.lib.DebugLib$b) luaThread.Q;
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.Globals globalsZ0 = luaValue2.z0();
        this.T = globalsZ0;
        globalsZ0.i0 = this;
        luaj.LuaTable luaTable = new luaj.LuaTable();
        luaTable.i2("debug", new luaj.lib.DebugLib$debug());
        luaTable.i2("gethook", new luaj.lib.DebugLib$gethook(this));
        luaTable.i2("getinfo", new luaj.lib.DebugLib$getinfo(this));
        luaTable.i2("getlocal", new luaj.lib.DebugLib$getlocal(this));
        luaTable.i2("getmetatable", new luaj.lib.DebugLib$getmetatable());
        luaTable.i2("getregistry", new luaj.lib.DebugLib$getregistry(this));
        luaTable.i2("getupvalue", new luaj.lib.DebugLib$getupvalue());
        luaTable.i2("sethook", new luaj.lib.DebugLib$sethook(this));
        luaTable.i2("setlocal", new luaj.lib.DebugLib$setlocal(this));
        luaTable.i2("setmetatable", new luaj.lib.DebugLib$setmetatable());
        luaTable.i2("setupvalue", new luaj.lib.DebugLib$setupvalue());
        luaTable.i2("traceback", new luaj.lib.DebugLib$traceback(this));
        luaTable.i2("upvalueid", new luaj.lib.DebugLib$upvalueid());
        luaTable.i2("upvaluejoin", new luaj.lib.DebugLib$upvaluejoin());
        luaValue2.i2("debug", luaTable);
        if (!luaValue2.T0("package").l1()) {
            luaValue2.T0("package").T0("loaded").i2("debug", luaTable);
        }
        return luaTable;
    }

    public luaj.lib.DebugLib$a d3(int i) {
        return Y2().e(i);
    }

    public void i3(luaj.LuaClosure luaClosure, luaj.Varargs varargs, luaj.LuaValue[] luaValueArr, boolean z) {
        luaj.LuaThread$a luaThread$a = this.T.f0.P;
        boolean z2 = luaThread$a.k == 1;
        if (z2) {
            luaThread$a.k = 2;
        }
        Y2().f(luaClosure, varargs, luaValueArr, z2, z);
        if (luaThread$a.k != 0) {
            return;
        }
        if (luaThread$a.f1671g) {
            luaThread$a.l = 0;
            luaThread$a.m = 0;
        }
        if (luaThread$a.h) {
            X2(luaThread$a, z ? Y : X, luaj.LuaValue.f1673c);
        }
    }

    public void j3(luaj.LuaFunction luaFunction, boolean z) {
        luaj.LuaThread$a luaThread$a = this.T.f0.P;
        boolean z2 = luaThread$a.k == 1;
        if (z2) {
            luaThread$a.k = 2;
        }
        Y2().g(luaFunction, z2, z);
        if (luaThread$a.k != 0) {
            return;
        }
        if (luaThread$a.f1671g) {
            luaThread$a.l = 0;
            luaThread$a.m = 0;
        }
        if (luaThread$a.h) {
            X2(luaThread$a, z ? Y : X, luaj.LuaValue.f1673c);
        }
    }

    public void k3(int i, luaj.Varargs varargs, int i2) {
        luaj.LuaThread luaThread = this.T.f0;
        luaj.LuaThread$a luaThread$a = luaThread.P;
        Z2(luaThread).h(i, varargs, i2);
        if (luaThread$a.k == 0 && luaThread$a.f1670f != null) {
            int i3 = luaThread$a.j;
            if (i3 > 0) {
                int i4 = luaThread$a.n + 1;
                luaThread$a.n = i4;
                if (i4 % i3 == 0) {
                    X2(luaThread$a, a0, luaj.LuaValue.f1673c);
                }
            }
            if (luaThread$a.f1671g) {
                int iB = Y2().b();
                if (iB != luaThread$a.l || i <= luaThread$a.m) {
                    luaThread$a.l = iB;
                    X2(luaThread$a, Z, luaj.LuaValue.I2(iB));
                }
                luaThread$a.m = i;
            }
        }
    }

    public void l3() {
        luaj.LuaThread$a luaThread$a = this.T.f0.P;
        if (luaThread$a.k == 0 && luaThread$a.i) {
            X2(luaThread$a, b0, luaj.LuaValue.f1673c);
        }
        Y2().i(luaThread$a);
    }

    public java.lang.String m3(luaj.Globals globals, int i) {
        return Y2().m(globals, i);
    }
}
