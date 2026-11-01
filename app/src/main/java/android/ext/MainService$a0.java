package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$a0 implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f219a;

    MainService$a0(android.ext.MainService mainService) {
        this.f219a = mainService;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f219a.q(true);
        android.ext.ConfigListAdapter.t(catch_.me_.if_.you_.can_.R.string.help_games_protection_);
    }
}
