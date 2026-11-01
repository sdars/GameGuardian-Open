package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$c implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.io.File f959a;

    f1$c(java.io.File file) {
        this.f959a = file;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f959a.delete();
        if (i != 0) {
            return;
        }
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.selinux).f42d = 1;
        android.ext.Config.k();
        android.ext.r.I();
    }
}
