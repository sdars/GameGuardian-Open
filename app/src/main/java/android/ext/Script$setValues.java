package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$setValues extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$setValues(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        luaj.LuaTable luaTableI = varargs.I(1);
        android.ext.MainService mainService = android.ext.MainService.instance;
        android.ext.z1$d z1_d = mainService.v0;
        boolean z = z1_d != null ? z1_d.n : false;
        android.ext.f0 f0Var = mainService.i;
        luaj.LuaString luaString = android.ext.Script.t0[1];
        luaj.LuaTable$i luaTable$iS3 = luaTableI.s3();
        while (luaTable$iS3.c()) {
            luaj.LuaTable luaTableH0 = luaTable$iS3.d().H0();
            try {
                android.ext.c cVarT3 = android.ext.Script.T3(null, luaTableH0, (byte) 1, z);
                int i = cVarT3.f674c & 127;
                cVarT3.f674c = i;
                if (i != 0) {
                    android.ext.i2$c i2_cX = android.ext.i2.x(android.ext.Script.D3(android.ext.Script.h3(luaTableH0, luaString)), false);
                    f0Var.a(cVarT3, i2_cX != null ? i2_cX.f1018b : 0);
                }
            } catch (java.lang.NumberFormatException e2) {
                throw android.ext.Script.m3(luaTable$iS3.b(), luaTableH0, e2);
            }
        }
        mainService.i.C(this.e0.t3());
        java.lang.Object obj = new java.lang.Object();
        synchronized (obj) {
            try {
                android.ext.n2.i(new android.ext.Script$setValues$1(this, obj));
                android.ext.Script.W3(obj);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        return luaj.LuaValue.f1674d;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.setValues(table values) -> true || string with error";
    }
}
