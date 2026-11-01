package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$m$b implements android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.fix.ScrollView f523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Tools$m f524b;

    Tools$m$b(android.ext.Tools$m tools$m, android.fix.ScrollView scrollView) {
        this.f524b = tools$m;
        this.f523a = scrollView;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        this.f523a.postDelayed(new android.ext.Tools$m$b$a(this), 100L);
    }
}
