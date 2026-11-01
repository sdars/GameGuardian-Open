package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f238a;

    MainService$e(android.ext.MainService mainService) {
        this.f238a = mainService;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService mainService = this.f238a;
        mainService.f217g = null;
        mainService.h0.d();
    }
}
