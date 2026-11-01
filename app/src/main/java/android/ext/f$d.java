package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$d implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.f$n f767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f768c;

    f$d(android.app.AlertDialog alertDialog, android.ext.f$n f_n, java.lang.Runnable runnable) {
        this.f766a = alertDialog;
        this.f767b = f_n;
        this.f768c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f766a.isShowing()) {
            this.f767b.a();
            return;
        }
        if (this.f767b.c()) {
            android.ext.e1.d("Fail-closed dialog was not shown");
            java.lang.Runnable runnable = this.f768c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
