package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$c implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f58a;

    ConfigListAdapter$c(android.ext.ConfigListAdapter configListAdapter) {
        this.f58a = configListAdapter;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.ConfigListAdapter.j(i);
    }
}
