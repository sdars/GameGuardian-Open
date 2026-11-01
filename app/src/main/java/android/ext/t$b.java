package android.ext;

/* JADX INFO: loaded from: classes.dex */
class t$b implements java.lang.Runnable {
    t$b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (android.ext.MainService.instance != null) {
                android.ext.MainService.instance.b0();
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("MainService onDestroy fail", th);
        }
    }
}
