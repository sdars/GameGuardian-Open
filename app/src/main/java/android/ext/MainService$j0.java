package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$j0 extends android.ext.p1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f251f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainService$j0(android.ext.MainService mainService) {
        super(catch_.me_.if_.you_.can_.R.string.calculate_offset_xor, catch_.me_.if_.you_.can_.R.drawable.ic_vector_difference_white_24dp);
        this.f251f = mainService;
    }

    private void h() {
        int i;
        int i2;
        java.lang.Object objZ = this.f251f.z();
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        if (objZ instanceof gg_d.a) {
            gg_d.a aVar = (gg_d.a) objZ;
            android.ext.c cVar = new android.ext.c();
            int i3 = aVar.i();
            i = 0;
            i2 = 0;
            for (int i4 = 0; i4 < i3; i4++) {
                if (aVar.c(i4)) {
                    if (i < 10) {
                        aVar.f(i4, cVar);
                        jArr[i] = cVar.f672a;
                        jArr2[i] = cVar.f673b & android.ext.c.f668d[cVar.D()];
                        i++;
                    }
                    i2++;
                    if (i2 > 10) {
                        break;
                    }
                }
            }
        } else if (objZ instanceof gg_d.e) {
            gg_d.e eVar = (gg_d.e) objZ;
            int iL = eVar.l();
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < iL; i7++) {
                if (eVar.a(i7)) {
                    android.ext.h2 h2Var = (android.ext.h2) eVar.n(i7);
                    if (h2Var instanceof android.ext.h2) {
                        if (i5 < 10) {
                            jArr[i5] = h2Var.f672a;
                            jArr2[i5] = h2Var.f673b & android.ext.c.f668d[h2Var.D()];
                            i5++;
                        }
                        i6++;
                        if (i6 > 10) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            i2 = i6;
            i = i5;
        } else if (objZ instanceof boolean[]) {
            android.ext.n1 n1Var = this.f251f.N;
            boolean[] zArr = (boolean[]) objZ;
            int length = zArr.length - 1;
            i = 0;
            i2 = 0;
            for (int i8 = 1; i8 < length; i8++) {
                if (zArr[i8]) {
                    if (i < 10) {
                        jArr[i] = n1Var.e(i8);
                        android.ext.c cVar2 = (android.ext.c) n1Var.getItem(i8);
                        jArr2[i] = cVar2.f673b & android.ext.c.f668d[cVar2.D()];
                        i++;
                    }
                    i2++;
                    if (i2 > 10) {
                        break;
                    }
                }
            }
        } else {
            i = 0;
            i2 = 0;
        }
        if (i < 2) {
            android.ext.Tools.J1(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.need_select_more), 2));
            return;
        }
        if (i2 > i) {
            android.ext.Tools.J1(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.used_only_first), java.lang.Integer.valueOf(i)));
        }
        android.ext.f.o(android.ext.f.b().setAdapter(new android.ext.ArrayAdapter(android.ext.MainService.context, new java.lang.String[]{android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.offset), "XOR"}), new android.ext.MainService$j0$a(this, jArr, jArr2, i)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null));
    }

    void i(long[] jArr, long[] jArr2, int i, int i2) {
        int i3 = i - 1;
        int i4 = (i * i3) / 2;
        java.lang.String[] strArr = new java.lang.String[i4];
        java.lang.String[] strArr2 = new java.lang.String[i4];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            int i7 = i5 + 1;
            for (int i8 = i7; i8 < i; i8++) {
                long j = jArr[i5];
                long j2 = jArr[i8];
                java.lang.String upperCase = i2 == 0 ? java.lang.Long.toHexString(j2 - j).toUpperCase(java.util.Locale.US) : android.ext.Tools.L1("%,d", java.lang.Long.valueOf(jArr2[i5] ^ jArr2[i8]));
                strArr2[i6] = upperCase;
                strArr[i6] = android.ext.t2.e(8, j) + " - " + android.ext.t2.e(8, j2) + ": " + upperCase;
                i6++;
            }
            i5 = i7;
        }
        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.select_copy_item)).setAdapter(new android.ext.ArrayAdapter(android.ext.MainService.context, strArr), new android.ext.MainService$j0$b(this, strArr2)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null));
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        h();
    }
}
