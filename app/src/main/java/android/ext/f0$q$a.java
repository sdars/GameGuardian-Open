package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$q$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f0$q f927a;

    f0$q$a(android.ext.f0$q f0_q) {
        this.f927a = f0_q;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_hide_from_game).f42d = 0;
        android.ext.Config.k();
    }
}
