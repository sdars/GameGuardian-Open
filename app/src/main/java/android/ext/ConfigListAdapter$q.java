package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$q implements java.util.Comparator<java.lang.String> {
    ConfigListAdapter$q() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(java.lang.String str, java.lang.String str2) {
        return (str + "_zzz").replace('-', '_').compareTo((str2 + "_zzz").replace('-', '_'));
    }
}
