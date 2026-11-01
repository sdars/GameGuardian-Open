package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$removeResults$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Object f436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$removeResults f437b;

    Script$removeResults$1(android.ext.Script$removeResults script$removeResults, java.lang.Object obj) {
        this.f437b = script$removeResults;
        this.f436a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService.instance.D0(false);
        synchronized (this.f436a) {
            try {
                this.f436a.notifyAll();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }
}
