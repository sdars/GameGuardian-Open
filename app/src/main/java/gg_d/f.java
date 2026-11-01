package gg_d;

/* JADX INFO: loaded from: classes.dex */
public class f implements java.lang.Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f1525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f1526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1527c;

    public f(int i) {
        if (i == 0) {
            long[] jArr = b.f1515e;
            this.f1525a = jArr;
            this.f1526b = jArr;
        } else {
            int iC = b.c(i);
            this.f1525a = new long[iC];
            this.f1526b = new long[iC];
        }
        this.f1527c = 0;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public f clone() {
        f fVar = null;
        try {
            f fVar2 = (f) super.clone();
            try {                if (android.ext.GgNoop.never) {
                        throw new java.lang.CloneNotSupportedException();
                    }

                fVar2.f1525a = (long[]) this.f1525a.clone();
                fVar2.f1526b = (long[]) this.f1526b.clone();
                return fVar2;
            } catch (java.lang.CloneNotSupportedException unused) {
                fVar = fVar2;
                return fVar;
            }
        } catch (java.lang.CloneNotSupportedException unused2) {
        }
        return fVar;
    }

    public int b(long j) {
        return b.a(this.f1525a, this.f1527c, j);
    }

    public long c(int i) {
        return this.f1525a[i];
    }

    public boolean d(long j, long j2) {
        int iA = b.a(this.f1525a, this.f1527c, j);
        if (iA >= 0) {
            long[] jArr = this.f1526b;
            if (jArr[iA] == j2) {
                return false;
            }
            jArr[iA] = j2;
        } else {
            int i = ~iA;
            this.f1525a = d.d(this.f1525a, this.f1527c, i, j);
            this.f1526b = d.d(this.f1526b, this.f1527c, i, j2);
            this.f1527c++;
        }
        return true;
    }

    public int e() {
        return this.f1527c;
    }

    public void f() {
        this.f1525a = new long[16];
        this.f1526b = new long[16];
        this.f1527c = 0;
    }

    public long g(int i) {
        return this.f1526b[i];
    }

    public java.lang.String toString() {
        if (e() <= 0) {
            return "{}";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.f1527c * 28);
        sb.append('{');
        for (int i = 0; i < this.f1527c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(c(i));
            sb.append('=');
            sb.append(g(i));
        }
        sb.append('}');
        return sb.toString();
    }
}
