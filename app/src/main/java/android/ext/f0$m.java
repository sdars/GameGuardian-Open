package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$m implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f906g;

    f0$m(android.ext.f0 f0Var, byte b2, int i, long j, long j2, long j3, byte[] bArr) {
        this.f906g = f0Var;
        this.f900a = b2;
        this.f901b = i;
        this.f902c = j;
        this.f903d = j2;
        this.f904e = j3;
        this.f905f = bArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f906g.f793b;
        inOut.q(this.f900a, (byte) 34, 0);
        inOut.u(this.f901b);
        inOut.v(this.f902c);
        inOut.v(this.f903d);
        inOut.v(this.f904e);
        inOut.u(this.f905f.length);
        byte[] bArr = this.f905f;
        inOut.t(bArr, bArr.length);
        this.f906g.t0();
        android.ext.f0.w = false;
    }
}
