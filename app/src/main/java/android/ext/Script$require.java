package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$require extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$require(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 2;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        java.lang.String strZ = varargs.Z(1, "0");
        int iY = varargs.Y(2, 0);
        int iE = android.ext.h0.e(strZ);
        if (iE > 80000) {
            iE -= 80000;
        }
        if (android.ext.h0.d() >= iE && ((int) (((1 * 17671.8f) - 1516.8f) + 0.5f)) >= iY) {
            return luaj.LuaValue.f1673c;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("");
        float f2 = 1;
        sb.append((116.200005f * f2) - 14.8f);
        java.lang.String string = sb.toString();
        if (iY > 0) {
            string = string + " (" + ((int) (((f2 * 19632.9f) - 3477.9f) + 0.5f)) + ')';
            strZ = strZ + " (" + iY + ')';
        }
        this.e0.T.c0.println(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.need_update_to), strZ, string));
        throw new android.ext.Script$OsExit(0);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.require([string version = nil [, int build = 0]]) -> nil";
    }
}
