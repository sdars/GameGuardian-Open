package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$removeListItems extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$removeListItems(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        try {
            luaj.LuaTable luaTableI = varargs.I(1);
            luaTableI.W1();
            long[] jArr = new long[luaTableI.d3() + luaTableI.e3()];
            int i = 0;
            luaj.LuaString luaString = android.ext.Script.t0[0];
            luaj.LuaTable$i luaTable$iS3 = luaTableI.s3();
            while (luaTable$iS3.c()) {
                luaj.LuaValue luaValueD = luaTable$iS3.d();
                jArr[i] = luaValueD.o1() ? android.ext.Script.i3((luaj.LuaTable) luaValueD, luaString) : luaValueD.C0();
                i++;
            }
            java.lang.Object obj = new java.lang.Object();
            synchronized (obj) {
                try {
                    android.ext.n2.i(new android.ext.Script$removeListItems$1(this, jArr, i, obj));
                    android.ext.Script.W3(obj);
                } catch (java.lang.Throwable th_c_c_c) {
                    throw th_c_c_c;
                }
            }
            return luaj.LuaValue.f1674d;
        } catch (luaj.d e2_c_c_c) {
            throw e2_c_c_c;
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Failed remove list items", th2);
            return luaj.LuaValue.K2(android.ext.Script.V3(th2));
        }
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.removeListItems(table items) -> true || string with error";
    }
}
