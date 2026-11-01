package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$multiChoice extends android.ext.Script$ApiFunction implements android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnMultiChoiceClickListener {
    volatile boolean[] e0;
    private volatile boolean f0;

    Script$multiChoice() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 3;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        int i;
        luaj.LuaTable luaTableI = varargs.I(1);
        luaj.LuaTable luaTableC0 = varargs.c0(2, null);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        luaj.LuaTable$i luaTable$iS3 = luaTableI.s3();
        while (true) {
            boolean z = false;
            if (!luaTable$iS3.c()) {
                break;
            }
            luaj.LuaValue luaValueB = luaTable$iS3.b();
            arrayList2.add(android.ext.b2.g(luaTable$iS3.d().B0()));
            if (luaTableC0 != null && android.ext.Script.G3(luaTableC0, luaValueB, false)) {
                z = true;
            }
            arrayList3.add(java.lang.Boolean.valueOf(z));
            arrayList.add(luaValueB);
        }
        this.e0 = android.ext.Tools.k(arrayList3);
        this.f0 = false;
        java.lang.String strG = android.ext.b2.g(varargs.Z(3, ""));
        java.lang.String str = strG.length() > 0 ? '\n' + strG : null;
        java.lang.CharSequence[] charSequenceArr = (java.lang.CharSequence[]) arrayList2.toArray(new java.lang.CharSequence[arrayList2.size()]);
        synchronized (this) {
            try {
                android.ext.n2.i(new android.ext.Script$multiChoice$1(this, str, charSequenceArr));
                android.ext.Script.W3(this);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        if (!this.f0) {
            return luaj.LuaValue.f1673c;
        }
        luaj.LuaTable luaTable = new luaj.LuaTable();
        for (i = 0; i < arrayList.size(); i++) {
            if (this.e0[i]) {
                luaTable.d2((luaj.LuaValue) arrayList.get(i), luaj.LuaValue.f1674d);
            }
        }
        return luaTable;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.multiChoice(table items [, table selection = {} [, string message = nil]]) -> table || nil";
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == -1) {
            this.f0 = true;
        }
    }

    @Override // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i, boolean z) {
        this.e0[i] = z;
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
