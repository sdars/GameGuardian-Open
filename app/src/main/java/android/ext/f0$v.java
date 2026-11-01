package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$v implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f940a;

    f0$v(android.ext.f0 f0Var) {
        this.f940a = f0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.os.Handler handlerC = android.ext.n2.c();
        handlerC.removeCallbacks(this);
        if (this.f940a.e0()) {
            handlerC.postDelayed(this, 1000L);
        }
    }
}
