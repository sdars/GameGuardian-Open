package android.ext;

/* JADX INFO: loaded from: classes.dex */
class x$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.x f1298a;

    x$b(android.ext.x xVar) {
        this.f1298a = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.x xVar = this.f1298a;
        xVar.k = -1L;
        xVar.f1290a = android.ext.f.b().setView(android.ext.Tools.O0(this.f1298a.j)).setCancelable(false).setPositiveButton(catch_.me_.if_.you_.can_.R.string.hide, (android.content.DialogInterface.OnClickListener) null).setNegativeButton(catch_.me_.if_.you_.can_.R.string.cancel, (android.content.DialogInterface.OnClickListener) null).create();
        this.f1298a.c("", -1L, 1L, 0, 1, 0L, "");
        android.ext.f.l(this.f1298a.f1290a, this.f1298a);
        if (android.ext.MainService.instance.n != null) {
            android.os.Handler handlerD = android.ext.n2.d();
            handlerD.removeCallbacks(this.f1298a.n);
            handlerD.postDelayed(this.f1298a.n, 100L);
        }
    }
}
