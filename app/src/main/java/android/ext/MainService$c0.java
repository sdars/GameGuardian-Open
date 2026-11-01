package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$c0 implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f226c;

    MainService$c0(android.ext.MainService mainService, java.lang.String str, boolean z) {
        this.f226c = mainService;
        this.f224a = str;
        this.f225b = z;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        boolean z = false;
        this.f226c.F0 = false;
        if (i == 0) {
            new android.ext.p0(1100).onClick(dialogInterface, i);
        } else if (i == 1) {
            android.ext.e1.d("Restart: " + this.f224a);
            try {
                android.content.Intent launchIntentForPackage = android.ext.Tools.B0().getLaunchIntentForPackage(this.f224a);
                if (launchIntentForPackage == null) {
                    launchIntentForPackage = new android.content.Intent("android.intent.action.MAIN");
                    launchIntentForPackage.setPackage(this.f224a);
                }
                launchIntentForPackage.setFlags(268435456);
                android.ext.Tools.f0().startActivity(launchIntentForPackage);
                z = true;
            } catch (java.lang.Exception e2) {
                android.ext.e1.l("Failed restart app: " + this.f224a, e2);
            }
            android.ext.n2.d().postDelayed(new android.ext.MainService$c0$a(this), z ? 4000L : 0L);
        } else if (i != 2) {
            if (i == 3) {
                android.ext.ConfigListAdapter.t(catch_.me_.if_.you_.can_.R.string.help_games_protection_title);
            }
            this.f226c.h.g();
        } else if (android.ext.f1.z(null, new android.ext.MainService$c0$b(this))) {
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.restart_game_without_protection)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.warn_restart_off_prot)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), new android.ext.MainService$c0$c(this)));
        }
        android.ext.Tools.D(dialogInterface);
    }
}
