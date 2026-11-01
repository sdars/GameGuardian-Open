package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$n implements android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.view.View.OnClickListener f77a;

    ConfigListAdapter$n(android.view.View.OnClickListener view$OnClickListener) {
        this.f77a = view$OnClickListener;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(dialogInterface, -1, null, this.f77a);
    }
}
