package android.ext;

/* JADX INFO: loaded from: classes.dex */
class SavedListAdapter$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.h2 f363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.SavedListAdapter f364b;

    SavedListAdapter$a(android.ext.SavedListAdapter savedListAdapter, android.ext.h2 h2Var) {
        this.f364b = savedListAdapter;
        this.f363a = h2Var;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f364b.k(this.f363a);
    }
}
