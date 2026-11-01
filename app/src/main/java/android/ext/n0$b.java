package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n0$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.SharedPreferences f1108a;

    n0$b(android.content.SharedPreferences sharedPreferences) {
        this.f1108a = sharedPreferences;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1108a.edit().remove("last_exception").commit();
    }
}
