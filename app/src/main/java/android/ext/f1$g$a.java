package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$g$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.SharedPreferences f966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.String f967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.f1$g f968c;

    f1$g$a(android.ext.f1$g f1_g, android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        this.f968c = f1_g;
        this.f966a = sharedPreferences;
        this.f967b = str;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == -1) {
            new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2wrslf2:8770li0|rx0zdqw0wr0dgg0d0qhz0wudqvodwlrq0ru0lpsuryh0dq0h{lvwlqj2").onClick(dialogInterface, i);
        }
        this.f966a.edit().putString("improve-translate", this.f967b).commit();
    }
}
