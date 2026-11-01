package android.ext;

/* JADX INFO: loaded from: classes.dex */
class OffsetCalculator$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.OffsetCalculator f318a;

    OffsetCalculator$a(android.ext.OffsetCalculator offsetCalculator) {
        this.f318a = offsetCalculator;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.SavedListAdapter savedListAdapter = android.ext.MainService.instance.t0;
        android.ext.h2 h2Var = new android.ext.h2(this.f318a.f316f, 0L, i);
        if (!h2Var.V()) {
            h2Var.f674c = android.ext.c.S(h2Var.f672a, true);
        }
        android.ext.h2 h2VarE = savedListAdapter.e(this.f318a.f316f);
        if (h2VarE == null || h2VarE.f674c != h2Var.f674c) {
            savedListAdapter.a(h2Var);
            savedListAdapter.i();
        }
        android.ext.Tools.J1(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.items_added), 1));
    }
}
