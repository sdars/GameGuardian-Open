package android.ext;

/* JADX INFO: loaded from: classes.dex */
class e0$a$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.e0$a f734a;

    e0$a$a(android.ext.e0$a e0_a) {
        this.f734a = e0_a;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        for (android.content.Intent intent : android.ext.b1.b0(this.f734a.f732a)) {
            try {
                android.ext.Tools.f0().startActivity(intent);
                return;
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
    }
}
