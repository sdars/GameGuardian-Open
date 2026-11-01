package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1048a;

    protected k2(android.content.Context context) {
        this.f1048a = context;
    }

    protected android.content.SharedPreferences a(java.lang.String str, int i) {
        return this.f1048a.getSharedPreferences(str, i);
    }

    protected java.lang.Object b(java.lang.String str) {
        return this.f1048a.getSystemService(str);
    }

    protected void c() {
        android.ext.v vVar = android.ext.v.f1277a;
        android.ext.v.f1281e = true;
        if (vVar != null) {
            android.ext.e1.d("BootstrapService stopSelf");
            vVar.stopSelf();
        }
        android.ext.u uVar = android.ext.u.f1267b;
        if (uVar != null) {
            uVar.onDestroy();
        }
    }
}
