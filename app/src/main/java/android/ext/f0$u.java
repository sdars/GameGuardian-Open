package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$u implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte f938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f939c;

    f0$u(android.ext.f0 f0Var, byte b2, byte b3) {
        this.f939c = f0Var;
        this.f937a = b2;
        this.f938b = b3;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f939c.f793b;
        inOut.q(this.f937a, (byte) 53, 0);
        inOut.s(this.f938b);
        this.f939c.t0();
    }
}
