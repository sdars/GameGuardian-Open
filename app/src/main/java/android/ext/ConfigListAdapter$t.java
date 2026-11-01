package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$t implements android.ext.Config$p$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f91a;

    ConfigListAdapter$t(android.ext.ConfigListAdapter configListAdapter) {
        this.f91a = configListAdapter;
    }

    @Override // android.ext.Config$p$a
    public int a(android.content.DialogInterface dialogInterface, int i) {
        if (i != android.ext.Config.o) {
            android.ext.ConfigListAdapter.m();
        }
        return i;
    }
}
