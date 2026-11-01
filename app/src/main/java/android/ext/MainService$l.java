package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$l implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f262b;

    MainService$l(android.ext.MainService mainService, long j) {
        this.f262b = mainService;
        this.f261a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.app.AlertDialog.Builder neutralButton;
        long j = this.f261a;
        if (-1024 >= j || j > 0) {
            java.lang.String str = android.ext.c.G(this.f261a, 4) + 'h';
            android.ext.MainService$l$a mainService$l$a = new android.ext.MainService$l$a(this, str);
            android.ext.y0.b(str, 1);
            neutralButton = android.ext.f.b().setMessage(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.allocated) + ": " + str).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.goto1), mainService$l$a).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.copy), mainService$l$a);
        } else {
            neutralButton = android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.allocate_fail) + ' ' + (-this.f261a));
        }
        android.ext.f.m(neutralButton.setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null).create());
    }
}
