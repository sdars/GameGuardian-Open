package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$v implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.CharSequence f302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f303c;

    MainService$v(android.ext.MainService mainService, java.lang.String str, java.lang.CharSequence charSequence) {
        this.f303c = mainService;
        this.f301a = str;
        this.f302b = charSequence;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String str = this.f301a;
        if (str != null) {
            this.f303c.C.setText(str);
        }
        java.lang.CharSequence charSequence = this.f302b;
        if (charSequence != null) {
            this.f303c.y.setText(charSequence);
        }
        this.f303c.x.setVisibility(8);
    }
}
