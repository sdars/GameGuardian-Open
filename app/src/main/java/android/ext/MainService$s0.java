package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$s0 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f299f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainService$s0(android.ext.MainService mainService) {
        super(catch_.me_.if_.you_.can_.R.string.select_all, catch_.me_.if_.you_.can_.R.drawable.ic_select_all_white_24dp);
        this.f299f = mainService;
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        this.f299f.j(1);
    }
}
