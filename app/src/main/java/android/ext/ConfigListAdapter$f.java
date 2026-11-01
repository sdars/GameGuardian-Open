package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$f implements android.content.DialogInterface.OnClickListener {
    ConfigListAdapter$f() {
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.MainService mainService = android.ext.MainService.instance;
        try {
            mainService.t();
            android.ext.n2.d().postDelayed(new android.ext.ConfigListAdapter$f$a(this), 8000L);
            mainService.m1(true);
            mainService.j.e();
            android.ext.n2.d().postDelayed(new android.ext.ConfigListAdapter$f$b(this), 300L);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed take screenshot", th);
            try {
                mainService.j.m();
            } catch (java.lang.Throwable th2) {
                android.ext.e1.l("Failed restore after take screenshot", th2);
            }
        }
    }
}
