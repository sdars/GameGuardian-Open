package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$k0 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f260f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainService$k0(android.ext.MainService mainService) {
        super(catch_.me_.if_.you_.can_.R.string.clear_selection, catch_.me_.if_.you_.can_.R.drawable.ic_select_off_white_24dp);
        this.f260f = mainService;
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        this.f260f.j(0);
    }
}
