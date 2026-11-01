package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$e$a implements android.ext.Config$p$b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.Config$e f36a;

    Config$e$a(android.ext.Config$e config$e) {
        this.f36a = config$e;
    }

    @Override // android.ext.Config$p$b
    public void a(int i) {
        java.lang.StringBuilder sb;
        if ((i & 1) != 0) {
            sb = new java.lang.StringBuilder();
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.hide_1_warn));
        } else {
            sb = null;
        }
        if ((i & 8) != 0) {
            if (sb == null) {
                sb = new java.lang.StringBuilder();
            } else {
                sb.append("\n\n");
            }
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.hide_4_warn));
        }
        if (sb != null) {
            android.ext.f.o(android.ext.f.b().setMessage(sb.toString()).setPositiveButton(catch_.me_.if_.you_.can_.R.string.ok, (android.content.DialogInterface.OnClickListener) null));
        }
    }
}
