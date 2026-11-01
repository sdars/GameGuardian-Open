package gg_d;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String[] f1511a = new java.lang.String[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f1513c = new byte[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f1514d = new int[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long[] f1515e = new long[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final java.lang.Object[] f1516f = new java.lang.Object[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean[] f1517g = new boolean[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final android.view.View[] f1512b = new android.view.View[0];

    static int a(long[] jArr, int i, long j) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    public static int b(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    public static int c(int i) {
        return b(i * 8) / 8;
    }
}
