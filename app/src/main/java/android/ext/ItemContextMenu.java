package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class ItemContextMenu implements android.widget.AdapterView.OnItemLongClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final java.lang.ThreadLocal f196f = new java.lang.ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final java.lang.String[] f199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final java.lang.String[] f200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final java.lang.String[] f201e;

    public ItemContextMenu(int i) {
        this.f197a = i;
        int[] iArr = {0, 4, 16, 64, 2, 1, 32, 8};
        this.f198b = iArr;
        this.f199c = new java.lang.String[iArr.length];
        this.f200d = new java.lang.String[iArr.length];
        this.f201e = new java.lang.String[iArr.length];
    }

    public static long b(long j) {
        f196f.set(java.lang.Long.valueOf(j));
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:162:0x047f  */
    @Override // android.widget.AdapterView$OnItemLongClickListener
    public boolean onItemLongClick(android.widget.AdapterView adapterView, android.view.View view, int i, long j) {
        int i2;
        java.lang.String str;
        long j2;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String strO;
        java.lang.String strQ;
        java.lang.String string;
        java.lang.String str4;
        int i3;
        java.lang.String str5;
        java.lang.String str6;
        int i4;
        long j3;
        int[] iArr;
        int i5;
        java.lang.String str7;
        int i6;
        java.lang.String str8;
        java.lang.Object itemAtPosition = adapterView.getItemAtPosition(i);
        if (!(itemAtPosition instanceof android.ext.c)) {
            return false;
        }
        android.ext.c cVar = (android.ext.c) itemAtPosition;
        android.ext.h2 h2Var = new android.ext.h2(cVar);
        java.lang.String strF = h2Var.F();
        long j4 = h2Var.f672a;
        int i7 = h2Var.f674c;
        int i8 = i7 & 127;
        long j5 = h2Var.f673b;
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        int iE = this.f197a == 3 ? 8 : android.ext.c.E(i8);
        long j6 = 3 & j4;
        int i9 = (j6 != 0 || iE < 4) ? 0 : (z1_d == null || !z1_d.n || iE != 8 || ((-4294967296L) & j5) == 0) ? 1 : 2;
        boolean z = (i7 & 47) != 0;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        arrayList.add(strF);
        arrayList2.add(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.offset_calculator));
        arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_calculator_white_24dp));
        arrayList.add(strF);
        arrayList2.add(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_pointer_search_title));
        arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_pointer_white_24dp));
        arrayList.add(strF);
        arrayList2.add(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.search_nearby));
        arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_search_nearby_white_24dp));
        int i10 = 32;
        if (adapterView != android.ext.MainService.instance.M) {
            arrayList.add(strF);
            arrayList2.add(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.goto_address) + ' ' + strF);
            arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_forward_white_24dp));
        }
        int i11 = 0;
        while (i11 < i9) {
            int i12 = i9;
            if (i11 == 0) {
                i10 = 4;
            }
            java.lang.String strM = android.ext.c.M(j4, j5, i10);
            arrayList.add(strM);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            boolean z2 = z;
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.goto_pointer));
            sb.append(' ');
            sb.append(strM);
            arrayList2.add(sb.toString());
            arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_forward_white_24dp));
            int i13 = i8;
            long j7 = j5 & (-4096);
            if (j7 != 0 && android.ext.RegionList.b(j7) == null) {
                java.lang.String strM2 = android.ext.c.M(j4, j7, i10);
                arrayList.add(strM2);
                arrayList2.add(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.allocate_page) + ": " + strM2);
                arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_code_braces_white_24dp));
            }
            i11++;
            i8 = i13;
            i9 = i12;
            z = z2;
            i10 = 32;
        }
        boolean z3 = z;
        int i14 = i8;
        long j8 = j4 & (-4096);
        if (j8 != 0 && android.ext.RegionList.b(j8) == null) {
            java.lang.String strG = android.ext.c.G(j8, 4);
            arrayList.add(strG);
            arrayList2.add(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.allocate_page) + ": " + strG);
            arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_code_braces_white_24dp));
        }
        arrayList.add(strF);
        arrayList2.add(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.copy_address) + ' ' + strF);
        arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_content_copy_white_24dp));
        int iH = android.ext.MainService.instance.H();
        if (iH == 1) {
            i2 = android.ext.AddressArrayAdapter.f23d;
        } else if (iH == 3) {
            i2 = android.ext.MainService.instance.N.j;
        } else {
            i2 = iH == 2 ? android.ext.SavedListAdapter.f360c : 0;
        }
        java.lang.String str9 = "ARM (x64)";
        java.lang.String str10 = "Thumb";
        if (i2 != 0) {
            int i15 = 0;
            strO = null;
            strQ = null;
            string = null;
            for (int i16 = 3; i15 < i16; i16 = 3) {
                if ((i15 != 0 || (j6 == 0 && (i2 & 16) != 0)) && ((i15 != 1 || ((j4 & 1) == 0 && (i2 & 32) != 0)) && (i15 != 2 || (j6 == 0 && (i2 & 64) != 0)))) {
                    java.lang.ThreadLocal threadLocal = f196f;
                    i5 = i2;
                    threadLocal.set(0L);
                    if (i15 == 0) {
                        strO = android.ext.n.o(null, j4, j5);
                    }
                    str7 = str9;
                    if (i15 == 1) {
                        strQ = android.ext.n.q(null, j4, j5);
                    }
                    if (i15 == 2) {
                        string = android.ext.m.g(android.ext.m.d(), j4, (int) j5, new java.lang.StringBuilder()).toString();
                    }
                    long jLongValue = ((java.lang.Long) threadLocal.get()).longValue();
                    if (jLongValue != 0) {
                        if (i15 == 0) {
                            str8 = "ARM (x32)";
                            i6 = 1;
                        } else {
                            i6 = 1;
                            str8 = null;
                        }
                        if (i15 == i6) {
                            str8 = str10;
                        }
                        if (i15 == 2) {
                            str8 = str7;
                        }
                        java.lang.String str11 = str8 + ": ";
                        strF = strF;
                        java.lang.String strG2 = android.ext.c.G(jLongValue, 4);
                        arrayList.add(strG2);
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append(str11);
                        j4 = j4;
                        sb2.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.goto_address));
                        sb2.append(' ');
                        sb2.append(strG2);
                        arrayList2.add(sb2.toString());
                        arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_forward_white_24dp));
                        arrayList.add(strG2);
                        arrayList2.add(str11 + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.copy_address) + ' ' + strG2);
                        arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_content_copy_white_24dp));
                        long j9 = jLongValue & (-4096);
                        if (j9 != 0 && android.ext.RegionList.b(j9) == null) {
                            java.lang.String strG3 = android.ext.c.G(j9, 4);
                            arrayList.add(strG3);
                            arrayList2.add(str11 + android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.allocate_page) + ": " + strG3);
                            arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_code_braces_white_24dp));
                        }
                    }
                    i15++;
                    i2 = i5;
                    str9 = str7;
                    str10 = str10;
                    strF = strF;
                    j4 = j4;
                } else {
                    i5 = i2;
                    str7 = str9;
                    str10 = str10;
                }
                i15++;
                i2 = i5;
                str9 = str7;
                str10 = str10;
                strF = strF;
                j4 = j4;
            }
            str = strF;
            j2 = j4;
            str2 = str9;
            str3 = str10;
        } else {
            str = strF;
            j2 = j4;
            str2 = "ARM (x64)";
            str3 = "Thumb";
            strO = null;
            strQ = null;
            string = null;
        }
        int[] iArr2 = this.f198b;
        java.lang.String[] strArr = this.f199c;
        java.lang.String[] strArr2 = this.f200d;
        java.lang.String[] strArr3 = this.f201e;
        int i17 = 0;
        int i18 = 0;
        while (i17 < iArr2.length) {
            int i19 = iArr2[i17];
            if (i19 == 0 || (i14 & i19) != 0) {
                if (i19 == 0) {
                    i19 = i14;
                    i4 = i19;
                } else {
                    i4 = i14;
                }
                int[] iArr3 = iArr2;
                j3 = j2;
                java.lang.String strK = android.ext.c.K(j3, j5, i19);
                iArr = iArr3;
                int i20 = 0;
                while (true) {
                    if (i20 >= i18) {
                        strArr[i18] = strK;
                        if (z3) {
                            int i21 = i19 & (-81);
                            strArr2[i18] = i21 == 0 ? null : android.ext.c.M(j3, j5, i19);
                            strArr3[i18] = i21 == 0 ? null : android.ext.c.P(j3, j5, i19);
                        }
                        i18++;
                        break;
                    }
                    if (strArr[i20].equals(strK)) {
                        break;
                    }
                    i20++;
                }
            } else {
                i4 = i14;
                iArr = iArr2;
                j3 = j2;
            }
            i17++;
            j2 = j3;
            i14 = i4;
            iArr2 = iArr;
        }
        if (i18 > 0) {
            for (int i22 = 0; i22 < i18; i22++) {
                arrayList.add(strArr[i22]);
                arrayList2.add(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.copy_value) + ' ' + strArr[i22]);
                arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_content_copy_white_24dp));
                if (z3 && (str6 = strArr2[i22]) != null) {
                    arrayList.add(str6);
                    arrayList2.add(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.copy_hex_value) + ' ' + strArr2[i22]);
                    arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_content_copy_white_24dp));
                    arrayList.add(strArr3[i22]);
                    arrayList2.add(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.copy_rhex_value) + ' ' + strArr3[i22]);
                    arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_content_copy_white_24dp));
                }
            }
        }
        for (int i23 = 0; i23 < 3; i23++) {
            if (i23 == 0) {
                str4 = "ARM (x32)";
                str5 = strO;
                i3 = 1;
            } else {
                str4 = null;
                i3 = 1;
                str5 = null;
            }
            if (i23 == i3) {
                str5 = strQ;
                str4 = str3;
            }
            if (i23 == 2) {
                str5 = string;
                str4 = str2;
            }
            if (str5 != null) {
                java.lang.String strTrim = str5.trim();
                int iIndexOf = strTrim.indexOf(59);
                if (iIndexOf != -1) {
                    strTrim = strTrim.substring(0, iIndexOf).trim();
                }
                if (strTrim.length() > 0) {
                    arrayList.add(strTrim);
                    arrayList2.add(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.copy_opcode), str4) + ' ' + strTrim);
                    arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_content_copy_white_24dp));
                }
            }
        }
        if (adapterView == android.ext.MainService.instance.L) {
            arrayList.add(str);
            arrayList2.add(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.change_address_type));
            arrayList3.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.drawable.ic_cursor_mover_white_24dp));
        }
        android.ext.f.o(android.ext.f.c(android.ext.Tools.k0()).setAdapter(new android.ext.ItemContextMenu$a(this, android.ext.MainService.context, arrayList2, arrayList3), new android.ext.ItemContextMenu$b(this, arrayList3, arrayList, cVar)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null));
        return true;
    }
}
