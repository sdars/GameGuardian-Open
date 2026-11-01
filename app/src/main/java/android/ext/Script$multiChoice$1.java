package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$multiChoice$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.CharSequence[] f421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$multiChoice f422c;

    Script$multiChoice$1(android.ext.Script$multiChoice script$multiChoice, java.lang.String str, java.lang.CharSequence[] charSequenceArr) {
        this.f422c = script$multiChoice;
        this.f420a = str;
        this.f421b = charSequenceArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.app.AlertDialog alertDialogCreate = android.ext.f.c(android.ext.Tools.k0()).setCustomTitle(android.ext.Tools.i0(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script), this.f420a)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), this.f422c).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), this.f422c).setMultiChoiceItems(this.f421b, this.f422c.e0, this.f422c).create();
        android.ext.f.k(alertDialogCreate, this.f422c);
        android.ext.f.m(alertDialogCreate);
        android.ext.MainService.instance.y(true);
    }
}
