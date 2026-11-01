package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$k implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.ListAdapter f258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f259b;

    MainService$k(android.ext.MainService mainService, android.widget.ListAdapter listAdapter) {
        this.f259b = mainService;
        this.f258a = listAdapter;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.widget.ListAdapter listAdapter = this.f258a;
        if (listAdapter instanceof android.ext.ConfigListAdapter) {
            ((android.ext.ConfigListAdapter) listAdapter).x();
        }
        android.widget.ListAdapter listAdapter2 = this.f258a;
        if (listAdapter2 instanceof android.widget.BaseAdapter) {
            try {
                ((android.widget.BaseAdapter) listAdapter2).notifyDataSetChanged();
            } catch (java.lang.NoSuchMethodError e2) {
                android.ext.e1.a(e2);
            }
        }
    }
}
