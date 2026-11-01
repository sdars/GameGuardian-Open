package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z$f implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.z f1396a;

    z$f(android.ext.z zVar) {
        this.f1396a = zVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.content.Intent intent = new android.content.Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("package:");
        sb.append(android.ext.Config.vSpaceReal ? android.ext.Config.E : android.ext.Tools.C0());
        intent.setData(android.net.Uri.parse(sb.toString()));
        this.f1396a.f1382a.startActivity(intent);
    }
}
