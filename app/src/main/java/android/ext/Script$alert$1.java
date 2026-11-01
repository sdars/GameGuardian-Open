package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$alert$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.String f402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ java.lang.String f403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ java.lang.String f404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$alert f405e;

    Script$alert$1(android.ext.Script$alert script$alert, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.f405e = script$alert;
        this.f401a = str;
        this.f402b = str2;
        this.f403c = str3;
        this.f404d = str4;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.app.AlertDialog.Builder positiveButton = android.ext.f.b().setCustomTitle(android.ext.Tools.h0(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script))).setMessage(android.ext.b2.g(this.f401a)).setPositiveButton(android.ext.b2.g(this.f402b), this.f405e);
        java.lang.String str = this.f403c;
        if (str != null) {
            positiveButton.setNegativeButton(android.ext.b2.g(str), this.f405e);
        }
        java.lang.String str2 = this.f404d;
        if (str2 != null) {
            positiveButton.setNeutralButton(android.ext.b2.g(str2), this.f405e);
        }
        android.app.AlertDialog alertDialogCreate = positiveButton.create();
        android.ext.f.k(alertDialogCreate, this.f405e);
        android.ext.f.m(alertDialogCreate);
        android.ext.MainService.instance.y(true);
    }
}
