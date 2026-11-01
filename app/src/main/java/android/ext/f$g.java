package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f775a;

    f$g(android.app.AlertDialog alertDialog) {
        this.f775a = alertDialog;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.ext.f.t(this.f775a);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed show dialog on service", th);
        }
    }
}
