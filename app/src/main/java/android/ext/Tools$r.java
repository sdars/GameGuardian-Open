package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$r implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.ImageView f534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ float f535b;

    Tools$r(android.widget.ImageView imageView, float f2) {
        this.f534a = imageView;
        this.f535b = f2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f534a.setImageAlpha((int) this.f535b);
        } catch (java.lang.NoSuchMethodError e2) {
            try {
                android.ext.e1.s("setImageAlpha 1", e2);
                this.f534a.setAlpha((int) this.f535b);
            } catch (java.lang.NoSuchMethodError e3) {
                android.ext.e1.s("setImageAlpha 2", e3);
            }
        }
    }
}
