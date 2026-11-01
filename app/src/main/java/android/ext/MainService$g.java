package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$g extends android.ext.FloatPanel {
    final /* synthetic */ java.lang.String p;
    final /* synthetic */ int q;
    final /* synthetic */ int r;
    final /* synthetic */ android.ext.MainService s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainService$g(android.ext.MainService mainService, android.content.Context context, java.lang.String str, int i, int i2) {
        super(context);
        this.s = mainService;
        this.p = str;
        this.q = i;
        this.r = i2;
    }

    @Override // android.ext.FloatPanel
    protected boolean f() {
        return true;
    }

    @Override // android.ext.FloatPanel
    protected int getDefX() {
        return this.q;
    }

    @Override // android.ext.FloatPanel
    protected int getDefY() {
        return this.r;
    }

    @Override // android.ext.FloatPanel
    protected java.lang.String getPrefName() {
        return this.p;
    }
}
