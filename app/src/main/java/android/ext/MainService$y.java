package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$y implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f306a;

    MainService$y(android.ext.MainService mainService) {
        this.f306a = mainService;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f306a.q(true);
    }
}
