package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$searchAddress extends android.ext.Script$BusyApiFunction {
    final /* synthetic */ android.ext.Script f0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Script$searchAddress(android.ext.Script script) {
        super(script);
        this.f0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected final int Y2() {
        return 7;
    }

    @Override // android.ext.Script$ApiFunction
    public final luaj.Varargs c3(luaj.Varargs varargs) {
        this.f0.y3();
        if ((this instanceof android.ext.Script$refineAddress) && android.ext.MainService.instance.p0 == 0) {
            return luaj.LuaValue.f1674d;
        }
        try {
            if (android.ext.m1.k(this.f0.t3(), android.ext.Script.D3(varargs.E(1)), varargs.a0(2, -1L), android.ext.Script.f3(varargs.Y(3, 127)), android.ext.Script.e3(varargs.Y(4, 536870912)), varargs.a0(5, 0L), varargs.a0(6, -1L), false, varargs.a0(7, 0L))) {
                return luaj.LuaValue.f1674d;
            }
            return null;
        } catch (java.lang.NumberFormatException e2) {
            return luaj.LuaValue.K2(android.ext.Script.V3(e2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0032  */
    /* JADX WARN: Code duplicated, block: B:23:0x0038  */
    @Override // android.ext.Script$ApiFunction
    protected final boolean d3(java.io.Writer writer, int i, luaj.LuaValue luaValue) {
        if (i == 2) {
            if (luaValue.j1()) {
                return android.ext.Script$ApiFunction.h3(writer, luaValue);
            }
        } else if (i != 3) {
            if (i != 4) {
                if (i == 5 || i == 6) {
                    if (luaValue.j1()) {
                        return android.ext.Script$ApiFunction.h3(writer, luaValue);
                    }
                }
            } else if (luaValue.h1()) {
                return android.ext.Script$ApiFunction.g3(writer, this.f0.g0.f374d, luaValue);
            }
        } else if (luaValue.h1()) {
            return android.ext.Script$ApiFunction.g3(writer, this.f0.g0.f372b, luaValue);
        }
        return super.d3(writer, i, luaValue);
    }

    @Override // android.ext.Script$ApiFunction
    final java.lang.String k3() {
        return this instanceof android.ext.Script$refineAddress ? "gg.searchAddress(string text [, long mask = -1 [, int type = gg.TYPE_AUTO [, int sign = gg.SIGN_EQUAL [, long memoryFrom = 0 [, long memoryTo = -1 [, long limit = 0]]]]]]) -> true || string with error".replace("searchAddress", "refineAddress") : "gg.searchAddress(string text [, long mask = -1 [, int type = gg.TYPE_AUTO [, int sign = gg.SIGN_EQUAL [, long memoryFrom = 0 [, long memoryTo = -1 [, long limit = 0]]]]]]) -> true || string with error";
    }
}
