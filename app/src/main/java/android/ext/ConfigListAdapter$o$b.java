package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$o$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter$o f84a;

    ConfigListAdapter$o$b(android.ext.ConfigListAdapter$o configListAdapter$o) {
        this.f84a = configListAdapter$o;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (android.ext.MainService.instance != null) {
            android.ext.MainService.instance.t();
        }
        this.f84a.f80c.hide();
    }
}
