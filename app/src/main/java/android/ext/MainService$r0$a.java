package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$r0$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Object f295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$r0 f297c;

    MainService$r0$a(android.ext.MainService$r0 mainService$r0, java.lang.Object obj, int i) {
        this.f297c = mainService$r0;
        this.f295a = obj;
        this.f296b = i;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.n1 n1Var = this.f297c.f294f.N;
        boolean[] zArr = (boolean[]) this.f295a;
        int length = zArr.length - 1;
        for (int i2 = 1; i2 < length; i2++) {
            if (zArr[i2]) {
                long jE = n1Var.e(i2);
                android.ext.h2 h2Var = new android.ext.h2(jE, 0L, i);
                if (!h2Var.V()) {
                    h2Var.f674c = android.ext.c.S(h2Var.f672a, true);
                }
                android.ext.h2 h2VarE = this.f297c.f294f.t0.e(jE);
                if (h2VarE == null || h2VarE.f674c != h2Var.f674c) {
                    this.f297c.f294f.t0.b(h2Var, (byte) 0, false);
                }
            }
        }
        this.f297c.f294f.t0.notifyDataSetChanged();
        this.f297c.f294f.t0.i();
        android.ext.Tools.J1(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.items_added), java.lang.Integer.valueOf(this.f296b)));
    }
}
