package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$o$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f81a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter$o f82b;

    ConfigListAdapter$o$a(android.ext.ConfigListAdapter$o configListAdapter$o, java.lang.String str) {
        this.f82b = configListAdapter$o;
        this.f81a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f82b.b();
        try {
            android.ext.e2$d e2_dJ = android.ext.e2.j(this.f81a);
            if (e2_dJ.f756a.contains("uid=0")) {
                android.ext.n2.i(new android.ext.ConfigListAdapter$o$a$a(this));
            } else {
                this.f82b.a(e2_dJ.f756a);
            }
        } catch (java.lang.Throwable th) {
            this.f82b.a(th.getMessage());
        }
        android.ext.e2.f745a = "";
    }
}
