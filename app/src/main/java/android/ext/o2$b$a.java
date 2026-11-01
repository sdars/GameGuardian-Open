package android.ext;

/* JADX INFO: loaded from: classes.dex */
class o2$b$a implements android.ext.Config$p$b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.Config$p f1166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.o2$b f1167b;

    o2$b$a(android.ext.o2$b o2_b, android.ext.Config$p config$p) {
        this.f1167b = o2_b;
        this.f1166a = config$p;
    }

    @Override // android.ext.Config$p$b
    public void a(int i) {
        this.f1166a.g(null);
        this.f1167b.f1163c.setText(this.f1166a.toString());
    }
}
