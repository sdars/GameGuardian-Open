package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$q$a implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.Config$q f46a;

    Config$q$a(android.ext.Config$q config$q) {
        this.f46a = config$q;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(this.f46a.f39a) + '\n' + android.ext.b2.f(this.f46a.h)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
    }
}
