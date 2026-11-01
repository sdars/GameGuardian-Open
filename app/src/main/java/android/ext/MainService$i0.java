package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$i0 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f249f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainService$i0(android.ext.MainService mainService, int i, int i2) {
        super(i, i2);
        this.f249f = mainService;
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        new android.ext.c1(this.f249f.v0, null);
    }
}
