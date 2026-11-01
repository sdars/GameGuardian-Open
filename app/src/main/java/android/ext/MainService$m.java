package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$m implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.widget.ListAdapter[] f268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.p1[][] f269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f270c;

    MainService$m(android.ext.MainService mainService, android.ext.p1[][] p1VarArr) {
        this.f270c = mainService;
        this.f269b = p1VarArr;
        this.f268a = new android.widget.ListAdapter[p1VarArr.length];
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        int iCharAt;
        int id = this.f270c.f0.getId();
        if (id == 2131034319) {
            iCharAt = 's' - "kwws=22jdphjxdugldq1qhw2khos2".charAt(20);
        } else if (id == 2131034389) {
            iCharAt = 'e' - "kwws=22jdphjxdugldq1qhw2iruxp2wrslf25<;940grqdwh2".charAt(13);
        } else if (id != 2131034395) {
            return;
        } else {
            iCharAt = 'j' - "kwws=22jdphjxdugldq1qhw2grzqordg".charAt(11);
        }
        android.widget.ListAdapter[] listAdapterArr = this.f268a;
        if (listAdapterArr[iCharAt] == null) {
            listAdapterArr[iCharAt] = new android.ext.MainService$m$a(this, android.ext.MainService.context, this.f269b[iCharAt]);
        }
        android.ext.f.o(android.ext.f.c(android.ext.Tools.k0()).setAdapter(this.f268a[iCharAt], new android.ext.MainService$m$b(this, iCharAt)));
    }
}
