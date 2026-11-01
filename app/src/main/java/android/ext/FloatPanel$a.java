package android.ext;

/* JADX INFO: loaded from: classes.dex */
class FloatPanel$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.FloatPanel f144a;

    FloatPanel$a(android.ext.FloatPanel floatPanel) {
        this.f144a = floatPanel;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.e1.d(this.f144a.d("show"));
        android.ext.FloatPanel floatPanel = this.f144a;
        if (floatPanel.m) {
            return;
        }
        floatPanel.j();
    }
}
