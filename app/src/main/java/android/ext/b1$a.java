package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.content.Intent[] f600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ java.lang.String f602d;

    b1$a(int i, android.content.Intent[] intentArr, int i2, java.lang.String str) {
        this.f599a = i;
        this.f600b = intentArr;
        this.f601c = i2;
        this.f602d = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.b1$a$a b1_a_a = new android.ext.b1$a$a(this);
        android.ext.b1.B.E();
        android.app.AlertDialog alertDialogCreate = android.ext.f.c(android.ext.r.p).setMessage(android.ext.b1.L + ": [" + this.f601c + "] " + this.f602d).setPositiveButton(catch_.me_.if_.you_.can_.R.string.yes, b1_a_a).setNegativeButton(catch_.me_.if_.you_.can_.R.string.no, b1_a_a).setCancelable(false).create();
        android.ext.f.m(alertDialogCreate);
        android.ext.b1.B.r = alertDialogCreate;
    }
}
