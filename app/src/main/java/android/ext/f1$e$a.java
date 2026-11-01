package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$e$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f1$e f962a;

    f1$e$a(android.ext.f1$e f1_e) {
        this.f962a = f1_e;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        int i2;
        if (i == 0) {
            i2 = catch_.me_.if_.you_.can_.R.id.config_prevent_unload;
        } else if (i != 1) {
            return;
        } else {
            i2 = catch_.me_.if_.you_.can_.R.id.config_ram;
        }
        android.ext.Config.b(i2).b();
    }
}
