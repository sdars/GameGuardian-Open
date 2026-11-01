package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f57a;

    ConfigListAdapter$b(android.ext.ConfigListAdapter configListAdapter) {
        this.f57a = configListAdapter;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Config.f30c = 0L;
        android.ext.Config.k();
    }
}
