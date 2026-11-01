package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$g$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.DialogInterface.OnClickListener f969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.f1$g f970b;

    f1$g$b(android.ext.f1$g f1_g, android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener) {
        this.f970b = f1_g;
        this.f969a = dialogInterface$OnClickListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.improve_translation_)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.site), this.f969a).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), this.f969a));
    }
}
