package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$a$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.StringBuilder f55a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter$a f56b;

    ConfigListAdapter$a$a(android.ext.ConfigListAdapter$a configListAdapter$a, java.lang.StringBuilder sb) {
        this.f56b = configListAdapter$a;
        this.f55a = sb;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.Tools.u1(android.ext.f.m(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.change_log)).setMessage(this.f55a.toString()).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null).create()));
    }
}
