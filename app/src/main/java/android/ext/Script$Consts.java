package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$Consts {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.ext.Script$Const[] f371a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    android.ext.Script$Const[] f372b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    android.ext.Script$Const[] f373c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    android.ext.Script$Const[] f374d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    android.ext.Script$Const[] f375e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    android.ext.Script$Const[] f376f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    android.ext.Script$Const[] f377g = null;
    android.ext.Script$Const[] h = null;
    android.ext.Script$Const[] i = null;
    android.ext.Script$Const[] j = null;

    Script$Consts() {
    }

    static boolean a(java.io.Writer writer, android.ext.Script$Const[] script$ConstArr, int i) {
        try {
            boolean z = true;
            for (android.ext.Script$Const script$Const : script$ConstArr) {
                int i2 = script$Const.f370b;
                if ((i & i2) == i2) {
                    writer.write(script$Const.f369a);
                    i &= ~i2;
                    if (i != 0) {
                        writer.write(" | ");
                    }
                    z = false;
                }
            }
            if (z || i != 0) {
                writer.write(java.lang.Integer.toString(i));
            }
            return true;
        } catch (java.io.IOException e2) {
            android.ext.e1.s("Writer fail", e2);
            return false;
        }
    }

    static boolean b(java.io.Writer writer, long j) {
        java.lang.String string;
        try {
            if (j == 0 || j == -1) {
                string = java.lang.Long.toString(j);
            } else {
                writer.write("0x");
                string = java.lang.Long.toHexString(j);
            }
            writer.write(string);
            return true;
        } catch (java.io.IOException e2) {
            android.ext.e1.s("Writer fail", e2);
            return false;
        }
    }

    static boolean c(java.io.Writer writer, java.lang.String str) {
        return d(writer, android.ext.Script.E3(str));
    }

    static boolean d(java.io.Writer writer, java.lang.String str) {
        try {
            writer.write("\"");
            if (str.length() <= 65535) {
                str = str.replace("\"", "\\\"");
            }
            writer.write(str);
            writer.write("\"");
            return true;
        } catch (java.io.IOException e2) {
            android.ext.e1.s("Writer fail", e2);
            return false;
        }
    }
}
