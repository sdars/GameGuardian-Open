package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$n0 extends android.ext.MainService$o0 {
    final /* synthetic */ android.ext.MainService i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainService$n0(android.ext.MainService mainService) {
        super(mainService, catch_.me_.if_.you_.can_.R.string.changed_as_search_result, catch_.me_.if_.you_.can_.R.drawable.ic_search_changed_white_24dp);
        this.i = mainService;
    }

    @Override // android.ext.MainService$l0
    void i() {
        android.ext.d dVar = this.i.u0;
        if (dVar.e() == 0) {
            android.ext.Tools.J1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.changed_not_found));
        } else {
            h(dVar.b(), null);
        }
    }
}
