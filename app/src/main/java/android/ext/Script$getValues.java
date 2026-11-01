package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getValues extends android.ext.Script$BusyApiFunction {
    final java.util.ArrayList f0;
    long[] g0;
    int[] h0;
    int i0;
    final /* synthetic */ android.ext.Script j0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Script$getValues(android.ext.Script script) {
        super(script);
        this.j0 = script;
        this.f0 = new java.util.ArrayList();
        this.g0 = null;
        this.h0 = null;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    protected luaj.Varargs a3() {
        java.util.ArrayList arrayList = this.f0;
        luaj.LuaTable luaTable = new luaj.LuaTable();
        luaTable.R1(this.i0);
        java.util.ArrayList arrayList2 = android.ext.Script.p0;
        int i = 0;
        if (arrayList2 != null) {
            android.ext.Script.q0++;
            android.ext.Script.p0 = null;
            java.util.Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                luaTable.d2((luaj.LuaValue) arrayList.get(i), android.ext.Script.n3(null, (android.ext.c) it.next()));
                i++;
            }
        } else {
            android.ext.Script.q0 += 100000;
            android.ext.n0.h(java.lang.Thread.currentThread(), new java.lang.RuntimeException("memList is null " + android.ext.Script.q0), false);
        }
        this.h0 = null;
        this.g0 = null;
        arrayList.clear();
        arrayList.trimToSize();
        return luaTable;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        luaj.LuaTable luaTableI = varargs.I(1);
        java.util.ArrayList arrayList = this.f0;
        this.h0 = null;
        this.g0 = null;
        int iD3 = luaTableI.d3() + luaTableI.e3();
        long[] jArrCopyOf = new long[iD3];
        int[] iArrCopyOf = new int[iD3];
        arrayList.clear();
        arrayList.ensureCapacity(iD3);
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        boolean z = z1_d != null ? z1_d.n : false;
        android.ext.c cVar = new android.ext.c(0L, 0L, 4);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (luaj.LuaTable$i luaTable$iS3 = luaTableI.s3(); luaTable$iS3.c(); luaTable$iS3 = luaTable$iS3) {
            if (luaTable$iS3.a() != 0) {
                i++;
            }
            luaj.LuaValue luaValueB = luaTable$iS3.b();
            android.ext.Script.T3(cVar, luaTable$iS3.d().H0(), (byte) 2, z);
            if (i2 == jArrCopyOf.length) {
                i3++;
                int i4 = i2 >> 1;
                if (i4 < 10) {
                    i4 = 10;
                }
                android.ext.n0.h(java.lang.Thread.currentThread(), new java.lang.RuntimeException("OF " + i3 + "; " + jArrCopyOf.length + "; " + luaTableI.d3() + " + " + luaTableI.e3() + "; " + luaValueB.h1() + ": " + luaValueB + "; " + luaTableI.V0() + "; " + luaTableI), false);
                int i5 = i4 + i2;
                long[] jArrCopyOf2 = java.util.Arrays.copyOf(jArrCopyOf, i5);
                iArrCopyOf = java.util.Arrays.copyOf(iArrCopyOf, i5);
                jArrCopyOf = jArrCopyOf2;
            }
            jArrCopyOf[i2] = cVar.f672a;
            iArrCopyOf[i2] = cVar.f674c & 127;
            arrayList.add(luaValueB);
            i2++;
            z = z;
        }
        this.i0 = i;
        if (iArrCopyOf.length != i2) {
            iArrCopyOf = java.util.Arrays.copyOf(iArrCopyOf, i2);
        }
        this.h0 = iArrCopyOf;
        if (jArrCopyOf.length != i2) {
            jArrCopyOf = java.util.Arrays.copyOf(jArrCopyOf, i2);
        }
        this.g0 = jArrCopyOf;
        if (i2 != 0) {
            return super.b3(varargs);
        }
        this.h0 = null;
        this.g0 = null;
        return new luaj.LuaTable();
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        android.ext.MainService.instance.i.R(this.j0.t3(), this.h0, this.g0);
        this.h0 = null;
        this.g0 = null;
        return null;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getValues(table values) -> table || string with error";
    }
}
