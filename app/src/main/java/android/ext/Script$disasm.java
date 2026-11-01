package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$disasm extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$disasm(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 3;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        long jF = varargs.F(2);
        int iD = varargs.D(3);
        int iD2 = varargs.D(1);
        if (iD2 == 4) {
            return luaj.LuaString.K2(android.ext.n.o(new android.ext.n(), jF, iD));
        }
        if (iD2 == 5) {
            return luaj.LuaString.K2(android.ext.n.q(new android.ext.n(), jF, iD));
        }
        if (iD2 == 6) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.ext.m.g(android.ext.m.d(), jF, iD, sb);
            return luaj.LuaString.K2(sb.toString());
        }
        return luaj.LuaValue.l0(1, "gg.disasm", "unknown type: " + varargs.D(1));
    }

    @Override // android.ext.Script$ApiFunction
    protected boolean d3(java.io.Writer writer, int i, luaj.LuaValue luaValue) {
        if (i != 1) {
            if ((i == 2 || i == 3) && luaValue.j1()) {
                return android.ext.Script$ApiFunction.h3(writer, luaValue);
            }
        } else if (luaValue.h1()) {
            return android.ext.Script$ApiFunction.g3(writer, this.e0.g0.j, luaValue);
        }
        return super.d3(writer, i, luaValue);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.disasm(int type, long address, int opcode) -> string";
    }
}
