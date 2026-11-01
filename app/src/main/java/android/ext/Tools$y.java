package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.lang.Class f550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    java.lang.String f551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    java.lang.Class[] f552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    java.lang.Object f553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    java.lang.Object[] f554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    java.lang.reflect.Method f555f = null;

    public Tools$y(java.lang.Class cls, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object obj, java.lang.Object[] objArr) {
        this.f550a = cls;
        this.f551b = str;
        this.f552c = clsArr;
        this.f553d = obj;
        this.f554e = objArr;
    }

    public android.ext.Tools$y a() {try {

        this.f555f = this.f550a.getMethod(this.f551b, this.f552c);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        return this;
    }

    public java.lang.Object b() {try {

        return this.f555f.invoke(this.f553d, this.f554e);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }
}
