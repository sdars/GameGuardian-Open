package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$f$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter$f f62a;

    ConfigListAdapter$f$a(android.ext.ConfigListAdapter$f configListAdapter$f) {
        this.f62a = configListAdapter$f;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.ext.MainService mainService = android.ext.MainService.instance;
            mainService.t();
            mainService.j.m();
            mainService.m1(false);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed restore after take screenshot", th);
        }
    }
}
