package gg_d;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f1507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f1508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean[] f1509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1510d;

    public a() {
        this(0);
    }

    public a(int i) {
        h(b.c(i));
    }

    private void g() {
        int i = this.f1510d;
        h(i + (i < 6 ? 12 : i >> 1));
    }

    private void h(int i) {
        boolean[] zArr;
        long[] jArr;
        int[] iArr;
        if (i == 0) {
            jArr = b.f1515e;
            iArr = b.f1514d;
            zArr = b.f1517g;
        } else {
            int[] iArr2 = new int[i];
            zArr = new boolean[i];
            jArr = new long[i * 2];
            iArr = iArr2;
        }
        int i2 = this.f1510d;
        if (i2 != 0) {
            java.lang.System.arraycopy(this.f1507a, 0, jArr, 0, i2 * 2);
            java.lang.System.arraycopy(this.f1508b, 0, iArr, 0, i2);
            java.lang.System.arraycopy(this.f1509c, 0, zArr, 0, i2);
        }
        this.f1507a = jArr;
        this.f1508b = iArr;
        this.f1509c = zArr;
    }

    static java.lang.IndexOutOfBoundsException j(int i, int i2) {
        throw new java.lang.IndexOutOfBoundsException("Invalid index " + i + ", size is " + i2);
    }

    public void a(long j, long j2, int i, boolean z) {
        int i2 = this.f1510d;
        if (i2 == this.f1508b.length) {
            g();
        }
        long[] jArr = this.f1507a;
        int i3 = i2 * 2;
        jArr[i3] = j;
        jArr[i3 + 1] = j2;
        this.f1508b[i2] = i;
        this.f1509c[i2] = z;
        this.f1510d = i2 + 1;
    }

    public void b(int i, boolean z) {
        this.f1509c[i] = z;
    }

    public boolean c(int i) {
        return this.f1509c[i];
    }

    public void d() {
        this.f1510d = 0;
    }

    public void e(int i) {
        if (this.f1508b.length < i) {
            h(i);
        }
    }

    public android.ext.c f(int i, android.ext.c cVar) {
        int i2 = this.f1510d;
        if (i >= i2) {
            j(i, i2);
        }
        if (cVar == null) {
            long[] jArr = this.f1507a;
            int i3 = i * 2;
            return new android.ext.c(jArr[i3], jArr[i3 + 1], this.f1508b[i]);
        }
        long[] jArr2 = this.f1507a;
        int i4 = i * 2;
        cVar.f672a = jArr2[i4];
        cVar.f673b = jArr2[i4 + 1];
        cVar.f674c = this.f1508b[i];
        return cVar;
    }

    public int i() {
        return this.f1510d;
    }

    public void k() {
        int i = this.f1510d;
        if (i == this.f1509c.length) {
            return;
        }
        h(i);
    }
}
