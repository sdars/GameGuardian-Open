package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$f$a implements java.util.Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.util.Iterator f1472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.lang.ProcessEnvironment$f f1473b;

    ProcessEnvironment$f$a(android.lang.ProcessEnvironment$f processEnvironment$f) {
        this.f1473b = processEnvironment$f;
        this.f1472a = processEnvironment$f.f1471a.iterator();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.String next() {
        return ((android.lang.ProcessEnvironment$g) this.f1472a.next()).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1472a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f1472a.remove();
    }
}
