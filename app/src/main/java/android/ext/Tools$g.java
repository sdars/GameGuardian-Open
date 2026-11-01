package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.EditText f508a;

    Tools$g(android.widget.EditText editText) {
        this.f508a = editText;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.text.Editable text = this.f508a.getText();
        if (text.length() > 0) {
            try {
                text.replace(0, 1, text.subSequence(0, 1), 0, 1);
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
            this.f508a.selectAll();
        }
    }
}
