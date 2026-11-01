package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$PostWriteWorker extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.io.OutputStream f384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private java.lang.Throwable f388e;

    Script$PostWriteWorker(java.io.OutputStream outputStream, byte[] bArr, int i, int i2) {
        this.f384a = outputStream;
        this.f385b = bArr;
        this.f386c = i;
        this.f387d = i2;
    }

    void a(boolean z) throws java.io.IOException {
        try {
            this.f384a.close();
        } catch (java.lang.Throwable unused) {
        }
        try {
            join(5000L);
        } catch (java.lang.InterruptedException unused2) {
            java.lang.Thread.currentThread().interrupt();
        }
        java.lang.Throwable th = this.f388e;
        if (z || th == null) {
            return;
        }
        if (!(th instanceof java.lang.RuntimeException)) {
            throw new java.io.IOException(th);
        }
        throw ((java.lang.RuntimeException) th);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
/* gg-shared-throwable */ java.lang.Throwable f388e = null;
        try {
            this.f384a.write(this.f385b, this.f386c, this.f387d);
            this.f384a.flush();
        } catch (java.lang.Throwable th) {
            this.f388e = th;
        }
    }
}
