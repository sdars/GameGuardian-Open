package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f223b;

    MainService$c(android.ext.MainService mainService, boolean z) {
        this.f223b = mainService;
        this.f222a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z = this.f222a;
        if (z) {
            this.f223b.f215e = false;
        }
        android.ext.MainService mainService = this.f223b;
        mainService.f214d = z ? mainService.C("script-ui-button", 0, 50, catch_.me_.if_.you_.can_.R.drawable.ic_ui_button_24dp, catch_.me_.if_.you_.can_.R.drawable.ic_ui_button_24dp) : null;
        this.f223b.h0.o();
    }
}
