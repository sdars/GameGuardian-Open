package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$a0$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f0$a0 f804a;

    f0$a0$a(android.ext.f0$a0 f0_a0) {
        this.f804a = f0_a0;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.app.AlertDialog alertDialogCreate = android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.failed_load_daemon)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.is_device_rooted) + "\n\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.must_be_root)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it), new android.ext.f0$a0$a$a(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null).create();
            android.ext.f.m(alertDialogCreate);
            android.ext.Tools.u1(alertDialogCreate);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }
}
