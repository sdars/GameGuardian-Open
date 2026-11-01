package android.ext;

/* JADX INFO: loaded from: classes.dex */
class l0$d implements android.widget.CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.l0 f1060a;

    l0$d(android.ext.l0 l0Var) {
        this.f1060a = l0Var;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1060a.s.setChecked(false);
        }
    }
}
