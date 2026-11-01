package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$o implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditTextPath f78a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.widget.CheckBox f79b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f80c;

    ConfigListAdapter$o(android.ext.EditTextPath editTextPath, android.widget.CheckBox checkBox, android.app.AlertDialog alertDialog) {
        this.f78a = editTextPath;
        this.f79b = checkBox;
        this.f80c = alertDialog;
    }

    void a(java.lang.String str) {
        android.ext.n2.i(new android.ext.ConfigListAdapter$o$c(this));
        android.ext.Tools.h(str + "\n\n" + android.ext.e2.f745a, 0);
    }

    void b() {
        android.ext.n2.i(new android.ext.ConfigListAdapter$o$b(this));
    }

    void c(java.lang.String str, boolean z) {
        android.ext.e1.d("su path: " + str + "; sh: " + z);
        new android.ext.g2().k("su", str, "").c("sh", z, false).commit();
        if (str.length() != 0) {
            android.ext.y0.b(str, 4);
        }
        android.ext.Tools.D(this.f80c);
        android.ext.ConfigListAdapter.m();
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        java.lang.String strTrim = this.f78a.getText().toString().trim();
        if (strTrim.length() <= 0) {
            c(strTrim, this.f79b.isChecked());
            return;
        }
        new android.ext.n0$i(new android.ext.ConfigListAdapter$o$a(this, strTrim), "CheckSu: " + strTrim).start();
    }
}
