package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$c implements android.view.View.OnClickListener {
    b1$c() {
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        android.ext.f.p(android.ext.f.c(android.ext.r.p).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.install_cancel_prompt)).setPositiveButton(catch_.me_.if_.you_.can_.R.string.yes, new android.ext.b1$c$a(this)).setNegativeButton(catch_.me_.if_.you_.can_.R.string.no, (android.content.DialogInterface.OnClickListener) null).setCancelable(false), android.ext.r.n);
    }
}
