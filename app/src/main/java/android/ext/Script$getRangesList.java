package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getRangesList extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$getRangesList(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        java.util.regex.Pattern patternCompile;
        int i = 1;
        java.lang.String strZ = varargs.Z(1, "");
        if (strZ.length() > 0) {
            strZ = android.ext.Tools.k1(strZ);
        }
        luaj.LuaTable luaTable = new luaj.LuaTable();
        if (strZ.length() > 0) {
            try {
                patternCompile = java.util.regex.Pattern.compile(strZ);
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
                patternCompile = null;
            }
        } else {
            patternCompile = null;
        }
        luaj.LuaString luaStringK2 = luaj.LuaString.K2("state");
        luaj.LuaString luaStringK3 = luaj.LuaString.K2("start");
        luaj.LuaString luaStringK4 = luaj.LuaString.K2("end");
        luaj.LuaString luaStringK5 = luaj.LuaString.K2("type");
        luaj.LuaString luaStringK6 = luaj.LuaString.K2("name");
        luaj.LuaString luaStringK7 = luaj.LuaString.K2("internalName");
        for (android.ext.RegionList$b regionList$b : android.ext.RegionList.getList()) {
            java.lang.String strA = regionList$b.a();
            if (patternCompile == null || patternCompile.matcher(strA).find()) {
                luaj.LuaTable luaTable2 = new luaj.LuaTable(0, 6);
                luaTable2.d2(luaStringK2, luaj.LuaValue.K2(regionList$b.e().toString()));
                luaTable2.d2(luaStringK3, luaj.LuaValue.I2(regionList$b.f356b));
                luaTable2.d2(luaStringK4, luaj.LuaValue.I2(regionList$b.f357c));
                luaTable2.d2(luaStringK5, luaj.LuaValue.K2(regionList$b.f()));
                luaTable2.d2(luaStringK6, luaj.LuaValue.K2(regionList$b.b()));
                luaTable2.d2(luaStringK7, luaj.LuaValue.K2(strA));
                luaTable.e2(i, luaTable2);
                i++;
            }
        }
        return luaTable;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getRangesList([string filter = '']) -> table";
    }
}
