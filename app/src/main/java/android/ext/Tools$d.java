package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$d implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f505a;

    Tools$d(android.app.AlertDialog alertDialog) {
        this.f505a = alertDialog;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.ext.Tools.T0(this.f505a.getWindow());
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("hideSoftInputFromWindow", th);
        }
    }
}
