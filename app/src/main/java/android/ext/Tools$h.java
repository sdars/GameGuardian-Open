package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$h implements java.util.concurrent.Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Process f509a;

    Tools$h(java.lang.Process process) {
        this.f509a = process;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Boolean call() throws java.lang.InterruptedException {
        this.f509a.waitFor();
        return java.lang.Boolean.TRUE;
    }
}
