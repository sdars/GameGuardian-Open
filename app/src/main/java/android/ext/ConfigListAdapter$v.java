package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$v implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f98a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f99b;

    ConfigListAdapter$v(android.ext.ConfigListAdapter configListAdapter, android.ext.MainService mainService) {
        this.f99b = configListAdapter;
        this.f98a = mainService;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f98a.v0();
    }
}
