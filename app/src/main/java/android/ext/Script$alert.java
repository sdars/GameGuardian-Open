package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$alert extends android.ext.Script$ApiFunction implements android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnClickListener {
    private volatile int e0 = 0;

    Script$alert() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 4;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        java.lang.String strE = varargs.E(1);
        java.lang.String strZ = varargs.Z(2, android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok));
        java.lang.String strZ2 = varargs.Z(3, null);
        java.lang.String strZ3 = varargs.Z(4, null);
        this.e0 = 0;
        synchronized (this) {
            try {
                android.ext.n2.i(new android.ext.Script$alert$1(this, strE, strZ, strZ2, strZ3));
                android.ext.Script.W3(this);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        return luaj.LuaValue.I2(this.e0);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.alert(string text [, string positive = 'ok' [, string negative = nil [, string neutral = nil]]]) -> int: 0 = cancel, 1 = positive, 2 = negative, 3 = neutral";
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.e0 = -i;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        synchronized (this) {
            try {
                notify();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        android.ext.MainService.instance.y(false);
    }
}
