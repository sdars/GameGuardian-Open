package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$internal1 extends android.ext.Script$BusyApiFunction {
    final /* synthetic */ android.ext.Script f0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Script$internal1(android.ext.Script script) {
        super(script);
        this.f0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 4;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        this.f0.y3();
        try {
            luaj.LuaString luaStringH = varargs.H(1);
            int i = luaStringH.R;
            byte[] bArr = new byte[i];
            luaStringH.U2(0, bArr, 0, i);
            if (android.ext.i2.m(this.f0.t3(), varargs.a0(4, 1L) == 2 ? 2 : 1, bArr, varargs.a0(2, 0L), varargs.a0(3, -1L), false, varargs.a0(4, 0L))) {
                return luaj.LuaValue.f1674d;
            }
            return null;
        } catch (java.lang.NumberFormatException e2) {
            return luaj.LuaValue.K2(android.ext.Script.V3(e2));
        }
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "do not use";
    }
}
