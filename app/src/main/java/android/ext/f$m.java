package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$m implements android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.List f784a;

    private f$m() {
        this.f784a = new java.util.ArrayList();
    }

    /* synthetic */ f$m(android.ext.f$a f_a) {
        this();
    }

    public void a(android.content.DialogInterface.OnShowListener dialogInterface$OnShowListener) {
        if (dialogInterface$OnShowListener == null || this.f784a.contains(dialogInterface$OnShowListener)) {
            return;
        }
        this.f784a.add(dialogInterface$OnShowListener);
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.N((android.app.AlertDialog) dialogInterface);
        for (android.content.DialogInterface.OnShowListener dialogInterface$OnShowListener : (java.util.Collection<android.content.DialogInterface.OnShowListener>) this.f784a) {
            if (dialogInterface$OnShowListener != null) {
                dialogInterface$OnShowListener.onShow(dialogInterface);
            }
        }
    }
}
