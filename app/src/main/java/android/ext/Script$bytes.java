package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$bytes extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$bytes(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 2;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        try {
            byte[] bytes = varargs.E(1).getBytes(varargs.Z(2, "UTF-8"));
            luaj.LuaTable luaTable = new luaj.LuaTable();
            int length = bytes.length;
            luaTable.R1(length);
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                luaTable.Y1(i2, luaj.LuaValue.I2(bytes[i] & 255));
                i = i2;
            }
            return luaTable;
        } catch (java.io.UnsupportedEncodingException e2) {
            throw new luaj.d(e2);
        }
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.bytes(string text [, string encoding = 'UTF-8']) -> table";
    }
}
