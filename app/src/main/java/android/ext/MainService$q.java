package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$q implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f287a;

    MainService$q(android.ext.MainService mainService) {
        this.f287a = mainService;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f287a.P();
    }
}
