package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n1$e extends android.widget.Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.ext.n f1132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int[] f1133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.n1 f1134c;

    private n1$e(android.ext.n1 n1Var) {
        this.f1134c = n1Var;
        this.f1132a = null;
        this.f1133b = null;
    }

    /* synthetic */ n1$e(android.ext.n1 n1Var, android.ext.n1$a n1_a) {
        this(n1Var);
    }

    private java.lang.String a(java.lang.String str) {
        return str.toLowerCase(java.util.Locale.US).replace(android.ext.t1.f1251a, "");
    }

    @Override // android.widget.Filter
    protected android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence charSequence) {
        android.ext.n nVar;
        android.widget.Filter.FilterResults filter$FilterResults = new android.widget.Filter.FilterResults();
        int[] iArrD = null;
        filter$FilterResults.values = null;
        try {
            boolean z = (this.f1134c.j & 12) == 0;
            if (charSequence != null && charSequence.length() > 0 && this.f1134c.E()) {
                java.lang.String string = charSequence.toString();
                if (z) {
                    string = a(string);
                }
                java.lang.String strK1 = android.ext.Tools.k1(string);
                android.ext.e1.d("Filter: '" + strK1 + '\'');
                java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(strK1, 8);
                if ((this.f1134c.j & 48) == 0) {
                    nVar = null;
                } else {
                    nVar = this.f1132a;
                    if (nVar == null) {
                        nVar = new android.ext.n();
                        this.f1132a = nVar;
                    }
                }
                if ((this.f1134c.j & 64) != 0 && (iArrD = this.f1133b) == null) {
                    iArrD = android.ext.m.d();
                    this.f1133b = iArrD;
                }
                int iS = (short) this.f1134c.s();
                short[] sArr = new short[iS];
                int i = 0;
                for (short s = 0; s < iS; s = (short) (s + 1)) {
                    java.lang.String strZ = this.f1134c.z(nVar, iArrD, s);
                    if (z) {
                        strZ = a(strZ);
                    }
                    if (patternCompile.matcher(strZ).find()) {
                        sArr[i] = s;
                        i++;
                    }
                }
                filter$FilterResults.values = java.util.Arrays.copyOf(sArr, i);
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("Failed filter", th);
            android.ext.n0.h(java.lang.Thread.currentThread(), th, false);
        }
        return filter$FilterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(java.lang.CharSequence charSequence, android.widget.Filter.FilterResults filter$FilterResults) {
        android.ext.n1 n1Var = this.f1134c;
        n1Var.f1117c = (short[]) filter$FilterResults.values;
        n1Var.P();
    }
}
