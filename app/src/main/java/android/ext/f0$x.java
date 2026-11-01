package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$x implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f946b;

    f0$x(android.ext.f0 f0Var, byte b2) {
        this.f946b = f0Var;
        this.f945a = b2;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f946b.f793b;
        inOut.q(this.f945a, (byte) 47, 0);
        inOut.u(android.os.Process.myPid());
        inOut.u(this.f946b.f797f);
        this.f946b.t0();
    }
}
