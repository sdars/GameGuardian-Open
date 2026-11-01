package luaj;

/* JADX INFO: loaded from: classes.dex */
class a$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ luaj.a$b f1702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ luaj.a f1703b;

    a$a(luaj.a aVar, luaj.a$b a_b) {
        this.f1703b = aVar;
        this.f1702a = a_b;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.app.AlertDialog.Builder neutralButton = android.ext.f.c(android.ext.Tools.f0()).setMessage(this.f1703b.j + "\n\n" + android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.invalid_header), this.f1702a.f1706a)).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it), new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2wrslf2594440elqdu|0vfulswv0zlwk0fruuxswhg0ru0lqydolg0khdghuv2"));
        luaj.a$a$a a_a_a = new luaj.a$a$a(this);
        if (android.ext.Tools.f489a.nextBoolean()) {
            neutralButton.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), a_a_a).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null);
        } else {
            neutralButton.setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), a_a_a).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null);
        }
        android.app.AlertDialog alertDialogCreate = neutralButton.create();
        android.ext.f.k(alertDialogCreate, new luaj.a$a$b(this));
        android.ext.f.m(alertDialogCreate);
    }
}
