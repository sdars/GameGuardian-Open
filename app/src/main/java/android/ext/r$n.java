package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class r$n implements android.content.DialogInterface.OnClickListener, android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1234a;

    public r$n(java.lang.String str) {
        this.f1234a = str == null ? "kwws=22jdphjxdugldq1qhw2grzqordg" : str;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            android.ext.Tools.f0().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(android.ext.Tools.removeNewLinesChars(this.f1234a))));
            android.ext.f.d();
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed call activity", th);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        onClick(null, 0);
    }
}
