package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f497b;

    Tools$a(java.lang.String str, boolean z) {
        this.f496a = str;
        this.f497b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String strReplace = this.f496a.replace(" ", " ");
        if (this.f497b) {
            android.ext.y0.b(strReplace, 1);
        }
        try {
            ((android.content.ClipboardManager) android.ext.MainService.context.getSystemService("clipboard")).setPrimaryClip(android.content.ClipData.newPlainText(strReplace, strReplace));
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.copied);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed to copy text to the clipboard", th);
            android.ext.e1.d("Text: " + strReplace);
            android.ext.Tools.J1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.failed_copy_text) + ' ' + th.getMessage());
        }
    }
}
