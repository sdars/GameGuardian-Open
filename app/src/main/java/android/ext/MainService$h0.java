package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$h0 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f247f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainService$h0(android.ext.MainService mainService, int i, int i2) {
        super(i, i2);
        this.f247f = mainService;
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.speedhack_open);
        this.f247f.t();
        this.f247f.onLongClick(null);
    }
}
