package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$r0 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f294f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainService$r0(android.ext.MainService mainService) {
        super(catch_.me_.if_.you_.can_.R.string.save_selected, catch_.me_.if_.you_.can_.R.drawable.ic_content_save_white_24dp);
        this.f294f = mainService;
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        java.lang.Object objZ = this.f294f.z();
        int iL0 = android.ext.Tools.L0(objZ);
        if (iL0 == 0) {
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.nothing_selected);
            return;
        }
        if (objZ instanceof boolean[]) {
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
            new android.ext.u2(android.ext.c.o(this.f294f.N.q((boolean[]) objZ, sparseIntArray)), sparseIntArray, "0", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_change_request), new android.ext.MainService$r0$a(this, objZ, iL0));
            return;
        }
        if (objZ instanceof gg_d.a) {
            java.util.ArrayList<android.ext.c> arrayList = new java.util.ArrayList();
            gg_d.a aVar = (gg_d.a) objZ;
            int i = aVar.i();
            for (int i2 = 0; i2 < i; i2++) {
                if (aVar.c(i2)) {
                    arrayList.add(aVar.f(i2, null));
                }
            }
            for (android.ext.c cVar : arrayList) {
                android.ext.h2 h2VarE = this.f294f.t0.e(cVar.f672a);
                if (h2VarE == null || h2VarE.f674c != cVar.f674c) {
                    this.f294f.t0.b(new android.ext.h2(cVar), (byte) 0, false);
                }
            }
            this.f294f.t0.notifyDataSetChanged();
            this.f294f.t0.i();
            android.ext.Tools.J1(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.items_added), java.lang.Integer.valueOf(iL0)));
            android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
            if (c2Var != null) {
                c2Var.write("\nlocal t = ");
                android.ext.b0.n(c2Var, true);
                c2Var.write("gg.addListItems(t)\n");
                c2Var.write("t = nil\n\n");
            }
        }
    }
}
