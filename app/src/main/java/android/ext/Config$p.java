package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class Config$p implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f40b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    java.lang.String f41c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f42d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f43e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f45g;
    protected android.ext.Config$p$b j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f44f = 0;
    int h = -1;
    protected android.ext.Config$p$a i = null;

    public Config$p(int i, int i2, int i3, java.lang.String str, boolean z) {
        this.f39a = i2;
        this.f40b = i3;
        this.f41c = str;
        this.f42d = i3;
        this.f45g = z;
        d();
        android.ext.Config.H.put(i, this);
    }

    public java.lang.CharSequence a() {
        return toString();
    }

    public abstract void b();

    public long c() {
        return ((long) this.f42d) | (((long) this.f44f) << 32);
    }

    protected void d() {
    }

    public abstract boolean e(android.content.DialogInterface dialogInterface, int i);

    public void f(android.ext.Config$p$a config$p$a) {
        this.i = config$p$a;
    }

    public void g(android.ext.Config$p$b config$p$b) {
        this.j = config$p$b;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Config$p$b config$p$b;
        android.ext.Config$p$a config$p$a = this.i;
        if (config$p$a != null) {
            i = config$p$a.a(dialogInterface, i);
        }
        if (!e(dialogInterface, i) || (config$p$b = this.j) == null) {
            return;
        }
        config$p$b.a(this.f42d);
    }

    public java.lang.String toString() {
        return android.ext.b2.f(this.f39a) + ' ' + this.f42d;
    }
}
