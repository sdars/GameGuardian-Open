package android.ext;

/* JADX INFO: loaded from: classes.dex */
class HotFrame$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.HotFrame f157a;

    HotFrame$a(android.ext.HotFrame hotFrame) {
        this.f157a = hotFrame;
    }

    @Override // java.lang.Runnable
    public void run() {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        boolean zPerformHapticFeedback;
        try {
            this.f157a.setHapticFeedbackEnabled(true);
            zPerformHapticFeedback = this.f157a.performHapticFeedback(0, 1);
            try {
                this.f157a.setHapticFeedbackEnabled(false);
            } catch (java.lang.Throwable th_c) {
                th = th_c;
                android.ext.e1.g("Failed make HapticFeedback", th_c);
                this.f157a.setHapticFeedbackEnabled(false);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            zPerformHapticFeedback = false;
        }
        android.ext.e1.d("Real long click: " + zPerformHapticFeedback);
        android.ext.MainService.instance.onLongClick(null);
    }
}
