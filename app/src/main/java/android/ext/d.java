package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gg_d.f[] f700a;

    public d() {
        this(10);
    }

    public d(int i) {
        gg_d.f[] fVarArr = new gg_d.f[7];
        for (int i2 = 0; i2 < 7; i2++) {
            fVarArr[i2] = new gg_d.f(i);
        }
        this.f700a = fVarArr;
    }

    public void a(long j, int i, android.ext.d$a d_a) {
        boolean z;
        gg_d.f fVar;
        int iB;
        int iNumberOfTrailingZeros = java.lang.Integer.numberOfTrailingZeros(i);
        if (iNumberOfTrailingZeros >= 7 || (iB = (fVar = this.f700a[iNumberOfTrailingZeros]).b(j)) < 0) {
            z = false;
        } else {
            d_a.f701a = fVar.g(iB);
            z = true;
        }
        d_a.f702b = z;
    }

    public java.util.List b() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        gg_d.f[] fVarArr = this.f700a;
        for (int i = 0; i < 7; i++) {
            gg_d.f fVar = fVarArr[i];
            int iE = fVar.e();
            if (iE > 0) {
                int i2 = 1 << i;
                for (int i3 = 0; i3 < iE; i3++) {
                    try {
                        android.ext.c cVar = new android.ext.c();
                        cVar.f674c = i2;
                        cVar.f672a = fVar.c(i3);
                        cVar.f673b = fVar.g(i3);
                        arrayList.add(cVar);
                    } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
                        android.ext.e1.s("Concurent modification for " + i, e2);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean c(long j, int i, long j2) {
        int iNumberOfTrailingZeros = java.lang.Integer.numberOfTrailingZeros(i);
        if (iNumberOfTrailingZeros < 7) {
            return this.f700a[iNumberOfTrailingZeros].d(j, j2);
        }
        return false;
    }

    public void d() {
        gg_d.f[] fVarArr = this.f700a;
        boolean z = false;
        for (int i = 0; i < 7; i++) {
            gg_d.f fVar = fVarArr[i];
            int iE = fVar.e();
            if (iE > 0) {
                if (!z) {
                    z = true;
                }
                int i2 = (1 << i) | 16777216;
                for (int i3 = 0; i3 < iE; i3++) {
                    try {
                        android.ext.c cVar = new android.ext.c();
                        cVar.f674c = i2;
                        cVar.f672a = fVar.c(i3);
                        cVar.f673b = fVar.g(i3);
                        cVar.a();
                    } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
                        android.ext.e1.s("Concurent modification for " + i, e2);
                    }
                }
            }
        }
        if (z) {
            android.ext.MainService.instance.e0();
        }
    }

    public int e() {
        gg_d.f[] fVarArr = this.f700a;
        int iE = 0;
        for (int i = 0; i < 7; i++) {
            iE += fVarArr[i].e();
        }
        return iE;
    }

    public void f() {
        gg_d.f[] fVarArr = this.f700a;
        for (int i = 0; i < 7; i++) {
            fVarArr[i].f();
        }
    }
}
