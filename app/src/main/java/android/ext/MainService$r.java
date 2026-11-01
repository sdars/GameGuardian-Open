package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$r implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f293a;

    MainService$r(android.ext.MainService mainService) {
        this.f293a = mainService;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f293a.O();
    }
}
