package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$o implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f276a;

    MainService$o(android.ext.MainService mainService) {
        this.f276a = mainService;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.ext.MainService mainService = this.f276a;
            if (mainService.f0 == mainService.a0) {
                mainService.t0.i();
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed update saved list", th);
        }
        try {
            int i = android.ext.Config.n;
            if (i <= 0) {
                i = 1000;
            }
            android.os.Handler handlerD = android.ext.n2.d();
            handlerD.removeCallbacks(this);
            handlerD.postDelayed(this, i);
        } catch (java.lang.Throwable th2) {
            android.ext.e1.s("Failed post timer", th2);
        }
    }
}
