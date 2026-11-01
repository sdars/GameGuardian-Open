package android.lang;

/* JADX INFO: loaded from: classes.dex */
abstract class ProcessEnvironment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.HashMap f1458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final java.util.Map f1459b;

    static {
        byte[][] bArrEnviron = environ();
        f1458a = new java.util.HashMap((bArrEnviron.length / 2) + 3);
        for (int length = bArrEnviron.length - 1; length > 0; length -= 2) {
            f1458a.put(android.lang.ProcessEnvironment$h.d(bArrEnviron[length - 1]), android.lang.ProcessEnvironment$g.d(bArrEnviron[length]));
        }
        f1459b = java.util.Collections.unmodifiableMap(new android.lang.ProcessEnvironment$d(f1458a));
    }

    private static native byte[][] environ();

    static int f(byte[] bArr, byte[] bArr2) {
        int length = bArr.length < bArr2.length ? bArr.length : bArr2.length;
        for (int i = 0; i < length; i++) {
            byte b2 = bArr[i];
            byte b3 = bArr2[i];
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return bArr.length - bArr2.length;
    }

    static boolean g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    static int h(byte[] bArr) {
        int i = 0;
        for (byte b2 : bArr) {
            i = (i * 31) + b2;
        }
        return i;
    }

    static java.util.Map i(int i) {
        return new android.lang.ProcessEnvironment$d(new java.util.HashMap(i));
    }

    static byte[] j(java.util.Map map, int[] iArr) {
        if (map == null) {
            return null;
        }
        return ((android.lang.ProcessEnvironment$d) map).d(iArr);
    }

    static void k(java.lang.String str) {
        if (str.indexOf(0) == -1) {
            return;
        }
        throw new java.lang.IllegalArgumentException("Invalid environment variable value: \"" + str + '\"');
    }

    static void l(java.lang.String str) {
        if (str.indexOf(61) == -1 && str.indexOf(0) == -1) {
            return;
        }
        throw new java.lang.IllegalArgumentException("Invalid environment variable name: \"" + str + '\"');
    }
}
