package android.ext;

/* JADX INFO: loaded from: classes.dex */
class p2$a implements java.lang.Runnable {
    p2$a() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0007 -> B:7:0x000c). Please report as a decompilation issue!!! */
    @Override // java.lang.Runnable
    public void run() {
        android.widget.Toast toast;
        try {
            java.lang.Thread.sleep(3000L);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("toastThread", th);
        }
        while (!java.lang.Thread.currentThread().isInterrupted()) {
            synchronized (android.ext.p2.f1177b) {
                try {
                    toast = android.ext.p2.f1176a;
                    android.widget.Toast unused = android.ext.p2.f1176a = null;
                } catch (java.lang.Throwable th2_c_c_c) {
                    throw th2_c_c_c;
                }
            }
            if ((android.ext.Config.B & 8192) != 0) {
                android.ext.n2.i(new android.ext.p2$a$a(this));
            }
            android.ext.p2.f(toast);try {

            java.lang.Thread.sleep(1500L);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        }
    }
}
