package android.ext;

/* JADX INFO: loaded from: classes.dex */
class PathSelector$b implements java.util.Comparator<android.ext.PathSelector$d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.StringBuilder f324a;

    PathSelector$b(java.lang.StringBuilder sb) {
        this.f324a = sb;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(android.ext.PathSelector$d pathSelector$d, android.ext.PathSelector$d pathSelector$d2) {
        int iA;
        boolean z = pathSelector$d.f337c;
        boolean z2 = pathSelector$d2.f337c;
        if (z != z2) {
            iA = z ? -1 : 1;
        } else {
            iA = android.ext.r1.a(pathSelector$d.f336b, pathSelector$d2.f336b);
        }
        this.f324a.append(z ? 'D' : 'F');
        this.f324a.append(':');
        this.f324a.append(pathSelector$d);
        this.f324a.append(':');
        this.f324a.append(pathSelector$d.f336b);
        this.f324a.append('\n');
        this.f324a.append(z2 ? 'D' : 'F');
        this.f324a.append(':');
        this.f324a.append(pathSelector$d2);
        this.f324a.append(':');
        this.f324a.append(pathSelector$d2.f336b);
        this.f324a.append('\n');
        this.f324a.append(iA);
        this.f324a.append('\n');
        return iA;
    }
}
