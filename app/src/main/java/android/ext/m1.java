package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class m1 extends android.ext.j2 implements android.view.View.OnClickListener {
    public m1() {
        super(catch_.me_.if_.you_.can_.R.string.help_mask_search_title, catch_.me_.if_.you_.can_.R.drawable.ic_mask_white_24dp);
    }

    public static boolean k(byte b2, java.lang.String str, long j, int i, int i2, long j2, long j3, boolean z, long j4) {
        int iD = i & 127;
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (mainService.p0 != 0 && !z) {
            iD &= android.ext.MainService.D() & 127;
        }
        int i3 = iD;
        if (i3 == 0) {
            mainService.n(b2);
            return true;
        }
        long[] jArrT = android.ext.Searcher.t(str, j);
        int i4 = i3 | i2;
        if (!mainService.a1()) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.busy_dialog_fail));
        }
        if (mainService.p0 != 0 && z) {
            mainService.n(b2);
        }
        if (mainService.p0 == 0) {
            mainService.q0 = false;
            mainService.i.x0(b2);
        }
        mainService.R(b2);
        mainService.r0 = false;
        mainService.i.o0(b2, jArrT[0], jArrT[1], i4, j2, j3, j4);
        android.ext.MainService.N0(i3, b2);
        return false;
    }

    public static boolean l(java.lang.String str, long j, int i, int i2, long j2, long j3, boolean z, long j4) {
        java.lang.String strH = android.ext.j2.h(str);
        boolean zK = k((byte) 0, strH, j, i, i2, j2, j3, z, j4);
        android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
        if (c2Var != null) {
            if (z) {
                c2Var.write("\ngg.clearResults()\n");
            }
            c2Var.write((z || android.ext.MainService.instance.p0 == 0) ? "gg.searchAddress(" : "gg.refineAddress(");
            android.ext.Script$Consts.c(c2Var, strH);
            c2Var.write(", ");
            android.ext.Script$Consts.b(c2Var, j);
            c2Var.write(", ");
            android.ext.Script$Consts.a(c2Var, c2Var.f697c.f372b, i);
            c2Var.write(", ");
            android.ext.Script$Consts.a(c2Var, c2Var.f697c.f374d, i2);
            c2Var.write(", ");
            android.ext.Script$Consts.b(c2Var, j2);
            c2Var.write(", ");
            android.ext.Script$Consts.b(c2Var, j3);
            c2Var.write(", ");
            c2Var.write(java.lang.Long.toString(j4));
            c2Var.write(")\n");
        }
        return zK;
    }

    @Override // android.ext.j2
    public void j(android.content.DialogInterface dialogInterface, int i) {
        l(this.j.f(), this.j.a(), i, this.j.i(), this.j.e(0), this.j.e(1), this.i == -3, this.j.b());
    }

    @Override // android.ext.j2, android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        this.f1037f = this.j.f();
        this.h = this.j.c();
        android.ext.MainService.O0 = this.j.j();
        this.f1038g = this.j.i();
        super.onDismiss(dialogInterface);
    }
}
