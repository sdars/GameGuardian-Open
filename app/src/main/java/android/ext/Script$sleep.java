package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$sleep extends android.ext.Script$ApiFunction {
    Script$sleep() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        int iD = varargs.D(1);
        if (iD < 0) {
            throw new luaj.d("milliseconds < 0: " + iD);
        }
        try {
            java.lang.Thread.sleep(iD);
            return luaj.LuaValue.f1673c;
        } catch (java.lang.InterruptedException e2) {
            android.ext.e1.s("Interrupted sleep", e2);
            throw new luaj.d(e2);
        }
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.sleep(int milliseconds) -> nil";
    }
}
