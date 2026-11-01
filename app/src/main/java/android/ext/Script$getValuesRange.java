package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getValuesRange extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$getValuesRange(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        luaj.LuaTable luaTableI = varargs.I(1);
        luaj.LuaTable luaTable = new luaj.LuaTable();
        luaTable.w3(luaTableI.d3(), luaTable.f3());
        luaj.LuaString luaString = android.ext.Script.t0[0];
        luaj.LuaTable$i luaTable$iS3 = luaTableI.s3();
        while (luaTable$iS3.c()) {
            luaj.LuaValue luaValueD = luaTable$iS3.d();
            long jC0 = !luaValueD.o1() ? luaValueD.C0() : android.ext.Script.i3(luaValueD.H0(), luaString);
            int iA = luaTable$iS3.a();
            if (iA == 0) {
                luaTable.d2(luaTable$iS3.b(), luaj.LuaValue.K2(android.ext.RegionList.a(jC0).toString()));
            } else {
                luaTable.Y1(iA, luaj.LuaValue.K2(android.ext.RegionList.a(jC0).toString()));
            }
        }
        return luaTable;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getValuesRange(table values) -> table || string with error";
    }
}
