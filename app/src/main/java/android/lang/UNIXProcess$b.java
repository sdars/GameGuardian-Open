package android.lang;

/* JADX INFO: loaded from: classes.dex */
class UNIXProcess$b implements java.security.PrivilegedExceptionAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f1480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.lang.UNIXProcess f1481b;

    UNIXProcess$b(android.lang.UNIXProcess uNIXProcess, int[] iArr) {
        this.f1481b = uNIXProcess;
        this.f1480a = iArr;
    }

    @Override // java.security.PrivilegedExceptionAction
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Void run() {
        this.f1481b.i(this.f1480a);
        return null;
    }
}
