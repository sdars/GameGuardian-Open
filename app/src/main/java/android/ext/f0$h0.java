package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$h0 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.String f866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ byte f867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f869e;

    f0$h0(android.ext.f0 f0Var, java.lang.String str, java.lang.String str2, byte b2, int i) {
        this.f869e = f0Var;
        this.f865a = str;
        this.f866b = str2;
        this.f867c = b2;
        this.f868d = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f869e.f793b;
        byte[] bytes = this.f865a.getBytes();
        int length = bytes.length;
        if (length > 255) {
            length = 255;
        }
        java.lang.String str = this.f866b;
        byte[] bytes2 = str == null ? gg_d.b.f1513c : str.getBytes();
        int length2 = bytes2.length;
        int i = length2 <= 255 ? length2 : 255;
        inOut.q(this.f867c, (byte) 37, 0);
        inOut.u(this.f868d);
        inOut.s((byte) length);
        inOut.t(bytes, length);
        inOut.s((byte) i);
        inOut.t(bytes2, i);
        this.f869e.t0();
    }
}
