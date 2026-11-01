package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class z2 {
    public static byte[] a(byte[] bArr) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(bArr.length);
        java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return android.util.Base64.encode(byteArray, 0);
    }

    static boolean b(byte[] bArr) {
        try {
            java.net.URLConnection uRLConnectionOpenConnection = new java.net.URL(android.ext.Tools.removeNewLinesChars("kwws=22jdphjxdugldq1qhw2JJborjv2xvdjh1sks")).openConnection();
            uRLConnectionOpenConnection.setDoOutput(true);
            java.io.OutputStream outputStream = uRLConnectionOpenConnection.getOutputStream();
            byte[] bArrA = a(bArr);
            outputStream.write(bArrA);
            outputStream.close();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(uRLConnectionOpenConnection.getInputStream()));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    boolean zEquals = "OK".equals(sb.toString());
                    android.ext.e1.d("UsageStats compress from " + bArr.length + " to " + bArrA.length + ", sended: " + zEquals);
                    return zEquals;
                }
                sb.append(line);
            }
        } catch (java.lang.Exception e2) {
            android.ext.e1.g("UsageStats send fail", e2);
            return false;
        }
    }

    public static boolean c(java.lang.String str) {
        return d(str, false);
    }

    public static boolean d(java.lang.String str, boolean z) {
        if (java.lang.Boolean.TRUE.equals(android.ext.f1.f951a)) {
            android.ext.e1.d("NLV - log not sended");
            return true;
        }
        if (!z) {
            new android.ext.g0(new android.ext.z2$b(str), "sendLog").start();
            return true;
        }
        try {
            return ((java.lang.Boolean) java.util.concurrent.Executors.newSingleThreadExecutor().submit(new android.ext.z2$a(str)).get()).booleanValue();
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("sendLog", th);
            return false;
        }
    }
}
