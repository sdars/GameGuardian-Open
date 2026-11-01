package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$s implements android.ext.Config$p$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f90a;

    ConfigListAdapter$s(android.ext.ConfigListAdapter configListAdapter) {
        this.f90a = configListAdapter;
    }

    @Override // android.ext.Config$p$a
    public int a(android.content.DialogInterface dialogInterface, int i) {
        if (i != 1 || android.ext.InternalKeyboard.a()) {
            return i;
        }
        android.ext.MainService.I0();
        return 0;
    }
}
