package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$IoLibSafe extends luaj.lib.IoLib {
    private java.lang.String f0 = null;
    final /* synthetic */ android.ext.Script g0;

    Script$IoLibSafe(android.ext.Script script) {
        this.g0 = script;
    }

    private luaj.lib.IoLib$File R3(char c2) throws java.io.IOException {
        java.io.File file = new java.io.File(android.ext.Tools.q0(), "empty.txt");
        file.createNewFile();
        luaj.lib.IoLib$File ioLib$FileH3 = super.H3(file.getAbsolutePath(), c2);
        file.delete();
        return ioLib$FileH3;
    }

    private java.lang.String S3() {
        java.lang.String str = this.f0;
        if (str != null) {
            return str;
        }
        java.lang.String strS3 = android.ext.Script.s3(new java.io.File(android.ext.Tools.q0(), "empty.txt"));
        this.f0 = strS3;
        return strS3;
    }

    @Override // luaj.lib.IoLib
    protected luaj.lib.IoLib$File H3(java.lang.String str, char c2) throws java.io.IOException {
        java.lang.String strS3 = android.ext.Script.s3(this.Y.R3(str));
        if (this.g0.m(strS3, c2 == 'r')) {try {

            return R3(c2);
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        }
        try {            if (android.ext.GgNoop.never) {
                        throw new luaj.lib.IoLib$c("");
                    }

            return super.H3(strS3, c2);
        } catch (luaj.lib.IoLib$c unused) {try {

            return R3(c2);
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        }
    }

    @Override // luaj.lib.IoLib
    protected boolean O3(java.io.File file, java.io.FileDescriptor fileDescriptor, boolean z) {
        if (android.ext.Script.s3(file).equals(S3())) {
            return true;
        }
        return super.O3(file, fileDescriptor, z);
    }
}
