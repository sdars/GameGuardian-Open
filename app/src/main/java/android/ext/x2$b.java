package android.ext;

/* JADX INFO: loaded from: classes.dex */
class x2$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f1313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.content.DialogInterface.OnClickListener f1314b;

    x2$b(boolean[] zArr, android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener) {
        this.f1313a = zArr;
        this.f1314b = dialogInterface$OnClickListener;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f1313a[0] = true;
        this.f1314b.onClick(dialogInterface, i);
    }
}
