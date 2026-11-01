package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$b$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.StringBuilder f956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.String f957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.f1$b f958c;

    f1$b$a(android.ext.f1$b f1_b, java.lang.StringBuilder sb, java.lang.String str) {
        this.f958c = f1_b;
        this.f956a = sb;
        this.f957b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.main_new_version, null);
        android.ext.Tools.v1((android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.changelog), this.f956a.toString());
        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.h0(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.found_new_version), this.f957b))).setView(viewF).setCancelable(false).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.download_it), new android.ext.r$n(null)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
    }
}
