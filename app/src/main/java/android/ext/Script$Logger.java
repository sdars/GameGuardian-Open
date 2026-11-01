package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Script$Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.io.OutputStream f380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    java.io.FileInputStream f381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    java.lang.StringBuilder f382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f383d;

    Script$Logger() {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.FileInputStream fileInputStream;
        java.lang.Throwable th;
        java.lang.StringBuilder sb = null;
        try {
            java.io.File file = new java.io.File(android.ext.Tools.p0(), java.lang.System.currentTimeMillis() + ".tmp");
            file.createNewFile();
            bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
            try {
                fileInputStream = new java.io.FileInputStream(file);
                try {
                    file.delete();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    android.ext.e1.a(th);
                    sb = new java.lang.StringBuilder();
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileInputStream = null;
                th = th;
                android.ext.e1.a(th);
                sb = new java.lang.StringBuilder();
                this.f382c = sb;
                this.f380a = bufferedOutputStream;
                this.f381b = fileInputStream;
                this.f383d = 0;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            fileInputStream = null;
        }
        this.f382c = sb;
        this.f380a = bufferedOutputStream;
        this.f381b = fileInputStream;
        this.f383d = 0;
    }

    public void a(java.lang.String str) {
        java.lang.StringBuilder sb = this.f382c;
        if (sb != null) {
            sb.append(str);
            return;
        }
        try {
            byte[] bytes = str.getBytes();
            this.f380a.write(bytes);
            this.f383d += bytes.length;
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    public java.lang.String toString() {
        int i = this.f383d;
        if (i < 0) {
            return "must be called only once";
        }
        java.lang.StringBuilder sb = this.f382c;
        if (sb != null) {
            return sb.toString();
        }
        try {
            this.f383d = -1;
            this.f380a.close();
            int i2 = 262144;
            if (i > 262144) {
                this.f381b.skip(i - 262144);
            } else {
                i2 = i;
            }
            byte[] bArr = new byte[i2];
            int i3 = this.f381b.read(bArr);
            this.f381b.close();
            android.ext.e1.d("Log script size: read = " + i3 + "; used = " + i2 + "; full = " + i);
            return i3 > 0 ? new java.lang.String(bArr, 0, i3) : "";
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return "";
        }
    }
}
