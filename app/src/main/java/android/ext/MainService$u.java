package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$u implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f300a;

    MainService$u(android.ext.MainService mainService) {
        this.f300a = mainService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f300a.e();
    }
}
