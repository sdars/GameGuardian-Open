package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$o implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Object[] f920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte f921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f922c;

    f0$o(android.ext.f0 f0Var, java.lang.Object[] objArr, byte b2) {
        this.f922c = f0Var;
        this.f920a = objArr;
        this.f921b = b2;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.c cVar;
        int i;
        android.ext.InOut inOut = this.f922c.f793b;
        int length = this.f920a.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = length - i2;
            if (i3 > 100000000) {
                i3 = 100000000;
            }
            inOut.q(this.f921b, (byte) 43, (android.ext.InOut.n + 16) * i3);
            inOut.u(i3);
            int i4 = i3 + i2;
            while (i2 < i4) {
                java.lang.Object obj = this.f920a[i2];
                if (obj instanceof android.ext.f0$k0) {
                    android.ext.f0$k0 f0_k0 = (android.ext.f0$k0) obj;
                    cVar = f0_k0.f891a;
                    i = f0_k0.f892b;
                } else {
                    cVar = (android.ext.c) obj;
                    i = 0;
                }
                int i5 = cVar.f674c;
                if (i5 != 0) {
                    inOut.u(i5);
                    inOut.v(cVar.f672a);
                    inOut.w(cVar.f673b);
                    inOut.u(i);
                }
                i2++;
            }
            inOut.u(0);
            this.f922c.t0();
            i2 = i4;
        }
    }
}
