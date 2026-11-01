package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class Script$ApiFunction extends luaj.lib.VarArgFunction {
    static java.lang.ref.WeakReference Y = new java.lang.ref.WeakReference(null);
    static java.lang.ref.WeakReference Z = new java.lang.ref.WeakReference(null);
    private static java.util.Map a0 = null;
    private static java.util.Map b0 = null;
    private static java.util.Map c0 = null;
    private static java.util.Map d0 = null;
    private java.lang.String X;
    private final boolean W = this instanceof android.ext.Script$BusyApiFunction;
    private volatile luaj.Varargs T = null;
    private volatile java.lang.Throwable U = null;
    protected volatile java.lang.Object V = new java.lang.Object();

    private static java.util.Map X2(int i) {
        java.util.HashMap map = new java.util.HashMap();
        for (int i2 = 0; i2 < 8; i2++) {
            if (((1 << i2) & i) != 0) {
                map.put(android.ext.Script.t0[i2], luaj.LuaValue.f1673c);
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0064  */
    static boolean e3(android.ext.Script$ApiFunction script$ApiFunction, java.io.Writer writer, int i, luaj.LuaValue luaValue) throws java.io.IOException {
        java.util.Map mapX2;
        if (luaValue instanceof luaj.LuaString) {
            return android.ext.Script$Consts.d(writer, luaValue.g0());
        }
        if (luaValue instanceof luaj.LuaTable) {
            if (script$ApiFunction == null || i != 1) {
                mapX2 = null;
            } else if ((script$ApiFunction instanceof android.ext.Script$removeResults) || (script$ApiFunction instanceof android.ext.Script$loadResults) || (script$ApiFunction instanceof android.ext.Script$getValues)) {
                mapX2 = a0;
                if (mapX2 == null) {
                    mapX2 = X2(5);
                    a0 = mapX2;
                }
            } else if (script$ApiFunction instanceof android.ext.Script$setValues) {
                mapX2 = b0;
                if (mapX2 == null) {
                    mapX2 = X2(7);
                    b0 = mapX2;
                }
            } else if ((script$ApiFunction instanceof android.ext.Script$getValuesRange) || (script$ApiFunction instanceof android.ext.Script$removeListItems)) {
                mapX2 = c0;
                if (mapX2 == null) {
                    mapX2 = X2(1);
                    c0 = mapX2;
                }
            } else if (script$ApiFunction instanceof android.ext.Script$addListItems) {
                mapX2 = d0;
                if (mapX2 == null) {
                    mapX2 = X2(255);
                    d0 = mapX2;
                }
            } else {
                mapX2 = null;
            }
            ((luaj.LuaTable) luaValue).E3(writer, mapX2);
        } else {
            writer.write(luaValue.g0());
        }
        return true;
    }

    private void f3(java.io.Writer writer, luaj.Varargs varargs) throws java.io.IOException {
        int iU = varargs.U();
        int iY2 = Y2();
        if (iY2 >= 0 && iU > iY2) {
            iU = iY2;
        }
        for (int i = 1; i <= iU; i++) {
            if (i != 1) {
                writer.write(", ");
            }
            if (!d3(writer, i, varargs.v(i))) {
                return;
            }
        }
    }

    protected static boolean g3(java.io.Writer writer, android.ext.Script$Const[] script$ConstArr, luaj.LuaValue luaValue) {
        return android.ext.Script$Consts.a(writer, script$ConstArr, luaValue.y2());
    }

    protected static boolean h3(java.io.Writer writer, luaj.LuaValue luaValue) {
        return android.ext.Script$Consts.b(writer, luaValue.z2());
    }

    @Override // luaj.LuaFunction
    public java.lang.String T2() {
        java.lang.String str = this.X;
        if (str != null) {
            return str;
        }
        java.lang.String strT2 = super.T2();
        this.X = strT2;
        return strT2;
    }

    protected abstract int Y2();

    protected java.lang.String Z2() {
        return null;
    }

    protected luaj.Varargs a3() {
        return luaj.LuaValue.f1674d;
    }

    public luaj.Varargs b3(luaj.Varargs varargs) {
        this.T = null;
        this.U = null;
        android.ext.Script$ApiFunction$1 script$ApiFunction$1 = new android.ext.Script$ApiFunction$1(this, varargs);
        synchronized (this.V) {
            try {
                android.ext.n2.i(script$ApiFunction$1);
                android.ext.Script.W3(this.V);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        java.lang.Throwable th2 = this.U;
        this.U = null;
        if (th2 != null) {
            this.T = null;
            if (th2 instanceof java.lang.RuntimeException) {
                throw ((java.lang.RuntimeException) th2);
            }
            throw new java.lang.RuntimeException(th2);
        }
        luaj.Varargs varargs2 = this.T;
        this.T = null;
        if (!this.W || varargs2 != null) {
            return varargs2;
        }
        java.lang.String strZ2 = Z2();
        return strZ2 == null ? a3() : luaj.LuaValue.K2(strZ2);
    }

    public luaj.Varargs c3(luaj.Varargs varargs) {
        return luaj.LuaValue.f1673c;
    }

    protected boolean d3(java.io.Writer writer, int i, luaj.LuaValue luaValue) {try {

        return e3(this, writer, i, luaValue);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    @Override // luaj.lib.LibFunction, luaj.LuaFunction, luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        java.lang.String strK3 = k3();
        java.lang.String strReplace = strK3.replace("[", "").replace("]", "").replace(" ,", ",");
        java.util.regex.Pattern pattern = (java.util.regex.Pattern) Y.get();
        if (pattern == null) {
            java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(".*(\\(.*\\)).*");
            Y = new java.lang.ref.WeakReference(patternCompile);
            pattern = patternCompile;
        }
        java.lang.String strReplaceAll = pattern.matcher(strReplace).replaceAll("$1");
        java.util.regex.Pattern pattern2 = (java.util.regex.Pattern) Z.get();
        if (pattern2 == null) {
            java.util.regex.Pattern patternCompile2 = java.util.regex.Pattern.compile("(?<=[\\(,])( ?)\\s*\\S*\\s*(\\S*)(\\s*=\\s*[^,\\)]*)?(?=[,\\)])");
            Z = new java.lang.ref.WeakReference(patternCompile2);
            pattern2 = patternCompile2;
        }
        return "function " + pattern2.matcher(strReplaceAll).replaceAll("$1$2") + " end, -- " + strK3;
    }

    protected void i3(java.io.Writer writer, luaj.Varargs varargs) throws java.io.IOException {
        if ((this instanceof android.ext.Script$isVisible) || (this instanceof android.ext.Script$internal1) || (this instanceof android.ext.Script$internal2) || (this instanceof android.ext.Script$sleep)) {
            return;
        }
        writer.write(T2());
        writer.write("(");
        f3(writer, varargs);
        writer.write(")\n");
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public final luaj.Varargs invoke(luaj.Varargs varargs) {
        java.lang.ThreadLocal threadLocal = luaj.Varargs.f1678a;
        luaj.lib.VarArgFunction varArgFunction = (luaj.lib.VarArgFunction) threadLocal.get();
        threadLocal.set(this);
        try {
            luaj.LuaValue luaValueW = varargs.w();
            if ((luaValueW instanceof luaj.LuaString) && luaValueW.W1() > 1000000) {
                varargs = luaj.LuaValue.N2(luaValueW.G0().j3(0, 1000000), varargs.e0(2));
            }
            android.ext.Script$DebugLog script$DebugLog = android.ext.Script.w0;
            if (script$DebugLog != null) {
                long jNanoTime = java.lang.System.nanoTime();
                try {
                    i3(script$DebugLog.f378a, varargs);
                } catch (java.lang.Throwable th) {
                    android.ext.e1.s("Failed write log for " + T2(), th);
                }
                luaj.Globals globals = script$DebugLog.f379b;
                globals.b0 = (int) (((long) globals.b0) + ((java.lang.System.nanoTime() - jNanoTime) / 1000000));
            }
            luaj.Varargs varargsB3 = b3(varargs);
            if (((this instanceof android.ext.Script$alert) || (this instanceof android.ext.Script$prompt) || (this instanceof android.ext.Script$choice) || (this instanceof android.ext.Script$multiChoice)) && script$DebugLog != null) {
                long jNanoTime2 = java.lang.System.nanoTime();
                try {
                    java.io.Writer writer = script$DebugLog.f378a;
                    writer.write("--[[ return: ");
                    writer.write(varargsB3 == null ? "null" : varargsB3.toString());
                    writer.write(" ]]\n");
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.s("Failed log for " + T2(), th2);
                }
                luaj.Globals globals2 = script$DebugLog.f379b;
                globals2.b0 = (int) (((long) globals2.b0) + ((java.lang.System.nanoTime() - jNanoTime2) / 1000000));
            }
            if ((this instanceof android.ext.Script$getResults) && (varargsB3 instanceof luaj.LuaTable) && script$DebugLog != null) {
                long jNanoTime3 = java.lang.System.nanoTime();
                try {
                    java.io.Writer writer2 = script$DebugLog.f378a;
                    writer2.write("--[[ count: ");
                    writer2.write(java.lang.Integer.toString(((luaj.LuaTable) varargsB3).W1()));
                    writer2.write(" ]]\n");
                } catch (java.lang.Throwable th3) {
                    android.ext.e1.s("Failed log for " + T2(), th3);
                }
                luaj.Globals globals3 = script$DebugLog.f379b;
                globals3.b0 = (int) (((long) globals3.b0) + ((java.lang.System.nanoTime() - jNanoTime3) / 1000000));
            }
            if (varargsB3 == luaj.LuaValue.f1674d && (((this instanceof android.ext.Script$searchNumber) || (this instanceof android.ext.Script$refineNumber) || (this instanceof android.ext.Script$startFuzzy) || (this instanceof android.ext.Script$searchFuzzy) || (this instanceof android.ext.Script$searchAddress) || (this instanceof android.ext.Script$refineAddress)) && script$DebugLog != null)) {
                long jNanoTime4 = java.lang.System.nanoTime();
                try {
                    java.io.Writer writer3 = script$DebugLog.f378a;
                    writer3.write("--[[ found: ");
                    writer3.write(java.lang.Long.toString(android.ext.MainService.instance.p0));
                    writer3.write(" ]]\n");
                } catch (java.lang.Throwable th4) {
                    android.ext.e1.s("Failed log for " + T2(), th4);
                }
                luaj.Globals globals4 = script$DebugLog.f379b;
                globals4.b0 = (int) (((long) globals4.b0) + ((java.lang.System.nanoTime() - jNanoTime4) / 1000000));
            }
            threadLocal.set(varArgFunction);
            return varargsB3;
        } catch (java.lang.Throwable th5_c_c_c) {
            threadLocal.set(varArgFunction);
            throw th5_c_c_c;
        }
    }

    public void j3(luaj.Varargs varargs) {
        luaj.Varargs varargsC3;
        java.lang.Throwable th = null;
        try {
            varargsC3 = c3(varargs);
            try {
                this.T = varargsC3;
            } catch (java.lang.Throwable th2) {
                th = th2;
                this.U = th;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            varargsC3 = null;
        }
        if (this.W && varargsC3 == null && th == null) {
            return;
        }
        synchronized (this.V) {
            try {
                this.V.notifyAll();
            } catch (java.lang.Throwable th4_c_c_c) {
                throw th4_c_c_c;
            }
        }
    }

    abstract java.lang.String k3();
}
