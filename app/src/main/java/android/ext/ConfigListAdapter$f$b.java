package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$f$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter$f f63a;

    ConfigListAdapter$f$b(android.ext.ConfigListAdapter$f configListAdapter$f) {
        this.f63a = configListAdapter$f;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService.instance.i.T0();
    }
}
