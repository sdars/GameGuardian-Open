package gg_d;

/* JADX INFO: loaded from: classes.dex */
public class e implements java.lang.Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final java.lang.Object f1519f = new java.lang.Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f1521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private java.lang.Object[] f1522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean[] f1523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1524e;

    public e() {
        this(16);
    }

    public e(int i) {
        this.f1520a = false;
        if (i == 0) {
            this.f1521b = b.f1515e;
            this.f1522c = b.f1516f;
            this.f1523d = b.f1517g;
        } else {
            int iC = b.c(i);
            this.f1521b = new long[iC];
            this.f1522c = new java.lang.Object[iC];
            this.f1523d = new boolean[iC];
        }
        this.f1524e = 0;
    }

    private void d() {
        int i = this.f1524e;
        long[] jArr = this.f1521b;
        java.lang.Object[] objArr = this.f1522c;
        boolean[] zArr = this.f1523d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            java.lang.Object obj = objArr[i3];
            if (obj != f1519f) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    zArr[i2] = zArr[i3];
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1520a = false;
        this.f1524e = i2;
    }

    public boolean a(int i) {
        if (this.f1520a) {
            d();
        }
        return this.f1523d[i];
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e clone() {
        e eVar = null;
        try {
            e eVar2 = (e) super.clone();
            try {                if (android.ext.GgNoop.never) {
                        throw new java.lang.CloneNotSupportedException();
                    }

                eVar2.f1521b = (long[]) this.f1521b.clone();
                eVar2.f1522c = (java.lang.Object[]) this.f1522c.clone();
                eVar2.f1523d = (boolean[]) this.f1523d.clone();
                return eVar2;
            } catch (java.lang.CloneNotSupportedException unused) {
                eVar = eVar2;
                return eVar;
            }
        } catch (java.lang.CloneNotSupportedException unused2) {
        }
        return eVar;
    }

    public java.lang.Object c(long j) {
        java.lang.Object[] objArr;
        java.lang.Object obj;
        java.lang.Object obj2;
        int iA = b.a(this.f1521b, this.f1524e, j);
        if (iA < 0 || (obj = (objArr = this.f1522c)[iA]) == (obj2 = f1519f)) {
            return null;
        }
        objArr[iA] = obj2;
        this.f1520a = true;
        return obj;
    }

    public java.lang.Object e(long j) {
        return f(j, null);
    }

    public java.lang.Object f(long j, java.lang.Object obj) {
        java.lang.Object obj2;
        int iA = b.a(this.f1521b, this.f1524e, j);
        return (iA < 0 || (obj2 = this.f1522c[iA]) == f1519f) ? obj : obj2;
    }

    public int g(long j) {
        if (this.f1520a) {
            d();
        }
        return b.a(this.f1521b, this.f1524e, j);
    }

    public long h(int i) {
        if (this.f1520a) {
            d();
        }
        return this.f1521b[i];
    }

    public java.lang.Object i(long j, java.lang.Object obj, byte b2) {
        int iA = b.a(this.f1521b, this.f1524e, j);
        if (iA >= 0) {
            java.lang.Object[] objArr = this.f1522c;
            java.lang.Object obj2 = objArr[iA];
            objArr[iA] = obj;
            if (b2 != 0) {
                this.f1523d[iA] = b2 == 1;
            }
            return obj2;
        }
        int i = ~iA;
        int i2 = this.f1524e;
        if (i < i2) {
            java.lang.Object[] objArr2 = this.f1522c;
            if (objArr2[i] == f1519f) {
                this.f1521b[i] = j;
                objArr2[i] = obj;
                if (b2 != 0) {
                    this.f1523d[i] = b2 == 1;
                }
                return null;
            }
        }
        if (this.f1520a && i2 >= this.f1521b.length) {
            d();
            i = ~b.a(this.f1521b, this.f1524e, j);
        }
        this.f1521b = d.d(this.f1521b, this.f1524e, i, j);
        this.f1522c = d.e(this.f1522c, this.f1524e, i, obj);
        this.f1523d = d.f(this.f1523d, this.f1524e, i, b2 == 1);
        this.f1524e++;
        return null;
    }

    public java.lang.Object j(int i) {
        java.lang.Object[] objArr = this.f1522c;
        java.lang.Object obj = objArr[i];
        java.lang.Object obj2 = f1519f;
        if (obj == obj2) {
            return null;
        }
        objArr[i] = obj2;
        this.f1520a = true;
        return obj;
    }

    public void k(int i, boolean z) {
        if (this.f1520a) {
            d();
        }
        this.f1523d[i] = z;
    }

    public int l() {
        if (this.f1520a) {
            d();
        }
        return this.f1524e;
    }

    public void m() {
        this.f1521b = new long[16];
        this.f1522c = new java.lang.Object[16];
        this.f1523d = new boolean[16];
        this.f1524e = 0;
        this.f1520a = false;
    }

    public java.lang.Object n(int i) {
        if (this.f1520a) {
            d();
        }
        return this.f1522c[i];
    }

    public java.lang.String toString() {
        if (l() <= 0) {
            return "{}";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.f1524e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1524e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(h(i));
            sb.append('=');
            java.lang.Object objN = n(i);
            if (objN != this) {
                sb.append(objN);
            } else {
                sb.append("(this Map)");
            }
            sb.append(" [");
            sb.append(a(i));
            sb.append("]");
        }
        sb.append('}');
        return sb.toString();
    }
}
