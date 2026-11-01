package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$prompt extends android.ext.Script$ApiFunction implements android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnClickListener, android.view.View.OnFocusChangeListener {
    private volatile int e0 = 0;
    private volatile luaj.LuaTable f0 = null;
    volatile java.util.ArrayList g0 = null;
    final /* synthetic */ android.ext.Script h0;

    Script$prompt(android.ext.Script script) {
        this.h0 = script;
    }

    void m3(android.view.View view) {
        view.setVisibility(8);
        android.ext.Tools.O0(view);
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 3;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        luaj.LuaTable luaTableI = varargs.I(1);
        luaj.LuaTable luaTableC0 = varargs.c0(2, null);
        luaj.LuaTable luaTableC1 = varargs.c0(3, null);
        this.e0 = 0;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.g0 = arrayList;
        this.f0 = new luaj.LuaTable();
        synchronized (this) {
            try {
                android.ext.n2.i(new android.ext.Script$prompt$1(this, luaTableI, luaTableC0, luaTableC1, arrayList));
                android.ext.Script.W3(this);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        this.g0 = null;
        luaj.LuaTable luaTable = this.f0;
        this.f0 = null;
        return this.e0 == 0 ? luaj.LuaValue.f1673c : luaTable;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.prompt(table prompts [, table defaults = {} [, table types = {} ]]) -> nil || table with keys from prompts and values from inputs";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        luaj.LuaValue luaValue;
        if (i != -1) {
            return;
        }
        this.e0 = -i;
        java.util.ArrayList<android.widget.TextView> arrayList = this.g0;
        luaj.LuaTable luaTable = this.f0;
        if (arrayList == null || luaTable == null) {
            return;
        }
        for (android.widget.TextView textView : arrayList) {
            if (textView != null && (luaValue = (luaj.LuaValue) textView.getTag()) != null) {
                if (textView instanceof android.widget.EditText) {
                    java.lang.String string = textView.getText().toString();
                    int dataType = textView instanceof android.ext.k0 ? ((android.ext.k0) textView).getDataType() : -1;
                    if (dataType == 1 || dataType == 8 || dataType == 16) {
                        string = android.ext.Script.E3(string);
                    }
                    luaTable.d2(luaValue, luaj.LuaValue.K2(string));
                    android.ext.y0.b(string, dataType);
                } else if (textView instanceof android.widget.CheckBox) {
                    luaTable.d2(luaValue, luaj.LuaValue.H2(((android.widget.CheckBox) textView).isChecked()));
                } else {
                    java.lang.String string2 = textView.getText().toString();
                    luaTable.d2(luaValue, luaj.LuaValue.K2(string2));
                    android.ext.y0.b(string2, 1);
                }
            }
        }
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View$OnFocusChangeListener
    public void onFocusChange(android.view.View view, boolean z) {
        android.ext.InternalKeyboard internalKeyboard;
        boolean z2 = true;
        if ((android.ext.Config.B & 1) == 0 || (internalKeyboard = (android.ext.InternalKeyboard) view.getRootView().findViewById(catch_.me_.if_.you_.can_.R.id.keyboard)) == null || !(view instanceof android.ext.k0)) {
            return;
        }
        int dataType = ((android.ext.k0) view).getDataType();
        if (dataType != 4 && dataType != 2) {
            z2 = false;
        }
        if (!z2) {
            z = false;
        }
        internalKeyboard.h(view, z);
        if (z2) {
            return;
        }
        android.ext.Tools.S0(view);
    }
}
