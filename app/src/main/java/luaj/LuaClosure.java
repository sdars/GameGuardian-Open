package luaj;

/* JADX INFO: loaded from: classes.dex */
public class LuaClosure extends luaj.LuaFunction {
    private static final luaj.i[] X = new luaj.i[0];
    private static int Y;
    public final luaj.h R;
    public luaj.i[] S;
    final luaj.Globals T;
    public java.lang.String U = null;
    private luaj.Varargs V = luaj.LuaValue.f1676f;
    public volatile int W;

    public LuaClosure(luaj.h hVar, luaj.LuaValue luaValue, boolean z) {
        this.R = hVar;
        gg_f.d[] dVarArr = hVar.f1728f;
        if (dVarArr == null || dVarArr.length == 0) {
            this.S = X;
        } else {
            int length = dVarArr.length;
            luaj.i[] iVarArr = new luaj.i[length];
            if (z) {
                luaj.LuaValue[] luaValueArr = new luaj.LuaValue[length];
                luaValueArr[0] = luaValue;
                iVarArr[0] = new luaj.i(luaValueArr, 0);
                for (int i = 1; i < length; i++) {
                    luaValueArr[i] = luaj.LuaValue.f1673c;
                    iVarArr[i] = new luaj.i(luaValueArr, i);
                }
            }
            this.S = iVarArr;
        }
        this.T = luaValue instanceof luaj.Globals ? (luaj.Globals) luaValue : null;
    }

    private luaj.LuaValue V2(luaj.LuaValue luaValue) {
        if (luaValue != null) {
            return luaValue;
        }
        throw new java.lang.NullPointerException("return null as LuaValue");
    }

    private luaj.Varargs W2(luaj.Varargs varargs) {
        if (varargs != null) {
            return varargs;
        }
        throw new java.lang.NullPointerException("return null as Varargs");
    }

    private static void X2(luaj.Globals globals, luaj.d dVar, java.lang.StringBuilder sb) {
        if (globals != null) {
            luaj.LuaThread luaThread = globals.f0;
            if (luaThread.S != null) {
                java.lang.String string = sb.toString();
                dVar.f1712e = string;
                try {
                    luaj.LuaValue luaValue = luaThread.S;
                    luaj.LuaValue luaValueK2 = dVar.f1714g;
                    if (luaValueK2 == null) {
                        luaValueK2 = luaj.LuaValue.K2(string);
                    }
                    dVar.f1714g = luaValue.call(luaValueK2);
                    return;
                } catch (java.lang.Throwable unused) {
                    dVar.f1714g = luaj.LuaValue.K2("error in error handling");
                    return;
                }
            }
            if (globals.i0 != null) {
                sb.append('\n');
                sb.append(globals.i0.m3(globals, dVar.f1708a));
            }
        }
        dVar.f1712e = sb.toString();
    }

    private luaj.i Z2(luaj.LuaValue[] luaValueArr, short s, luaj.i[] iVarArr) {
        int length = iVarArr.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            luaj.i iVar = iVarArr[i2];
            if (iVar != null) {
                if (iVar.f1731b == s) {
                    return iVar;
                }
            } else if (i < 0) {
                i = i2;
            }
        }
        if (i >= 0) {
            luaj.i iVar2 = new luaj.i(luaValueArr, s);
            iVarArr[i] = iVar2;
            return iVar2;
        }
        luaj.LuaValue.R0("No space for upvalue " + length);
        return null;
    }

    private luaj.LuaValue[] a3() {
        int i = this.R.l;
        luaj.LuaValue[] luaValueArr = new luaj.LuaValue[i];
        java.lang.System.arraycopy(luaj.LuaValue.O, 0, luaValueArr, 0, i);
        return luaValueArr;
    }

    private static void c3(luaj.Globals globals, luaj.d dVar, luaj.h hVar, int i, java.lang.String str) {
        luaj.lib.DebugLib$a debugLib$aD3;
        luaj.lib.DebugLib debugLib;
        if (dVar.f1712e != null) {
            return;
        }
        if (hVar != null) {
            if (globals == null || (debugLib = globals.i0) == null) {
                debugLib$aD3 = null;
            } else {
                debugLib$aD3 = debugLib.d3(dVar.f1708a);
                if (debugLib$aD3 != null) {
                    java.lang.String strI = debugLib$aD3.i();
                    if (strI == null) {
                        strI = "?";
                    }
                    dVar.f1710c = strI;
                    dVar.f1711d = debugLib$aD3.a();
                }
            }
            if (debugLib$aD3 == null) {
                luaj.LuaString luaString = hVar.f1729g;
                dVar.f1710c = luaString != null ? luaString.g0() : "?";
                int[] iArr = hVar.f1726d;
                dVar.f1711d = (iArr == null || i < 0 || i >= iArr.length) ? -1 : iArr[i];
            }
            dVar.d();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(dVar.getMessage());
        if (str != null) {
            sb.append(" (");
            sb.append(str);
            sb.append(")");
        }
        sb.append("\nlevel = ");
        sb.append(dVar.f1708a);
        if (hVar != null) {
            sb.append(", const = ");
            sb.append(hVar.f1723a.length);
            sb.append(", proto = ");
            sb.append(hVar.f1725c.length);
            sb.append(", upval = ");
            sb.append(hVar.f1728f.length);
            sb.append(", vars = ");
            sb.append(hVar.l);
            sb.append(", code = ");
            sb.append(hVar.f1724b.length);
            sb.append('\n');
            if (i < 0 || i >= hVar.f1724b.length) {
                sb.append("PC ");
                sb.append(i);
            } else {
                luaj.g.F(sb, hVar, i, null);
                sb.append('\n');
                luaj.g.v(sb, i, hVar.f1724b[i]);
            }
        }
        X2(globals, dVar, sb);
    }

    public static luaj.Varargs d3(luaj.Globals globals, luaj.LuaFunction luaFunction, luaj.LuaValue luaValue, luaj.Varargs varargs) {
        luaj.lib.DebugLib debugLib;
        luaj.lib.DebugLib debugLib2;
        luaj.lib.DebugLib debugLib3;
        luaj.lib.DebugLib debugLib4;
        if (globals != null && (debugLib4 = globals.i0) != null) {
            debugLib4.j3(luaFunction, false);
        }
        int i = Y;
        Y = 0;
        try {
            luaj.Varargs varargsN2 = luaj.LuaValue.N2(luaj.LuaValue.f1674d, luaValue.invoke(varargs));
            Y = i;
            if (globals != null && (debugLib3 = globals.i0) != null) {
                debugLib3.l3();
            }
            return varargsN2;
        } catch (java.lang.Throwable th) {
            try {
                luaj.d d_a = th instanceof luaj.d ? (luaj.d) th : new luaj.d$a(th);
                if (d_a.f1712e == null) {
                    c3(globals, d_a, null, 0, null);
                }
                luaj.LuaValue luaValueB = d_a.b();
                luaj.LuaBoolean luaBoolean = luaj.LuaValue.f1675e;
                if (luaValueB == null) {
                    luaValueB = luaj.LuaValue.f1673c;
                }
                luaj.Varargs varargsN3 = luaj.LuaValue.N2(luaBoolean, luaValueB);
                Y = i;
                if (globals != null && (debugLib2 = globals.i0) != null) {
                    debugLib2.l3();
                }
                return varargsN3;
            } catch (java.lang.Throwable th2_c_c_c) {
                Y = i;
                if (globals != null && (debugLib = globals.i0) != null) {
                    debugLib.l3();
                }
                throw th2_c_c_c;
            }
        }
    }

    private void e3(luaj.LuaValue luaValue) {
        if (luaValue instanceof android.ext.Script$DebugFunction) {
            ((android.ext.Script$DebugFunction) luaValue).l3(this);
        }
    }

    private static luaj.d g3(int i, int i2, int i3) {
        return new luaj.d("Damaged script " + i + ": an attempt to get an upvalue with index " + i2 + " when there are " + i3 + " in total.");
    }

    @Override // luaj.LuaValue
    public final luaj.Varargs D1(luaj.Varargs varargs, boolean z) {
        luaj.h hVar;
        int i;
        luaj.LuaValue[] luaValueArrA3 = a3();
        luaj.h hVar2 = this.R;
        if (hVar2.l < hVar2.j) {
            throw new luaj.d("Damaged script: .maxstacksize (" + this.R.l + ") < .numparams (" + this.R.j + ")");
        }
        int i2 = 0;
        while (true) {
            hVar = this.R;
            i = hVar.j;
            if (i2 >= i) {
                break;
            }
            int i3 = i2 + 1;
            luaValueArrA3[i2] = varargs.v(i3);
            i2 = i3;
        }
        return Y2(luaValueArrA3, hVar.k == 0 ? luaj.LuaValue.f1676f : varargs.e0(i + 1), z);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 48941. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    protected luaj.Varargs Y2(luaj.LuaValue[] r40, luaj.Varargs r41, boolean r42) {
        /*
            Method dump skipped, instruction units count: 4894
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: luaj.LuaClosure.Y2(luaj.LuaValue[], luaj.Varargs, boolean):luaj.Varargs");
    }

    public luaj.Varargs b3() {
        return this.V;
    }

    @Override // luaj.LuaValue
    public final luaj.LuaValue call() {
        return Y2(a3(), luaj.LuaValue.f1676f, false).w();
    }

    @Override // luaj.LuaValue
    public final luaj.LuaValue call(luaj.LuaValue luaValue) {
        luaj.LuaValue[] luaValueArrA3 = a3();
        luaj.h hVar = this.R;
        if (hVar.j == 0) {
            if (hVar.k == 0) {
            }
            return Y2(luaValueArrA3, luaValue, false).w();
        }
        luaValueArrA3[0] = luaValue;
        luaValue = luaj.LuaValue.f1676f;
        return Y2(luaValueArrA3, luaValue, false).w();
    }

    @Override // luaj.LuaValue
    public final luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.Varargs varargsN2 = null;
        luaj.Varargs varargsY2 = null;
        luaj.LuaValue[] luaValueArrA3 = a3();
        luaj.h hVar = this.R;
        int i = hVar.j;
        if (i == 0) {
            if (hVar.k != 0) {
                varargsN2 = luaj.LuaValue.N2(luaValue, luaValue2);
            }
            varargsY2 = Y2(luaValueArrA3, varargsN2, false);
            return varargsY2.w();
        }
        if (i != 1) {
            luaValueArrA3[0] = luaValue;
            luaValueArrA3[1] = luaValue2;
        } else {
            luaValueArrA3[0] = luaValue;
            if (hVar.k == 0) {
                luaValue2 = luaj.LuaValue.f1676f;
            }
            varargsY2 = Y2(luaValueArrA3, luaValue2, false);
        }
        return varargsY2.w();
    }

    @Override // luaj.LuaValue
    public final luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        luaj.Varargs varargsY2;
        luaj.Varargs varargsM2 = null;
        luaj.LuaValue[] luaValueArrA3 = a3();
        luaj.h hVar = this.R;
        int i = hVar.j;
        if (i != 0) {
            if (i == 1) {
                luaValueArrA3[0] = luaValue;
                if (hVar.k != 0) {
                    varargsM2 = luaj.LuaValue.N2(luaValue2, luaValue3);
                }
                varargsY2 = Y2(luaValueArrA3, varargsM2, false);
            } else if (i != 2) {
                luaValueArrA3[0] = luaValue;
                luaValueArrA3[1] = luaValue2;
                luaValueArrA3[2] = luaValue3;
            } else {
                luaValueArrA3[0] = luaValue;
                luaValueArrA3[1] = luaValue2;
                if (hVar.k == 0) {
                    luaValue3 = luaj.LuaValue.f1676f;
                }
                varargsY2 = Y2(luaValueArrA3, luaValue3, false);
            }
            varargsY2 = Y2(luaValueArrA3, varargsM2, false);
        } else {
            varargsM2 = hVar.k == 0 ? luaj.LuaValue.f1676f : luaj.LuaValue.M2(luaValue, luaValue2, luaValue3);
            varargsY2 = Y2(luaValueArrA3, varargsM2, false);
        }
        return varargsY2.w();
    }

    @Override // luaj.LuaValue
    public boolean f1() {
        return true;
    }

    public void f3(luaj.Varargs varargs) {
        this.V = varargs;
    }

    @Override // luaj.LuaFunction, luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        return "function: " + this.R.toString();
    }

    @Override // luaj.LuaValue
    public final luaj.Varargs invoke(luaj.Varargs varargs) {
        return D1(varargs, false).N();
    }

    @Override // luaj.LuaValue
    public luaj.LuaClosure w0() {
        return this;
    }
}
