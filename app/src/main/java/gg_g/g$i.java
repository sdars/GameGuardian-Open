package gg_g;

/* JADX INFO: loaded from: classes.dex */
class g$i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g$h f1620b;

    private g$i() {
        this.f1620b = new g$h(null);
    }

    /* synthetic */ g$i(g$a g_a) {
        this();
    }

    public void a(g$i g_i) {
        this.f1619a = g_i.f1619a;
        g$h g_h = this.f1620b;
        g$h g_h2 = g_i.f1620b;
        g_h.f1617a = g_h2.f1617a;
        g_h.f1618b = g_h2.f1618b;
    }
}
