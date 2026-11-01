package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$b0 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f814b;

    f0$b0(android.ext.f0 f0Var, byte b2) {
        this.f814b = f0Var;
        this.f813a = b2;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.f0 f0Var = this.f814b;
        android.ext.InOut inOut = f0Var.f793b;
        f0Var.L0(this.f813a, (byte) 1);
        this.f814b.u0(this.f813a, (byte) 45);
        inOut.n(false);
        android.ext.MainService.instance.q0();
    }
}
