package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$m0 implements java.lang.Comparable<android.ext.f0$m0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f908b;

    public f0$m0(long j, int i) {
        this.f907a = j;
        this.f908b = i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(android.ext.f0$m0 f0_m0) {
        long j = this.f907a;
        long j2 = f0_m0.f907a;
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
