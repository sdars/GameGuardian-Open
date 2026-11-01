package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$m$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$m f273b;

    MainService$m$b(android.ext.MainService$m mainService$m, int i) {
        this.f273b = mainService$m;
        this.f272a = i;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.MainService$m mainService$m = this.f273b;
        mainService$m.f269b[this.f272a][i].e(mainService$m.f270c.J);
        android.ext.Tools.D(dialogInterface);
    }
}
