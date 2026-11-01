package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.ThreadLocal f1264a = new android.ext.t2$a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f1265b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static java.lang.Appendable a(java.lang.Appendable appendable, int i, char c2, java.lang.String str) {
        try {
            int length = i - str.length();
            for (int i2 = 0; i2 < length; i2++) {
                appendable.append(c2);
            }
            return appendable.append(str);
        } catch (java.io.IOException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    public static java.lang.String b(int i, char c2, java.lang.String str) {
        int length = str.length();
        if (length >= i) {
            return str;
        }
        char[] cArr = (char[]) f1264a.get();
        int i2 = i - length;
        java.util.Arrays.fill(cArr, 0, i2, c2);
        str.getChars(0, length, cArr, i2);
        return new java.lang.String(cArr, 0, i);
    }

    public static java.lang.Appendable c(java.lang.Appendable appendable, int i, int i2) {
        return a(appendable, i, '0', java.lang.Integer.toHexString(i2).toUpperCase(java.util.Locale.US));
    }

    public static java.lang.Appendable d(java.lang.Appendable appendable, int i, long j) {
        return a(appendable, i, '0', java.lang.Long.toHexString(j).toUpperCase(java.util.Locale.US));
    }

    public static java.lang.String e(int i, long j) {
        return b(i, '0', java.lang.Long.toHexString(j).toUpperCase(java.util.Locale.US));
    }

    public static java.lang.String f(java.lang.String str, java.lang.Object... objArr) {
        return android.ext.Tools.L1(str, objArr);
    }

    public static java.lang.String g(int i) {
        char[] cArr = new char[7];
        boolean z = i < 0;
        if (!z) {
            i = -i;
        }
        char[] cArr2 = f1265b;
        int i2 = 6;
        while (i <= -64) {
            cArr[i2] = cArr2[-(i % 64)];
            i /= 64;
            i2--;
        }
        cArr[i2] = cArr2[-i];
        if (z) {
            i2--;
            cArr[i2] = '-';
        }
        return new java.lang.String(cArr, i2, 7 - i2);
    }

    public static java.lang.String h(long j) {
        char[] cArr = new char[12];
        boolean z = j < 0;
        if (!z) {
            j = -j;
        }
        char[] cArr2 = f1265b;
        int i = 11;
        while (j <= -64) {
            cArr[i] = cArr2[(int) (-(j % 64))];
            j /= 64;
            i--;
        }
        cArr[i] = cArr2[(int) (-j)];
        if (z) {
            i--;
            cArr[i] = '-';
        }
        return new java.lang.String(cArr, i, 12 - i);
    }
}
