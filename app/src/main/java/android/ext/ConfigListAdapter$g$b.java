package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$g$b implements android.content.DialogInterface.OnMultiChoiceClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f68a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter$g f69b;

    ConfigListAdapter$g$b(android.ext.ConfigListAdapter$g configListAdapter$g, boolean[] zArr) {
        this.f69b = configListAdapter$g;
        this.f68a = zArr;
    }

    @Override // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i, boolean z) {
        this.f68a[i] = z;
    }
}
