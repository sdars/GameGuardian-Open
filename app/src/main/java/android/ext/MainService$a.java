package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$a extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f218f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainService$a(android.ext.MainService mainService, int i, int i2) {
        super(i, i2);
        this.f218f = mainService;
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        int count = this.f218f.t0.getCount();
        android.ext.h2[] h2VarArr = new android.ext.h2[count];
        for (int i = 0; i < count; i++) {
            h2VarArr[i] = this.f218f.t0.getItem(i);
        }
        new android.ext.c1(this.f218f.v0, h2VarArr);
    }
}
