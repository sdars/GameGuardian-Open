package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$h implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f971a;

    f1$h(long j) {
        this.f971a = j;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Config.f30c |= this.f971a;
        android.ext.Config.k();
    }
}
