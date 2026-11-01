package android.ext;

/* JADX INFO: loaded from: classes.dex */
class HotPoint$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.HotPoint f158a;

    HotPoint$a(android.ext.HotPoint hotPoint) {
        this.f158a = hotPoint;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f158a.q();
        android.ext.Tools.y1(this.f158a.s, 0.0f);
    }
}
