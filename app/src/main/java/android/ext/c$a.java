package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class c$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    java.lang.CharSequence f676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f677c;

    public c$a(int i, java.lang.CharSequence charSequence, int i2) {
        this.f675a = i;
        this.f676b = charSequence;
        this.f677c = i2;
    }

    public java.lang.String toString() {
        if (this.f677c <= 0) {
            return this.f676b.toString();
        }
        return this.f677c + ": " + this.f676b.toString();
    }
}
