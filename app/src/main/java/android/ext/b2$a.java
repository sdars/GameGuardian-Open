package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b2$a implements java.lang.Runnable {
    b2$a() {
    }

    @Override // java.lang.Runnable
    public void run() {
        long j = android.ext.b2.f658d;
        if (j != 0 && java.lang.System.currentTimeMillis() - j > 5000) {
            android.ext.b2.a();
        }
        android.os.Handler handlerD = android.ext.n2.d();
        try {
            handlerD.removeCallbacks(this);
        } catch (java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
        }
        handlerD.postDelayed(this, 1000L);
    }
}
