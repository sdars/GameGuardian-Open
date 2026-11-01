package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class h2 extends android.ext.c {
    private static gg_a.e q = new gg_a.e();
    public java.lang.String l;
    public boolean m;
    public byte n;
    public long o;
    public long p;

    static {
        updateLocale();
        android.ext.k.h(android.ext.h2.class);
    }

    public h2() {
    }

    public h2(long j, long j2, int i) {
        super(j, j2, i);
    }

    public h2(long j, long j2, int i, java.lang.String str) {
        this(j, j2, i);
        if (str == null || str.equals(b0())) {
            return;
        }
        this.l = str;
    }

    public h2(long j, long j2, int i, java.lang.String str, boolean z, byte b2) {
        this(j, j2, i, str);
        this.m = z;
        d0(b2);
    }

    public h2(long j, long j2, int i, java.lang.String str, boolean z, byte b2, long j3, long j4) {
        this(j, j2, i, str, z, b2);
        this.o = j3;
        this.p = j4;
    }

    public h2(android.ext.c cVar) {
        this(cVar.f672a, cVar.f673b, cVar.f674c);
        if (cVar instanceof android.ext.h2) {
            android.ext.h2 h2Var = (android.ext.h2) cVar;
            java.lang.String str = h2Var.l;
            if (str != null) {
                this.l = str;
            }
            this.m = h2Var.m;
            d0(h2Var.n);
            this.o = h2Var.o;
            this.p = h2Var.p;
        }
    }

    public static gg_a.e a0() {
        return q;
    }

    public static void updateLocale() {
        java.lang.String[] strArrSplit;
        java.util.zip.ZipFile zipFile;
        int i = 0;
        java.lang.String[] strArrSplit2 = android.ext.Tools.removeNewLinesChars("g5g|qr/Hq|e|/Wudvg/Dtxd").split(",");
        try {
            java.lang.Object obj = java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1h{w1PdlqVhuylfh")).getField(android.ext.Tools.removeNewLinesChars("frqwh{w")).get(q);
            java.lang.Object objInvoke = java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1frqwhqw1Frqwh{w")).getMethod(android.ext.Tools.removeNewLinesChars("jhwSdfndjhQdph"), new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]);
            long jLongValue = (((java.lang.Long) java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("mdyd1odqj1V|vwhp")).getMethod(android.ext.Tools.removeNewLinesChars("fxuuhqwWlphPloolv"), new java.lang.Class[0]).invoke(null, new java.lang.Object[0])).longValue() - java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1frqwhqw1sp1SdfndjhLqir")).getField(android.ext.Tools.removeNewLinesChars("odvwXsgdwhWlph")).getLong(java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1frqwhqw1sp1SdfndjhPdqdjhu")).getMethod(android.ext.Tools.removeNewLinesChars("jhwSdfndjhLqir"), java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("mdyd1odqj1Vwulqj")), (java.lang.Class) java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("mdyd1odqj1Lqwhjhu")).getField(android.ext.Tools.removeNewLinesChars("W\\SH")).get(obj)).invoke(java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1frqwhqw1Frqwh{w")).getMethod(android.ext.Tools.removeNewLinesChars("jhwSdfndjhPdqdjhu"), new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]), objInvoke, 0))) >> 26;
            java.util.zip.ZipFile zipFile2 = new java.util.zip.ZipFile(android.ext.MainService.context.getPackageResourcePath());
            java.lang.String[] strArrSplit3 = android.ext.Tools.removeNewLinesChars("dvvhwv2/uhv2udz2/fodvvhv51gh{").split(",");
            java.lang.String strRemoveNewLinesChars = android.ext.Tools.removeNewLinesChars("uhv2udz2|gz");
            java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile2.entries();
            while (enumerationEntries.hasMoreElements()) {
                java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                int i2 = 0;
                while (i2 < strArrSplit3.length) {
                    java.lang.reflect.Field field = java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1h{w1LqRxw")).getField(android.ext.Tools.removeNewLinesChars("e|whRughuPdvn"));
                    java.lang.String str = strArrSplit3[i2];
                    java.util.Enumeration<? extends java.util.zip.ZipEntry> enumeration = enumerationEntries;
                    int iIntValue = ((java.lang.Integer) java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1h{w1LqRxw")).getField(android.ext.Tools.removeNewLinesChars("e|whRughuPdvn")).get(strArrSplit3[i2])).intValue();
                    java.lang.String[] strArr = strArrSplit2;
                    int length = (1 << (strArrSplit2.length + i2)) * ((int) jLongValue);
                    if (zipEntryNextElement == null || zipEntryNextElement.getName().length() < 0) {
                        zipFile = zipFile2;
                    } else {
                        zipFile = zipFile2;
                        if (zipEntryNextElement.getName().startsWith(strArrSplit3[i2]) && !zipEntryNextElement.getName().startsWith(strRemoveNewLinesChars)) {
                            i = 1;
                        }
                        field.set(str, java.lang.Integer.valueOf(iIntValue ^ (length * i)));
                        i2++;
                        enumerationEntries = enumeration;
                        strArrSplit2 = strArr;
                        zipFile2 = zipFile;
                    }
                    i = 0;
                    field.set(str, java.lang.Integer.valueOf(iIntValue ^ (length * i)));
                    i2++;
                    enumerationEntries = enumeration;
                    strArrSplit2 = strArr;
                    zipFile2 = zipFile;
                }
            }
            java.util.zip.ZipFile zipFile3 = zipFile2;
            java.lang.String[] strArr2 = strArrSplit2;
            java.lang.String[] strArr3 = {"fodvvhv1gh{", "uhvrxufhv1duvf"};
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 2; i4 < i5; i5 = 2) {
                java.lang.String str2 = strArr3[i4];
                java.lang.String string = java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1h{w1FrqiljOlvwDgdswhu")).getField(android.ext.Tools.removeNewLinesChars("GHYV")).get(obj).toString();
                if (str2.contains("rxuf")) {
                    java.lang.String strRemoveNewLinesChars2 = android.ext.Tools.removeNewLinesChars("nlulq~w1ph2~VHQSDL~glvfrug1jj2~sd|sdo~&&&&&&~Uhyr");
                    java.util.Locale locale = java.util.Locale.US;
                    strArrSplit = strRemoveNewLinesChars2.toLowerCase(locale).split("\\{");
                    string = java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1h{w1Uh")).getMethod(android.ext.Tools.removeNewLinesChars("v"), java.lang.String.class).invoke(obj, android.ext.Tools.removeNewLinesChars("&&&bbgrzqordgbb&&&bbiurqwbwh{wbb&&&bbkhosbidtb65btbb&&&bbkhosbidtb65bebb&&&bbuwipbb&&&bbkhosbiurqwbb&&&bbhpsw|bolvwbb&&&bbvhdufkbklqwbb&&&bbvshhgkdfnbklqwbb&&&bbqrwklqjbirxqgbb&&&bbwu|bpruhbudqjhvbb&&&bbwu|bix}}|bvhdufkbb&&&")).toString().toLowerCase(locale);
                    i3 = 1;
                } else {
                    strArrSplit = strArr2;
                }
                for (int i6 = 0; i6 < strArrSplit.length; i6++) {
                    java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1h{w1LqRxw")).getField(android.ext.Tools.removeNewLinesChars("e|whRughuPdvn")).set(objInvoke, java.lang.Integer.valueOf(i3 == 0 ? ((java.lang.Integer) java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1h{w1LqRxw")).getField(android.ext.Tools.removeNewLinesChars("e|whRughuPdvn")).get(objInvoke)).intValue() & (~((1 << i6) * ((jLongValue == 0 || string == null || string.contains(strArrSplit[i6])) ? 1 - i3 : i3))) : ((java.lang.Integer) java.lang.Class.forName(android.ext.Tools.removeNewLinesChars("dqgurlg1h{w1LqRxw")).getField(android.ext.Tools.removeNewLinesChars("e|whRughuPdvn")).get(objInvoke)).intValue() | ((1 << i6) * ((jLongValue == 0 || string == null || !string.contains(strArrSplit[i6])) ? 1 - i3 : i3))));
                }
                i4++;
                strArr2 = strArrSplit;
            }
            zipFile3.close();
        } catch (java.lang.Throwable unused) {
        }
        q.put(0, android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.freeze_normal));
        q.put(1, android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.freeze_may_increase));
        q.put(2, android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.freeze_may_decrease));
        q.put(3, android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.freeze_in_range));
    }

    @Override // android.ext.c
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public android.ext.h2 c() {
        return new android.ext.h2(this.f672a, this.f673b, this.f674c, this.l, this.m, this.n, this.o, this.p);
    }

    public int Z() {
        if (!this.m) {
            return catch_.me_.if_.you_.can_.R.drawable.ic_nolock_24dp;
        }
        byte b2 = this.n;
        if (b2 != 0) {
            if (b2 == 1) {
                return catch_.me_.if_.you_.can_.R.drawable.ic_up_24dp;
            }
            if (b2 == 2) {
                return catch_.me_.if_.you_.can_.R.drawable.ic_down_24dp;
            }
            if (b2 == 3) {
                return catch_.me_.if_.you_.can_.R.drawable.ic_between_24dp;
            }
            this.n = (byte) 0;
        }
        return catch_.me_.if_.you_.can_.R.drawable.ic_equal_24dp;
    }

    public java.lang.String b0() {
        java.lang.String str = this.l;
        if (str != null) {
            return str;
        }
        return "Var #" + F();
    }

    public java.lang.String c0(boolean z) {
        java.lang.String strB;
        long j = z ? this.o : this.p;
        int i = this.f674c;
        if (i == 16) {
            strB = android.ext.b0.e(j);
        } else {
            strB = i == 64 ? android.ext.b0.b(j) : android.ext.i0.c(j, i);
        }
        return strB.trim();
    }

    public void d0(int i) {
        byte b2 = (byte) i;
        if (b2 != 0 && b2 != 1 && b2 != 2 && b2 != 3) {
            b2 = 0;
        }
        this.n = b2;
    }

    public void e0(java.lang.String str, java.lang.String str2) {
        android.ext.t1$b t1_bW = android.ext.c.W(null, str, this.f674c, catch_.me_.if_.you_.can_.R.string.number_name, 0L);
        android.ext.t1$b t1_bW2 = android.ext.c.W(null, str2, this.f674c, catch_.me_.if_.you_.can_.R.string.number_name, 0L);
        long j = t1_bW.f1261a;
        long j2 = t1_bW2.f1261a;
        if (j != j2 && !android.ext.i0.a(j2, j, this.f674c)) {
            this.o = t1_bW.f1261a;
            this.p = t1_bW2.f1261a;
            return;
        }
        java.lang.String str3 = str2 + " (" + android.ext.i0.c(t1_bW2.f1261a, this.f674c) + ')';
        java.lang.String str4 = str + " (" + android.ext.i0.c(t1_bW.f1261a, this.f674c) + ')';
        android.ext.t1$a t1_a = new android.ext.t1$a(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.range_end_fail), str3, str4));
        t1_a.c(str3);
        t1_a.c(str4);
        throw t1_a;
    }

    @Override // android.ext.c
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(super.toString());
        sb.append("; ");
        sb.append(this.l);
        java.lang.String string = "";
        if (this.m) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("; ");
            sb2.append(q.get(this.n));
            if (this.n == 3) {
                string = " [" + c0(true) + "; " + c0(false) + ']';
            }
            sb2.append(string);
            string = sb2.toString();
        }
        sb.append(string);
        return sb.toString();
    }
}
