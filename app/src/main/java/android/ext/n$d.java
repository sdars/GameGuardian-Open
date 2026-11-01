package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n$d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final java.lang.String f1088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f1089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1091d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1092e = -1;

    n$d(java.lang.String str) {
        java.lang.String upperCase = str.toUpperCase(java.util.Locale.US);
        this.f1088a = upperCase;
        this.f1089b = upperCase.length();
        k();
    }

    boolean a(char c2) {
        if (c() != c2) {
            return false;
        }
        this.f1090c++;
        return true;
    }

    boolean b(java.lang.String str) {
        java.lang.String str2 = this.f1088a;
        int i = this.f1090c;
        int i2 = this.f1089b - i;
        if (i2 < 0) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length > i2) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (str2.charAt(i + i3) != str.charAt(i3)) {
                return false;
            }
        }
        this.f1090c = i + length;
        return true;
    }

    char c() {
        java.lang.String str = this.f1088a;
        int i = this.f1090c;
        int i2 = this.f1089b;
        char cG = android.ext.n.g(str, i2, i);
        if (cG == 0) {
            cG = ' ';
        }
        if (i >= i2 || cG > ' ') {
            return cG;
        }
        while (i < i2) {
            int i3 = i + 1;
            if (android.ext.n.g(str, i2, i3) > ' ') {
                break;
            }
            i = i3;
        }
        this.f1090c = i;
        return ' ';
    }

    char d() {
        char c2 = c();
        this.f1090c++;
        return c2;
    }

    float e() {
        java.lang.String str = this.f1088a;
        int i = this.f1090c;
        int length = str.length();
        if (i >= length) {
            throw android.ext.n.h;
        }
        int iIndexOf = str.indexOf(59, i);
        if (iIndexOf == -1) {
            iIndexOf = length;
        }
        try {
            float f2 = java.lang.Float.parseFloat(str.substring(i, iIndexOf));
            this.f1090c = length;
            return f2;
        } catch (java.lang.NumberFormatException unused) {
            throw android.ext.n.h;
        }
    }

    long f() {
        char cD = d();
        if ((cD < '0' || cD > '9') && (cD < 'A' || cD > 'F')) {
            throw android.ext.n.h;
        }
        long j = 0;
        while (true) {
            j = (j << 4) + ((long) ((cD < '0' || cD > '9') ? cD - '7' : cD - '0'));
            cD = d();
            if (cD < '0' || cD > '9') {
                if (cD < 'A' || cD > 'F') {
                    break;
                }
            }
        }
        this.f1090c--;
        return j;
    }

    long g() {
        return (a('-') ? -1L : 1L) * (b("0X") ? f() : h());
    }

    int h() {
        boolean z;
        char cD = d();
        int i = 0;
        if (cD == '-') {
            cD = d();
            z = true;
        } else {
            z = false;
        }
        if (cD < '0' || cD > '9') {
            throw android.ext.n.h;
        }
        do {
            i = (i * 10) + (cD - '0');
            cD = d();
            if (cD < '0') {
                break;
            }
        } while (cD <= '9');
        this.f1090c--;
        return z ? -i : i;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    int i(java.lang.String str) {
        int i;
        int i2;
        java.lang.String str2 = this.f1088a;
        int i3 = this.f1090c;
        int i4 = this.f1089b - i3;
        int i5 = -1;
        if (i4 >= 0) {
            int length = str.length();
            int i6 = 0;
            int i7 = -1;
            int i8 = -1;
            int i9 = 0;
            while (i6 <= length) {
                int iIndexOf = str.indexOf(0, i6);
                if (iIndexOf == i5) {
                    iIndexOf = length;
                }
                if (i6 != iIndexOf) {
                    java.lang.String strSubstring = str.substring(i6, iIndexOf);
                    int length2 = strSubstring.length();
                    if (length2 != 0) {
                        if (length2 <= i4) {
                            int i10 = 0;
                            while (true) {
                                if (i10 < length2) {
                                    if (str2.charAt(i3 + i10) == strSubstring.charAt(i10)) {
                                        i10++;
                                    }
                                } else if (i8 < length2) {
                                    i7 = i9;
                                    i6 = iIndexOf;
                                    i8 = length2;
                                }
                            }
                        }
                        i6 = iIndexOf;
                    } else if (i8 < length2) {
                        i7 = i9;
                        i6 = iIndexOf;
                        i8 = length2;
                    } else {
                        i6 = iIndexOf;
                    }
                }
                i6++;
                i9++;
                i5 = -1;
            }
            i2 = i7;
            i = i8;
        } else {
            i = -1;
            i2 = -1;
        }
        if (i > 0) {
            this.f1090c = i3 + i;
        }
        return i2;
    }

    int j(java.lang.String[] strArr) {
        java.lang.String str = this.f1088a;
        int i = this.f1090c;
        int i2 = this.f1089b - i;
        int i3 = -1;
        if (i2 >= 0) {
            for (int length = strArr.length - 1; length >= 0; length--) {
                java.lang.String str2 = strArr[length];
                int length2 = str2.length();
                if (length2 == 0) {
                    i3 = length;
                } else if (length2 > i2) {
                    continue;
                } else {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            this.f1090c = i + length2;
                            return length;
                        }
                        if (str.charAt(i + i4) != str2.charAt(i4)) {
                            break;
                        }
                        i4++;
                    }
                }
            }
        }
        return i3;
    }

    void k() {
        java.lang.String str = this.f1088a;
        int i = this.f1089b;
        int i2 = 0;
        while (i2 < i && android.ext.n.g(str, i, i2) <= ' ') {
            i2++;
        }
        this.f1090c = i2;
    }
}
