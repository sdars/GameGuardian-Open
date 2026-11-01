package android.ext;

/* JADX INFO: loaded from: classes.dex */
class EditorListener$b implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemClickListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener, android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.app.AlertDialog f124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private java.util.List f128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f130g;
    private android.ext.l0 h;
    final /* synthetic */ android.ext.EditorListener i;

    private EditorListener$b(android.ext.EditorListener editorListener) {
        this.i = editorListener;
        this.f126c = false;
        this.f127d = 0;
        this.f128e = null;
        this.f129f = 0;
        this.f130g = 0;
    }

    /* synthetic */ EditorListener$b(android.ext.EditorListener editorListener, android.ext.EditorListener$a editorListener$a) {
        this(editorListener);
    }

    private boolean a(android.view.View view) {
        java.lang.StringBuilder sb;
        int i;
        java.lang.String str = null;
        long j = 1;
        switch (view.getId()) {
            case catch_.me_.if_.you_.can_.R.id.fill_hex /* 2131034255 */:
                sb = new java.lang.StringBuilder();
                sb.append('h');
                int size = this.f128e.size();
                char[] cArr = android.ext.x0.f1306a;
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    android.ext.c cVar = (android.ext.c) this.f128e.get(i2);
                    if (j2 != 0 && j2 + 1 != cVar.f672a) {
                    }
                    j2 = cVar.f672a;
                    sb.append(' ');
                    int i3 = (int) cVar.f673b;
                    sb.append(cArr[(i3 & 240) >> 4]);
                    sb.append(cArr[i3 & 15]);
                    break;
                }
                break;
            case catch_.me_.if_.you_.can_.R.id.fill_hex_utf16le /* 2131034256 */:
            case catch_.me_.if_.you_.can_.R.id.fill_hex_utf8 /* 2131034257 */:
            case catch_.me_.if_.you_.can_.R.id.fill_hex_utf8_utf16le /* 2131034258 */:
                sb = new java.lang.StringBuilder();
                sb.append('Q');
                sb.append(' ');
                int id = view.getId();
                int size2 = this.f128e.size();
                byte[] bArr = new byte[size2];
                long j3 = 0;
                int i4 = 0;
                while (true) {
                    if (i4 < size2) {
                        android.ext.c cVar2 = (android.ext.c) this.f128e.get(i4);
                        if (j3 == 0 || j3 + 1 == cVar2.f672a) {
                            j3 = cVar2.f672a;
                            bArr[i4] = (byte) cVar2.f673b;
                            i4++;
                        } else {
                            i = i4;
                        }
                    } else {
                        i = size2;
                    }
                }
            case catch_.me_.if_.you_.can_.R.id.fill_utf16le /* 2131034259 */:
            case catch_.me_.if_.you_.can_.R.id.fill_utf8 /* 2131034260 */:
                sb = new java.lang.StringBuilder();
                boolean z = view.getId() == 2131034260;
                sb.append(z ? ':' : ';');
                if (z || this.h.c().f674c == 1) {
                    int size3 = this.f128e.size();
                    byte[] bArr2 = new byte[size3];
                    long j4 = 0;
                    int i5 = 0;
                    while (i5 < size3) {
                        android.ext.c cVar3 = (android.ext.c) this.f128e.get(i5);
                        if (j4 == 0 || j4 + j == cVar3.f672a) {
                            j4 = cVar3.f672a;
                            bArr2[i5] = (byte) cVar3.f673b;
                            i5++;
                            j = 1;
                        } else {
                            size3 = i5;
                            str = new java.lang.String(bArr2, 0, size3, android.ext.t1.i(!z));
                        }
                    }
                    str = new java.lang.String(bArr2, 0, size3, android.ext.t1.i(!z));
                } else if (this.h.c().f674c == 2) {
                    int size4 = this.f128e.size();
                    char[] cArr2 = new char[size4];
                    long j5 = 0;
                    for (int i6 = 0; i6 < size4; i6++) {
                        android.ext.c cVar4 = (android.ext.c) this.f128e.get(i6);
                        if (j5 == 0 || j5 + 2 == cVar4.f672a) {
                            j5 = cVar4.f672a;
                            cArr2[i6] = (char) cVar4.f673b;
                        } else {
                            size4 = i6;
                            sb.append(new java.lang.String(cArr2, 0, size4));
                        }
                        break;
                    }
                    sb.append(new java.lang.String(cArr2, 0, size4));
                } else if (this.h.c().f674c == 4) {
                    int size5 = this.f128e.size();
                    char[] cArr3 = new char[size5 * 2];
                    long j6 = 0;
                    for (int i7 = 0; i7 < size5; i7++) {
                        android.ext.c cVar5 = (android.ext.c) this.f128e.get(i7);
                        if (j6 == 0 || j6 + 4 == cVar5.f672a) {
                            j6 = cVar5.f672a;
                            int i8 = i7 * 2;
                            long j7 = cVar5.f673b;
                            cArr3[i8] = (char) j7;
                            cArr3[i8 + 1] = (char) (j7 >> 16);
                        } else {
                            size5 = i7;
                            str = new java.lang.String(cArr3, 0, size5 * 2);
                        }
                    }
                    str = new java.lang.String(cArr3, 0, size5 * 2);
                }
                sb.append(str);
                break;
            case catch_.me_.if_.you_.can_.R.id.fill_values /* 2131034261 */:
                sb = new java.lang.StringBuilder();
                int size6 = this.f128e.size();
                for (int i9 = 0; i9 < size6; i9++) {
                    android.ext.c cVar6 = (android.ext.c) this.f128e.get(i9);
                    if (i9 != 0) {
                        sb.append(';');
                    }
                    sb.append(cVar6.J());
                }
                break;
            default:
                sb = null;
                break;
        }
        if (sb != null) {
            this.h.s(sb.toString());
        }
        return sb != null;
    }

    private void c(boolean z, boolean z2, java.lang.String str) {
        android.ext.c2 c2Var;
        java.lang.String string;
        if (z) {
            int iH = android.ext.MainService.instance.H();
            if (iH == 1 && android.ext.MainService.instance.p0 == 1) {
                this.f127d = 1;
            } else if (iH != 2 || android.ext.MainService.instance.t0.getCount() != 1) {
                return;
            } else {
                this.f127d = 2;
            }
        }
        int i = this.f127d;
        if ((i == 1 || i == 2) && (c2Var = android.ext.MainService.instance.f216f) != null) {
            android.ext.h2 h2VarG = this.h.g();
            if (this.f127d != 2 && !z2) {
                c2Var.write("revert = ");
                android.ext.b0.n(c2Var, true);
                int i2 = h2VarG.f674c;
                if ((i2 & 1073741824) == 1073741824) {
                    h2VarG.f674c = i2 & (-1073741825);
                    c2Var.write("local t = ");
                    android.ext.b0.n(c2Var, true);
                    c2Var.write("for i, v in ipairs(t) do\n");
                    c2Var.write("\tif v.flags == ");
                    android.ext.Script$Consts.a(c2Var, c2Var.f697c.f372b, h2VarG.f674c);
                    c2Var.write(" then\n");
                    c2Var.write("\t\tv.value = ");
                    c2Var.write("v.value + ");
                    android.ext.Script$Consts.c(c2Var, str);
                    c2Var.write("\n");
                    c2Var.write("\tend\n");
                    c2Var.write("end\n");
                    c2Var.write("gg.setValues(t)\n");
                    c2Var.write("t = nil\n\n");
                } else {
                    c2Var.write("gg.editAll(");
                    android.ext.Script$Consts.c(c2Var, str);
                    c2Var.write(", ");
                    android.ext.Script$Consts.a(c2Var, c2Var.f697c.f372b, h2VarG.f674c);
                    c2Var.write(")\n");
                }
                return;
            }
            c2Var.write("\nrevert = ");
            if (this.f127d == 1) {
                android.ext.b0.n(c2Var, true);
            } else {
                c2Var.write("gg.getListItems()\n");
            }
            c2Var.write("local t = ");
            if (this.f127d == 1) {
                android.ext.b0.n(c2Var, true);
            } else {
                c2Var.write("gg.getListItems()\n");
            }
            c2Var.write("for i, v in ipairs(t) do\n");
            c2Var.write("\tif v.flags == ");
            android.ext.Script$Consts.a(c2Var, c2Var.f697c.f372b, h2VarG.f674c);
            c2Var.write(" then\n");
            c2Var.write("\t\tv.value = ");
            int i3 = h2VarG.f674c;
            if ((i3 & 1073741824) == 1073741824) {
                h2VarG.f674c = i3 & (-1073741825);
                c2Var.write("v.value + ");
            }
            android.ext.Script$Consts.c(c2Var, str);
            c2Var.write("\n");
            if (this.f127d == 2 || h2VarG.m) {
                c2Var.write("\t\tv.freeze = ");
                c2Var.write(java.lang.Boolean.toString(h2VarG.m));
                c2Var.write("\n");
                if (this.f127d == 2 || h2VarG.n != 0) {
                    byte b2 = h2VarG.n;
                    if (b2 == 0) {
                        string = "gg.FREEZE_NORMAL";
                    } else if (b2 == 1) {
                        string = "gg.FREEZE_MAY_INCREASE";
                    } else if (b2 != 2) {
                        string = b2 != 3 ? java.lang.Integer.toString(b2) : "gg.FREEZE_IN_RANGE";
                    } else {
                        string = "gg.FREEZE_MAY_DECREASE";
                    }
                    c2Var.write("\t\tv.freezeType = ");
                    c2Var.write(string);
                    c2Var.write("\n");
                    if (h2VarG.n == 3) {
                        c2Var.write("\t\tv.freezeFrom = ");
                        android.ext.Script$Consts.c(c2Var, h2VarG.c0(true));
                        c2Var.write("\n");
                        c2Var.write("\t\tv.freezeTo = ");
                        android.ext.Script$Consts.c(c2Var, h2VarG.c0(false));
                        c2Var.write("\n");
                    }
                }
            }
            c2Var.write("\tend\n");
            c2Var.write("end\n");
            c2Var.write("gg.addListItems(t)\n");
            c2Var.write("t = nil\n\n");
        }
    }

    void b(android.ext.c cVar) {
        android.ext.c cVarC;
        int size;
        android.ext.h2 h2Var;
        int i = 0;
        this.f125b = false;
        this.f126c = false;
        if (cVar == null) {
            this.f125b = true;
            java.lang.Object objZ = android.ext.MainService.instance.z();
            if (android.ext.Tools.L0(objZ) == 0) {
                android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.nothing_selected);
                return;
            }
            if (this.f128e == null) {
                this.f128e = new java.util.ArrayList();
                if (objZ instanceof boolean[]) {
                    this.f127d = 3;
                    if (this.f129f == 0) {
                        this.f128e = null;
                        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
                        new android.ext.u2(android.ext.c.o(android.ext.MainService.instance.N.q((boolean[]) objZ, sparseIntArray)), sparseIntArray, "0", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_change_request), new android.ext.EditorListener$b$a(this));
                        return;
                    }
                    android.ext.n1 n1Var = android.ext.MainService.instance.N;
                    boolean[] zArr = (boolean[]) objZ;
                    int length = zArr.length - 1;
                    for (int i2 = 1; i2 < length; i2++) {
                        if (zArr[i2]) {
                            android.ext.c cVar2 = new android.ext.c(n1Var.e(i2), 0L, this.f129f);
                            if (cVar2.V()) {
                                cVar2.f673b = android.ext.MainService.instance.B(cVar2.f672a, cVar2.f674c);
                                this.f128e.add(cVar2);
                            }
                        }
                    }
                    this.f129f = 0;
                } else if (objZ instanceof gg_d.e) {
                    this.f127d = 2;
                    gg_d.e eVar = (gg_d.e) objZ;
                    int iL = eVar.l();
                    for (int i3 = 0; i3 < iL; i3++) {
                        if (eVar.a(i3)) {
                            this.f128e.add((android.ext.c) eVar.n(i3));
                        }
                    }
                } else {
                    if (!(objZ instanceof gg_d.a)) {
                        throw new java.lang.IllegalArgumentException("Obj is unknown: " + objZ);
                    }
                    this.f127d = 1;
                    gg_d.a aVar = (gg_d.a) objZ;
                    int i4 = aVar.i();
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (aVar.c(i5)) {
                            this.f128e.add(aVar.f(i5, null));
                        }
                    }
                }
            }
            java.util.List list = this.f128e;
            if (list == null) {
                cVarC = cVar;
                size = 0;
            } else {
                if (list.size() == 0) {
                    android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.nothing_selected);
                    android.ext.e1.d("It must never happen.");
                    return;
                }
                if (this.f130g == 0) {
                    android.util.SparseIntArray sparseIntArray2 = new android.util.SparseIntArray();
                    java.util.Iterator it = this.f128e.iterator();
                    while (it.hasNext()) {
                        int i6 = ((android.ext.c) it.next()).f674c;
                        i |= i6;
                        sparseIntArray2.put(i6, sparseIntArray2.get(i6) + 1);
                    }
                    new android.ext.u2(android.ext.c.o(i), sparseIntArray2, "0", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_change_request), new android.ext.EditorListener$b$b(this));
                    return;
                }
                int i7 = 0;
                while (i7 < this.f128e.size()) {
                    if (((android.ext.c) this.f128e.get(i7)).f674c != this.f130g) {
                        this.f128e.remove(i7);
                        i7--;
                    }
                    i7++;
                }
                this.f130g = 0;
                if (this.f128e.size() == 0) {
                    android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.no_items_for_editing);
                    android.ext.e1.d("It must never happen. " + this.f130g);
                    return;
                }
                cVarC = ((android.ext.c) this.f128e.get(0)).c();
                size = this.f128e.size();
                if (size == 1) {
                    this.f125b = false;
                }
            }
            if (cVarC == null) {
                throw new java.lang.NullPointerException("Something going wrong");
            }
        } else {
            cVarC = cVar;
            size = 0;
        }
        if (!this.f125b) {
            android.ext.h2 h2VarE = android.ext.MainService.instance.t0.e(cVarC.f672a);
            if (h2VarE == null || h2VarE.Q() != cVarC.Q()) {
                h2Var = new android.ext.h2(cVarC);
            } else {
                h2Var = h2VarE.c();
                h2Var.f673b = cVarC.f673b;
                this.f126c = true;
            }
            cVarC = h2Var;
        }
        if (this.f125b) {
            cVarC.f674c = cVarC.Q();
        }
        android.ext.l0 l0Var = new android.ext.l0(this.f125b ? 2 : this.f126c ? 0 : 1, cVarC);
        this.h = l0Var;
        if (this.f125b) {
            java.lang.String strJ = android.ext.i2.l;
            if (strJ == null || this.f127d != 1) {
                strJ = cVarC.J();
            }
            this.h.s(strJ);
            this.h.q(this);
        } else if (this.f126c) {
            l0Var.l();
        }
        java.lang.CharSequence charSequenceU = cVarC.u();
        this.h.r(android.ext.Tools.v(new android.text.SpannableString(this.f125b ? android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.edit_all_info), java.lang.Integer.valueOf(size), charSequenceU) : android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.edit_info), cVarC.F(), charSequenceU)), charSequenceU, cVarC.m()));
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(this.h.j()).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null).create();
        this.f124a = alertDialogCreate;
        if (!this.f125b) {
            alertDialogCreate.setButton(-3, android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.goto1), this);
        }
        android.ext.f.l(alertDialogCreate, this);
        android.ext.f.k(alertDialogCreate, this);
        android.ext.f.n(alertDialogCreate, this.h.f());
    }

    void d(android.ext.c cVar) {
        this.f128e = null;
        this.f129f = 0;
        this.f130g = 0;
        this.f127d = 0;
        b(cVar);
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == -1 || i == -2 || i != -3 || this.f125b) {
            return;
        }
        android.ext.c cVarC = this.h.c();
        android.ext.MainService mainService = android.ext.MainService.instance;
        java.lang.Long lValueOf = !this.i.f123f ? null : java.lang.Long.valueOf(cVarC.f672a);
        mainService.L(lValueOf, cVarC.F(), android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.from_item) + ": (" + cVarC + ')');
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00a0  */
    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
/* gg-shared-throwable */ java.lang.Throwable e = null;
/* gg-shared-throwable */ java.lang.Throwable th = null;
        int i;
        char[] charArray;
        byte[] bArrH;
        java.lang.String[] strArr;
        java.lang.String str;
        android.ext.SavedListAdapter savedListAdapter;
        byte[] bArr;
        int i2;
        long j;
        int i3;
        long j2;
        long j3;
        java.lang.String str2 = "Exception in EditorListener";
        android.ext.t1$b t1_bW = null;
        if (view == null || (view.getTag() instanceof android.ext.p1)) {
            d(null);
            return;
        }
        try {
            if (!this.f125b) {
                java.lang.String strH = android.ext.j2.h(this.h.e());
                android.ext.i2$c i2_cX = android.ext.i2.x(strH, false);
                int i4 = i2_cX != null ? i2_cX.f1018b : 0;
                if (i2_cX != null) {
                    strH = i2_cX.f1017a;
                }
                android.ext.h2 h2VarG = this.h.g();
                h2VarG.X(strH);
                h2VarG.b(i4);
                boolean zN = this.h.n();
                if (zN || this.f126c) {
                    android.ext.MainService.instance.t0.a(h2VarG);
                }
                android.ext.Tools.D(this.f124a);
                c(true, zN, strH);
                android.ext.MainService.instance.e0();
                return;
            }
            if (a(view)) {
                return;
            }
            try {
                try {
                    try {
                        java.lang.String strH2 = android.ext.j2.h(this.h.e());
                        android.ext.i2$c i2_cX2 = android.ext.i2.x(strH2, false);
                        if (i2_cX2 != null) {
                            try {
                                i = i2_cX2.f1018b;
                            } catch (java.lang.Throwable th_c) {
                                th = th_c;
                                android.ext.e1.l(str2, th_c);
                                return;
                            }
                        } else {
                            i = 0;
                        }
                        java.lang.String str3 = i2_cX2 != null ? i2_cX2.f1017a : strH2;
                        boolean zN2 = this.h.n();
                        java.lang.String strH3 = android.ext.j2.h(this.h.b());
                        int size = this.f128e.size();
                        boolean zO = this.h.o();
                        int i5 = this.h.c().f674c;
                        if (i5 == 1 && android.ext.t1.m(str3)) {
                            charArray = null;
                            strArr = null;
                            bArrH = android.ext.t1.h(str3);
                        } else if ((i5 & 6) != 0 && android.ext.t1.m(str3) && str3.charAt(0) == ';') {
                            bArrH = null;
                            strArr = null;
                            charArray = str3.substring(1).toCharArray();
                        } else if (str3.indexOf(59) != -1) {
                            java.lang.String[] strArrSplit = str3.split(";");
                            if (strArrSplit.length == 0) {
                                charArray = null;
                                bArrH = null;
                                strArr = null;
                            } else {
                                charArray = null;
                                bArrH = null;
                                strArr = strArrSplit;
                            }
                        } else {
                            charArray = null;
                            bArrH = null;
                            strArr = null;
                        }
                        android.ext.SavedListAdapter savedListAdapter2 = android.ext.MainService.instance.t0;
                        android.ext.t1$b[] t1_bArr = strArr == null ? null : new android.ext.t1$b[strArr.length];
                        android.ext.c$b c_bF = null;
                        long j4 = 0;
                        int i6 = 0;
                        int length = 0;
                        int i7 = 0;
                        while (i6 < size) {
                            android.ext.c cVar = (android.ext.c) this.f128e.get(i6);
                            str = str2;
                            java.lang.String str4 = strH2;
                            try {
                                android.ext.h2 h2VarE = android.ext.MainService.instance.t0.e(cVar.f672a);
                                boolean z = h2VarE != null && h2VarE.Q() == cVar.Q();
                                android.ext.h2 h2VarH = this.h.h(cVar);
                                if (zO) {
                                    if (bArrH != null) {
                                        long j5 = j4 + 1;
                                        long j6 = cVar.f672a;
                                        int i8 = j5 != j6 ? 0 : length;
                                        if (i8 < bArrH.length) {
                                            length = i8 + 1;
                                            j3 = ((long) bArrH[i8]) & 255;
                                        } else {
                                            length = i8;
                                            j3 = 0;
                                        }
                                        h2VarH.f673b = j3;
                                        savedListAdapter = savedListAdapter2;
                                        bArr = bArrH;
                                        i2 = size;
                                        j4 = j6;
                                    } else if (charArray != null) {
                                        android.ext.SavedListAdapter savedListAdapter3 = savedListAdapter2;
                                        boolean z2 = cVar.f674c == 2;
                                        byte[] bArr2 = bArrH;
                                        int i9 = size;
                                        long j7 = j4 + ((long) (z2 ? 2 : 4));
                                        long j8 = cVar.f672a;
                                        int i10 = j7 != j8 ? 0 : length;
                                        if (i10 < charArray.length) {
                                            j = ((long) charArray[i10]) & 65535;
                                            i10++;
                                        } else {
                                            j = 0;
                                        }
                                        h2VarH.f673b = j;
                                        if (!z2) {
                                            if (i10 < charArray.length) {
                                                i3 = i10 + 1;
                                                j2 = (((long) charArray[i10]) & 65535) << 16;
                                            } else {
                                                i3 = i10;
                                                j2 = 0;
                                            }
                                            h2VarH.f673b = j2 | j;
                                            i10 = i3;
                                        }
                                        length = i10;
                                        j4 = j8;
                                        savedListAdapter = savedListAdapter3;
                                        i2 = i9;
                                        bArr = bArr2;
                                    } else {
                                        android.ext.SavedListAdapter savedListAdapter4 = savedListAdapter2;
                                        byte[] bArr3 = bArrH;
                                        int i11 = size;
                                        if (strArr != null) {
                                            length = i6 % strArr.length;
                                            str3 = strArr[length];
                                            t1_bW = t1_bArr[length];
                                            if (t1_bW == null) {
                                                t1_bW = android.ext.c.W(null, str3, h2VarH.f674c, catch_.me_.if_.you_.can_.R.string.number_name, cVar.f672a);
                                                t1_bArr[length] = t1_bW;
                                            }
                                        } else if (t1_bW == null) {
                                            t1_bW = android.ext.c.W(null, str3, h2VarH.f674c, catch_.me_.if_.you_.can_.R.string.number_name, cVar.f672a);
                                        }
                                        int i12 = length;
                                        i7++;
                                        savedListAdapter = savedListAdapter4;
                                        bArr = bArr3;
                                        i2 = i11;
                                        c_bF = h2VarH.f(c_bF, t1_bW, str3, cVar.f672a, strH3, i7);
                                        length = i12;
                                    }
                                    h2VarH.b(i);
                                } else {
                                    i6 = i6;
                                    savedListAdapter = savedListAdapter2;
                                    charArray = charArray;
                                    bArr = bArrH;
                                    i2 = size;
                                    strArr = strArr;
                                }
                                if (zN2 || z) {
                                    savedListAdapter.b(h2VarH, (byte) 0, false);
                                }
                                i6++;
                                strH2 = str4;
                                savedListAdapter2 = savedListAdapter;
                                charArray = charArray;
                                bArrH = bArr;
                                size = i2;
                                strArr = strArr;
                                str2 = str;
                            } catch (java.lang.NumberFormatException e2) {
                                e = e2;
                                android.ext.j2.i(e2, this.h.f());
                                return;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                str2 = str;
                                android.ext.e1.l(str2, th);
                                return;
                            }
                        }
                        str = str2;
                        java.lang.String str5 = strH2;
                        char[] cArr = charArray;
                        byte[] bArr4 = bArrH;
                        savedListAdapter2.notifyDataSetChanged();
                        android.ext.MainService.instance.e0();
                        android.ext.Tools.D(this.f124a);
                        if (android.ext.i2.l != null && this.f127d == 1 && (bArr4 != null || cArr != null)) {
                            android.ext.i2.l = str5;
                        }
                        c(false, zN2, str5);
                    } catch (java.lang.NumberFormatException e3) {
                        e = e3;
                    }
                } catch (java.lang.NumberFormatException e4) {
                    e = e4;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.NumberFormatException e5) {
            android.ext.j2.i(e5, this.h.f());
        } catch (java.lang.Throwable th4) {
            android.ext.e1.l("Exception in EditorListener", th4);
        }
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        try {
            this.h.k();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(android.widget.AdapterView adapterView, android.view.View view, int i, long j) {
        java.lang.Object itemAtPosition = adapterView.getItemAtPosition(i);
        if (itemAtPosition instanceof android.ext.v0) {
            android.ext.v0 v0Var = (android.ext.v0) itemAtPosition;
            android.ext.MainService.instance.L(java.lang.Long.valueOf(v0Var.b()), v0Var.a(), android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.from_boundary));
            return;
        }
        android.ext.c cVar = itemAtPosition instanceof android.ext.c ? (android.ext.c) itemAtPosition : null;
        if (cVar == null) {
            return;
        }
        if (adapterView.getId() != 2131034317 || ((android.ext.Config.B & 1024) != 0 && java.lang.Integer.bitCount(cVar.f674c) == 1)) {
            d(cVar);
        } else {
            new android.ext.u2(android.ext.c.p(127, cVar.f672a), "0", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_change_request), new android.ext.EditorListener$b$c(this, cVar));
        }
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.t1(dialogInterface, -1, null, this, this.h.f());
    }
}
