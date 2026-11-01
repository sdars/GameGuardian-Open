package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$d implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f59a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f60b;

    ConfigListAdapter$d(android.ext.ConfigListAdapter configListAdapter, android.ext.MainService mainService) {
        this.f60b = configListAdapter;
        this.f59a = mainService;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f59a.i.s();
    }
}
