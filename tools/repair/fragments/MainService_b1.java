    public void b1() {
        java.lang.StringBuilder sb;
        if (this.p0 == 0) {
            if (this.r0) {
                sb = new java.lang.StringBuilder();
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.search_hint));
                sb.append('\n');
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.speedhack_hint));
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.nothing_found));
                if (android.ext.Config.i != -1) {
                    sb.append('\n');
                    sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.try_more_ranges));
                }
                if (!this.q0) {
                    sb.append('\n');
                    sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R$string.try_fuzzy_search));
                }
            }
        } else {
            sb = null;
        }
        int i2 = this.s0.i();
        boolean zK = android.ext.b0.k();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(" (");
        long j = i2;
        sb2.append(android.ext.i0.c(j, 32));
        java.lang.String string = "";
        if (zK || this.p0 != j) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(zK ? "*" : "");
            sb3.append("/");
            sb3.append(android.ext.i0.c(this.p0, 32));
            string = sb3.toString();
        }
        sb2.append(string);
        sb2.append(")");
        java.lang.CharSequence string2 = sb2.toString();
        java.lang.String string3 = sb != null ? sb.toString() : null;
        if (android.ext.AddressArrayAdapter.f23d != 0) {
            string2 = android.ext.Tools.x(string2, " ", android.ext.n1.B(android.ext.AddressArrayAdapter.f23d));
        }
        android.ext.n2.i(new android.ext.MainService$v(this, string3, string2));
    }
