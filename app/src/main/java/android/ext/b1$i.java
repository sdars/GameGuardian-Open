package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$i implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f625a;

    b1$i(java.lang.Runnable runnable) {
        this.f625a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.b1.S1();
        this.f625a.run();
        android.ext.b1.R1("normal-service-ready");
        android.ext.b1.f("normal-service-ready");
    }
}
