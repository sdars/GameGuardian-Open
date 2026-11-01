package gg_g;

/* JADX INFO: loaded from: classes.dex */
public class f extends c {
    final lasm.b q;

    public f(lasm.b bVar) {
        this.q = bVar;
        this.f1578e = new g(null, null);
    }

    @Override // g.c
    int S(int i, int i2) {
        return this.q.g(i);
    }

    @Override // g.c
    public int T(int i, int i2, int i3, int i4) {
        return super.T(i, i2, i3, i4);
    }

    @Override // g.c
    public int U(int i, int i2, int i3) {
        return super.U(i, i2, i3);
    }

    @Override // g.c
    public int V(int i, int i2, int i3) {
        return super.V(i, i2, i3);
    }

    @Override // g.c
    public int W(int i, int i2) {
        return super.W(i, i2);
    }

    public void o1(int i, int i2, int i3) {
        if (i3 <= 511) {
            T(36, i, i2, i3);
        } else {
            T(36, i, i2, 0);
            S(i3, this.f1578e.f1592d);
        }
    }
}
