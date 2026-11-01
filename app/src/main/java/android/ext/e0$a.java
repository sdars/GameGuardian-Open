package android.ext;

/* JADX INFO: loaded from: classes.dex */
class e0$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.io.File f732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.e0 f733b;

    e0$a(android.ext.e0 e0Var, java.io.File file) {
        this.f733b = e0Var;
        this.f732a = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.f.o(android.ext.f.b().setMessage(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.need_fixer), this.f732a.getAbsolutePath())).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it), new android.ext.e0$a$a(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
    }
}
