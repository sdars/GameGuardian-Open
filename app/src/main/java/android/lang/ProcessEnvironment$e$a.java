package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$e$a implements java.util.Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.util.Iterator f1469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.lang.ProcessEnvironment$e f1470b;

    ProcessEnvironment$e$a(android.lang.ProcessEnvironment$e processEnvironment$e) {
        this.f1470b = processEnvironment$e;
        this.f1469a = processEnvironment$e.f1468a.iterator();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.String next() {
        return ((android.lang.ProcessEnvironment$h) this.f1469a.next()).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1469a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f1469a.remove();
    }
}
