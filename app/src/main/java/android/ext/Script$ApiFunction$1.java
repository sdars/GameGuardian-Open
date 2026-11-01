package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$ApiFunction$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ luaj.Varargs f367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$ApiFunction f368b;

    Script$ApiFunction$1(android.ext.Script$ApiFunction script$ApiFunction, luaj.Varargs varargs) {
        this.f368b = script$ApiFunction;
        this.f367a = varargs;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f368b.j3(this.f367a);
    }
}
