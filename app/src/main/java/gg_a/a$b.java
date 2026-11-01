package gg_a;

/* JADX INFO: loaded from: classes.dex */
class a$b implements android.content.DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f6a;

    a$b(a aVar) {
        this.f6a = aVar;
    }

    @Override // android.content.DialogInterface$OnCancelListener
    public void onCancel(android.content.DialogInterface dialogInterface) {
        this.f6a.a();
    }
}
