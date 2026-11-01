package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$ScriptThread$2 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ java.lang.String f396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.content.DialogInterface.OnClickListener f397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$ScriptThread f398e;

    Script$ScriptThread$2(android.ext.Script$ScriptThread script$ScriptThread, java.lang.String str, int i, java.lang.String str2, android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener) {
        this.f398e = script$ScriptThread;
        this.f394a = str;
        this.f395b = i;
        this.f396c = str2;
        this.f397d = dialogInterface$OnClickListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.Tools.i(this.f394a, this.f395b, this.f396c, this.f397d);
    }
}
