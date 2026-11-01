package android.ext;

/* JADX INFO: loaded from: classes.dex */
class FloatPanel$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.FloatPanel f145a;

    FloatPanel$b(android.ext.FloatPanel floatPanel) {
        this.f145a = floatPanel;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.e1.d(this.f145a.d("hide"));
        android.ext.FloatPanel floatPanel = this.f145a;
        if (floatPanel.l) {
            floatPanel.l = false;
            floatPanel.i();
        }
    }
}
