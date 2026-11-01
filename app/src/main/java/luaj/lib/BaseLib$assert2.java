package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$assert2 extends luaj.lib.VarArgFunction {
    BaseLib$assert2() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        java.lang.StringBuilder sb;
        java.lang.String str;
        luaj.LuaValue luaValueV = varargs.v(1);
        luaj.LuaValue luaValueV2 = varargs.v(2);
        if (!luaValueV.P0(luaValueV2)) {
            if (luaValueV.B2().equals(luaValueV2.B2())) {
                if (luaValueV.D2().equals(luaValueV2.D2())) {
                    sb = new java.lang.StringBuilder();
                    sb.append(luaValueV);
                    sb.append(" {");
                    sb.append(luaValueV.getClass());
                    sb.append("} ~= ");
                    sb.append(luaValueV2);
                    sb.append(" {");
                    sb.append(luaValueV2.getClass());
                    str = "}";
                } else {
                    sb = new java.lang.StringBuilder();
                    sb.append(luaValueV);
                    sb.append(" [");
                    sb.append(luaValueV.D2());
                    sb.append("] ~= ");
                    sb.append(luaValueV2);
                    sb.append(" [");
                    sb.append(luaValueV2.D2());
                    str = "]";
                }
                sb.append(str);
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(luaValueV);
                sb.append(" ~= ");
                sb.append(luaValueV2);
            }
            luaj.LuaValue.R0(sb.toString() + ": " + varargs.Z(3, "assertion failed!"));
        }
        return varargs;
    }
}
