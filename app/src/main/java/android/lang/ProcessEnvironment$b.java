package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$b implements java.util.Map.Entry<java.lang.String, java.lang.String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final java.util.Map.Entry f1462a;

    public ProcessEnvironment$b(java.util.Map.Entry map$Entry) {
        this.f1462a = map$Entry;
    }

    @Override // java.util.Map$Entry
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public java.lang.String getKey() {
        return ((android.lang.ProcessEnvironment$h) this.f1462a.getKey()).toString();
    }

    @Override // java.util.Map$Entry
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public java.lang.String getValue() {
        return ((android.lang.ProcessEnvironment$g) this.f1462a.getValue()).toString();
    }

    @Override // java.util.Map$Entry
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public java.lang.String setValue(java.lang.String str) {
        return ((android.lang.ProcessEnvironment$g) this.f1462a.setValue(android.lang.ProcessEnvironment$g.c(str))).toString();
    }

    @Override // java.util.Map$Entry
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof android.lang.ProcessEnvironment$b) && this.f1462a.equals(((android.lang.ProcessEnvironment$b) obj).f1462a);
    }

    @Override // java.util.Map$Entry
    public int hashCode() {
        return this.f1462a.hashCode();
    }

    public java.lang.String toString() {
        return getKey() + '=' + getValue();
    }
}
