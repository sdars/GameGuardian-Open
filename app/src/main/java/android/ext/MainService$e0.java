package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$e0 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f239a;

    MainService$e0(android.ext.MainService mainService) {
        this.f239a = mainService;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.e1.d("doCheckLibs: " + this.f239a.v());
    }
}
