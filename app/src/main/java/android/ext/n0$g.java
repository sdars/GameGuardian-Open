package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n0$g extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.n0 f1114b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    n0$g(android.ext.n0 n0Var, java.lang.String str, java.lang.String str2) {
        super(str);
        this.f1114b = n0Var;
        this.f1113a = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            android.os.Looper.prepare();
            android.ext.p2.j(android.widget.Toast.makeText(android.ext.p2.h(), this.f1113a, 1));
            android.os.Looper.loop();
        } catch (java.lang.Throwable unused) {
        }
    }
}
