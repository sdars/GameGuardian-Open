package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$n implements java.lang.Runnable {
    f1$n() {
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.e1$e.a("AndroidService", "wait 4");
        android.ext.n2.d().removeCallbacks(this);
        android.ext.f1.p();
    }
}
