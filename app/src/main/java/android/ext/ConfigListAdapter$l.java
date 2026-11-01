package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$l implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditTextPath f73a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f74b;

    ConfigListAdapter$l(android.ext.EditTextPath editTextPath, android.app.AlertDialog alertDialog) {
        this.f73a = editTextPath;
        this.f74b = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        java.lang.String strQ1 = android.ext.Tools.Q1(this.f73a.getText().toString().trim());
        if (strQ1.length() > 0) {
            if (!android.ext.Tools.f1(strQ1)) {
                return;
            } else {
                android.ext.y0.b(strQ1, 4);
            }
        }
        android.ext.e1.d("save path: " + strQ1);
        new android.ext.g2().k("temp-path", strQ1, "").commit();
        android.ext.MainService mainService = android.ext.MainService.instance;
        mainService.i.B0(mainService.I());
        mainService.q(true);
        android.ext.Tools.D(this.f74b);
    }
}
