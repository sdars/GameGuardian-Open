package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$l implements java.lang.Runnable {
    f1$l() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if ((android.ext.Config.f30c & 8) != 0) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String[] strArrE = android.ext.n0.e();
        for (int i = 2; i < strArrE.length; i += 2) {
            java.lang.String str = strArrE[i];
            int i2 = i + 1;
            if (android.ext.Tools.e1(strArrE[i2])) {
                sb.append('\n');
                sb.append(str);
                sb.append(" (");
                sb.append(strArrE[i2]);
                sb.append(')');
            }
        }
        if (sb.length() == 0) {
            return;
        }
        sb.append('\n');
        android.ext.n2.i(android.ext.f1.J(android.ext.r.p, android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.killers_found), sb.toString()), 8L, false));
    }
}
