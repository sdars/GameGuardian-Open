package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.view.View f1390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.view.WindowManager.LayoutParams f1391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.z f1392c;

    z$c(android.ext.z zVar, android.view.View view, android.view.WindowManager.LayoutParams windowManager$LayoutParams) {
        this.f1392c = zVar;
        this.f1390a = view;
        this.f1391b = windowManager$LayoutParams;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.ext.Tools.f(this.f1390a, this.f1391b);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed show test view(" + this.f1391b.type + ", " + this.f1391b.flags + "): " + this.f1390a + "; " + this.f1391b, th);
        }
        synchronized (this) {
            try {
                notify();
            } catch (java.lang.Throwable th2_c_c_c) {
                throw th2_c_c_c;
            }
        }
    }
}
