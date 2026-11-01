package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f501b;

    Tools$b(java.lang.String str, int i) {
        this.f500a = str;
        this.f501b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.content.Context contextH = android.ext.p2.h();
            java.lang.String str = this.f500a;
            if (str == null) {
                str = "null";
            }
            android.ext.p2.j(android.widget.Toast.makeText(contextH, android.ext.b2.g(str), this.f501b));
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Toast fail", th);
        }
    }
}
