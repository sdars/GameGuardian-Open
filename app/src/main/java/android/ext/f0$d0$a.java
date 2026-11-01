package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$d0$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.f0$d0 f830b;

    f0$d0$a(android.ext.f0$d0 f0_d0, byte[] bArr) {
        this.f830b = f0_d0;
        this.f829a = bArr;
    }

    @Override // java.lang.Runnable
    public void run() {try {

        try { if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }
try {

            this.f830b.f828a.h0(this.f829a);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        } catch (java.io.IOException e2) {
            android.ext.e1.l("Failed process message: " + ((int) this.f829a[0]) + ' ' + this.f829a.length, e2);
        };
} catch (java.lang.RuntimeException e) {
    throw e;
} catch (java.lang.Throwable e) {
    throw new java.lang.RuntimeException(e);
}
    }
}
