package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$i implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.String f973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f974c;

    f1$i(android.content.Context context, java.lang.String str, long j) {
        this.f972a = context;
        this.f973b = str;
        this.f974c = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.content.Context contextF0 = this.f972a;
            if (contextF0 == null) {
                contextF0 = android.ext.Tools.f0();
            }
            android.app.AlertDialog alertDialogCreate = android.ext.f.c(contextF0).setMessage(this.f973b).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), android.ext.f1.w(this.f974c)).create();
            android.ext.f.m(alertDialogCreate);
            android.ext.Tools.u1(alertDialogCreate);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }
}
