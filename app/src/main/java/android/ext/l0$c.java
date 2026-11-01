package android.ext;

/* JADX INFO: loaded from: classes.dex */
class l0$c implements android.widget.CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.l0 f1059a;

    l0$c(android.ext.l0 l0Var) {
        this.f1059a = l0Var;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1059a.u.setChecked(false);
        }
        this.f1059a.t.setChecked(true);
    }
}
