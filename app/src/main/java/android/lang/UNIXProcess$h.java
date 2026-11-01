package android.lang;

/* JADX INFO: loaded from: classes.dex */
class UNIXProcess$h implements java.util.concurrent.ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.ThreadGroup f1485a = a();

    private UNIXProcess$h() {
    }

    /* synthetic */ UNIXProcess$h(android.lang.UNIXProcess$a uNIXProcess$a) {
        this();
    }

    private static java.lang.ThreadGroup a() {
        return (java.lang.ThreadGroup) android.lang.UNIXProcess.e(new android.lang.UNIXProcess$h$a());
    }

    @Override // java.util.concurrent.ThreadFactory
    public java.lang.Thread newThread(java.lang.Runnable runnable) {
        java.lang.Thread thread = new java.lang.Thread(f1485a, runnable, "process reaper", 32768L);
        thread.setDaemon(true);
        thread.setPriority(10);
        return thread;
    }
}
