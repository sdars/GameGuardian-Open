package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n0$f implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String[] f1111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f1112b;

    n0$f(java.lang.String[] strArr, int i) {
        this.f1111a = strArr;
        this.f1112b = i;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Tools.i1(this.f1111a[(this.f1112b * 2) + 1]);
    }
}
