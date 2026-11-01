package android.ext;

/* JADX INFO: loaded from: classes.dex */
class r$c implements android.content.DialogInterface.OnClickListener {
    r$c() {
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            android.ext.r.p.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("https://support.google.com/android/answer/6088895")));
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed call activity", th);
        }
    }
}
