package android.ext;

/* JADX INFO: loaded from: classes.dex */
class t0$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.SeekBar f1249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.t0 f1250b;

    t0$b(android.ext.t0 t0Var, android.widget.SeekBar seekBar) {
        this.f1250b = t0Var;
        this.f1249a = seekBar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            android.ext.t0.l("0", android.ext.MainService.D() & 127, 536870912, this.f1249a.getProgress() + 1, this.f1250b.j.e(0), this.f1250b.j.e(1), this.f1250b.j.b());
        } catch (java.lang.NumberFormatException e2) {
            android.ext.j2.i(e2, this.f1250b.j.g());
        }
    }
}
