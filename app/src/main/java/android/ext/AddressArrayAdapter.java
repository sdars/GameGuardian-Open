package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class AddressArrayAdapter extends android.ext.BaseAdapterIndexer implements android.ext.d3$a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile int f23d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gg_d.a f24a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.ext.d$a f25b = new android.ext.d$a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.ext.c f26c = new android.ext.c();

    public AddressArrayAdapter(gg_d.a aVar) {
        this.f24a = aVar;
        f23d = android.ext.Tools.M0().getInt("search-results-format", 0);
    }

    private android.view.View a(android.view.ViewGroup viewGroup) {
        android.view.View viewG = gg_a.d.g(catch_.me_.if_.you_.can_.R.layout.service_address_item, viewGroup, false);
        new android.ext.d3(viewG, this);
        return viewG;
    }

    static void b(int i) {
        f23d = i;
        new android.ext.g2().g("search-results-format", i, 0).commit();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24a.i();
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i) {
        try {
            return this.f24a.f(i, null);
        } catch (java.lang.IndexOutOfBoundsException e2) {
            android.ext.e1.s("Failed get item in memory list", e2);
            return null;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        long j;
        long j2;
        int i2;
        boolean z;
        int iD;
        if (view == null || view.getTag() == null) {
            view = a(viewGroup);
        }
        boolean zC = false;
        boolean z2 = (android.ext.Config.q & (1 << android.ext.Tools.d1())) == 0;
        android.ext.d3 d3Var = (android.ext.d3) view.getTag();
        if (d3Var.b()) {
            view = a(viewGroup);
            d3Var = (android.ext.d3) view.getTag();
        }
        android.ext.d3 d3Var2 = d3Var;
        d3Var2.m = i;
        d3Var2.q.setTag(java.lang.Integer.valueOf(i));
        d3Var2.p.setTag(java.lang.Integer.valueOf(i));
        gg_d.a aVar = this.f24a;
        android.ext.c cVar = null;
        if (aVar.i() > i) {
            try {
                android.ext.c cVarF = aVar.f(i, this.f26c);
                zC = aVar.c(i);
                cVar = cVarF;
            } catch (java.lang.IndexOutOfBoundsException unused) {
            }
        }
        d3Var2.o.setOrientation(z2 ? 0 : 1);
        android.ext.SavedListAdapter.p(d3Var2.q, z2);
        d3Var2.f661a.setChecked(zC);
        d3Var2.f661a.getLayoutParams().height = z2 ? -2 : android.ext.Tools.H();
        d3Var2.a(zC, -2);
        if (cVar != null) {
            int iM = cVar.m();
            d3Var2.n.setTextColor(iM);
            d3Var2.p.setTextColor(iM);
            java.lang.String strH = cVar.H();
            android.ext.d$a d_a = this.f25b;
            android.ext.MainService.instance.u0.a(cVar.f672a, cVar.f674c, d_a);
            if (d_a.f702b) {
                strH = strH + " (" + android.ext.c.I(cVar.f672a, d_a.f701a, cVar.f674c) + ')';
            }
            d3Var2.f662b.setText(cVar.F());
            d3Var2.n.setText(strH);
            d3Var2.p.setText(cVar.z());
            d3Var2.j.setText(android.ext.RegionList.a(cVar.f672a));
            long j3 = cVar.f672a;
            j2 = cVar.f673b;
            i2 = f23d;
            z = true;
            iD = cVar.D();
            j = j3;
        } else {
            d3Var2.f662b.setText("null");
            d3Var2.n.setText("null");
            d3Var2.p.setText("null");
            d3Var2.j.setText("null");
            j = 0;
            j2 = 0;
            i2 = 0;
            z = false;
            iD = 0;
        }
        android.ext.n1.c(d3Var2, j, j2, i2, z, iD);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        android.ext.b3 b3Var = (android.ext.b3) compoundButton.getTag();
        if (b3Var == null) {
            return;
        }
        try {
            this.f24a.b(b3Var.m, z);
            android.ext.MainService.instance.p1();
        } catch (java.lang.IndexOutOfBoundsException e2) {
            android.ext.e1.l("ArrayAdapter onCheckedChanged failed", e2);
        }
        b3Var.a(z, -2);
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        java.lang.Integer num = (java.lang.Integer) view.getTag();
        if (num == null) {
            return;
        }
        try {
            android.ext.c cVarF = this.f24a.f(num.intValue(), this.f26c);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(cVarF);
            android.ext.MainService.instance.i.j0(arrayList);
        } catch (java.lang.IndexOutOfBoundsException e2) {
            android.ext.e1.l("ArrayAdapter onClick Failed", e2);
        }
        android.ext.MainService.instance.D0(false);
    }
}
