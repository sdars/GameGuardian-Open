package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$editAll$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Object f411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$editAll f412b;

    Script$editAll$1(android.ext.Script$editAll script$editAll, java.lang.Object obj) {
        this.f412b = script$editAll;
        this.f411a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService.instance.f0(this.f412b.e0.t3());
        synchronized (this.f411a) {
            try {
                this.f411a.notifyAll();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }
}
