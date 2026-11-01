package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$setValues$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Object f440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$setValues f441b;

    Script$setValues$1(android.ext.Script$setValues script$setValues, java.lang.Object obj) {
        this.f441b = script$setValues;
        this.f440a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService.instance.f0(this.f441b.e0.t3());
        synchronized (this.f440a) {
            try {
                this.f440a.notifyAll();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }
}
