package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$c0$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$c0 f227a;

    MainService$c0$a(android.ext.MainService$c0 mainService$c0) {
        this.f227a = mainService$c0;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService$c0 mainService$c0 = this.f227a;
        mainService$c0.f226c.h.c(true, mainService$c0.f224a);
    }
}
