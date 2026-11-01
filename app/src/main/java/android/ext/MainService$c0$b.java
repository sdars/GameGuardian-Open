package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$c0$b implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$c0 f228a;

    MainService$c0$b(android.ext.MainService$c0 mainService$c0) {
        this.f228a = mainService$c0;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.ext.MainService$c0 mainService$c0 = this.f228a;
        mainService$c0.f226c.s0(mainService$c0.f224a, mainService$c0.f225b);
    }
}
