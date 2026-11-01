package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$c0$c$a$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Intent f231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$c0$c$a f232b;

    MainService$c0$c$a$a(android.ext.MainService$c0$c$a mainService$c0$c$a, android.content.Intent intent) {
        this.f232b = mainService$c0$c$a;
        this.f231a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.ext.Tools.f0().startActivity(this.f231a);
        } catch (java.lang.Exception e2) {
            android.ext.e1.l("Failed restart app 2: " + this.f232b.f230a.f229a.f224a, e2);
        }
    }
}
