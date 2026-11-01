package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final java.lang.String[] f1075d = {"EQ", "NE", "CS", "CC", "MI", "PL", "VS", "VC", "HI", "LS", "GE", "LT", "GT", "LE", "AL", "<UND>", ""};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final java.lang.String[] f1076e = {"R0", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "R12", "SP", "LR", "PC"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final java.lang.String[] f1077f = {"0.0", "1.0", "2.0", "3.0", "4.0", "5.0", "0.5", "10.0"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final java.lang.String[] f1078g = {"LSL", "LSR", "ASR", "ROR"};
    static final android.ext.n$f h = new android.ext.n$f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    android.ext.n$d f1081c;

    static final void d(java.lang.StringBuilder sb, char c2) {
        if (c2 != 0) {
            sb.append(c2);
        }
    }

    static int e(android.ext.n$d n_d) {
        if (n_d.b("CPSR")) {
            return 15;
        }
        if (n_d.b("R8_USR")) {
            return 32;
        }
        if (n_d.b("R9_USR")) {
            return 33;
        }
        if (n_d.b("R10_USR")) {
            return 34;
        }
        if (n_d.b("R11_USR")) {
            return 35;
        }
        if (n_d.b("R12_USR")) {
            return 36;
        }
        if (n_d.b("SP_USR")) {
            return 37;
        }
        if (n_d.b("LR_USR")) {
            return 38;
        }
        if (n_d.b("R8_FIQ")) {
            return 40;
        }
        if (n_d.b("R9_FIQ")) {
            return 41;
        }
        if (n_d.b("R10_FIQ")) {
            return 42;
        }
        if (n_d.b("R11_FIQ")) {
            return 43;
        }
        if (n_d.b("R12_FIQ")) {
            return 44;
        }
        if (n_d.b("SP_FIQ")) {
            return 45;
        }
        if (n_d.b("LR_FIQ")) {
            return 46;
        }
        if (n_d.b("LR_IRQ")) {
            return 48;
        }
        if (n_d.b("SP_IRQ")) {
            return 49;
        }
        if (n_d.b("LR_SVC")) {
            return 50;
        }
        if (n_d.b("SP_SVC")) {
            return 51;
        }
        if (n_d.b("LR_ABT")) {
            return 52;
        }
        if (n_d.b("SP_ABT")) {
            return 53;
        }
        if (n_d.b("LR_UND")) {
            return 54;
        }
        if (n_d.b("SP_UND")) {
            return 55;
        }
        if (n_d.b("LR_MON")) {
            return 60;
        }
        if (n_d.b("SP_MON")) {
            return 61;
        }
        if (n_d.b("ELR_HYP")) {
            return 62;
        }
        if (n_d.b("SP_HYP")) {
            return 63;
        }
        if (n_d.b("SPSR_FIQ")) {
            return 110;
        }
        if (n_d.b("SPSR_IRQ")) {
            return 112;
        }
        if (n_d.b("SPSR_SVC")) {
            return 114;
        }
        if (n_d.b("SPSR_ABT")) {
            return 116;
        }
        if (n_d.b("SPSR_UND")) {
            return 118;
        }
        if (n_d.b("SPSR_MON")) {
            return 124;
        }
        if (n_d.b("SPSR_HYP")) {
            return 126;
        }
        if (n_d.b("SPSR")) {
            return 79;
        }
        if (!n_d.b("(UNDEF: ")) {
            return -1;
        }
        int iG = (int) n_d.g();
        if ((iG & (-128)) != 0) {
            throw h;
        }
        if (n_d.a(')')) {
            return iG;
        }
        throw h;
    }

    static void f(java.lang.StringBuilder sb, int i) {
        java.lang.String str;
        if (i == 15) {
            str = "CPSR";
        } else if (i == 79) {
            str = "SPSR";
        } else if (i == 110) {
            str = "SPSR_fiq";
        } else if (i == 112) {
            str = "SPSR_irq";
        } else if (i == 114) {
            str = "SPSR_svc";
        } else if (i == 116) {
            str = "SPSR_abt";
        } else if (i == 118) {
            str = "SPSR_und";
        } else if (i == 124) {
            str = "SPSR_mon";
        } else if (i != 126) {
            switch (i) {
                case 32:
                    str = "R8_usr";
                    break;
                case 33:
                    str = "R9_usr";
                    break;
                case 34:
                    str = "R10_usr";
                    break;
                case 35:
                    str = "R11_usr";
                    break;
                case 36:
                    str = "R12_usr";
                    break;
                case 37:
                    str = "SP_usr";
                    break;
                case 38:
                    str = "LR_usr";
                    break;
                default:
                    switch (i) {
                        case 40:
                            str = "R8_fiq";
                            break;
                        case 41:
                            str = "R9_fiq";
                            break;
                        case 42:
                            str = "R10_fiq";
                            break;
                        case 43:
                            str = "R11_fiq";
                            break;
                        case 44:
                            str = "R12_fiq";
                            break;
                        case 45:
                            str = "SP_fiq";
                            break;
                        case 46:
                            str = "LR_fiq";
                            break;
                        default:
                            switch (i) {
                                case 48:
                                    str = "LR_irq";
                                    break;
                                case 49:
                                    str = "SP_irq";
                                    break;
                                case 50:
                                    str = "LR_svc";
                                    break;
                                case 51:
                                    str = "SP_svc";
                                    break;
                                case 52:
                                    str = "LR_abt";
                                    break;
                                case 53:
                                    str = "SP_abt";
                                    break;
                                case 54:
                                    str = "LR_und";
                                    break;
                                case 55:
                                    str = "SP_und";
                                    break;
                                default:
                                    switch (i) {
                                        case 60:
                                            str = "LR_mon";
                                            break;
                                        case 61:
                                            str = "SP_mon";
                                            break;
                                        case 62:
                                            str = "ELR_hyp";
                                            break;
                                        case 63:
                                            str = "SP_hyp";
                                            break;
                                        default:
                                            sb.append("(UNDEF: ");
                                            sb.append(i);
                                            sb.append(')');
                                            return;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            str = "SPSR_hyp";
        }
        sb.append(str);
    }

    static final char g(java.lang.String str, int i, int i2) {
        if (i2 < i) {
            return str.charAt(i2);
        }
        return (char) 0;
    }

    static int h(android.ext.n$d n_d) {
        if (n_d.b("OSHLD")) {
            return 1;
        }
        if (n_d.b("OSHST")) {
            return 2;
        }
        if (n_d.b("OSH")) {
            return 3;
        }
        if (n_d.b("NSHLD")) {
            return 5;
        }
        if (n_d.b("UNST")) {
            return 6;
        }
        if (n_d.b("UN")) {
            return 7;
        }
        if (n_d.b("ISHLD")) {
            return 9;
        }
        if (n_d.b("ISHST")) {
            return 10;
        }
        if (n_d.b("ISH")) {
            return 11;
        }
        if (n_d.b("LD")) {
            return 13;
        }
        if (n_d.b("ST")) {
            return 14;
        }
        if (n_d.b("SY")) {
            return 15;
        }
        if (!n_d.a('#')) {
            return -1;
        }
        int iG = (int) n_d.g();
        if ((iG & (-16)) == 0) {
            return iG;
        }
        throw h;
    }

    static void i(java.lang.StringBuilder sb, int i) {
        java.lang.String str;
        int i2 = i & 15;
        switch (i2) {
            case 1:
                str = "oshld";
                break;
            case 2:
                str = "oshst";
                break;
            case 3:
                str = "osh";
                break;
            case 4:
            case 8:
            case 12:
            default:
                sb.append('#');
                sb.append(i2);
                return;
            case 5:
                str = "nshld";
                break;
            case 6:
                str = "unst";
                break;
            case 7:
                str = "un";
                break;
            case 9:
                str = "ishld";
                break;
            case 10:
                str = "ishst";
                break;
            case 11:
                str = "ish";
                break;
            case 13:
                str = "ld";
                break;
            case 14:
                str = "st";
                break;
            case 15:
                str = "sy";
                break;
        }
        sb.append(str);
    }

    static int j(java.lang.String str, int i, int i2, int i3, android.ext.n nVar) {
        int i4;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            char cG = g(str, i, i2);
            int i7 = 0;
            while (cG >= '0' && cG <= '9') {
                i7 = ((i7 * 10) + cG) - 48;
                i2++;
                cG = g(str, i, i2);
            }
            if (cG == '-') {
                i2++;
                cG = g(str, i, i2);
                i4 = 0;
                while (cG >= '0' && cG <= '9') {
                    i4 = ((i4 * 10) + cG) - 48;
                    i2++;
                    cG = g(str, i, i2);
                }
            } else {
                i4 = i7;
            }
            int i8 = i4 - i7;
            if (i8 < 0) {
                throw new java.lang.RuntimeException("140 Bits is negative: " + i8 + "; " + i7 + "; " + i4 + "; '" + str + "'; " + i2 + "; " + i + "; 0x" + java.lang.Integer.toHexString(i3));
            }
            i5 |= ((i3 >> i7) & ((2 << i8) - 1)) << i6;
            i6 += i8 + 1;
            int i9 = i2 + 1;
            if (cG != ',') {
                nVar.f1079a = i5;
                nVar.f1080b = i6;
                return i2;
            }
            i2 = i9;
        }
    }

    static int k(java.lang.String str, int i, int i2, android.ext.n nVar, int i3) {
        int i4;
        int i5 = nVar.f1079a;
        int i6 = 0;
        while (true) {
            char cG = g(str, i, i2);
            int i7 = 0;
            while (cG >= '0' && cG <= '9') {
                i7 = ((i7 * 10) + cG) - 48;
                i2++;
                cG = g(str, i, i2);
            }
            if (cG == '-') {
                i2++;
                cG = g(str, i, i2);
                i4 = 0;
                while (cG >= '0' && cG <= '9') {
                    i4 = ((i4 * 10) + cG) - 48;
                    i2++;
                    cG = g(str, i, i2);
                }
            } else {
                i4 = i7;
            }
            int i8 = i4 - i7;
            if (i8 < 0) {
                throw new java.lang.RuntimeException("141 Bits is negative: " + i8 + "; " + i7 + "; " + i4 + "; '" + str + "'; " + i2 + "; " + i + "; 0x" + java.lang.Integer.toHexString(i3));
            }
            int i9 = (2 << i8) - 1;
            int i10 = ((i3 >> i6) & i9) << i7;
            i5 |= i10;
            if ((((i9 & ((-1) >> i6)) << i7) & i5) != i10) {
                throw h;
            }
            i6 += i8 + 1;
            int i11 = i2 + 1;
            if (cG != ',') {
                nVar.f1079a = i5;
                nVar.f1080b = i6;
                return i2;
            }
            i2 = i11;
        }
    }

    static int l(int i, android.ext.n$d n_d, boolean z) {
        int i2;
        java.lang.String[] strArr = f1076e;
        int iJ = n_d.j(strArr);
        if (iJ == -1) {
            throw h;
        }
        int i3 = i | iJ;
        if (!n_d.b(", ")) {
            return i3;
        }
        if (n_d.b("RRX")) {
            return i3 | 96;
        }
        if (z) {
            int iJ2 = n_d.j(f1078g);
            if (iJ2 == -1) {
                throw h;
            }
            i3 |= iJ2 << 5;
            if (!n_d.a(' ')) {
                throw h;
            }
        }
        if (n_d.a('#')) {
            int iG = (int) n_d.g();
            if (iG < 0 || iG > 32) {
                throw h;
            }
            if (iG == 32) {
                iG = 0;
            }
            i2 = iG << 7;
        } else {
            i3 |= 16;
            int iJ3 = n_d.j(strArr);
            if (iJ3 == -1) {
                throw h;
            }
            i2 = iJ3 << 8;
        }
        return i3 | i2;
    }

    static void m(java.lang.StringBuilder sb, int i, boolean z) {
        java.lang.String str;
        java.lang.String[] strArr = f1076e;
        sb.append(strArr[i & 15]);
        if ((i & 4080) != 0) {
            if ((i & 16) != 0) {
                if ((i & 128) == 128) {
                    str = " <illegal shifter operand>";
                } else {
                    sb.append(", ");
                    if (z) {
                        sb.append(f1078g[(i & 96) >> 5]);
                        sb.append(' ');
                    }
                    str = strArr[(i & 3840) >> 8];
                }
                sb.append(str);
                return;
            }
            int i2 = (i & 3968) >> 7;
            int i3 = (i & 96) >> 5;
            if (i2 == 0) {
                if (i3 == 3) {
                    sb.append(", RRX");
                    return;
                }
                i2 = 32;
            }
            sb.append(", ");
            if (z) {
                sb.append(f1078g[i3]);
                sb.append(' ');
            }
            sb.append('#');
            sb.append(i2);
        }
    }

    public static int n(android.ext.n nVar, long j, java.lang.String str) {
        if (nVar == null) {
            nVar = new android.ext.n();
        }
        int iA = android.ext.n$a.a(nVar, j, str, -1);
        if (iA != -1) {
            return iA;
        }
        java.lang.String strTrim = o(nVar, j, nVar.f1081c.f1092e).trim();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.asm_failed), "ARM").trim());
        sb.append("\n'");
        sb.append(str);
        sb.append("'\n\n");
        sb.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.asm_suggestion), "\n'" + strTrim + "'\n").trim());
        android.ext.n$b n_b = new android.ext.n$b(sb.toString());
        int iIndexOf = strTrim.indexOf(59);
        if (iIndexOf != -1) {
            strTrim = strTrim.substring(0, iIndexOf).trim();
        }
        n_b.f1084a = strTrim;
        n_b.f1085b = str;
        throw n_b;
    }

    public static java.lang.String o(android.ext.n nVar, long j, long j2) {
        if (nVar == null) {
            try {
                nVar = new android.ext.n();
            } catch (java.lang.Throwable th) {
                java.lang.String strReplace = th.toString().replace("java.lang.RuntimeException:", "RE:");
                android.ext.e1.g("Failed get OP 2", th);
                return strReplace;
            }
        }
        return android.ext.n$a.b(nVar, j, (int) j2);
    }

    public static int p(android.ext.n nVar, long j, java.lang.String str) {
        if (nVar == null) {
            nVar = new android.ext.n();
        }
        int iA = android.ext.n$g.a(nVar, j, str, -1);
        if (iA != -1) {
            return 65535 & iA;
        }
        java.lang.String strTrim = q(nVar, j, nVar.f1081c.f1092e).trim();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.asm_failed), "Thumb").trim());
        sb.append("\n'");
        sb.append(str);
        sb.append("'\n\n");
        sb.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.asm_suggestion), "\n'" + strTrim + "'\n").trim());
        android.ext.n$b n_b = new android.ext.n$b(sb.toString());
        int iIndexOf = strTrim.indexOf(59);
        if (iIndexOf != -1) {
            strTrim = strTrim.substring(0, iIndexOf).trim();
        }
        n_b.f1084a = strTrim;
        n_b.f1085b = str;
        throw n_b;
    }

    public static java.lang.String q(android.ext.n nVar, long j, long j2) {
        long j3 = j2 & 63488;
        try {
            if (j3 != 63488 && j3 != 61440 && j3 != 59392) {
                return android.ext.n$g.b(j, (int) j2);
            }
            long j4 = (((j2 & (-65536)) >> 16) & 65535) | ((j2 & 65535) << 16);
            if (nVar == null) {
                nVar = new android.ext.n();
            }
            return android.ext.n$h.a(nVar, j, (int) j4);
        } catch (java.lang.Throwable th) {
            java.lang.String strReplace = th.toString().replace("java.lang.RuntimeException:", "RE:");
            android.ext.e1.g("Failed get OP 1", th);
            return strReplace;
        }
    }

    static void r(java.lang.StringBuilder sb, long j, long j2) {
        if (j == 0) {
            if (j2 < 0) {
                sb.append('-');
                j2 = -j2;
            } else {
                sb.append('+');
            }
        }
        sb.append("0x");
        long j3 = j + j2;
        if (j3 != 0) {
            android.ext.ItemContextMenu.b(j3);
        }
        android.ext.t2.d(sb, 8, j3);
        sb.append("; ");
        sb.append(j2 <= 0 ? '-' : '+');
        sb.append("0x");
        if (j2 <= 0) {
            j2 = -j2;
        }
        sb.append(java.lang.Long.toHexString(j2).toUpperCase(java.util.Locale.US));
        sb.append(' ');
        sb.append(j2 > 0 ? (char) 8595 : (char) 8593);
    }
}
