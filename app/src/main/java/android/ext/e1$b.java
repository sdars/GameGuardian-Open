package android.ext;

/* JADX INFO: loaded from: classes.dex */
class e1$b implements java.lang.Runnable {
    e1$b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.e1.f735a = true;
        if (android.ext.e1.f736b == null) {
            return;
        }
        try {
            android.ext.e1.f736b.flush();
            android.ext.e1.f736b.close();
            android.ext.e1.f736b = null;
        } catch (java.io.IOException e2) {
            android.ext.e1$e.b("AndroidService", "Log close: I/O", e2);
        }
    }
}
