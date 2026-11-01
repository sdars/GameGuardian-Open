package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$r$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter$r f89a;

    ConfigListAdapter$r$a(android.ext.ConfigListAdapter$r configListAdapter$r) {
        this.f89a = configListAdapter$r;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            android.ext.k.i((java.lang.String) this.f89a.f88c.get(i));
            android.ext.ConfigListAdapter.m();
        } catch (java.lang.IndexOutOfBoundsException e2) {
            android.ext.e1.l("Failed get locale for index: " + i, e2);
        }
        android.ext.Tools.D(dialogInterface);
    }
}
