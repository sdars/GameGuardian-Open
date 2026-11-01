package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$addListItems$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Object f399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$addListItems f400b;

    Script$addListItems$1(android.ext.Script$addListItems script$addListItems, java.lang.Object obj) {
        this.f400b = script$addListItems;
        this.f399a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.ArrayList<android.ext.h2> arrayList = this.f400b.e0;
        try {
            android.ext.SavedListAdapter savedListAdapter = android.ext.MainService.instance.t0;
            for (android.ext.h2 h2Var : arrayList) {
                if (h2Var != null) {
                    savedListAdapter.b(h2Var, (byte) 0, false);
                }
            }
            savedListAdapter.notifyDataSetChanged();
            savedListAdapter.i();
            this.f400b.f0 = luaj.LuaValue.f1674d;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed add list items", th);
            this.f400b.f0 = luaj.LuaValue.K2(android.ext.Script.V3(th));
        }
        synchronized (this.f399a) {
            try {
                this.f399a.notifyAll();
            } catch (java.lang.Throwable th2_c_c_c) {
                throw th2_c_c_c;
            }
        }
    }
}
