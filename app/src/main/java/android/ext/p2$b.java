package android.ext;

/* JADX INFO: loaded from: classes.dex */
class p2$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.Toast f1184a;

    p2$b(android.widget.Toast toast) {
        this.f1184a = toast;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.p2.f(this.f1184a);
    }
}
