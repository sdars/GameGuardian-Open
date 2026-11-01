package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$e extends java.util.AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final java.util.Set f1468a;

    public ProcessEnvironment$e(java.util.Set set) {
        this.f1468a = set;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f1468a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(java.lang.Object obj) {
        return this.f1468a.contains(android.lang.ProcessEnvironment$h.e(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1468a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public java.util.Iterator iterator() {
        return new android.lang.ProcessEnvironment$e$a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(java.lang.Object obj) {
        return this.f1468a.remove(android.lang.ProcessEnvironment$h.e(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f1468a.size();
    }
}
