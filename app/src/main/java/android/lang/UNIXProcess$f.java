package android.lang;

/* JADX INFO: loaded from: classes.dex */
class UNIXProcess$f extends java.io.BufferedInputStream {
    UNIXProcess$f(int i) {
        super(android.lang.UNIXProcess.g(i));
    }

    private static byte[] a(java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArrCopyOf = null;
        if (inputStream == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int iAvailable = inputStream.available();
            if (iAvailable <= 0) {
                break;
            }
            bArrCopyOf = bArrCopyOf == null ? new byte[iAvailable] : java.util.Arrays.copyOf(bArrCopyOf, i + iAvailable);
            i += inputStream.read(bArrCopyOf, i, iAvailable);
        }
        return (bArrCopyOf == null || i == bArrCopyOf.length) ? bArrCopyOf : java.util.Arrays.copyOf(bArrCopyOf, i);
    }

    synchronized void b() {
        try {
            java.io.InputStream inputStream = this.in;
            if (inputStream != null) {
                byte[] bArrA = a(inputStream);
                inputStream.close();
                this.in = bArrA == null ? android.lang.UNIXProcess$d.f1483a : new java.io.ByteArrayInputStream(bArrA);
                if (this.buf == null) {
                    this.in = null;
                }
            }
        } catch (java.io.IOException unused) {
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }
}
