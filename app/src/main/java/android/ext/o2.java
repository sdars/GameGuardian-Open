package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class o2 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile java.lang.String f1158f = "0";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile android.ext.o2 f1159g;

    public o2() {
        super(catch_.me_.if_.you_.can_.R.string.time_jump, catch_.me_.if_.you_.can_.R.drawable.ic_fast_forward_white_24dp);
        f1159g = this;
    }

    public static void h(long j) {
        if (android.ext.MainService.instance.h.a(false, new android.ext.o2$a(j))) {
            android.ext.MainService.instance.i.e(j);
        }
        j(j);
        android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
        if (c2Var != null) {
            java.lang.String strF = android.ext.Tools.F(j / 1.0E9d);
            c2Var.write("gg.timeJump(");
            android.ext.Script$Consts.c(c2Var, strF);
            c2Var.write(")\n");
        }
    }

    public static long i(java.lang.String str) {
        java.lang.String strTrim = str.trim();
        double dJ1 = android.ext.Tools.j1(strTrim);
        if (dJ1 < -92233720) {
            android.ext.t1$a t1_a = new android.ext.t1$a(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.number_less), strTrim, -92233720L));
            t1_a.c(strTrim);
            t1_a.a(-92233720L);
            throw t1_a;
        }
        if (dJ1 <= 92233720) {
            return (long) (dJ1 * 1.0E9d);
        }
        android.ext.t1$a t1_a2 = new android.ext.t1$a(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.number_greater), strTrim, 92233720L));
        t1_a2.c(strTrim);
        t1_a2.a(92233720L);
        throw t1_a2;
    }

    static void j(long j) {
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_time_jump_last).f42d = (int) ((j / 1.0E9d) * 1000.0d);
        android.ext.Config.k();
        android.ext.TimeJumpPanel timeJumpPanel = android.ext.MainService.instance.k;
        if (timeJumpPanel != null) {
            timeJumpPanel.r();
        }
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        new android.ext.o2$b(this, null).onClick(view);
    }
}
