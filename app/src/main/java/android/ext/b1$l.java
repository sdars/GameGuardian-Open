package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$l implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f626a;

    b1$l(java.lang.String str) {
        this.f626a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.widget.TextView textView = (android.widget.TextView) android.ext.b1.I.get();
        if (textView != null) {
            textView.setText(this.f626a);
        }
    }
}
