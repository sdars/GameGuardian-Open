package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$ScriptPrintStream extends gg_b.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ android.ext.Script f391g;

    public Script$ScriptPrintStream(android.ext.Script script, boolean z) {
        this.f391g = script;
        this.f390f = z;
    }

    @Override // b.a
    protected void b(java.lang.String str) {
        this.f391g.a3(this.f390f, str);
        java.lang.String str2 = "script: " + str;
        if (this.f390f) {
            android.ext.e1.i(str2);
        } else {
            android.ext.e1.d(str2);
        }
    }
}
