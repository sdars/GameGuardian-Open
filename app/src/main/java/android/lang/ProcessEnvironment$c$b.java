package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$c$b implements java.util.Map.Entry<android.lang.ProcessEnvironment$h, android.lang.ProcessEnvironment$g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Object f1466a;

    ProcessEnvironment$c$b(java.lang.Object obj) {
        this.f1466a = obj;
    }

    @Override // java.util.Map$Entry
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public android.lang.ProcessEnvironment$h getKey() {
        return android.lang.ProcessEnvironment$h.e(((java.util.Map.Entry) this.f1466a).getKey());
    }

    @Override // java.util.Map$Entry
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public android.lang.ProcessEnvironment$g getValue() {
        return android.lang.ProcessEnvironment$g.e(((java.util.Map.Entry) this.f1466a).getValue());
    }

    @Override // java.util.Map$Entry
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public android.lang.ProcessEnvironment$g setValue(android.lang.ProcessEnvironment$g processEnvironment$g) {
        throw new java.lang.UnsupportedOperationException();
    }
}
