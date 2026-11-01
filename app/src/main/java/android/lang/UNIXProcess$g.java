package android.lang;

/* JADX INFO: loaded from: classes.dex */
class UNIXProcess$g extends java.io.BufferedOutputStream {
    UNIXProcess$g(int i) {
        super(android.lang.UNIXProcess.h(i));
    }

    synchronized void a() {
        try {
            java.io.OutputStream outputStream = this.out;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (java.io.IOException unused) {
                }
                this.out = android.lang.UNIXProcess$e.f1484a;
            }
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }
}
