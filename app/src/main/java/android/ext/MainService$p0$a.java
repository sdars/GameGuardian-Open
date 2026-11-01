package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$p0$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.Object f282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$p0 f283c;

    MainService$p0$a(android.ext.MainService$p0 mainService$p0, int i, java.lang.Object obj) {
        this.f283c = mainService$p0;
        this.f281a = i;
        this.f282b = obj;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i > 2 && this.f281a == 0) {
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.nothing_selected);
            return;
        }
        if (i == 0) {
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.remove_all2)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), new android.ext.MainService$p0$a$a(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null));
            return;
        }
        if (i == 1) {
            android.ext.n2.d().postDelayed(new android.ext.MainService$p0$a$b(this, dialogInterface), 1000L);
            return;
        }
        if (i == 2) {
            this.f283c.f280g.L0(this.f282b, null);
        } else if (i != 3) {
            return;
        }
        this.f283c.f280g.H0(this.f282b);
    }
}
