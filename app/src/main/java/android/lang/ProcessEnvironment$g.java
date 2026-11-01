package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$g extends android.lang.ProcessEnvironment$a implements java.lang.Comparable<android.lang.ProcessEnvironment$g> {
    protected ProcessEnvironment$g(java.lang.String str, byte[] bArr) {
        super(str, bArr);
    }

    public static android.lang.ProcessEnvironment$g c(java.lang.String str) {
        android.lang.ProcessEnvironment.k(str);
        return f(str);
    }

    public static android.lang.ProcessEnvironment$g d(byte[] bArr) {
        return new android.lang.ProcessEnvironment$g(new java.lang.String(bArr), bArr);
    }

    public static android.lang.ProcessEnvironment$g e(java.lang.Object obj) {
        return f((java.lang.String) obj);
    }

    public static android.lang.ProcessEnvironment$g f(java.lang.String str) {
        return new android.lang.ProcessEnvironment$g(str, str.getBytes());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(android.lang.ProcessEnvironment$g processEnvironment$g) {
        return android.lang.ProcessEnvironment.f(a(), processEnvironment$g.a());
    }

    @Override // android.lang.ProcessEnvironment$a
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof android.lang.ProcessEnvironment$g) && super.equals(obj);
    }
}
