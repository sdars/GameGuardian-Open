package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$l0$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$l0 f267a;

    MainService$l0$a(android.ext.MainService$l0 mainService$l0) {
        this.f267a = mainService$l0;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.MainService$l0 mainService$l0 = this.f267a;
        mainService$l0.f265f = i;
        mainService$l0.i();
    }
}
