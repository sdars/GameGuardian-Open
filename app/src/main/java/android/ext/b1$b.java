package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$b implements java.lang.Runnable {
    b1$b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.b1.H1();
        android.os.Handler handlerD = android.ext.n2.d();
        handlerD.removeCallbacks(this);
        handlerD.postDelayed(this, 500L);
    }
}
