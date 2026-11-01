package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$s implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.TextView f536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.graphics.drawable.Drawable f537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f538c;

    Tools$s(android.widget.TextView textView, android.graphics.drawable.Drawable drawable, int i) {
        this.f536a = textView;
        this.f537b = drawable;
        this.f538c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.Tools.d(this.f536a, this.f537b, this.f538c);
    }
}
