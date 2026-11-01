package android.ext;

/* JADX INFO: loaded from: classes.dex */
class t1$a$a implements java.util.Comparator<java.lang.String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.t1$a f1260a;

    t1$a$a(android.ext.t1$a t1_a) {
        this.f1260a = t1_a;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(java.lang.String str, java.lang.String str2) {
        return str2.length() - str.length();
    }
}
