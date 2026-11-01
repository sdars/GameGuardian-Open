package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z1$a extends java.util.LinkedHashMap {
    z1$a(int i, float f2, boolean z) {
        super(i, f2, z);
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(java.util.Map.Entry map$Entry) {
        return size() > 128;
    }
}
