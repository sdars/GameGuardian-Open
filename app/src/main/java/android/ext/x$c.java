package android.ext;

/* JADX INFO: loaded from: classes.dex */
class x$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.CharSequence f1299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f1300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f1301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f1302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f1303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f1304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1305g;
    final /* synthetic */ android.ext.x h;

    x$c(android.ext.x xVar, java.lang.CharSequence charSequence, long j, long j2, int i, int i2, long j3, java.lang.String str) {
        this.h = xVar;
        this.f1299a = charSequence;
        this.f1300b = j;
        this.f1301c = j2;
        this.f1302d = i;
        this.f1303e = i2;
        this.f1304f = j3;
        this.f1305g = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.h.d(this.f1299a, this.f1300b, this.f1301c, this.f1302d, this.f1303e, this.f1304f, this.f1305g);
    }
}
