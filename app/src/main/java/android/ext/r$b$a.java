package android.ext;

/* JADX INFO: loaded from: classes.dex */
class r$b$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.r$b f1215a;

    r$b$a(android.ext.r$b r_b) {
        this.f1215a = r_b;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            android.ext.r.p.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(android.ext.Tools.removeNewLinesChars("kwws=22jdphjxdugldq1qhw2iruxp2wrslf24<7540yluwxdo0vsdfhv0wr0uxq0jdphjxdugldq0zlwkrxw0urrw2"))));
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed call activity", th);
        }
        new android.ext.p0(1400).onClick(null, 0);
    }
}
