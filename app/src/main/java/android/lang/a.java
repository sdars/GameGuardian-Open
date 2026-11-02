package android.lang;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static int a(java.io.FileDescriptor fileDescriptor) {
        try {
            java.lang.reflect.Field declaredField = java.io.FileDescriptor.class.getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            return ((java.lang.Integer) declaredField.get(fileDescriptor)).intValue();
        } catch (java.lang.Throwable th) {
            throw new java.lang.RuntimeException("Failed get fd", th);
        }
    }

    static java.lang.Process b(java.lang.String[] strArr, java.util.Map map, java.lang.String str, boolean z) {
        int length = strArr.length - 1;
        byte[][] bArr = new byte[length][];
        int length2 = length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            byte[] bytes = strArr[i2].getBytes();
            bArr[i] = bytes;
            length2 += bytes.length;
            i = i2;
        }
        byte[] bArr2 = new byte[length2];
        int length3 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte[] bArr3 = bArr[i3];
            java.lang.System.arraycopy(bArr3, 0, bArr2, length3, bArr3.length);
            length3 += bArr3.length + 1;
        }
        int[] iArr = new int[1];try {

        return new android.lang.UNIXProcess(c(strArr[0]), bArr2, length, android.lang.ProcessEnvironment.j(map, iArr), iArr[0], c(str), new int[]{-1, -1, -1}, z);
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    private static byte[] c(java.lang.String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[length + 1];
        java.lang.System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        bArr[length] = 0;
        return bArr;
    }
}
