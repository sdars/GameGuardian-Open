package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Searcher$a implements android.text.TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.Searcher f452a;

    Searcher$a(android.ext.Searcher searcher) {
        this.f452a = searcher;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        this.f452a.L();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        this.f452a.L();
    }
}
