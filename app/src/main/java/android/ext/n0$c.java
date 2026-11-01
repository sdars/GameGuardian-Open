package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n0$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.io.File f1109a;

    n0$c(java.io.File file) {
        this.f1109a = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1109a.delete();
    }
}
