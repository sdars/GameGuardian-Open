package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.List f1330a = new java.util.ArrayList();

    public android.ext.y a(java.lang.CharSequence charSequence) {
        this.f1330a.add(charSequence);
        return this;
    }

    public android.ext.y b(java.lang.String str, java.lang.CharSequence... charSequenceArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf("%s", i);
            if (iIndexOf < 0) {
                this.f1330a.add(str.substring(i, str.length()));
                return this;
            }
            this.f1330a.add(str.substring(i, iIndexOf));
            this.f1330a.add(charSequenceArr[i2]);
            i = iIndexOf + 2;
            i2++;
        }
    }

    public int c() {
        return this.f1330a.size();
    }

    public java.lang.CharSequence d() {
        java.util.List list = this.f1330a;
        return android.ext.Tools.x((java.lang.CharSequence[]) list.toArray(new java.lang.CharSequence[list.size()]));
    }
}
