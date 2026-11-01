package android.ext;

/* JADX INFO: loaded from: classes.dex */
class p2$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.Toast f1185a;

    p2$c(android.widget.Toast toast) {
        this.f1185a = toast;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1185a.cancel();
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Toast cancel", th);
        }
    }
}
