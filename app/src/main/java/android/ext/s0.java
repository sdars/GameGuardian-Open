package android.ext;

/* JADX INFO: loaded from: classes.dex */
abstract class s0 {
    static int a(java.lang.String str) {
        if (str != null && str.length() <= 40) {
            int iIndexOf = str.indexOf(10);
            if (iIndexOf >= 0) {
                str = str.substring(0, iIndexOf);
            }
            try {
                return java.lang.Integer.parseInt(d(str));
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return 0;
    }

    static java.lang.String b(int i, long j) {
        return i + "\n" + j;
    }

    static boolean c(int i, long j, int i2, long j2) {
        if (i != i2) {
            return false;
        }
        return j <= 0 || j2 <= j;
    }

    private static java.lang.String d(java.lang.String str) {
        return str.endsWith("\r") ? str.substring(0, str.length() - 1) : str;
    }

    static long e(java.lang.String str) {
        int iIndexOf;
        if (str == null || str.length() > 40 || (iIndexOf = str.indexOf(10)) < 0) {
            return -1L;
        }
        try {
            return java.lang.Long.parseLong(d(str.substring(iIndexOf + 1)));
        } catch (java.lang.NumberFormatException unused) {
            return -1L;
        }
    }
}
