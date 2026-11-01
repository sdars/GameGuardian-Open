package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$p$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.b1$p f631a;

    b1$p$a(android.ext.b1$p b1_p) {
        this.f631a = b1_p;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i != -1) {
            android.ext.b1.k(true);
        } else {
            new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2wrslf2:6<;0jdwkhulqj0lqirupdwlrq0derxw0jj0huuruv2").onClick(dialogInterface, i);
            android.ext.n2.d().postDelayed(new android.ext.b1$p$a$a(this), 5000L);
        }
    }
}
