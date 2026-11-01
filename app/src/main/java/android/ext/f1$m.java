package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$m implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f976b;

    f1$m(android.content.Context context, java.lang.Runnable runnable) {
        this.f975a = context;
        this.f976b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.app.AlertDialog alertDialogCreate = android.ext.f.c(this.f975a).setMessage(android.ext.b2.g("     15. __help_faq_15_q__\r\n        __help_faq_15_a__\r\n\r\n     16. __help_faq_16_q__\r\n        __help_faq_16_a__\r\n\r\n     17. __help_faq_17_q__\r\n        __help_faq_17_a__\r\n\r\n__rtfm__")).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null).create();
            if (this.f976b != null) {
                android.ext.f.k(alertDialogCreate, new android.ext.f1$m$a(this));
            }
            android.ext.f.m(alertDialogCreate);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed faq alert", th);
        }
    }
}
