package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z0$f implements java.lang.Runnable {
    z0$f() {
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.b1.R1("install-mode-unavailable");
        android.ext.r rVar = android.ext.r.n;
        if (rVar != null) {
            rVar.finish();
        }
        android.ext.f1.n();
    }
}
