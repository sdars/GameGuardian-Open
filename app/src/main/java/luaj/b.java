package luaj;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f1707a = {96, 113, 65, 84, 80, 80, 92, 108, 60, 16, 60, 84, 108, 124, 124, 124, 124, 124, 124, 96, 96, 96, 104, 34, 188, 188, 188, 132, 228, 84, 80, 16, 98, 98, 4, 226, 20, 81, 80, 23, 124, 96, 124, 124, 124, 124, 124};

    public static int c(int i) {
        return (i >>> 6) & 255;
    }

    public static int d(int i) {
        return (i >>> 6) & 67108863;
    }

    public static int e(int i) {
        return (i >>> 23) & 511;
    }

    public static int f(int i) {
        return (i >>> 14) & 262143;
    }

    public static int g(int i) {
        return (i >>> 14) & 511;
    }

    public static int h(int i) {
        return ((i >>> 14) & 262143) - 131071;
    }

    public static int i(int i) {
        return i & 63;
    }

    public static int j(int i) {
        return i & (-257);
    }

    public static boolean k(int i) {
        return (i & 256) != 0;
    }

    public static int l(int i) {
        return i | 256;
    }

    public static java.lang.String m(java.lang.String str) {
        if (str.startsWith("=")) {
            return str.substring(1);
        }
        if (str.startsWith("@")) {
            str = str.substring(1);
        }
        if (new java.io.File(str).exists()) {
            return str;
        }
        if (str.length() > 69) {
            str = str.substring(0, 66) + "...";
        }
        return "[string '" + str + "']";
    }

    public static int n(int i) {
        return (f1707a[i] >>> 4) & 3;
    }

    public static int o(int i) {
        return (f1707a[i] >>> 2) & 3;
    }

    public static int p(int i) {
        return f1707a[i] & 3;
    }

    public static boolean q(int i) {
        return (f1707a[i] & 64) != 0;
    }

    public static boolean r(int i) {
        return (f1707a[i] & 128) != 0;
    }
}
