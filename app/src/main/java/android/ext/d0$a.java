package android.ext;

/* JADX INFO: loaded from: classes.dex */
class d0$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.d0 f704b;

    d0$a(android.ext.d0 d0Var, boolean[] zArr) {
        this.f704b = d0Var;
        this.f703a = zArr;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        int i2 = 0;
        if (i == -1) {
            int i3 = 0;
            while (true) {
                boolean[] zArr = this.f703a;
                if (i2 >= zArr.length) {
                    break;
                }
                i3 = zArr[i2] ? i3 | (1 << i2) : i3 & (~(1 << i2));
                i2++;
            }
            i2 = i3;
        }
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_copy_params).f42d = i2;
        android.ext.Config.k();
        this.f704b.i(i2);
    }
}
