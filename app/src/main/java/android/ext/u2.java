package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class u2 implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final android.ext.c$a[] f1273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final java.lang.String f1274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final android.content.DialogInterface.OnClickListener f1275c;

    public u2(gg_a.e eVar, android.util.SparseIntArray sparseIntArray, java.lang.String str, java.lang.String str2, android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener) {
        android.ext.c$a[] c_aArrX = android.ext.c.x(eVar, sparseIntArray);
        this.f1273a = c_aArrX;
        this.f1274b = str;
        this.f1275c = dialogInterface$OnClickListener;
        if (eVar.size() == 1) {
            onClick(null, 0);
        } else {
            android.ext.f.o(android.ext.f.c(android.ext.Tools.k0()).setCustomTitle(android.ext.Tools.h0(str2)).setAdapter(new android.ext.u2$a(this, android.ext.MainService.context, c_aArrX), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null));
        }
    }

    public u2(gg_a.e eVar, java.lang.String str, java.lang.String str2, android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener) {
        this(eVar, null, str, str2, dialogInterface$OnClickListener);
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            int i2 = this.f1273a[i].f675a;
            if (!"0".equals(this.f1274b)) {
                android.ext.c.e(0L, this.f1274b, i2);
            }
            if (dialogInterface != null) {
                android.ext.Tools.D(dialogInterface);
            }
            this.f1275c.onClick(dialogInterface, i2);
        } catch (java.lang.NumberFormatException e2) {
            android.ext.j2.i(e2, null);
        }
    }
}
