package android.lang;

/* JADX INFO: loaded from: classes.dex */
abstract class ProcessEnvironment$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final java.lang.String f1460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final byte[] f1461b;

    protected ProcessEnvironment$a(java.lang.String str, byte[] bArr) {
        this.f1460a = str;
        this.f1461b = bArr;
    }

    public byte[] a() {
        return this.f1461b;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof android.lang.ProcessEnvironment$a) && android.lang.ProcessEnvironment.g(a(), ((android.lang.ProcessEnvironment$a) obj).a());
    }

    public int hashCode() {
        return android.lang.ProcessEnvironment.h(a());
    }

    public java.lang.String toString() {
        return this.f1460a;
    }
}
