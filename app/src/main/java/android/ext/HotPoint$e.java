package android.ext;

/* JADX INFO: loaded from: classes.dex */
class HotPoint$e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.graphics.drawable.Drawable f170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.HotPoint f171b;

    HotPoint$e(android.ext.HotPoint hotPoint, android.graphics.drawable.Drawable drawable) {
        this.f171b = hotPoint;
        this.f170a = drawable;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.HotPoint hotPoint = this.f171b;
        android.ext.Tools.c(hotPoint.y, this.f170a, 24 - hotPoint.q);
    }
}
