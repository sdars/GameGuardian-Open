package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$k implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.Tools$a0 f71a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f72b;

    ConfigListAdapter$k(android.ext.ConfigListAdapter configListAdapter, android.ext.Tools$a0 tools$a0) {
        this.f72b = configListAdapter;
        this.f71a = tools$a0;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.Tools.A1(android.ext.MainService.instance.Y, this.f71a);
    }
}
