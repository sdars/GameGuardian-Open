package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$j0$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String[] f256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$j0 f257b;

    MainService$j0$b(android.ext.MainService$j0 mainService$j0, java.lang.String[] strArr) {
        this.f257b = mainService$j0;
        this.f256a = strArr;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Tools.z(this.f256a[i]);
        android.ext.Tools.D(dialogInterface);
    }
}
