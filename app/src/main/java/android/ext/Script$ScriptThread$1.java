package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$ScriptThread$1 implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$ScriptThread f393a;

    Script$ScriptThread$1(android.ext.Script$ScriptThread script$ScriptThread) {
        this.f393a = script$ScriptThread;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        java.io.File file = (java.io.File) this.f393a.f392a.U;try {

        if (android.ext.Tools.a1(file)) {
            android.ext.MainService mainService = android.ext.MainService.instance;
            java.lang.String absolutePath = file.getAbsolutePath();
            android.ext.Script script = this.f393a.f392a;
            mainService.x(absolutePath, script.X, script.Y);
        };
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }
}
