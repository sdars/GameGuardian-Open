package android.ext;

/* JADX INFO: loaded from: classes.dex */
class x$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.x f1297a;

    x$a(android.ext.x xVar) {
        this.f1297a = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.app.AlertDialog alertDialog = this.f1297a.f1290a;
        if (alertDialog != null) {
            android.ext.f.m(alertDialog);
        }
    }
}
