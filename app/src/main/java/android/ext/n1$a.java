package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n1$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.n1 f1122a;

    n1$a(android.ext.n1 n1Var) {
        this.f1122a = n1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1122a.notifyDataSetChanged();
    }
}
