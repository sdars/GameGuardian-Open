package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$w implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f304a;

    MainService$w(android.ext.MainService mainService) {
        this.f304a = mainService;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_waitpid).f42d = 1;
        android.ext.Config.k();
        android.ext.ConfigListAdapter.m();
    }
}
