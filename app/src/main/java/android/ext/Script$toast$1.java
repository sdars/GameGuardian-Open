package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$toast$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$toast f444c;

    Script$toast$1(android.ext.Script$toast script$toast, java.lang.String str, boolean z) {
        this.f444c = script$toast;
        this.f442a = str;
        this.f443b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.Tools.K1(android.ext.b2.g(this.f442a), !this.f443b ? 1 : 0);
    }
}
