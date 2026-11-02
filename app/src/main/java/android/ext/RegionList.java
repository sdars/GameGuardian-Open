package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class RegionList extends android.fix.ImageButtonView implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile java.util.List f342a = new java.util.ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile android.ext.RegionList$b f343b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile android.util.SparseIntArray f344c = new android.util.SparseIntArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int[] f345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static java.lang.CharSequence[] f346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static int[] f347f;

    public RegionList(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public static java.lang.CharSequence a(long j) {
        android.ext.RegionList$b regionList$bB = b(j);
        return regionList$bB == null ? "?" : regionList$bB.e();
    }

    public static android.ext.RegionList$b b(long j) {
        long jA = android.ext.e.a(j, android.ext.e0.m());
        android.ext.RegionList$b regionList$b = f343b;
        if (regionList$b != null && android.ext.Tools.T1(regionList$b.f356b, jA) && android.ext.Tools.S1(jA, regionList$b.f357c)) {
            return regionList$b;
        }
        java.util.List list = f342a;
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            android.ext.RegionList$b regionList$b2 = (android.ext.RegionList$b) list.get(i2);
            if (android.ext.Tools.T1(regionList$b2.f357c, jA)) {
                i = i2 + 1;
            } else {
                if (!android.ext.Tools.S1(jA, regionList$b2.f356b)) {
                    f343b = regionList$b2;
                    return regionList$b2;
                }
                size = i2 - 1;
            }
        }
        return null;
    }

    public static android.ext.RegionList$b c(java.lang.String str, java.lang.String str2, long j) {
        int i;
        java.lang.String strTrim = str.trim();
        java.lang.String strTrim2 = str2.trim();
        if (strTrim2.length() > 0 && j >= 0) {
            java.util.List list = f342a;
            android.ext.RegionList$b[] regionList$bArr = new android.ext.RegionList$b[6];
            int[] iArr = new int[6];
            java.io.File file = new java.io.File(strTrim2);
            java.lang.String str3 = '/' + file.getName();
            java.lang.String str4 = file.getParentFile() != null ? '/' + file.getParentFile().getName() + str3 : null;
            int iF = f(strTrim);
            java.util.Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                android.ext.RegionList$b regionList$b = (android.ext.RegionList$b) it.next();
                if (regionList$b != null) {
                    java.lang.String strA = regionList$b.a();
                    if (strA.length() != 0 && regionList$b.f357c - regionList$b.f356b > j) {
                        int iBitCount = (regionList$b.f355a ^ iF) & 3840;
                        if (iBitCount != 0) {
                            iBitCount = java.lang.Integer.bitCount(iBitCount);
                        }
                        if (strA.equals(strTrim2)) {
                            if (iBitCount == 0) {
                                regionList$bArr[0] = regionList$b;
                                break;
                            }
                            if (regionList$bArr[1] == null || iArr[1] > iBitCount) {
                                regionList$bArr[1] = regionList$b;
                                iArr[1] = iBitCount;
                            }
                        }
                        if (str4 != null && strA.endsWith(str4)) {
                            if (iBitCount == 0) {
                                regionList$bArr[2] = regionList$b;
                            } else if (regionList$bArr[3] == null || iArr[3] > iBitCount) {
                                regionList$bArr[3] = regionList$b;
                                iArr[3] = iBitCount;
                            }
                        }
                        if (strA.endsWith(str3)) {
                            if (iBitCount == 0) {
                                regionList$bArr[4] = regionList$b;
                            } else if (regionList$bArr[5] == null || iArr[5] > iBitCount) {
                                regionList$bArr[5] = regionList$b;
                                iArr[5] = iBitCount;
                            }
                        }
                    }
                }
            }
            for (i = 0; i < 6; i++) {
                android.ext.RegionList$b regionList$b2 = regionList$bArr[i];
                if (regionList$b2 != null) {
                    return regionList$b2;
                }
            }
        }
        return null;
    }

    public static long d(int i) {
        return ((long) f344c.get(i)) * 4096;
    }

    private static int e(int i) {
        int length = f345d.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if ((f345d[i3] & i) == i) {
                i2 = i3;
            }
        }
        return i2;
    }

    public static int f(java.lang.String str) {
        if (str.length() != 4) {
            return 0;
        }
        int i = str.charAt(0) == 'r' ? 256 : 0;
        if (str.charAt(1) == 'w') {
            i |= 512;
        }
        if (str.charAt(2) == 'x') {
            i |= 1024;
        }
        return str.charAt(3) == 's' ? i | 2048 : i;
    }

    private void g() {
        setOnClickListener(this);
        if (isInEditMode()) {
            return;
        }
        setImageResource(catch_.me_.if_.you_.can_.R.drawable.ic_arrow_down_drop_circle_white_24dp);
        android.ext.Config.m(this);
    }

    public static java.util.List<android.ext.RegionList$b> getList() {
        return f342a;
    }

    public static void h(android.ext.w wVar) {
        wVar.j();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        java.util.List list = f342a;
        if (list != null) {
            arrayList.ensureCapacity(list.size());
        }
        i();
        java.lang.String str = "";
        /* the original dex leaves the loop in three places: the end of the map,
           a name length outside of 0..1024 and an IOException of the reader. */
        boolean done = false;
        while (!done) {try {

            try {                if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

                    int iF = wVar.f();
                    if (iF != 0) {
                        int iE = e(iF);
                        long jH = wVar.h();
                        long jH2 = wVar.h();
                        int iF2 = iE | (wVar.f() << 8);
                        if ((iF & 2064) == 0) {
                            str = null;
                        }
                        int iF3 = wVar.f();
                        if (iF3 < 0 || iF3 > 1024) {
                            /* cond_9d of the original dex */
                            android.ext.e1.l("Bad name length: " + iF3, new java.lang.RuntimeException());
                            done = true;
                        } else {
                            android.ext.RegionList$b regionList$bB = b(jH);
                            java.lang.String strIntern = wVar.i(iF3, regionList$bB == null ? null : regionList$bB.f358d).trim().intern();
                            if (regionList$bB == null || regionList$bB.f355a != iF2 || regionList$bB.f356b != jH || regionList$bB.f357c != jH2) {
                                regionList$bB = new android.ext.RegionList$b(iF2, jH, jH2);
                            }
                            regionList$bB.f358d = strIntern;
                            regionList$bB.f359e = str;
                            arrayList.add(regionList$bB);
                            long j = (regionList$bB.f357c - regionList$bB.f356b) / 4096;
                            if (j < 0) {
                                j = 0;
                            }
                            sparseIntArray.put(iE, sparseIntArray.get(iE) + ((int) j));
                            str = strIntern;
                        }
                    } else {
                        /* the dex leaves the loop here: the flags of the
                           region are zero, the map of the process ends */
                        done = true;
                    }
            } catch (java.io.IOException e2) {
                android.ext.e1.l("???", e2);
                done = true;
            };
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        }
        f342a = arrayList;
        f344c = sparseIntArray;
        f343b = null;
        android.ext.MainService.instance.N.d();
    }

    private static void i() {
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_ranges).a();
    }

    public static void k(int[] iArr, java.lang.CharSequence[] charSequenceArr, int[] iArr2) {
        f345d = iArr;
        f346e = charSequenceArr;
        f347f = iArr2;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0084  */
    /* JADX WARN: Code duplicated, block: B:33:0x009a  */
    /* JADX WARN: Code duplicated, block: B:61:0x009b A[SYNTHETIC] */
    public void j(android.view.View view, int i) {
        long jR;
        java.lang.Object tag = getTag();
        if (tag instanceof android.ext.EditText) {
            android.ext.EditText editText = (android.ext.EditText) tag;
            editText.requestFocus();
            boolean z = (view == null ? this : view).getId() == 2131034378;
            java.lang.String strTrim = editText.getText().toString().trim();
            if (strTrim.length() > 0) {
                try {
                    jR = android.ext.t1.r(strTrim, 16);
                } catch (java.lang.NumberFormatException e2) {
                    android.ext.e1.s("RegionList failed parse: " + strTrim, e2);
                    jR = 0;
                }
            } else {
                jR = 0;
            }
            java.util.List list = f342a;
            java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
            android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
            int i2 = -1;
            for (int i3 = 0; i3 < list.size(); i3++) {
                android.ext.RegionList$b regionList$b = (android.ext.RegionList$b) list.get(i3);
                if (i != 0) {
                    int i4 = regionList$b.f355a & 255;
                    int[] iArr = f345d;
                    if (i4 >= iArr.length || (iArr[i4] & i) != 0) {
                        sparseIntArray.append(arrayList.size(), i3);
                        arrayList.add(regionList$b.g());
                        if (android.ext.Tools.T1(regionList$b.f356b, jR)) {
                            i2 = i3;
                        }
                    }
                } else {
                    sparseIntArray.append(arrayList.size(), i3);
                    arrayList.add(regionList$b.g());
                    if (android.ext.Tools.T1(regionList$b.f356b, jR)) {
                        i2 = i3;
                    }
                }
            }
            if (arrayList.size() != 0) {
                android.app.AlertDialog alertDialogCreate = android.ext.f.b().setSingleChoiceItems((java.lang.CharSequence[]) arrayList.toArray(new java.lang.CharSequence[arrayList.size()]), i2, new android.ext.RegionList$a(this, editText, z, list, sparseIntArray)).create();
                android.widget.ListView listView = alertDialogCreate.getListView();
                if (listView != null) {
                    android.ext.Tools.C1(listView, catch_.me_.if_.you_.can_.R.style.SmallText);
                    android.ext.FastScrollerFix.a(listView, true);
                }
                android.ext.f.m(alertDialogCreate);
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no_regions));
            if (i != 0) {
                int[] iArr2 = f345d;
                java.lang.CharSequence[] charSequenceArr = f346e;
                int length = iArr2.length;
                boolean z2 = false;
                for (int i5 = 0; i5 < length; i5++) {
                    if ((i & iArr2[i5]) != 0) {
                        sb.append(z2 ? ", " : "\n[");
                        sb.append(charSequenceArr[i5]);
                        z2 = true;
                    }
                }
                if (z2) {
                    sb.append(']');
                }
            }
            android.ext.Tools.J1(sb.toString());
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        j(view, this instanceof android.ext.RegionListFiltered ? android.ext.Config.i : 0);
    }
}
