package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f802d;

    f0$a(android.ext.f0 f0Var, byte b2, int i, long j) {
        this.f802d = f0Var;
        this.f799a = b2;
        this.f800b = i;
        this.f801c = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f802d.f793b;
        inOut.q(this.f799a, (byte) 32, 0);
        inOut.u(this.f800b);
        inOut.v(this.f801c);
        this.f802d.t0();
    }
}
