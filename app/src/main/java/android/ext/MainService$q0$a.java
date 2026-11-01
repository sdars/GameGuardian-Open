package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$q0$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$q0 f290a;

    MainService$q0$a(android.ext.MainService$q0 mainService$q0) {
        this.f290a = mainService$q0;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.MainService$q0 mainService$q0 = this.f290a;
        mainService$q0.f288f = i;
        mainService$q0.h();
    }
}
