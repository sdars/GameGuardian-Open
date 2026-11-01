package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Script extends luaj.lib.TwoArgFunction implements luaj.lib.e {
    private static volatile int n0;
    private static java.lang.ref.WeakReference o0 = new java.lang.ref.WeakReference(null);
    static volatile java.util.ArrayList p0 = null;
    static volatile int q0 = 0;
    static final java.util.Map r0 = new java.util.HashMap();
    static volatile long s0 = 0;
    static final luaj.LuaString[] t0 = {luaj.LuaString.K2("address"), luaj.LuaString.K2("value"), luaj.LuaString.K2("flags"), luaj.LuaString.K2("name"), luaj.LuaString.K2("freeze"), luaj.LuaString.K2("freezeType"), luaj.LuaString.K2("freezeFrom"), luaj.LuaString.K2("freezeTo")};
    static final int[] u0 = new int[3];
    static final int[] v0 = new int[8];
    static android.ext.Script$DebugLog w0;
    final java.lang.Object U;
    final int X;
    final java.lang.String Y;
    private final byte Z;
    android.ext.Script$Consts g0;
    private java.lang.String h0;
    private java.lang.String i0;
    private java.lang.String j0;
    private java.lang.String k0;
    volatile java.lang.String l0;
    volatile android.ext.Script$SavedState m0;
    private volatile int a0 = 0;
    private volatile byte b0 = -1;
    volatile boolean c0 = true;
    byte d0 = 0;
    boolean e0 = false;
    volatile int f0 = 0;
    final luaj.Globals T = new luaj.Globals();
    final java.lang.Thread V = new android.ext.Script$ScriptThread(this);
    final android.ext.Script$Logger W = new android.ext.Script$Logger();

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = u0;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2] = luaj.LuaTable.j3(t0[i2], 3);
            i2++;
        }
        while (true) {
            int[] iArr2 = v0;
            if (i >= iArr2.length) {
                break;
            }
            iArr2[i] = luaj.LuaTable.j3(t0[i], 7);
            i++;
        }
        w0 = null;
    }

    public Script(java.io.File file, int i, java.lang.String str) {
        int i2 = n0;
        n0 = i2 + 1;
        this.Z = (byte) (i2 % 5);
        this.g0 = null;
        this.h0 = null;
        this.i0 = null;
        this.j0 = null;
        this.k0 = null;
        this.l0 = null;
        this.m0 = null;
        luaj.a.u = false;
        this.U = file;
        this.X = i;
        this.Y = str;
        u3();
    }

    public Script(java.lang.String str, int i, java.lang.String str2) {
        int i2 = n0;
        n0 = i2 + 1;
        this.Z = (byte) (i2 % 5);
        this.g0 = null;
        this.h0 = null;
        this.i0 = null;
        this.j0 = null;
        this.k0 = null;
        this.l0 = null;
        this.m0 = null;
        this.U = str;
        this.X = i;
        this.Y = str2;
        u3();
    }

    static boolean A3(java.lang.String str, java.lang.String str2) {
        java.lang.String strD = luaj.lib.d.d(str);
        java.lang.String strD2 = luaj.lib.d.d(str2);
        return strD.startsWith(strD2) && (strD.length() == strD2.length() || strD.charAt(strD2.length()) == '/');
    }

    static void B3(luaj.LuaTable luaTable, java.util.ArrayList arrayList) {
        P3(arrayList, luaTable, "TYPE_AUTO", 127);
        P3(arrayList, luaTable, "TYPE_BYTE", 1);
        P3(arrayList, luaTable, "TYPE_WORD", 2);
        P3(arrayList, luaTable, "TYPE_DWORD", 4);
        P3(arrayList, luaTable, "TYPE_XOR", 8);
        P3(arrayList, luaTable, "TYPE_FLOAT", 16);
        P3(arrayList, luaTable, "TYPE_QWORD", 32);
        P3(arrayList, luaTable, "TYPE_DOUBLE", 64);
        P3(arrayList, luaTable, "SIGN_EQUAL", 536870912);
        P3(arrayList, luaTable, "SIGN_NOT_EQUAL", 268435456);
        P3(arrayList, luaTable, "SIGN_LESS_OR_EQUAL", 134217728);
        P3(arrayList, luaTable, "SIGN_GREATER_OR_EQUAL", 67108864);
        P3(arrayList, luaTable, "SIGN_FUZZY_EQUAL", 536870912);
        P3(arrayList, luaTable, "SIGN_FUZZY_NOT_EQUAL", 268435456);
        P3(arrayList, luaTable, "SIGN_FUZZY_LESS", 134217728);
        P3(arrayList, luaTable, "SIGN_FUZZY_GREATER", 67108864);
        P3(arrayList, luaTable, "REGION_JAVA_HEAP", 2);
        P3(arrayList, luaTable, "REGION_C_HEAP", 1);
        P3(arrayList, luaTable, "REGION_C_ALLOC", 4);
        P3(arrayList, luaTable, "REGION_C_DATA", 8);
        P3(arrayList, luaTable, "REGION_C_BSS", 16);
        P3(arrayList, luaTable, "REGION_PPSSPP", 262144);
        P3(arrayList, luaTable, "REGION_ANONYMOUS", 32);
        P3(arrayList, luaTable, "REGION_JAVA", 65536);
        P3(arrayList, luaTable, "REGION_STACK", 64);
        P3(arrayList, luaTable, "REGION_ASHMEM", 524288);
        P3(arrayList, luaTable, "REGION_VIDEO", 1048576);
        P3(arrayList, luaTable, "REGION_OTHER", -2080896);
        P3(arrayList, luaTable, "REGION_BAD", 131072);
        P3(arrayList, luaTable, "REGION_CODE_APP", 16384);
        P3(arrayList, luaTable, "REGION_CODE_SYS", 32768);
        P3(arrayList, luaTable, "LOAD_VALUES_FREEZE", 3);
        P3(arrayList, luaTable, "LOAD_VALUES", 2);
        P3(arrayList, luaTable, "LOAD_APPEND", 8);
        P3(arrayList, luaTable, "SAVE_AS_TEXT", 1);
        luaTable.a2("FREEZE_NORMAL", 0);
        luaTable.a2("FREEZE_MAY_INCREASE", 1);
        luaTable.a2("FREEZE_MAY_DECREASE", 2);
        luaTable.a2("FREEZE_IN_RANGE", 3);
        luaTable.a2("PROT_NONE", 0);
        P3(arrayList, luaTable, "PROT_READ", 2);
        P3(arrayList, luaTable, "PROT_WRITE", 1);
        P3(arrayList, luaTable, "PROT_EXEC", 4);
        P3(arrayList, luaTable, "POINTER_NO", 4);
        P3(arrayList, luaTable, "POINTER_READ_ONLY", 8);
        P3(arrayList, luaTable, "POINTER_WRITABLE", 16);
        P3(arrayList, luaTable, "POINTER_EXECUTABLE", 2);
        P3(arrayList, luaTable, "POINTER_EXECUTABLE_WRITABLE", 1);
        P3(arrayList, luaTable, "DUMP_SKIP_SYSTEM_LIBS", 1);
        P3(arrayList, luaTable, "TAB_SETTINGS", 0);
        P3(arrayList, luaTable, "TAB_SEARCH", 1);
        P3(arrayList, luaTable, "TAB_SAVED_LIST", 2);
        P3(arrayList, luaTable, "TAB_MEMORY_EDITOR", 3);
        P3(arrayList, luaTable, "ASM_ARM", 4);
        P3(arrayList, luaTable, "ASM_THUMB", 5);
        P3(arrayList, luaTable, "ASM_ARM64", 6);
    }

    public static void C3(android.ext.w wVar) {
        wVar.j();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (true) {try {

            try {                if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

                int iF = wVar.f();
                if (iF == 0) {
                    break;
                } else {
                    arrayList.add(new android.ext.c(wVar.g(), wVar.h(), iF));
                }
            } catch (java.io.IOException e2) {
                android.ext.e1.l("???", e2);
                android.ext.n0.h(java.lang.Thread.currentThread(), e2, false);
            };
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        }
        p0 = arrayList;
        q0 += 100;
    }

    static java.lang.String D3(java.lang.String str) {
        return (android.ext.t1.m(str) || android.ext.t1.C(str) != 0) ? str : android.ext.t1.f(str);
    }

    static java.lang.String E3(java.lang.String str) {
        return android.ext.t1.e(str);
    }

    public static java.lang.String F3(java.lang.String str) {
        luaj.Globals globals = new luaj.Globals();
        globals.X = false;
        gg_g.h.M(globals);
        globals.t1(new luaj.lib.BaseLib());
        globals.t1(new luaj.lib.Bit32Lib());
        globals.t1(new luaj.lib.TableLib());
        globals.t1(new luaj.lib.StringLib());
        globals.t1(new luaj.lib.Utf8Lib());
        globals.t1(new luaj.lib.MathLib());
        globals.t1(new luaj.lib.OsLib());
        return globals.O3(new java.io.ByteArrayInputStream(str.getBytes()), str, "t", globals).call().g0();
    }

    static boolean G3(luaj.LuaTable luaTable, luaj.LuaValue luaValue, boolean z) {
        try {
            return luaTable.U0(luaValue).E1(z);
        } catch (luaj.d e2) {
            throw b3(luaValue, e2);
        }
    }

    static int H3(luaj.LuaTable luaTable, luaj.LuaValue luaValue, int i) {
        try {
            return luaTable.U0(luaValue).H1(i);
        } catch (luaj.d e2) {
            throw b3(luaValue, e2);
        }
    }

    static java.lang.String I3(luaj.LuaTable luaTable, luaj.LuaValue luaValue, java.lang.String str) {
        try {
            return luaTable.U0(luaValue).I1(str);
        } catch (luaj.d e2) {
            throw b3(luaValue, e2);
        }
    }

    static byte J3(byte b2) {
        j3(b2);
        return (byte) 0;
    }

    public static void K3(luaj.Globals globals) {
        luaj.LuaNil.P = null;
        luaj.LuaNumber.P = null;
        luaj.LuaBoolean.Q = null;
        luaj.LuaValue luaValueT0 = globals == null ? null : globals.T0("string");
        luaj.LuaString.U = (luaValueT0 == null || luaValueT0.l1()) ? null : luaj.LuaValue.u2(new luaj.LuaValue[]{luaj.LuaValue.l, luaValueT0});
        luaj.LuaFunction.P = null;
        luaj.LuaThread.T = null;
    }

    static int O3(byte b2) {
        return ((byte) (b2 - 20)) / 20;
    }

    private static void P3(java.util.ArrayList arrayList, luaj.LuaTable luaTable, java.lang.String str, int i) {
        luaTable.a2(str, i);
        if (arrayList != null) {
            arrayList.add(new android.ext.Script$Const("gg." + str, i));
        }
    }

    private static void Q3(int i, luaj.LuaTable luaTable, luaj.LuaString luaString, long j, long j2, int i2) {
        if (i2 == 8) {
            j2 ^= j;
        }
        if (i2 == 16) {
            luaTable.H3(i, luaString, java.lang.Float.intBitsToFloat((int) j2));
        } else if (i2 == 64) {
            luaTable.G3(i, luaString, java.lang.Double.longBitsToDouble(j2));
        } else {
            luaTable.J3(i, luaString, android.ext.i0.b(j2, android.ext.c.y(i2), false));
        }
    }

    static java.util.ArrayList S3(byte b2) {
        java.util.ArrayList arrayList;
        java.util.Map map = r0;
        synchronized (map) {
            try {
                arrayList = (java.util.ArrayList) map.get(java.lang.Byte.valueOf(b2));
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    static android.ext.c T3(android.ext.c cVar, luaj.LuaTable luaTable, byte b2, boolean z) {
        long jQ3;
        luaj.LuaString[] luaStringArr = t0;
        long jI3 = i3(luaTable, luaStringArr[0]);
        if (!z) {
            jI3 &= 4294967295L;
        }
        int iF3 = f3(g3(luaTable, luaStringArr[2]));
        if (b2 != 2) {
            luaj.LuaString luaString = luaStringArr[1];
            jQ3 = q3(jI3, luaString, luaTable.U0(luaString), iF3, b2 == 0);
        } else {
            jQ3 = 0;
        }
        long j = jQ3;
        if (cVar == null) {
            return new android.ext.c(jI3, j, iF3);
        }
        cVar.f672a = jI3;
        cVar.f673b = j;
        cVar.f674c = iF3;
        return cVar;
    }

    static android.ext.h2 U3(luaj.LuaTable luaTable, boolean z) {
        luaj.LuaString[] luaStringArr = t0;
        android.ext.h2 h2Var = new android.ext.h2();
        T3(h2Var, luaTable, (byte) 0, z);
        h2Var.l = I3(luaTable, luaStringArr[3], null);
        h2Var.m = G3(luaTable, luaStringArr[4], false);
        h2Var.d0(H3(luaTable, luaStringArr[5], 0));
        long j = h2Var.f672a;
        int i = h2Var.f674c;
        luaj.LuaString luaString = luaStringArr[6];
        h2Var.o = q3(j, luaString, luaTable.U0(luaString), i, true);
        luaj.LuaString luaString2 = luaStringArr[7];
        h2Var.p = q3(j, luaString2, luaTable.U0(luaString2), i, true);
        return h2Var;
    }

    static java.lang.String V3(java.lang.Throwable th) {
        if (th instanceof android.ext.t1$a) {
            ((android.ext.t1$a) th).d();
        }
        return th.toString();
    }

    static void W3(java.lang.Object obj) {
        try {
            obj.wait();
        } catch (java.lang.InterruptedException e2) {
            android.ext.e1.s("Interrupted wait", e2);
            java.lang.Thread.currentThread().interrupt();
            throw new luaj.d(e2);
        }
    }

    public static void Y2(long j) {
        s0 = j;
    }

    private static luaj.d b3(luaj.LuaValue luaValue, luaj.d dVar) {
        java.lang.String message = dVar.getMessage();
        if (message.indexOf("bad argument:") != 0) {
            return dVar;
        }
        return new luaj.d("bad argument for key '" + luaValue.g0() + "':" + message.substring(13));
    }

    public static void d3(byte b2, java.util.ArrayList arrayList) {
        java.util.Map map = r0;
        synchronized (map) {
            try {
                map.put(java.lang.Byte.valueOf(b2), arrayList);
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    static int e3(int i) {
        if (i == 67108864 || i == 134217728 || i == 268435456 || i == 536870912) {
            return i;
        }
        throw new luaj.d("Unknown sign: " + i + ". The sign must be one of the constants gg.SIGN_*.");
    }

    static int f3(int i) {
        if (i != 0 && (i & (-128)) == 0) {
            return i;
        }
        throw new luaj.d("Unknown type: " + i + ". The type must be one of the constants gg.TYPE_*.");
    }

    static int g3(luaj.LuaTable luaTable, luaj.LuaValue luaValue) {
        try {
            return luaTable.U0(luaValue).A0();
        } catch (luaj.d e2) {
            throw b3(luaValue, e2);
        }
    }

    static java.lang.String h3(luaj.LuaTable luaTable, luaj.LuaValue luaValue) {
        try {
            return luaTable.U0(luaValue).B0();
        } catch (luaj.d e2) {
            throw b3(luaValue, e2);
        }
    }

    static long i3(luaj.LuaTable luaTable, luaj.LuaValue luaValue) {
        try {
            return luaTable.g3(luaValue);
        } catch (luaj.d e2) {
            throw b3(luaValue, e2);
        }
    }

    static java.util.ArrayList j3(byte b2) {
        java.util.ArrayList arrayList;
        java.util.Map map = r0;
        synchronized (map) {
            try {
                arrayList = (java.util.ArrayList) map.remove(java.lang.Byte.valueOf(b2));
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    static void l3(int i) {
        java.util.Map map = r0;
        synchronized (map) {
            try {
                java.util.Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    if (O3(((java.lang.Byte) it.next()).byteValue()) == i) {
                        it.remove();
                    }
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    static luaj.d m3(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, java.lang.Throwable th) {
        return new luaj.d("Failed parse item " + luaValue2.g0() + " on key '" + luaValue.g0() + "': " + th.getMessage(), th);
    }

    static luaj.LuaTable n3(int[] iArr, android.ext.c cVar) {
        if (iArr == null) {
            iArr = u0;
        }
        int length = iArr.length;
        luaj.LuaString[] luaStringArr = t0;
        luaj.LuaTable luaTable = new luaj.LuaTable(0, length);
        long j = cVar.f672a;
        int i = cVar.f674c;
        luaTable.J3(iArr[0], luaStringArr[0], j);
        Q3(iArr[1], luaTable, luaStringArr[1], j, cVar.f673b, i);
        luaTable.I3(iArr[2], luaStringArr[2], i);
        return luaTable;
    }

    static luaj.LuaTable o3(android.ext.h2 h2Var) {
        luaj.LuaString[] luaStringArr = t0;
        int[] iArr = v0;
        luaj.LuaTable luaTableN3 = n3(iArr, h2Var);
        java.lang.String str = h2Var.l;
        if (str != null) {
            luaTableN3.m3(luaStringArr[3], luaj.LuaValue.K2(str));
        }
        luaTableN3.K3(iArr[4], luaStringArr[4], h2Var.m);
        luaTableN3.I3(iArr[5], luaStringArr[5], h2Var.n);
        long j = h2Var.f672a;
        int i = h2Var.f674c;
        long j2 = h2Var.o;
        if (j2 != 0 || h2Var.p != 0) {
            Q3(iArr[6], luaTableN3, luaStringArr[6], j, j2, i);
            Q3(iArr[7], luaTableN3, luaStringArr[7], j, h2Var.p, i);
        }
        return luaTableN3;
    }

    public static android.ext.Script$Consts p3(java.util.ArrayList arrayList) {
        android.ext.Script$Consts script$Consts = (android.ext.Script$Consts) o0.get();
        if (script$Consts != null) {
            return script$Consts;
        }
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
            B3(new luaj.LuaTable(0, 64), arrayList);
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        java.util.ArrayList arrayList5 = new java.util.ArrayList();
        java.util.ArrayList arrayList6 = new java.util.ArrayList();
        java.util.ArrayList arrayList7 = new java.util.ArrayList();
        java.util.ArrayList arrayList8 = new java.util.ArrayList();
        java.util.ArrayList arrayList9 = new java.util.ArrayList();
        java.util.ArrayList arrayList10 = new java.util.ArrayList();
        java.util.ArrayList arrayList11 = new java.util.ArrayList();
        for (android.ext.Script$Const script$Const : (java.util.Collection<android.ext.Script$Const>) arrayList) {
            java.lang.String str = script$Const.f369a;
            if (str.startsWith("gg.REGION_")) {
                arrayList2.add(script$Const);
            } else if (str.startsWith("gg.TYPE_")) {
                arrayList3.add(script$Const);
            } else if (str.startsWith("gg.SIGN_FUZZY_")) {
                arrayList4.add(script$Const);
            } else if (str.startsWith("gg.SIGN_")) {
                arrayList5.add(script$Const);
            } else if (str.startsWith("gg.LOAD_")) {
                arrayList6.add(script$Const);
            } else if (str.startsWith("gg.SAVE_")) {
                arrayList7.add(script$Const);
            } else if (str.startsWith("gg.PROT_")) {
                arrayList8.add(script$Const);
            } else if (str.startsWith("gg.POINTER_")) {
                arrayList9.add(script$Const);
            } else if (str.startsWith("gg.DUMP_")) {
                arrayList10.add(script$Const);
            } else if (str.startsWith("gg.ASM_")) {
                arrayList11.add(script$Const);
            }
        }
        android.ext.Script$Consts script$Consts2 = new android.ext.Script$Consts();
        script$Consts2.f371a = (android.ext.Script$Const[]) arrayList2.toArray(new android.ext.Script$Const[arrayList2.size()]);
        script$Consts2.f372b = (android.ext.Script$Const[]) arrayList3.toArray(new android.ext.Script$Const[arrayList3.size()]);
        script$Consts2.f373c = (android.ext.Script$Const[]) arrayList4.toArray(new android.ext.Script$Const[arrayList4.size()]);
        script$Consts2.f374d = (android.ext.Script$Const[]) arrayList5.toArray(new android.ext.Script$Const[arrayList5.size()]);
        script$Consts2.f375e = (android.ext.Script$Const[]) arrayList6.toArray(new android.ext.Script$Const[arrayList6.size()]);
        script$Consts2.f376f = (android.ext.Script$Const[]) arrayList7.toArray(new android.ext.Script$Const[arrayList7.size()]);
        script$Consts2.f377g = (android.ext.Script$Const[]) arrayList8.toArray(new android.ext.Script$Const[arrayList8.size()]);
        script$Consts2.h = (android.ext.Script$Const[]) arrayList9.toArray(new android.ext.Script$Const[arrayList9.size()]);
        script$Consts2.i = (android.ext.Script$Const[]) arrayList10.toArray(new android.ext.Script$Const[arrayList10.size()]);
        script$Consts2.j = (android.ext.Script$Const[]) arrayList11.toArray(new android.ext.Script$Const[arrayList11.size()]);
        o0 = new java.lang.ref.WeakReference(script$Consts2);
        return script$Consts2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [luaj.LuaValue] */
    /* JADX WARN: Type inference failed for: r6v1, types: [luaj.LuaValue] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.String] */
    private static long q3(long j, luaj.LuaValue luaValue, luaj.LuaValue luaValue2, int i, boolean z) {
        long jDoubleToRawLongBits;
        if (luaValue2 instanceof luaj.LuaLong) {
            long jZ2 = luaValue2.z2();
            if (i == 16) {
                jZ2 = java.lang.Float.floatToRawIntBits(jZ2);
            } else if (i == 64) {
                jZ2 = java.lang.Double.doubleToRawLongBits(jZ2);
            }
            return i == 8 ? jZ2 ^ j : jZ2;
        }
        if (luaValue2 instanceof luaj.LuaDouble) {
            double dX2 = luaValue2.x2();
            if (i == 16) {
                jDoubleToRawLongBits = java.lang.Float.floatToRawIntBits((float) dX2);
            } else {
                jDoubleToRawLongBits = i == 64 ? java.lang.Double.doubleToRawLongBits(dX2) : (long) dX2;
            }
            return i == 8 ? j ^ jDoubleToRawLongBits : jDoubleToRawLongBits;
        }
        try {
            java.lang.String strB0 = z ? luaValue2.I1(null) : luaValue2.B0();
            if (strB0 == null) {
                return 0L;
            }
            java.lang.String strD3 = D3(strB0);
            android.ext.i2$c i2_cX = android.ext.i2.x(strD3, false);
            if (i2_cX != null) {
                strD3 = i2_cX.f1017a;
            }
            return android.ext.c.e(j, strD3, i);
        } catch (luaj.d e2) {
            throw b3(luaValue, e2);
        }
    }

    static java.util.ArrayList r3(luaj.Varargs varargs) {
        luaj.LuaTable luaTableI = varargs.I(1);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        boolean z = z1_d != null ? z1_d.n : false;
        luaj.LuaTable$i luaTable$iS3 = luaTableI.s3();
        while (luaTable$iS3.c()) {
            android.ext.c cVarT3 = T3(null, luaTable$iS3.d().H0(), (byte) 2, z);
            cVarT3.f674c &= 127;
            arrayList.add(cVarT3);
        }
        return arrayList;
    }

    static java.lang.String s3(java.io.File file) {
        try {
            return file.getCanonicalPath();
        } catch (java.io.IOException unused) {
            return file.getAbsolutePath();
        }
    }

    private void u3() {
        luaj.Globals globals = this.T;
        globals.Z = this;
        luaj.a.c(globals);
        gg_g.h.M(globals);
        globals.t1(new luaj.lib.BaseLib());
        globals.t1(new luaj.lib.PackageLib());
        globals.t1(new luaj.lib.Bit32Lib());
        globals.t1(new luaj.lib.TableLib());
        globals.t1(new luaj.lib.StringLib());
        globals.t1(new luaj.lib.Utf8Lib());
        globals.t1(new luaj.lib.MathLib());
        globals.t1(new android.ext.Script$IoLibSafe(this));
        globals.t1(new android.ext.Script$OsLibSafe(this));
        globals.t1(new luaj.lib.DebugLib());
        v3();
    }

    private void v3() {
        luaj.Globals globals = this.T;
        globals.c0 = new android.ext.Script$ScriptPrintStream(this, false);
        globals.d0 = new android.ext.Script$ScriptPrintStream(this, true);
        globals.t1(this);
    }

    void L3() {
        android.ext.Script$SavedState script$SavedState = this.m0;
        if (script$SavedState == null) {
            return;
        }
        android.ext.n2.i(new android.ext.Script$1(this, script$SavedState));
    }

    void M3() throws java.io.IOException {
        luaj.LuaValue luaValueO3;
        java.lang.String name;
        java.io.BufferedWriter bufferedWriter;
        java.lang.Object obj = this.U;
        if (obj instanceof java.io.File) {
            java.io.File file = (java.io.File) obj;
            if (!file.exists()) {
                throw new java.io.FileNotFoundException("File not found: " + file);
            }
            this.T.T3(file.getParentFile().getAbsolutePath());
            java.lang.String absolutePath = file.getAbsolutePath();
            luaj.lib.BaseLib$b baseLib$b = new luaj.lib.BaseLib$b(new java.io.FileInputStream(file));
            try {
                try {
                    luaValueO3 = this.T.O3(baseLib$b, '@' + absolutePath, "bt", this.T);
                    if (luaValueO3 instanceof luaj.LuaClosure) {
                        ((luaj.LuaClosure) luaValueO3).U = absolutePath;
                    }
                    baseLib$b.close();
                    if ((luaValueO3 instanceof luaj.LuaClosure) && (((luaj.LuaClosure) luaValueO3).R instanceof lasm.b)) {
                        java.lang.String str = file.getAbsolutePath() + '.' + android.ext.t2.h(java.lang.System.currentTimeMillis() - 1546300800000L) + ".lua";
                        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(str), 65536);
                        try {
                            gg_g.b.a(((luaj.LuaClosure) luaValueO3).R, bufferedOutputStream, false, false);
                            java.io.File file2 = new java.io.File(file.getAbsolutePath() + ".tail");
                            if (file2.exists()) {
                                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file2);
                                byte[] bArr = new byte[65536];
                                while (true) {
                                    int i = fileInputStream.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    } else {
                                        bufferedOutputStream.write(bArr, 0, i);
                                    }
                                }
                                fileInputStream.close();
                            }
                            bufferedOutputStream.close();
                            Z2(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.assembled) + ":\n" + str);
                            return;
                        } catch (java.lang.Throwable th) {
                            bufferedOutputStream.close();
                            throw th;
                        }
                    }
                    name = file.getName();
                } catch (java.lang.Exception e2) {
                    throw new luaj.d("load " + absolutePath + ": " + e2, e2);
                }
            } catch (java.lang.Throwable th2) {
                baseLib$b.close();
                throw th2;
            }
        } else {
            java.lang.String string = obj.toString();
            luaValueO3 = this.T.O3(new java.io.ByteArrayInputStream(string.getBytes()), string, "t", this.T);
            name = "string";
        }
        java.lang.String str2 = name + '_' + android.ext.t2.h(java.lang.System.currentTimeMillis() - 1546300800000L) + '_' + android.ext.t2.g(android.ext.Tools.f489a.nextInt());
        if ((this.X & 1) != 0) {
            luaj.LuaClosure luaClosureW0 = luaValueO3.w0();
            java.lang.String str3 = this.Y + '/' + str2 + ".lasm";
            java.io.PrintStream printStream = luaj.g.f1716b;
            try {
                luaj.g.f1716b = new java.io.PrintStream(str3);
                luaj.g.A(luaClosureW0.R);
                luaj.g.f1716b.close();
                luaj.g.M(luaClosureW0, str3 + ".tail");
            } catch (java.lang.Throwable th3) {
                android.ext.e1.l("Failed disassemble " + luaClosureW0 + " into '" + str3 + '\'', th3);
            }
            luaj.g.f1716b = printStream;
        }
        if ((this.X & 2) != 0) {
            this.T.g0.c3(this.Y + '/' + str2);
        }
        if ((this.X & 4) != 0) {
            try {
                bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.Y + '/' + str2 + ".log.txt")), 65536);
            } catch (java.lang.Throwable th4) {
                android.ext.e1.s("Failed open log file", th4);
                bufferedWriter = null;
            }
        } else {
            bufferedWriter = null;
        }
        w0 = bufferedWriter == null ? null : new android.ext.Script$DebugLog(bufferedWriter, this.T);
        java.io.PrintStream printStream2 = luaj.g.f1716b;
        try {
            luaj.Globals globals = this.T;
            luaj.g.f1716b = globals.c0;
            K3(globals);
            luaValueO3.call();
            luaj.g.f1716b = printStream2;
            if (bufferedWriter != null) {
                w0 = null;
                try {
                    bufferedWriter.close();
                } catch (java.lang.Throwable th5) {
                    android.ext.e1.s("Failed close log", th5);
                }
            }
            if ((this.X & 2) != 0) {
                this.T.g0.Z2();
            }
            K3(null);
        } catch (java.lang.Throwable th6) {
            luaj.g.f1716b = printStream2;
            if (bufferedWriter != null) {
                w0 = null;
                try {
                    bufferedWriter.close();
                } catch (java.lang.Throwable th7) {
                    android.ext.e1.s("Failed close log", th7);
                }
            }
            if ((this.X & 2) != 0) {
                this.T.g0.Z2();
            }
            K3(null);
            throw th6;
        }
    }

    void N3() {
        android.ext.Script$SavedState script$SavedState = new android.ext.Script$SavedState(null);
        script$SavedState.f389a = android.ext.Config.i;
        this.m0 = script$SavedState;
    }

    public android.ext.Script R3() {
        this.V.start();
        return this;
    }

    void Z2(java.lang.String str) {
        this.W.a("\n");
        this.W.a(str);
        this.W.a("\n");
    }

    void a3(boolean z, java.lang.String str) {
        if (z) {
            this.W.a("err: ");
        }
        this.W.a(str);
        this.W.a("\n");
    }

    public void c3(byte b2, java.lang.String str) {
        java.lang.String str2;
        byte b3 = (byte) (b2 - 20);
        byte b4 = (byte) (b3 / 20);
        byte b5 = (byte) (b3 % 20);
        if (this.Z != b4) {
            str2 = "callNotify id mismatch: " + ((int) this.Z) + " != " + ((int) b4) + "; " + ((int) b5) + "; " + ((int) b2) + "; " + str;
        } else {
            byte b6 = this.b0;
            if (b6 == b5) {
                synchronized (this) {
                    try {
                        b6 = this.b0;
                        if (b6 == b5) {
                            this.l0 = str;
                            notifyAll();
                            return;
                        }
                    } catch (java.lang.Throwable th) {
                        throw th;
                    }
                }
            }
            str2 = "callNotify seq mismatch: " + ((int) b6) + " != " + ((int) b5) + "; " + ((int) b4) + "; " + ((int) b2) + "; " + str;
        }
        android.ext.e1.d(str2);
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        android.content.Context contextF0 = android.ext.Tools.f0();
        java.util.ArrayList arrayList = (this.X & 4) != 0 ? new java.util.ArrayList() : null;
        luaj.LuaTable luaTable = new luaj.LuaTable(0, 128);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("");
        float f2 = 1;
        sb.append((108.3f * f2) - 6.9f);
        luaTable.b2("VERSION", sb.toString());
        luaTable.a2("VERSION_INT", android.ext.h0.d());
        luaTable.a2("BUILD", (int) (((f2 * 16409.7f) - 254.7f) + 0.5f));
        luaTable.b2("PACKAGE", android.ext.Tools.C0());
        luaTable.a2("ANDROID_SDK_INT", android.os.Build.VERSION.SDK_INT);
        luaTable.b2("FILES_DIR", android.ext.Tools.p0().getAbsolutePath());
        luaTable.b2("CACHE_DIR", android.ext.Tools.b0().getAbsolutePath());
        try {
            luaTable.b2("EXT_FILES_DIR", contextF0.getExternalFilesDir(null).getAbsolutePath());
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed set EXT_FILES_DIR for script", th);
            luaTable.b2("EXT_FILES_DIR", android.ext.Tools.p0().getAbsolutePath());
        }
        try {
            luaTable.b2("EXT_CACHE_DIR", contextF0.getExternalCacheDir().getAbsolutePath());
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Failed set EXT_CACHE_DIR for script", th2);
            luaTable.b2("EXT_CACHE_DIR", android.ext.Tools.b0().getAbsolutePath());
        }
        luaTable.b2("EXT_STORAGE", android.ext.Tools.K0());
        B3(luaTable, arrayList);
        luaTable.c2("require", new android.ext.Script$require(this));
        luaTable.c2("toast", new android.ext.Script$toast());
        luaTable.c2("alert", new android.ext.Script$alert());
        luaTable.c2("prompt", new android.ext.Script$prompt(this));
        luaTable.c2("choice", new android.ext.Script$choice());
        luaTable.c2("multiChoice", new android.ext.Script$multiChoice());
        luaTable.c2("isVisible", new android.ext.Script$isVisible());
        luaTable.c2("setVisible", new android.ext.Script$setVisible(this));
        luaTable.c2("getActiveTab", new android.ext.Script$getActiveTab());
        luaTable.c2("showUiButton", new android.ext.Script$showUiButton(this));
        luaTable.c2("hideUiButton", new android.ext.Script$hideUiButton(this));
        luaTable.c2("isClickedUiButton", new android.ext.Script$isClickedUiButton());
        android.ext.Script$getTargetPackage script$getTargetPackage = new android.ext.Script$getTargetPackage();
        luaTable.c2("getTargetPackage", script$getTargetPackage);
        luaTable.c2("getTargetInfo", new android.ext.Script$getTargetInfo());
        luaTable.c2("isPackageInstalled", new android.ext.Script$isPackageInstalled());
        luaTable.c2("processKill", new android.ext.Script$processKill(this));
        luaTable.c2("saveVariable", new android.ext.Script$saveVariable(this));
        luaTable.c2("makeRequest", new android.ext.Script$makeRequest(this));
        android.ext.Script$getResultsCount script$getResultsCount = new android.ext.Script$getResultsCount();
        luaTable.c2("getResultsCount", script$getResultsCount);
        luaTable.c2("getResults", new android.ext.Script$getResults(this));
        luaTable.c2("editAll", new android.ext.Script$editAll(this));
        luaTable.c2("clearResults", new android.ext.Script$clearResults(this));
        luaTable.c2("removeResults", new android.ext.Script$removeResults(this));
        luaTable.c2("loadResults", new android.ext.Script$loadResults(this));
        luaTable.c2("getSelectedResults", new android.ext.Script$getSelectedResults(this));
        luaTable.c2("setValues", new android.ext.Script$setValues(this));
        luaTable.c2("getValues", new android.ext.Script$getValues(this));
        luaTable.c2("getValuesRange", new android.ext.Script$getValuesRange(this));
        luaTable.c2("processPause", new android.ext.Script$processPause(this));
        luaTable.c2("processResume", new android.ext.Script$processResume(this));
        luaTable.c2("processToggle", new android.ext.Script$processToggle(this));
        luaTable.c2("isProcessPaused", new android.ext.Script$isProcessPaused());
        luaTable.c2("timeJump", new android.ext.Script$timeJump(this));
        luaTable.c2("setSpeed", new android.ext.Script$setSpeed(this));
        luaTable.c2("getSpeed", new android.ext.Script$getSpeed());
        luaTable.c2("unrandomizer", new android.ext.Script$unrandomizer(this));
        luaTable.c2("gotoAddress", new android.ext.Script$gotoAddress());
        luaTable.c2("getSelectedElements", new android.ext.Script$getSelectedElements(this));
        luaTable.c2("getRanges", new android.ext.Script$getRanges());
        luaTable.c2("setRanges", new android.ext.Script$setRanges(this));
        luaTable.c2("copyMemory", new android.ext.Script$copyMemory(this));
        luaTable.c2("dumpMemory", new android.ext.Script$dumpMemory(this));
        luaTable.c2("loadList", new android.ext.Script$loadList(this));
        luaTable.c2("saveList", new android.ext.Script$saveList(this));
        luaTable.c2("clearList", new android.ext.Script$clearList(this));
        luaTable.c2("addListItems", new android.ext.Script$addListItems(this));
        luaTable.c2("getListItems", new android.ext.Script$getListItems(this));
        luaTable.c2("removeListItems", new android.ext.Script$removeListItems(this));
        luaTable.c2("getSelectedListItems", new android.ext.Script$getSelectedListItems(this));
        luaTable.c2("searchNumber", new android.ext.Script$searchNumber(this));
        luaTable.c2("refineNumber", new android.ext.Script$refineNumber(this));
        luaTable.c2("searchAddress", new android.ext.Script$searchAddress(this));
        luaTable.c2("refineAddress", new android.ext.Script$refineAddress(this));
        luaTable.c2("startFuzzy", new android.ext.Script$startFuzzy(this));
        luaTable.c2("searchFuzzy", new android.ext.Script$searchFuzzy(this));
        android.ext.Script$searchPointer script$searchPointer = new android.ext.Script$searchPointer(this);
        luaTable.c2("searchPointer", script$searchPointer);
        luaTable.c2("sleep", new android.ext.Script$sleep());
        luaTable.c2("copyText", new android.ext.Script$copyText());
        luaTable.c2("disasm", new android.ext.Script$disasm(this));
        luaTable.c2("getLine", new android.ext.Script$getLine(this));
        luaTable.c2("getFile", new android.ext.Script$getFile(this));
        luaTable.c2("bytes", new android.ext.Script$bytes(this));
        luaTable.c2("skipRestoreState", new android.ext.Script$skipRestoreState(this));
        luaTable.c2("getRangesList", new android.ext.Script$getRangesList(this));
        luaTable.c2("allocatePage", new android.ext.Script$allocatePage(this));
        luaTable.c2("getLocale", new android.ext.Script$getLocale(this));
        luaTable.c2("numberToLocale", new android.ext.Script$numberToLocale(this));
        luaTable.c2("numberFromLocale", new android.ext.Script$numberFromLocale(this));
        luaTable.d2(luaj.LuaValue.K2("SIGN_INEQUAL").h3(), luaj.LuaValue.I2(268435456L));
        luaTable.d2(luaj.LuaValue.K2("SIGN_SMALLER").h3(), luaj.LuaValue.I2(134217728L));
        luaTable.d2(luaj.LuaValue.K2("SIGN_LARGER").h3(), luaj.LuaValue.I2(67108864L));
        luaTable.d2(luaj.LuaValue.K2("getSelectedPackage").h3(), script$getTargetPackage);
        luaTable.d2(luaj.LuaValue.K2("getResultCount").h3(), script$getResultsCount);
        luaTable.d2(luaj.LuaValue.K2("internal1").h3(), new android.ext.Script$internal1(this));
        luaTable.d2(luaj.LuaValue.K2("internal2").h3(), new android.ext.Script$internal2(this));
        luaTable.d2(luaj.LuaValue.K2("internal3").h3(), script$searchPointer);
        luaValue2.i2("gg", luaTable);
        luaValue2.T0("package").T0("loaded").i2("gg", luaTable);
        luaj.LuaValue luaValueT0 = luaValue2.T0("os");
        luaValueT0.i2("exit", new android.ext.Script$exit());
        luaValueT0.i2("remove", new android.ext.Script$wrap(this, "os.remove", luaValueT0.T0("remove"), 1));
        luaValueT0.i2("rename", new android.ext.Script$wrap(this, "os.rename", luaValueT0.T0("rename"), 2));
        luaValueT0.i2("tmpname", new android.ext.Script$wrap(this, "os.tmpname", luaValueT0.T0("tmpname"), 0));
        luaj.LuaValue luaValueT1 = luaValue2.T0("string");
        luaValueT1.i2("format", new android.ext.Script$format(luaValueT1.T0("format")));
        luaValueT1.i2("dump", new android.ext.Script$wrap(this, "string.dump", luaValueT1.T0("dump"), 1));
        luaj.LuaValue luaValueT2 = luaValue2.T0("io");
        luaValueT2.i2("open", new android.ext.Script$wrap(this, "io.open", luaValueT2.T0("open"), 2));
        luaValueT2.i2("input", new android.ext.Script$wrap(this, "io.input", luaValueT2.T0("input"), 1));
        luaValueT2.i2("output", new android.ext.Script$wrap(this, "io.output", luaValueT2.T0("output"), 1));
        luaValueT2.i2("tmpfile", new android.ext.Script$wrap(this, "io.tmpfile", luaValueT2.T0("tmpfile"), 0));
        luaValueT2.i2("lines", new android.ext.Script$wrap(this, "io.lines", luaValueT2.T0("lines"), 1));
        luaj.LuaValue luaValueT3 = luaValue2.T0("debug");
        luaValueT3.i2("debug", new android.ext.Script$wrap(this, "debug.debug", luaValueT3.T0("debug"), 0));
        luaValueT3.i2("gethook", new android.ext.Script$wrap(this, "debug.gethook", luaValueT3.T0("gethook"), 1));
        luaValueT3.i2("getinfo", new android.ext.Script$wrap(this, "debug.getinfo", luaValueT3.T0("getinfo"), 3));
        luaValueT3.i2("getlocal", new android.ext.Script$wrap(this, "debug.getlocal", luaValueT3.T0("getlocal"), 3));
        luaValueT3.i2("getmetatable", new android.ext.Script$wrap(this, "debug.getmetatable", luaValueT3.T0("getmetatable"), 1));
        luaValueT3.i2("getregistry", new android.ext.Script$wrap(this, "debug.getregistry", luaValueT3.T0("getregistry"), 0));
        luaValueT3.i2("getupvalue", new android.ext.Script$wrap(this, "debug.getupvalue", luaValueT3.T0("getupvalue"), 2));
        luaValueT3.i2("getuservalue", new android.ext.Script$wrap(this, "debug.getuservalue", luaValueT3.T0("getuservalue"), 1));
        luaValueT3.i2("sethook", new android.ext.Script$wrap(this, "debug.sethook", luaValueT3.T0("sethook"), 4));
        luaValueT3.i2("setlocal", new android.ext.Script$wrap(this, "debug.setlocal", luaValueT3.T0("setlocal"), 4));
        luaValueT3.i2("setmetatable", new android.ext.Script$wrap(this, "debug.setmetatable", luaValueT3.T0("setmetatable"), 2));
        luaValueT3.i2("setupvalue", new android.ext.Script$wrap(this, "debug.setupvalue", luaValueT3.T0("setupvalue"), 3));
        luaValueT3.i2("setuservalue", new android.ext.Script$wrap(this, "debug.setuservalue", luaValueT3.T0("setuservalue"), 2));
        luaValueT3.i2("traceback", new android.ext.Script$wrap(this, "debug.traceback", luaValueT3.T0("traceback"), 3));
        luaValueT3.i2("upvalueid", new android.ext.Script$wrap(this, "debug.upvalueid", luaValueT3.T0("upvalueid"), 2));
        luaValueT3.i2("upvaluejoin", new android.ext.Script$wrap(this, "debug.upvaluejoin", luaValueT3.T0("upvaluejoin"), 4));
        this.g0 = arrayList != null ? p3(arrayList) : new android.ext.Script$Consts();
        return luaTable;
    }

    void k3() {
        l3(this.Z);
    }

    @Override // luaj.lib.e
    public boolean m(java.lang.String str, boolean z) {
        java.lang.String strS3 = s3(new java.io.File(str));
        java.lang.String strS4 = this.i0;
        if (strS4 == null) {
            strS4 = s3(android.ext.Tools.q0());
            this.i0 = strS4;
        }
        if (A3(strS3, strS4)) {
            return true;
        }
        java.lang.String strS5 = this.j0;
        if (strS5 == null) {
            strS5 = s3(android.ext.Tools.c0());
            this.j0 = strS5;
        }
        if (A3(strS3, strS5)) {
            return true;
        }
        java.lang.String strS6 = this.k0;
        if (strS6 == null) {
            strS6 = s3(android.ext.x2.g(android.ext.MainService.G0));
            this.k0 = strS6;
        }
        if (A3(strS6, strS3)) {
            return true;
        }
        if (z) {
            return false;
        }
        java.lang.Object obj = this.U;
        if (!(obj instanceof java.io.File)) {
            return false;
        }
        java.lang.String strS7 = this.h0;
        if (strS7 == null) {
            strS7 = s3((java.io.File) obj);
            this.h0 = strS7;
        }
        return A3(strS7, strS3);
    }

    byte t3() {
        int i = this.a0;
        this.a0 = i + 1;
        byte b2 = (byte) (i % 20);
        this.b0 = b2;
        return (byte) (b2 + (this.Z * 20) + 20);
    }

    public android.ext.Script w3() {
        return x3(1);
    }

    public android.ext.Script x3(int i) {
        this.f0 = i;
        this.V.interrupt();
        return this;
    }

    void y3() {
        this.c0 = false;
        this.d0 = J3(this.d0);
    }

    boolean z3(java.io.File file) {
        if (!file.exists()) {
            return false;
        }
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
            int i = 0;
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                java.lang.String strTrim = line.trim();
                if (strTrim.length() != 0) {
                    if (i == 0) {
                        try {
                            java.lang.Integer.parseInt(strTrim);
                            i = 1;
                        } catch (java.lang.Throwable unused) {
                        }
                    } else {
                        if (strTrim.split("\\|").length < 10) {
                            i = -i;
                            break;
                        }
                        i++;
                    }
                }
            }
            bufferedReader.close();
            return i > 1;
        } catch (java.io.IOException e2) {
            android.ext.e1.g("Failed detect", e2);
            return false;
        }
    }
}
