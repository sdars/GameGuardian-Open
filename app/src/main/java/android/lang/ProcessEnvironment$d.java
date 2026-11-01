package android.lang;

/* JADX INFO: loaded from: classes.dex */
class ProcessEnvironment$d extends java.util.AbstractMap<java.lang.String, java.lang.String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.Map f1467a;

    public ProcessEnvironment$d(java.util.Map map) {
        this.f1467a = map;
    }

    private static java.lang.String e(android.lang.ProcessEnvironment$g processEnvironment$g) {
        if (processEnvironment$g == null) {
            return null;
        }
        return processEnvironment$g.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.String get(java.lang.Object obj) {
        return e((android.lang.ProcessEnvironment$g) this.f1467a.get(android.lang.ProcessEnvironment$h.e(obj)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public java.lang.String put(java.lang.String str, java.lang.String str2) {
        return e((android.lang.ProcessEnvironment$g) this.f1467a.put(android.lang.ProcessEnvironment$h.c(str), android.lang.ProcessEnvironment$g.c(str2)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public java.lang.String remove(java.lang.Object obj) {
        return e((android.lang.ProcessEnvironment$g) this.f1467a.remove(android.lang.ProcessEnvironment$h.e(obj)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f1467a.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        return this.f1467a.containsKey(android.lang.ProcessEnvironment$h.e(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(java.lang.Object obj) {
        return this.f1467a.containsValue(android.lang.ProcessEnvironment$g.e(obj));
    }

    public byte[] d(int[] iArr) {
        int size = this.f1467a.size() * 2;
        for (java.util.Map.Entry map$Entry : (java.util.Collection<java.util.Map.Entry>) this.f1467a.entrySet()) {
            size = size + ((android.lang.ProcessEnvironment$h) map$Entry.getKey()).a().length + ((android.lang.ProcessEnvironment$g) map$Entry.getValue()).a().length;
        }
        byte[] bArr = new byte[size];
        int length = 0;
        for (java.util.Map.Entry map$Entry2 : (java.util.Collection<java.util.Map.Entry>) this.f1467a.entrySet()) {
            byte[] bArrA = ((android.lang.ProcessEnvironment$h) map$Entry2.getKey()).a();
            byte[] bArrA2 = ((android.lang.ProcessEnvironment$g) map$Entry2.getValue()).a();
            java.lang.System.arraycopy(bArrA, 0, bArr, length, bArrA.length);
            int length2 = length + bArrA.length;
            int i = length2 + 1;
            bArr[length2] = 61;
            java.lang.System.arraycopy(bArrA2, 0, bArr, i, bArrA2.length);
            length = bArrA2.length + 1 + i;
        }
        iArr[0] = this.f1467a.size();
        return bArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set entrySet() {
        return new android.lang.ProcessEnvironment$c(this.f1467a.entrySet());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f1467a.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set keySet() {
        return new android.lang.ProcessEnvironment$e(this.f1467a.keySet());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f1467a.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Collection values() {
        return new android.lang.ProcessEnvironment$f(this.f1467a.values());
    }
}
