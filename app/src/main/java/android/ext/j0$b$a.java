package android.ext;

/* JADX INFO: loaded from: classes.dex */
class j0$b$a extends android.ext.InternalKeyboard$e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditTextPath f1035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.j0$b f1036b;

    j0$b$a(android.ext.j0$b j0_b, android.ext.EditTextPath editTextPath) {
        this.f1036b = j0_b;
        this.f1035a = editTextPath;
    }

    @Override // android.ext.InternalKeyboard$e
    protected boolean a(android.view.View view, boolean z) {
        return view == this.f1035a;
    }
}
