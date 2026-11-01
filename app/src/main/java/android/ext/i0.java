package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long[] f1004a = new long[12];

    static {
        for (int i = 0; i < 3; i++) {
            long j = (1 << ((1 << i) * 8)) - 1;
            long j2 = j >> 1;
            long j3 = ~j2;
            int i2 = i * 4;
            long[] jArr = f1004a;
            jArr[i2] = j & j3;
            jArr[i2 + 1] = j2;
            jArr[i2 + 2] = j3;
            jArr[i2 + 3] = j;
        }
    }

    public static boolean a(long j, long j2, int i) {
        int iY = android.ext.c.y(i);
        if (iY == 3) {
            return j < j2;
        }
        int i2 = iY * 4;
        long[] jArr = f1004a;
        long j3 = jArr[i2];
        long j4 = j & j3;
        long j5 = j3 & j2;
        long j6 = jArr[i2 + 1];
        long j7 = j & j6;
        long j8 = j2 & j6;
        if (j4 == j5) {
            if (j7 >= j8) {
                return false;
            }
        } else if (j4 == 0) {
            return false;
        }
        return true;
    }

    public static long b(long j, int i, boolean z) {
        long j2;
        if (i == 3) {
            return j;
        }
        int i2 = i * 4;
        if (z) {
            j2 = f1004a[i2 + 3];
        } else {
            long[] jArr = f1004a;
            if ((jArr[i2] & j) != 0) {
                return j | jArr[i2 + 2];
            }
            j2 = jArr[i2 + 1];
        }
        return j & j2;
    }

    public static java.lang.String c(long j, int i) {
        return d(j, i, false);
    }

    public static java.lang.String d(long j, int i, boolean z) {
        int iY = android.ext.c.y(i);
        long jB = b(j, iY, z);
        return z ? android.ext.t2.e(1 << (iY + 1), jB) : e(jB);
    }

    private static java.lang.String e(long j) {
        java.lang.String strM1 = android.ext.Tools.M1("%,d", "%d", null, java.lang.Long.valueOf(j));
        if (strM1 == null) {
            try {
                strM1 = java.lang.Long.toString(j);
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Format fail 3", th);
            }
        }
        if (strM1 == null) {
            try {
                strM1 = "" + j;
            } catch (java.lang.Throwable th2) {
                android.ext.e1.s("Format fail 4", th2);
            }
        }
        return strM1 == null ? "fail" : strM1;
    }
}
