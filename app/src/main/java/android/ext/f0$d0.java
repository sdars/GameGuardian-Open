package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$d0 extends android.ext.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f828a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f0$d0(android.ext.f0 f0Var, java.lang.String str) {
        super(str);
        this.f828a = f0Var;
    }

    private void a(byte[] bArr) {
        try {
            java.util.concurrent.Exchanger exchanger = this.f828a.f794c;
            while (!java.lang.Thread.interrupted()) {
                try {
                    exchanger.exchange(bArr, 500L, java.util.concurrent.TimeUnit.MILLISECONDS);
                    return;
                } catch (java.lang.InterruptedException unused) {
                }
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("handleMemoryItem failed", th);
        }
    }

    private void b(byte[] bArr) {
        if (bArr[0] == 20 && bArr[1] == 0) {
            a(bArr);
        } else {
            android.ext.n2.d().post(new android.ext.f0$d0$a(this, bArr));
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f828a.f793b;
        while (!java.lang.Thread.interrupted()) {
            try {
                byte[] bArrK = inOut.k();
                android.ext.f0.B = null;
                if (bArrK != null) {
                    b(bArrK);
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("Read error", th);
                android.ext.f0.B = th.toString();
                android.ext.n2.d().post(new android.ext.f0$d0$b(this));
                return;
            }
        }
    }
}
