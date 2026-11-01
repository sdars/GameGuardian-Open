package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$b0 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f221a;

    MainService$b0(android.ext.MainService mainService) {
        this.f221a = mainService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f221a.n.show();
        this.f221a.i0.e(false);
    }
}
