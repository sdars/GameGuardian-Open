package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f220a;

    MainService$b(android.ext.MainService mainService) {
        this.f220a = mainService;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService mainService = this.f220a;
        mainService.f213c = mainService.C("script-interrupt", 0, 0, catch_.me_.if_.you_.can_.R.string.interrupt, catch_.me_.if_.you_.can_.R.drawable.ic_stop_white_24dp);
        android.ext.MainService mainService2 = this.f220a;
        mainService2.f214d = null;
        mainService2.h0.o();
    }
}
