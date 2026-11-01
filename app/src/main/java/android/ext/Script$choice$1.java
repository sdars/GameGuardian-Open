package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$choice$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ luaj.LuaValue f407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ java.lang.CharSequence[] f408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$choice f410e;

    Script$choice$1(android.ext.Script$choice script$choice, java.lang.String str, luaj.LuaValue luaValue, java.lang.CharSequence[] charSequenceArr, int i) {
        this.f410e = script$choice;
        this.f406a = str;
        this.f407b = luaValue;
        this.f408c = charSequenceArr;
        this.f409d = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.app.AlertDialog.Builder negativeButton = android.ext.f.b().setCustomTitle(android.ext.Tools.i0(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script), this.f406a)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), this.f410e);
        if (this.f407b.l1()) {
            negativeButton.setItems(this.f408c, this.f410e);
        } else {
            negativeButton.setSingleChoiceItems(this.f408c, this.f409d, this.f410e);
        }
        android.app.AlertDialog alertDialogCreate = negativeButton.create();
        android.ext.f.k(alertDialogCreate, this.f410e);
        android.ext.f.m(alertDialogCreate);
        android.ext.MainService.instance.y(true);
    }
}
