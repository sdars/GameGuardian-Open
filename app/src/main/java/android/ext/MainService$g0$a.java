package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$g0$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$g0 f244a;

    MainService$g0$a(android.ext.MainService$g0 mainService$g0) {
        this.f244a = mainService$g0;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Tools.I1(catch_.me_.if_.you_.can_.R.string.reinstall_started, 0);
        new android.ext.n0$i(new android.ext.MainService$g0$a$a(this), "FixLibs").start();
    }
}
