package android.ext;

/* JADX INFO: loaded from: classes.dex */
class HexConverter$a$a implements android.ext.Config$p$b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.Config$p f154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.HexConverter$a f155b;

    HexConverter$a$a(android.ext.HexConverter$a hexConverter$a, android.ext.Config$p config$p) {
        this.f155b = hexConverter$a;
        this.f154a = config$p;
    }

    @Override // android.ext.Config$p$b
    public void a(int i) {
        this.f154a.g(null);
        java.lang.String strL1 = android.ext.Tools.L1("%,d", java.lang.Long.valueOf(this.f155b.f148b ^ android.ext.Config.s));
        try {
            android.ext.HexConverter$a hexConverter$a = this.f155b;
            hexConverter$a.f149c.setSelection(hexConverter$a.f150d, hexConverter$a.f151e);
            android.ext.HexConverter$a hexConverter$a2 = this.f155b;
            hexConverter$a2.f152f.replace(hexConverter$a2.f150d, hexConverter$a2.f151e, strL1);
        } catch (java.lang.IndexOutOfBoundsException e2) {
            android.ext.e1.s("Failed replace text", e2);
            this.f155b.f149c.setText(strL1);
        }
        this.f155b.f149c.requestFocus();
    }
}
