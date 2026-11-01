package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$f0 implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f241a;

    MainService$f0(android.ext.MainService mainService) {
        this.f241a = mainService;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_check_libs).f42d = 0;
        android.ext.Config.k();
    }
}
