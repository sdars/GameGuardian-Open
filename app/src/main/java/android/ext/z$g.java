package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z$g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog.Builder f1397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.z f1398b;

    z$g(android.ext.z zVar, android.app.AlertDialog.Builder alertDialog$Builder) {
        this.f1398b = zVar;
        this.f1397a = alertDialog$Builder;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.app.AlertDialog alertDialogCreate = this.f1397a.create();
            android.ext.f.w(alertDialogCreate);
            android.ext.Tools.u1(alertDialogCreate);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed show float dialog", th);
        }
    }
}
