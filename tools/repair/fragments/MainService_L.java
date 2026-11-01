    public void L(java.lang.Long l, java.lang.String str, java.lang.CharSequence charSequence) {
        android.ext.y0.b(str, 1);
        int length = str.length();
        long j = 0;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int iIndexOf = str.indexOf(45, i2);
            int iIndexOf2 = str.indexOf(43, i2);
            if (iIndexOf2 != -1 && (iIndexOf == -1 || iIndexOf >= iIndexOf2)) {
                iIndexOf = iIndexOf2;
            }
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            java.lang.String strTrim = str.substring(i, iIndexOf).trim();
            int length2 = strTrim.length();
            boolean matched = false;
            if (length2 > 0) {
                java.util.Iterator<android.ext.RegionList$b> it = android.ext.RegionList.getList().iterator();
                while (it.hasNext()) {
                    android.ext.RegionList$b next = it.next();
                    java.lang.String str2 = next.f358d;
                    if (str2 != null && str2.length() >= length2 && str2.endsWith(strTrim) && (str2.length() == strTrim.length() || str2.charAt((str2.length() - strTrim.length()) - 1) == '/')) {
                        j += next.f356b;
                        matched = true;
                        break;
                    }
                }
            }
            if (!matched) {
                java.lang.String strParse = strTrim;
                if (strParse.endsWith("h")) {
                    strParse = strParse.substring(0, strParse.length() - 1);
                }
                try {
                    j += android.ext.t1.r(strParse, 16);
                } catch (java.lang.Throwable th) {
                    android.ext.e1.g("Failed parse", th);
                }
            }
            i = iIndexOf;
        }
        M0(l, j);
        this.O.a(j, charSequence);
        J(j);
    }
