package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$x implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f305a;

    MainService$x(android.ext.MainService mainService) {
        this.f305a = mainService;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f305a.n == null) {
            this.f305a.c0();
        }
    }
}
