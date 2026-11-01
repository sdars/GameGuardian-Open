package gg_a;

/* JADX INFO: loaded from: classes.dex */
class a$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Intent f3a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f4b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f5c;

    a$a(a aVar, android.content.Intent intent, int i) {
        this.f5c = aVar;
        this.f3a = intent;
        this.f4b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5c.startActivityForResult(this.f3a, this.f4b);
    }
}
