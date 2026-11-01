package android.ext;

/* JADX INFO: loaded from: classes.dex */
class l0$a extends android.ext.InternalKeyboard$e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.l0 f1057a;

    l0$a(android.ext.l0 l0Var) {
        this.f1057a = l0Var;
    }

    @Override // android.ext.InternalKeyboard$e
    protected boolean a(android.view.View view, boolean z) {
        return this.f1057a.u() || view == this.f1057a.f1055f;
    }
}
