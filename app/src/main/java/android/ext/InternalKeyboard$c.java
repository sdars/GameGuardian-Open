package android.ext;

/* JADX INFO: loaded from: classes.dex */
class InternalKeyboard$c implements android.view.View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f193a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f194b;

    InternalKeyboard$c(int i) {
        this.f194b = i;
    }

    @Override // android.view.View$OnFocusChangeListener
    public void onFocusChange(android.view.View view, boolean z) {
        android.ext.InternalKeyboard internalKeyboard;
        if ((android.ext.Config.B & 1) == 0 || (internalKeyboard = (android.ext.InternalKeyboard) view.getRootView().findViewById(catch_.me_.if_.you_.can_.R.id.keyboard)) == null) {
            return;
        }
        if (this.f193a == -1) {
            this.f193a = internalKeyboard.getFlags();
        }
        internalKeyboard.setFlags((z ? this.f194b : 0) | this.f193a);
        internalKeyboard.t();
    }
}
