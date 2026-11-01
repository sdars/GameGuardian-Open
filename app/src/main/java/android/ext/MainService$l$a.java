package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$l$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$l f264b;

    MainService$l$a(android.ext.MainService$l mainService$l, java.lang.String str) {
        this.f264b = mainService$l;
        this.f263a = str;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == -3) {
            android.ext.Tools.z(this.f263a);
        } else {
            if (i != -1) {
                return;
            }
            android.ext.MainService.instance.L(null, this.f263a, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.allocated));
        }
    }
}
