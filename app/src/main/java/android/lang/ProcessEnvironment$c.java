package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$c extends java.util.AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final java.util.Set f1463a;

    public ProcessEnvironment$c(java.util.Set set) {
        this.f1463a = set;
    }

    private static java.util.Map.Entry b(java.lang.Object obj) {
        return obj instanceof android.lang.ProcessEnvironment$b ? ((android.lang.ProcessEnvironment$b) obj).f1462a : new android.lang.ProcessEnvironment$c$b(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f1463a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(java.lang.Object obj) {
        return this.f1463a.contains(b(obj));
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof android.lang.ProcessEnvironment$c) && this.f1463a.equals(((android.lang.ProcessEnvironment$c) obj).f1463a);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f1463a.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1463a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public java.util.Iterator iterator() {
        return new android.lang.ProcessEnvironment$c$a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(java.lang.Object obj) {
        return this.f1463a.remove(b(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f1463a.size();
    }
}
