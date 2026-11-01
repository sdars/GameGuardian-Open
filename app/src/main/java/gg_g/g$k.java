package gg_g;

/* JADX INFO: loaded from: classes.dex */
class g$k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g$k$a f1623b = new g$k$a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final e f1624c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final e f1625d = new e();

    g$k() {
    }

    boolean a() {
        return this.f1624c.f1589a != this.f1625d.f1589a;
    }

    void b(int i, int i2) {
        this.f1625d.f1589a = -1;
        this.f1624c.f1589a = -1;
        this.f1622a = i;
        this.f1623b.f1630e = i2;
    }

    boolean c() {
        return this.f1622a == 5 && this.f1624c.f1589a == -1 && this.f1625d.f1589a == -1;
    }

    public void d(g$k g_k) {
        this.f1625d.f1589a = g_k.f1625d.f1589a;
        this.f1622a = g_k.f1622a;
        this.f1624c.f1589a = g_k.f1624c.f1589a;
        g$k$a g_k_a = this.f1623b;
        g$k$a g_k_a2 = g_k.f1623b;
        g_k_a.f1629d = g_k_a2.f1629d;
        g_k_a.f1626a = g_k_a2.f1626a;
        g_k_a.f1627b = g_k_a2.f1627b;
        g_k_a.f1628c = g_k_a2.f1628c;
        g_k_a.f1630e = g_k_a2.f1630e;
    }
}
