package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$g$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f65a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f66b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter$g f67c;

    ConfigListAdapter$g$a(android.ext.ConfigListAdapter$g configListAdapter$g, boolean[] zArr, int i) {
        this.f67c = configListAdapter$g;
        this.f65a = zArr;
        this.f66b = i;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == -1 || i == -3) {
            long j = -1;
            if (i == -1) {
                int i2 = 0;
                while (true) {
                    boolean[] zArr = this.f65a;
                    if (i2 >= zArr.length) {
                        break;
                    }
                    j = zArr[i2] ? j | ((long) (1 << i2)) : j & ((long) (~(1 << i2)));
                    i2++;
                }
            }
            if ((((long) ((1 << this.f65a.length) - 1)) & j) == 0) {
                j |= 1;
            }
            android.ext.Config.f29b[this.f66b] = j;
            android.ext.Config.k();
        }
        android.ext.ConfigListAdapter.c();
    }
}
