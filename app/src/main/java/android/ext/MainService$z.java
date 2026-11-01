package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$z implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f307a;

    MainService$z(android.ext.MainService mainService) {
        this.f307a = mainService;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.ConfigListAdapter.a(null);
    }
}
