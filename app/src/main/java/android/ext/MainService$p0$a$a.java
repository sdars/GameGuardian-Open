package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$p0$a$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$p0$a f284a;

    MainService$p0$a$a(android.ext.MainService$p0$a mainService$p0$a) {
        this.f284a = mainService$p0$a;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.MainService$p0 mainService$p0 = this.f284a.f283c;
        boolean z = mainService$p0.f279f;
        android.ext.MainService mainService = mainService$p0.f280g;
        if (z) {
            mainService.t0.c();
        } else {
            mainService.m();
        }
        android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
        if (c2Var != null) {
            c2Var.write(this.f284a.f283c.f279f ? "\ngg.clearList()\n" : "\ngg.clearResults()\n");
        }
    }
}
