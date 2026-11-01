package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$searchFuzzy extends android.ext.Script$BusyApiFunction {
    final /* synthetic */ android.ext.Script f0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Script$searchFuzzy(android.ext.Script script) {
        super(script);
        this.f0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 6;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        int iF3;
        int iY;
        this.f0.y3();
        try {
            if ((varargs.Y(2, 0) & 127) != 0) {
                iF3 = android.ext.Script.f3(varargs.Y(2, 127));
                iY = varargs.Y(3, 536870912);
            } else {
                iF3 = android.ext.Script.f3(varargs.Y(3, 127));
                iY = varargs.Y(2, 536870912);
            }
            if (android.ext.t0.k(this.f0.t3(), android.ext.Script.D3(varargs.Z(1, "0")), iF3, android.ext.Script.e3(iY), 1, varargs.a0(4, 0L), varargs.a0(5, -1L), varargs.a0(6, 0L))) {
                return luaj.LuaValue.f1674d;
            }
            return null;
        } catch (java.lang.NumberFormatException e2) {
            return luaj.LuaValue.K2(android.ext.Script.V3(e2));
        }
    }

    @Override // android.ext.Script$ApiFunction
    protected boolean d3(java.io.Writer writer, int i, luaj.LuaValue luaValue) {
        if (i != 2) {
            if (i != 3) {
                if ((i == 4 || i == 5) && luaValue.j1()) {
                    return android.ext.Script$ApiFunction.h3(writer, luaValue);
                }
            } else if (luaValue.h1()) {
                return android.ext.Script$ApiFunction.g3(writer, this.f0.g0.f372b, luaValue);
            }
        } else if (luaValue.h1()) {
            return android.ext.Script$ApiFunction.g3(writer, this.f0.g0.f373c, luaValue);
        }
        return super.d3(writer, i, luaValue);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.searchFuzzy([string difference = '0' [, int sign = gg.SIGN_FUZZY_EQUAL [, int type = gg.TYPE_AUTO [, long memoryFrom = 0 [, long memoryTo = -1 [, long limit = 0]]]]]]) -> true || string with error";
    }
}
