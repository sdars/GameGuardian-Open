package android.lang;

/* JADX INFO: loaded from: classes.dex */
class UNIXProcess$a implements java.security.PrivilegedAction {
    UNIXProcess$a() {
    }

    @Override // java.security.PrivilegedAction
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.util.concurrent.Executor run() {
        return java.util.concurrent.Executors.newCachedThreadPool(new android.lang.UNIXProcess$h(null));
    }
}
