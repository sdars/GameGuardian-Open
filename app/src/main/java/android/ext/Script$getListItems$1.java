package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$getListItems$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.util.ArrayList f413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.Object f414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$getListItems f415c;

    Script$getListItems$1(android.ext.Script$getListItems script$getListItems, java.util.ArrayList arrayList, java.lang.Object obj) {
        this.f415c = script$getListItems;
        this.f413a = arrayList;
        this.f414b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.SavedListAdapter savedListAdapter = android.ext.MainService.instance.t0;
        try {
            int count = savedListAdapter.getCount();
            for (int i = 0; i < count; i++) {
                android.ext.h2 item = savedListAdapter.getItem(i);
                if (item != null) {
                    this.f413a.add(item);
                }
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed get list items", th);
        }
        synchronized (this.f414b) {
            try {
                this.f414b.notifyAll();
            } catch (java.lang.Throwable th2_c_c_c) {
                throw th2_c_c_c;
            }
        }
    }
}
