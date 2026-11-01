package android.ext;

/* JADX INFO: loaded from: classes.dex */
class r$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f1213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.r f1214b;

    r$b(android.ext.r rVar, java.lang.Runnable runnable) {
        this.f1214b = rVar;
        this.f1213a = runnable;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.f1213a.run();
        } else if (i != 1) {
            new android.ext.p0(1500).onClick(null, 0);
        } else {
            android.ext.f.o(android.ext.f.c(android.ext.r.p).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.how_no_root)).setCancelable(false).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), new android.ext.r$b$a(this)));
            android.ext.r.k();
        }
    }
}
