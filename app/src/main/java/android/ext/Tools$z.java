package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Tools$z implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final java.lang.Runnable f556a;

    public Tools$z(java.lang.Runnable runnable) {
        this.f556a = runnable;
    }

    public static java.lang.Runnable a(java.lang.Runnable runnable) {
        return !(runnable instanceof android.ext.Tools$z) ? new android.ext.Tools$z(runnable) : runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f556a.run();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }
}
