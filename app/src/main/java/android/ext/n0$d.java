package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n0$d implements android.content.DialogInterface.OnClickListener {
    n0$d() {
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        java.lang.String absolutePath;
        try {
            absolutePath = android.ext.Tools.f0().getFilesDir().getAbsolutePath();
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed get files dir", th);
            absolutePath = "error";
        }
        android.ext.ConfigListAdapter.a(absolutePath);
    }
}
