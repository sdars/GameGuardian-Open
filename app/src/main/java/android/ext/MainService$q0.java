package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$q0 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f289g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainService$q0(android.ext.MainService mainService) {
        super(catch_.me_.if_.you_.can_.R.string.revert_selected, catch_.me_.if_.you_.can_.R.drawable.ic_undo_variant_white_24dp);
        this.f289g = mainService;
        this.f288f = 0;
    }

    void h() {
        java.lang.Object objZ = this.f289g.z();
        android.ext.d dVar = new android.ext.d();
        android.ext.d dVar2 = this.f289g.u0;
        android.ext.d$a d_a = new android.ext.d$a();
        if (!(objZ instanceof boolean[])) {
            this.f289g.L0(objZ, dVar);
        } else if (this.f288f == 0) {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
            gg_a.e eVarO = android.ext.c.o(this.f289g.N.q((boolean[]) objZ, sparseIntArray));
            if (sparseIntArray.size() > 0) {
                new android.ext.u2(eVarO, sparseIntArray, "0", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_change_request), new android.ext.MainService$q0$a(this));
                return;
            }
        } else {
            android.ext.n1 n1Var = this.f289g.N;
            boolean[] zArr = (boolean[]) objZ;
            int length = zArr.length - 1;
            for (int i = 1; i < length; i++) {
                if (zArr[i]) {
                    android.ext.c cVar = new android.ext.c(n1Var.e(i), 0L, this.f288f);
                    if (cVar.V()) {
                        dVar2.a(cVar.f672a, cVar.f674c, d_a);
                        if (d_a.f702b) {
                            dVar.c(cVar.f672a, cVar.f674c, d_a.f701a);
                        }
                    }
                }
            }
            this.f288f = 0;
        }
        int iE = dVar.e();
        if (iE == 0) {
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.nothing_to_revert);
        } else {
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.revert_selected)).setMessage(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.revert_prompt), java.lang.Integer.valueOf(iE))).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), new android.ext.MainService$q0$b(this, dVar)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null));
        }
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        this.f288f = 0;
        h();
    }
}
