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
    /* ------------------------------------------------------------- *
     *  .method protected Y2([Lluaj/LuaValue;Lluaj/Varargs;Z)Lluaj/Varargs;
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    protected luaj.Varargs Y2(luaj.LuaValue[] r40, luaj.Varargs r41, boolean r42) {
        lcY2State st = new lcY2State();
        st.v39o = this;
        st.v40o = r40;
        st.v41o = r41;
        st.v42i = (r42 ? 1 : 0);
        return lcY2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void lcY2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class lcY2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
        int v9i;
        long v9j;
        java.lang.Object v9o;
        double v9d;
        int v10i;
        long v10j;
        java.lang.Object v10o;
        double v10d;
        int v11i;
        long v11j;
        java.lang.Object v11o;
        double v11d;
        int v12i;
        long v12j;
        java.lang.Object v12o;
        double v12d;
        int v13i;
        long v13j;
        java.lang.Object v13o;
        double v13d;
        int v14i;
        long v14j;
        java.lang.Object v14o;
        double v14d;
        int v15i;
        long v15j;
        java.lang.Object v15o;
        double v15d;
        int v16i;
        long v16j;
        java.lang.Object v16o;
        double v16d;
        int v17i;
        long v17j;
        java.lang.Object v17o;
        double v17d;
        int v18i;
        long v18j;
        java.lang.Object v18o;
        double v18d;
        int v19i;
        long v19j;
        java.lang.Object v19o;
        double v19d;
        int v20i;
        long v20j;
        java.lang.Object v20o;
        double v20d;
        int v21i;
        long v21j;
        java.lang.Object v21o;
        double v21d;
        int v22i;
        long v22j;
        java.lang.Object v22o;
        double v22d;
        int v23i;
        long v23j;
        java.lang.Object v23o;
        double v23d;
        int v24i;
        long v24j;
        java.lang.Object v24o;
        double v24d;
        int v25i;
        long v25j;
        java.lang.Object v25o;
        double v25d;
        int v26i;
        long v26j;
        java.lang.Object v26o;
        double v26d;
        int v27i;
        long v27j;
        java.lang.Object v27o;
        double v27d;
        int v28i;
        long v28j;
        java.lang.Object v28o;
        double v28d;
        int v29i;
        long v29j;
        java.lang.Object v29o;
        double v29d;
        int v30i;
        long v30j;
        java.lang.Object v30o;
        double v30d;
        int v31i;
        long v31j;
        java.lang.Object v31o;
        double v31d;
        int v32i;
        long v32j;
        java.lang.Object v32o;
        double v32d;
        int v33i;
        long v33j;
        java.lang.Object v33o;
        double v33d;
        int v34i;
        long v34j;
        java.lang.Object v34o;
        double v34d;
        int v35i;
        long v35j;
        java.lang.Object v35o;
        double v35d;
        int v36i;
        long v36j;
        java.lang.Object v36o;
        double v36d;
        int v37i;
        long v37j;
        java.lang.Object v37o;
        double v37d;
        int v38i;
        long v38j;
        java.lang.Object v38o;
        double v38d;
        java.lang.Object v39o;
        java.lang.Object v40o;
        java.lang.Object v41o;
        int v42i;
    }

    private static luaj.Varargs lcY2_run(lcY2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 1200) {
                done = lcY2_c0(st);
            }
            else if (pc < 2400) {
                done = lcY2_c1(st);
            }
            else if (pc < 2520) {
                done = lcY2_c2(st);
            }
            else {
                done = lcY2_c2(st);
            }
            if (done) {
                return (luaj.Varargs) st.resultO;
            }
        }
    }

    private static boolean lcY2_c0(lcY2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v1o = st.v39o;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 1:
                        st.v2o = st.v40o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2:
                        st.v3o = st.v41o;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 3:
                        st.v4i = st.v42i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 4:
                        st.v5o = ")";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v6o = luaj.LuaValue.f1676f;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v7o = ((luaj.LuaClosure) st.v1o).R;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v8o = ((luaj.h) st.v7o).f1724b;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v9o = ((luaj.h) st.v7o).f1723a;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v10o = ((luaj.LuaClosure) st.v1o).S;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 10:
                        st.pc = 10;
                        ((luaj.LuaClosure) st.v1o).V = (luaj.Varargs) st.v3o;
                    case 11:
                        st.pc = 11;
                        st.v11i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.v7o = ((luaj.h) st.v7o).f1725c;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.v7i = java.lang.reflect.Array.getLength(st.v7o);
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v7i <= 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 15:
                        st.pc = 15;
                        st.v7o = new luaj.i[st.v11i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.pc = 18;
                        continue;
                    case 17:
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.v13o = ((luaj.LuaClosure) st.v1o).T;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 19:
                        st.pc = 19;
                        if (st.v13o == null) {
                            st.pc = 22;
                            continue;
                        }
                    case 20:
                        st.pc = 20;
                        st.v14o = ((luaj.Globals) st.v13o).i0;
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 21:
                        st.pc = 21;
                        st.pc = 23;
                        continue;
                    case 22:
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14o = null;
                        st.v14d = 0.0;
                    case 23:
                        st.pc = 23;
                        if ((st.v14o == null && st.v14i == 0)) {
                            st.pc = 25;
                            continue;
                        }
                    case 24:
                        st.pc = 24;
                        ((luaj.lib.DebugLib) st.v14o).i3((luaj.LuaClosure) st.v1o, (luaj.Varargs) st.v3o, (luaj.LuaValue[]) st.v2o, (st.v4i != 0));
                    case 25:
                        st.v15i = 1;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.v16i = luaj.LuaClosure.Y;
                        st.v16j = 0L;
                        st.v16o = null;
                        st.v16d = 0.0;
                    case 27:
                        st.v16i = st.v16i + 1;
                        st.v16j = 0L;
                        st.v16o = null;
                        st.v16d = 0.0;
                    case 28:
                        st.pc = 28;
                        luaj.LuaClosure.Y = st.v16i;
                    case 29:
                        st.pc = 29;
                        st.v16o = luaj.LuaValue.f1673c;
                        st.v16i = 0;
                        st.v16j = 0L;
                        st.v16d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.v17o = luaj.LuaValue.f1674d;
                        st.v17i = 0;
                        st.v17j = 0L;
                        st.v17d = 0.0;
                    case 31:
                        st.pc = 31;
                        st.v18o = luaj.LuaValue.f1675e;
                        st.v18i = 0;
                        st.v18j = 0L;
                        st.v18d = 0.0;
                    case 32:
                        st.pc = 32;
                        st.v3o = luaj.LuaValue.f1677g;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 33:
                        st.pc = 33;
                        st.v15o = ((luaj.LuaClosure) st.v1o).U;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 34:
                        st.pc = 34;
                        st.v12o = ((luaj.LuaClosure) st.v1o).R;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 35:
                        st.pc = 35;
                        st.v12o = ((luaj.h) st.v12o).f1725c;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 36:
                        st.pc = 36;
                        st.tmpO = java.lang.Thread.currentThread();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 37:
                        st.v21o = st.tmpO;
                        st.v21i = 0;
                        st.v21j = 0L;
                        st.v21d = 0.0;
                    case 38:
                        st.v25o = st.v6o;
                        st.v25i = 0;
                        st.v25j = 0L;
                        st.v25d = 0.0;
                    case 39:
                        st.v24i = st.v11i;
                        st.v24j = 0L;
                        st.v24o = null;
                        st.v24d = 0.0;
                    case 40:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 41:
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 42:
                        st.v22i = 0;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 43:
                        st.v23i = 0;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 44:
                        st.v26i = 0;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 45:
                        st.v27i = 0;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 46:
                        st.pc = 46;
                        st.tmpI = (((java.lang.Thread) st.v21o).isInterrupted()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 47:
                        st.v28i = st.tmpI;
                        st.v28j = 0L;
                        st.v28o = null;
                        st.v28d = 0.0;
                    case 48:
                        st.pc = 48;
                        if (st.v28i != 0) {
                            st.pc = 2271;
                            continue;
                        }
                    case 49:
                        st.pc = 49;
                        if ((st.v14o == null && st.v14i == 0)) {
                            st.pc = 79;
                            continue;
                        }
                    case 50:
                        st.pc = 50;
                        ((luaj.lib.DebugLib) st.v14o).k3(st.v11i, (luaj.Varargs) st.v6o, st.v4i);
                    case 51:
                        st.pc = 51;
                        st.pc = 79;
                        continue;
                    case 52:
                        st.pc = 52;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 53:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 54:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 55:
                        st.v3i = st.v11i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 56:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 57:
                        st.pc = 57;
                        st.pc = 2308;
                        continue;
                    case 58:
                        st.pc = 58;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 59:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 60:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 61:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 62:
                        st.pc = 62;
                        st.pc = 2318;
                        continue;
                    case 63:
                        st.pc = 63;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 64:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 65:
                        st.v4o = st.v5o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 66:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 67:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 68:
                        st.pc = 68;
                        st.pc = 2323;
                        continue;
                    case 69:
                        st.pc = 69;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 70:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 71:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 72:
                        st.v4i = st.v11i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 73:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 74:
                        st.v3i = st.v22i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 75:
                        st.v22i = st.v23i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 76:
                        st.v6i = st.v26i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 77:
                        st.v11i = st.v27i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 78:
                        st.pc = 78;
                        st.pc = 2339;
                        continue;
                    case 79:
                        st.pc = 79;
                        ((luaj.LuaClosure) st.v1o).W = st.v11i;
                    case 80:
                        st.v28o = st.v14o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 81:
                        st.pc = 81;
                        st.v14i = ((int[]) st.v8o)[st.v11i];
                        st.v14j = 0L;
                        st.v14o = null;
                        st.v14d = 0.0;
                    case 82:
                        st.v29o = st.v3o;
                        st.v29i = 0;
                        st.v29j = 0L;
                        st.v29d = 0.0;
                    case 83:
                        st.v3i = st.v14i >> 6;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 84:
                        st.v30o = st.v5o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 85:
                        st.v5i = 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 86:
                        st.v3i = st.v3i & st.v5i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 87:
                        st.v5i = st.v14i & 63;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 88:
                        st.v31o = st.v6o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 89:
                        st.v6o = " (";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 90:
                        st.v22o = st.v6o;
                        st.v22i = 0;
                        st.v22j = 0L;
                        st.v22d = 0.0;
                    case 91:
                        st.v6o = "Null from ";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 92:
                        st.v23i = 8372224;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 93:
                        st.v32i = 131071;
                        st.v32j = 0L;
                        st.v32o = null;
                        st.v32d = 0.0;
                    case 94:
                        st.v33o = st.v6o;
                        st.v33i = 0;
                        st.v33j = 0L;
                        st.v33d = 0.0;
                    case 95:
                        st.v6i = 2;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 96:
                        switch (st.v5i) {
                            case 0: st.pc = 2208; continue;
                            case 1: st.pc = 2191; continue;
                            case 2: st.pc = 2132; continue;
                            case 3: st.pc = 2107; continue;
                            case 4: st.pc = 2075; continue;
                            case 5: st.pc = 2050; continue;
                            case 6: st.pc = 2016; continue;
                            case 7: st.pc = 1986; continue;
                            case 8: st.pc = 1928; continue;
                            case 9: st.pc = 1903; continue;
                            case 10: st.pc = 1857; continue;
                            case 11: st.pc = 1837; continue;
                            case 12: st.pc = 1798; continue;
                            case 13: st.pc = 1766; continue;
                            case 14: st.pc = 1734; continue;
                            case 15: st.pc = 1702; continue;
                            case 16: st.pc = 1670; continue;
                            case 17: st.pc = 1638; continue;
                            case 18: st.pc = 1606; continue;
                            case 19: st.pc = 1587; continue;
                            case 20: st.pc = 1568; continue;
                            case 21: st.pc = 1549; continue;
                            case 22: st.pc = 1502; continue;
                            case 23: st.pc = 1458; continue;
                            case 24: st.pc = 1422; continue;
                            case 25: st.pc = 1386; continue;
                            case 26: st.pc = 1328; continue;
                            case 27: st.pc = 1305; continue;
                            case 28: st.pc = 1273; continue;
                            case 29: st.pc = 864; continue;
                            case 30: st.pc = 787; continue;
                            case 31: st.pc = 707; continue;
                            case 32: st.pc = 673; continue;
                            case 33: st.pc = 628; continue;
                            case 34: st.pc = 551; continue;
                            case 35: st.pc = 527; continue;
                            case 36: st.pc = 429; continue;
                            case 37: st.pc = 395; continue;
                            case 38: st.pc = 362; continue;
                            case 39: st.pc = 358; continue;
                            case 40: st.pc = 336; continue;
                            case 41: st.pc = 317; continue;
                            case 42: st.pc = 295; continue;
                            case 43: st.pc = 273; continue;
                            case 44: st.pc = 251; continue;
                            case 45: st.pc = 208; continue;
                            case 46: st.pc = 140; continue;
                            default: st.pc = 97; continue;
                        }
                    case 97:
                        st.v4i = 63;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 98:
                        st.pc = 98;
                        if (st.v5i != st.v4i) {
                            st.pc = 130;
                            continue;
                        }
                    case 99:
                        st.pc = 99;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 100:
                        st.v5o = "Damaged script: 5";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 101:
                        st.pc = 101;
                        st.v4o = new luaj.d((java.lang.String) st.v5o);
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 102:
                        st.pc = 102;
                        throw (java.lang.Throwable) st.v4o;
                    case 103:
                        st.pc = 103;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 104:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 105:
                        st.v3i = st.v11i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 106:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 107:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 108:
                        st.pc = 108;
                        st.pc = 2308;
                        continue;
                    case 109:
                        st.pc = 109;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 110:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 111:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 112:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 113:
                        st.pc = 113;
                        st.pc = 2318;
                        continue;
                    case 114:
                        st.pc = 114;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 115:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 116:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 117:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 118:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 119:
                        st.pc = 119;
                        st.pc = 2323;
                        continue;
                    case 120:
                        st.pc = 120;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 121:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 122:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 123:
                        st.v4i = st.v11i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 124:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 125:
                        st.v6i = st.v26i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 126:
                        st.v11i = st.v27i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 127:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 128:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 129:
                        st.pc = 129;
                        st.pc = 2339;
                        continue;
                    case 130:
                        st.pc = 130;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 131:
                        st.pc = 131;
                        st.v6o = null;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 132:
                        st.pc = 132;
                        st.v6o = new java.lang.StringBuilder();
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 133:
                        st.v8o = "Illegal opcode: ";
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 134:
                        st.pc = 134;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 135:
                        st.pc = 135;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append(st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 136:
                        st.pc = 136;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 137:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 138:
                        st.pc = 138;
                        st.v4o = new java.lang.IllegalArgumentException((java.lang.String) st.v5o);
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 139:
                        st.pc = 139;
                        throw (java.lang.Throwable) st.v4o;
                    case 140:
                        st.v5i = st.v14i >>> 23;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 141:
                        st.v6i = 255;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 142:
                        st.pc = 142;
                        if (st.v5i <= st.v6i) {
                            st.pc = 155;
                            continue;
                        }
                    case 143:
                        st.v6i = st.v5i & 255;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 144:
                        st.pc = 144;
                        st.v6o = ((java.lang.Object[]) st.v9o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 145:
                        st.pc = 145;
                        st.pc = 156;
                        continue;
                    case 146:
                        st.pc = 146;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 147:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 148:
                        st.v6i = st.v5i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 149:
                        st.v4i = st.v11i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 150:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 151:
                        st.v11i = st.v27i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 152:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 153:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 154:
                        st.pc = 154;
                        st.pc = 128;
                        continue;
                    case 155:
                        st.pc = 155;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v5i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 156:
                        st.v22i = st.v5i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 157:
                        st.v5i = st.v14i >> 14;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 158:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 159:
                        st.v4i = st.v5i & 511;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 160:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 161:
                        st.v8i = 255;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 162:
                        st.pc = 162;
                        if (st.v4i <= st.v8i) {
                            st.pc = 177;
                            continue;
                        }
                    case 163:
                        st.v5i = st.v5i & 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 164:
                        st.pc = 164;
                        st.v5o = ((java.lang.Object[]) st.v9o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 165:
                        st.pc = 165;
                        st.pc = 178;
                        continue;
                    case 166:
                        st.pc = 166;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 167:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 168:
                        st.v6i = st.v22i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 169:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 170:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 171:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 172:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 173:
                        st.v38i = st.v11i;
                        st.v38j = 0L;
                        st.v38o = null;
                        st.v38d = 0.0;
                    case 174:
                        st.v11i = st.v4i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 175:
                        st.v4i = st.v38i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 176:
                        st.pc = 176;
                        st.pc = 2339;
                        continue;
                    case 177:
                        st.pc = 177;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 178:
                        st.pc = 178;
                        st.tmpO = ((luaj.LuaValue) st.v6o).n2((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 179:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 180:
                        st.pc = 180;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v5o;
                    case 181:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 182:
                        st.v27i = st.v4i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 183:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 184:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 185:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 186:
                        st.v26i = st.v22i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 187:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 188:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 189:
                        st.v6o = st.v31o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 190:
                        st.v5i = st.v34i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 191:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 192:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 193:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 194:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 195:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 196:
                        st.pc = 196;
                        st.pc = 2225;
                        continue;
                    case 197:
                        st.pc = 197;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 198:
                        st.v22i = st.v5i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 199:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 200:
                        st.v4i = st.v11i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 201:
                        st.v6i = st.v22i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 202:
                        st.v11i = st.v27i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 203:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 204:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 205:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 206:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 207:
                        st.pc = 207;
                        st.pc = 2339;
                        continue;
                    case 208:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 209:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 210:
                        st.v4i = st.v14i >>> 23;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 211:
                        st.v5i = 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 212:
                        st.pc = 212;
                        if (st.v4i <= st.v5i) {
                            st.pc = 223;
                            continue;
                        }
                    case 213:
                        st.v5i = st.v4i & 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 214:
                        st.pc = 214;
                        st.v5o = ((java.lang.Object[]) st.v9o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 215:
                        st.pc = 215;
                        st.pc = 224;
                        continue;
                    case 216:
                        st.pc = 216;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 217:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 218:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 219:
                        st.v6i = st.v4i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 220:
                        st.v4i = st.v11i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 221:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 222:
                        st.pc = 222;
                        st.pc = 126;
                        continue;
                    case 223:
                        st.pc = 223;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 224:
                        st.v6i = st.v14i >> 14;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 225:
                        st.v8i = st.v6i & 511;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 226:
                        st.v22i = st.v4i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 227:
                        st.v4i = 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 228:
                        st.pc = 228;
                        if (st.v8i <= st.v4i) {
                            st.pc = 241;
                            continue;
                        }
                    case 229:
                        st.v4i = st.v6i & 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 230:
                        st.pc = 230;
                        st.v4o = ((java.lang.Object[]) st.v9o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 231:
                        st.pc = 231;
                        st.pc = 242;
                        continue;
                    case 232:
                        st.pc = 232;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 233:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 234:
                        st.v4i = st.v11i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 235:
                        st.v6i = st.v22i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 236:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 237:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 238:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 239:
                        st.v11i = st.v8i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 240:
                        st.pc = 240;
                        st.pc = 206;
                        continue;
                    case 241:
                        st.pc = 241;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v8i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 242:
                        st.pc = 242;
                        st.tmpO = ((luaj.LuaValue) st.v5o).m2((luaj.LuaValue) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 243:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 244:
                        st.pc = 244;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v4o;
                    case 245:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 246:
                        st.v27i = st.v8i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 247:
                        st.pc = 247;
                        st.pc = 183;
                        continue;
                    case 248:
                        st.pc = 248;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 249:
                        st.v22i = st.v4i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 250:
                        st.pc = 250;
                        st.pc = 199;
                        continue;
                    case 251:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 252:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 253:
                        st.v4i = st.v14i >>> 23;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 254:
                        st.v5i = 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 255:
                        st.pc = 255;
                        if (st.v4i <= st.v5i) {
                            st.pc = 259;
                            continue;
                        }
                    case 256:
                        st.v5i = st.v4i & 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 257:
                        st.pc = 257;
                        st.v5o = ((java.lang.Object[]) st.v9o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 258:
                        st.pc = 258;
                        st.pc = 260;
                        continue;
                    case 259:
                        st.pc = 259;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 260:
                        st.v6i = st.v14i >> 14;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 261:
                        st.v8i = st.v6i & 511;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 262:
                        st.v22i = st.v4i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 263:
                        st.v4i = 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 264:
                        st.pc = 264;
                        if (st.v8i <= st.v4i) {
                            st.pc = 268;
                            continue;
                        }
                    case 265:
                        st.v4i = st.v6i & 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 266:
                        st.pc = 266;
                        st.v4o = ((java.lang.Object[]) st.v9o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 267:
                        st.pc = 267;
                        st.pc = 269;
                        continue;
                    case 268:
                        st.pc = 268;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v8i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 269:
                        st.pc = 269;
                        st.tmpO = ((luaj.LuaValue) st.v5o).t0((luaj.LuaValue) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 270:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 271:
                        st.pc = 271;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v4o;
                    case 272:
                        st.pc = 272;
                        st.pc = 245;
                        continue;
                    case 273:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 274:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 275:
                        st.v4i = st.v14i >>> 23;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 276:
                        st.v5i = 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 277:
                        st.pc = 277;
                        if (st.v4i <= st.v5i) {
                            st.pc = 281;
                            continue;
                        }
                    case 278:
                        st.v5i = st.v4i & 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 279:
                        st.pc = 279;
                        st.v5o = ((java.lang.Object[]) st.v9o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 280:
                        st.pc = 280;
                        st.pc = 282;
                        continue;
                    case 281:
                        st.pc = 281;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 282:
                        st.v6i = st.v14i >> 14;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 283:
                        st.v8i = st.v6i & 511;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 284:
                        st.v22i = st.v4i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 285:
                        st.v4i = 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 286:
                        st.pc = 286;
                        if (st.v8i <= st.v4i) {
                            st.pc = 290;
                            continue;
                        }
                    case 287:
                        st.v4i = st.v6i & 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 288:
                        st.pc = 288;
                        st.v4o = ((java.lang.Object[]) st.v9o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 289:
                        st.pc = 289;
                        st.pc = 291;
                        continue;
                    case 290:
                        st.pc = 290;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v8i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 291:
                        st.pc = 291;
                        st.tmpO = ((luaj.LuaValue) st.v5o).r0((luaj.LuaValue) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 292:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 293:
                        st.pc = 293;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v4o;
                    case 294:
                        st.pc = 294;
                        st.pc = 245;
                        continue;
                    case 295:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 296:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 297:
                        st.v4i = st.v14i >>> 23;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 298:
                        st.v5i = 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 299:
                        st.pc = 299;
                        if (st.v4i <= st.v5i) {
                            st.pc = 303;
                            continue;
                        }
                    case 300:
                        st.v5i = st.v4i & 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 301:
                        st.pc = 301;
                        st.v5o = ((java.lang.Object[]) st.v9o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 302:
                        st.pc = 302;
                        st.pc = 304;
                        continue;
                    case 303:
                        st.pc = 303;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 304:
                        st.v6i = st.v14i >> 14;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 305:
                        st.v8i = st.v6i & 511;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 306:
                        st.v22i = st.v4i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 307:
                        st.v4i = 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 308:
                        st.pc = 308;
                        if (st.v8i <= st.v4i) {
                            st.pc = 312;
                            continue;
                        }
                    case 309:
                        st.v4i = st.v6i & 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 310:
                        st.pc = 310;
                        st.v4o = ((java.lang.Object[]) st.v9o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 311:
                        st.pc = 311;
                        st.pc = 313;
                        continue;
                    case 312:
                        st.pc = 312;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v8i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 313:
                        st.pc = 313;
                        st.tmpO = ((luaj.LuaValue) st.v5o).o0((luaj.LuaValue) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 314:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 315:
                        st.pc = 315;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v4o;
                    case 316:
                        st.pc = 316;
                        st.pc = 245;
                        continue;
                    case 317:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 318:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 319:
                        st.v4i = st.v14i >>> 23;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 320:
                        st.pc = 320;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 321:
                        st.pc = 321;
                        st.tmpO = ((luaj.LuaValue) st.v4o).q0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 322:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 323:
                        st.pc = 323;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v4o;
                    case 324:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 325:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 326:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 327:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 328:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 329:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 330:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 331:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 332:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 333:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 334:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 335:
                        st.pc = 335;
                        st.pc = 2104;
                        continue;
                    case 336:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 337:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 338:
                        st.v4i = st.v14i >>> 23;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 339:
                        st.v5i = 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 340:
                        st.pc = 340;
                        if (st.v4i <= st.v5i) {
                            st.pc = 344;
                            continue;
                        }
                    case 341:
                        st.v5i = st.v4i & 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 342:
                        st.pc = 342;
                        st.v5o = ((java.lang.Object[]) st.v9o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 343:
                        st.pc = 343;
                        st.pc = 345;
                        continue;
                    case 344:
                        st.pc = 344;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 345:
                        st.v6i = st.v14i >> 14;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 346:
                        st.v8i = st.v6i & 511;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 347:
                        st.v22i = st.v4i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 348:
                        st.v4i = 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 349:
                        st.pc = 349;
                        if (st.v8i <= st.v4i) {
                            st.pc = 353;
                            continue;
                        }
                    case 350:
                        st.v4i = st.v6i & 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 351:
                        st.pc = 351;
                        st.v4o = ((java.lang.Object[]) st.v9o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 352:
                        st.pc = 352;
                        st.pc = 354;
                        continue;
                    case 353:
                        st.pc = 353;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v8i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 354:
                        st.pc = 354;
                        st.tmpO = ((luaj.LuaValue) st.v5o).Z0((luaj.LuaValue) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 355:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 356:
                        st.pc = 356;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v4o;
                    case 357:
                        st.pc = 357;
                        st.pc = 245;
                        continue;
                    case 358:
                        st.pc = 358;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 359:
                        st.v5o = "Uexecutable opcode: EXTRAARG";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 360:
                        st.pc = 360;
                        st.v4o = new java.lang.IllegalArgumentException((java.lang.String) st.v5o);
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 361:
                        st.pc = 361;
                        throw (java.lang.Throwable) st.v4o;
                    case 362:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 363:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 364:
                        st.v4i = st.v14i >>> 23;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 365:
                        st.pc = 365;
                        if (st.v4i != 0) {
                            st.pc = 378;
                            continue;
                        }
                    case 366:
                        st.pc = 366;
                        st.v6o = ((luaj.LuaClosure) st.v1o).V;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 367:
                        st.pc = 367;
                        st.tmpI = ((luaj.Varargs) st.v6o).U();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 368:
                        st.v26i = st.tmpI;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 369:
                        st.v4i = st.v3i + st.v26i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 370:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 371:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 372:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 373:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 374:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 375:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 376:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 377:
                        st.pc = 377;
                        st.pc = 191;
                        continue;
                    case 378:
                        st.pc = 378;
                        st.v5o = ((luaj.LuaClosure) st.v1o).V;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 379:
                        st.v6i = 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 380:
                        st.pc = 380;
                        if (st.v6i >= st.v4i) {
                            st.pc = 389;
                            continue;
                        }
                    case 381:
                        st.v8i = st.v3i + st.v6i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 382:
                        st.v20i = 1;
                        st.v20j = 0L;
                        st.v20o = null;
                        st.v20d = 0.0;
                    case 383:
                        st.v8i = st.v8i + 0xffffffff;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 384:
                        st.pc = 384;
                        st.tmpO = ((luaj.Varargs) st.v5o).v(st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 385:
                        st.v22o = st.tmpO;
                        st.v22i = 0;
                        st.v22j = 0L;
                        st.v22d = 0.0;
                    case 386:
                        st.pc = 386;
                        ((java.lang.Object[]) st.v2o)[st.v8i] = st.v22o;
                    case 387:
                        st.v6i = st.v6i + 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 388:
                        st.pc = 388;
                        st.pc = 380;
                        continue;
                    case 389:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 390:
                        st.v26i = st.v4i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 391:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 392:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 393:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 394:
                        st.pc = 394;
                        st.pc = 187;
                        continue;
                    case 395:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 396:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 397:
                        st.v4i = st.v14i >>> 14;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 398:
                        st.pc = 398;
                        st.v4o = ((java.lang.Object[]) st.v12o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 399:
                        st.pc = 399;
                        st.v5o = null;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 400:
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 401:
                        st.pc = 401;
                        st.v5o = new luaj.LuaClosure((luaj.h) st.v4o, (luaj.LuaValue) st.v13o, (st.v6i != 0));
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 402:
                        st.pc = 402;
                        ((luaj.LuaClosure) st.v5o).U = (java.lang.String) st.v15o;
                    case 403:
                        st.pc = 403;
                        st.v4o = ((luaj.h) st.v4o).f1728f;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 404:
                        st.pc = 404;
                        st.v6i = java.lang.reflect.Array.getLength(st.v4o);
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 405:
                        st.pc = 405;
                        st.v8o = ((luaj.LuaClosure) st.v5o).S;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 406:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 407:
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 408:
                        st.pc = 408;
                        if (st.v12i >= st.v6i) {
                            st.pc = 426;
                            continue;
                        }
                    case 409:
                        st.v22i = st.v6i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 410:
                        st.pc = 410;
                        st.v6o = ((java.lang.Object[]) st.v4o)[st.v12i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 411:
                        st.v23o = st.v4o;
                        st.v23i = 0;
                        st.v23j = 0L;
                        st.v23d = 0.0;
                    case 412:
                        st.pc = 412;
                        st.v4i = (((gg_f.d) st.v6o).f1566b ? 1 : 0);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 413:
                        st.pc = 413;
                        if (st.v4i == 0) {
                            st.pc = 419;
                            continue;
                        }
                    case 414:
                        st.pc = 414;
                        st.v4i = ((gg_f.d) st.v6o).f1567c;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 415:
                        st.pc = 415;
                        st.tmpO = ((luaj.LuaClosure) st.v1o).Z2((luaj.LuaValue[]) st.v2o, (short) st.v4i, (luaj.i[]) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 416:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 417:
                        st.pc = 417;
                        ((java.lang.Object[]) st.v8o)[st.v12i] = st.v4o;
                    case 418:
                        st.pc = 418;
                        st.pc = 422;
                        continue;
                    case 419:
                        st.pc = 419;
                        st.v4i = ((gg_f.d) st.v6o).f1567c;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 420:
                        st.pc = 420;
                        st.v4o = ((java.lang.Object[]) st.v10o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 421:
                        st.pc = 421;
                        ((java.lang.Object[]) st.v8o)[st.v12i] = st.v4o;
                    case 422:
                        st.v12i = st.v12i + 1;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 423:
                        st.v6i = st.v22i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 424:
                        st.v4o = st.v23o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 425:
                        st.pc = 425;
                        st.pc = 408;
                        continue;
                    case 426:
                        st.pc = 426;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v5o;
                    case 427:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 428:
                        st.pc = 428;
                        st.pc = 326;
                        continue;
                    case 429:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 430:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 431:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 432:
                        st.v4i = st.v14i >> 14;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 433:
                        st.v4i = st.v4i & 511;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 434:
                        st.pc = 434;
                        if (st.v4i != 0) {
                            st.pc = 437;
                            continue;
                        }
                    case 435:
                        st.v11i = st.v11i + 1;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 436:
                        st.pc = 436;
                        st.v4i = ((int[]) st.v35o)[st.v11i];
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 437:
                        st.v27i = st.v4i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 438:
                        st.pc = 438;
                        st.pc = 447;
                        continue;
                    case 439:
                        st.pc = 439;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 440:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 441:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 442:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 443:
                        st.v6i = st.v26i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 444:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 445:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 446:
                        st.pc = 446;
                        st.pc = 173;
                        continue;
                    case 447:
                        st.v4i = st.v27i + 0xffffffff;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 448:
                        st.v4i = st.v4i * 50;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 449:
                        st.pc = 449;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 450:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 451:
                        st.pc = 451;
                        if (st.v6i != 0) {
                            st.pc = 501;
                            continue;
                        }
                    case 452:
                        st.v6i = st.v34i - st.v3i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 453:
                        st.v8i = 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 454:
                        st.v6i = st.v6i - st.v8i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 455:
                        st.pc = 455;
                        st.tmpI = ((luaj.Varargs) st.v31o).U();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 456:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 457:
                        st.v8i = st.v6i - st.v8i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 458:
                        st.v12i = 1;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 459:
                        st.pc = 459;
                        if (st.v12i > st.v8i) {
                            st.pc = 478;
                            continue;
                        }
                    case 460:
                        st.v22i = st.v11i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 461:
                        st.v11i = st.v4i + st.v12i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 462:
                        st.v23i = st.v3i + st.v12i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 463:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 464:
                        st.pc = 464;
                        st.v15o = ((java.lang.Object[]) st.v2o)[st.v23i];
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 465:
                        st.pc = 465;
                        ((luaj.LuaValue) st.v5o).e2(st.v11i, (luaj.LuaValue) st.v15o);
                    case 466:
                        st.v12i = st.v12i + 1;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 467:
                        st.v11i = st.v22i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 468:
                        st.v15o = st.v37o;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 469:
                        st.pc = 469;
                        st.pc = 459;
                        continue;
                    case 470:
                        st.pc = 470;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 471:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 472:
                        st.v3i = st.v22i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 473:
                        st.pc = 473;
                        st.pc = 106;
                        continue;
                    case 474:
                        st.pc = 474;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 475:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 476:
                        st.v4i = st.v22i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 477:
                        st.pc = 477;
                        st.pc = 202;
                        continue;
                    case 478:
                        st.v22i = st.v11i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 479:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 480:
                        st.pc = 480;
                        if (st.v12i > st.v6i) {
                            st.pc = 492;
                            continue;
                        }
                    case 481:
                        st.v11i = st.v4i + st.v12i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 482:
                        st.v15i = st.v12i - st.v8i;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 483:
                        st.v23i = st.v8i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 484:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 485:
                        st.pc = 485;
                        st.tmpO = ((luaj.Varargs) st.v8o).v(st.v15i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 486:
                        st.v15o = st.tmpO;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 487:
                        st.pc = 487;
                        ((luaj.LuaValue) st.v5o).e2(st.v11i, (luaj.LuaValue) st.v15o);
                    case 488:
                        st.v12i = st.v12i + 1;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 489:
                        st.v31o = st.v8o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 490:
                        st.v8i = st.v23i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 491:
                        st.pc = 491;
                        st.pc = 480;
                        continue;
                    case 492:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 493:
                        st.v26i = st.v6i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 494:
                        st.pc = 494;
                        st.pc = 514;
                        continue;
                    case 495:
                        st.pc = 495;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 496:
                        st.v22i = st.v11i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 497:
                        st.pc = 497;
                        st.pc = 471;
                        continue;
                    case 498:
                        st.pc = 498;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 499:
                        st.v22i = st.v11i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 500:
                        st.pc = 500;
                        st.pc = 475;
                        continue;
                    case 501:
                        st.v22i = st.v11i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 502:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 503:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 504:
                        st.v11i = st.v4i + st.v6i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 505:
                        st.pc = 505;
                        ((luaj.LuaValue) st.v5o).R1(st.v11i);
                    case 506:
                        st.v11i = 1;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 507:
                        st.pc = 507;
                        if (st.v11i > st.v6i) {
                            st.pc = 493;
                            continue;
                        }
                    case 508:
                        st.v12i = st.v4i + st.v11i;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 509:
                        st.v15i = st.v3i + st.v11i;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 510:
                        st.pc = 510;
                        st.v15o = ((java.lang.Object[]) st.v2o)[st.v15i];
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 511:
                        st.pc = 511;
                        ((luaj.LuaValue) st.v5o).e2(st.v12i, (luaj.LuaValue) st.v15o);
                    case 512:
                        st.v11i = st.v11i + 1;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 513:
                        st.pc = 513;
                        st.pc = 507;
                        continue;
                    case 514:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 515:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 516:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 517:
                        st.v11i = st.v22i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 518:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 519:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 520:
                        st.pc = 520;
                        st.pc = 190;
                        continue;
                    case 521:
                        st.pc = 521;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 522:
                        st.v22i = st.v11i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 523:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 524:
                        st.v4i = st.v22i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 525:
                        st.v6i = st.v26i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 526:
                        st.pc = 526;
                        st.pc = 202;
                        continue;
                    case 527:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 528:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 529:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 530:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 531:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 532:
                        st.v4i = st.v3i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 533:
                        st.pc = 533;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 534:
                        st.pc = 534;
                        st.tmpI = (((luaj.LuaValue) st.v5o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 535:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 536:
                        st.pc = 536;
                        if (st.v5i != 0) {
                            st.pc = 546;
                            continue;
                        }
                    case 537:
                        st.pc = 537;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 538:
                        st.pc = 538;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v4o;
                    case 539:
                        st.v4i = st.v14i >>> 14;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 540:
                        st.v4i = st.v4i - st.v32i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 541:
                        st.v11i = st.v11i + st.v4i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 542:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 543:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 544:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 545:
                        st.pc = 545;
                        st.pc = 518;
                        continue;
                    case 546:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 547:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 548:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 549:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 550:
                        st.pc = 550;
                        st.pc = 331;
                        continue;
                    case 551:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 552:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 553:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 554:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 555:
                        st.pc = 555;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 556:
                        st.pc = 556;
                        ((luaj.LuaClosure) st.v1o).e3((luaj.LuaValue) st.v4o);
                    case 557:
                        st.pc = 557;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 558:
                        st.v5i = st.v3i + 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 559:
                        st.pc = 559;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 560:
                        st.v6i = st.v3i + 2;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 561:
                        st.pc = 561;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 562:
                        st.pc = 562;
                        st.tmpO = luaj.LuaValue.N2((luaj.LuaValue) st.v5o, (luaj.Varargs) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 563:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 564:
                        st.pc = 564;
                        st.tmpO = ((luaj.LuaValue) st.v4o).invoke((luaj.Varargs) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 565:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 566:
                        st.pc = 566;
                        st.tmpO = ((luaj.LuaClosure) st.v1o).W2((luaj.Varargs) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 567:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 568:
                        st.v5i = st.v14i >> 14;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 569:
                        st.v5i = st.v5i & 511;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 570:
                        st.v27i = st.v5i + 0xffffffff;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 571:
                        st.pc = 571;
                        if (st.v27i < 0) {
                            st.pc = 579;
                            continue;
                        }
                    case 572:
                        st.v6i = st.v3i + 3;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 573:
                        st.v6i = st.v6i + st.v27i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 574:
                        st.pc = 574;
                        st.tmpO = ((luaj.Varargs) st.v4o).v(st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 575:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 576:
                        st.pc = 576;
                        ((java.lang.Object[]) st.v2o)[st.v6i] = st.v5o;
                    case 577:
                        st.v5i = st.v27i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 578:
                        st.pc = 578;
                        st.pc = 570;
                        continue;
                    case 579:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 580:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 581:
                        st.v6o = st.v25o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 582:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 583:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 584:
                        st.v5i = st.v34i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 585:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 586:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 587:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 588:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 589:
                        st.v9o = st.v6o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 590:
                        st.pc = 590;
                        st.pc = 2225;
                        continue;
                    case 591:
                        st.pc = 591;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 592:
                        st.v4o = st.v0o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 593:
                        st.pc = 593;
                        st.v5o = null;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 594:
                        st.pc = 594;
                        st.v6o = null;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 595:
                        st.pc = 595;
                        st.v6o = new java.lang.StringBuilder();
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 596:
                        st.v12o = st.v33o;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 597:
                        st.pc = 597;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v12o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 598:
                        st.pc = 598;
                        st.v8o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 599:
                        st.pc = 599;
                        st.tmpO = ((java.lang.Object) st.v8o).getClass();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 600:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 601:
                        st.pc = 601;
                        st.tmpO = ((java.lang.Class) st.v8o).getName();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 602:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 603:
                        st.pc = 603;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 604:
                        st.v15o = st.v22o;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 605:
                        st.pc = 605;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v15o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 606:
                        st.v8i = st.v3i + 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 607:
                        st.pc = 607;
                        st.v8o = ((java.lang.Object[]) st.v2o)[st.v8i];
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 608:
                        st.v9i = st.v3i + 2;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 609:
                        st.pc = 609;
                        st.v9o = ((java.lang.Object[]) st.v2o)[st.v9i];
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 610:
                        st.pc = 610;
                        st.tmpO = luaj.LuaValue.N2((luaj.LuaValue) st.v8o, (luaj.Varargs) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 611:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 612:
                        st.pc = 612;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append(st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 613:
                        st.v12o = st.v30o;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 614:
                        st.pc = 614;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v12o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 615:
                        st.pc = 615;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 616:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 617:
                        st.pc = 617;
                        st.v5o = new java.lang.NullPointerException((java.lang.String) st.v6o);
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 618:
                        st.pc = 618;
                        st.tmpO = ((java.lang.Throwable) st.v5o).initCause((java.lang.Throwable) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 619:
                        st.pc = 619;
                        throw (java.lang.Throwable) st.v5o;
                    case 620:
                        st.pc = 620;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 621:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 622:
                        st.v4o = st.v12o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 623:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 624:
                        st.pc = 624;
                        st.pc = 118;
                        continue;
                    case 625:
                        st.pc = 625;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 626:
                        st.v12o = st.v30o;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 627:
                        st.pc = 627;
                        st.pc = 621;
                        continue;
                    case 628:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 629:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 630:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 631:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 632:
                        st.v12o = st.v30o;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 633:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 634:
                        st.pc = 634;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 635:
                        st.v5o = "'for' initial value must be a number";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 636:
                        st.pc = 636;
                        st.tmpO = ((luaj.LuaValue) st.v4o).F0((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 637:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 638:
                        st.v5i = st.v3i + 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 639:
                        st.pc = 639;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v5i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 640:
                        st.v15o = "'for' limit must be a number";
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 641:
                        st.pc = 641;
                        st.tmpO = ((luaj.LuaValue) st.v6o).F0((java.lang.String) st.v15o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 642:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 643:
                        st.v15i = st.v3i + 2;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 644:
                        st.v30o = st.v12o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 645:
                        st.pc = 645;
                        st.v12o = ((java.lang.Object[]) st.v2o)[st.v15i];
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 646:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 647:
                        st.v10o = "'for' step must be a number";
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 648:
                        st.pc = 648;
                        st.tmpO = ((luaj.LuaValue) st.v12o).F0((java.lang.String) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 649:
                        st.v10o = st.tmpO;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 650:
                        st.pc = 650;
                        st.tmpO = ((luaj.LuaValue) st.v4o).r2((luaj.LuaValue) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 651:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 652:
                        st.pc = 652;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v4o;
                    case 653:
                        st.pc = 653;
                        ((java.lang.Object[]) st.v2o)[st.v5i] = st.v6o;
                    case 654:
                        st.pc = 654;
                        ((java.lang.Object[]) st.v2o)[st.v15i] = st.v10o;
                    case 655:
                        st.v4i = st.v14i >>> 14;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 656:
                        st.v4i = st.v4i - st.v32i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 657:
                        st.v11i = st.v11i + st.v4i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 658:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 659:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 660:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 661:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 662:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 663:
                        st.v5i = st.v34i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 664:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 665:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 666:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 667:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 668:
                        st.v7o = st.v31o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 669:
                        st.pc = 669;
                        st.pc = 2225;
                        continue;
                    case 670:
                        st.pc = 670;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 671:
                        st.v30o = st.v12o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 672:
                        st.pc = 672;
                        st.pc = 115;
                        continue;
                    case 673:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 674:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 675:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 676:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 677:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 678:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 679:
                        st.v4i = st.v3i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 680:
                        st.pc = 680;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 681:
                        st.v5i = st.v3i + 2;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 682:
                        st.pc = 682;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 683:
                        st.pc = 683;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 684:
                        st.pc = 684;
                        st.tmpO = ((luaj.LuaValue) st.v6o).j0((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 685:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 686:
                        st.v10o = st.v29o;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 687:
                        st.pc = 687;
                        st.tmpI = (((luaj.LuaValue) st.v5o).X0((luaj.LuaValue) st.v10o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 688:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 689:
                        st.pc = 689;
                        if (st.v5i == 0) {
                            st.pc = 694;
                            continue;
                        }
                    case 690:
                        st.pc = 690;
                        st.tmpI = (((luaj.LuaValue) st.v6o).v1((luaj.LuaValue) st.v4o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 691:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 692:
                        st.pc = 692;
                        if (st.v4i == 0) {
                            st.pc = 703;
                            continue;
                        }
                    case 693:
                        st.pc = 693;
                        st.pc = 697;
                        continue;
                    case 694:
                        st.pc = 694;
                        st.tmpI = (((luaj.LuaValue) st.v6o).Y0((luaj.LuaValue) st.v4o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 695:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 696:
                        st.pc = 696;
                        if (st.v4i == 0) {
                            st.pc = 703;
                            continue;
                        }
                    case 697:
                        st.pc = 697;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v6o;
                    case 698:
                        st.v4i = st.v3i + 3;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 699:
                        st.pc = 699;
                        ((java.lang.Object[]) st.v2o)[st.v4i] = st.v6o;
                    case 700:
                        st.v4i = st.v14i >>> 14;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 701:
                        st.v4i = st.v4i - st.v32i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 702:
                        st.v11i = st.v11i + st.v4i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 703:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 704:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 705:
                        st.v29o = st.v10o;
                        st.v29i = 0;
                        st.v29j = 0L;
                        st.v29d = 0.0;
                    case 706:
                        st.pc = 706;
                        st.pc = 660;
                        continue;
                    case 707:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 708:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 709:
                        st.v4i = st.v14i >>> 23;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 710:
                        st.pc = 710;
                        if (st.v4i == 0) {
                            st.pc = 768;
                            continue;
                        }
                    case 711:
                        st.v5i = 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 712:
                        st.pc = 712;
                        if (st.v4i == st.v5i) {
                            st.pc = 749;
                            continue;
                        }
                    case 713:
                        st.pc = 713;
                        if (st.v4i == st.v6i) {
                            st.pc = 736;
                            continue;
                        }
                    case 714:
                        st.v5i = st.v4i + 0xffffffff;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 715:
                        st.pc = 715;
                        st.tmpO = luaj.LuaValue.P2((luaj.LuaValue[]) st.v2o, st.v3i, st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 716:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 717:
                        st.pc = 717;
                        if (st.v7i == 0) {
                            st.pc = 726;
                            continue;
                        }
                    case 718:
                        st.v11i = st.v24i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 719:
                        st.v3i = 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 720:
                        st.v11i = st.v11i + st.v3i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 721:
                        st.pc = 721;
                        if (st.v11i < 0) {
                            st.pc = 726;
                            continue;
                        }
                    case 722:
                        st.pc = 722;
                        st.v3o = ((java.lang.Object[]) st.v7o)[st.v11i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 723:
                        st.pc = 723;
                        if (st.v3o == null) {
                            st.pc = 719;
                            continue;
                        }
                    case 724:
                        st.pc = 724;
                        ((luaj.i) st.v3o).a();
                    case 725:
                        st.pc = 725;
                        st.pc = 719;
                        continue;
                    case 726:
                        st.pc = 726;
                        if (st.v28i == 0) {
                            st.pc = 729;
                            continue;
                        }
                    case 727:
                        st.pc = 727;
                        if (st.v42i != 0) {
                            st.pc = 729;
                            continue;
                        }
                    case 728:
                        st.pc = 728;
                        ((luaj.lib.DebugLib) st.v28o).l3();
                    case 729:
                        st.pc = 729;
                        st.v3o = luaj.LuaValue.f1676f;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 730:
                        st.pc = 730;
                        ((luaj.LuaClosure) st.v1o).V = (luaj.Varargs) st.v3o;
                    case 731:
                        st.pc = 731;
                        st.v3i = luaj.LuaClosure.Y;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 732:
                        st.v4i = 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 733:
                        st.v3i = st.v3i - st.v4i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 734:
                        st.pc = 734;
                        luaj.LuaClosure.Y = st.v3i;
                    case 735:
                        st.pc = 735;
                        st.resultO = st.v2o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 736:
                        st.pc = 736;
                        st.v2o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 737:
                        st.pc = 737;
                        if (st.v7i == 0) {
                            st.pc = 746;
                            continue;
                        }
                    case 738:
                        st.v11i = st.v24i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 739:
                        st.v3i = 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 740:
                        st.v11i = st.v11i + st.v3i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 741:
                        st.pc = 741;
                        if (st.v11i < 0) {
                            st.pc = 746;
                            continue;
                        }
                    case 742:
                        st.pc = 742;
                        st.v3o = ((java.lang.Object[]) st.v7o)[st.v11i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 743:
                        st.pc = 743;
                        if (st.v3o == null) {
                            st.pc = 739;
                            continue;
                        }
                    case 744:
                        st.pc = 744;
                        ((luaj.i) st.v3o).a();
                    case 745:
                        st.pc = 745;
                        st.pc = 739;
                        continue;
                    case 746:
                        st.pc = 746;
                        if (st.v28i == 0) {
                            st.pc = 729;
                            continue;
                        }
                    case 747:
                        st.pc = 747;
                        if (st.v42i != 0) {
                            st.pc = 729;
                            continue;
                        }
                    case 748:
                        st.pc = 748;
                        st.pc = 728;
                        continue;
                    case 749:
                        st.pc = 749;
                        if (st.v7i == 0) {
                            st.pc = 758;
                            continue;
                        }
                    case 750:
                        st.v11i = st.v24i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 751:
                        st.v2i = 0xffffffff;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 752:
                        st.v11i = st.v11i + st.v2i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 753:
                        st.pc = 753;
                        if (st.v11i < 0) {
                            st.pc = 758;
                            continue;
                        }
                    case 754:
                        st.pc = 754;
                        st.v2o = ((java.lang.Object[]) st.v7o)[st.v11i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 755:
                        st.pc = 755;
                        if (st.v2o == null) {
                            st.pc = 751;
                            continue;
                        }
                    case 756:
                        st.pc = 756;
                        ((luaj.i) st.v2o).a();
                    case 757:
                        st.pc = 757;
                        st.pc = 751;
                        continue;
                    case 758:
                        st.pc = 758;
                        if (st.v28i == 0) {
                            st.pc = 761;
                            continue;
                        }
                    case 759:
                        st.pc = 759;
                        if (st.v42i != 0) {
                            st.pc = 761;
                            continue;
                        }
                    case 760:
                        st.pc = 760;
                        ((luaj.lib.DebugLib) st.v28o).l3();
                    case 761:
                        st.pc = 761;
                        st.v2o = luaj.LuaValue.f1676f;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 762:
                        st.pc = 762;
                        ((luaj.LuaClosure) st.v1o).V = (luaj.Varargs) st.v2o;
                    case 763:
                        st.pc = 763;
                        st.v2i = luaj.LuaClosure.Y;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 764:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 765:
                        st.v2i = st.v2i - st.v3i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 766:
                        st.pc = 766;
                        luaj.LuaClosure.Y = st.v2i;
                    case 767:
                        st.pc = 767;
                        st.resultO = st.v25o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 768:
                        st.v5i = st.v34i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 769:
                        st.pc = 769;
                        st.tmpI = ((luaj.Varargs) st.v8o).U();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 770:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 771:
                        st.v5i = st.v5i - st.v6i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 772:
                        st.v5i = st.v5i - st.v3i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 773:
                        st.pc = 773;
                        st.tmpO = luaj.LuaValue.Q2((luaj.LuaValue[]) st.v2o, st.v3i, st.v5i, (luaj.Varargs) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 774:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 775:
                        st.pc = 775;
                        if (st.v7i == 0) {
                            st.pc = 784;
                            continue;
                        }
                    case 776:
                        st.v11i = st.v24i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 777:
                        st.v3i = 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 778:
                        st.v11i = st.v11i + st.v3i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 779:
                        st.pc = 779;
                        if (st.v11i < 0) {
                            st.pc = 784;
                            continue;
                        }
                    case 780:
                        st.pc = 780;
                        st.v3o = ((java.lang.Object[]) st.v7o)[st.v11i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 781:
                        st.pc = 781;
                        if (st.v3o == null) {
                            st.pc = 777;
                            continue;
                        }
                    case 782:
                        st.pc = 782;
                        ((luaj.i) st.v3o).a();
                    case 783:
                        st.pc = 783;
                        st.pc = 777;
                        continue;
                    case 784:
                        st.pc = 784;
                        if (st.v28i == 0) {
                            st.pc = 729;
                            continue;
                        }
                    case 785:
                        st.pc = 785;
                        if (st.v42i != 0) {
                            st.pc = 729;
                            continue;
                        }
                    case 786:
                        st.pc = 786;
                        st.pc = 728;
                        continue;
                    case 787:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 788:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 789:
                        st.pc = 789;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 790:
                        st.pc = 790;
                        ((luaj.LuaClosure) st.v1o).e3((luaj.LuaValue) st.v4o);
                    case 791:
                        st.v4i = 0xff800000;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 792:
                        st.v4i = st.v4i & st.v14i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 793:
                        st.v6i = 8388608;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 794:
                        st.pc = 794;
                        if (st.v4i == st.v6i) {
                            st.pc = 838;
                            continue;
                        }
                    case 795:
                        st.v6i = 16777216;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 796:
                        st.pc = 796;
                        if (st.v4i == st.v6i) {
                            st.pc = 835;
                            continue;
                        }
                    case 797:
                        st.v6i = 25165824;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 798:
                        st.pc = 798;
                        if (st.v4i == st.v6i) {
                            st.pc = 828;
                            continue;
                        }
                    case 799:
                        st.v6i = 33554432;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 800:
                        st.pc = 800;
                        if (st.v4i == st.v6i) {
                            st.pc = 819;
                            continue;
                        }
                    case 801:
                        st.v4i = st.v14i >>> 23;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 802:
                        st.pc = 802;
                        if (st.v4i <= 0) {
                            st.pc = 809;
                            continue;
                        }
                    case 803:
                        st.v5i = st.v3i + 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 804:
                        st.v6i = st.v4i + 0xffffffff;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 805:
                        st.pc = 805;
                        st.tmpO = luaj.LuaValue.P2((luaj.LuaValue[]) st.v2o, st.v5i, st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 806:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 807:
                        st.v6o = st.v5o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 808:
                        st.pc = 808;
                        st.pc = 817;
                        continue;
                    case 809:
                        st.v6i = st.v3i + 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 810:
                        st.pc = 810;
                        st.tmpI = ((luaj.Varargs) st.v8o).U();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 811:
                        st.v9i = st.tmpI;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 812:
                        st.v5i = st.v5i - st.v9i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 813:
                        st.v5i = st.v5i - st.v6i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 814:
                        st.pc = 814;
                        st.tmpO = luaj.LuaValue.Q2((luaj.LuaValue[]) st.v2o, st.v6i, st.v5i, (luaj.Varargs) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 815:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 816:
                        st.pc = 816;
                        st.pc = 807;
                        continue;
                    case 817:
                        st.v26i = st.v4i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 818:
                        st.pc = 818;
                        st.pc = 839;
                        continue;
                    case 819:
                        st.v4i = st.v3i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 820:
                        st.pc = 820;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 821:
                        st.v5i = st.v3i + 2;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 822:
                        st.pc = 822;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 823:
                        st.v6i = st.v3i + 3;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 824:
                        st.pc = 824;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 825:
                        st.pc = 825;
                        st.tmpO = luaj.LuaValue.M2((luaj.LuaValue) st.v4o, (luaj.LuaValue) st.v5o, (luaj.Varargs) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 826:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 827:
                        st.pc = 827;
                        st.pc = 839;
                        continue;
                    case 828:
                        st.v4i = st.v3i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 829:
                        st.pc = 829;
                        st.v4o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 830:
                        st.v5i = st.v3i + 2;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 831:
                        st.pc = 831;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 832:
                        st.pc = 832;
                        st.tmpO = luaj.LuaValue.N2((luaj.LuaValue) st.v4o, (luaj.Varargs) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 833:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 834:
                        st.pc = 834;
                        st.pc = 839;
                        continue;
                    case 835:
                        st.v4i = st.v3i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 836:
                        st.pc = 836;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 837:
                        st.pc = 837;
                        st.pc = 839;
                        continue;
                    case 838:
                        st.v6o = st.v25o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 839:
                        st.pc = 839;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 840:
                        st.pc = 840;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 841:
                        st.pc = 841;
                        st.v4o = new gg_f.c((luaj.Globals) st.v13o, (luaj.LuaValue) st.v5o, (luaj.Varargs) st.v6o);
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 842:
                        st.pc = 842;
                        if (st.v42i != 0) {
                            st.pc = 845;
                            continue;
                        }
                    case 843:
                        st.pc = 843;
                        st.tmpO = ((luaj.Varargs) st.v4o).N();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 844:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 845:
                        st.pc = 845;
                        if (st.v7i == 0) {
                            st.pc = 854;
                            continue;
                        }
                    case 846:
                        st.v11i = st.v24i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 847:
                        st.v2i = 0xffffffff;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 848:
                        st.v11i = st.v11i + st.v2i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 849:
                        st.pc = 849;
                        if (st.v11i < 0) {
                            st.pc = 854;
                            continue;
                        }
                    case 850:
                        st.pc = 850;
                        st.v2o = ((java.lang.Object[]) st.v7o)[st.v11i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 851:
                        st.pc = 851;
                        if (st.v2o == null) {
                            st.pc = 847;
                            continue;
                        }
                    case 852:
                        st.pc = 852;
                        ((luaj.i) st.v2o).a();
                    case 853:
                        st.pc = 853;
                        st.pc = 847;
                        continue;
                    case 854:
                        st.pc = 854;
                        if (st.v28i == 0) {
                            st.pc = 857;
                            continue;
                        }
                    case 855:
                        st.pc = 855;
                        if (st.v42i != 0) {
                            st.pc = 857;
                            continue;
                        }
                    case 856:
                        st.pc = 856;
                        ((luaj.lib.DebugLib) st.v28o).l3();
                    case 857:
                        st.pc = 857;
                        st.v2o = luaj.LuaValue.f1676f;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 858:
                        st.pc = 858;
                        ((luaj.LuaClosure) st.v1o).V = (luaj.Varargs) st.v2o;
                    case 859:
                        st.pc = 859;
                        st.v2i = luaj.LuaClosure.Y;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 860:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 861:
                        st.v2i = st.v2i - st.v3i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 862:
                        st.pc = 862;
                        luaj.LuaClosure.Y = st.v2i;
                    case 863:
                        st.pc = 863;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 864:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 865:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 866:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 867:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 868:
                        st.v15o = st.v22o;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 869:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 870:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 871:
                        st.v12o = st.v33o;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 872:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 873:
                        st.v10o = st.v29o;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 874:
                        st.pc = 874;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 875:
                        st.pc = 875;
                        ((luaj.LuaClosure) st.v1o).e3((luaj.LuaValue) st.v6o);
                    case 876:
                        st.pc = 876;
                        if (st.v28i == 0) {
                            st.pc = 894;
                            continue;
                        }
                    case 877:
                        st.pc = 877;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 878:
                        st.pc = 878;
                        st.tmpI = (((luaj.LuaValue) st.v6o).f1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 879:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 880:
                        st.pc = 880;
                        if (st.v6i != 0) {
                            st.pc = 894;
                            continue;
                        }
                    case 881:
                        st.v6i = 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 882:
                        st.pc = 882;
                        st.pc = 895;
                        continue;
                    case 883:
                        st.pc = 883;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 884:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 885:
                        st.pc = 885;
                        st.pc = 623;
                        continue;
                    case 886:
                        st.pc = 886;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 887:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 888:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 889:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 890:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 891:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 892:
                        st.v7o = st.v0o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 893:
                        st.pc = 893;
                        st.pc = 1184;
                        continue;
                    case 894:
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 895:
                        st.pc = 895;
                        if (st.v6i == 0) {
                            st.pc = 955;
                            continue;
                        }
                    case 896:
                        st.pc = 896;
                        st.v22o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v22i = 0;
                        st.v22j = 0L;
                        st.v22d = 0.0;
                    case 897:
                        st.pc = 897;
                        st.tmpI = (((luaj.LuaValue) st.v22o).g1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 898:
                        st.v22i = st.tmpI;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 899:
                        st.pc = 899;
                        if (st.v22i == 0) {
                            st.pc = 949;
                            continue;
                        }
                    case 900:
                        st.pc = 900;
                        st.v22o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v22i = 0;
                        st.v22j = 0L;
                        st.v22d = 0.0;
                    case 901:
                        st.v23i = st.v6i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 902:
                        st.pc = 902;
                        st.tmpO = ((luaj.LuaValue) st.v22o).y0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 903:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 904:
                        st.v29o = st.v10o;
                        st.v29i = 0;
                        st.v29j = 0L;
                        st.v29d = 0.0;
                    case 905:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 906:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 907:
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 908:
                        st.pc = 908;
                        ((luaj.lib.DebugLib) st.v13o).j3((luaj.LuaFunction) st.v6o, (st.v10i != 0));
                    case 909:
                        st.pc = 909;
                        st.pc = 960;
                        continue;
                    case 910:
                        st.pc = 910;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 911:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 912:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 913:
                        st.v3i = st.v11i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 914:
                        st.pc = 914;
                        st.pc = 2308;
                        continue;
                    case 915:
                        st.pc = 915;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 916:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 917:
                        st.pc = 917;
                        st.pc = 112;
                        continue;
                    case 918:
                        st.pc = 918;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 919:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 920:
                        st.pc = 920;
                        st.pc = 118;
                        continue;
                    case 921:
                        st.pc = 921;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 922:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 923:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 924:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 925:
                        st.v4i = st.v11i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 926:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 927:
                        st.pc = 927;
                        st.pc = 76;
                        continue;
                    case 928:
                        st.pc = 928;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 929:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 930:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 931:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 932:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 933:
                        st.pc = 933;
                        st.pc = 892;
                        continue;
                    case 934:
                        st.pc = 934;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 935:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 936:
                        st.pc = 936;
                        st.pc = 911;
                        continue;
                    case 937:
                        st.pc = 937;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 938:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 939:
                        st.pc = 939;
                        st.pc = 916;
                        continue;
                    case 940:
                        st.pc = 940;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 941:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 942:
                        st.pc = 942;
                        st.pc = 919;
                        continue;
                    case 943:
                        st.pc = 943;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 944:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 945:
                        st.pc = 945;
                        st.pc = 922;
                        continue;
                    case 946:
                        st.pc = 946;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 947:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 948:
                        st.pc = 948;
                        st.pc = 929;
                        continue;
                    case 949:
                        st.v29o = st.v10o;
                        st.v29i = 0;
                        st.v29j = 0L;
                        st.v29d = 0.0;
                    case 950:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 951:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 952:
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 953:
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 954:
                        st.pc = 954;
                        st.pc = 961;
                        continue;
                    case 955:
                        st.v23i = st.v6i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 956:
                        st.v29o = st.v10o;
                        st.v29i = 0;
                        st.v29j = 0L;
                        st.v29d = 0.0;
                    case 957:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 958:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 959:
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 960:
                        st.v6i = st.v23i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 961:
                        st.v10i = st.v14i & 0xffffc000;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 962:
                        switch (st.v10i) {
                            case 8388608: st.pc = 1127; continue;
                            case 8404992: st.pc = 1120; continue;
                            case 8421376: st.pc = 1110; continue;
                            case 16777216: st.pc = 1093; continue;
                            case 16793600: st.pc = 1085; continue;
                            case 16809984: st.pc = 1073; continue;
                            case 25182208: st.pc = 1063; continue;
                            case 25198592: st.pc = 1049; continue;
                            case 33570816: st.pc = 1037; continue;
                            case 33587200: st.pc = 1018; continue;
                            default: st.pc = 963; continue;
                        }
                    case 963:
                        st.v26i = st.v14i >>> 23;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 964:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 965:
                        st.v10i = st.v10i & 511;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 966:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 967:
                        st.pc = 967;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 968:
                        st.pc = 968;
                        if (st.v26i <= 0) {
                            st.pc = 981;
                            continue;
                        }
                    case 969:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 970:
                        st.v9i = st.v3i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 971:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 972:
                        st.v11i = st.v26i + 0xffffffff;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 973:
                        st.pc = 973;
                        st.tmpO = luaj.LuaValue.P2((luaj.LuaValue[]) st.v2o, st.v9i, st.v11i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 974:
                        st.v9o = st.tmpO;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 975:
                        st.pc = 975;
                        st.pc = 990;
                        continue;
                    case 976:
                        st.pc = 976;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 977:
                        st.v7o = st.v0o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 978:
                        st.v27i = st.v10i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 979:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 980:
                        st.pc = 980;
                        st.pc = 1176;
                        continue;
                    case 981:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 982:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 983:
                        st.v9i = st.v3i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 984:
                        st.pc = 984;
                        st.tmpI = ((luaj.Varargs) st.v8o).U();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 985:
                        st.v11i = st.tmpI;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 986:
                        st.v11i = st.v5i - st.v11i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 987:
                        st.v11i = st.v11i - st.v9i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 988:
                        st.pc = 988;
                        st.tmpO = luaj.LuaValue.Q2((luaj.LuaValue[]) st.v2o, st.v9i, st.v11i, (luaj.Varargs) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 989:
                        st.v9o = st.tmpO;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 990:
                        st.pc = 990;
                        st.tmpO = ((luaj.LuaValue) st.v7o).invoke((luaj.Varargs) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 991:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 992:
                        st.pc = 992;
                        st.tmpO = ((luaj.LuaClosure) st.v1o).W2((luaj.Varargs) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 993:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 994:
                        st.pc = 994;
                        if (st.v10i <= 0) {
                            st.pc = 1007;
                            continue;
                        }
                    case 995:
                        st.v8i = st.v10i + 0xffffffff;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 996:
                        st.pc = 996;
                        ((luaj.Varargs) st.v7o).L((luaj.LuaValue[]) st.v2o, st.v3i, st.v8i);
                    case 997:
                        st.v27i = st.v10i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 998:
                        st.v7o = st.v25o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 999:
                        st.v9o = st.v7o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1000:
                        st.pc = 1000;
                        st.pc = 1139;
                        continue;
                    case 1001:
                        st.pc = 1001;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1002:
                        st.v8o = st.v7o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1003:
                        st.v27i = st.v10i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 1004:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1005:
                        st.v7o = st.v0o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1006:
                        st.pc = 1006;
                        st.pc = 1176;
                        continue;
                    case 1007:
                        st.pc = 1007;
                        st.tmpI = ((luaj.Varargs) st.v7o).U();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1008:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1009:
                        st.v5i = st.v5i + st.v3i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1010:
                        st.pc = 1010;
                        st.tmpO = ((luaj.Varargs) st.v7o).M();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1011:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1012:
                        st.v27i = st.v10i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 1013:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1014:
                        st.pc = 1014;
                        st.pc = 1139;
                        continue;
                    case 1015:
                        st.pc = 1015;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1016:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1017:
                        st.pc = 1017;
                        st.pc = 977;
                        continue;
                    case 1018:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1019:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1020:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1021:
                        st.pc = 1021;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1022:
                        st.v9i = st.v3i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 1023:
                        st.pc = 1023;
                        st.v9o = ((java.lang.Object[]) st.v2o)[st.v9i];
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1024:
                        st.v10i = st.v3i + 2;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1025:
                        st.pc = 1025;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1026:
                        st.v11i = st.v3i + 3;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1027:
                        st.pc = 1027;
                        st.v11o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 1028:
                        st.pc = 1028;
                        st.tmpO = ((luaj.LuaValue) st.v7o).call((luaj.LuaValue) st.v9o, (luaj.LuaValue) st.v10o, (luaj.LuaValue) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1029:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1030:
                        st.pc = 1030;
                        st.tmpO = ((luaj.LuaClosure) st.v1o).V2((luaj.LuaValue) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1031:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1032:
                        st.pc = 1032;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v7o;
                    case 1033:
                        st.pc = 1033;
                        st.pc = 1125;
                        continue;
                    case 1034:
                        st.pc = 1034;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1035:
                        st.v7o = st.v0o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1036:
                        st.pc = 1036;
                        st.pc = 979;
                        continue;
                    case 1037:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1038:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1039:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1040:
                        st.pc = 1040;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1041:
                        st.v9i = st.v3i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 1042:
                        st.pc = 1042;
                        st.v9o = ((java.lang.Object[]) st.v2o)[st.v9i];
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1043:
                        st.v10i = st.v3i + 2;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1044:
                        st.pc = 1044;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1045:
                        st.v11i = st.v3i + 3;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1046:
                        st.pc = 1046;
                        st.v11o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 1047:
                        st.pc = 1047;
                        st.tmpO = ((luaj.LuaValue) st.v7o).call((luaj.LuaValue) st.v9o, (luaj.LuaValue) st.v10o, (luaj.LuaValue) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1048:
                        st.pc = 1048;
                        st.pc = 1125;
                        continue;
                    case 1049:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1050:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1051:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1052:
                        st.pc = 1052;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1053:
                        st.v9i = st.v3i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 1054:
                        st.pc = 1054;
                        st.v9o = ((java.lang.Object[]) st.v2o)[st.v9i];
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1055:
                        st.v10i = st.v3i + 2;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1056:
                        st.pc = 1056;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1057:
                        st.pc = 1057;
                        st.tmpO = ((luaj.LuaValue) st.v7o).call((luaj.LuaValue) st.v9o, (luaj.LuaValue) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1058:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1059:
                        st.pc = 1059;
                        st.tmpO = ((luaj.LuaClosure) st.v1o).V2((luaj.LuaValue) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1060:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1061:
                        st.pc = 1061;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v7o;
                    case 1062:
                        st.pc = 1062;
                        st.pc = 1125;
                        continue;
                    case 1063:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1064:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1065:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1066:
                        st.pc = 1066;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1067:
                        st.v9i = st.v3i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 1068:
                        st.pc = 1068;
                        st.v9o = ((java.lang.Object[]) st.v2o)[st.v9i];
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1069:
                        st.v10i = st.v3i + 2;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1070:
                        st.pc = 1070;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1071:
                        st.pc = 1071;
                        st.tmpO = ((luaj.LuaValue) st.v7o).call((luaj.LuaValue) st.v9o, (luaj.LuaValue) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1072:
                        st.pc = 1072;
                        st.pc = 1125;
                        continue;
                    case 1073:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1074:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1075:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1076:
                        st.pc = 1076;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1077:
                        st.v9i = st.v3i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 1078:
                        st.pc = 1078;
                        st.v9o = ((java.lang.Object[]) st.v2o)[st.v9i];
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1079:
                        st.pc = 1079;
                        st.tmpO = ((luaj.LuaValue) st.v7o).call((luaj.LuaValue) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1080:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1081:
                        st.pc = 1081;
                        st.tmpO = ((luaj.LuaClosure) st.v1o).V2((luaj.LuaValue) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1082:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1083:
                        st.pc = 1083;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v7o;
                    case 1084:
                        st.pc = 1084;
                        st.pc = 1125;
                        continue;
                    case 1085:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1086:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1087:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1088:
                        st.pc = 1088;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1089:
                        st.v9i = st.v3i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 1090:
                        st.pc = 1090;
                        st.v9o = ((java.lang.Object[]) st.v2o)[st.v9i];
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1091:
                        st.pc = 1091;
                        st.tmpO = ((luaj.LuaValue) st.v7o).call((luaj.LuaValue) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1092:
                        st.pc = 1092;
                        st.pc = 1125;
                        continue;
                    case 1093:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1094:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1095:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1096:
                        st.pc = 1096;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1097:
                        st.v9i = st.v3i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 1098:
                        st.pc = 1098;
                        st.v9o = ((java.lang.Object[]) st.v2o)[st.v9i];
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1099:
                        st.pc = 1099;
                        st.tmpO = ((luaj.LuaValue) st.v7o).invoke((luaj.Varargs) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1100:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1101:
                        st.pc = 1101;
                        st.tmpO = ((luaj.LuaClosure) st.v1o).W2((luaj.Varargs) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1102:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1103:
                        st.pc = 1103;
                        st.tmpI = ((luaj.Varargs) st.v7o).U();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1104:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1105:
                        st.v5i = st.v5i + st.v3i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1106:
                        st.pc = 1106;
                        st.pc = 1013;
                        continue;
                    case 1107:
                        st.pc = 1107;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1108:
                        st.v8o = st.v7o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1109:
                        st.pc = 1109;
                        st.pc = 1004;
                        continue;
                    case 1110:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1111:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1112:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1113:
                        st.pc = 1113;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1114:
                        st.pc = 1114;
                        st.tmpO = ((luaj.LuaValue) st.v7o).call();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1115:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1116:
                        st.pc = 1116;
                        st.tmpO = ((luaj.LuaClosure) st.v1o).V2((luaj.LuaValue) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1117:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1118:
                        st.pc = 1118;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v7o;
                    case 1119:
                        st.pc = 1119;
                        st.pc = 1125;
                        continue;
                    case 1120:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1121:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1122:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1123:
                        st.pc = 1123;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1124:
                        st.pc = 1124;
                        st.tmpO = ((luaj.LuaValue) st.v7o).call();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1125:
                        st.v7o = st.v8o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1126:
                        st.pc = 1126;
                        st.pc = 1013;
                        continue;
                    case 1127:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1128:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1129:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1130:
                        st.pc = 1130;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1131:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1132:
                        st.pc = 1132;
                        st.tmpO = ((luaj.LuaValue) st.v7o).invoke((luaj.Varargs) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1133:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1134:
                        st.pc = 1134;
                        st.tmpO = ((luaj.LuaClosure) st.v1o).W2((luaj.Varargs) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1135:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1136:
                        st.pc = 1136;
                        st.tmpI = ((luaj.Varargs) st.v7o).U();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1137:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1138:
                        st.v5i = st.v5i + st.v3i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1139:
                        st.pc = 1139;
                        if (st.v6i == 0) {
                            st.pc = 1163;
                            continue;
                        }
                    case 1140:
                        st.pc = 1140;
                        ((luaj.lib.DebugLib) st.v13o).l3();
                    case 1141:
                        st.pc = 1141;
                        st.pc = 1163;
                        continue;
                    case 1142:
                        st.pc = 1142;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1143:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 1144:
                        st.v3i = st.v33i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1145:
                        st.pc = 1145;
                        st.pc = 2308;
                        continue;
                    case 1146:
                        st.pc = 1146;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1147:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 1148:
                        st.pc = 1148;
                        st.pc = 2318;
                        continue;
                    case 1149:
                        st.pc = 1149;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1150:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 1151:
                        st.pc = 1151;
                        st.pc = 2323;
                        continue;
                    case 1152:
                        st.pc = 1152;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1153:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1154:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 1155:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1156:
                        st.v6i = st.v26i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1157:
                        st.v11i = st.v27i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1158:
                        st.v4i = st.v33i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 1159:
                        st.pc = 1159;
                        st.pc = 2339;
                        continue;
                    case 1160:
                        st.pc = 1160;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1161:
                        st.v6o = st.v7o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1162:
                        st.pc = 1162;
                        st.pc = 892;
                        continue;
                    case 1163:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 1164:
                        st.v6o = st.v7o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1165:
                        st.v7o = st.v31o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1166:
                        st.v11i = st.v33i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1167:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1168:
                        st.pc = 1168;
                        st.pc = 2225;
                        continue;
                    case 1169:
                        st.pc = 1169;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1170:
                        st.v8o = st.v7o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1171:
                        st.pc = 1171;
                        st.pc = 1005;
                        continue;
                    case 1172:
                        st.pc = 1172;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1173:
                        st.pc = 1173;
                        st.pc = 1005;
                        continue;
                    case 1174:
                        st.pc = 1174;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1175:
                        st.pc = 1175;
                        st.pc = 1004;
                        continue;
                    case 1176:
                        st.pc = 1176;
                        if (st.v6i == 0) {
                            st.pc = 1183;
                            continue;
                        }
                    case 1177:
                        st.pc = 1177;
                        ((luaj.lib.DebugLib) st.v13o).l3();
                    case 1178:
                        st.pc = 1178;
                        st.pc = 1183;
                        continue;
                    case 1179:
                        st.pc = 1179;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1180:
                        st.v7o = st.v0o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1181:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1182:
                        st.pc = 1182;
                        st.pc = 1184;
                        continue;
                    case 1183:
                        st.pc = 1183;
                        throw (java.lang.Throwable) st.v7o;
                    case 1184:
                        st.v8o = "";
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1185:
                        st.v10i = st.v14i & 0xffffc000;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1186:
                        st.v11o = ", ";
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 1187:
                        switch (st.v10i) {
                            case 8388608: st.pc = 1235; continue;
                            case 8404992: st.pc = 1237; continue;
                            case 8421376: st.pc = 1237; continue;
                            case 16777216: st.pc = 1230; continue;
                            case 16793600: st.pc = 1230; continue;
                            case 16809984: st.pc = 1230; continue;
                            case 25182208: st.pc = 1220; continue;
                            case 25198592: st.pc = 1220; continue;
                            case 33570816: st.pc = 1204; continue;
                            case 33587200: st.pc = 1204; continue;
                            default: st.pc = 1188; continue;
                        }
                    case 1188:
                        st.pc = 1188;
                        if (st.v26i <= 0) {
                            st.pc = 1194;
                            continue;
                        }
                    case 1189:
                        st.v5i = st.v3i + 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1190:
                        st.v6i = st.v26i + 0xffffffff;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1191:
                        st.pc = 1191;
                        st.tmpO = luaj.LuaValue.P2((luaj.LuaValue[]) st.v2o, st.v5i, st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1192:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1193:
                        st.pc = 1193;
                        st.pc = 1201;
                        continue;
                    case 1194:
                        st.v8i = st.v3i + 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 1195:
                        st.pc = 1195;
                        st.tmpI = ((luaj.Varargs) st.v6o).U();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1196:
                        st.v9i = st.tmpI;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 1197:
                        st.v5i = st.v5i - st.v9i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1198:
                        st.v5i = st.v5i - st.v8i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1199:
                        st.pc = 1199;
                        st.tmpO = luaj.LuaValue.Q2((luaj.LuaValue[]) st.v2o, st.v8i, st.v5i, (luaj.Varargs) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.pc = 1200;
                        return false;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = lcY2_handler(st.pc, t);
            if (h < 0) {
                lcY2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static boolean lcY2_c1(lcY2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 1200:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1201:
                        st.pc = 1201;
                        st.tmpO = ((luaj.Varargs) st.v5o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1202:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1203:
                        st.pc = 1203;
                        st.pc = 1237;
                        continue;
                    case 1204:
                        st.pc = 1204;
                        st.v5o = null;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1205:
                        st.pc = 1205;
                        st.v5o = new java.lang.StringBuilder();
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1206:
                        st.v6i = st.v3i + 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1207:
                        st.pc = 1207;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1208:
                        st.pc = 1208;
                        st.tmpO = ((java.lang.StringBuilder) st.v5o).append(st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1209:
                        st.pc = 1209;
                        st.tmpO = ((java.lang.StringBuilder) st.v5o).append((java.lang.String) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1210:
                        st.v6i = st.v3i + 2;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1211:
                        st.pc = 1211;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1212:
                        st.pc = 1212;
                        st.tmpO = ((java.lang.StringBuilder) st.v5o).append(st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1213:
                        st.pc = 1213;
                        st.tmpO = ((java.lang.StringBuilder) st.v5o).append((java.lang.String) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1214:
                        st.v6i = st.v3i + 3;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1215:
                        st.pc = 1215;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1216:
                        st.pc = 1216;
                        st.tmpO = ((java.lang.StringBuilder) st.v5o).append(st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1217:
                        st.pc = 1217;
                        st.tmpO = ((java.lang.StringBuilder) st.v5o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1218:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1219:
                        st.pc = 1219;
                        st.pc = 1237;
                        continue;
                    case 1220:
                        st.pc = 1220;
                        st.v5o = null;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1221:
                        st.pc = 1221;
                        st.v5o = new java.lang.StringBuilder();
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1222:
                        st.v6i = st.v3i + 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1223:
                        st.pc = 1223;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1224:
                        st.pc = 1224;
                        st.tmpO = ((java.lang.StringBuilder) st.v5o).append(st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1225:
                        st.pc = 1225;
                        st.tmpO = ((java.lang.StringBuilder) st.v5o).append((java.lang.String) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1226:
                        st.v6i = st.v3i + 2;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1227:
                        st.pc = 1227;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1228:
                        st.pc = 1228;
                        st.tmpO = ((java.lang.StringBuilder) st.v5o).append(st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1229:
                        st.pc = 1229;
                        st.pc = 1217;
                        continue;
                    case 1230:
                        st.v5i = st.v3i + 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1231:
                        st.pc = 1231;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1232:
                        st.pc = 1232;
                        st.tmpO = ((luaj.LuaValue) st.v5o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1233:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1234:
                        st.pc = 1234;
                        st.pc = 1237;
                        continue;
                    case 1235:
                        st.pc = 1235;
                        st.tmpO = ((luaj.LuaValue) st.v9o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1236:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1237:
                        st.pc = 1237;
                        st.v5o = null;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1238:
                        st.pc = 1238;
                        st.v6o = null;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1239:
                        st.pc = 1239;
                        st.v6o = new java.lang.StringBuilder();
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1240:
                        st.pc = 1240;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v12o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1241:
                        st.pc = 1241;
                        st.v9o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1242:
                        st.pc = 1242;
                        st.tmpO = ((java.lang.Object) st.v9o).getClass();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1243:
                        st.v9o = st.tmpO;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1244:
                        st.pc = 1244;
                        st.tmpO = ((java.lang.Class) st.v9o).getName();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1245:
                        st.v9o = st.tmpO;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1246:
                        st.pc = 1246;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1247:
                        st.pc = 1247;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v15o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1248:
                        st.pc = 1248;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1249:
                        st.pc = 1249;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1250:
                        st.pc = 1250;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1251:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1252:
                        st.pc = 1252;
                        st.v5o = new java.lang.NullPointerException((java.lang.String) st.v6o);
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1253:
                        st.pc = 1253;
                        st.tmpO = ((java.lang.Throwable) st.v5o).initCause((java.lang.Throwable) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1254:
                        st.pc = 1254;
                        throw (java.lang.Throwable) st.v5o;
                    case 1255:
                        st.pc = 1255;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1256:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1257:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1258:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1259:
                        st.pc = 1259;
                        st.pc = 1143;
                        continue;
                    case 1260:
                        st.pc = 1260;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1261:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1262:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1263:
                        st.pc = 1263;
                        st.pc = 1147;
                        continue;
                    case 1264:
                        st.pc = 1264;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1265:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1266:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1267:
                        st.pc = 1267;
                        st.pc = 1150;
                        continue;
                    case 1268:
                        st.pc = 1268;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1269:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1270:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1271:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1272:
                        st.pc = 1272;
                        st.pc = 1153;
                        continue;
                    case 1273:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1274:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1275:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1276:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1277:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1278:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1279:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1280:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1281:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1282:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1283:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1284:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1285:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1286:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1287:
                        st.pc = 1287;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1288:
                        st.pc = 1288;
                        st.tmpI = (((luaj.LuaValue) st.v6o).w2()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1289:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1290:
                        st.v10i = st.v14i & st.v23i;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1291:
                        st.pc = 1291;
                        if (st.v10i == 0) {
                            st.pc = 1294;
                            continue;
                        }
                    case 1292:
                        st.v10i = 1;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1293:
                        st.pc = 1293;
                        st.pc = 1295;
                        continue;
                    case 1294:
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1295:
                        st.pc = 1295;
                        if (st.v7i == st.v10i) {
                            st.pc = 1301;
                            continue;
                        }
                    case 1296:
                        st.v11i = st.v33i + 1;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1297:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 1298:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1299:
                        st.v7o = st.v31o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1300:
                        st.pc = 1300;
                        st.pc = 1167;
                        continue;
                    case 1301:
                        st.pc = 1301;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v6o;
                    case 1302:
                        st.v34i = st.v5i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 1303:
                        st.v7o = st.v31o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1304:
                        st.pc = 1304;
                        st.pc = 2104;
                        continue;
                    case 1305:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1306:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1307:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1308:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1309:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1310:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1311:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1312:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1313:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1314:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1315:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1316:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1317:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1318:
                        st.pc = 1318;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1319:
                        st.pc = 1319;
                        st.tmpI = (((luaj.LuaValue) st.v6o).w2()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1320:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1321:
                        st.v7i = st.v14i & st.v23i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1322:
                        st.pc = 1322;
                        if (st.v7i == 0) {
                            st.pc = 1325;
                            continue;
                        }
                    case 1323:
                        st.v7i = 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1324:
                        st.pc = 1324;
                        st.pc = 1326;
                        continue;
                    case 1325:
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1326:
                        st.pc = 1326;
                        if (st.v6i == st.v7i) {
                            st.pc = 1302;
                            continue;
                        }
                    case 1327:
                        st.pc = 1327;
                        st.pc = 1296;
                        continue;
                    case 1328:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1329:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1330:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1331:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1332:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1333:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1334:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1335:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1336:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1337:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1338:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1339:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1340:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1341:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1342:
                        st.v7i = 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1343:
                        st.pc = 1343;
                        if (st.v6i <= st.v7i) {
                            st.pc = 1352;
                            continue;
                        }
                    case 1344:
                        st.v7i = st.v6i & 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1345:
                        st.pc = 1345;
                        st.v7o = ((java.lang.Object[]) st.v30o)[st.v7i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1346:
                        st.pc = 1346;
                        st.pc = 1353;
                        continue;
                    case 1347:
                        st.pc = 1347;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1348:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1349:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 1350:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1351:
                        st.pc = 1351;
                        st.pc = 1157;
                        continue;
                    case 1352:
                        st.pc = 1352;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1353:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1354:
                        st.v11i = st.v10i & 511;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1355:
                        st.v12i = 255;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1356:
                        st.pc = 1356;
                        if (st.v11i <= st.v12i) {
                            st.pc = 1365;
                            continue;
                        }
                    case 1357:
                        st.v10i = st.v10i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1358:
                        st.pc = 1358;
                        st.v10o = ((java.lang.Object[]) st.v30o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1359:
                        st.pc = 1359;
                        st.pc = 1366;
                        continue;
                    case 1360:
                        st.pc = 1360;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1361:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1362:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 1363:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1364:
                        st.pc = 1364;
                        st.pc = 1158;
                        continue;
                    case 1365:
                        st.pc = 1365;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1366:
                        st.pc = 1366;
                        st.tmpI = (((luaj.LuaValue) st.v7o).v1((luaj.LuaValue) st.v10o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1367:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1368:
                        st.pc = 1368;
                        if (st.v3i == 0) {
                            st.pc = 1371;
                            continue;
                        }
                    case 1369:
                        st.v10i = 1;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1370:
                        st.pc = 1370;
                        st.pc = 1372;
                        continue;
                    case 1371:
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1372:
                        st.pc = 1372;
                        if (st.v7i == st.v10i) {
                            st.pc = 1381;
                            continue;
                        }
                    case 1373:
                        st.v7i = st.v33i + 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1374:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 1375:
                        st.v26i = st.v6i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 1376:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1377:
                        st.v27i = st.v11i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 1378:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1379:
                        st.v11i = st.v7i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1380:
                        st.pc = 1380;
                        st.pc = 668;
                        continue;
                    case 1381:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 1382:
                        st.v26i = st.v6i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 1383:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1384:
                        st.v27i = st.v11i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 1385:
                        st.pc = 1385;
                        st.pc = 1165;
                        continue;
                    case 1386:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1387:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1388:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1389:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1390:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1391:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1392:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1393:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1394:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1395:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1396:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1397:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1398:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1399:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1400:
                        st.v7i = 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1401:
                        st.pc = 1401;
                        if (st.v6i <= st.v7i) {
                            st.pc = 1405;
                            continue;
                        }
                    case 1402:
                        st.v7i = st.v6i & 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1403:
                        st.pc = 1403;
                        st.v7o = ((java.lang.Object[]) st.v30o)[st.v7i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1404:
                        st.pc = 1404;
                        st.pc = 1406;
                        continue;
                    case 1405:
                        st.pc = 1405;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1406:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1407:
                        st.v11i = st.v10i & 511;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1408:
                        st.v12i = 255;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1409:
                        st.pc = 1409;
                        if (st.v11i <= st.v12i) {
                            st.pc = 1413;
                            continue;
                        }
                    case 1410:
                        st.v10i = st.v10i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1411:
                        st.pc = 1411;
                        st.v10o = ((java.lang.Object[]) st.v30o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1412:
                        st.pc = 1412;
                        st.pc = 1414;
                        continue;
                    case 1413:
                        st.pc = 1413;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1414:
                        st.pc = 1414;
                        st.tmpI = (((luaj.LuaValue) st.v7o).u1((luaj.LuaValue) st.v10o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1415:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1416:
                        st.pc = 1416;
                        if (st.v3i == 0) {
                            st.pc = 1419;
                            continue;
                        }
                    case 1417:
                        st.v10i = 1;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1418:
                        st.pc = 1418;
                        st.pc = 1420;
                        continue;
                    case 1419:
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1420:
                        st.pc = 1420;
                        if (st.v7i == st.v10i) {
                            st.pc = 1381;
                            continue;
                        }
                    case 1421:
                        st.pc = 1421;
                        st.pc = 1373;
                        continue;
                    case 1422:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1423:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1424:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1425:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1426:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1427:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1428:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1429:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1430:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1431:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1432:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1433:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1434:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1435:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1436:
                        st.v7i = 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1437:
                        st.pc = 1437;
                        if (st.v6i <= st.v7i) {
                            st.pc = 1441;
                            continue;
                        }
                    case 1438:
                        st.v7i = st.v6i & 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1439:
                        st.pc = 1439;
                        st.v7o = ((java.lang.Object[]) st.v30o)[st.v7i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1440:
                        st.pc = 1440;
                        st.pc = 1442;
                        continue;
                    case 1441:
                        st.pc = 1441;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1442:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1443:
                        st.v11i = st.v10i & 511;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1444:
                        st.v12i = 255;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1445:
                        st.pc = 1445;
                        if (st.v11i <= st.v12i) {
                            st.pc = 1449;
                            continue;
                        }
                    case 1446:
                        st.v10i = st.v10i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1447:
                        st.pc = 1447;
                        st.v10o = ((java.lang.Object[]) st.v30o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1448:
                        st.pc = 1448;
                        st.pc = 1450;
                        continue;
                    case 1449:
                        st.pc = 1449;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1450:
                        st.pc = 1450;
                        st.tmpI = (((luaj.LuaValue) st.v7o).P0((luaj.LuaValue) st.v10o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1451:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1452:
                        st.pc = 1452;
                        if (st.v3i == 0) {
                            st.pc = 1455;
                            continue;
                        }
                    case 1453:
                        st.v10i = 1;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1454:
                        st.pc = 1454;
                        st.pc = 1456;
                        continue;
                    case 1455:
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1456:
                        st.pc = 1456;
                        if (st.v7i == st.v10i) {
                            st.pc = 1381;
                            continue;
                        }
                    case 1457:
                        st.pc = 1457;
                        st.pc = 1373;
                        continue;
                    case 1458:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1459:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1460:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1461:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1462:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1463:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1464:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1465:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1466:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1467:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1468:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1469:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1470:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1471:
                        st.v6i = st.v14i >>> 14;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1472:
                        st.v6i = st.v6i - st.v32i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1473:
                        st.v11i = st.v33i + st.v6i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1474:
                        st.pc = 1474;
                        if (st.v3i <= 0) {
                            st.pc = 1297;
                            continue;
                        }
                    case 1475:
                        st.v3i = st.v3i + 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1476:
                        st.pc = 1476;
                        if (st.v28o == null) {
                            st.pc = 1297;
                            continue;
                        }
                    case 1477:
                        st.v7i = st.v24i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1478:
                        st.v6i = 0xffffffff;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1479:
                        st.v7i = st.v7i + st.v6i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1480:
                        st.pc = 1480;
                        if (st.v7i < 0) {
                            st.pc = 1499;
                            continue;
                        }
                    case 1481:
                        st.pc = 1481;
                        st.v6o = ((java.lang.Object[]) st.v28o)[st.v7i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1482:
                        st.pc = 1482;
                        if (st.v6o == null) {
                            st.pc = 1478;
                            continue;
                        }
                    case 1483:
                        st.pc = 1483;
                        st.v10i = ((luaj.i) st.v6o).f1731b;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1484:
                        st.pc = 1484;
                        if (st.v10i < st.v3i) {
                            st.pc = 1478;
                            continue;
                        }
                    case 1485:
                        st.pc = 1485;
                        ((luaj.i) st.v6o).a();
                    case 1486:
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1487:
                        st.pc = 1487;
                        ((java.lang.Object[]) st.v28o)[st.v7i] = st.v6o;
                    case 1488:
                        st.pc = 1488;
                        st.pc = 1478;
                        continue;
                    case 1489:
                        st.pc = 1489;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1490:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 1491:
                        st.pc = 1491;
                        st.pc = 913;
                        continue;
                    case 1492:
                        st.pc = 1492;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1493:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1494:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 1495:
                        st.v6i = st.v7i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1496:
                        st.v4i = st.v11i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 1497:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1498:
                        st.pc = 1498;
                        st.pc = 77;
                        continue;
                    case 1499:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 1500:
                        st.v26i = st.v7i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 1501:
                        st.pc = 1501;
                        st.pc = 1298;
                        continue;
                    case 1502:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1503:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1504:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1505:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1506:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1507:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1508:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1509:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1510:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1511:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1512:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1513:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1514:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1515:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1516:
                        st.v7i = st.v14i >> 14;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1517:
                        st.v7i = st.v7i & 511;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1518:
                        st.v10i = st.v6i + 1;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1519:
                        st.pc = 1519;
                        if (st.v7i <= st.v10i) {
                            st.pc = 1542;
                            continue;
                        }
                    case 1520:
                        st.pc = 1520;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v7i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1521:
                        st.pc = 1521;
                        st.tmpO = ((luaj.LuaValue) st.v10o).s0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1522:
                        st.v10o = st.tmpO;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1523:
                        st.v11i = 0xffffffff;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1524:
                        st.v7i = st.v7i + st.v11i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1525:
                        st.pc = 1525;
                        if (st.v7i < st.v6i) {
                            st.pc = 1534;
                            continue;
                        }
                    case 1526:
                        st.pc = 1526;
                        st.v11o = ((java.lang.Object[]) st.v2o)[st.v7i];
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 1527:
                        st.pc = 1527;
                        st.tmpO = ((gg_f.a) st.v10o).g((luaj.LuaValue) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1528:
                        st.pc = 1528;
                        st.pc = 1523;
                        continue;
                    case 1529:
                        st.pc = 1529;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1530:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1531:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 1532:
                        st.v11i = st.v7i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1533:
                        st.pc = 1533;
                        st.pc = 1363;
                        continue;
                    case 1534:
                        st.pc = 1534;
                        st.tmpO = ((gg_f.a) st.v10o).m();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1535:
                        st.v10o = st.tmpO;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1536:
                        st.pc = 1536;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v10o;
                    case 1537:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 1538:
                        st.v26i = st.v6i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 1539:
                        st.v27i = st.v7i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 1540:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1541:
                        st.pc = 1541;
                        st.pc = 1165;
                        continue;
                    case 1542:
                        st.v10i = st.v7i + 0xffffffff;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1543:
                        st.pc = 1543;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1544:
                        st.pc = 1544;
                        st.v11o = ((java.lang.Object[]) st.v2o)[st.v7i];
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 1545:
                        st.pc = 1545;
                        st.tmpO = ((luaj.LuaValue) st.v10o).K0((luaj.LuaValue) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1546:
                        st.v10o = st.tmpO;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1547:
                        st.pc = 1547;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v10o;
                    case 1548:
                        st.pc = 1548;
                        st.pc = 1537;
                        continue;
                    case 1549:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1550:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1551:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1552:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1553:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1554:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1555:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1556:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1557:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1558:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1559:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1560:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1561:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1562:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1563:
                        st.pc = 1563;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1564:
                        st.pc = 1564;
                        st.tmpO = ((luaj.LuaValue) st.v6o).r1();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1565:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1566:
                        st.pc = 1566;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v6o;
                    case 1567:
                        st.pc = 1567;
                        st.pc = 1302;
                        continue;
                    case 1568:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1569:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1570:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1571:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1572:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1573:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1574:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1575:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1576:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1577:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1578:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1579:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1580:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1581:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1582:
                        st.pc = 1582;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1583:
                        st.pc = 1583;
                        st.tmpO = ((luaj.LuaValue) st.v6o).B1();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1584:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1585:
                        st.pc = 1585;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v6o;
                    case 1586:
                        st.pc = 1586;
                        st.pc = 1302;
                        continue;
                    case 1587:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1588:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1589:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1590:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1591:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1592:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1593:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1594:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1595:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1596:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1597:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1598:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1599:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1600:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1601:
                        st.pc = 1601;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1602:
                        st.pc = 1602;
                        st.tmpO = ((luaj.LuaValue) st.v6o).A1();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1603:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1604:
                        st.pc = 1604;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v6o;
                    case 1605:
                        st.pc = 1605;
                        st.pc = 1302;
                        continue;
                    case 1606:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1607:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1608:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1609:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1610:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1611:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1612:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1613:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1614:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1615:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1616:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1617:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1618:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1619:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1620:
                        st.v7i = 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1621:
                        st.pc = 1621;
                        if (st.v6i <= st.v7i) {
                            st.pc = 1625;
                            continue;
                        }
                    case 1622:
                        st.v7i = st.v6i & 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1623:
                        st.pc = 1623;
                        st.v7o = ((java.lang.Object[]) st.v30o)[st.v7i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1624:
                        st.pc = 1624;
                        st.pc = 1626;
                        continue;
                    case 1625:
                        st.pc = 1625;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1626:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1627:
                        st.v11i = st.v10i & 511;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1628:
                        st.v12i = 255;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1629:
                        st.pc = 1629;
                        if (st.v11i <= st.v12i) {
                            st.pc = 1633;
                            continue;
                        }
                    case 1630:
                        st.v10i = st.v10i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1631:
                        st.pc = 1631;
                        st.v10o = ((java.lang.Object[]) st.v30o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1632:
                        st.pc = 1632;
                        st.pc = 1634;
                        continue;
                    case 1633:
                        st.pc = 1633;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1634:
                        st.pc = 1634;
                        st.tmpO = ((luaj.LuaValue) st.v7o).Q1((luaj.LuaValue) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1635:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1636:
                        st.pc = 1636;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v7o;
                    case 1637:
                        st.pc = 1637;
                        st.pc = 1381;
                        continue;
                    case 1638:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1639:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1640:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1641:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1642:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1643:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1644:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1645:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1646:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1647:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1648:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1649:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1650:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1651:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1652:
                        st.v7i = 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1653:
                        st.pc = 1653;
                        if (st.v6i <= st.v7i) {
                            st.pc = 1657;
                            continue;
                        }
                    case 1654:
                        st.v7i = st.v6i & 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1655:
                        st.pc = 1655;
                        st.v7o = ((java.lang.Object[]) st.v30o)[st.v7i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1656:
                        st.pc = 1656;
                        st.pc = 1658;
                        continue;
                    case 1657:
                        st.pc = 1657;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1658:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1659:
                        st.v11i = st.v10i & 511;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1660:
                        st.v12i = 255;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1661:
                        st.pc = 1661;
                        if (st.v11i <= st.v12i) {
                            st.pc = 1665;
                            continue;
                        }
                    case 1662:
                        st.v10i = st.v10i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1663:
                        st.pc = 1663;
                        st.v10o = ((java.lang.Object[]) st.v30o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1664:
                        st.pc = 1664;
                        st.pc = 1666;
                        continue;
                    case 1665:
                        st.pc = 1665;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1666:
                        st.pc = 1666;
                        st.tmpO = ((luaj.LuaValue) st.v7o).y1((luaj.LuaValue) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1667:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1668:
                        st.pc = 1668;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v7o;
                    case 1669:
                        st.pc = 1669;
                        st.pc = 1381;
                        continue;
                    case 1670:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1671:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1672:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1673:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1674:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1675:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1676:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1677:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1678:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1679:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1680:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1681:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1682:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1683:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1684:
                        st.v7i = 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1685:
                        st.pc = 1685;
                        if (st.v6i <= st.v7i) {
                            st.pc = 1689;
                            continue;
                        }
                    case 1686:
                        st.v7i = st.v6i & 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1687:
                        st.pc = 1687;
                        st.v7o = ((java.lang.Object[]) st.v30o)[st.v7i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1688:
                        st.pc = 1688;
                        st.pc = 1690;
                        continue;
                    case 1689:
                        st.pc = 1689;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1690:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1691:
                        st.v11i = st.v10i & 511;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1692:
                        st.v12i = 255;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1693:
                        st.pc = 1693;
                        if (st.v11i <= st.v12i) {
                            st.pc = 1697;
                            continue;
                        }
                    case 1694:
                        st.v10i = st.v10i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1695:
                        st.pc = 1695;
                        st.v10o = ((java.lang.Object[]) st.v30o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1696:
                        st.pc = 1696;
                        st.pc = 1698;
                        continue;
                    case 1697:
                        st.pc = 1697;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1698:
                        st.pc = 1698;
                        st.tmpO = ((luaj.LuaValue) st.v7o).O0((luaj.LuaValue) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1699:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1700:
                        st.pc = 1700;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v7o;
                    case 1701:
                        st.pc = 1701;
                        st.pc = 1381;
                        continue;
                    case 1702:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1703:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1704:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1705:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1706:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1707:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1708:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1709:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1710:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1711:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1712:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1713:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1714:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1715:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1716:
                        st.v7i = 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1717:
                        st.pc = 1717;
                        if (st.v6i <= st.v7i) {
                            st.pc = 1721;
                            continue;
                        }
                    case 1718:
                        st.v7i = st.v6i & 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1719:
                        st.pc = 1719;
                        st.v7o = ((java.lang.Object[]) st.v30o)[st.v7i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1720:
                        st.pc = 1720;
                        st.pc = 1722;
                        continue;
                    case 1721:
                        st.pc = 1721;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1722:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1723:
                        st.v11i = st.v10i & 511;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1724:
                        st.v12i = 255;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1725:
                        st.pc = 1725;
                        if (st.v11i <= st.v12i) {
                            st.pc = 1729;
                            continue;
                        }
                    case 1726:
                        st.v10i = st.v10i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1727:
                        st.pc = 1727;
                        st.v10o = ((java.lang.Object[]) st.v30o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1728:
                        st.pc = 1728;
                        st.pc = 1730;
                        continue;
                    case 1729:
                        st.pc = 1729;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1730:
                        st.pc = 1730;
                        st.tmpO = ((luaj.LuaValue) st.v7o).z1((luaj.LuaValue) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1731:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1732:
                        st.pc = 1732;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v7o;
                    case 1733:
                        st.pc = 1733;
                        st.pc = 1381;
                        continue;
                    case 1734:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1735:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1736:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1737:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1738:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1739:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1740:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1741:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1742:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1743:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1744:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1745:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1746:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1747:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1748:
                        st.v7i = 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1749:
                        st.pc = 1749;
                        if (st.v6i <= st.v7i) {
                            st.pc = 1753;
                            continue;
                        }
                    case 1750:
                        st.v7i = st.v6i & 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1751:
                        st.pc = 1751;
                        st.v7o = ((java.lang.Object[]) st.v30o)[st.v7i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1752:
                        st.pc = 1752;
                        st.pc = 1754;
                        continue;
                    case 1753:
                        st.pc = 1753;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1754:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1755:
                        st.v11i = st.v10i & 511;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1756:
                        st.v12i = 255;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1757:
                        st.pc = 1757;
                        if (st.v11i <= st.v12i) {
                            st.pc = 1761;
                            continue;
                        }
                    case 1758:
                        st.v10i = st.v10i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1759:
                        st.pc = 1759;
                        st.v10o = ((java.lang.Object[]) st.v30o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1760:
                        st.pc = 1760;
                        st.pc = 1762;
                        continue;
                    case 1761:
                        st.pc = 1761;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1762:
                        st.pc = 1762;
                        st.tmpO = ((luaj.LuaValue) st.v7o).r2((luaj.LuaValue) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1763:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1764:
                        st.pc = 1764;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v7o;
                    case 1765:
                        st.pc = 1765;
                        st.pc = 1381;
                        continue;
                    case 1766:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1767:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1768:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1769:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1770:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1771:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1772:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1773:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1774:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1775:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1776:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1777:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1778:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1779:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1780:
                        st.v7i = 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1781:
                        st.pc = 1781;
                        if (st.v6i <= st.v7i) {
                            st.pc = 1785;
                            continue;
                        }
                    case 1782:
                        st.v7i = st.v6i & 255;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1783:
                        st.pc = 1783;
                        st.v7o = ((java.lang.Object[]) st.v30o)[st.v7i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1784:
                        st.pc = 1784;
                        st.pc = 1786;
                        continue;
                    case 1785:
                        st.pc = 1785;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1786:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1787:
                        st.v11i = st.v10i & 511;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1788:
                        st.v12i = 255;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1789:
                        st.pc = 1789;
                        if (st.v11i <= st.v12i) {
                            st.pc = 1793;
                            continue;
                        }
                    case 1790:
                        st.v10i = st.v10i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1791:
                        st.pc = 1791;
                        st.v10o = ((java.lang.Object[]) st.v30o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1792:
                        st.pc = 1792;
                        st.pc = 1794;
                        continue;
                    case 1793:
                        st.pc = 1793;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1794:
                        st.pc = 1794;
                        st.tmpO = ((luaj.LuaValue) st.v7o).j0((luaj.LuaValue) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1795:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1796:
                        st.pc = 1796;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v7o;
                    case 1797:
                        st.pc = 1797;
                        st.pc = 1381;
                        continue;
                    case 1798:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1799:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1800:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1801:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1802:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1803:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1804:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1805:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1806:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1807:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1808:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1809:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1810:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1811:
                        st.v6i = st.v3i + 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1812:
                        st.v7i = st.v14i >>> 23;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1813:
                        st.pc = 1813;
                        st.v7o = ((java.lang.Object[]) st.v2o)[st.v7i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1814:
                        st.pc = 1814;
                        ((java.lang.Object[]) st.v2o)[st.v6i] = st.v7o;
                    case 1815:
                        st.v6i = st.v14i >> 14;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1816:
                        st.v10i = st.v6i & 511;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1817:
                        st.v11i = 255;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1818:
                        st.pc = 1818;
                        if (st.v10i <= st.v11i) {
                            st.pc = 1829;
                            continue;
                        }
                    case 1819:
                        st.v6i = st.v6i & 255;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1820:
                        st.pc = 1820;
                        st.v6o = ((java.lang.Object[]) st.v30o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1821:
                        st.pc = 1821;
                        st.pc = 1830;
                        continue;
                    case 1822:
                        st.pc = 1822;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1823:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1824:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 1825:
                        st.v11i = st.v10i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1826:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1827:
                        st.v6i = st.v26i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1828:
                        st.pc = 1828;
                        st.pc = 1158;
                        continue;
                    case 1829:
                        st.pc = 1829;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v10i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1830:
                        st.pc = 1830;
                        st.tmpO = ((luaj.LuaValue) st.v7o).U0((luaj.LuaValue) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1831:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1832:
                        st.pc = 1832;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v6o;
                    case 1833:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 1834:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1835:
                        st.v27i = st.v10i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 1836:
                        st.pc = 1836;
                        st.pc = 1165;
                        continue;
                    case 1837:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1838:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1839:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1840:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1841:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1842:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1843:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1844:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1845:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1846:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1847:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1848:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1849:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1850:
                        st.pc = 1850;
                        st.v6o = null;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1851:
                        st.v7i = st.v14i >>> 23;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1852:
                        st.v10i = st.v14i >> 14;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1853:
                        st.v10i = st.v10i & 511;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1854:
                        st.pc = 1854;
                        st.v6o = new luaj.LuaTable(st.v7i, st.v10i);
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1855:
                        st.pc = 1855;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v6o;
                    case 1856:
                        st.pc = 1856;
                        st.pc = 1302;
                        continue;
                    case 1857:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1858:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1859:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1860:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1861:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1862:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1863:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1864:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1865:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1866:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1867:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1868:
                        st.v31o = st.v10o;
                        st.v31i = 0;
                        st.v31j = 0L;
                        st.v31d = 0.0;
                    case 1869:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1870:
                        st.pc = 1870;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1871:
                        st.v7i = st.v14i >>> 23;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 1872:
                        st.v10i = 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1873:
                        st.pc = 1873;
                        if (st.v7i <= st.v10i) {
                            st.pc = 1882;
                            continue;
                        }
                    case 1874:
                        st.v10i = st.v7i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1875:
                        st.pc = 1875;
                        st.v10o = ((java.lang.Object[]) st.v30o)[st.v10i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1876:
                        st.pc = 1876;
                        st.pc = 1883;
                        continue;
                    case 1877:
                        st.pc = 1877;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1878:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1879:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 1880:
                        st.v6i = st.v7i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1881:
                        st.pc = 1881;
                        st.pc = 1350;
                        continue;
                    case 1882:
                        st.pc = 1882;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v7i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1883:
                        st.v11i = st.v14i >> 14;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1884:
                        st.v12i = st.v11i & 511;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1885:
                        st.v15i = 255;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 1886:
                        st.pc = 1886;
                        if (st.v12i <= st.v15i) {
                            st.pc = 1896;
                            continue;
                        }
                    case 1887:
                        st.v11i = st.v11i & 255;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1888:
                        st.pc = 1888;
                        st.v11o = ((java.lang.Object[]) st.v30o)[st.v11i];
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 1889:
                        st.pc = 1889;
                        st.pc = 1897;
                        continue;
                    case 1890:
                        st.pc = 1890;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1891:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1892:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 1893:
                        st.v6i = st.v7i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1894:
                        st.v11i = st.v12i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1895:
                        st.pc = 1895;
                        st.pc = 1363;
                        continue;
                    case 1896:
                        st.pc = 1896;
                        st.v11o = ((java.lang.Object[]) st.v2o)[st.v12i];
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 1897:
                        st.pc = 1897;
                        ((luaj.LuaValue) st.v6o).j2((luaj.LuaValue) st.v10o, (luaj.LuaValue) st.v11o);
                    case 1898:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 1899:
                        st.v26i = st.v7i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 1900:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1901:
                        st.v27i = st.v12i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 1902:
                        st.pc = 1902;
                        st.pc = 1165;
                        continue;
                    case 1903:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1904:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1905:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1906:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1907:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1908:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1909:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1910:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1911:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1912:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1913:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1914:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1915:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1916:
                        st.pc = 1916;
                        st.v6i = java.lang.reflect.Array.getLength(st.v7o);
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1917:
                        st.v10i = st.v14i >>> 23;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1918:
                        st.pc = 1918;
                        if (st.v10i >= st.v6i) {
                            st.pc = 1924;
                            continue;
                        }
                    case 1919:
                        st.pc = 1919;
                        st.v6o = ((java.lang.Object[]) st.v7o)[st.v10i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1920:
                        st.pc = 1920;
                        st.v10o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 1921:
                        st.pc = 1921;
                        ((luaj.i) st.v6o).c((luaj.LuaValue) st.v10o);
                    case 1922:
                        st.v34i = st.v5i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 1923:
                        st.pc = 1923;
                        st.pc = 2104;
                        continue;
                    case 1924:
                        st.v5i = 4;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1925:
                        st.pc = 1925;
                        st.tmpO = luaj.LuaClosure.g3(st.v5i, st.v10i, st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1926:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1927:
                        st.pc = 1927;
                        throw (java.lang.Throwable) st.v5o;
                    case 1928:
                        st.v5i = st.v4i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1929:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1930:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1931:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1932:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1933:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1934:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1935:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1936:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1937:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1938:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1939:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1940:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1941:
                        st.pc = 1941;
                        st.v6i = java.lang.reflect.Array.getLength(st.v7o);
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1942:
                        st.pc = 1942;
                        if (st.v3i >= st.v6i) {
                            st.pc = 1982;
                            continue;
                        }
                    case 1943:
                        st.pc = 1943;
                        st.v6o = ((java.lang.Object[]) st.v7o)[st.v3i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1944:
                        st.pc = 1944;
                        st.tmpO = ((luaj.i) st.v6o).b();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1945:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1946:
                        st.v10i = st.v14i >>> 23;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 1947:
                        st.v11i = 255;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1948:
                        st.pc = 1948;
                        if (st.v10i <= st.v11i) {
                            st.pc = 1957;
                            continue;
                        }
                    case 1949:
                        st.v11i = st.v10i & 255;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1950:
                        st.pc = 1950;
                        st.v11o = ((java.lang.Object[]) st.v30o)[st.v11i];
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 1951:
                        st.pc = 1951;
                        st.pc = 1958;
                        continue;
                    case 1952:
                        st.pc = 1952;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1953:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1954:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 1955:
                        st.v6i = st.v10i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1956:
                        st.pc = 1956;
                        st.pc = 1350;
                        continue;
                    case 1957:
                        st.pc = 1957;
                        st.v11o = ((java.lang.Object[]) st.v2o)[st.v10i];
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 1958:
                        st.v12i = st.v14i >> 14;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 1959:
                        st.v15i = st.v12i & 511;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 1960:
                        st.v34i = st.v5i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 1961:
                        st.v5i = 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1962:
                        st.pc = 1962;
                        if (st.v15i <= st.v5i) {
                            st.pc = 1973;
                            continue;
                        }
                    case 1963:
                        st.v5i = st.v12i & 255;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1964:
                        st.pc = 1964;
                        st.v5o = ((java.lang.Object[]) st.v30o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1965:
                        st.pc = 1965;
                        st.pc = 1974;
                        continue;
                    case 1966:
                        st.pc = 1966;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1967:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1968:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 1969:
                        st.v6i = st.v10i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 1970:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1971:
                        st.v11i = st.v15i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1972:
                        st.pc = 1972;
                        st.pc = 1158;
                        continue;
                    case 1973:
                        st.pc = 1973;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v15i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1974:
                        st.pc = 1974;
                        ((luaj.LuaValue) st.v6o).j2((luaj.LuaValue) st.v11o, (luaj.LuaValue) st.v5o);
                    case 1975:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 1976:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 1977:
                        st.v26i = st.v10i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 1978:
                        st.v27i = st.v15i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 1979:
                        st.v11i = st.v33i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 1980:
                        st.v5i = st.v34i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1981:
                        st.pc = 1981;
                        st.pc = 1167;
                        continue;
                    case 1982:
                        st.v5i = 3;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 1983:
                        st.pc = 1983;
                        st.tmpO = luaj.LuaClosure.g3(st.v5i, st.v3i, st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1984:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 1985:
                        st.pc = 1985;
                        throw (java.lang.Throwable) st.v5o;
                    case 1986:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 1987:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 1988:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 1989:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 1990:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 1991:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 1992:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 1993:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 1994:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 1995:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 1996:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 1997:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1998:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 1999:
                        st.v5i = st.v14i >>> 23;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2000:
                        st.pc = 2000;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2001:
                        st.v6i = st.v14i >> 14;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2002:
                        st.v10i = st.v6i & 511;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 2003:
                        st.v11i = 255;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 2004:
                        st.pc = 2004;
                        if (st.v10i <= st.v11i) {
                            st.pc = 2008;
                            continue;
                        }
                    case 2005:
                        st.v6i = st.v6i & 255;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2006:
                        st.pc = 2006;
                        st.v6o = ((java.lang.Object[]) st.v30o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2007:
                        st.pc = 2007;
                        st.pc = 2009;
                        continue;
                    case 2008:
                        st.pc = 2008;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v10i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2009:
                        st.pc = 2009;
                        st.tmpO = ((luaj.LuaValue) st.v5o).U0((luaj.LuaValue) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2010:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2011:
                        st.pc = 2011;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v5o;
                    case 2012:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 2013:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2014:
                        st.v27i = st.v10i;
                        st.v27j = 0L;
                        st.v27o = null;
                        st.v27d = 0.0;
                    case 2015:
                        st.pc = 2015;
                        st.pc = 1979;
                        continue;
                    case 2016:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 2017:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 2018:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2019:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 2020:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 2021:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 2022:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2023:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2024:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 2025:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2026:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 2027:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2028:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2029:
                        st.pc = 2029;
                        st.v5i = java.lang.reflect.Array.getLength(st.v7o);
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2030:
                        st.v10i = st.v14i >>> 23;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 2031:
                        st.pc = 2031;
                        if (st.v10i >= st.v5i) {
                            st.pc = 2047;
                            continue;
                        }
                    case 2032:
                        st.pc = 2032;
                        st.v5o = ((java.lang.Object[]) st.v7o)[st.v10i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2033:
                        st.pc = 2033;
                        st.tmpO = ((luaj.i) st.v5o).b();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2034:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2035:
                        st.v6i = st.v14i >> 14;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2036:
                        st.v10i = st.v6i & 511;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 2037:
                        st.v11i = 255;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 2038:
                        st.pc = 2038;
                        if (st.v10i <= st.v11i) {
                            st.pc = 2042;
                            continue;
                        }
                    case 2039:
                        st.v6i = st.v6i & 255;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2040:
                        st.pc = 2040;
                        st.v6o = ((java.lang.Object[]) st.v30o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2041:
                        st.pc = 2041;
                        st.pc = 2043;
                        continue;
                    case 2042:
                        st.pc = 2042;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v10i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2043:
                        st.pc = 2043;
                        st.tmpO = ((luaj.LuaValue) st.v5o).U0((luaj.LuaValue) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2044:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2045:
                        st.pc = 2045;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v5o;
                    case 2046:
                        st.pc = 2046;
                        st.pc = 2012;
                        continue;
                    case 2047:
                        st.pc = 2047;
                        st.tmpO = luaj.LuaClosure.g3(st.v6i, st.v10i, st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2048:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2049:
                        st.pc = 2049;
                        throw (java.lang.Throwable) st.v5o;
                    case 2050:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 2051:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 2052:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2053:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 2054:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 2055:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 2056:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2057:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2058:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 2059:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2060:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 2061:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2062:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2063:
                        st.pc = 2063;
                        st.v5i = java.lang.reflect.Array.getLength(st.v7o);
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2064:
                        st.v6i = st.v14i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2065:
                        st.pc = 2065;
                        if (st.v6i >= st.v5i) {
                            st.pc = 2071;
                            continue;
                        }
                    case 2066:
                        st.pc = 2066;
                        st.v5o = ((java.lang.Object[]) st.v7o)[st.v6i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2067:
                        st.pc = 2067;
                        st.tmpO = ((luaj.i) st.v5o).b();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2068:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2069:
                        st.pc = 2069;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v5o;
                    case 2070:
                        st.pc = 2070;
                        st.pc = 2104;
                        continue;
                    case 2071:
                        st.v7i = 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 2072:
                        st.pc = 2072;
                        st.tmpO = luaj.LuaClosure.g3(st.v7i, st.v6i, st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2073:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2074:
                        st.pc = 2074;
                        throw (java.lang.Throwable) st.v5o;
                    case 2075:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 2076:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 2077:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2078:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 2079:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 2080:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 2081:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2082:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2083:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 2084:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2085:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 2086:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2087:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2088:
                        st.v5i = st.v14i >>> 23;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2089:
                        st.v26i = st.v5i + 0xffffffff;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 2090:
                        st.pc = 2090;
                        if (st.v5i < 0) {
                            st.pc = 2104;
                            continue;
                        }
                    case 2091:
                        st.v5i = st.v3i + 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2092:
                        st.pc = 2092;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v16o;
                    case 2093:
                        st.v3i = st.v5i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2094:
                        st.v5i = st.v26i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2095:
                        st.pc = 2095;
                        st.pc = 2089;
                        continue;
                    case 2096:
                        st.pc = 2096;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2097:
                        st.v22i = st.v5i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 2098:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2099:
                        st.v6i = st.v26i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2100:
                        st.v11i = st.v27i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 2101:
                        st.v4i = st.v33i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 2102:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2103:
                        st.pc = 2103;
                        st.pc = 2339;
                        continue;
                    case 2104:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 2105:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2106:
                        st.pc = 2106;
                        st.pc = 1979;
                        continue;
                    case 2107:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 2108:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 2109:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2110:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 2111:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 2112:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 2113:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2114:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2115:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 2116:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2117:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 2118:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2119:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2120:
                        st.v5i = st.v14i >>> 23;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2121:
                        st.pc = 2121;
                        if (st.v5i == 0) {
                            st.pc = 2124;
                            continue;
                        }
                    case 2122:
                        st.v5o = st.v17o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2123:
                        st.pc = 2123;
                        st.pc = 2125;
                        continue;
                    case 2124:
                        st.v5o = st.v18o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2125:
                        st.pc = 2125;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v5o;
                    case 2126:
                        st.v5i = st.v14i & st.v23i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2127:
                        st.pc = 2127;
                        if (st.v5i == 0) {
                            st.pc = 2104;
                            continue;
                        }
                    case 2128:
                        st.v11i = st.v33i + 1;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 2129:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 2130:
                        st.v6o = st.v8o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2131:
                        st.pc = 2131;
                        st.pc = 1980;
                        continue;
                    case 2132:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 2133:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 2134:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2135:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 2136:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 2137:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 2138:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2139:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2140:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 2141:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2142:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 2143:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2144:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2145:
                        st.v11i = st.v33i + 1;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 2146:
                        st.pc = 2146;
                        st.v5i = ((int[]) st.v35o)[st.v11i];
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2147:
                        st.v6i = st.v5i & 63;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2148:
                        st.v10i = 39;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 2149:
                        st.pc = 2149;
                        if (st.v6i == st.v10i) {
                            st.pc = 2181;
                            continue;
                        }
                    case 2150:
                        st.pc = 2150;
                        st.v7o = null;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2151:
                        st.pc = 2151;
                        st.v8o = null;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 2152:
                        st.pc = 2152;
                        st.v8o = new java.lang.StringBuilder();
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 2153:
                        st.v9o = "EXTRAARG expected after LOADKX, got ";
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2154:
                        st.pc = 2154;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2155:
                        st.pc = 2155;
                        st.v9o = luaj.g.f1717c;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2156:
                        st.pc = 2156;
                        st.v10i = java.lang.reflect.Array.getLength(st.v9o);
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 2157:
                        st.v12i = 1;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 2158:
                        st.v10i = st.v10i - st.v12i;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 2159:
                        st.pc = 2159;
                        if (st.v6i >= st.v10i) {
                            st.pc = 2169;
                            continue;
                        }
                    case 2160:
                        st.pc = 2160;
                        st.v6o = ((java.lang.Object[]) st.v9o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2161:
                        st.pc = 2161;
                        st.pc = 2176;
                        continue;
                    case 2162:
                        st.pc = 2162;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2163:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 2164:
                        st.v3i = st.v5i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2165:
                        st.v4i = st.v11i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 2166:
                        st.v6i = st.v26i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2167:
                        st.v11i = st.v27i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 2168:
                        st.pc = 2168;
                        st.pc = 2102;
                        continue;
                    case 2169:
                        st.pc = 2169;
                        st.v9o = null;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2170:
                        st.pc = 2170;
                        st.v9o = new java.lang.StringBuilder();
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2171:
                        st.v10o = "UNKNOWN_OP_";
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 2172:
                        st.pc = 2172;
                        st.tmpO = ((java.lang.StringBuilder) st.v9o).append((java.lang.String) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2173:
                        st.pc = 2173;
                        st.tmpO = ((java.lang.StringBuilder) st.v9o).append(st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2174:
                        st.pc = 2174;
                        st.tmpO = ((java.lang.StringBuilder) st.v9o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2175:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2176:
                        st.pc = 2176;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2177:
                        st.pc = 2177;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2178:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2179:
                        st.pc = 2179;
                        st.v7o = new luaj.d((java.lang.String) st.v6o);
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2180:
                        st.pc = 2180;
                        throw (java.lang.Throwable) st.v7o;
                    case 2181:
                        st.v6i = st.v5i >>> 6;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2182:
                        st.pc = 2182;
                        st.v6o = ((java.lang.Object[]) st.v30o)[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2183:
                        st.pc = 2183;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v6o;
                    case 2184:
                        st.v23i = st.v3i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 2185:
                        st.v14i = st.v5i;
                        st.v14j = 0L;
                        st.v14o = null;
                        st.v14d = 0.0;
                    case 2186:
                        st.pc = 2186;
                        st.pc = 2130;
                        continue;
                    case 2187:
                        st.pc = 2187;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2188:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2189:
                        st.v22i = st.v3i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 2190:
                        st.pc = 2190;
                        st.pc = 925;
                        continue;
                    case 2191:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 2192:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 2193:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2194:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 2195:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 2196:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 2197:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2198:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2199:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 2200:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2201:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 2202:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2203:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2204:
                        st.v5i = st.v14i >>> 14;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2205:
                        st.pc = 2205;
                        st.v5o = ((java.lang.Object[]) st.v30o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2206:
                        st.pc = 2206;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v5o;
                    case 2207:
                        st.pc = 2207;
                        st.pc = 2104;
                        continue;
                    case 2208:
                        st.v34i = st.v4i;
                        st.v34j = 0L;
                        st.v34o = null;
                        st.v34d = 0.0;
                    case 2209:
                        st.v35o = st.v8o;
                        st.v35i = 0;
                        st.v35j = 0L;
                        st.v35d = 0.0;
                    case 2210:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2211:
                        st.v36o = st.v12o;
                        st.v36i = 0;
                        st.v36j = 0L;
                        st.v36d = 0.0;
                    case 2212:
                        st.v19o = st.v13o;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 2213:
                        st.v37o = st.v15o;
                        st.v37i = 0;
                        st.v37j = 0L;
                        st.v37d = 0.0;
                    case 2214:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2215:
                        st.v4o = st.v30o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2216:
                        st.v8o = st.v31o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 2217:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2218:
                        st.v30o = st.v9o;
                        st.v30i = 0;
                        st.v30j = 0L;
                        st.v30d = 0.0;
                    case 2219:
                        st.v7o = st.v10o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2220:
                        st.v9o = st.v25o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2221:
                        st.v5i = st.v14i >>> 23;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2222:
                        st.pc = 2222;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v5i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2223:
                        st.pc = 2223;
                        ((java.lang.Object[]) st.v2o)[st.v3i] = st.v5o;
                    case 2224:
                        st.pc = 2224;
                        st.pc = 2104;
                        continue;
                    case 2225:
                        st.v11i = st.v11i + st.v3i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 2226:
                        st.v10o = st.v7o;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 2227:
                        st.v25o = st.v9o;
                        st.v25i = 0;
                        st.v25j = 0L;
                        st.v25d = 0.0;
                    case 2228:
                        st.v22i = st.v14i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 2229:
                        st.v7o = st.v28o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2230:
                        st.v3o = st.v29o;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2231:
                        st.v9o = st.v30o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 2232:
                        st.v8o = st.v35o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 2233:
                        st.v12o = st.v36o;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 2234:
                        st.v15o = st.v37o;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 2235:
                        st.v14o = st.v13o;
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 2236:
                        st.v13o = st.v19o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2237:
                        st.v38i = st.v5i;
                        st.v38j = 0L;
                        st.v38o = null;
                        st.v38d = 0.0;
                    case 2238:
                        st.v5o = st.v4o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2239:
                        st.v4i = st.v38i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 2240:
                        st.pc = 2240;
                        st.pc = 46;
                        continue;
                    case 2241:
                        st.pc = 2241;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2242:
                        st.v4o = st.v5o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2243:
                        st.pc = 2243;
                        st.pc = 1265;
                        continue;
                    case 2244:
                        st.pc = 2244;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2245:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2246:
                        st.v13o = st.v28o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2247:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2248:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2249:
                        st.v3i = st.v22i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2250:
                        st.v22i = st.v23i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 2251:
                        st.pc = 2251;
                        st.pc = 1156;
                        continue;
                    case 2252:
                        st.pc = 2252;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2253:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2254:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2255:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2256:
                        st.pc = 2256;
                        st.pc = 1143;
                        continue;
                    case 2257:
                        st.pc = 2257;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2258:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2259:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2260:
                        st.pc = 2260;
                        st.pc = 1147;
                        continue;
                    case 2261:
                        st.pc = 2261;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2262:
                        st.v4o = st.v5o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2263:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2264:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2265:
                        st.pc = 2265;
                        st.pc = 1150;
                        continue;
                    case 2266:
                        st.pc = 2266;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2267:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2268:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2269:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2270:
                        st.pc = 2270;
                        st.pc = 2248;
                        continue;
                    case 2271:
                        st.v4o = st.v5o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2272:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2273:
                        st.v33i = st.v11i;
                        st.v33j = 0L;
                        st.v33o = null;
                        st.v33d = 0.0;
                    case 2274:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2275:
                        st.pc = 2275;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2276:
                        st.v5o = "Script thread interrupted";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2277:
                        st.pc = 2277;
                        st.v3o = new java.lang.InterruptedException((java.lang.String) st.v5o);
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2278:
                        st.pc = 2278;
                        throw (java.lang.Throwable) st.v3o;
                    case 2279:
                        st.pc = 2279;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2280:
                        st.pc = 2280;
                        st.pc = 2248;
                        continue;
                    case 2281:
                        st.pc = 2281;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2282:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2283:
                        st.v24i = st.v11i;
                        st.v24j = 0L;
                        st.v24o = null;
                        st.v24d = 0.0;
                    case 2284:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2285:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2286:
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2287:
                        st.pc = 2287;
                        st.pc = 2308;
                        continue;
                    case 2288:
                        st.pc = 2288;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2289:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2290:
                        st.v24i = st.v11i;
                        st.v24j = 0L;
                        st.v24o = null;
                        st.v24d = 0.0;
                    case 2291:
                        st.pc = 2291;
                        st.pc = 2259;
                        continue;
                    case 2292:
                        st.pc = 2292;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2293:
                        st.v4o = st.v5o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2294:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2295:
                        st.v24i = st.v11i;
                        st.v24j = 0L;
                        st.v24o = null;
                        st.v24d = 0.0;
                    case 2296:
                        st.pc = 2296;
                        st.pc = 2264;
                        continue;
                    case 2297:
                        st.pc = 2297;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2298:
                        st.v28o = st.v7o;
                        st.v28i = 0;
                        st.v28j = 0L;
                        st.v28d = 0.0;
                    case 2299:
                        st.v24i = st.v11i;
                        st.v24j = 0L;
                        st.v24o = null;
                        st.v24d = 0.0;
                    case 2300:
                        st.v13o = st.v14o;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 2301:
                        st.v5o = st.v0o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2302:
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2303:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 2304:
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2305:
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 2306:
                        st.v22i = 0;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 2307:
                        st.pc = 2307;
                        st.pc = 2339;
                        continue;
                    case 2308:
                        st.pc = 2308;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2309:
                        st.pc = 2309;
                        st.v4o = new luaj.d$a((java.lang.Throwable) st.v2o);
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2310:
                        st.pc = 2310;
                        st.v2o = ((luaj.LuaClosure) st.v1o).T;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2311:
                        st.pc = 2311;
                        st.v5o = ((luaj.LuaClosure) st.v1o).R;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2312:
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2313:
                        st.pc = 2313;
                        luaj.LuaClosure.c3((luaj.Globals) st.v2o, (luaj.d) st.v4o, (luaj.h) st.v5o, st.v3i, (java.lang.String) st.v6o);
                    case 2314:
                        st.pc = 2314;
                        throw (java.lang.Throwable) st.v4o;
                    case 2315:
                        st.pc = 2315;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2316:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2317:
                        st.pc = 2317;
                        st.pc = 2500;
                        continue;
                    case 2318:
                        st.v3o = "Interrupted closure";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2319:
                        st.pc = 2319;
                        st.tmpI = android.ext.e1.s((java.lang.String) st.v3o, (java.lang.Throwable) st.v2o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2320:
                        st.pc = 2320;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2321:
                        st.pc = 2321;
                        st.v3o = new luaj.d((java.lang.Throwable) st.v2o);
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2322:
                        st.pc = 2322;
                        throw (java.lang.Throwable) st.v3o;
                    case 2323:
                        st.pc = 2323;
                        st.tmpO = ((java.lang.Throwable) st.v2o).getMessage();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2324:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2325:
                        st.pc = 2325;
                        st.v5o = null;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2326:
                        st.pc = 2326;
                        if (st.v3o != null) {
                            st.pc = 2329;
                            continue;
                        }
                    case 2327:
                        st.v3o = "stack overflow";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2328:
                        st.pc = 2328;
                        st.pc = 2337;
                        continue;
                    case 2329:
                        st.pc = 2329;
                        st.v6o = null;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2330:
                        st.pc = 2330;
                        st.v6o = new java.lang.StringBuilder();
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2331:
                        st.v7o = "stack overflow (";
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2332:
                        st.pc = 2332;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2333:
                        st.pc = 2333;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2334:
                        st.pc = 2334;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2335:
                        st.pc = 2335;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2336:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2337:
                        st.pc = 2337;
                        st.v5o = new luaj.d$b((java.lang.String) st.v3o, (java.lang.Throwable) st.v2o);
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2338:
                        st.pc = 2338;
                        throw (java.lang.Throwable) st.v5o;
                    case 2339:
                        st.pc = 2339;
                        st.v7o = ((luaj.d) st.v5o).f1712e;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 2340:
                        st.pc = 2340;
                        if (st.v7o != null) {
                            st.pc = 2463;
                            continue;
                        }
                    case 2341:
                        st.v7i = st.v3i & 63;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 2342:
                        switch (st.v7i) {
                            case 5: st.pc = 2425; continue;
                            case 6: st.pc = 2425; continue;
                            case 7: st.pc = 2423; continue;
                            case 8: st.pc = 2421; continue;
                            case 9: st.pc = 2425; continue;
                            case 10: st.pc = 2419; continue;
                            case 11: st.pc = 2343; continue;
                            case 12: st.pc = 2423; continue;
                            case 13: st.pc = 2401; continue;
                            case 14: st.pc = 2401; continue;
                            case 15: st.pc = 2401; continue;
                            case 16: st.pc = 2401; continue;
                            case 17: st.pc = 2401; continue;
                            case 18: st.pc = 2401; continue;
                            case 19: st.pc = 2423; continue;
                            case 20: st.pc = 2423; continue;
                            case 21: st.pc = 2423; continue;
                            case 22: st.pc = 2372; continue;
                            case 23: st.pc = 2343; continue;
                            case 24: st.pc = 2343; continue;
                            case 25: st.pc = 2358; continue;
                            case 26: st.pc = 2358; continue;
                            case 27: st.pc = 2419; continue;
                            case 28: st.pc = 2423; continue;
                            case 29: st.pc = 2419; continue;
                            case 30: st.pc = 2419; continue;
                            case 31: st.pc = 2343; continue;
                            case 32: st.pc = 2343; continue;
                            case 33: st.pc = 2343; continue;
                            case 34: st.pc = 2419; continue;
                            case 35: st.pc = 2343; continue;
                            case 36: st.pc = 2419; continue;
                            case 37: st.pc = 2343; continue;
                            case 38: st.pc = 2343; continue;
                            case 39: st.pc = 2343; continue;
                            case 40: st.pc = 2401; continue;
                            case 41: st.pc = 2423; continue;
                            case 42: st.pc = 2344; continue;
                            case 43: st.pc = 2344; continue;
                            case 44: st.pc = 2344; continue;
                            case 45: st.pc = 2344; continue;
                            case 46: st.pc = 2344; continue;
                            default: st.pc = 2343; continue;
                        }
                    case 2343:
                        st.pc = 2343;
                        st.pc = 2416;
                        continue;
                    case 2344:
                        st.v3i = 255;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2345:
                        st.pc = 2345;
                        if (st.v6i > st.v3i) {
                            st.pc = 2352;
                            continue;
                        }
                    case 2346:
                        st.pc = 2346;
                        st.v3o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2347:
                        st.pc = 2347;
                        st.tmpI = (((luaj.LuaValue) st.v3o).k1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2348:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2349:
                        st.pc = 2349;
                        if (st.v3i != 0) {
                            st.pc = 2351;
                            continue;
                        }
                    case 2350:
                        st.pc = 2350;
                        st.pc = 2407;
                        continue;
                    case 2351:
                        st.v3i = 255;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2352:
                        st.pc = 2352;
                        if (st.v11i > st.v3i) {
                            st.pc = 2416;
                            continue;
                        }
                    case 2353:
                        st.pc = 2353;
                        st.v2o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2354:
                        st.pc = 2354;
                        st.tmpI = (((luaj.LuaValue) st.v2o).k1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2355:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2356:
                        st.pc = 2356;
                        if (st.v2i != 0) {
                            st.pc = 2416;
                            continue;
                        }
                    case 2357:
                        st.pc = 2357;
                        st.pc = 2414;
                        continue;
                    case 2358:
                        st.v3i = 255;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2359:
                        st.pc = 2359;
                        if (st.v6i > st.v3i) {
                            st.pc = 2366;
                            continue;
                        }
                    case 2360:
                        st.pc = 2360;
                        st.v3o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2361:
                        st.pc = 2361;
                        st.tmpI = (((luaj.LuaValue) st.v3o).n1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2362:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2363:
                        st.pc = 2363;
                        if (st.v3i != 0) {
                            st.pc = 2365;
                            continue;
                        }
                    case 2364:
                        st.pc = 2364;
                        st.pc = 2407;
                        continue;
                    case 2365:
                        st.v3i = 255;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2366:
                        st.pc = 2366;
                        if (st.v11i > st.v3i) {
                            st.pc = 2416;
                            continue;
                        }
                    case 2367:
                        st.pc = 2367;
                        st.v2o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2368:
                        st.pc = 2368;
                        st.tmpI = (((luaj.LuaValue) st.v2o).n1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2369:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2370:
                        st.pc = 2370;
                        if (st.v2i != 0) {
                            st.pc = 2416;
                            continue;
                        }
                    case 2371:
                        st.pc = 2371;
                        st.pc = 2414;
                        continue;
                    case 2372:
                        st.v6i = st.v3i >>> 23;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2373:
                        st.v3i = st.v3i >> 14;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2374:
                        st.v3i = st.v3i & 511;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2375:
                        st.v7i = 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 2376:
                        st.v6i = st.v6i + st.v7i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2377:
                        st.pc = 2377;
                        if (st.v3i <= st.v6i) {
                            st.pc = 2390;
                            continue;
                        }
                    case 2378:
                        st.pc = 2378;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2379:
                        st.pc = 2379;
                        st.tmpI = (((luaj.LuaValue) st.v6o).n1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2380:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2381:
                        st.pc = 2381;
                        if (st.v6i != 0) {
                            st.pc = 2383;
                            continue;
                        }
                    case 2382:
                        st.pc = 2382;
                        st.pc = 2414;
                        continue;
                    case 2383:
                        st.pc = 2383;
                        st.v2o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2384:
                        st.pc = 2384;
                        st.tmpI = (((luaj.LuaValue) st.v2o).n1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2385:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2386:
                        st.pc = 2386;
                        if (st.v2i != 0) {
                            st.pc = 2416;
                            continue;
                        }
                    case 2387:
                        st.v6i = st.v3i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2388:
                        st.v3i = 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2389:
                        st.pc = 2389;
                        st.pc = 2427;
                        continue;
                    case 2390:
                        st.v3i = st.v11i + 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2391:
                        st.pc = 2391;
                        st.v6o = ((java.lang.Object[]) st.v2o)[st.v3i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2392:
                        st.pc = 2392;
                        st.tmpI = (((luaj.LuaValue) st.v6o).n1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2393:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2394:
                        st.pc = 2394;
                        if (st.v6i != 0) {
                            st.pc = 2396;
                            continue;
                        }
                    case 2395:
                        st.pc = 2395;
                        st.pc = 2387;
                        continue;
                    case 2396:
                        st.pc = 2396;
                        st.v2o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2397:
                        st.pc = 2397;
                        st.tmpI = (((luaj.LuaValue) st.v2o).n1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2398:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2399:
                        st.pc = 2399;
                        if (st.v2i != 0) {
                            st.pc = 2416;
                            continue;
                        }
                        st.pc = 2400;
                        return false;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = lcY2_handler(st.pc, t);
            if (h < 0) {
                lcY2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static boolean lcY2_c2(lcY2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 2400:
                        st.pc = 2400;
                        st.pc = 2414;
                        continue;
                    case 2401:
                        st.v3i = 255;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2402:
                        st.pc = 2402;
                        if (st.v6i > st.v3i) {
                            st.pc = 2409;
                            continue;
                        }
                    case 2403:
                        st.pc = 2403;
                        st.v3o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2404:
                        st.pc = 2404;
                        st.tmpI = (((luaj.LuaValue) st.v3o).m1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2405:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2406:
                        st.pc = 2406;
                        if (st.v3i != 0) {
                            st.pc = 2408;
                            continue;
                        }
                    case 2407:
                        st.pc = 2407;
                        st.pc = 2388;
                        continue;
                    case 2408:
                        st.v3i = 255;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2409:
                        st.pc = 2409;
                        if (st.v11i > st.v3i) {
                            st.pc = 2416;
                            continue;
                        }
                    case 2410:
                        st.pc = 2410;
                        st.v2o = ((java.lang.Object[]) st.v2o)[st.v11i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2411:
                        st.pc = 2411;
                        st.tmpI = (((luaj.LuaValue) st.v2o).m1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2412:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2413:
                        st.pc = 2413;
                        if (st.v2i != 0) {
                            st.pc = 2416;
                            continue;
                        }
                    case 2414:
                        st.v6i = st.v11i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2415:
                        st.pc = 2415;
                        st.pc = 2388;
                        continue;
                    case 2416:
                        st.v3i = 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2417:
                        st.v6i = 0xffffffff;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2418:
                        st.pc = 2418;
                        st.pc = 2427;
                        continue;
                    case 2419:
                        st.v6i = st.v22i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 2420:
                        st.pc = 2420;
                        st.pc = 2388;
                        continue;
                    case 2421:
                        st.v3i = st.v22i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2422:
                        st.pc = 2422;
                        st.pc = 2417;
                        continue;
                    case 2423:
                        st.v3i = st.v3i >>> 23;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2424:
                        st.pc = 2424;
                        st.pc = 2387;
                        continue;
                    case 2425:
                        st.v3i = st.v3i >>> 23;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2426:
                        st.pc = 2426;
                        st.pc = 2417;
                        continue;
                    case 2427:
                        st.pc = 2427;
                        if (st.v3i < 0) {
                            st.pc = 2446;
                            continue;
                        }
                    case 2428:
                        st.pc = 2428;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2429:
                        st.pc = 2429;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2430:
                        st.v6o = "upvalue '";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2431:
                        st.pc = 2431;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2432:
                        st.pc = 2432;
                        st.v6o = ((luaj.LuaClosure) st.v1o).R;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2433:
                        st.pc = 2433;
                        st.v6o = ((luaj.h) st.v6o).f1728f;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2434:
                        st.pc = 2434;
                        st.v7i = java.lang.reflect.Array.getLength(st.v6o);
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 2435:
                        st.pc = 2435;
                        if (st.v3i >= st.v7i) {
                            st.pc = 2439;
                            continue;
                        }
                    case 2436:
                        st.pc = 2436;
                        st.v3o = ((java.lang.Object[]) st.v6o)[st.v3i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2437:
                        st.pc = 2437;
                        st.v3o = ((gg_f.d) st.v3o).f1565a;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2438:
                        st.pc = 2438;
                        st.pc = 2440;
                        continue;
                    case 2439:
                        st.v3o = "?";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2440:
                        st.pc = 2440;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append(st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2441:
                        st.v3o = "'";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2442:
                        st.pc = 2442;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2443:
                        st.pc = 2443;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2444:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2445:
                        st.pc = 2445;
                        st.pc = 2449;
                        continue;
                    case 2446:
                        st.pc = 2446;
                        st.v2o = ((luaj.LuaClosure) st.v1o).R;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2447:
                        st.pc = 2447;
                        st.tmpO = luaj.lib.DebugLib.f3(st.v4i, st.v6i, (luaj.h) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2448:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2449:
                        st.pc = 2449;
                        if (st.v2o == null) {
                            st.pc = 2460;
                            continue;
                        }
                    case 2450:
                        st.v3o = "method ";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2451:
                        st.pc = 2451;
                        st.tmpI = (((java.lang.String) st.v2o).startsWith((java.lang.String) st.v3o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2452:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2453:
                        st.pc = 2453;
                        if (st.v3i == 0) {
                            st.pc = 2460;
                            continue;
                        }
                    case 2454:
                        st.v3i = (st.v5o instanceof luaj.c) ? 1 : 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2455:
                        st.pc = 2455;
                        if (st.v3i == 0) {
                            st.pc = 2460;
                            continue;
                        }
                    case 2456:
                        st.pc = 2456;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2457:
                        st.pc = 2457;
                        st.v5o = (luaj.c) st.v5o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2458:
                        st.pc = 2458;
                        st.v3o = new luaj.c((luaj.c) st.v5o);
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2459:
                        st.v5o = st.v3o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 2460:
                        st.pc = 2460;
                        st.v3o = ((luaj.LuaClosure) st.v1o).T;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2461:
                        st.pc = 2461;
                        st.v6o = ((luaj.LuaClosure) st.v1o).R;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2462:
                        st.pc = 2462;
                        luaj.LuaClosure.c3((luaj.Globals) st.v3o, (luaj.d) st.v5o, (luaj.h) st.v6o, st.v4i, (java.lang.String) st.v2o);
                    case 2463:
                        st.v2i = (st.v5o instanceof luaj.d$b) ? 1 : 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2464:
                        st.pc = 2464;
                        if (st.v2i == 0) {
                            st.pc = 2499;
                            continue;
                        }
                    case 2465:
                        st.pc = 2465;
                        st.v2i = luaj.LuaClosure.Y;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2466:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2467:
                        st.pc = 2467;
                        if (st.v2i != st.v3i) {
                            st.pc = 2499;
                            continue;
                        }
                    case 2468:
                        st.pc = 2468;
                        st.tmpO = ((luaj.d) st.v5o).getCause();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2469:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2470:
                        st.pc = 2470;
                        if (st.v2o == null) {
                            st.pc = 2499;
                            continue;
                        }
                    case 2471:
                        st.pc = 2471;
                        st.tmpO = ((java.lang.Throwable) st.v2o).getMessage();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2472:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2473:
                        st.pc = 2473;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2474:
                        st.pc = 2474;
                        st.v4o = new java.lang.StringBuilder();
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2475:
                        st.v6o = "Stack overflow 1: ";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2476:
                        st.pc = 2476;
                        st.tmpO = ((java.lang.StringBuilder) st.v4o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2477:
                        st.pc = 2477;
                        st.tmpO = ((java.lang.StringBuilder) st.v4o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2478:
                        st.pc = 2478;
                        st.tmpO = ((java.lang.StringBuilder) st.v4o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2479:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2480:
                        st.pc = 2480;
                        st.tmpI = android.ext.e1.p((java.lang.String) st.v3o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2481:
                        st.v3o = "Stack overflow 2";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2482:
                        st.pc = 2482;
                        st.tmpI = android.ext.e1.s((java.lang.String) st.v3o, (java.lang.Throwable) st.v2o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2483:
                        st.pc = 2483;
                        st.pc = 2499;
                        continue;
                    case 2484:
                        st.pc = 2484;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2485:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2486:
                        st.v3o = "Stack overflow 3";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2487:
                        st.pc = 2487;
                        st.tmpI = android.ext.e1.s((java.lang.String) st.v3o, (java.lang.Throwable) st.v2o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2488:
                        st.pc = 2488;
                        st.pc = 2499;
                        continue;
                    case 2489:
                        st.pc = 2489;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2490:
                        st.pc = 2490;
                        st.v3o = new java.lang.StringBuilder();
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2491:
                        st.v4o = "Stack overflow 4: ";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2492:
                        st.pc = 2492;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2493:
                        st.pc = 2493;
                        st.tmpO = ((java.lang.Throwable) st.v2o).getMessage();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2494:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2495:
                        st.pc = 2495;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2496:
                        st.pc = 2496;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2497:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2498:
                        st.pc = 2498;
                        st.tmpI = android.ext.e1.p((java.lang.String) st.v2o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2499:
                        st.pc = 2499;
                        throw (java.lang.Throwable) st.v5o;
                    case 2500:
                        st.pc = 2500;
                        if (st.v28o == null) {
                            st.pc = 2509;
                            continue;
                        }
                    case 2501:
                        st.v11i = st.v24i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 2502:
                        st.v3i = 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2503:
                        st.v11i = st.v11i + st.v3i;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 2504:
                        st.pc = 2504;
                        if (st.v11i < 0) {
                            st.pc = 2509;
                            continue;
                        }
                    case 2505:
                        st.pc = 2505;
                        st.v4o = ((java.lang.Object[]) st.v28o)[st.v11i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2506:
                        st.pc = 2506;
                        if (st.v4o == null) {
                            st.pc = 2503;
                            continue;
                        }
                    case 2507:
                        st.pc = 2507;
                        ((luaj.i) st.v4o).a();
                    case 2508:
                        st.pc = 2508;
                        st.pc = 2503;
                        continue;
                    case 2509:
                        st.pc = 2509;
                        if (st.v13o == null) {
                            st.pc = 2512;
                            continue;
                        }
                    case 2510:
                        st.pc = 2510;
                        if (st.v42i != 0) {
                            st.pc = 2512;
                            continue;
                        }
                    case 2511:
                        st.pc = 2511;
                        ((luaj.lib.DebugLib) st.v13o).l3();
                    case 2512:
                        st.pc = 2512;
                        st.v3o = luaj.LuaValue.f1676f;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 2513:
                        st.pc = 2513;
                        ((luaj.LuaClosure) st.v1o).V = (luaj.Varargs) st.v3o;
                    case 2514:
                        st.pc = 2514;
                        st.v3i = luaj.LuaClosure.Y;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2515:
                        st.v4i = 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 2516:
                        st.v3i = st.v3i - st.v4i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2517:
                        st.pc = 2517;
                        luaj.LuaClosure.Y = st.v3i;
                    case 2518:
                        st.pc = 2518;
                        throw (java.lang.Throwable) st.v2o;
                    case 2519:
                        st.pc = 2519;
                        st.pc = 2520;
                        return false;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = lcY2_handler(st.pc, t);
            if (h < 0) {
                lcY2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] lcY2_ctypes = {
        luaj.d.class, java.lang.StackOverflowError.class, java.lang.InterruptedException.class, java.lang.NullPointerException.class
    };
    private static final int[] lcY2_handlers = {
        26, 38, 2297, 0, 26, 38, 2292, 1, 26, 38, 2288, 2, 26, 38, 2281, -1, 46, 48, 2266, 0, 46, 48, 2261, 1, 46, 48, 2257, 2, 46, 48, 2252, -1, 50, 51, 69, 0, 50, 51, 63, 1, 50, 51, 58, 2, 50, 51, 52, -1, 79, 80, 2266, 0, 79, 80, 2261, 1, 79, 80, 2257, 2, 79, 80, 2252, -1, 81, 82, 2244, 0, 81, 82, 2241, 1, 81, 82, 1260, 2, 81, 82, 1255, -1, 99, 140, 120, 0, 99, 140, 114, 1, 99, 140, 109, 2, 99, 140, 103, -1, 144, 145, 146, 0, 144, 145, 114, 1, 144, 145, 109, 2, 144, 145, 103, -1, 155, 156, 197, 0, 155, 156, 114, 1, 155, 156, 109, 2, 155, 156, 103, -1, 164, 181, 166, 0, 164, 181, 114, 1, 164, 181, 109, 2, 164, 181, 103, -1, 214, 215, 216, 0, 214, 215, 114, 1, 214, 215, 109, 2, 214, 215, 103, -1, 223, 224, 248, 0, 223, 224, 114, 1, 223, 224, 109, 2, 223, 224, 103, -1, 230, 245, 232, 0, 230, 245, 114, 1, 230, 245, 109, 2, 230, 245, 103, -1, 257, 258, 216, 0, 257, 258, 114, 1, 257, 258, 109, 2, 257, 258, 103, -1, 259, 260, 248, 0, 259, 260, 114, 1, 259, 260, 109, 2, 259, 260, 103, -1, 266, 272, 232, 0, 266, 272, 114, 1, 266, 272, 109, 2, 266, 272, 103, -1, 279, 280, 216, 0, 279, 280, 114, 1, 279, 280, 109, 2, 279, 280, 103, -1, 281, 282, 248, 0, 281, 282, 114, 1, 281, 282, 109, 2, 281, 282, 103, -1, 288, 294, 232, 0, 288, 294, 114, 1, 288, 294, 109, 2, 288, 294, 103, -1, 301, 302, 216, 0, 301, 302, 114, 1, 301, 302, 109, 2, 301, 302, 103, -1, 303, 304, 248, 0, 303, 304, 114, 1, 303, 304, 109, 2, 303, 304, 103, -1, 310, 316, 232, 0, 310, 316, 114, 1, 310, 316, 109, 2, 310, 316, 103, -1, 320, 324, 120, 0, 320, 324, 114, 1, 320, 324, 109, 2, 320, 324, 103, -1, 342, 343, 216, 0, 342, 343, 114, 1, 342, 343, 109, 2, 342, 343, 103, -1, 344, 345, 248, 0, 344, 345, 114, 1, 344, 345, 109, 2, 344, 345, 103, -1, 351, 357, 232, 0, 351, 357, 114, 1, 351, 357, 109, 2, 351, 357, 103, -1, 358, 362, 120, 0, 358, 362, 114, 1, 358, 362, 109, 2, 358, 362, 103, -1, 366, 387, 216, 0, 366, 387, 114, 1, 366, 387, 109, 2, 366, 387, 103, -1, 398, 427, 120, 0, 398, 427, 114, 1, 398, 427, 109, 2, 398, 427, 103, -1, 436, 437, 439, 0, 436, 437, 114, 1, 436, 437, 109, 2, 436, 437, 103, -1, 449, 450, 521, 0, 449, 450, 114, 1, 449, 450, 109, 2, 449, 450, 495, -1, 455, 457, 498, 0, 455, 457, 114, 1, 455, 457, 109, 2, 455, 457, 495, -1, 464, 512, 474, 0, 464, 512, 114, 1, 464, 512, 109, 2, 464, 512, 470, -1, 533, 539, 120, 0, 533, 539, 114, 1, 533, 539, 109, 2, 533, 539, 103, -1, 555, 557, 120, 0, 555, 557, 625, 1, 555, 557, 109, 2, 555, 557, 103, -1, 557, 568, 591, 3, 557, 568, 120, 0, 557, 568, 114, 1, 557, 568, 109, 2, 557, 568, 103, -1, 574, 577, 120, 0, 574, 577, 114, 1, 574, 577, 109, 2, 574, 577, 103, -1, 593, 613, 120, 0, 593, 613, 625, 1, 593, 613, 109, 2, 593, 613, 103, -1, 614, 620, 120, 0, 614, 620, 620, 1, 614, 620, 109, 2, 614, 620, 103, -1, 634, 643, 120, 0, 634, 643, 670, 1, 634, 643, 109, 2, 634, 643, 103, -1, 645, 700, 120, 0, 645, 700, 114, 1, 645, 700, 109, 2, 645, 700, 103, -1, 715, 717, 216, 0, 715, 717, 114, 1, 715, 717, 109, 2, 715, 717, 103, -1, 736, 737, 216, 0, 736, 737, 114, 1, 736, 737, 109, 2, 736, 737, 103, -1, 769, 775, 216, 0, 769, 775, 114, 1, 769, 775, 109, 2, 769, 775, 103, -1, 789, 791, 120, 0, 789, 791, 114, 1, 789, 791, 109, 2, 789, 791, 103, -1, 805, 816, 216, 0, 805, 816, 114, 1, 805, 816, 109, 2, 805, 816, 103, -1, 820, 845, 120, 0, 820, 845, 114, 1, 820, 845, 109, 2, 820, 845, 103, -1, 874, 876, 1268, 0, 874, 876, 1264, 1, 874, 876, 1260, 2, 874, 876, 1255, -1, 877, 880, 886, 3, 877, 880, 120, 0, 877, 880, 883, 1, 877, 880, 109, 2, 877, 880, 103, -1, 896, 904, 946, 3, 896, 904, 943, 0, 896, 904, 940, 1, 896, 904, 937, 2, 896, 904, 934, -1, 908, 909, 928, 3, 908, 909, 921, 0, 908, 909, 918, 1, 908, 909, 915, 2, 908, 909, 910, -1, 967, 968, 1015, -1, 973, 994, 976, -1, 996, 1012, 1001, -1, 1021, 1103, 1034, -1, 1103, 1105, 1107, -1, 1113, 1125, 1034, -1, 1130, 1131, 1174, -1, 1132, 1136, 1172, -1, 1136, 1138, 1169, -1, 1140, 1141, 1160, 3, 1140, 1141, 1152, 0, 1140, 1141, 1149, 1, 1140, 1141, 1146, 2, 1140, 1141, 1142, -1, 1177, 1184, 1179, 3, 1177, 1184, 1152, 0, 1177, 1184, 1149, 1, 1177, 1184, 1146, 2, 1177, 1184, 1142, -1, 1184, 1185, 1152, 0, 1184, 1185, 1149, 1, 1184, 1185, 1146, 2, 1184, 1185, 1142, -1, 1191, 1321, 1152, 0, 1191, 1321, 1149, 1, 1191, 1321, 1146, 2, 1191, 1321, 1142, -1, 1345, 1353, 1347, 0, 1345, 1353, 1149, 1, 1345, 1353, 1146, 2, 1345, 1353, 1142, -1, 1358, 1368, 1360, 0, 1358, 1368, 1149, 1, 1358, 1368, 1146, 2, 1358, 1368, 1142, -1, 1403, 1406, 1347, 0, 1403, 1406, 1149, 1, 1403, 1406, 1146, 2, 1403, 1406, 1142, -1, 1411, 1416, 1360, 0, 1411, 1416, 1149, 1, 1411, 1416, 1146, 2, 1411, 1416, 1142, -1, 1439, 1442, 1347, 0, 1439, 1442, 1149, 1, 1439, 1442, 1146, 2, 1439, 1442, 1142, -1, 1447, 1452, 1360, 0, 1447, 1452, 1149, 1, 1447, 1452, 1146, 2, 1447, 1452, 1142, -1, 1481, 1488, 1492, 0, 1481, 1488, 1149, 1, 1481, 1488, 1146, 2, 1481, 1488, 1489, -1, 1520, 1548, 1529, 0, 1520, 1548, 1149, 1, 1520, 1548, 1146, 2, 1520, 1548, 1142, -1, 1563, 1605, 1152, 0, 1563, 1605, 1149, 1, 1563, 1605, 1146, 2, 1563, 1605, 1142, -1, 1623, 1626, 1347, 0, 1623, 1626, 1149, 1, 1623, 1626, 1146, 2, 1623, 1626, 1142, -1, 1631, 1637, 1360, 0, 1631, 1637, 1149, 1, 1631, 1637, 1146, 2, 1631, 1637, 1142, -1, 1655, 1658, 1347, 0, 1655, 1658, 1149, 1, 1655, 1658, 1146, 2, 1655, 1658, 1142, -1, 1663, 1669, 1360, 0, 1663, 1669, 1149, 1, 1663, 1669, 1146, 2, 1663, 1669, 1142, -1, 1687, 1690, 1347, 0, 1687, 1690, 1149, 1, 1687, 1690, 1146, 2, 1687, 1690, 1142, -1, 1695, 1701, 1360, 0, 1695, 1701, 1149, 1, 1695, 1701, 1146, 2, 1695, 1701, 1142, -1, 1719, 1722, 1347, 0, 1719, 1722, 1149, 1, 1719, 1722, 1146, 2, 1719, 1722, 1142, -1, 1727, 1733, 1360, 0, 1727, 1733, 1149, 1, 1727, 1733, 1146, 2, 1727, 1733, 1142, -1, 1751, 1754, 1347, 0, 1751, 1754, 1149, 1, 1751, 1754, 1146, 2, 1751, 1754, 1142, -1, 1759, 1765, 1360, 0, 1759, 1765, 1149, 1, 1759, 1765, 1146, 2, 1759, 1765, 1142, -1, 1783, 1786, 1347, 0, 1783, 1786, 1149, 1, 1783, 1786, 1146, 2, 1783, 1786, 1142, -1, 1791, 1797, 1360, 0, 1791, 1797, 1149, 1, 1791, 1797, 1146, 2, 1791, 1797, 1142, -1, 1813, 1815, 1152, 0, 1813, 1815, 1149, 1, 1813, 1815, 1146, 2, 1813, 1815, 1142, -1, 1820, 1833, 1822, 0, 1820, 1833, 1149, 1, 1820, 1833, 1146, 2, 1820, 1833, 1142, -1, 1850, 1871, 1152, 0, 1850, 1871, 1149, 1, 1850, 1871, 1146, 2, 1850, 1871, 1142, -1, 1875, 1883, 1877, 0, 1875, 1883, 1149, 1, 1875, 1883, 1146, 2, 1875, 1883, 1142, -1, 1888, 1898, 1890, 0, 1888, 1898, 1149, 1, 1888, 1898, 1146, 2, 1888, 1898, 1142, -1, 1916, 1946, 1152, 0, 1916, 1946, 1149, 1, 1916, 1946, 1146, 2, 1916, 1946, 1142, -1, 1950, 1958, 1952, 0, 1950, 1958, 1149, 1, 1950, 1958, 1146, 2, 1950, 1958, 1142, -1, 1964, 1975, 1966, 0, 1964, 1975, 1149, 1, 1964, 1975, 1146, 2, 1964, 1975, 1142, -1, 1983, 2001, 1152, 0, 1983, 2001, 1149, 1, 1983, 2001, 1146, 2, 1983, 2001, 1142, -1, 2006, 2012, 1822, 0, 2006, 2012, 1149, 1, 2006, 2012, 1146, 2, 2006, 2012, 1142, -1, 2029, 2035, 1152, 0, 2029, 2035, 1149, 1, 2029, 2035, 1146, 2, 2029, 2035, 1142, -1, 2040, 2046, 1822, 0, 2040, 2046, 1149, 1, 2040, 2046, 1146, 2, 2040, 2046, 1142, -1, 2047, 2075, 1152, 0, 2047, 2075, 1149, 1, 2047, 2075, 1146, 2, 2047, 2075, 1142, -1, 2092, 2093, 2096, 0, 2092, 2093, 1149, 1, 2092, 2093, 1146, 2, 2092, 2093, 1142, -1, 2125, 2126, 1152, 0, 2125, 2126, 1149, 1, 2125, 2126, 1146, 2, 2125, 2126, 1142, -1, 2146, 2147, 2187, 0, 2146, 2147, 1149, 1, 2146, 2147, 1146, 2, 2146, 2147, 1489, -1, 2150, 2184, 2162, 0, 2150, 2184, 1149, 1, 2150, 2184, 1146, 2, 2150, 2184, 1489, -1, 2205, 2224, 1152, 0, 2205, 2224, 1149, 1, 2205, 2224, 1146, 2, 2205, 2224, 1142, -1, 2275, 2279, 2279, 0, 2275, 2279, 1149, 1, 2275, 2279, 1146, 2, 2275, 2279, 1142, -1, 2308, 2481, 2315, -1, 2481, 2483, 2484, -1, 2486, 2488, 2489, -1, 2489, 2500, 2315, -1
    };
    private static int lcY2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < lcY2_handlers.length; i += 4) {
            if (pc < lcY2_handlers[i] || pc >= lcY2_handlers[i + 1]) {
                continue;
            }
            int ti = lcY2_handlers[i + 3];
            if (ti < 0 || lcY2_ctypes[ti].isInstance(t)) {
                return lcY2_handlers[i + 2];
            }
        }
        return -1;
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
                luaValue = luaj.LuaValue.f1676f;
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
        luaj.LuaValue[] luaValueArrA3 = a3();
        luaj.h hVar = this.R;
        int i = hVar.j;
        if (i == 0) {
            if (hVar.k != 0) {
                varargsN2 = luaj.LuaValue.N2(luaValue, luaValue2);
            } else {
                varargsN2 = luaj.LuaValue.f1676f;
            }
            return Y2(luaValueArrA3, varargsN2, false).w();
        }
        if (i != 1) {
            luaValueArrA3[0] = luaValue;
            luaValueArrA3[1] = luaValue2;
            return Y2(luaValueArrA3, luaj.LuaValue.f1676f, false).w();
        }
        luaValueArrA3[0] = luaValue;
        if (hVar.k == 0) {
            luaValue2 = luaj.LuaValue.f1676f;
        }
        return Y2(luaValueArrA3, luaValue2, false).w();
    }

    @Override // luaj.LuaValue
    public final luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        luaj.Varargs varargsM2;
        luaj.LuaValue[] luaValueArrA3 = a3();
        luaj.h hVar = this.R;
        int i = hVar.j;
        if (i == 0) {
            varargsM2 = hVar.k == 0 ? luaj.LuaValue.f1676f : luaj.LuaValue.M2(luaValue, luaValue2, luaValue3);
            return Y2(luaValueArrA3, varargsM2, false).w();
        }
        if (i == 1) {
            luaValueArrA3[0] = luaValue;
            if (hVar.k == 0) {
                return Y2(luaValueArrA3, luaj.LuaValue.f1676f, false).w();
            }
            return Y2(luaValueArrA3, luaj.LuaValue.N2(luaValue2, luaValue3), false).w();
        }
        if (i == 2) {
            luaValueArrA3[0] = luaValue;
            luaValueArrA3[1] = luaValue2;
            if (hVar.k == 0) {
                luaValue3 = luaj.LuaValue.f1676f;
            }
            return Y2(luaValueArrA3, luaValue3, false).w();
        }
        luaValueArrA3[0] = luaValue;
        luaValueArrA3[1] = luaValue2;
        luaValueArrA3[2] = luaValue3;
        return Y2(luaValueArrA3, luaj.LuaValue.f1676f, false).w();
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
