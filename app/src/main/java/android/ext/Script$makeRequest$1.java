package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$makeRequest$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$makeRequest f419a;

    Script$makeRequest$1(android.ext.Script$makeRequest script$makeRequest) {
        this.f419a = script$makeRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setCustomTitle(android.ext.Tools.h0(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script))).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_prompt_internet)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), this.f419a).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null).create();
        android.ext.f.k(alertDialogCreate, this.f419a);
        android.ext.f.m(alertDialogCreate);
    }
}
