package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$c0$c$a$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$c0$c$a f234b;

    MainService$c0$c$a$b(android.ext.MainService$c0$c$a mainService$c0$c$a, java.lang.String str) {
        this.f234b = mainService$c0$c$a;
        this.f233a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.ext.e2.n(this.f233a + " ''", 5);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed unstub app: " + this.f234b.f230a.f229a.f224a, th);
        }
    }
}
