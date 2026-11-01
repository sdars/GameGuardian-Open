package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f240a;

    MainService$f(android.ext.MainService mainService) {
        this.f240a = mainService;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService mainService = this.f240a;
        mainService.f217g = mainService.C("record-interrupt", 0, 0, catch_.me_.if_.you_.can_.R.string.record, catch_.me_.if_.you_.can_.R.drawable.ic_stop_white_24dp);
        this.f240a.h0.n();
    }
}
