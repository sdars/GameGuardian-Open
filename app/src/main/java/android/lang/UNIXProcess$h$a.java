package android.lang;

/* JADX INFO: loaded from: classes.dex */
class UNIXProcess$h$a implements java.security.PrivilegedAction {
    UNIXProcess$h$a() {
    }

    @Override // java.security.PrivilegedAction
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.ThreadGroup run() {
        java.lang.ThreadGroup threadGroup = java.lang.Thread.currentThread().getThreadGroup();
        while (true) {
            java.lang.ThreadGroup parent = threadGroup.getParent();
            if (parent == null || threadGroup == parent) {
                break;
            }
            threadGroup = parent;
        }
        return threadGroup;
    }
}
