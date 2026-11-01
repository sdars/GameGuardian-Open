package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$j0$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long[] f252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long[] f253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$j0 f255d;

    MainService$j0$a(android.ext.MainService$j0 mainService$j0, long[] jArr, long[] jArr2, int i) {
        this.f255d = mainService$j0;
        this.f252a = jArr;
        this.f253b = jArr2;
        this.f254c = i;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f255d.i(this.f252a, this.f253b, this.f254c, i);
    }
}
