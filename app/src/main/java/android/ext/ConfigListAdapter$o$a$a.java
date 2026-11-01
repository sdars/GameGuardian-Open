package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$o$a$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter$o$a f83a;

    ConfigListAdapter$o$a$a(android.ext.ConfigListAdapter$o$a configListAdapter$o$a) {
        this.f83a = configListAdapter$o$a;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.ConfigListAdapter$o$a configListAdapter$o$a = this.f83a;
        android.ext.ConfigListAdapter$o configListAdapter$o = configListAdapter$o$a.f82b;
        configListAdapter$o.c(configListAdapter$o$a.f81a, configListAdapter$o.f79b.isChecked());
    }
}
