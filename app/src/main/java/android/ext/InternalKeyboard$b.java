package android.ext;

/* JADX INFO: loaded from: classes.dex */
class InternalKeyboard$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.inputmethodservice.Keyboard f191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.InternalKeyboard f192b;

    InternalKeyboard$b(android.ext.InternalKeyboard internalKeyboard, android.inputmethodservice.Keyboard keyboard) {
        this.f192b = internalKeyboard;
        this.f191a = keyboard;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f192b.setKeyboard(this.f191a);
    }
}
