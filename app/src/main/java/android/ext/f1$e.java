package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$e implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f961b;

    f1$e(boolean[] zArr, java.lang.Runnable runnable) {
        this.f960a = zArr;
        this.f961b = runnable;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f960a[0] = true;
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.fix_it)).setItems(new java.lang.String[]{android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_prevent_unload).toString(), android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_ram).toString()}, new android.ext.f1$e$a(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
        if (this.f961b != null) {
            android.ext.f.k(alertDialogCreate, new android.ext.f1$e$b(this));
        }
        android.ext.f.m(alertDialogCreate);
    }
}
