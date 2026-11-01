package android.ext;

/* JADX INFO: loaded from: classes.dex */
class HotPoint$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ java.lang.String f166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ android.ext.HotPoint f167g;

    HotPoint$c(android.ext.HotPoint hotPoint, byte b2, long j, long j2, int i, int i2, java.lang.String str) {
        this.f167g = hotPoint;
        this.f161a = b2;
        this.f162b = j;
        this.f163c = j2;
        this.f164d = i;
        this.f165e = i2;
        this.f166f = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f167g.u(this.f161a, this.f162b, this.f163c, this.f164d, this.f165e, this.f166f);
    }
}
