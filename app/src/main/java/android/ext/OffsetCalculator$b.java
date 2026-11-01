package android.ext;

/* JADX INFO: loaded from: classes.dex */
class OffsetCalculator$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.OffsetCalculator f321c;

    OffsetCalculator$b(android.ext.OffsetCalculator offsetCalculator, long j, long j2) {
        this.f321c = offsetCalculator;
        this.f319a = j;
        this.f320b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f321c.l(this.f319a, this.f320b, false);
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed update value: " + this.f319a + ' ' + this.f320b, th);
        }
    }
}
