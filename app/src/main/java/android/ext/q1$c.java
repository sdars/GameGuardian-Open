package android.ext;

/* JADX INFO: loaded from: classes.dex */
class q1$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog.Builder f1204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.q1 f1205b;

    q1$c(android.ext.q1 q1Var, android.app.AlertDialog.Builder alertDialog$Builder) {
        this.f1205b = q1Var;
        this.f1204a = alertDialog$Builder;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.app.AlertDialog alertDialogCreate = this.f1204a.create();
            android.ext.f.w(alertDialogCreate);
            android.ext.Tools.u1(alertDialogCreate);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed show miui dialog", th);
        }
    }
}
