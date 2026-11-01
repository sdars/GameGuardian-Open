package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$d implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f236a;

    MainService$d(android.ext.MainService mainService) {
        this.f236a = mainService;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService mainService = this.f236a;
        mainService.f213c = null;
        mainService.f214d = null;
        mainService.h0.e();
        this.f236a.D0(true);
    }
}
