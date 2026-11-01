package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getResults extends android.ext.Script$BusyApiFunction {
    private byte f0;
    final /* synthetic */ android.ext.Script g0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Script$getResults(android.ext.Script script) {
        super(script);
        this.g0 = script;
    }

    private java.util.ArrayList l3() {
        java.util.ArrayList arrayList = new java.util.ArrayList(android.ext.MainService.instance.s0.i());
        java.lang.Object obj = new java.lang.Object();
        synchronized (obj) {
            try {
                android.ext.n2.i(new android.ext.Script$getResults$1(this, arrayList, obj));
                android.ext.Script.W3(obj);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        return arrayList;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 9;
    }

    @Override // android.ext.Script$ApiFunction
    protected luaj.Varargs a3() {
        int i = 1;
        this.g0.c0 = true;
        android.ext.Script script = this.g0;
        byte b2 = this.f0;
        script.d0 = b2;
        java.util.ArrayList<android.ext.c> arrayListS3 = android.ext.Script.S3(b2);
        if (arrayListS3 == null) {
            android.ext.Script script2 = this.g0;
            if (!script2.e0) {
                script2.e0 = true;
                android.ext.e1.p("getResults: no reply capture for seq " + ((int) this.f0) + "; using the shared result list");
            }
            arrayListS3 = l3();
        }
        luaj.LuaTable luaTable = new luaj.LuaTable();
        luaTable.R1(arrayListS3.size());
        for (android.ext.c cVar : arrayListS3) {
            if (cVar != null) {
                luaTable.Y1(i, android.ext.Script.n3(null, cVar));
                i++;
            }
        }
        return luaTable;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        int iD = varargs.D(1);
        int iY = varargs.Y(2, 0);
        try {
            android.ext.b0$a b0_aF = android.ext.b0.f(varargs.a0(3, 0L), varargs.a0(4, -1L), varargs.Z(5, null), varargs.Z(6, null), varargs.Y(7, 0), varargs.Z(8, null), varargs.Y(9, 0));
            byte bT3 = this.g0.t3();
            this.f0 = bT3;
            android.ext.Script.j3(bT3);
            android.ext.Script script = this.g0;
            script.d0 = android.ext.Script.J3(script.d0);
            android.ext.b0.h(this.f0, iD, iY, b0_aF);
            return null;
        } catch (luaj.d e2_c_c_c) {
            throw e2_c_c_c;
        } catch (java.lang.Throwable th) {
            return luaj.LuaValue.K2(android.ext.Script.V3(th));
        }
    }

    @Override // android.ext.Script$ApiFunction
    protected boolean d3(java.io.Writer writer, int i, luaj.LuaValue luaValue) {
        if (i != 7) {
            if (i == 9 && luaValue.h1()) {
                return android.ext.Script$ApiFunction.g3(writer, this.g0.g0.h, luaValue);
            }
        } else if (luaValue.h1()) {
            return android.ext.Script$ApiFunction.g3(writer, this.g0.g0.f372b, luaValue);
        }
        return super.d3(writer, i, luaValue);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getResults(int maxCount [, int skip = 0 [, long addressMin = nil [, long addressMax = nil [, string valueMin = nil [, string valueMax = nil [, int type = nil [, string fractional = nil [, int pointer = nil]]]]]]]]) -> table || string with error";
    }
}
