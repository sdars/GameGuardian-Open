package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$s implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f298a;

    MainService$s(android.ext.MainService mainService) {
        this.f298a = mainService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f298a.onLongClick(null);
    }
}
