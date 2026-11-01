package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z2$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1443a;

    z2$b(java.lang.String str) {
        this.f1443a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            try {
                android.ext.z2.b(this.f1443a.getBytes());
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }
}
