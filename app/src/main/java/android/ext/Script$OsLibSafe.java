package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$OsLibSafe extends luaj.lib.OsLib {
    final /* synthetic */ android.ext.Script W;

    Script$OsLibSafe(android.ext.Script script) {
        this.W = script;
    }

    @Override // luaj.lib.OsLib
    protected void r3(java.lang.String str) throws java.io.IOException {
        if (this.W.m(str, false)) {
            return;
        }
        super.r3(str);
    }

    @Override // luaj.lib.OsLib
    protected void s3(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        if (this.W.m(str, false) || this.W.m(str2, false)) {
            return;
        }
        super.s3(str, str2);
    }
}
