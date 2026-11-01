package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class w0 {
    public static final java.lang.String a(java.lang.Object obj, java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            if (obj instanceof java.io.File) {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream((java.io.File) obj);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i);
                }
                fileInputStream.close();
            } else {
                messageDigest.update(obj.toString().getBytes());
            }
            return b(messageDigest);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("hash fail", th);
            return th.toString();
        }
    }

    public static final java.lang.String b(java.security.MessageDigest messageDigest) {
        byte[] bArrDigest = messageDigest.digest();
        byte[] bArr = new byte[8];
        java.lang.System.arraycopy(bArrDigest, 0, bArr, 0, 4);
        java.lang.System.arraycopy(bArrDigest, bArrDigest.length - 4, bArr, 4, 4);
        return android.ext.Tools.l(bArr);
    }
}
