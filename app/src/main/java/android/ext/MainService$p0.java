package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$p0 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f280g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainService$p0(android.ext.MainService mainService, boolean z) {
        super(catch_.me_.if_.you_.can_.R.string.remove, catch_.me_.if_.you_.can_.R.drawable.ic_delete_white_24dp);
        this.f280g = mainService;
        this.f279f = z;
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        java.lang.Object objZ = this.f280g.z();
        int iL0 = android.ext.Tools.L0(objZ);
        java.lang.String str = " (" + iL0 + ')';
        android.ext.f.o(android.ext.f.b().setItems(new java.lang.String[]{android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.remove_all2), "---", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.revert_and_remove) + str, android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.remove) + str}, new android.ext.MainService$p0$a(this, iL0, objZ)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null));
    }
}
