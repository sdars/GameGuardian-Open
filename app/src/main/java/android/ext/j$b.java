package android.ext;

/* JADX INFO: loaded from: classes.dex */
class j$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.util.List f1026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.j f1027c;

    j$b(android.ext.j jVar, int i, java.util.List list) {
        this.f1027c = jVar;
        this.f1025a = i;
        this.f1026b = list;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == this.f1025a) {
            android.ext.ConfigListAdapter.t(catch_.me_.if_.you_.can_.R.string.help_game_not_listed_title);
            return;
        }
        this.f1027c.f((android.ext.z1$d) this.f1026b.get(i));
        this.f1027c.f1020b = true;
        android.ext.Tools.D(dialogInterface);
        java.lang.Runnable runnable = this.f1027c.f1021c;
        if (runnable != null) {
            this.f1027c.f1021c = null;
            runnable.run();
        }
    }
}
