package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z$d implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f1393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.z f1394b;

    z$d(android.ext.z zVar, android.app.AlertDialog alertDialog) {
        this.f1394b = zVar;
        this.f1393a = alertDialog;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.ext.f.w(this.f1393a);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed show dialog: " + this.f1393a, th);
        }
    }
}
