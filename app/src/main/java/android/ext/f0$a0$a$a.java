package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$a0$a$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f0$a0$a f805a;

    f0$a0$a$a(android.ext.f0$a0$a f0_a0_a) {
        this.f805a = f0_a0_a;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (!android.ext.Config.vSpaceReal || android.ext.Config.C || (android.ext.Config.B & 512) == 0) {
            android.ext.ConfigListAdapter.t(catch_.me_.if_.you_.can_.R.string.work_without_root);
        } else {
            android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_vspace_root).b();
        }
    }
}
