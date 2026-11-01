package android.ext;

/* JADX INFO: loaded from: classes.dex */
class PathSelector$c$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.PathSelector$c f333b;

    PathSelector$c$a(android.ext.PathSelector$c pathSelector$c, int i) {
        this.f333b = pathSelector$c;
        this.f332a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f333b.f327c.setSelection(this.f332a);
    }
}
