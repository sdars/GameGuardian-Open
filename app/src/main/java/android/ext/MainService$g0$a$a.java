package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$g0$a$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$g0$a f245a;

    MainService$g0$a$a(android.ext.MainService$g0$a mainService$g0$a) {
        this.f245a = mainService$g0$a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // java.lang.Runnable
    public void run() {
        java.lang.String F = "";
        try {
            java.lang.Process processQ = android.ext.e2.q(android.ext.Tools.removeNewLinesChars("h{hf#sp#lqvwdoo#0u#00del#{;9#") + this.f245a.f244a.f242a);
            if (processQ == null) {
                F = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.reinstall_failed) + "\nnull";
            } else {
                int iWaitFor = processQ.waitFor();
                if (iWaitFor == 0) {
                    F = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.reinstall_ended);
                } else {
                    F = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.reinstall_failed) + "\ncode: " + iWaitFor;
                }
            }
        } catch (java.lang.InterruptedException e2) {
            android.ext.e1.g("Reinstall failed", e2);
            F = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.reinstall_failed) + "\n" + e2.getMessage();
        }
        android.ext.Tools.K1(F, 1);
    }
}
