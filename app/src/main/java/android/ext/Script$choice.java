package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$choice extends android.ext.Script$ApiFunction implements android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnClickListener {
    private volatile int e0 = 0;

    Script$choice() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 3;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        java.lang.String str;
        luaj.LuaTable luaTableI = varargs.I(1);
        luaj.LuaValue luaValueV = varargs.v(2);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        luaj.LuaTable$i luaTable$iS3 = luaTableI.s3();
        int i = 0;
        int i2 = -1;
        while (luaTable$iS3.c()) {
            luaj.LuaValue luaValueB = luaTable$iS3.b();
            luaj.LuaValue luaValueD = luaTable$iS3.d();
            if (luaValueB.P0(luaValueV)) {
                i2 = i;
            }
            arrayList2.add(android.ext.b2.g(luaValueD.B0()));
            arrayList.add(luaValueB);
            i++;
        }
        java.lang.String strG = android.ext.b2.g(varargs.Z(3, ""));
        if (strG.length() > 0) {
            str = '\n' + strG;
        } else {
            str = null;
        }
        java.lang.CharSequence[] charSequenceArr = (java.lang.CharSequence[]) arrayList2.toArray(new java.lang.CharSequence[arrayList2.size()]);
        this.e0 = -1;
        synchronized (this) {
            try {
                android.ext.n2.i(new android.ext.Script$choice$1(this, str, luaValueV, charSequenceArr, i2));
                android.ext.Script.W3(this);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        return this.e0 < 0 ? luaj.LuaValue.f1673c : (luaj.Varargs) arrayList.get(this.e0);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.choice(table items [, string selected = nil [, string message = nil]]) -> string || nil";
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.e0 = i;
        android.ext.Tools.D(dialogInterface);
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
