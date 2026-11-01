package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z2$a implements java.util.concurrent.Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1442a;

    z2$a(java.lang.String str) {
        this.f1442a = str;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Boolean call() {
        return java.lang.Boolean.valueOf(android.ext.z2.b(this.f1442a.getBytes()));
    }
}
