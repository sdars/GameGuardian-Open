package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$getResults$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.util.ArrayList f416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.Object f417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$getResults f418c;

    Script$getResults$1(android.ext.Script$getResults script$getResults, java.util.ArrayList arrayList, java.lang.Object obj) {
        this.f418c = script$getResults;
        this.f416a = arrayList;
        this.f417b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        gg_d.a aVar = android.ext.MainService.instance.s0;
        for (int i = 0; i < aVar.i(); i++) {
            try {
                android.ext.c cVarF = aVar.f(i, null);
                if (cVarF != null) {
                    this.f416a.add(cVarF);
                }
            } catch (java.lang.IndexOutOfBoundsException unused) {
            }
        }
        synchronized (this.f417b) {
            try {
                this.f417b.notifyAll();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }
}
