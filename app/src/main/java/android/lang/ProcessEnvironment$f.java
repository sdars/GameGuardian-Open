package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$f extends java.util.AbstractCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final java.util.Collection f1471a;

    public ProcessEnvironment$f(java.util.Collection collection) {
        this.f1471a = collection;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f1471a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(java.lang.Object obj) {
        return this.f1471a.contains(android.lang.ProcessEnvironment$g.e(obj));
    }

    @Override // java.util.Collection
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof android.lang.ProcessEnvironment$f) && this.f1471a.equals(((android.lang.ProcessEnvironment$f) obj).f1471a);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.f1471a.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f1471a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public java.util.Iterator iterator() {
        return new android.lang.ProcessEnvironment$f$a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(java.lang.Object obj) {
        return this.f1471a.remove(android.lang.ProcessEnvironment$g.e(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f1471a.size();
    }
}
