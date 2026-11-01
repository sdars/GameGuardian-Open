package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$h extends android.lang.ProcessEnvironment$a implements java.lang.Comparable<android.lang.ProcessEnvironment$h> {
    protected ProcessEnvironment$h(java.lang.String str, byte[] bArr) {
        super(str, bArr);
    }

    public static android.lang.ProcessEnvironment$h c(java.lang.String str) {
        android.lang.ProcessEnvironment.l(str);
        return f(str);
    }

    public static android.lang.ProcessEnvironment$h d(byte[] bArr) {
        return new android.lang.ProcessEnvironment$h(new java.lang.String(bArr), bArr);
    }

    public static android.lang.ProcessEnvironment$h e(java.lang.Object obj) {
        return f((java.lang.String) obj);
    }

    public static android.lang.ProcessEnvironment$h f(java.lang.String str) {
        return new android.lang.ProcessEnvironment$h(str, str.getBytes());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(android.lang.ProcessEnvironment$h processEnvironment$h) {
        return android.lang.ProcessEnvironment.f(a(), processEnvironment$h.a());
    }

    @Override // android.lang.ProcessEnvironment$a
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof android.lang.ProcessEnvironment$h) && super.equals(obj);
    }
}
