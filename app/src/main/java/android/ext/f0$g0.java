package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$g0 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f860d;

    f0$g0(android.ext.f0 f0Var, byte b2, long j, int i) {
        this.f860d = f0Var;
        this.f857a = b2;
        this.f858b = j;
        this.f859c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f860d.f793b;
        inOut.q(this.f857a, (byte) 50, 0);
        inOut.v(this.f858b);
        inOut.u(this.f859c);
        inOut.s((byte) 0);
        this.f860d.t0();
    }
}
