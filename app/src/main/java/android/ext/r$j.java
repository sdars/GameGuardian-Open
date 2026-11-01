package android.ext;

/* JADX INFO: loaded from: classes.dex */
class r$j implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.r f1223a;

    r$j(android.ext.r rVar) {
        this.f1223a = rVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        boolean z = i == -1;
        new android.ext.g2().putInt("odd-vspace", z ? 1 : 2).commit();
        if (z) {
            android.ext.ConfigListAdapter.m();
        }
    }
}
