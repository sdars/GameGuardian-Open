package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$f0 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte f850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long[] f851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f852d;

    f0$f0(android.ext.f0 f0Var, int[] iArr, byte b2, long[] jArr) {
        this.f852d = f0Var;
        this.f849a = iArr;
        this.f850b = b2;
        this.f851c = jArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f852d.f793b;
        int length = this.f849a.length;
        int i = 0;
        while (i < length) {
            int i2 = length - i;
            if (i2 > 100000000) {
                i2 = 100000000;
            }
            inOut.q(this.f850b, (byte) 36, (android.ext.InOut.n + 4) * i2);
            inOut.u(i2);
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = this.f849a[i];
                if (i4 != 0) {
                    inOut.u(i4);
                    inOut.v(this.f851c[i]);
                }
                i++;
            }
            inOut.u(0);
            this.f852d.t0();
            i = i3;
        }
    }
}
