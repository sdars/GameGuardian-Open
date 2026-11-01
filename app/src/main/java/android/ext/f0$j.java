package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$j implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ long f886g;
    final /* synthetic */ android.ext.f0 h;

    f0$j(android.ext.f0 f0Var, byte b2, long j, long j2, int i, long j3, long j4, long j5) {
        this.h = f0Var;
        this.f880a = b2;
        this.f881b = j;
        this.f882c = j2;
        this.f883d = i;
        this.f884e = j3;
        this.f885f = j4;
        this.f886g = j5;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.h.f793b;
        inOut.q(this.f880a, (byte) 63, 0);
        inOut.v(this.f881b);
        inOut.v(this.f882c);
        inOut.u(this.f883d);
        inOut.v(this.f884e);
        inOut.v(this.f885f);
        inOut.v(this.f886g);
        this.h.t0();
        android.ext.f0.w = false;
    }
}
