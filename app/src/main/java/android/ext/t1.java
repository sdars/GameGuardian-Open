package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f1251a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static char f1252b = '.';

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1253c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static java.nio.charset.Charset f1254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static java.nio.charset.Charset f1255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int[] f1256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static java.util.regex.Pattern f1257g;

    static {
        updateLocale();
        android.ext.k.h(android.ext.t1.class);
        f1254d = null;
        f1255e = null;
        f1256f = null;
        f1257g = null;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005b  */
    private static void A(android.ext.t1$b t1_b) {
        int[] iArr = f1256f;
        if (iArr == null) {
            iArr = new int[]{1, android.ext.c.E(1), 2, android.ext.c.E(2), 4, android.ext.c.E(4), 8, android.ext.c.E(8)};
            f1256f = iArr;
        }
        int length = iArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 2) {
            int i3 = iArr[i2 + 1];
            if (t1_b.f1262b) {
                int i4 = (i3 * 8) - 1;
                if ((t1_b.f1261a >> i4) == ((-1) >> i4)) {
                    i |= iArr[i2];
                }
            } else if (i3 == 8 || (t1_b.f1261a >> (i3 * 8)) == 0) {
                i |= iArr[i2];
            }
        }
        t1_b.f1263c = i | 32;
    }

    public static long B(java.lang.String str) {
        long jCharAt = 0;
        if (str.length() < 2) {
            return 0L;
        }
        if (str.charAt(0) == ';') {
            int length = str.length();
            if (length > 5) {
                length = 5;
            }
            for (int i = 1; i < length; i++) {
                jCharAt |= (((long) str.charAt(i)) & 65535) << ((i - 1) * 16);
            }
        } else {
            byte[] bArrH = h(str);
            int length2 = bArrH.length;
            if (length2 > 8) {
                length2 = 8;
            }
            for (int i2 = 0; i2 < length2; i2++) {
                jCharAt |= (((long) bArrH[i2]) & 255) << (i2 * 8);
            }
        }
        return jCharAt;
    }

    public static int C(java.lang.String str) {
        if (str.length() > 2 && str.charAt(0) == '~') {
            char cCharAt = str.charAt(1);
            if (cCharAt == 'A') {
                return 4;
            }
            if (cCharAt != 'T') {
                if (cCharAt == 'a') {
                    return 4;
                }
                if (cCharAt != 't') {
                }
            }
            return 2;
        }
        return 0;
    }

    private static byte[] a(byte[] bArr, java.lang.String str) {
        java.lang.String strReplace = str.replace(" ", "").replace("\t", "").replace("\r", "").replace("\n", "");
        if (strReplace.length() < 2) {
            return bArr;
        }
        int length = strReplace.length() & (-2);
        int length2 = bArr.length;
        byte[] bArrCopyOf = java.util.Arrays.copyOf(bArr, (length / 2) + length2);
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            bArrCopyOf[(i / 2) + length2] = (byte) java.lang.Integer.parseInt(strReplace.substring(i, i2), 16);
            i = i2;
        }
        return bArrCopyOf;
    }

    private static java.lang.String b(java.lang.String str, boolean z) {
        if (str == null) {
            throw new java.lang.NumberFormatException(z(catch_.me_.if_.you_.can_.R.string.input_number));
        }
        if (m(str) || C(str) != 0) {
            return str;
        }
        java.lang.String lowerCase = str.trim().toLowerCase(java.util.Locale.US);
        if (z) {
            lowerCase = e(lowerCase);
        }
        if (lowerCase.length() == 0) {
            throw new java.lang.NumberFormatException(z(catch_.me_.if_.you_.can_.R.string.input_number));
        }
        if ((android.ext.Config.B & 4096) == 0) {
            return lowerCase;
        }
        java.util.regex.Pattern patternCompile = f1257g;
        if (patternCompile == null) {
            try {
                patternCompile = java.util.regex.Pattern.compile("[^\\p{XDigit}" + f1252b + f1251a + ".hrwxqHRWXQ~?*^$:;-]+");
                f1257g = patternCompile;
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
        if (patternCompile == null) {
            return lowerCase;
        }
        try {
            java.lang.String strReplaceAll = patternCompile.matcher(lowerCase).replaceAll("");
            if (strReplaceAll.equals(lowerCase)) {
                return lowerCase;
            }
            android.ext.e1.d("strip: '" + patternCompile.pattern() + "': '" + lowerCase + "' -> '" + strReplaceAll + '\'');
            return strReplaceAll;
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
            return lowerCase;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    private static android.ext.t1$b c(android.ext.t1$b t1_b, int i, int i2) {
        long jFloatToRawIntBits = 0L;
        int i3 = i2 & 127;
        if (i3 == 1 || i3 == 2 || i3 == 4 || i3 == 8) {
            t1_b.f1261a = i;
            t1_b.f1263c = i3;
        } else {
            int i4 = 16;
            if (i3 == 16) {
                jFloatToRawIntBits = java.lang.Float.floatToRawIntBits(i);
                if (jFloatToRawIntBits < 0) {
                    jFloatToRawIntBits = (jFloatToRawIntBits & 2147483647L) + 2147483648L;
                }
            } else if (i3 != 32) {
                i4 = 64;
                if (i3 != 64) {
                    if (i3 != 127) {
                        android.ext.e1.p("Unknown flags: " + i3 + " we use Auto parsing");
                    }
                    t1_b.f1261a = i;
                    t1_b.f1263c = 127;
                } else {
                    jFloatToRawIntBits = java.lang.Double.doubleToRawLongBits(i);
                }
            } else {
                t1_b.f1261a = i;
                t1_b.f1263c = i3;
            }
            t1_b.f1261a = jFloatToRawIntBits;
            t1_b.f1263c = i4;
        }
        t1_b.f1262b = i < 0;
        return t1_b;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004d  */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r3 != 'q') goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.lang.String d(java.lang.String str) {
        java.lang.String str2;
        if (str.length() <= 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        char cCharAt = str.charAt(0);
        sb.append(cCharAt);
        if (cCharAt == ':') {
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.text));
            str2 = " UTF-8";
        } else {
            if (cCharAt != ';') {
                if (cCharAt == 'H') {
                    str2 = " DF 59 37 5F 00";
                } else {
                    if (cCharAt != 'Q') {
                        if (cCharAt == 'h') {
                            str2 = " DF 59 37 5F 00";
                        }
                    }
                    sb.append(" DF 59 '");
                    sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.text));
                    sb.append(" UTF-8' 37 5F \"");
                    sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.text));
                    str2 = " UTF-16LE\" 48 00";
                }
                return sb.toString();
            }
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.text));
            str2 = " UTF-16LE";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static java.lang.String e(java.lang.String str) {
        java.lang.String strReplace = str.replace(" ", "").replace(" ", "").replace(f1251a, "");
        return f1253c ? strReplace.replace(f1252b, '.') : strReplace;
    }

    public static java.lang.String f(java.lang.String str) {
        java.lang.String strReplace = str.replace(" ", "").replace(" ", "").replace(",", "");
        return f1253c ? strReplace.replace('.', f1252b) : strReplace;
    }

    public static byte[] g(long j) {
        byte[] bArr = new byte[9];
        int i = -1;
        for (int i2 = 0; i2 < 8; i2++) {
            byte b2 = (byte) (255 & j);
            bArr[i2] = b2;
            if (b2 != 0 && i < i2) {
                i = i2;
            }
            j >>= 8;
        }
        bArr[8] = (byte) i;
        return bArr;
    }

    public static byte[] h(java.lang.CharSequence charSequence) {
        boolean z = false;
        java.lang.String strSubstring;
        if (charSequence.length() < 1) {
            return gg_d.b.f1513c;
        }
        char cCharAt = charSequence.charAt(0);
        byte[] bArrCopyOf = gg_d.b.f1513c;
        boolean z2 = !(charSequence instanceof java.lang.String) && (charSequence instanceof android.text.Editable);
        if (cCharAt != ';') {
            if (cCharAt != 'H') {
                if (cCharAt != 'Q') {
                    if (cCharAt != 'h') {
                        z = cCharAt == 'q';
                    }
                }
                int i = 1;
                char c2 = 0;
                int i2 = 1;
                while (i < charSequence.length()) {
                    char cCharAt2 = charSequence.charAt(i);
                    if (c2 != 0 ? cCharAt2 != c2 : !(cCharAt2 == '\'' || cCharAt2 == '\"')) {
                        strSubstring = i == charSequence.length() - 1 ? charSequence.toString().substring(i2) : null;
                        cCharAt2 = c2;
                    } else {
                        strSubstring = i2 != i ? charSequence.toString().substring(i2, i) : null;
                        if (c2 != 0) {
                            cCharAt2 = 0;
                        }
                        i2 = i + 1;
                    }
                    if (strSubstring != null && strSubstring.length() > 0) {
                        if (c2 != 0) {
                            byte[] bytes = strSubstring.getBytes(i(c2 == '\"'));
                            if (z2) {
                                java.lang.String strTrim = android.ext.InOut.b(bytes, 0, bytes.length).trim();
                                ((android.text.Editable) charSequence).replace((i - strSubstring.length()) - 1, i + 1, strTrim);
                                int length = strTrim.length() - (strSubstring.length() + 2);
                                i += length;
                                i2 += length;
                            } else {
                                int length2 = bArrCopyOf.length;
                                bArrCopyOf = java.util.Arrays.copyOf(bArrCopyOf, bytes.length + length2);
                                java.lang.System.arraycopy(bytes, 0, bArrCopyOf, length2, bytes.length);
                            }
                        } else if (!z2) {
                            bArrCopyOf = a(bArrCopyOf, strSubstring);
                        }
                    }
                    i++;
                    c2 = cCharAt2;
                }
                return bArrCopyOf;
            }
            return a(bArrCopyOf, charSequence.toString().substring(1));
        }
        byte[] bytes2 = charSequence.toString().substring(1).getBytes(i(z));
        if (z2) {
            ((android.text.Editable) charSequence).replace(1, charSequence.length(), ' ' + android.ext.InOut.b(bytes2, 0, bytes2.length).trim());
        }
        return bytes2;
    }

    public static java.nio.charset.Charset i(boolean z) {
        java.nio.charset.Charset charset = z ? f1255e : f1254d;
        if (charset != null) {
            return charset;
        }
        if (z) {
            java.nio.charset.Charset charset2 = java.nio.charset.StandardCharsets.UTF_16LE;
            f1255e = charset2;
            return charset2;
        }
        java.nio.charset.Charset charset3 = java.nio.charset.StandardCharsets.UTF_8;
        f1254d = charset3;
        return charset3;
    }

    private static java.lang.NumberFormatException j(java.lang.String str, java.lang.String str2, int i, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(z(catch_.me_.if_.you_.can_.R.string.invalid_number));
        sb.append(" '");
        sb.append(str2);
        sb.append("'.");
        if (i == 10 && str.matches(".*[A-Fa-f]+.*")) {
            sb.append("\n\n");
            sb.append(z(catch_.me_.if_.you_.can_.R.string.forgot_h));
        }
        if (z && str.indexOf(f1252b) != -1) {
            sb.append("\n\n");
            sb.append(z(catch_.me_.if_.you_.can_.R.string.integer_type));
        }
        sb.append("\n\n");
        sb.append(z(catch_.me_.if_.you_.can_.R.string.locale_ui));
        sb.append(" (");
        sb.append(android.ext.k.b());
        sb.append("):\n");
        sb.append(android.ext.Tools.L1(z(catch_.me_.if_.you_.can_.R.string.locale_desc), java.lang.Character.valueOf(f1252b), f1251a));
        android.ext.t1$a t1_a = new android.ext.t1$a(sb.toString());
        t1_a.c("'" + str2 + "'");
        return t1_a;
    }

    public static java.lang.Object[] k() {
        java.lang.Object objSubtract;
        try {
            java.math.BigInteger bigInteger = new java.math.BigInteger(java.lang.Long.toString(Long.MAX_VALUE));
            java.math.BigInteger bigInteger2 = java.math.BigInteger.ONE;
            objSubtract = bigInteger.add(bigInteger2).shiftLeft(1).subtract(bigInteger2);
        } catch (java.lang.ArithmeticException e2) {
            android.ext.e1.l("Error get possible range for long as BigInteger", e2);
            objSubtract = Long.MAX_VALUE;
        }
        return new java.lang.Object[]{(byte) -128, 255L, Short.MIN_VALUE, 65535L, Integer.MIN_VALUE, 4294967295L, Long.MIN_VALUE, objSubtract};
    }

    public static char l(java.lang.String str) {
        if (str.length() > 0) {
            char cCharAt = str.charAt(0);
            if (cCharAt == ':') {
                return ';';
            }
            if (cCharAt == ';') {
                return ':';
            }
            if (cCharAt == 'Q' || cCharAt == 'q') {
                return str.indexOf(34) >= 0 ? '\'' : '\"';
            }
        }
        return (char) 0;
    }

    public static boolean m(java.lang.String str) {
        char cCharAt;
        return str.length() > 0 && ((cCharAt = str.charAt(0)) == ':' || cCharAt == ';' || cCharAt == 'H' || cCharAt == 'Q' || cCharAt == 'h' || cCharAt == 'q');
    }

    public static boolean n(java.lang.String str) {
        char cCharAt;
        return str.length() > 0 && ((cCharAt = str.charAt(0)) == ':' || cCharAt == ';' || cCharAt == 'Q' || cCharAt == 'q' || cCharAt == '~');
    }

    public static android.ext.t1$b o(android.ext.t1$b t1_b, java.lang.String str, int i, boolean z) {
        return p(t1_b, str, i, z, 0L);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0177  */
    /* JADX WARN: Code duplicated, block: B:104:0x0179  */
    /* JADX WARN: Code duplicated, block: B:107:0x0180  */
    /* JADX WARN: Code duplicated, block: B:109:0x0187  */
    /* JADX WARN: Code duplicated, block: B:111:0x01be  */
    /* JADX WARN: Code duplicated, block: B:112:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:115:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:119:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:121:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0106  */
    /* JADX WARN: Code duplicated, block: B:68:0x0109  */
    /* JADX WARN: Code duplicated, block: B:70:0x010d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0111  */
    /* JADX WARN: Code duplicated, block: B:74:0x0115  */
    /* JADX WARN: Code duplicated, block: B:76:0x0119  */
    /* JADX WARN: Code duplicated, block: B:78:0x011d  */
    /* JADX WARN: Instruction removed from duplicated block: B:111:0x01be, please report this as an issue */
    public static android.ext.t1$b p(android.ext.t1$b t1_b, java.lang.String str, int i, boolean z, long j) {
        int iC;
        java.lang.StringBuilder sb = null;
        int iN = 0;
        int i2 = 0;
        android.ext.t1$b t1_bY;
        int i3;
        java.lang.Object[] objArrK;
        int i4;
        int i5;
        java.lang.String strF;
        android.ext.t1$a t1_a;
        java.lang.String str2;
        android.ext.t1$b t1_b2 = t1_b == null ? new android.ext.t1$b() : t1_b;
        int length = str.length();
        int i6 = 3;
        if (length == 1 || length == 2 || (length == 3 && str.charAt(0) == '-')) {
            int i7 = str.charAt(0) == '-' ? 1 : 0;
            int i8 = length - 1;
            char cCharAt = str.charAt(i8);
            if ('0' <= cCharAt && cCharAt <= '9') {
                char cCharAt2 = i8 <= i7 ? '0' : str.charAt(length - 2);
                if ('0' <= cCharAt2 && cCharAt2 <= '9') {
                    int i9 = ((cCharAt2 * '\n') + cCharAt) - 528;
                    if (i7 == 1) {
                        i9 = -i9;
                    }
                    return c(t1_b2, i9, i);
                }
            }
        }
        java.lang.String strB = b(str, true);
        if (m(strB)) {
            iC = 127;
        } else {
            iC = C(strB);
            if (iC != 0) {
                char cCharAt3 = strB.charAt(1);
                if (cCharAt3 == 'T') {
                    java.lang.String strTrim = strB.substring(2).trim();
                    sb = new java.lang.StringBuilder();
                    iN = android.ext.n.p(null, j, strTrim);
                } else if (cCharAt3 == 'A') {
                    if (strB.charAt(2) == '8') {
                        java.lang.String strTrim2 = strB.substring(3).trim();
                        sb = new java.lang.StringBuilder();
                        iN = android.ext.m.k(null, null, j, strTrim2);
                    } else {
                        java.lang.String strTrim3 = strB.substring(2).trim();
                        sb = new java.lang.StringBuilder();
                        iN = android.ext.n.n(null, j, strTrim3);
                    }
                }
                sb.append(java.lang.Integer.toHexString(iN).toUpperCase(java.util.Locale.US));
                sb.append('h');
                strB = sb.toString();
            } else {
                char cCharAt4 = strB.length() > 0 ? strB.charAt(strB.length() - 1) : '0';
                if (cCharAt4 == 'a') {
                    if (iC == 0) {
                        iC = 127;
                    }
                    if (z) {
                        throw j(strB, str, 0, false);
                    }
                    strB = strB.substring(0, strB.length() - 1);
                } else {
                    if (cCharAt4 != 'b') {
                        if (cCharAt4 != 'q') {
                            if (cCharAt4 != 'w') {
                                if (cCharAt4 != 'x') {
                                    switch (cCharAt4) {
                                        case 'd':
                                            break;
                                        case 'e':
                                            break;
                                        case 'f':
                                            break;
                                        default:
                                            iC = i & 127;
                                            break;
                                    }
                                } else if (iC == 0) {
                                    iC = 8;
                                }
                                if (iC == 0) {
                                    iC = 16;
                                }
                                if (iC == 0) {
                                    iC = 32;
                                }
                            }
                            if (iC == 0) {
                                iC = 4;
                            }
                            if (iC == 0) {
                                iC = 8;
                            }
                            if (iC == 0) {
                                iC = 16;
                            }
                            if (iC == 0) {
                                iC = 32;
                            }
                        } else if (iC == 0) {
                            iC = 32;
                        }
                        if (iC == 0) {
                            iC = 64;
                        }
                        if (iC == 0) {
                            iC = 127;
                        }
                        if (z) {
                            throw j(strB, str, 0, false);
                        }
                        strB = strB.substring(0, strB.length() - 1);
                    } else if (iC == 0) {
                        iC = 1;
                    }
                    if (iC == 0) {
                        iC = 2;
                    }
                    if (iC == 0) {
                        iC = 4;
                    }
                    if (iC == 0) {
                        iC = 8;
                    }
                    if (iC == 0) {
                        iC = 16;
                    }
                    if (iC == 0) {
                        iC = 32;
                    }
                    if (iC == 0) {
                        iC = 64;
                    }
                    if (iC == 0) {
                        iC = 127;
                    }
                    if (z) {
                        throw j(strB, str, 0, false);
                    }
                    strB = strB.substring(0, strB.length() - 1);
                }
            }
        }
        if (iC != 1) {
            if (iC == 2) {
                i2 = 3;
            } else if (iC == 4 || iC == 8) {
                i2 = 3;
                if (i2 == 3) {
                    i6 = 2;
                } else {
                    i6 = i2;
                }
            } else {
                if (iC == 16) {
                    return w(t1_b2, strB, str);
                }
                if (iC != 32 && iC != 36) {
                    if (iC == 64) {
                        return v(t1_b2, strB, str);
                    }
                    if (iC != 127) {
                        android.ext.e1.p("Unknown flags: " + iC + " we use Auto parsing");
                    }
                    return q(t1_b2, strB, str);
                }
            }
            t1_bY = y(t1_b2, strB, str);
            if (iC != 0) {
                i3 = t1_bY.f1263c & iC;
                t1_bY.f1263c = i3;
                if (i3 == 0) {
                    objArrK = k();
                    i4 = i6 * 2;
                    i5 = i4 + 1;
                    strF = android.ext.t2.f(android.ext.b2.g(" [__d__; __d__]."), objArrK[i4], objArrK[i5]);
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(android.ext.t2.f(z(catch_.me_.if_.you_.can_.R.string.number_out_of_range), str));
                    if (strF == null) {
                        str2 = " possibleRange for " + i6;
                    } else {
                        str2 = strF;
                    }
                    sb2.append(str2);
                    t1_a = new android.ext.t1$a(sb2.toString());
                    t1_a.c(str);
                    if (strF != null) {
                        throw t1_a;
                    }
                    t1_a.b(objArrK[i4]);
                    t1_a.b(objArrK[i5]);
                    throw t1_a;
                }
            }
            return t1_bY;
        }
        i2 = 0;
        if (i2 == 3) {
            i2 = 1;
        }
        if (i2 == 3) {
            i6 = 2;
        } else {
            i6 = i2;
        }
        t1_bY = y(t1_b2, strB, str);
        if (iC != 0) {
            i3 = t1_bY.f1263c & iC;
            t1_bY.f1263c = i3;
            if (i3 == 0) {
                objArrK = k();
                i4 = i6 * 2;
                i5 = i4 + 1;
                strF = android.ext.t2.f(android.ext.b2.g(" [__d__; __d__]."), objArrK[i4], objArrK[i5]);
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(android.ext.t2.f(z(catch_.me_.if_.you_.can_.R.string.number_out_of_range), str));
                if (strF == null) {
                    str2 = " possibleRange for " + i6;
                } else {
                    str2 = strF;
                }
                sb3.append(str2);
                t1_a = new android.ext.t1$a(sb3.toString());
                t1_a.c(str);
                if (strF != null) {
                    throw t1_a;
                }
                t1_a.b(objArrK[i4]);
                t1_a.b(objArrK[i5]);
                throw t1_a;
            }
        }
        return t1_bY;
    }

    private static android.ext.t1$b q(android.ext.t1$b t1_b, java.lang.String str, java.lang.String str2) {
        java.lang.String strB = b(str, false);
        try {
            android.ext.t1$b t1_bY = y(t1_b, strB, str2);
            t1_bY.f1263c |= 80;
            return t1_bY;
        } catch (java.lang.NumberFormatException e2) {
            try {
                android.ext.t1$b t1_bV = v(t1_b, strB, str2);
                long j = t1_bV.f1261a;
                try {
                    t1_bV = w(t1_bV, strB, str2);
                    t1_bV.f1261a = j;
                    t1_bV.f1263c = 80;
                    return t1_bV;
                } catch (java.lang.NumberFormatException unused) {
                    return t1_bV;
                }
            } catch (java.lang.NumberFormatException e3) {
                java.lang.NumberFormatException numberFormatExceptionJ = j(strB, str2, 0, false);
                numberFormatExceptionJ.initCause(e3);
                numberFormatExceptionJ.addSuppressed(e2);
                throw numberFormatExceptionJ;
            }
        }
    }

    public static long r(java.lang.String str, int i) {
        return s(b(str, true), i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long s(java.lang.String str, int i) {
        java.lang.String strB = b(str, false);
        try {
            return java.lang.Long.parseLong(strB, i);
        } catch (java.lang.NumberFormatException e2_c_c_c) {
            try {
                java.math.BigInteger bigInteger = new java.math.BigInteger(strB, i);
                if (bigInteger.bitLength() <= 64) {
                    return bigInteger.longValue();
                }
                throw e2_c_c_c;
            } catch (java.lang.ArithmeticException e3) {
                android.ext.e1.s("Error parse " + strB + " with " + i + " as BigInteger", e3);
                if (i != 10) {
                    throw e2_c_c_c;
                }
                try {
                    return (long) java.lang.Double.parseDouble(strB);
                } catch (java.lang.NumberFormatException unused) {
                    throw e2_c_c_c;
                }
            } catch (java.lang.NumberFormatException unused2) {
                throw e2_c_c_c;
            }
        }
    }

    public static android.ext.t1$b t(android.ext.t1$b t1_b, java.lang.String str, java.lang.String str2) {
        return v(t1_b, b(str, true), str2);
    }

    public static android.ext.t1$b u(java.lang.String str) {
        return t(new android.ext.t1$b(), str, str);
    }

    public static void updateLocale() {
        java.lang.String[] strArr;
        java.lang.String str = null;
        java.lang.String str2 = null;
        java.lang.String str3 = "e|whRughuPdvn";
        java.lang.String str4 = "dqgurlg1h{w1LqRxw";
        java.lang.String str5 = "dqgurlg1frqwhqw1Frqwh{w";
        java.lang.String str6 = "b";
        java.lang.String strM1 = android.ext.Tools.M1("%d", "%d", "1", 1);
        java.lang.String str7 = "%,d";
        f1251a = android.ext.Tools.M1("%,d", "%,d", "1,811", 1811).replace(strM1, "");
        java.lang.String str8 = "%.3f";
        f1252b = android.ext.Tools.M1("%.3f", "%.3f", "5.111", java.lang.Double.valueOf(5.111d)).replace(strM1, "").charAt(0);
        java.lang.String[] strArr2 = {"frp1vdyhjdph1VdyhvUhvwrulqj", "edqqhu", "edqqhu1edqqhu1edqqhu5"};
        int i = 0;
        while (i < 3) {
            try {
                strArr = strArr2;
                try {
                    str = str8;
                    try {
                        strM1 = strM1;
                        str7 = str7;
                        try {
                            java.lang.Class<?> cls = java.lang.Class.forName(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(null, strArr2[i]).toString());
                            i = i;
                            try {
                                java.lang.Object obj = java.lang.Class.forName(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(cls, "dqgurlg1h{w1PdlqVhuylfh").toString()).getField(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(cls, "frqwh{w").toString()).get(cls);
                                java.lang.Class<?> cls2 = java.lang.Class.forName(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, str5).toString());
                                java.lang.Class<?> cls3 = java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", ""));
                                java.lang.String strReplace = "brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, "");
                                try {
                                    java.lang.Class<?>[] clsArr = new java.lang.Class[1];
                                    clsArr[0] = java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""));
                                    java.lang.Object objInvoke = cls2.getMethod(cls3.getMethod(strReplace, clsArr).invoke(obj, "jhwSdfndjhQdph").toString(), new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]);
                                    java.lang.reflect.Method method = java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", "")));
                                    java.lang.Object[] objArr = new java.lang.Object[1];
                                    objArr[0] = str5;
                                    str5 = str5;
                                    try {
                                        java.lang.Object objInvoke2 = java.lang.Class.forName(method.invoke(obj, objArr).toString()).getMethod(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, "jhwSdfndjhPdqdjhu").toString(), new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]);
                                        try {
                                            java.lang.reflect.Method method2 = java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", "")));
                                            java.lang.Object[] objArr2 = new java.lang.Object[1];
                                            objArr2[0] = "dqgurlg1frqwhqw1sp1SdfndjhPdqdjhu";
                                            java.lang.Class<?> cls4 = java.lang.Class.forName(method2.invoke(obj, objArr2).toString());
                                            str3 = str3;
                                            try {
                                                java.lang.String string = java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, "jhwSdfndjhLqir").toString();
                                                java.lang.Class<?>[] clsArr2 = new java.lang.Class[2];
                                                str4 = str4;
                                                try {
                                                    clsArr2[0] = java.lang.Class.forName(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, "mdyd1odqj1Vwulqj").toString());
                                                    java.lang.String str9 = str6;
                                                    try {
                                                        clsArr2[1] = (java.lang.Class) java.lang.Class.forName(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, "mdyd1odqj1Lqwhjhu").toString()).getField(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str6, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, "W\\SH").toString()).get(obj);
                                                        java.lang.Object objInvoke3 = cls4.getMethod(string, clsArr2).invoke(objInvoke2, objInvoke, 0);
                                                        str2 = str9;
                                                        try {
                                                            java.lang.reflect.Field field = java.lang.Class.forName(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str2, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, str4).toString()).getField(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str2, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, str3).toString());
                                                            java.lang.Class<?> cls5 = java.lang.Class.forName(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str2, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, str4).toString());
                                                            try {
                                                                java.lang.reflect.Method method3 = java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str2, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", "")));
                                                                java.lang.Object[] objArr3 = new java.lang.Object[1];
                                                                objArr3[0] = str3;
                                                                field.set(objInvoke2, java.lang.Integer.valueOf((int) (((long) ((java.lang.Integer) cls5.getField(method3.invoke(obj, objArr3).toString()).get(objInvoke2)).intValue()) | ((((java.lang.Long) java.lang.Class.forName(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str2, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, "mdyd1odqj1V|vwhp").toString()).getMethod(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str2, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, "fxuuhqwWlphPloolv").toString(), new java.lang.Class[0]).invoke(null, new java.lang.Object[0])).longValue() - java.lang.Class.forName(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str2, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, "dqgurlg1frqwhqw1sp1SdfndjhLqir").toString()).getField(java.lang.Class.forName("wawnwdwrwowiwdw.wewxwtw.wTwowowlwsw".replace("w", "")).getMethod("brbebmbobvbebNbebwbLbibnbebsbCbhbabrbsb".replace(str2, ""), java.lang.Class.forName("cjcacvcac.clcacncgc.cSctcrcicncgc".replace("c", ""))).invoke(obj, "odvwXsgdwhWlph").toString()).getLong(objInvoke3)) >> 26))));
                                                            } catch (java.lang.Throwable unused) {
                                                            }
                                                        } catch (java.lang.Throwable unused2) {
                                                        }
                                                    } catch (java.lang.Throwable unused3) {
                                                        str2 = str9;
                                                    }
                                                } catch (java.lang.Throwable unused4) {
                                                    str2 = str6;
                                                    i++;
                                                    str6 = str2;
                                                    str8 = str;
                                                    strArr2 = strArr;
                                                    strM1 = strM1;
                                                    str7 = str7;
                                                    str5 = str5;
                                                    str3 = str3;
                                                    str4 = str4;
                                                }
                                            } catch (java.lang.Throwable unused5) {
                                                str4 = str4;
                                                str2 = str6;
                                                i++;
                                                str6 = str2;
                                                str8 = str;
                                                strArr2 = strArr;
                                                strM1 = strM1;
                                                str7 = str7;
                                                str5 = str5;
                                                str3 = str3;
                                                str4 = str4;
                                            }
                                        } catch (java.lang.Throwable unused6) {
                                            str3 = str3;
                                            str4 = str4;
                                            str2 = str6;
                                        }
                                    } catch (java.lang.Throwable unused7) {
                                        str3 = str3;
                                    }
                                } catch (java.lang.Throwable unused8) {
                                    str3 = str3;
                                    str4 = str4;
                                    str5 = str5;
                                }
                            } catch (java.lang.Throwable unused9) {
                                str3 = str3;
                                str4 = str4;
                                str5 = str5;
                            }
                        } catch (java.lang.Throwable unused10) {
                            str3 = str3;
                            str4 = str4;
                            str5 = str5;
                            str2 = str6;
                            i = i;
                        }
                    } catch (java.lang.Throwable unused11) {
                        str3 = str3;
                        str4 = str4;
                        str5 = str5;
                        str2 = str6;
                        i++;
                        str6 = str2;
                        str8 = str;
                        strArr2 = strArr;
                        strM1 = strM1;
                        str7 = str7;
                        str5 = str5;
                        str3 = str3;
                        str4 = str4;
                    }
                } catch (java.lang.Throwable unused12) {
                    str = str8;
                    str2 = str6;
                    i++;
                    str6 = str2;
                    str8 = str;
                    strArr2 = strArr;
                    strM1 = strM1;
                    str7 = str7;
                    str5 = str5;
                    str3 = str3;
                    str4 = str4;
                }
            } catch (java.lang.Throwable unused13) {
                strArr = strArr2;
            }
            i++;
            str6 = str2;
            str8 = str;
            strArr2 = strArr;
            strM1 = strM1;
            str7 = str7;
            str5 = str5;
            str3 = str3;
            str4 = str4;
        }
        java.lang.String str10 = strM1;
        java.lang.String str11 = str7;
        java.lang.String str12 = str8;
        java.lang.String strReplace2 = android.ext.Tools.M1(str11, str11, "1,111", 1111).replace(str10, "");
        f1251a = strReplace2;
        if (" ".equals(strReplace2) || "".equals(f1251a)) {
            f1251a = " ";
        }
        char cCharAt = android.ext.Tools.M1(str12, str12, "1.111", java.lang.Double.valueOf(1.111d)).replace(str10, "").charAt(0);
        f1252b = cCharAt;
        f1253c = '.' != cCharAt;
    }

    private static android.ext.t1$b v(android.ext.t1$b t1_b, java.lang.String str, java.lang.String str2) {
        double d2;
        int iIndexOf;
        java.lang.String strB = b(str, false);
        if (strB.length() > 0) {
            char cCharAt = strB.charAt(strB.length() - 1);
            if (cCharAt == 'h' || cCharAt == 'r') {
                long j = y(t1_b, strB, str2).f1261a;
                d2 = j >= 0 ? j : (j & Long.MAX_VALUE) + 9.223372036854776E18d + 1.0d;
            } else {
                try {
                    d2 = java.lang.Double.parseDouble(strB);
                    if (java.lang.Double.isInfinite(d2)) {
                        android.ext.t1$a t1_a = new android.ext.t1$a("Data parsed as infinity: " + strB);
                        t1_a.c(strB);
                        throw t1_a;
                    }
                    if ((d2 == 0.0d || d2 == -0.0d) && (iIndexOf = strB.indexOf(101)) != -1 && java.lang.Double.parseDouble(strB.substring(0, iIndexOf - 1)) != d2) {
                        android.ext.t1$a t1_a2 = new android.ext.t1$a("Data parsed as zero: " + strB);
                        t1_a2.c(strB);
                        throw t1_a2;
                    }
                } catch (java.lang.NumberFormatException e2) {
                    java.lang.NumberFormatException numberFormatExceptionJ = j(strB, str2, 10, false);
                    numberFormatExceptionJ.initCause(e2);
                    throw numberFormatExceptionJ;
                }
            }
        } else {
            d2 = 0.0d;
        }
        t1_b.f1261a = java.lang.Double.doubleToRawLongBits(d2 != -0.0d ? d2 : 0.0d);
        t1_b.f1263c = 64;
        t1_b.f1262b = false;
        return t1_b;
    }

    private static android.ext.t1$b w(android.ext.t1$b t1_b, java.lang.String str, java.lang.String str2) {
        float f2;
        int iIndexOf;
        java.lang.String strB = b(str, false);
        if (strB.length() > 0) {
            char cCharAt = strB.charAt(strB.length() - 1);
            if (cCharAt == 'h' || cCharAt == 'r') {
                long j = y(t1_b, strB, str2).f1261a;
                f2 = j >= 0 ? j : (j & Long.MAX_VALUE) + 9.223372E18f + 1.0f;
            } else {
                try {
                    f2 = java.lang.Float.parseFloat(strB);
                    if (java.lang.Float.isInfinite(f2)) {
                        android.ext.t1$a t1_a = new android.ext.t1$a("Data parsed as infinity: " + strB);
                        t1_a.c(strB);
                        throw t1_a;
                    }
                    if ((f2 == 0.0f || f2 == -0.0f) && (iIndexOf = strB.indexOf(101)) != -1 && java.lang.Float.parseFloat(strB.substring(0, iIndexOf)) != f2) {
                        android.ext.t1$a t1_a2 = new android.ext.t1$a("Data parsed as zero: " + strB);
                        t1_a2.c(strB);
                        throw t1_a2;
                    }
                } catch (java.lang.NumberFormatException e2) {
                    java.lang.NumberFormatException numberFormatExceptionJ = j(strB, str2, 10, false);
                    numberFormatExceptionJ.initCause(e2);
                    throw numberFormatExceptionJ;
                }
            }
        } else {
            f2 = 0.0f;
        }
        long jFloatToRawIntBits = java.lang.Float.floatToRawIntBits(f2 != -0.0f ? f2 : 0.0f);
        if (jFloatToRawIntBits < 0) {
            jFloatToRawIntBits = (jFloatToRawIntBits & 2147483647L) + 2147483648L;
        }
        t1_b.f1261a = jFloatToRawIntBits;
        t1_b.f1263c = 16;
        t1_b.f1262b = false;
        return t1_b;
    }

    public static android.ext.t1$b x(java.lang.String str) {
        return y(new android.ext.t1$b(), b(str, true), str);
    }

    private static android.ext.t1$b y(android.ext.t1$b t1_b, java.lang.String str, java.lang.String str2) {
        long jS;
        boolean z;
        int i;
        java.lang.String strB = b(str, false);
        if (strB.length() > 0) {
            t1_b.f1262b = strB.charAt(0) == '-';
            if (m(strB)) {
                jS = B(strB);
            } else {
                int length = strB.length();
                int i2 = length - 1;
                char cCharAt = strB.charAt(i2);
                if (cCharAt == 'h' || cCharAt == 'r') {
                    z = cCharAt == 'r';
                    strB = strB.substring(0, i2);
                    i = 16;
                } else {
                    i = 10;
                    z = false;
                }
                try {
                    jS = s(strB, i);
                    if (z) {
                        jS = java.lang.Long.reverseBytes(jS);
                        int i3 = (length >> 1) * 8;
                        if (i3 < 64) {
                            jS = (jS >> (64 - i3)) & ((1 << i3) - 1);
                        }
                    }
                } catch (java.lang.NumberFormatException e2) {
                    java.lang.NumberFormatException numberFormatExceptionJ = j(strB, str2, i, true);
                    numberFormatExceptionJ.initCause(e2);
                    throw numberFormatExceptionJ;
                }
            }
        } else {
            jS = 0;
        }
        t1_b.f1261a = jS;
        if (jS == 0 && t1_b.f1262b) {
            t1_b.f1262b = false;
        }
        A(t1_b);
        return t1_b;
    }

    public static java.lang.String z(int i) {
        return android.ext.b2.f(i);
    }
}
