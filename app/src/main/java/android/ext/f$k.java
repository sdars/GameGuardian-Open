package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$k implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.List f781a;

    private f$k() {
        this.f781a = new java.util.ArrayList();
    }

    /* synthetic */ f$k(android.ext.f$a f_a) {
        this();
    }

    public void a(android.content.DialogInterface.OnDismissListener dialogInterface$OnDismissListener) {
        if (dialogInterface$OnDismissListener == null || this.f781a.contains(dialogInterface$OnDismissListener)) {
            return;
        }
        this.f781a.add(dialogInterface$OnDismissListener);
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.ext.f.g();
        for (android.content.DialogInterface.OnDismissListener dialogInterface$OnDismissListener : (java.util.Collection<android.content.DialogInterface.OnDismissListener>) this.f781a) {
            if (dialogInterface$OnDismissListener != null) {
                dialogInterface$OnDismissListener.onDismiss(dialogInterface);
            }
        }
    }
}
