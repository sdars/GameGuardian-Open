package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$m0 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f274f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainService$m0(android.ext.MainService mainService) {
        super(catch_.me_.if_.you_.can_.R.string.invert_selection, catch_.me_.if_.you_.can_.R.drawable.ic_select_inverse_white_24dp);
        this.f274f = mainService;
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        this.f274f.j(2);
    }
}
