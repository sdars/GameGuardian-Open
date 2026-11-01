package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n1$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f1123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean[] f1124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.n1 f1125c;

    n1$b(android.ext.n1 n1Var, boolean z, boolean[] zArr) {
        this.f1125c = n1Var;
        this.f1123a = z;
        this.f1124b = zArr;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        int i2 = 0;
        int i3 = this.f1123a ? 0 : -15999;
        if (i == -1) {
            while (true) {
                boolean[] zArr = this.f1124b;
                if (i2 >= zArr.length) {
                    break;
                }
                i3 = zArr[i2] ? i3 | (1 << i2) : i3 & (~(1 << i2));
                i2++;
            }
        }
        boolean z = this.f1123a;
        if (!z && (((1 << this.f1124b.length) - 1) & i3) == 0) {
            i3 |= 8;
        }
        if (z) {
            android.ext.SavedListAdapter.o(i3);
        } else {
            this.f1125c.R(i3);
        }
    }
}
