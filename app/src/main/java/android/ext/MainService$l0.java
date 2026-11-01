package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$l0 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f266g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainService$l0(android.ext.MainService mainService) {
        super(catch_.me_.if_.you_.can_.R.string.export_selected, catch_.me_.if_.you_.can_.R.drawable.ic_download_checked_white_24dp);
        this.f266g = mainService;
        this.f265f = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainService$l0(android.ext.MainService mainService, int i, int i2) {
        super(i, i2);
        this.f266g = mainService;
        this.f265f = 0;
    }

    void h(java.util.List list, java.lang.Object obj) {
        int size = list.size();
        android.ext.h2[] h2VarArr = new android.ext.h2[size];
        for (int i = 0; i < size; i++) {
            android.ext.c cVar = (android.ext.c) list.get(i);
            h2VarArr[i] = cVar instanceof android.ext.h2 ? (android.ext.h2) cVar : new android.ext.h2(cVar);
        }
        new android.ext.c1(this.f266g.v0, h2VarArr).f694g = true;
    }

    void i() {
        java.lang.Object objZ = this.f266g.z();
        if (android.ext.Tools.L0(objZ) == 0) {
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.nothing_selected);
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        if (objZ instanceof boolean[]) {
            if (this.f265f == 0) {
                android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
                new android.ext.u2(android.ext.c.o(this.f266g.N.q((boolean[]) objZ, sparseIntArray)), sparseIntArray, "0", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_change_request), new android.ext.MainService$l0$a(this));
                return;
            }
            android.ext.n1 n1Var = this.f266g.N;
            boolean[] zArr = (boolean[]) objZ;
            int length = zArr.length - 1;
            for (int i2 = 1; i2 < length; i2++) {
                if (zArr[i2]) {
                    java.lang.Object item = n1Var.getItem(i2);
                    if (item instanceof android.ext.c) {
                        android.ext.c cVar = (android.ext.c) item;
                        cVar.f674c = this.f265f;
                        if (cVar.V()) {
                            arrayList.add(cVar);
                        }
                    }
                }
            }
            this.f265f = 0;
        } else if (objZ instanceof gg_d.a) {
            gg_d.a aVar = (gg_d.a) objZ;
            int i3 = aVar.i();
            while (i < i3) {
                if (aVar.c(i)) {
                    arrayList.add(aVar.f(i, null));
                }
                i++;
            }
        } else if (objZ instanceof gg_d.e) {
            gg_d.e eVar = (gg_d.e) objZ;
            int iL = eVar.l();
            while (i < iL) {
                if (eVar.a(i)) {
                    android.ext.h2 h2Var = (android.ext.h2) eVar.n(i);
                    if (h2Var instanceof android.ext.h2) {
                        arrayList.add(h2Var);
                    }
                }
                i++;
            }
        }
        h(arrayList, objZ);
    }

    void j() {
        this.f265f = 0;
        i();
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        j();
    }
}
