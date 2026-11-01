package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$o$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter$o f85a;

    ConfigListAdapter$o$c(android.ext.ConfigListAdapter$o configListAdapter$o) {
        this.f85a = configListAdapter$o;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f85a.f80c.show();
    }
}
