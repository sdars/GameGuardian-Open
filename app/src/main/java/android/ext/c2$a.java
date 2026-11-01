package android.ext;

/* JADX INFO: loaded from: classes.dex */
class c2$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Throwable f698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.c2 f699b;

    c2$a(android.ext.c2 c2Var, java.lang.Throwable th) {
        this.f699b = c2Var;
        this.f698a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.error)).setMessage(this.f699b.f696b + "\n\n" + this.f698a.toString()).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed show alert", th);
        }
    }
}
