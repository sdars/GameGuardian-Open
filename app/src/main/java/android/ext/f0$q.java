package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$q implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f926a;

    f0$q(android.ext.f0 f0Var) {
        this.f926a = f0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.bad_settings)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.freeze_lags)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it), new android.ext.f0$q$a(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), (android.content.DialogInterface.OnClickListener) null));
    }
}
