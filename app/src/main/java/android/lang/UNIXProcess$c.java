package android.lang;

/* JADX INFO: loaded from: classes.dex */
class UNIXProcess$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.lang.UNIXProcess f1482a;

    UNIXProcess$c(android.lang.UNIXProcess uNIXProcess) {
        this.f1482a = uNIXProcess;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.lang.UNIXProcess uNIXProcess = this.f1482a;
        this.f1482a.k(uNIXProcess.waitForProcessExit(uNIXProcess.pid));
    }
}
