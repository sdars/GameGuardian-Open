package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$r implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.ListAdapter f86a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f87b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ java.util.List f88c;

    ConfigListAdapter$r(android.widget.ListAdapter listAdapter, int i, java.util.List list) {
        this.f86a = listAdapter;
        this.f87b = i;
        this.f88c = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.f.o(android.ext.f.c(android.ext.Tools.k0()).setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.select_language)).setSingleChoiceItems(this.f86a, this.f87b, new android.ext.ConfigListAdapter$r$a(this)));
    }
}
