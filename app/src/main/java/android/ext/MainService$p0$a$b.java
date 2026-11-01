package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$p0$a$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.DialogInterface f285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$p0$a f286b;

    MainService$p0$a$b(android.ext.MainService$p0$a mainService$p0$a, android.content.DialogInterface dialogInterface) {
        this.f286b = mainService$p0$a;
        this.f285a = dialogInterface;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.f.m((android.app.AlertDialog) this.f285a);
    }
}
