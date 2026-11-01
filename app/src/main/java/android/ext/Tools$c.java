package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.TextView f503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.String f504b;

    Tools$c(android.widget.TextView textView, java.lang.String str) {
        this.f503a = textView;
        this.f504b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 1;
        while (i < 4) {
            try {
                this.f503a.setLinksClickable(i <= 2);
                this.f503a.setAutoLinkMask(i <= 2 ? 1 : 0);
                this.f503a.setMovementMethod(i <= 1 ? android.text.method.LinkMovementMethod.getInstance() : null);
                this.f503a.setText(this.f504b);
                break;
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("Failed set clickable text " + i, th);
                i++;
            }
        }
        if (i == 4) {
            this.f503a.setText("Failed set text");
        }
        android.ext.DefensiveURLSpan.a(this.f503a);
    }
}
