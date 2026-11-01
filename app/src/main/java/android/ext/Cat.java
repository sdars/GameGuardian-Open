package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Cat {
    public static void main(java.lang.String[] strArr) throws java.io.IOException {
        byte[] bArr = new byte[8192];
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(strArr[0]);
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i < 0) {
                fileInputStream.close();
                return;
            }
            java.lang.System.out.write(bArr, 0, i);
        }
    }
}
