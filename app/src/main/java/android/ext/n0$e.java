package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n0$e implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String[] f1110a;

    n0$e(java.lang.String[] strArr) {
        this.f1110a = strArr;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            android.ext.e2.n("exec setprop persist.sys.whetstone.level 0", 15);
            android.ext.Tools.J1(android.ext.b2.g(this.f1110a[8] + ": " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok)));
        } catch (java.lang.Throwable unused) {
            android.ext.e1.p("Failed fix " + this.f1110a[8]);
            android.ext.Tools.J1(android.ext.b2.g(this.f1110a[8] + ": " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.patch_failed)));
        }
    }
}
