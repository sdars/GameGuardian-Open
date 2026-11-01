package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$s implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f0$j0 f931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte f932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f933c;

    f0$s(android.ext.f0 f0Var, android.ext.f0$j0 f0_j0, byte b2) {
        this.f933c = f0Var;
        this.f931a = f0_j0;
        this.f932b = b2;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f933c.f793b;
        int length = this.f931a.f887a.length;
        int i = 0;
        while (i < length) {
            int i2 = length - i;
            if (i2 > 100000000) {
                i2 = 100000000;
            }
            inOut.q(this.f932b, (byte) 33, (android.ext.InOut.n + 4) * i2);
            inOut.u(i2);
            android.ext.f0$j0 f0_j0 = this.f931a;
            int[] iArr = f0_j0.f888b;
            long[] jArr = f0_j0.f887a;
            int i3 = i2 + i;
            while (i < i3) {
                inOut.u(iArr[i]);
                inOut.v(jArr[i]);
                i++;
            }
            this.f933c.t0();
            i = i3;
        }
    }
}
