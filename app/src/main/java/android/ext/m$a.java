package android.ext;

/* JADX INFO: loaded from: classes.dex */
class m$a implements java.lang.Comparable<android.ext.m$a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f1067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1068b;

    public m$a(long j, int i) {
        this.f1067a = j;
        this.f1068b = i;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(android.ext.m$a m_a) {
        long j = this.f1067a;
        long j2 = m_a.f1067a;
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
