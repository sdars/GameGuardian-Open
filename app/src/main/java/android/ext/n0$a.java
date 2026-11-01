package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n0$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.String[] f1105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f1106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f1107d;

    n0$a(java.lang.String str, java.lang.String[] strArr, int i, java.lang.Runnable runnable) {
        this.f1104a = str;
        this.f1105b = strArr;
        this.f1106c = i;
        this.f1107d = runnable;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == -1) {
            android.ext.z2.c(this.f1104a);
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.thank_you);
        }
        if (i == -3) {
            android.ext.Tools.i1(this.f1105b[this.f1106c + 1]);
        }
        this.f1107d.run();
    }
}
