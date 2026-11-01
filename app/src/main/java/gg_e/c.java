package gg_e;

/* JADX INFO: loaded from: classes.dex */
public class c implements a {
    static final long[] m = {-2, -1, -1, -1};
    static final long[] n = {0, 0, -1, -1};
    static final int[] o = {3, 0, 5, 49, 33, 34, 39, 40, 44, 45, 1, 2, 1, 2, 0, 5, 46, 3, 0, 5, 27, 32, 22, 24, 25, 17, 19, 20, 33, 34, 39, 40, 30, 31, 37, 38, 41, 42, 50, 31, 32, 37, 38, 42, 43, 1, 2, 44, 3, 0, 5, 25, 30, 20, 22, 23, 15, 17, 18, 31, 32, 37, 38, 47, 48, 28, 29, 35, 36, 39, 40, 37, 50, 39, 40, 45, 46, 32, 33, 1, 2, 37, 26, 38, 34, 3, 0, 5, 39, 40, 45, 46, 29, 30, 43, 44, 51, 35, 36, 41, 42, 46, 47, 3, 4, 3, 4, 2, 7, 48, 5, 2, 7, 29, 34, 24, 26, 27, 19, 21, 22, 5, 2, 7, 35, 36, 41, 42, 32, 33};
    public static final java.lang.String[] p = {"", null, null, null, null, "MOVE", "LOADK", "LOADBOOL", "LOADNIL", "GETUPVAL", "GETTABUP", "GETTABLE", "SETTABUP", "SETUPVAL", "SETTABLE", "NEWTABLE", "SELF", "ADD", "SUB", "MUL", "DIV", "MOD", "POW", "UNM", "NOT", "LEN", "CONCAT", "JMP", "EQ", "LT", "LE", "TEST", "TESTSET", "CALL", "TAILCALL", "RETURN", "FORLOOP", "FORPREP", "TFORCALL", "TFORLOOP", "SETLIST", "CLOSURE", "VARARG", "IDIV", "BNOT", "BAND", "BOR", "BXOR", "SHL", "SHR", "CONST", "FUNC[", "GOTO[", "OP", "SET_TOP", "SKIP_NEXT", "nil", "true", "false", null, null, null, ".source", ".linedefined", ".lastlinedefined", ".numparams", ".is_vararg", ".maxstacksize", ".upval", ".line", ".local", ".end local", ".func", ".end", null, "..", null, null, null, null, null, null, null, null, null, null, null, null, "[", "]"};
    public static final java.lang.String[] q = {"STATE_NAME", "STATE_SINT", "STATE_V_NAME", "DEFAULT"};
    public static final int[] r = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 0, 3, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 3, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    static final long[] s = {-31, 51642367};
    static final long[] t = {30, 0};
    static final long[] u = {16, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected e f1530c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected char f1533f;
    int i;
    int j;
    int k;
    int l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public java.io.PrintStream f1529b = java.lang.System.out;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f1531d = new int[52];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f1532e = new int[104];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1534g = 3;
    int h = 3;

    public c(e eVar) {
        this.f1530c = eVar;
    }

    private int A(long j, long j2, long j3, long j4) {
        long j5 = j4 & j3;
        if (((j2 & j) | j5) == 0) {
            return E0(10, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'e') {
                if (cK == 'i') {
                    return E(j5, 1L);
                }
            } else if ((8 & j5) != 0) {
                return G0(12, 67);
            }
            return E0(11, 0L, j5);
        } catch (java.io.IOException unused) {
            J0(11, 0L, j5);
            return 12;
        }
    }

    private int A0(int i, int i2, int i3) {
        this.l = i2;
        this.k = i;
        try {
            this.f1533f = this.f1530c.k();
            return k(i3, i + 1);
        } catch (java.io.IOException unused) {
            return i + 1;
        }
    }

    private int B(long j, long j2, long j3, long j4) {
        long j5 = j4 & j3;
        if (((j2 & j) | j5) == 0) {
            return F0(10, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'e') {
                if (cK == 'i') {
                    return F(j5, 1L);
                }
            } else if ((8 & j5) != 0) {
                return G0(12, 67);
            }
            return F0(11, 0L, j5);
        } catch (java.io.IOException unused) {
            K0(11, 0L, j5);
            return 12;
        }
    }

    private int B0(int i, int i2, int i3) {
        this.l = i2;
        this.k = i;
        try {
            this.f1533f = this.f1530c.k();
            return l(i3, i + 1);
        } catch (java.io.IOException unused) {
            return i + 1;
        }
    }

    private int C(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return C0(11, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return cK != 'n' ? C0(12, 0L, j3) : G(j3, 1L);
        } catch (java.io.IOException unused) {
            H0(12, 0L, j3);
            return 13;
        }
    }

    private final int C0(int i, long j, long j2) {
        return i(H0(i, j, j2), i + 1);
    }

    private int D(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return D0(11, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return cK != 'n' ? D0(12, 0L, j3) : H(j3, 1L);
        } catch (java.io.IOException unused) {
            I0(12, 0L, j3);
            return 13;
        }
    }

    private final int D0(int i, long j, long j2) {
        return j(I0(i, j, j2), i + 1);
    }

    private int E(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return E0(11, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return cK != 'n' ? E0(12, 0L, j3) : I(j3, 1L);
        } catch (java.io.IOException unused) {
            J0(12, 0L, j3);
            return 13;
        }
    }

    private final int E0(int i, long j, long j2) {
        return k(J0(i, j, j2), i + 1);
    }

    private int F(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return F0(11, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return cK != 'n' ? F0(12, 0L, j3) : J(j3, 1L);
        } catch (java.io.IOException unused) {
            K0(12, 0L, j3);
            return 13;
        }
    }

    private final int F0(int i, long j, long j2) {
        return l(K0(i, j, j2), i + 1);
    }

    private int G(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return C0(12, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return cK != 'e' ? C0(13, 0L, j3) : K(j3, 1L);
        } catch (java.io.IOException unused) {
            H0(13, 0L, j3);
            return 14;
        }
    }

    private int G0(int i, int i2) {
        this.l = i2;
        this.k = i;
        return i + 1;
    }

    private int H(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return D0(12, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return cK != 'e' ? D0(13, 0L, j3) : L(j3, 1L);
        } catch (java.io.IOException unused) {
            I0(13, 0L, j3);
            return 14;
        }
    }

    private final int H0(int i, long j, long j2) {
        int i2;
        switch (i) {
            case 0:
                if ((576460752303423456L & j) != 0) {
                    this.l = 61;
                    return 1;
                }
                if ((14 & j) != 0) {
                    return 52;
                }
                return ((j & (-4611686018427387904L)) == 0 && (3071 & j2) == 0) ? -1 : 30;
            case 1:
                if ((9007201167343616L & j) != 0) {
                    return 1;
                }
                if ((j & 567453551136079840L) == 0) {
                    return -1;
                }
                if (this.k != 1) {
                    this.l = 61;
                    this.k = 1;
                }
                return 1;
            case 2:
                if ((72972387913433088L & j) != 0) {
                    return 1;
                }
                if ((j & 494481163256201184L) == 0) {
                    return -1;
                }
                this.l = 61;
                i2 = 2;
                break;
            case 3:
                if ((144317513247817760L & j) != 0) {
                    return 1;
                }
                if ((j & 350163650008383424L) == 0) {
                    return -1;
                }
                if (this.k != 3) {
                    this.l = 61;
                    this.k = 3;
                }
                return 1;
            case 4:
                if ((289356276058554432L & j) != 0) {
                    return 1;
                }
                if ((j & 54051978803740544L) == 0) {
                    return -1;
                }
                if (this.k != 4) {
                    this.l = 61;
                    this.k = 4;
                }
                return 1;
            case 5:
                if ((4432473358336L & j) != 0) {
                    return 1;
                }
                if ((j & 54047546330382208L) == 0) {
                    return -1;
                }
                this.l = 61;
                i2 = 5;
                break;
            case 6:
                if ((36029638832619136L & j) == 0) {
                    return (j & 18017907497763072L) != 0 ? 1 : -1;
                }
                this.l = 61;
                i2 = 6;
                break;
            case 7:
                if ((j & 36028797018963968L) == 0) {
                    return (j & 841813655168L) != 0 ? 1 : -1;
                }
                this.l = 61;
                i2 = 7;
                break;
            case 8:
                return (j & 36028797018963968L) != 0 ? 1 : -1;
            default:
                return -1;
        }
        this.k = i2;
        return 1;
    }

    private int I(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return E0(12, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return cK != 'e' ? E0(13, 0L, j3) : M(j3, 1L);
        } catch (java.io.IOException unused) {
            J0(13, 0L, j3);
            return 14;
        }
    }

    private final int I0(int i, long j, long j2) {
        if (i != 0) {
            return -1;
        }
        if ((14 & j) != 0) {
            return 51;
        }
        return ((j & (-4611686018427387904L)) == 0 && (3071 & j2) == 0) ? -1 : 27;
    }

    private int J(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return F0(12, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return cK != 'e' ? F0(13, 0L, j3) : N(j3, 1L);
        } catch (java.io.IOException unused) {
            K0(13, 0L, j3);
            return 14;
        }
    }

    private final int J0(int i, long j, long j2) {
        if (i != 0) {
            return -1;
        }
        if (((-4611686018427387904L) & j) == 0 && (j2 & 3071) == 0) {
            return (j & 14) != 0 ? 51 : -1;
        }
        return 26;
    }

    private int K(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return C0(13, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return (cK == 'd' && (1 & j3) != 0) ? G0(15, 64) : C0(14, 0L, j3);
        } catch (java.io.IOException unused) {
            H0(14, 0L, j3);
            return 15;
        }
    }

    private final int K0(int i, long j, long j2) {
        if (i != 0) {
            return -1;
        }
        if (((-4611686018427387904L) & j) == 0 && (j2 & 3071) == 0) {
            return (j & 14) != 0 ? 50 : -1;
        }
        return 28;
    }

    private int L(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return D0(13, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return (cK == 'd' && (1 & j3) != 0) ? G0(15, 64) : D0(14, 0L, j3);
        } catch (java.io.IOException unused) {
            I0(14, 0L, j3);
            return 15;
        }
    }

    private int M(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return E0(13, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return (cK == 'd' && (1 & j3) != 0) ? G0(15, 64) : E0(14, 0L, j3);
        } catch (java.io.IOException unused) {
            J0(14, 0L, j3);
            return 15;
        }
    }

    private int N(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return F0(13, 0L, j);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            return (cK == 'd' && (1 & j3) != 0) ? G0(15, 64) : F0(14, 0L, j3);
        } catch (java.io.IOException unused) {
            K0(14, 0L, j3);
            return 15;
        }
    }

    private int O(long j, long j2) {
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != '.') {
                if (cK == 'A') {
                    return S(j, 39608188403712L, j2, 0L);
                }
                if (cK == 'X') {
                    return S(j, 140737488355328L, j2, 0L);
                }
                if (cK == 'a') {
                    return S(j, 288230376151711744L, j2, 0L);
                }
                if (cK == 'i') {
                    return S(j, 72057594037927936L, j2, 4L);
                }
                if (cK == 'u') {
                    return S(j, 0L, j2, 16L);
                }
                if (cK == 'H') {
                    return S(j, 844424930131968L, j2, 0L);
                }
                if (cK == 'I') {
                    return S(j, 1048576L, j2, 0L);
                }
                if (cK != 'T') {
                    if (cK == 'U') {
                        return S(j, 2251799814471680L, j2, 0L);
                    }
                    if (cK == 'e') {
                        return S(j, 0L, j2, 640L);
                    }
                    if (cK == 'f') {
                        return S(j, 0L, j2, 256L);
                    }
                    if (cK == 'r') {
                        return S(j, 144115188075855872L, j2, 0L);
                    }
                    if (cK == 's') {
                        return S(j, 4611686018427387904L, j2, 0L);
                    }
                    switch (cK) {
                        case 'D':
                            return S(j, 8796093153280L, j2, 0L);
                        case 'E':
                            if ((1073741824 & j) != 0) {
                                this.l = 30;
                                this.k = 1;
                            }
                            return S(j, 18015538856984064L, j2, 0L);
                        case 'F':
                            return S(j, 824633720832L, j2, 0L);
                        default:
                            switch (cK) {
                                case 'K':
                                    return S(j, 36028797018963968L, j2, 0L);
                                case 'L':
                                    return S(j, 2199023255552L, j2, 0L);
                                case 'M':
                                    return S(j, 134217728L, j2, 0L);
                                case 'N':
                                    return S(j, 17592194433024L, j2, 0L);
                                case 'O':
                                    return S(j, 5700074526999008L, j2, 0L);
                                case 'P':
                                    if ((9007199254740992L & j) != 0) {
                                        return y0(1, 53, 1);
                                    }
                                    break;
                                case 'Q':
                                    if ((268435456 & j) != 0) {
                                        return y0(1, 28, 1);
                                    }
                                    break;
                                default:
                                    switch (cK) {
                                        case 'l':
                                            return S(j, Long.MIN_VALUE, j2, 97L);
                                        case 'm':
                                            return S(j, 0L, j2, 8L);
                                        case 'n':
                                            return S(j, 0L, j2, 2L);
                                    }
                            }
                            break;
                    }
                } else if ((536870912 & j) != 0) {
                    return y0(1, 29, 1);
                }
            } else if ((2048 & j2) != 0) {
                return G0(1, 75);
            }
            return C0(0, j, j2);
        } catch (java.io.IOException unused) {
            H0(0, j, j2);
            return 1;
        }
    }

    private int P(long j, long j2) {
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != '.') {
                if (cK == 'A') {
                    return T(j, 39608188403712L, j2, 0L);
                }
                if (cK == 'X') {
                    return T(j, 140737488355328L, j2, 0L);
                }
                if (cK == 'a') {
                    return T(j, 288230376151711744L, j2, 0L);
                }
                if (cK == 'i') {
                    return T(j, 72057594037927936L, j2, 4L);
                }
                if (cK == 'u') {
                    return T(j, 0L, j2, 16L);
                }
                if (cK == 'H') {
                    return T(j, 844424930131968L, j2, 0L);
                }
                if (cK == 'I') {
                    return T(j, 1048576L, j2, 0L);
                }
                if (cK != 'T') {
                    if (cK == 'U') {
                        return T(j, 2251799814471680L, j2, 0L);
                    }
                    if (cK == 'e') {
                        return T(j, 0L, j2, 640L);
                    }
                    if (cK == 'f') {
                        return T(j, 0L, j2, 256L);
                    }
                    if (cK == 'r') {
                        return T(j, 144115188075855872L, j2, 0L);
                    }
                    if (cK == 's') {
                        return T(j, 4611686018427387904L, j2, 0L);
                    }
                    switch (cK) {
                        case 'D':
                            return T(j, 8796093153280L, j2, 0L);
                        case 'E':
                            if ((1073741824 & j) != 0) {
                                this.l = 30;
                                this.k = 1;
                            }
                            return T(j, 18015538856984064L, j2, 0L);
                        case 'F':
                            return T(j, 824633720832L, j2, 0L);
                        default:
                            switch (cK) {
                                case 'K':
                                    return T(j, 36028797018963968L, j2, 0L);
                                case 'L':
                                    return T(j, 2199023255552L, j2, 0L);
                                case 'M':
                                    return T(j, 134217728L, j2, 0L);
                                case 'N':
                                    return T(j, 17592194433024L, j2, 0L);
                                case 'O':
                                    return T(j, 5700074526999008L, j2, 0L);
                                case 'P':
                                    if ((9007199254740992L & j) != 0) {
                                        return G0(1, 53);
                                    }
                                    break;
                                case 'Q':
                                    if ((268435456 & j) != 0) {
                                        return G0(1, 28);
                                    }
                                    break;
                                default:
                                    switch (cK) {
                                        case 'l':
                                            return T(j, Long.MIN_VALUE, j2, 97L);
                                        case 'm':
                                            return T(j, 0L, j2, 8L);
                                        case 'n':
                                            return T(j, 0L, j2, 2L);
                                    }
                            }
                            break;
                    }
                } else if ((536870912 & j) != 0) {
                    return G0(1, 29);
                }
            } else if ((2048 & j2) != 0) {
                return G0(1, 75);
            }
            return D0(0, j, j2);
        } catch (java.io.IOException unused) {
            I0(0, j, j2);
            return 1;
        }
    }

    private int Q(long j, long j2) {
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != '.') {
                if (cK == 'A') {
                    return U(j, 39608188403712L, j2, 0L);
                }
                if (cK == 'X') {
                    return U(j, 140737488355328L, j2, 0L);
                }
                if (cK == 'a') {
                    return U(j, 288230376151711744L, j2, 0L);
                }
                if (cK == 'i') {
                    return U(j, 72057594037927936L, j2, 4L);
                }
                if (cK == 'u') {
                    return U(j, 0L, j2, 16L);
                }
                if (cK == 'H') {
                    return U(j, 844424930131968L, j2, 0L);
                }
                if (cK == 'I') {
                    return U(j, 1048576L, j2, 0L);
                }
                if (cK != 'T') {
                    if (cK == 'U') {
                        return U(j, 2251799814471680L, j2, 0L);
                    }
                    if (cK == 'e') {
                        return U(j, 0L, j2, 640L);
                    }
                    if (cK == 'f') {
                        return U(j, 0L, j2, 256L);
                    }
                    if (cK == 'r') {
                        return U(j, 144115188075855872L, j2, 0L);
                    }
                    if (cK == 's') {
                        return U(j, 4611686018427387904L, j2, 0L);
                    }
                    switch (cK) {
                        case 'D':
                            return U(j, 8796093153280L, j2, 0L);
                        case 'E':
                            if ((1073741824 & j) != 0) {
                                this.l = 30;
                                this.k = 1;
                            }
                            return U(j, 18015538856984064L, j2, 0L);
                        case 'F':
                            return U(j, 824633720832L, j2, 0L);
                        default:
                            switch (cK) {
                                case 'K':
                                    return U(j, 36028797018963968L, j2, 0L);
                                case 'L':
                                    return U(j, 2199023255552L, j2, 0L);
                                case 'M':
                                    return U(j, 134217728L, j2, 0L);
                                case 'N':
                                    return U(j, 17592194433024L, j2, 0L);
                                case 'O':
                                    return U(j, 5700074526999008L, j2, 0L);
                                case 'P':
                                    if ((9007199254740992L & j) != 0) {
                                        return G0(1, 53);
                                    }
                                    break;
                                case 'Q':
                                    if ((268435456 & j) != 0) {
                                        return G0(1, 28);
                                    }
                                    break;
                                default:
                                    switch (cK) {
                                        case 'l':
                                            return U(j, Long.MIN_VALUE, j2, 97L);
                                        case 'm':
                                            return U(j, 0L, j2, 8L);
                                        case 'n':
                                            return U(j, 0L, j2, 2L);
                                    }
                            }
                            break;
                    }
                } else if ((536870912 & j) != 0) {
                    return G0(1, 29);
                }
            } else if ((2048 & j2) != 0) {
                return G0(1, 75);
            }
            return E0(0, j, j2);
        } catch (java.io.IOException unused) {
            J0(0, j, j2);
            return 1;
        }
    }

    private int R(long j, long j2) {
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != '.') {
                if (cK == 'A') {
                    return V(j, 39608188403712L, j2, 0L);
                }
                if (cK == 'X') {
                    return V(j, 140737488355328L, j2, 0L);
                }
                if (cK == 'a') {
                    return V(j, 288230376151711744L, j2, 0L);
                }
                if (cK == 'i') {
                    return V(j, 72057594037927936L, j2, 4L);
                }
                if (cK == 'u') {
                    return V(j, 0L, j2, 16L);
                }
                if (cK == 'H') {
                    return V(j, 844424930131968L, j2, 0L);
                }
                if (cK == 'I') {
                    return V(j, 1048576L, j2, 0L);
                }
                if (cK != 'T') {
                    if (cK == 'U') {
                        return V(j, 2251799814471680L, j2, 0L);
                    }
                    if (cK == 'e') {
                        return V(j, 0L, j2, 640L);
                    }
                    if (cK == 'f') {
                        return V(j, 0L, j2, 256L);
                    }
                    if (cK == 'r') {
                        return V(j, 144115188075855872L, j2, 0L);
                    }
                    if (cK == 's') {
                        return V(j, 4611686018427387904L, j2, 0L);
                    }
                    switch (cK) {
                        case 'D':
                            return V(j, 8796093153280L, j2, 0L);
                        case 'E':
                            if ((1073741824 & j) != 0) {
                                this.l = 30;
                                this.k = 1;
                            }
                            return V(j, 18015538856984064L, j2, 0L);
                        case 'F':
                            return V(j, 824633720832L, j2, 0L);
                        default:
                            switch (cK) {
                                case 'K':
                                    return V(j, 36028797018963968L, j2, 0L);
                                case 'L':
                                    return V(j, 2199023255552L, j2, 0L);
                                case 'M':
                                    return V(j, 134217728L, j2, 0L);
                                case 'N':
                                    return V(j, 17592194433024L, j2, 0L);
                                case 'O':
                                    return V(j, 5700074526999008L, j2, 0L);
                                case 'P':
                                    if ((9007199254740992L & j) != 0) {
                                        return G0(1, 53);
                                    }
                                    break;
                                case 'Q':
                                    if ((268435456 & j) != 0) {
                                        return G0(1, 28);
                                    }
                                    break;
                                default:
                                    switch (cK) {
                                        case 'l':
                                            return V(j, Long.MIN_VALUE, j2, 97L);
                                        case 'm':
                                            return V(j, 0L, j2, 8L);
                                        case 'n':
                                            return V(j, 0L, j2, 2L);
                                    }
                            }
                            break;
                    }
                } else if ((536870912 & j) != 0) {
                    return G0(1, 29);
                }
            } else if ((2048 & j2) != 0) {
                return G0(1, 75);
            }
            return F0(0, j, j2);
        } catch (java.io.IOException unused) {
            K0(0, j, j2);
            return 1;
        }
    }

    private int S(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return C0(0, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return W(j5, 448L, j6, 0L);
            }
            if (cK != 'B') {
                if (cK != 'D') {
                    if (cK == 'I') {
                        return W(j5, 36037610291855360L, j6, 0L);
                    }
                    if (cK == 'a') {
                        return W(j5, 0L, j6, 9L);
                    }
                    if (cK == 'i') {
                        return W(j5, Long.MIN_VALUE, j6, 32L);
                    }
                    if (cK == 'l') {
                        return (72057594037927936L & j5) != 0 ? y0(2, 56, 1) : W(j5, 288230376151711744L, j6, 0L);
                    }
                    if (cK == 's') {
                        return W(j5, 0L, j6, 4L);
                    }
                    if (cK == 'u') {
                        return W(j5, 144115188075855872L, j6, 258L);
                    }
                    if (cK == 'V') {
                        return (1048576 & j5) != 0 ? y0(2, 20, 1) : W(j5, 32L, j6, 0L);
                    }
                    if (cK == 'W') {
                        return (4194304 & j5) != 0 ? y0(2, 22, 1) : W(j5, 32768L, j6, 0L);
                    }
                    switch (cK) {
                        case 'L':
                            if ((524288 & j5) != 0) {
                                return y0(2, 19, 1);
                            }
                            return (281474976710656L & j5) != 0 ? y0(2, 48, 1) : W(j5, 8590000128L, j6, 0L);
                        case 'M':
                            if ((8388608 & j5) != 0) {
                                return y0(2, 23, 1);
                            }
                            break;
                        case 'N':
                            return (33554432 & j5) != 0 ? y0(2, 25, 1) : W(j5, 3412884159725568L, j6, 0L);
                        case 'O':
                            return W(j5, 161353331376128L, j6, 0L);
                        case 'P':
                            if ((134217728 & j5) != 0) {
                                return y0(2, 27, 1);
                            }
                            break;
                        default:
                            switch (cK) {
                                case 'R':
                                    if ((70368744177664L & j5) != 0) {
                                        return y0(2, 46, 1);
                                    }
                                    return (562949953421312L & j5) != 0 ? y0(2, 49, 1) : W(j5, 4604204941312L, j6, 0L);
                                case 'S':
                                    return W(j5, 6442450944L, j6, 0L);
                                case 'T':
                                    return (16777216 & j5) != 0 ? y0(2, 24, 1) : W(j5, 22519132008250880L, j6, 0L);
                                default:
                                    switch (cK) {
                                        case 'n':
                                            return W(j5, 0L, j6, 640L);
                                        case 'o':
                                            return W(j5, 4611686018427387904L, j6, 64L);
                                        case 'p':
                                            return W(j5, 0L, j6, 16L);
                                    }
                            }
                    }
                } else {
                    if ((131072 & j5) != 0) {
                        return y0(2, 17, 1);
                    }
                    if ((2097152 & j5) != 0) {
                        return y0(2, 21, 1);
                    }
                }
            } else if ((262144 & j5) != 0) {
                return y0(2, 18, 1);
            }
            return C0(1, j5, j6);
        } catch (java.io.IOException unused) {
            H0(1, j5, j6);
            return 2;
        }
    }

    private int T(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return D0(0, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return X(j5, 448L, j6, 0L);
            }
            if (cK != 'B') {
                if (cK != 'D') {
                    if (cK == 'I') {
                        return X(j5, 36037610291855360L, j6, 0L);
                    }
                    if (cK == 'a') {
                        return X(j5, 0L, j6, 9L);
                    }
                    if (cK == 'i') {
                        return X(j5, Long.MIN_VALUE, j6, 32L);
                    }
                    if (cK == 'l') {
                        return (72057594037927936L & j5) != 0 ? G0(2, 56) : X(j5, 288230376151711744L, j6, 0L);
                    }
                    if (cK == 's') {
                        return X(j5, 0L, j6, 4L);
                    }
                    if (cK == 'u') {
                        return X(j5, 144115188075855872L, j6, 258L);
                    }
                    if (cK == 'V') {
                        return (1048576 & j5) != 0 ? G0(2, 20) : X(j5, 32L, j6, 0L);
                    }
                    if (cK == 'W') {
                        return (4194304 & j5) != 0 ? G0(2, 22) : X(j5, 32768L, j6, 0L);
                    }
                    switch (cK) {
                        case 'L':
                            if ((524288 & j5) != 0) {
                                return G0(2, 19);
                            }
                            return (281474976710656L & j5) != 0 ? G0(2, 48) : X(j5, 8590000128L, j6, 0L);
                        case 'M':
                            if ((8388608 & j5) != 0) {
                                return G0(2, 23);
                            }
                            break;
                        case 'N':
                            return (33554432 & j5) != 0 ? G0(2, 25) : X(j5, 3412884159725568L, j6, 0L);
                        case 'O':
                            return X(j5, 161353331376128L, j6, 0L);
                        case 'P':
                            if ((134217728 & j5) != 0) {
                                return G0(2, 27);
                            }
                            break;
                        default:
                            switch (cK) {
                                case 'R':
                                    if ((70368744177664L & j5) != 0) {
                                        return G0(2, 46);
                                    }
                                    return (562949953421312L & j5) != 0 ? G0(2, 49) : X(j5, 4604204941312L, j6, 0L);
                                case 'S':
                                    return X(j5, 6442450944L, j6, 0L);
                                case 'T':
                                    return (16777216 & j5) != 0 ? G0(2, 24) : X(j5, 22519132008250880L, j6, 0L);
                                default:
                                    switch (cK) {
                                        case 'n':
                                            return X(j5, 0L, j6, 640L);
                                        case 'o':
                                            return X(j5, 4611686018427387904L, j6, 64L);
                                        case 'p':
                                            return X(j5, 0L, j6, 16L);
                                    }
                            }
                    }
                } else {
                    if ((131072 & j5) != 0) {
                        return G0(2, 17);
                    }
                    if ((2097152 & j5) != 0) {
                        return G0(2, 21);
                    }
                }
            } else if ((262144 & j5) != 0) {
                return G0(2, 18);
            }
            return D0(1, j5, j6);
        } catch (java.io.IOException unused) {
            I0(1, j5, j6);
            return 2;
        }
    }

    private int U(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return E0(0, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return Y(j5, 448L, j6, 0L);
            }
            if (cK != 'B') {
                if (cK != 'D') {
                    if (cK == 'I') {
                        return Y(j5, 36037610291855360L, j6, 0L);
                    }
                    if (cK == 'a') {
                        return Y(j5, 0L, j6, 9L);
                    }
                    if (cK == 'i') {
                        return Y(j5, Long.MIN_VALUE, j6, 32L);
                    }
                    if (cK == 'l') {
                        return (72057594037927936L & j5) != 0 ? G0(2, 56) : Y(j5, 288230376151711744L, j6, 0L);
                    }
                    if (cK == 's') {
                        return Y(j5, 0L, j6, 4L);
                    }
                    if (cK == 'u') {
                        return Y(j5, 144115188075855872L, j6, 258L);
                    }
                    if (cK == 'V') {
                        return (1048576 & j5) != 0 ? G0(2, 20) : Y(j5, 32L, j6, 0L);
                    }
                    if (cK == 'W') {
                        return (4194304 & j5) != 0 ? G0(2, 22) : Y(j5, 32768L, j6, 0L);
                    }
                    switch (cK) {
                        case 'L':
                            if ((524288 & j5) != 0) {
                                return G0(2, 19);
                            }
                            return (281474976710656L & j5) != 0 ? G0(2, 48) : Y(j5, 8590000128L, j6, 0L);
                        case 'M':
                            if ((8388608 & j5) != 0) {
                                return G0(2, 23);
                            }
                            break;
                        case 'N':
                            return (33554432 & j5) != 0 ? G0(2, 25) : Y(j5, 3412884159725568L, j6, 0L);
                        case 'O':
                            return Y(j5, 161353331376128L, j6, 0L);
                        case 'P':
                            if ((134217728 & j5) != 0) {
                                return G0(2, 27);
                            }
                            break;
                        default:
                            switch (cK) {
                                case 'R':
                                    if ((70368744177664L & j5) != 0) {
                                        return G0(2, 46);
                                    }
                                    return (562949953421312L & j5) != 0 ? G0(2, 49) : Y(j5, 4604204941312L, j6, 0L);
                                case 'S':
                                    return Y(j5, 6442450944L, j6, 0L);
                                case 'T':
                                    return (16777216 & j5) != 0 ? G0(2, 24) : Y(j5, 22519132008250880L, j6, 0L);
                                default:
                                    switch (cK) {
                                        case 'n':
                                            return Y(j5, 0L, j6, 640L);
                                        case 'o':
                                            return Y(j5, 4611686018427387904L, j6, 64L);
                                        case 'p':
                                            return Y(j5, 0L, j6, 16L);
                                    }
                            }
                    }
                } else {
                    if ((131072 & j5) != 0) {
                        return G0(2, 17);
                    }
                    if ((2097152 & j5) != 0) {
                        return G0(2, 21);
                    }
                }
            } else if ((262144 & j5) != 0) {
                return G0(2, 18);
            }
            return E0(1, j5, j6);
        } catch (java.io.IOException unused) {
            J0(1, j5, j6);
            return 2;
        }
    }

    private int V(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return F0(0, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return Z(j5, 448L, j6, 0L);
            }
            if (cK != 'B') {
                if (cK != 'D') {
                    if (cK == 'I') {
                        return Z(j5, 36037610291855360L, j6, 0L);
                    }
                    if (cK == 'a') {
                        return Z(j5, 0L, j6, 9L);
                    }
                    if (cK == 'i') {
                        return Z(j5, Long.MIN_VALUE, j6, 32L);
                    }
                    if (cK == 'l') {
                        return (72057594037927936L & j5) != 0 ? G0(2, 56) : Z(j5, 288230376151711744L, j6, 0L);
                    }
                    if (cK == 's') {
                        return Z(j5, 0L, j6, 4L);
                    }
                    if (cK == 'u') {
                        return Z(j5, 144115188075855872L, j6, 258L);
                    }
                    if (cK == 'V') {
                        return (1048576 & j5) != 0 ? G0(2, 20) : Z(j5, 32L, j6, 0L);
                    }
                    if (cK == 'W') {
                        return (4194304 & j5) != 0 ? G0(2, 22) : Z(j5, 32768L, j6, 0L);
                    }
                    switch (cK) {
                        case 'L':
                            if ((524288 & j5) != 0) {
                                return G0(2, 19);
                            }
                            return (281474976710656L & j5) != 0 ? G0(2, 48) : Z(j5, 8590000128L, j6, 0L);
                        case 'M':
                            if ((8388608 & j5) != 0) {
                                return G0(2, 23);
                            }
                            break;
                        case 'N':
                            return (33554432 & j5) != 0 ? G0(2, 25) : Z(j5, 3412884159725568L, j6, 0L);
                        case 'O':
                            return Z(j5, 161353331376128L, j6, 0L);
                        case 'P':
                            if ((134217728 & j5) != 0) {
                                return G0(2, 27);
                            }
                            break;
                        default:
                            switch (cK) {
                                case 'R':
                                    if ((70368744177664L & j5) != 0) {
                                        return G0(2, 46);
                                    }
                                    return (562949953421312L & j5) != 0 ? G0(2, 49) : Z(j5, 4604204941312L, j6, 0L);
                                case 'S':
                                    return Z(j5, 6442450944L, j6, 0L);
                                case 'T':
                                    return (16777216 & j5) != 0 ? G0(2, 24) : Z(j5, 22519132008250880L, j6, 0L);
                                default:
                                    switch (cK) {
                                        case 'n':
                                            return Z(j5, 0L, j6, 640L);
                                        case 'o':
                                            return Z(j5, 4611686018427387904L, j6, 64L);
                                        case 'p':
                                            return Z(j5, 0L, j6, 16L);
                                    }
                            }
                    }
                } else {
                    if ((131072 & j5) != 0) {
                        return G0(2, 17);
                    }
                    if ((2097152 & j5) != 0) {
                        return G0(2, 21);
                    }
                }
            } else if ((262144 & j5) != 0) {
                return G0(2, 18);
            }
            return F0(1, j5, j6);
        } catch (java.io.IOException unused) {
            K0(1, j5, j6);
            return 2;
        }
    }

    private int W(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return C0(1, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return a0(j5, 4398046511104L, j6, 0L);
            }
            if (cK == 'L') {
                return (8589934592L & j5) != 0 ? y0(3, 33, 1) : a0(j5, 1185410973696L, j6, 0L);
            }
            if (cK == '_') {
                return a0(j5, 18014398509481984L, j6, 4L);
            }
            if (cK == 's') {
                return a0(j5, 288230376151711744L, j6, 1L);
            }
            if (cK == 'x') {
                return a0(j5, 0L, j6, 8L);
            }
            if (cK == 'O') {
                return a0(j5, 4503599627370496L, j6, 0L);
            }
            if (cK == 'P') {
                return a0(j5, 36028934457917440L, j6, 0L);
            }
            if (cK == 'm') {
                return a0(j5, 0L, j6, 2L);
            }
            if (cK == 'n') {
                return a0(j5, Long.MIN_VALUE, j6, 288L);
            }
            if (cK == 'u') {
                return a0(j5, 4611686018427387904L, j6, 0L);
            }
            if (cK == 'v') {
                return a0(j5, 0L, j6, 16L);
            }
            switch (cK) {
                case 'C':
                    return a0(j5, 2251799880794112L, j6, 0L);
                case 'D':
                    return (35184372088832L & j5) != 0 ? y0(3, 45, 1) : a0(j5, 448L, j6, 0L);
                case 'E':
                    if ((32 & j5) != 0) {
                        return y0(3, 5, 1);
                    }
                    break;
                case 'F':
                    if ((65536 & j5) != 0) {
                        return y0(3, 16, 1);
                    }
                    break;
                default:
                    switch (cK) {
                        case 'R':
                            return (140737488355328L & j5) != 0 ? y0(3, 47, 1) : a0(j5, 824633720832L, j6, 0L);
                        case 'S':
                            return a0(j5, 1128098930098176L, j6, 0L);
                        case 'T':
                            if ((2147483648L & j5) != 0) {
                                this.l = 31;
                                this.k = 3;
                            } else if ((17592186044416L & j5) != 0) {
                                return y0(3, 44, 1);
                            }
                            return a0(j5, 4295023616L, j6, 0L);
                        case 'U':
                            return a0(j5, 34359747072L, j6, 0L);
                        case 'V':
                            if ((8796093022208L & j5) != 0) {
                                return y0(3, 43, 1);
                            }
                            break;
                        default:
                            switch (cK) {
                                case 'c':
                                    return a0(j5, 0L, j6, 64L);
                                case 'd':
                                    if ((512 & j6) != 0) {
                                        this.l = 73;
                                        this.k = 3;
                                    }
                                    return a0(j5, 0L, j6, 128L);
                                case 'e':
                                    if ((144115188075855872L & j5) != 0) {
                                        return y0(3, 57, 1);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
            return C0(2, j5, j6);
        } catch (java.io.IOException unused) {
            H0(2, j5, j6);
            return 3;
        }
    }

    private int X(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return D0(1, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return b0(j5, 4398046511104L, j6, 0L);
            }
            if (cK == 'L') {
                return (8589934592L & j5) != 0 ? G0(3, 33) : b0(j5, 1185410973696L, j6, 0L);
            }
            if (cK == '_') {
                return b0(j5, 18014398509481984L, j6, 4L);
            }
            if (cK == 's') {
                return b0(j5, 288230376151711744L, j6, 1L);
            }
            if (cK == 'x') {
                return b0(j5, 0L, j6, 8L);
            }
            if (cK == 'O') {
                return b0(j5, 4503599627370496L, j6, 0L);
            }
            if (cK == 'P') {
                return b0(j5, 36028934457917440L, j6, 0L);
            }
            if (cK == 'm') {
                return b0(j5, 0L, j6, 2L);
            }
            if (cK == 'n') {
                return b0(j5, Long.MIN_VALUE, j6, 288L);
            }
            if (cK == 'u') {
                return b0(j5, 4611686018427387904L, j6, 0L);
            }
            if (cK == 'v') {
                return b0(j5, 0L, j6, 16L);
            }
            switch (cK) {
                case 'C':
                    return b0(j5, 2251799880794112L, j6, 0L);
                case 'D':
                    return (35184372088832L & j5) != 0 ? G0(3, 45) : b0(j5, 448L, j6, 0L);
                case 'E':
                    if ((32 & j5) != 0) {
                        return G0(3, 5);
                    }
                    break;
                case 'F':
                    if ((65536 & j5) != 0) {
                        return G0(3, 16);
                    }
                    break;
                default:
                    switch (cK) {
                        case 'R':
                            return (140737488355328L & j5) != 0 ? G0(3, 47) : b0(j5, 824633720832L, j6, 0L);
                        case 'S':
                            return b0(j5, 1128098930098176L, j6, 0L);
                        case 'T':
                            if ((2147483648L & j5) != 0) {
                                this.l = 31;
                                this.k = 3;
                            } else if ((17592186044416L & j5) != 0) {
                                return G0(3, 44);
                            }
                            return b0(j5, 4295023616L, j6, 0L);
                        case 'U':
                            return b0(j5, 34359747072L, j6, 0L);
                        case 'V':
                            if ((8796093022208L & j5) != 0) {
                                return G0(3, 43);
                            }
                            break;
                        default:
                            switch (cK) {
                                case 'c':
                                    return b0(j5, 0L, j6, 64L);
                                case 'd':
                                    if ((512 & j6) != 0) {
                                        this.l = 73;
                                        this.k = 3;
                                    }
                                    return b0(j5, 0L, j6, 128L);
                                case 'e':
                                    if ((144115188075855872L & j5) != 0) {
                                        return G0(3, 57);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
            return D0(2, j5, j6);
        } catch (java.io.IOException unused) {
            I0(2, j5, j6);
            return 3;
        }
    }

    private int Y(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return E0(1, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return c0(j5, 4398046511104L, j6, 0L);
            }
            if (cK == 'L') {
                return (8589934592L & j5) != 0 ? G0(3, 33) : c0(j5, 1185410973696L, j6, 0L);
            }
            if (cK == '_') {
                return c0(j5, 18014398509481984L, j6, 4L);
            }
            if (cK == 's') {
                return c0(j5, 288230376151711744L, j6, 1L);
            }
            if (cK == 'x') {
                return c0(j5, 0L, j6, 8L);
            }
            if (cK == 'O') {
                return c0(j5, 4503599627370496L, j6, 0L);
            }
            if (cK == 'P') {
                return c0(j5, 36028934457917440L, j6, 0L);
            }
            if (cK == 'm') {
                return c0(j5, 0L, j6, 2L);
            }
            if (cK == 'n') {
                return c0(j5, Long.MIN_VALUE, j6, 288L);
            }
            if (cK == 'u') {
                return c0(j5, 4611686018427387904L, j6, 0L);
            }
            if (cK == 'v') {
                return c0(j5, 0L, j6, 16L);
            }
            switch (cK) {
                case 'C':
                    return c0(j5, 2251799880794112L, j6, 0L);
                case 'D':
                    return (35184372088832L & j5) != 0 ? G0(3, 45) : c0(j5, 448L, j6, 0L);
                case 'E':
                    if ((32 & j5) != 0) {
                        return G0(3, 5);
                    }
                    break;
                case 'F':
                    if ((65536 & j5) != 0) {
                        return G0(3, 16);
                    }
                    break;
                default:
                    switch (cK) {
                        case 'R':
                            return (140737488355328L & j5) != 0 ? G0(3, 47) : c0(j5, 824633720832L, j6, 0L);
                        case 'S':
                            return c0(j5, 1128098930098176L, j6, 0L);
                        case 'T':
                            if ((2147483648L & j5) != 0) {
                                this.l = 31;
                                this.k = 3;
                            } else if ((17592186044416L & j5) != 0) {
                                return G0(3, 44);
                            }
                            return c0(j5, 4295023616L, j6, 0L);
                        case 'U':
                            return c0(j5, 34359747072L, j6, 0L);
                        case 'V':
                            if ((8796093022208L & j5) != 0) {
                                return G0(3, 43);
                            }
                            break;
                        default:
                            switch (cK) {
                                case 'c':
                                    return c0(j5, 0L, j6, 64L);
                                case 'd':
                                    if ((512 & j6) != 0) {
                                        this.l = 73;
                                        this.k = 3;
                                    }
                                    return c0(j5, 0L, j6, 128L);
                                case 'e':
                                    if ((144115188075855872L & j5) != 0) {
                                        return G0(3, 57);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
            return E0(2, j5, j6);
        } catch (java.io.IOException unused) {
            J0(2, j5, j6);
            return 3;
        }
    }

    private int Z(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return F0(1, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return d0(j5, 4398046511104L, j6, 0L);
            }
            if (cK == 'L') {
                return (8589934592L & j5) != 0 ? G0(3, 33) : d0(j5, 1185410973696L, j6, 0L);
            }
            if (cK == '_') {
                return d0(j5, 18014398509481984L, j6, 4L);
            }
            if (cK == 's') {
                return d0(j5, 288230376151711744L, j6, 1L);
            }
            if (cK == 'x') {
                return d0(j5, 0L, j6, 8L);
            }
            if (cK == 'O') {
                return d0(j5, 4503599627370496L, j6, 0L);
            }
            if (cK == 'P') {
                return d0(j5, 36028934457917440L, j6, 0L);
            }
            if (cK == 'm') {
                return d0(j5, 0L, j6, 2L);
            }
            if (cK == 'n') {
                return d0(j5, Long.MIN_VALUE, j6, 288L);
            }
            if (cK == 'u') {
                return d0(j5, 4611686018427387904L, j6, 0L);
            }
            if (cK == 'v') {
                return d0(j5, 0L, j6, 16L);
            }
            switch (cK) {
                case 'C':
                    return d0(j5, 2251799880794112L, j6, 0L);
                case 'D':
                    return (35184372088832L & j5) != 0 ? G0(3, 45) : d0(j5, 448L, j6, 0L);
                case 'E':
                    if ((32 & j5) != 0) {
                        return G0(3, 5);
                    }
                    break;
                case 'F':
                    if ((65536 & j5) != 0) {
                        return G0(3, 16);
                    }
                    break;
                default:
                    switch (cK) {
                        case 'R':
                            return (140737488355328L & j5) != 0 ? G0(3, 47) : d0(j5, 824633720832L, j6, 0L);
                        case 'S':
                            return d0(j5, 1128098930098176L, j6, 0L);
                        case 'T':
                            if ((2147483648L & j5) != 0) {
                                this.l = 31;
                                this.k = 3;
                            } else if ((17592186044416L & j5) != 0) {
                                return G0(3, 44);
                            }
                            return d0(j5, 4295023616L, j6, 0L);
                        case 'U':
                            return d0(j5, 34359747072L, j6, 0L);
                        case 'V':
                            if ((8796093022208L & j5) != 0) {
                                return G0(3, 43);
                            }
                            break;
                        default:
                            switch (cK) {
                                case 'c':
                                    return d0(j5, 0L, j6, 64L);
                                case 'd':
                                    if ((512 & j6) != 0) {
                                        this.l = 73;
                                        this.k = 3;
                                    }
                                    return d0(j5, 0L, j6, 128L);
                                case 'e':
                                    if ((144115188075855872L & j5) != 0) {
                                        return G0(3, 57);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
            return F0(2, j5, j6);
        } catch (java.io.IOException unused) {
            K0(2, j5, j6);
            return 3;
        }
    }

    private void a() {
        this.j = -2147483647;
        int i = 52;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            this.f1531d[i2] = Integer.MIN_VALUE;
            i = i2;
        }
    }

    private int a0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return C0(2, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == ' ') {
                return e0(j5, 0L, j6, 128L);
            }
            if (cK == 'I') {
                return e0(j5, 1099511627776L, j6, 0L);
            }
            if (cK != '[') {
                if (cK == '_') {
                    return e0(j5, 36028797018963968L, j6, 0L);
                }
                if (cK == 'a') {
                    return e0(j5, 0L, j6, 80L);
                }
                if (cK != 'c') {
                    if (cK == 'e') {
                        if ((288230376151711744L & j5) != 0) {
                            return y0(4, 58, 1);
                        }
                        if ((32 & j6) != 0) {
                            this.l = 69;
                            this.k = 4;
                        }
                        return e0(j5, Long.MIN_VALUE, j6, 0L);
                    }
                    if (cK == 'p') {
                        return e0(j5, 0L, j6, 2L);
                    }
                    if (cK == 'v') {
                        return e0(j5, 0L, j6, 4L);
                    }
                    if (cK != 'K') {
                        if (cK == 'L') {
                            return e0(j5, 549755813888L, j6, 0L);
                        }
                        switch (cK) {
                            case 'A':
                                return e0(j5, 67165184L, j6, 0L);
                            case 'B':
                                return e0(j5, 128L, j6, 0L);
                            case 'C':
                                return e0(j5, 292057776128L, j6, 0L);
                            default:
                                switch (cK) {
                                    case 'N':
                                        return e0(j5, 256L, j6, 0L);
                                    case 'O':
                                        return e0(j5, 68719476736L, j6, 0L);
                                    case 'P':
                                        return e0(j5, 8704L, j6, 0L);
                                    default:
                                        switch (cK) {
                                            case 'R':
                                                return e0(j5, 4569845202944L, j6, 0L);
                                            case 'S':
                                                return e0(j5, 4294967296L, j6, 0L);
                                            case 'T':
                                                return (1125899906842624L & j5) != 0 ? y0(4, 50, 1) : e0(j5, 18014398509481984L, j6, 0L);
                                            case 'U':
                                                return e0(j5, 2199023255552L, j6, 0L);
                                            default:
                                                switch (cK) {
                                                    case 'r':
                                                        return e0(j5, 4611686018427387904L, j6, 0L);
                                                    case 's':
                                                        return e0(j5, 0L, j6, 8L);
                                                    case 't':
                                                        return e0(j5, 0L, j6, 1L);
                                                }
                                        }
                                }
                        }
                    }
                    if ((64 & j5) != 0) {
                        return y0(4, 6, 1);
                    }
                } else if ((256 & j6) != 0) {
                    return G0(4, 72);
                }
            } else {
                if ((2251799813685248L & j5) != 0) {
                    return G0(4, 51);
                }
                if ((4503599627370496L & j5) != 0) {
                    return G0(4, 52);
                }
            }
            return C0(3, j5, j6);
        } catch (java.io.IOException unused) {
            H0(3, j5, j6);
            return 4;
        }
    }

    private int b0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return D0(2, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == ' ') {
                return f0(j5, 0L, j6, 128L);
            }
            if (cK == 'I') {
                return f0(j5, 1099511627776L, j6, 0L);
            }
            if (cK != '[') {
                if (cK == '_') {
                    return f0(j5, 36028797018963968L, j6, 0L);
                }
                if (cK == 'a') {
                    return f0(j5, 0L, j6, 80L);
                }
                if (cK != 'c') {
                    if (cK == 'e') {
                        if ((288230376151711744L & j5) != 0) {
                            return G0(4, 58);
                        }
                        if ((32 & j6) != 0) {
                            this.l = 69;
                            this.k = 4;
                        }
                        return f0(j5, Long.MIN_VALUE, j6, 0L);
                    }
                    if (cK == 'p') {
                        return f0(j5, 0L, j6, 2L);
                    }
                    if (cK == 'v') {
                        return f0(j5, 0L, j6, 4L);
                    }
                    if (cK != 'K') {
                        if (cK == 'L') {
                            return f0(j5, 549755813888L, j6, 0L);
                        }
                        switch (cK) {
                            case 'A':
                                return f0(j5, 67165184L, j6, 0L);
                            case 'B':
                                return f0(j5, 128L, j6, 0L);
                            case 'C':
                                return f0(j5, 292057776128L, j6, 0L);
                            default:
                                switch (cK) {
                                    case 'N':
                                        return f0(j5, 256L, j6, 0L);
                                    case 'O':
                                        return f0(j5, 68719476736L, j6, 0L);
                                    case 'P':
                                        return f0(j5, 8704L, j6, 0L);
                                    default:
                                        switch (cK) {
                                            case 'R':
                                                return f0(j5, 4569845202944L, j6, 0L);
                                            case 'S':
                                                return f0(j5, 4294967296L, j6, 0L);
                                            case 'T':
                                                return (1125899906842624L & j5) != 0 ? G0(4, 50) : f0(j5, 18014398509481984L, j6, 0L);
                                            case 'U':
                                                return f0(j5, 2199023255552L, j6, 0L);
                                            default:
                                                switch (cK) {
                                                    case 'r':
                                                        return f0(j5, 4611686018427387904L, j6, 0L);
                                                    case 's':
                                                        return f0(j5, 0L, j6, 8L);
                                                    case 't':
                                                        return f0(j5, 0L, j6, 1L);
                                                }
                                        }
                                }
                        }
                    }
                    if ((64 & j5) != 0) {
                        return G0(4, 6);
                    }
                } else if ((256 & j6) != 0) {
                    return G0(4, 72);
                }
            } else {
                if ((2251799813685248L & j5) != 0) {
                    return G0(4, 51);
                }
                if ((4503599627370496L & j5) != 0) {
                    return G0(4, 52);
                }
            }
            return D0(3, j5, j6);
        } catch (java.io.IOException unused) {
            I0(3, j5, j6);
            return 4;
        }
    }

    private void c(int i, int i2) {
        while (true) {
            int[] iArr = this.f1532e;
            int i3 = this.i;
            this.i = i3 + 1;
            iArr[i3] = o[i];
            int i4 = i + 1;
            if (i == i2) {
                return;
            } else {
                i = i4;
            }
        }
    }

    private int c0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return E0(2, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == ' ') {
                return g0(j5, 0L, j6, 128L);
            }
            if (cK == 'I') {
                return g0(j5, 1099511627776L, j6, 0L);
            }
            if (cK != '[') {
                if (cK == '_') {
                    return g0(j5, 36028797018963968L, j6, 0L);
                }
                if (cK == 'a') {
                    return g0(j5, 0L, j6, 80L);
                }
                if (cK != 'c') {
                    if (cK == 'e') {
                        if ((288230376151711744L & j5) != 0) {
                            return G0(4, 58);
                        }
                        if ((32 & j6) != 0) {
                            this.l = 69;
                            this.k = 4;
                        }
                        return g0(j5, Long.MIN_VALUE, j6, 0L);
                    }
                    if (cK == 'p') {
                        return g0(j5, 0L, j6, 2L);
                    }
                    if (cK == 'v') {
                        return g0(j5, 0L, j6, 4L);
                    }
                    if (cK != 'K') {
                        if (cK == 'L') {
                            return g0(j5, 549755813888L, j6, 0L);
                        }
                        switch (cK) {
                            case 'A':
                                return g0(j5, 67165184L, j6, 0L);
                            case 'B':
                                return g0(j5, 128L, j6, 0L);
                            case 'C':
                                return g0(j5, 292057776128L, j6, 0L);
                            default:
                                switch (cK) {
                                    case 'N':
                                        return g0(j5, 256L, j6, 0L);
                                    case 'O':
                                        return g0(j5, 68719476736L, j6, 0L);
                                    case 'P':
                                        return g0(j5, 8704L, j6, 0L);
                                    default:
                                        switch (cK) {
                                            case 'R':
                                                return g0(j5, 4569845202944L, j6, 0L);
                                            case 'S':
                                                return g0(j5, 4294967296L, j6, 0L);
                                            case 'T':
                                                return (1125899906842624L & j5) != 0 ? G0(4, 50) : g0(j5, 18014398509481984L, j6, 0L);
                                            case 'U':
                                                return g0(j5, 2199023255552L, j6, 0L);
                                            default:
                                                switch (cK) {
                                                    case 'r':
                                                        return g0(j5, 4611686018427387904L, j6, 0L);
                                                    case 's':
                                                        return g0(j5, 0L, j6, 8L);
                                                    case 't':
                                                        return g0(j5, 0L, j6, 1L);
                                                }
                                        }
                                }
                        }
                    }
                    if ((64 & j5) != 0) {
                        return G0(4, 6);
                    }
                } else if ((256 & j6) != 0) {
                    return G0(4, 72);
                }
            } else {
                if ((2251799813685248L & j5) != 0) {
                    return G0(4, 51);
                }
                if ((4503599627370496L & j5) != 0) {
                    return G0(4, 52);
                }
            }
            return E0(3, j5, j6);
        } catch (java.io.IOException unused) {
            J0(3, j5, j6);
            return 4;
        }
    }

    private static final boolean d(int i, int i2, int i3, long j, long j2) {
        if (i != 0) {
            return (m[i2] & j) != 0;
        }
        return (n[i3] & j2) != 0;
    }

    private int d0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return F0(2, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == ' ') {
                return h0(j5, 0L, j6, 128L);
            }
            if (cK == 'I') {
                return h0(j5, 1099511627776L, j6, 0L);
            }
            if (cK != '[') {
                if (cK == '_') {
                    return h0(j5, 36028797018963968L, j6, 0L);
                }
                if (cK == 'a') {
                    return h0(j5, 0L, j6, 80L);
                }
                if (cK != 'c') {
                    if (cK == 'e') {
                        if ((288230376151711744L & j5) != 0) {
                            return G0(4, 58);
                        }
                        if ((32 & j6) != 0) {
                            this.l = 69;
                            this.k = 4;
                        }
                        return h0(j5, Long.MIN_VALUE, j6, 0L);
                    }
                    if (cK == 'p') {
                        return h0(j5, 0L, j6, 2L);
                    }
                    if (cK == 'v') {
                        return h0(j5, 0L, j6, 4L);
                    }
                    if (cK != 'K') {
                        if (cK == 'L') {
                            return h0(j5, 549755813888L, j6, 0L);
                        }
                        switch (cK) {
                            case 'A':
                                return h0(j5, 67165184L, j6, 0L);
                            case 'B':
                                return h0(j5, 128L, j6, 0L);
                            case 'C':
                                return h0(j5, 292057776128L, j6, 0L);
                            default:
                                switch (cK) {
                                    case 'N':
                                        return h0(j5, 256L, j6, 0L);
                                    case 'O':
                                        return h0(j5, 68719476736L, j6, 0L);
                                    case 'P':
                                        return h0(j5, 8704L, j6, 0L);
                                    default:
                                        switch (cK) {
                                            case 'R':
                                                return h0(j5, 4569845202944L, j6, 0L);
                                            case 'S':
                                                return h0(j5, 4294967296L, j6, 0L);
                                            case 'T':
                                                return (1125899906842624L & j5) != 0 ? G0(4, 50) : h0(j5, 18014398509481984L, j6, 0L);
                                            case 'U':
                                                return h0(j5, 2199023255552L, j6, 0L);
                                            default:
                                                switch (cK) {
                                                    case 'r':
                                                        return h0(j5, 4611686018427387904L, j6, 0L);
                                                    case 's':
                                                        return h0(j5, 0L, j6, 8L);
                                                    case 't':
                                                        return h0(j5, 0L, j6, 1L);
                                                }
                                        }
                                }
                        }
                    }
                    if ((64 & j5) != 0) {
                        return G0(4, 6);
                    }
                } else if ((256 & j6) != 0) {
                    return G0(4, 72);
                }
            } else {
                if ((2251799813685248L & j5) != 0) {
                    return G0(4, 51);
                }
                if ((4503599627370496L & j5) != 0) {
                    return G0(4, 52);
                }
            }
            return F0(3, j5, j6);
        } catch (java.io.IOException unused) {
            K0(3, j5, j6);
            return 4;
        }
    }

    private void e(int i) {
        int[] iArr = this.f1531d;
        int i2 = iArr[i];
        int i3 = this.j;
        if (i2 != i3) {
            int[] iArr2 = this.f1532e;
            int i4 = this.i;
            this.i = i4 + 1;
            iArr2[i4] = i;
            iArr[i] = i3;
        }
    }

    private int e0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return C0(3, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return i0(j5, 292057776128L, j6, 0L);
            }
            if (cK == 'B') {
                return i0(j5, 56320L, j6, 0L);
            }
            if (cK == 'E') {
                return i0(j5, 141733920768L, j6, 0L);
            }
            if (cK != 'G') {
                if (cK == 'I') {
                    return i0(j5, 256L, j6, 0L);
                }
                if (cK == 'V') {
                    return i0(j5, 8704L, j6, 0L);
                }
                if (cK == 'a') {
                    return i0(j5, 0L, j6, 6L);
                }
                if (cK == 'l') {
                    if ((16 & j6) != 0) {
                        return G0(5, 68);
                    }
                    return (64 & j6) != 0 ? G0(5, 70) : i0(j5, 0L, j6, 129L);
                }
                if (cK == 't') {
                    return i0(j5, 0L, j6, 8L);
                }
                if (cK == 'N') {
                    return (34359738368L & j5) != 0 ? y0(5, 35, 1) : i0(j5, 36028797018963968L, j6, 0L);
                }
                if (cK == 'O') {
                    return i0(j5, 18015016984772736L, j6, 0L);
                }
                if (cK == 'c') {
                    return i0(j5, 4611686018427387904L, j6, 0L);
                }
                if (cK == 'd') {
                    return i0(j5, Long.MIN_VALUE, j6, 0L);
                }
                switch (cK) {
                    case 'R':
                        return i0(j5, 2199023255552L, j6, 0L);
                    case 'S':
                        return i0(j5, 1099511627776L, j6, 0L);
                    case 'T':
                        if ((67108864 & j5) != 0) {
                            return y0(5, 26, 1);
                        }
                        break;
                }
            } else if ((4398046511104L & j5) != 0) {
                return y0(5, 42, 1);
            }
            return C0(4, j5, j6);
        } catch (java.io.IOException unused) {
            H0(4, j5, j6);
            return 5;
        }
    }

    private void f(int i, int i2) {
        while (true) {
            e(o[i]);
            int i3 = i + 1;
            if (i == i2) {
                return;
            } else {
                i = i3;
            }
        }
    }

    private int f0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return D0(3, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return j0(j5, 292057776128L, j6, 0L);
            }
            if (cK == 'B') {
                return j0(j5, 56320L, j6, 0L);
            }
            if (cK == 'E') {
                return j0(j5, 141733920768L, j6, 0L);
            }
            if (cK != 'G') {
                if (cK == 'I') {
                    return j0(j5, 256L, j6, 0L);
                }
                if (cK == 'V') {
                    return j0(j5, 8704L, j6, 0L);
                }
                if (cK == 'a') {
                    return j0(j5, 0L, j6, 6L);
                }
                if (cK == 'l') {
                    if ((16 & j6) != 0) {
                        return G0(5, 68);
                    }
                    return (64 & j6) != 0 ? G0(5, 70) : j0(j5, 0L, j6, 129L);
                }
                if (cK == 't') {
                    return j0(j5, 0L, j6, 8L);
                }
                if (cK == 'N') {
                    return (34359738368L & j5) != 0 ? G0(5, 35) : j0(j5, 36028797018963968L, j6, 0L);
                }
                if (cK == 'O') {
                    return j0(j5, 18015016984772736L, j6, 0L);
                }
                if (cK == 'c') {
                    return j0(j5, 4611686018427387904L, j6, 0L);
                }
                if (cK == 'd') {
                    return j0(j5, Long.MIN_VALUE, j6, 0L);
                }
                switch (cK) {
                    case 'R':
                        return j0(j5, 2199023255552L, j6, 0L);
                    case 'S':
                        return j0(j5, 1099511627776L, j6, 0L);
                    case 'T':
                        if ((67108864 & j5) != 0) {
                            return G0(5, 26);
                        }
                        break;
                }
            } else if ((4398046511104L & j5) != 0) {
                return G0(5, 42);
            }
            return D0(4, j5, j6);
        } catch (java.io.IOException unused) {
            I0(4, j5, j6);
            return 5;
        }
    }

    private void g(int i, int i2) {
        e(i);
        e(i2);
    }

    private int g0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return E0(3, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return k0(j5, 292057776128L, j6, 0L);
            }
            if (cK == 'B') {
                return k0(j5, 56320L, j6, 0L);
            }
            if (cK == 'E') {
                return k0(j5, 141733920768L, j6, 0L);
            }
            if (cK != 'G') {
                if (cK == 'I') {
                    return k0(j5, 256L, j6, 0L);
                }
                if (cK == 'V') {
                    return k0(j5, 8704L, j6, 0L);
                }
                if (cK == 'a') {
                    return k0(j5, 0L, j6, 6L);
                }
                if (cK == 'l') {
                    if ((16 & j6) != 0) {
                        return G0(5, 68);
                    }
                    return (64 & j6) != 0 ? G0(5, 70) : k0(j5, 0L, j6, 129L);
                }
                if (cK == 't') {
                    return k0(j5, 0L, j6, 8L);
                }
                if (cK == 'N') {
                    return (34359738368L & j5) != 0 ? G0(5, 35) : k0(j5, 36028797018963968L, j6, 0L);
                }
                if (cK == 'O') {
                    return k0(j5, 18015016984772736L, j6, 0L);
                }
                if (cK == 'c') {
                    return k0(j5, 4611686018427387904L, j6, 0L);
                }
                if (cK == 'd') {
                    return k0(j5, Long.MIN_VALUE, j6, 0L);
                }
                switch (cK) {
                    case 'R':
                        return k0(j5, 2199023255552L, j6, 0L);
                    case 'S':
                        return k0(j5, 1099511627776L, j6, 0L);
                    case 'T':
                        if ((67108864 & j5) != 0) {
                            return G0(5, 26);
                        }
                        break;
                }
            } else if ((4398046511104L & j5) != 0) {
                return G0(5, 42);
            }
            return E0(4, j5, j6);
        } catch (java.io.IOException unused) {
            J0(4, j5, j6);
            return 5;
        }
    }

    private int h0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return F0(3, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return l0(j5, 292057776128L, j6, 0L);
            }
            if (cK == 'B') {
                return l0(j5, 56320L, j6, 0L);
            }
            if (cK == 'E') {
                return l0(j5, 141733920768L, j6, 0L);
            }
            if (cK != 'G') {
                if (cK == 'I') {
                    return l0(j5, 256L, j6, 0L);
                }
                if (cK == 'V') {
                    return l0(j5, 8704L, j6, 0L);
                }
                if (cK == 'a') {
                    return l0(j5, 0L, j6, 6L);
                }
                if (cK == 'l') {
                    if ((16 & j6) != 0) {
                        return G0(5, 68);
                    }
                    return (64 & j6) != 0 ? G0(5, 70) : l0(j5, 0L, j6, 129L);
                }
                if (cK == 't') {
                    return l0(j5, 0L, j6, 8L);
                }
                if (cK == 'N') {
                    return (34359738368L & j5) != 0 ? G0(5, 35) : l0(j5, 36028797018963968L, j6, 0L);
                }
                if (cK == 'O') {
                    return l0(j5, 18015016984772736L, j6, 0L);
                }
                if (cK == 'c') {
                    return l0(j5, 4611686018427387904L, j6, 0L);
                }
                if (cK == 'd') {
                    return l0(j5, Long.MIN_VALUE, j6, 0L);
                }
                switch (cK) {
                    case 'R':
                        return l0(j5, 2199023255552L, j6, 0L);
                    case 'S':
                        return l0(j5, 1099511627776L, j6, 0L);
                    case 'T':
                        if ((67108864 & j5) != 0) {
                            return G0(5, 26);
                        }
                        break;
                }
            } else if ((4398046511104L & j5) != 0) {
                return G0(5, 42);
            }
            return F0(4, j5, j6);
        } catch (java.io.IOException unused) {
            K0(4, j5, j6);
            return 5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:130:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:190:0x0295  */
    /* JADX WARN: Code duplicated, block: B:194:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:19:0x0064  */
    /* JADX WARN: Code duplicated, block: B:23:0x0071  */
    /* JADX WARN: Code duplicated, block: B:250:0x035d  */
    /* JADX WARN: Code duplicated, block: B:251:0x036a  */
    /* JADX WARN: Code duplicated, block: B:253:0x036e  */
    /* JADX WARN: Code duplicated, block: B:393:0x05cc A[LOOP:3: B:355:0x051b->B:393:0x05cc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:441:0x0379 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:472:0x037b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x012b  */
    private int i(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        char c2 = 0;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        this.i = 52;
        this.f1532e[0] = i;
        int i14 = 1;
        int i15 = Integer.MAX_VALUE;
        int i16 = i2;
        int i17 = 0;
        int i18 = 1;
        int i19 = Integer.MAX_VALUE;
        while (true) {
            int i20 = this.j + i14;
            this.j = i20;
            if (i20 == i15) {
                a();
            }
            char c3 = this.f1533f;
            int i21 = 4;
            if (c3 < '@') {
                long j = 1 << c3;
                do {
                    int[] iArr = this.f1532e;
                    i18--;
                    switch (iArr[i18]) {
                        case 0:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 79) {
                                    i19 = 79;
                                }
                                i5 = 96;
                                i6 = 100;
                            } else if ((j & 4294971904L) != 0) {
                                i5 = 101;
                                i6 = 104;
                            } else if ((j & 9216) == 0) {
                                char c4 = this.f1533f;
                                if (c4 == ';') {
                                    if (i19 > 4) {
                                        i19 = 4;
                                    }
                                    i5 = 109;
                                    i6 = 112;
                                } else if (c4 == '.') {
                                    e(30);
                                } else if (c4 == '-') {
                                    c(113, 114);
                                } else if (c4 == '\'') {
                                    f(115, 117);
                                } else if (c4 == '\"') {
                                    f(118, 120);
                                } else if (c4 == ':') {
                                    int i22 = this.i;
                                    this.i = i22 + 1;
                                    iArr[i22] = 9;
                                }
                                c2 = this.f1533f;
                                if (c2 == '0') {
                                    int[] iArr2 = this.f1532e;
                                    int i23 = this.i;
                                    this.i = i23 + 1;
                                    iArr2[i23] = 16;
                                } else if (c2 == '\r') {
                                    int[] iArr3 = this.f1532e;
                                    int i24 = this.i;
                                    this.i = i24 + 1;
                                    iArr3[i24] = 6;
                                }
                            } else {
                                if (i19 > 74) {
                                    i19 = 74;
                                }
                                i5 = 105;
                                i6 = 108;
                            }
                            f(i5, i6);
                            c2 = this.f1533f;
                            if (c2 == '0') {
                                int[] iArr4 = this.f1532e;
                                int i25 = this.i;
                                this.i = i25 + 1;
                                iArr4[i25] = 16;
                            } else if (c2 == '\r') {
                                int[] iArr5 = this.f1532e;
                                int i26 = this.i;
                                this.i = i26 + 1;
                                iArr5[i26] = 6;
                            }
                            break;
                        case 1:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 61) {
                                    i19 = 61;
                                }
                                int i27 = this.i;
                                this.i = i27 + 1;
                                iArr[i27] = 1;
                            }
                            break;
                        case 2:
                            if ((j & 9216) != 0) {
                                if (i19 > 74) {
                                    i19 = 74;
                                }
                                i7 = 105;
                                i8 = 108;
                                f(i7, i8);
                            }
                            break;
                        case 3:
                            if ((j & 4294971904L) != 0) {
                                g(3, 4);
                            }
                            break;
                        case 4:
                            if (this.f1533f == ';') {
                                f(121, 123);
                            }
                            break;
                        case 5:
                            if ((j & (-9217)) != 0) {
                                f(121, 123);
                            }
                            break;
                        case 6:
                            if (this.f1533f == '\n') {
                                if (i19 > 74) {
                                    i19 = 74;
                                }
                                i7 = 105;
                                i8 = 108;
                                f(i7, i8);
                            }
                            break;
                        case 7:
                            if (this.f1533f == '\r') {
                                int i28 = this.i;
                                this.i = i28 + 1;
                                iArr[i28] = 6;
                            }
                            break;
                        case 8:
                            if (this.f1533f == ':') {
                                int i29 = this.i;
                                this.i = i29 + 1;
                                iArr[i29] = 9;
                            }
                            break;
                        case 10:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 76) {
                                    i19 = 76;
                                }
                                int i30 = this.i;
                                this.i = i30 + 1;
                                iArr[i30] = 10;
                            }
                            break;
                        case 12:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 77) {
                                    i19 = 77;
                                }
                                int i31 = this.i;
                                this.i = i31 + 1;
                                iArr[i31] = 12;
                            }
                            break;
                        case 14:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 78) {
                                    i19 = 78;
                                }
                                int i32 = this.i;
                                this.i = i32 + 1;
                                iArr[i32] = 14;
                            }
                            break;
                        case 15:
                            if (this.f1533f == '0') {
                                int i33 = this.i;
                                this.i = i33 + 1;
                                iArr[i33] = 16;
                            }
                            break;
                        case 17:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 80) {
                                    i19 = 80;
                                }
                                int i34 = this.i;
                                this.i = i34 + 1;
                                iArr[i34] = 17;
                            }
                            break;
                        case 18:
                            i9 = 120;
                            i10 = 118;
                            if (this.f1533f == '\"') {
                                f(i10, i9);
                            }
                            break;
                        case 21:
                            if ((j & (-17179869185L)) == 0) {
                                break;
                            }
                        case 20:
                            i9 = 120;
                            i10 = 118;
                            f(i10, i9);
                            break;
                        case 22:
                            if (this.f1533f == '\"' && i19 > 81) {
                                i19 = 81;
                            }
                            break;
                        case 23:
                            i7 = 115;
                            i8 = 117;
                            if (this.f1533f == '\'') {
                                f(i7, i8);
                            }
                            break;
                        case 26:
                            if ((j & (-549755813889L)) == 0) {
                                break;
                            }
                        case 25:
                            i7 = 115;
                            i8 = 117;
                            f(i7, i8);
                            break;
                        case 27:
                            if (this.f1533f == '\'' && i19 > 81) {
                                i19 = 81;
                            }
                            break;
                        case 28:
                            if (this.f1533f == '-') {
                                c(113, 114);
                            }
                            break;
                        case 29:
                            if (this.f1533f == '.') {
                                i11 = 30;
                                e(i11);
                            }
                            break;
                        case 30:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i12 = 30;
                                i13 = 31;
                                g(i12, i13);
                            }
                            break;
                        case 32:
                            if ((j & 43980465111040L) != 0) {
                                i11 = 33;
                                e(i11);
                            }
                            break;
                        case 33:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i11 = 33;
                                e(i11);
                            }
                            break;
                        case 34:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i7 = 124;
                                i8 = 127;
                                f(i7, i8);
                            }
                            break;
                        case 35:
                            if ((j & 287948901175001088L) != 0) {
                                i12 = 35;
                                i13 = 36;
                                g(i12, i13);
                            }
                            break;
                        case 36:
                            if (this.f1533f == '.') {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i12 = 37;
                                i13 = 38;
                                g(i12, i13);
                            }
                            break;
                        case 37:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i12 = 37;
                                i13 = 38;
                                g(i12, i13);
                            }
                            break;
                        case 39:
                            if ((j & 43980465111040L) != 0) {
                                i11 = 40;
                                e(i11);
                            }
                            break;
                        case 40:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i11 = 40;
                                e(i11);
                            }
                            break;
                        case 41:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i12 = 41;
                                i13 = 42;
                                g(i12, i13);
                            }
                            break;
                        case 43:
                            if ((j & 43980465111040L) != 0) {
                                i11 = 44;
                                e(i11);
                            }
                            break;
                        case 44:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i11 = 44;
                                e(i11);
                            }
                            break;
                        case 45:
                            if ((j & 4294971904L) != 0) {
                                i7 = 101;
                                i8 = 104;
                                f(i7, i8);
                            }
                            break;
                        case 46:
                            if ((j & 4294971904L) != 0) {
                                g(46, 47);
                            }
                            break;
                        case 47:
                            if (this.f1533f == ';') {
                                if (i19 > 4) {
                                    i19 = 4;
                                }
                                e(48);
                            }
                            break;
                        case 48:
                            if ((j & (-9217)) != 0) {
                                if (i19 > 4) {
                                    i19 = 4;
                                }
                                e(48);
                            }
                            break;
                        case 49:
                            if (this.f1533f == ';') {
                                if (i19 > 4) {
                                    i19 = 4;
                                }
                                i7 = 109;
                                i8 = 112;
                                f(i7, i8);
                            }
                            break;
                        case 50:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 79) {
                                    i19 = 79;
                                }
                                i7 = 96;
                                i8 = 100;
                                f(i7, i8);
                            }
                            break;
                        case 51:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 79) {
                                    i19 = 79;
                                }
                                i11 = 51;
                                e(i11);
                            }
                            break;
                        case 52:
                            long j2 = j & 4294971904L;
                            if (j2 != 0) {
                                g(3, 4);
                            } else if (this.f1533f == ';') {
                                f(121, 123);
                            }
                            if (j2 != 0) {
                                g(46, 47);
                            } else if (this.f1533f == ';') {
                                if (i19 > 4) {
                                    i19 = 4;
                                }
                                e(48);
                            }
                            break;
                    }
                } while (i18 != i17);
            } else if (c3 < 128) {
                long j3 = 1 << (c3 & '?');
                do {
                    int[] iArr6 = this.f1532e;
                    i18--;
                    int i35 = iArr6[i18];
                    if (i35 == 0) {
                        if ((576460745995190270L & j3) != 0) {
                            if (i19 > 61) {
                                i19 = 61;
                            }
                            e(1);
                        }
                        char c5 = this.f1533f;
                        if (c5 == 'u') {
                            int[] iArr7 = this.f1532e;
                            int i36 = this.i;
                            this.i = i36 + 1;
                            iArr7[i36] = 14;
                        } else if (c5 == 'v') {
                            int[] iArr8 = this.f1532e;
                            int i37 = this.i;
                            this.i = i37 + 1;
                            iArr8[i37] = 12;
                        }
                    } else if (i35 != 1) {
                        if (i35 == 5) {
                            c(121, 123);
                        } else if (i35 != 13) {
                            if (i35 != 31) {
                                if (i35 != 38) {
                                    if (i35 != 42) {
                                        if (i35 == 48) {
                                            if (i19 > 4) {
                                                i19 = 4;
                                            }
                                            int i38 = this.i;
                                            this.i = i38 + 1;
                                            iArr6[i38] = 48;
                                        } else if (i35 != 16) {
                                            if (i35 != 17) {
                                                switch (i35) {
                                                    case 9:
                                                    case 10:
                                                        if ((576460745995190270L & j3) != 0) {
                                                            if (i19 > 76) {
                                                                i19 = 76;
                                                            }
                                                            e(10);
                                                            break;
                                                        }
                                                        break;
                                                    case 11:
                                                        if (this.f1533f == 'v') {
                                                            int i39 = this.i;
                                                            this.i = i39 + 1;
                                                            iArr6[i39] = 12;
                                                        }
                                                        break;
                                                    default:
                                                        switch (i35) {
                                                            case 19:
                                                                if (this.f1533f == '\\') {
                                                                    int i40 = this.i;
                                                                    this.i = i40 + 1;
                                                                    iArr6[i40] = 20;
                                                                }
                                                                break;
                                                            case 21:
                                                                if (((-268435457) & j3) != 0) {
                                                                }
                                                            case 20:
                                                                f(118, 120);
                                                                break;
                                                            default:
                                                                switch (i35) {
                                                                    case 24:
                                                                        if (this.f1533f == '\\') {
                                                                            int i41 = this.i;
                                                                            this.i = i41 + 1;
                                                                            iArr6[i41] = 25;
                                                                        }
                                                                        break;
                                                                    case 26:
                                                                        if (((-268435457) & j3) != 0) {
                                                                        }
                                                                    case 25:
                                                                        f(115, 117);
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                            } else if ((541165879422L & j3) != 0) {
                                                int i42 = i19 > 80 ? 80 : i19;
                                                e(17);
                                                i19 = i42;
                                            }
                                        } else if ((72057594054705152L & j3) != 0) {
                                            e(17);
                                        }
                                    } else if ((137438953504L & j3) != 0) {
                                        i3 = 94;
                                        i4 = 95;
                                        c(i3, i4);
                                    }
                                } else if ((137438953504L & j3) != 0) {
                                    i3 = 69;
                                    i4 = 70;
                                    c(i3, i4);
                                }
                            } else if ((137438953504L & j3) != 0) {
                                i3 = 128;
                                i4 = 129;
                                c(i3, i4);
                            }
                        } else if (this.f1533f == 'u') {
                            int i43 = this.i;
                            this.i = i43 + 1;
                            iArr6[i43] = 14;
                        }
                    } else if ((576460745995190270L & j3) != 0) {
                        if (i19 > 61) {
                            i19 = 61;
                        }
                        e(1);
                    }
                } while (i18 != i17);
            } else {
                int i44 = c3 >> '\b';
                int i45 = c3 >> 14;
                long j4 = 1 << (i44 & 63);
                int i46 = (c3 & 255) >> 6;
                long j5 = 1 << (c3 & '?');
                while (true) {
                    i18--;
                    int i47 = this.f1532e[i18];
                    if (i47 == 5) {
                        if (d(i44, i45, i46, j4, j5)) {
                            c(121, 123);
                        }
                        if (i18 == i17) {
                            i21 = 4;
                        }
                    } else if (i47 != 48) {
                        if (i47 == 20 || i47 == 21) {
                            if (d(i44, i45, i46, j4, j5)) {
                                f(118, 120);
                            }
                        } else if ((i47 == 25 || i47 == 26) && d(i44, i45, i46, j4, j5)) {
                            f(115, 117);
                        }
                    } else if (d(i44, i45, i46, j4, j5)) {
                        if (i19 > i21) {
                            i19 = 4;
                        }
                        int[] iArr9 = this.f1532e;
                        int i48 = this.i;
                        this.i = i48 + 1;
                        iArr9[i48] = 48;
                    }
                    if (i18 == i17) {
                        i21 = 4;
                    }
                }
            }
            if (i19 != Integer.MAX_VALUE) {
                this.l = i19;
                this.k = i16;
                i19 = Integer.MAX_VALUE;
            }
            i16++;
            i18 = this.i;
            this.i = i17;
            i17 = 52 - i17;
            if (i18 == i17) {
                return i16;
            }
            try {
                this.f1533f = this.f1530c.k();
                i14 = 1;
                i15 = Integer.MAX_VALUE;
            } catch (java.io.IOException unused) {
                return i16;
            }
        }
    }

    private int i0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return C0(4, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return m0(j5, 8704L, j6, 0L);
            }
            if (cK == 'E') {
                return (2199023255552L & j5) != 0 ? y0(6, 41, 1) : m0(j5, 36028797018963968L, j6, 0L);
            }
            if (cK == 'L') {
                return (256 & j5) != 0 ? y0(6, 8, 1) : m0(j5, 292057827328L, j6, 0L);
            }
            if (cK == 'a') {
                return m0(j5, 0L, j6, 8L);
            }
            if (cK == 'e') {
                return (4611686018427387904L & j5) != 0 ? G0(6, 62) : m0(j5, Long.MIN_VALUE, j6, 0L);
            }
            if (cK == 'i') {
                return m0(j5, 0L, j6, 1L);
            }
            if (cK == 'o') {
                return m0(j5, 0L, j6, 128L);
            }
            if (cK == 'r') {
                return m0(j5, 0L, j6, 6L);
            }
            if (cK == 'O') {
                return m0(j5, 549755814016L, j6, 0L);
            }
            if (cK != 'P') {
                if (cK != 'T') {
                    if (cK == 'U') {
                        return m0(j5, 5120L, j6, 0L);
                    }
                } else {
                    if ((4294967296L & j5) != 0) {
                        return y0(6, 32, 1);
                    }
                    if ((1099511627776L & j5) != 0) {
                        return y0(6, 40, 1);
                    }
                }
            } else {
                if ((68719476736L & j5) != 0) {
                    return y0(6, 36, 1);
                }
                if ((137438953472L & j5) != 0) {
                    return y0(6, 37, 1);
                }
                if ((18014398509481984L & j5) != 0) {
                    return y0(6, 54, 1);
                }
            }
            return C0(5, j5, j6);
        } catch (java.io.IOException unused) {
            H0(5, j5, j6);
            return 6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:138:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:19:0x0060  */
    /* JADX WARN: Code duplicated, block: B:237:0x0343  */
    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:84:0x011b A[PHI: r4 r7 r8
      0x011b: PHI (r4v48 int) = (r4v21 int), (r4v19 int), (r4v19 int), (r4v19 int), (r4v19 int), (r4v19 int), (r4v49 int) binds: [B:234:0x0335, B:154:0x0203, B:152:0x01f7, B:143:0x01df, B:141:0x01d1, B:115:0x0175, B:83:0x0117] A[DONT_GENERATE, DONT_INLINE]
      0x011b: PHI (r7v76 int) = (r7v33 int), (r7v45 int), (r7v46 int), (r7v51 int), (r7v52 int), (r7v65 int), (r7v78 int) binds: [B:234:0x0335, B:154:0x0203, B:152:0x01f7, B:143:0x01df, B:141:0x01d1, B:115:0x0175, B:83:0x0117] A[DONT_GENERATE, DONT_INLINE]
      0x011b: PHI (r8v48 int) = (r8v7 int), (r8v38 int), (r8v39 int), (r8v40 int), (r8v41 int), (r8v45 int), (r8v49 int) binds: [B:234:0x0335, B:154:0x0203, B:152:0x01f7, B:143:0x01df, B:141:0x01d1, B:115:0x0175, B:83:0x0117] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x03a7, code lost:
    
        if ((r8 & (-268435457)) != 0) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x03c9, code lost:
    
        if ((r8 & (-268435457)) != 0) goto L283;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int j(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15;
        int i16;
        this.i = 51;
        this.f1532e[0] = i;
        int i17 = 1;
        int i18 = i2;
        int i19 = Integer.MAX_VALUE;
        int i20 = 1;
        int i21 = 0;
        while (true) {
            int i22 = this.j + i17;
            this.j = i22;
            if (i22 == Integer.MAX_VALUE) {
                a();
            }
            char c2 = this.f1533f;
            int i23 = 4;
            if (c2 < '@') {
                long j = 1 << c2;
                do {
                    int[] iArr = this.f1532e;
                    i20--;
                    switch (iArr[i20]) {
                        case 0:
                            if ((j & 9216) != 0) {
                                if (i19 > 74) {
                                    i19 = 74;
                                }
                                i10 = 12;
                                i11 = 15;
                                f(i10, i11);
                            }
                            break;
                        case 1:
                            if ((j & 4294971904L) != 0) {
                                g(i17, 2);
                            }
                            break;
                        case 2:
                            if (this.f1533f == ';') {
                                f(0, 2);
                            }
                            break;
                        case 3:
                            if ((j & (-9217)) != 0) {
                                f(0, 2);
                            }
                            break;
                        case 4:
                            if (this.f1533f == '\n') {
                                if (i19 > 74) {
                                    i19 = 74;
                                }
                                i10 = 12;
                                i11 = 15;
                                f(i10, i11);
                            }
                            break;
                        case 5:
                            if (this.f1533f == '\r') {
                                int i24 = this.i;
                                this.i = i24 + 1;
                                iArr[i24] = 4;
                            }
                            break;
                        case 6:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 60) {
                                    i19 = 60;
                                }
                                f(71, 76);
                            } else {
                                if ((j & 4294971904L) != 0) {
                                    i12 = 77;
                                    i13 = 80;
                                } else if ((j & 9216) != 0) {
                                    if (i19 > 74) {
                                        i19 = 74;
                                    }
                                    i12 = 12;
                                    i13 = 15;
                                } else {
                                    char c3 = this.f1533f;
                                    if (c3 == '-') {
                                        f(81, 83);
                                    } else if (c3 == ';') {
                                        if (i19 > 4) {
                                            i19 = 4;
                                        }
                                        f(84, 87);
                                    } else if (c3 == '.') {
                                        e(27);
                                    } else if (c3 == '\'') {
                                        f(22, 24);
                                    } else if (c3 == '\"') {
                                        f(25, 27);
                                    } else if (c3 == ':') {
                                        int i25 = this.i;
                                        this.i = i25 + 1;
                                        iArr[i25] = 7;
                                    }
                                }
                                f(i12, i13);
                            }
                            char c4 = this.f1533f;
                            if (c4 == '0') {
                                int[] iArr2 = this.f1532e;
                                int i26 = this.i;
                                this.i = i26 + 1;
                                iArr2[i26] = 14;
                            } else if (c4 == '\r') {
                                int[] iArr3 = this.f1532e;
                                int i27 = this.i;
                                this.i = i27 + 1;
                                iArr3[i27] = 4;
                            }
                            break;
                        case 8:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 76) {
                                    i19 = 76;
                                }
                                int i28 = this.i;
                                this.i = i28 + 1;
                                iArr[i28] = 8;
                            }
                            break;
                        case 10:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 77) {
                                    i19 = 77;
                                }
                                int i29 = this.i;
                                this.i = i29 + 1;
                                iArr[i29] = 10;
                            }
                            break;
                        case 12:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 78) {
                                    i19 = 78;
                                }
                                int i30 = this.i;
                                this.i = i30 + 1;
                                iArr[i30] = 12;
                            }
                            break;
                        case 13:
                            if (this.f1533f == '0') {
                                int i31 = this.i;
                                this.i = i31 + 1;
                                iArr[i31] = 14;
                            }
                            break;
                        case 15:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 80) {
                                    i19 = 80;
                                }
                                int i32 = this.i;
                                this.i = i32 + 1;
                                iArr[i32] = 15;
                            }
                            break;
                        case 16:
                            i10 = 25;
                            i11 = 27;
                            if (this.f1533f == '\"') {
                                f(i10, i11);
                            }
                            break;
                        case 19:
                            if ((j & (-17179869185L)) == 0) {
                                break;
                            }
                        case 18:
                            i10 = 25;
                            i11 = 27;
                            f(i10, i11);
                            break;
                        case 20:
                            if (this.f1533f == '\"' && i19 > 81) {
                                i19 = 81;
                            }
                            break;
                        case 21:
                            i10 = 22;
                            i11 = 24;
                            if (this.f1533f == '\'') {
                                f(i10, i11);
                            }
                            break;
                        case 24:
                            if ((j & (-549755813889L)) == 0) {
                                break;
                            }
                        case 23:
                            i10 = 22;
                            i11 = 24;
                            f(i10, i11);
                            break;
                        case 25:
                            if (this.f1533f == '\'' && i19 > 81) {
                                i19 = 81;
                            }
                            break;
                        case 26:
                            if (this.f1533f == '.') {
                                e(27);
                            }
                            break;
                        case 27:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                g(27, 28);
                            }
                            break;
                        case 29:
                            if ((j & 43980465111040L) != 0) {
                                i14 = 30;
                                e(i14);
                            }
                            break;
                        case 30:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i14 = 30;
                                e(i14);
                            }
                            break;
                        case 31:
                            if ((j & 4294971904L) != 0) {
                                i10 = 77;
                                i11 = 80;
                                f(i10, i11);
                            }
                            break;
                        case 32:
                            if ((j & 4294971904L) != 0) {
                                i15 = 32;
                                i16 = 33;
                                g(i15, i16);
                            }
                            break;
                        case 33:
                            if (this.f1533f == ';') {
                                if (i19 > 4) {
                                    i19 = 4;
                                }
                                e(34);
                            }
                            break;
                        case 34:
                            if ((j & (-9217)) != 0) {
                                if (i19 > 4) {
                                    i19 = 4;
                                }
                                e(34);
                            }
                            break;
                        case 35:
                            if (this.f1533f == ';') {
                                if (i19 > 4) {
                                    i19 = 4;
                                }
                                f(84, 87);
                            }
                            break;
                        case 36:
                            if (this.f1533f == '-') {
                                f(81, 83);
                            }
                            break;
                        case 37:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 60) {
                                    i19 = 60;
                                }
                                i14 = 37;
                                e(i14);
                            }
                            break;
                        case 38:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i10 = 88;
                                i11 = 91;
                                f(i10, i11);
                            }
                            break;
                        case 39:
                            if ((j & 287948901175001088L) != 0) {
                                i15 = 39;
                                i16 = 40;
                                g(i15, i16);
                            }
                            break;
                        case 40:
                            if (this.f1533f == '.') {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i15 = 41;
                                i16 = 42;
                                g(i15, i16);
                            }
                            break;
                        case 41:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i15 = 41;
                                i16 = 42;
                                g(i15, i16);
                            }
                            break;
                        case 43:
                            if ((j & 43980465111040L) != 0) {
                                i14 = 44;
                                e(i14);
                            }
                            break;
                        case 44:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i14 = 44;
                                e(i14);
                            }
                            break;
                        case 45:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i15 = 45;
                                i16 = 46;
                                g(i15, i16);
                            }
                            break;
                        case 47:
                            if ((j & 43980465111040L) != 0) {
                                i14 = 48;
                                e(i14);
                            }
                            break;
                        case 48:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 84) {
                                    i19 = 84;
                                }
                                i14 = 48;
                                e(i14);
                            }
                            break;
                        case 49:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 60) {
                                    i19 = 60;
                                }
                                f(71, 76);
                            }
                            break;
                        case 50:
                            if ((j & 287948901175001088L) != 0) {
                                if (i19 > 79) {
                                    i19 = 79;
                                }
                                i14 = 50;
                                e(i14);
                            }
                            break;
                        case 51:
                            long j2 = j & 4294971904L;
                            if (j2 != 0) {
                                g(i17, 2);
                            } else if (this.f1533f == ';') {
                                f(0, 2);
                            }
                            if (j2 != 0) {
                                i15 = 32;
                                i16 = 33;
                                g(i15, i16);
                            } else if (this.f1533f == ';') {
                                if (i19 > 4) {
                                    i19 = 4;
                                }
                                e(34);
                            }
                            break;
                    }
                } while (i20 != i21);
            } else if (c2 < 128) {
                long j3 = 1 << (c2 & '?');
                do {
                    int[] iArr4 = this.f1532e;
                    i20--;
                    int i33 = iArr4[i20];
                    if (i33 == 3) {
                        c(0, 2);
                    } else if (i33 != 11) {
                        if (i33 != 28) {
                            if (i33 == 34) {
                                if (i19 > 4) {
                                    i19 = 4;
                                }
                                int i34 = this.i;
                                this.i = i34 + 1;
                                iArr4[i34] = 34;
                            } else if (i33 != 42) {
                                if (i33 != 46) {
                                    if (i33 == 14) {
                                        i7 = 15;
                                        if ((j3 & 72057594054705152L) != 0) {
                                            e(i7);
                                        }
                                    } else if (i33 != 15) {
                                        switch (i33) {
                                            case 6:
                                                char c5 = this.f1533f;
                                                if (c5 == 'u') {
                                                    int i35 = this.i;
                                                    this.i = i35 + 1;
                                                    iArr4[i35] = 12;
                                                } else if (c5 == 'v') {
                                                    int i36 = this.i;
                                                    this.i = i36 + 1;
                                                    iArr4[i36] = 10;
                                                }
                                                break;
                                            case 7:
                                            case 8:
                                                if ((j3 & 576460745995190270L) != 0) {
                                                    if (i19 > 76) {
                                                        i19 = 76;
                                                    }
                                                    e(8);
                                                }
                                                break;
                                            case 9:
                                                if (this.f1533f == 'v') {
                                                    int i37 = this.i;
                                                    this.i = i37 + 1;
                                                    iArr4[i37] = 10;
                                                }
                                                break;
                                            default:
                                                switch (i33) {
                                                    case 17:
                                                        if (this.f1533f == '\\') {
                                                            int i38 = this.i;
                                                            this.i = i38 + 1;
                                                            iArr4[i38] = 18;
                                                        }
                                                        break;
                                                    case 19:
                                                    case 18:
                                                        i8 = 25;
                                                        i9 = 27;
                                                        f(i8, i9);
                                                        break;
                                                    default:
                                                        switch (i33) {
                                                            case 22:
                                                                if (this.f1533f == '\\') {
                                                                    int i39 = this.i;
                                                                    this.i = i39 + 1;
                                                                    iArr4[i39] = 23;
                                                                }
                                                                break;
                                                            case 24:
                                                            case 23:
                                                                i8 = 22;
                                                                i9 = 24;
                                                                f(i8, i9);
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                    } else if ((j3 & 541165879422L) != 0) {
                                        if (i19 > 80) {
                                            i19 = 80;
                                        }
                                        i7 = 15;
                                        e(i7);
                                    }
                                } else if ((j3 & 137438953504L) != 0) {
                                    c(63, 64);
                                }
                            } else if ((j3 & 137438953504L) != 0) {
                                i5 = 94;
                                i6 = 95;
                                c(i5, i6);
                            }
                        } else if ((j3 & 137438953504L) != 0) {
                            i5 = 92;
                            i6 = 93;
                            c(i5, i6);
                        }
                    } else if (this.f1533f == 'u') {
                        int i40 = this.i;
                        this.i = i40 + 1;
                        iArr4[i40] = 12;
                    }
                } while (i20 != i21);
            } else {
                int i41 = c2 >> '\b';
                int i42 = c2 >> 14;
                long j4 = 1 << (i41 & 63);
                int i43 = (c2 & 255) >> 6;
                long j5 = 1 << (c2 & '?');
                while (true) {
                    i20--;
                    int i44 = this.f1532e[i20];
                    if (i44 != 3) {
                        if (i44 != 34) {
                            if (i44 != 18 && i44 != 19) {
                                if (i44 != 23) {
                                    i4 = 24;
                                    if (i44 == 24) {
                                    }
                                } else {
                                    i4 = 24;
                                }
                                if (d(i41, i42, i43, j4, j5)) {
                                    i3 = 22;
                                    f(i3, i4);
                                }
                            } else if (d(i41, i42, i43, j4, j5)) {
                                i3 = 25;
                                i4 = 27;
                                f(i3, i4);
                            }
                        } else if (d(i41, i42, i43, j4, j5)) {
                            if (i19 > i23) {
                                i19 = 4;
                            }
                            int[] iArr5 = this.f1532e;
                            int i45 = this.i;
                            this.i = i45 + 1;
                            iArr5[i45] = 34;
                        }
                    } else if (d(i41, i42, i43, j4, j5)) {
                        c(0, 2);
                    }
                    if (i20 != i21) {
                        i23 = 4;
                    }
                }
            }
            if (i19 != Integer.MAX_VALUE) {
                this.l = i19;
                this.k = i18;
                i19 = Integer.MAX_VALUE;
            }
            i18++;
            i20 = this.i;
            this.i = i21;
            i21 = 51 - i21;
            if (i20 == i21) {
                return i18;
            }
            try {
                this.f1533f = this.f1530c.k();
                i17 = 1;
            } catch (java.io.IOException unused) {
                return i18;
            }
        }
    }

    private int j0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return D0(4, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return n0(j5, 8704L, j6, 0L);
            }
            if (cK == 'E') {
                return (2199023255552L & j5) != 0 ? G0(6, 41) : n0(j5, 36028797018963968L, j6, 0L);
            }
            if (cK == 'L') {
                return (256 & j5) != 0 ? G0(6, 8) : n0(j5, 292057827328L, j6, 0L);
            }
            if (cK == 'a') {
                return n0(j5, 0L, j6, 8L);
            }
            if (cK == 'e') {
                return (4611686018427387904L & j5) != 0 ? G0(6, 62) : n0(j5, Long.MIN_VALUE, j6, 0L);
            }
            if (cK == 'i') {
                return n0(j5, 0L, j6, 1L);
            }
            if (cK == 'o') {
                return n0(j5, 0L, j6, 128L);
            }
            if (cK == 'r') {
                return n0(j5, 0L, j6, 6L);
            }
            if (cK == 'O') {
                return n0(j5, 549755814016L, j6, 0L);
            }
            if (cK != 'P') {
                if (cK != 'T') {
                    if (cK == 'U') {
                        return n0(j5, 5120L, j6, 0L);
                    }
                } else {
                    if ((4294967296L & j5) != 0) {
                        return G0(6, 32);
                    }
                    if ((1099511627776L & j5) != 0) {
                        return G0(6, 40);
                    }
                }
            } else {
                if ((68719476736L & j5) != 0) {
                    return G0(6, 36);
                }
                if ((137438953472L & j5) != 0) {
                    return G0(6, 37);
                }
                if ((18014398509481984L & j5) != 0) {
                    return G0(6, 54);
                }
            }
            return D0(5, j5, j6);
        } catch (java.io.IOException unused) {
            I0(5, j5, j6);
            return 6;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:146:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:226:0x0305  */
    /* JADX WARN: Code duplicated, block: B:227:0x0315  */
    /* JADX WARN: Code duplicated, block: B:229:0x0319  */
    /* JADX WARN: Code duplicated, block: B:238:0x0342  */
    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    /* JADX WARN: Code duplicated, block: B:242:0x0356  */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x019e, code lost:
    
        if ((r19 & 43980465111040L) != 0) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01e3, code lost:
    
        if ((r19 & (-549755813889L)) != 0) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x020d, code lost:
    
        if ((r19 & (-17179869185L)) != 0) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ec, code lost:
    
        if ((r19 & 4294971904L) != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0116, code lost:
    
        if ((r19 & 43980465111040L) != 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0147, code lost:
    
        if ((r19 & 43980465111040L) != 0) goto L96;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int k(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 0;
        char c2 = 0;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        this.i = 51;
        this.f1532e[0] = i;
        int i14 = 1;
        int i15 = i2;
        int i16 = Integer.MAX_VALUE;
        int i17 = 1;
        int i18 = 0;
        while (true) {
            int i19 = this.j + i14;
            this.j = i19;
            if (i19 == Integer.MAX_VALUE) {
                a();
            }
            char c3 = this.f1533f;
            int i20 = 4;
            if (c3 < '@') {
                long j = 1 << c3;
                do {
                    int[] iArr = this.f1532e;
                    i17--;
                    int i21 = 59;
                    switch (iArr[i17]) {
                        case 0:
                            if ((j & 9216) != 0) {
                                if (i16 > 74) {
                                    i16 = 74;
                                }
                                f(12, 15);
                            }
                            break;
                        case 1:
                            if ((j & 4294971904L) != 0) {
                                g(i14, 2);
                            }
                            break;
                        case 2:
                            if (this.f1533f == ';') {
                                f(0, 2);
                            }
                            break;
                        case 3:
                            if ((j & (-9217)) != 0) {
                                f(0, 2);
                            }
                            break;
                        case 4:
                            if (this.f1533f == '\n') {
                                if (i16 > 74) {
                                    i16 = 74;
                                }
                                f(12, 15);
                            }
                            break;
                        case 5:
                            if (this.f1533f == '\r') {
                                int i22 = this.i;
                                this.i = i22 + 1;
                                iArr[i22] = 4;
                            }
                            break;
                        case 6:
                            if ((j & 287948901175001088L) == 0) {
                                if ((j & 4294971904L) != 0) {
                                    f(43, 46);
                                } else if ((j & 9216) == 0) {
                                    char c4 = this.f1533f;
                                    if (c4 == ';') {
                                        if (i16 > 4) {
                                            i16 = 4;
                                        }
                                        i6 = 47;
                                        i7 = 50;
                                    } else if (c4 == '.') {
                                        e(26);
                                    } else if (c4 == '-') {
                                        c(51, 52);
                                    } else if (c4 == '\'') {
                                        f(53, 55);
                                    } else if (c4 == '\"') {
                                        f(56, 58);
                                    } else if (c4 == ':') {
                                        int i23 = this.i;
                                        this.i = i23 + 1;
                                        iArr[i23] = 7;
                                    }
                                    c2 = this.f1533f;
                                    if (c2 == '0') {
                                        int[] iArr2 = this.f1532e;
                                        int i24 = this.i;
                                        this.i = i24 + 1;
                                        iArr2[i24] = 12;
                                    } else if (c2 == '\r') {
                                        int[] iArr3 = this.f1532e;
                                        int i25 = this.i;
                                        this.i = i25 + 1;
                                        iArr3[i25] = 4;
                                    }
                                } else {
                                    if (i16 > 74) {
                                        i16 = 74;
                                    }
                                    f(12, 15);
                                }
                                c2 = this.f1533f;
                                if (c2 == '0') {
                                    int[] iArr4 = this.f1532e;
                                    int i26 = this.i;
                                    this.i = i26 + 1;
                                    iArr4[i26] = 12;
                                } else if (c2 == '\r') {
                                    int[] iArr5 = this.f1532e;
                                    int i27 = this.i;
                                    this.i = i27 + 1;
                                    iArr5[i27] = 4;
                                }
                            } else {
                                if (i16 > 79) {
                                    i16 = 79;
                                }
                                i6 = 38;
                                i7 = 42;
                            }
                            f(i6, i7);
                            c2 = this.f1533f;
                            if (c2 == '0') {
                                int[] iArr6 = this.f1532e;
                                int i28 = this.i;
                                this.i = i28 + 1;
                                iArr6[i28] = 12;
                            } else if (c2 == '\r') {
                                int[] iArr7 = this.f1532e;
                                int i29 = this.i;
                                this.i = i29 + 1;
                                iArr7[i29] = 4;
                            }
                            break;
                        case 7:
                        case 9:
                        case 12:
                        case 15:
                        case 20:
                        case 27:
                        case 34:
                        case 38:
                        case 46:
                        default:
                            break;
                        case 8:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 76) {
                                    i16 = 76;
                                }
                                int i30 = this.i;
                                this.i = i30 + 1;
                                iArr[i30] = 8;
                            }
                            break;
                        case 10:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 78) {
                                    i16 = 78;
                                }
                                int i31 = this.i;
                                this.i = i31 + 1;
                                iArr[i31] = 10;
                            }
                            break;
                        case 11:
                            if (this.f1533f == '0') {
                                int i32 = this.i;
                                this.i = i32 + 1;
                                iArr[i32] = 12;
                            }
                            break;
                        case 13:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 80) {
                                    i16 = 80;
                                }
                                int i33 = this.i;
                                this.i = i33 + 1;
                                iArr[i33] = 13;
                            }
                            break;
                        case 14:
                            i21 = 56;
                            i8 = 58;
                            if (this.f1533f == '\"') {
                                f(i21, i8);
                            }
                            break;
                        case 16:
                            i21 = 56;
                            i8 = 58;
                            f(i21, i8);
                            break;
                        case 17:
                            break;
                        case 18:
                            if (this.f1533f == '\"' && i16 > 81) {
                                i16 = 81;
                            }
                            break;
                        case 19:
                            i9 = 55;
                            i10 = 53;
                            if (this.f1533f == '\'') {
                                f(i10, i9);
                            }
                            break;
                        case 21:
                            i9 = 55;
                            i10 = 53;
                            f(i10, i9);
                            break;
                        case 22:
                            break;
                        case 23:
                            if (this.f1533f == '\'' && i16 > 81) {
                                i16 = 81;
                            }
                            break;
                        case 24:
                            if (this.f1533f == '-') {
                                c(51, 52);
                            }
                            break;
                        case 25:
                            if (this.f1533f == '.') {
                                i11 = 26;
                                e(i11);
                            }
                            break;
                        case 26:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 84) {
                                    i16 = 84;
                                }
                                i12 = 26;
                                i13 = 27;
                                g(i12, i13);
                            }
                            break;
                        case 28:
                            break;
                        case 29:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 84) {
                                    i16 = 84;
                                }
                                i11 = 29;
                                e(i11);
                            }
                            break;
                        case 30:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 84) {
                                    i16 = 84;
                                }
                                i8 = 62;
                                f(i21, i8);
                            }
                            break;
                        case 31:
                            if ((j & 287948901175001088L) != 0) {
                                i12 = 31;
                                i13 = 32;
                                g(i12, i13);
                            }
                            break;
                        case 32:
                            i13 = 34;
                            if (this.f1533f == '.') {
                                if (i16 > 84) {
                                    i16 = 84;
                                }
                                i12 = 33;
                                g(i12, i13);
                            }
                            break;
                        case 33:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 84) {
                                    i16 = 84;
                                }
                                i12 = 33;
                                i13 = 34;
                                g(i12, i13);
                            }
                            break;
                        case 35:
                            break;
                        case 36:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 84) {
                                    i16 = 84;
                                }
                                i11 = 36;
                                e(i11);
                            }
                            break;
                        case 37:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 84) {
                                    i16 = 84;
                                }
                                i12 = 37;
                                i13 = 38;
                                g(i12, i13);
                            }
                            break;
                        case 39:
                            break;
                        case 40:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 84) {
                                    i16 = 84;
                                }
                                i11 = 40;
                                e(i11);
                            }
                            break;
                        case 41:
                            if ((j & 4294971904L) != 0) {
                                f(43, 46);
                            }
                            break;
                        case 42:
                            break;
                        case 43:
                            if (this.f1533f == ';') {
                                if (i16 > 4) {
                                    i16 = 4;
                                }
                                e(44);
                            }
                            break;
                        case 44:
                            if ((j & (-9217)) != 0) {
                                if (i16 > 4) {
                                    i16 = 4;
                                }
                                e(44);
                            }
                            break;
                        case 45:
                            if (this.f1533f == ';') {
                                if (i16 > 4) {
                                    i16 = 4;
                                }
                                i21 = 47;
                                i8 = 50;
                                f(i21, i8);
                            }
                            break;
                        case 47:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 59) {
                                    i16 = 59;
                                }
                                int i34 = this.i;
                                this.i = i34 + 1;
                                iArr[i34] = 47;
                            }
                            break;
                        case 48:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 77) {
                                    i16 = 77;
                                }
                                int i35 = this.i;
                                this.i = i35 + 1;
                                iArr[i35] = 48;
                            }
                            break;
                        case 49:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 79) {
                                    i16 = 79;
                                }
                                i21 = 38;
                                i8 = 42;
                                f(i21, i8);
                            }
                            break;
                        case 50:
                            if ((j & 287948901175001088L) != 0) {
                                if (i16 > 79) {
                                    i16 = 79;
                                }
                                i11 = 50;
                                e(i11);
                            }
                            break;
                        case 51:
                            long j2 = j & 4294971904L;
                            if (j2 != 0) {
                                g(i14, 2);
                            } else if (this.f1533f == ';') {
                                f(0, 2);
                            }
                            if (j2 != 0) {
                                i12 = 42;
                                i13 = 43;
                                g(i12, i13);
                            } else if (this.f1533f == ';') {
                                if (i16 > 4) {
                                    i16 = 4;
                                }
                                e(44);
                            }
                            break;
                    }
                } while (i17 != i18);
            } else if (c3 < 128) {
                long j3 = 1 << (c3 & '?');
                do {
                    int[] iArr8 = this.f1532e;
                    i17--;
                    int i36 = iArr8[i17];
                    if (i36 == 3) {
                        c(0, 2);
                    } else if (i36 != 27) {
                        if (i36 != 34) {
                            if (i36 != 38) {
                                if (i36 == 44) {
                                    if (i16 > 4) {
                                        i16 = 4;
                                    }
                                    int i37 = this.i;
                                    this.i = i37 + 1;
                                    iArr8[i37] = 44;
                                } else if (i36 != 46) {
                                    if (i36 == 12) {
                                        i5 = 13;
                                        if ((j3 & 72057594054705152L) != 0) {
                                            e(i5);
                                        }
                                    } else if (i36 != 13) {
                                        switch (i36) {
                                            case 6:
                                                char c5 = this.f1533f;
                                                if (c5 == 'v') {
                                                    c(63, 64);
                                                } else if (c5 == 'u') {
                                                    int i38 = this.i;
                                                    this.i = i38 + 1;
                                                    iArr8[i38] = 10;
                                                }
                                                break;
                                            case 7:
                                            case 8:
                                                if ((j3 & 576460745995190270L) != 0) {
                                                    if (i16 > 76) {
                                                        i16 = 76;
                                                    }
                                                    e(8);
                                                }
                                                break;
                                            case 9:
                                                if (this.f1533f == 'u') {
                                                    int i39 = this.i;
                                                    this.i = i39 + 1;
                                                    iArr8[i39] = 10;
                                                }
                                                break;
                                            default:
                                                switch (i36) {
                                                    case 15:
                                                        if (this.f1533f == '\\') {
                                                            int i40 = this.i;
                                                            this.i = i40 + 1;
                                                            iArr8[i40] = 16;
                                                        }
                                                        break;
                                                    case 17:
                                                        if ((j3 & (-268435457)) != 0) {
                                                        }
                                                    case 16:
                                                        f(56, 58);
                                                        break;
                                                    default:
                                                        switch (i36) {
                                                            case 20:
                                                                if (this.f1533f == '\\') {
                                                                    int i41 = this.i;
                                                                    this.i = i41 + 1;
                                                                    iArr8[i41] = 21;
                                                                }
                                                                break;
                                                            case 22:
                                                                if ((j3 & (-268435457)) != 0) {
                                                                }
                                                            case 21:
                                                                f(53, 55);
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                    } else if ((j3 & 541165879422L) != 0) {
                                        if (i16 > 80) {
                                            i16 = 80;
                                        }
                                        i5 = 13;
                                        e(i5);
                                    }
                                } else if (this.f1533f == 'v') {
                                    c(63, 64);
                                }
                            } else if ((j3 & 137438953504L) != 0) {
                                i3 = 69;
                                i4 = 70;
                                c(i3, i4);
                            }
                        } else if ((j3 & 137438953504L) != 0) {
                            i3 = 67;
                            i4 = 68;
                            c(i3, i4);
                        }
                    } else if ((j3 & 137438953504L) != 0) {
                        i3 = 65;
                        i4 = 66;
                        c(i3, i4);
                    }
                } while (i17 != i18);
            } else {
                int i42 = c3 >> '\b';
                int i43 = c3 >> 14;
                long j4 = 1 << (i42 & 63);
                int i44 = (c3 & 255) >> 6;
                long j5 = 1 << (c3 & '?');
                while (true) {
                    i17--;
                    int i45 = this.f1532e[i17];
                    if (i45 != 3) {
                        if (i45 != 44) {
                            if (i45 == 16 || i45 == 17) {
                                if (d(i42, i43, i44, j4, j5)) {
                                    f(56, 58);
                                }
                            } else if ((i45 == 21 || i45 == 22) && d(i42, i43, i44, j4, j5)) {
                                f(53, 55);
                            }
                        } else if (d(i42, i43, i44, j4, j5)) {
                            if (i16 > i20) {
                                i16 = 4;
                            }
                            int[] iArr9 = this.f1532e;
                            int i46 = this.i;
                            this.i = i46 + 1;
                            iArr9[i46] = 44;
                        }
                    } else if (d(i42, i43, i44, j4, j5)) {
                        c(0, 2);
                    }
                    if (i17 != i18) {
                        i20 = 4;
                    }
                }
            }
            if (i16 != Integer.MAX_VALUE) {
                this.l = i16;
                this.k = i15;
                i16 = Integer.MAX_VALUE;
            }
            i15++;
            i17 = this.i;
            this.i = i18;
            i18 = 51 - i18;
            if (i17 == i18) {
                return i15;
            }
            try {
                this.f1533f = this.f1530c.k();
                i14 = 1;
            } catch (java.io.IOException unused) {
                return i15;
            }
        }
    }

    private int k0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return E0(4, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return o0(j5, 8704L, j6, 0L);
            }
            if (cK == 'E') {
                return (2199023255552L & j5) != 0 ? G0(6, 41) : o0(j5, 36028797018963968L, j6, 0L);
            }
            if (cK == 'L') {
                return (256 & j5) != 0 ? G0(6, 8) : o0(j5, 292057827328L, j6, 0L);
            }
            if (cK == 'a') {
                return o0(j5, 0L, j6, 8L);
            }
            if (cK == 'e') {
                return (4611686018427387904L & j5) != 0 ? G0(6, 62) : o0(j5, Long.MIN_VALUE, j6, 0L);
            }
            if (cK == 'i') {
                return o0(j5, 0L, j6, 1L);
            }
            if (cK == 'o') {
                return o0(j5, 0L, j6, 128L);
            }
            if (cK == 'r') {
                return o0(j5, 0L, j6, 6L);
            }
            if (cK == 'O') {
                return o0(j5, 549755814016L, j6, 0L);
            }
            if (cK != 'P') {
                if (cK != 'T') {
                    if (cK == 'U') {
                        return o0(j5, 5120L, j6, 0L);
                    }
                } else {
                    if ((4294967296L & j5) != 0) {
                        return G0(6, 32);
                    }
                    if ((1099511627776L & j5) != 0) {
                        return G0(6, 40);
                    }
                }
            } else {
                if ((68719476736L & j5) != 0) {
                    return G0(6, 36);
                }
                if ((137438953472L & j5) != 0) {
                    return G0(6, 37);
                }
                if ((18014398509481984L & j5) != 0) {
                    return G0(6, 54);
                }
            }
            return E0(5, j5, j6);
        } catch (java.io.IOException unused) {
            J0(5, j5, j6);
            return 6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:19:0x0059  */
    /* JADX WARN: Code duplicated, block: B:219:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:220:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:222:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:235:0x0329  */
    /* JADX WARN: Code duplicated, block: B:23:0x0065  */
    /* JADX WARN: Code duplicated, block: B:371:0x0567  */
    /* JADX WARN: Code duplicated, block: B:378:0x0589 A[LOOP:3: B:338:0x04da->B:378:0x0589, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:379:0x0579 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:381:0x0578 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:414:0x034c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:445:0x034f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x0125  */
    private int l(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        int i6;
        int i7;
        int i8 = 0;
        int i9 = 0;
        char c2 = 0;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        this.i = 50;
        int i15 = 0;
        this.f1532e[0] = i;
        int i16 = 1;
        int i17 = Integer.MAX_VALUE;
        int i18 = i2;
        int i19 = 1;
        int i20 = Integer.MAX_VALUE;
        int i21 = 0;
        while (true) {
            int i22 = this.j + i16;
            this.j = i22;
            if (i22 == i17) {
                a();
            }
            char c3 = this.f1533f;
            int i23 = 4;
            if (c3 < '@') {
                long j = 1 << c3;
                do {
                    int[] iArr = this.f1532e;
                    i19--;
                    switch (iArr[i19]) {
                        case 0:
                            if ((j & 9216) != 0) {
                                if (i20 > 74) {
                                    i20 = 74;
                                }
                                i6 = 12;
                                i7 = 15;
                                f(i6, i7);
                            }
                            break;
                        case 1:
                            if ((j & 4294971904L) != 0) {
                                g(i16, 2);
                            }
                            break;
                        case 2:
                            if (this.f1533f == ';') {
                                f(i15, 2);
                            }
                            break;
                        case 3:
                            if ((j & (-9217)) != 0) {
                                f(i15, 2);
                            }
                            break;
                        case 4:
                            if (this.f1533f == '\n') {
                                if (i20 > 74) {
                                    i20 = 74;
                                }
                                i6 = 12;
                                i7 = 15;
                                f(i6, i7);
                            }
                            break;
                        case 5:
                            if (this.f1533f == '\r') {
                                int i24 = this.i;
                                this.i = i24 + 1;
                                iArr[i24] = 4;
                            }
                            break;
                        case 6:
                            if ((j & 287948901175001088L) == 0) {
                                if ((j & 4294971904L) != 0) {
                                    f(8, 11);
                                } else if ((j & 9216) != 0) {
                                    if (i20 > 74) {
                                        i20 = 74;
                                    }
                                    i8 = 12;
                                    i9 = 15;
                                } else {
                                    char c4 = this.f1533f;
                                    if (c4 == ';') {
                                        if (i20 > 4) {
                                            i20 = 4;
                                        }
                                        i8 = 16;
                                        i9 = 19;
                                    } else if (c4 == '.') {
                                        e(28);
                                    } else if (c4 == '-') {
                                        c(20, 21);
                                    } else if (c4 == '\'') {
                                        f(22, 24);
                                    } else if (c4 == '\"') {
                                        f(25, 27);
                                    } else if (c4 == ':') {
                                        int i25 = this.i;
                                        this.i = i25 + 1;
                                        iArr[i25] = 7;
                                    }
                                }
                                c2 = this.f1533f;
                                if (c2 == '0') {
                                    int[] iArr2 = this.f1532e;
                                    int i26 = this.i;
                                    this.i = i26 + 1;
                                    iArr2[i26] = 14;
                                } else if (c2 == '\r') {
                                    int[] iArr3 = this.f1532e;
                                    int i27 = this.i;
                                    this.i = i27 + 1;
                                    iArr3[i27] = 4;
                                }
                            } else {
                                if (i20 > 79) {
                                    i20 = 79;
                                }
                                i8 = 3;
                                i9 = 7;
                            }
                            f(i8, i9);
                            c2 = this.f1533f;
                            if (c2 == '0') {
                                int[] iArr4 = this.f1532e;
                                int i28 = this.i;
                                this.i = i28 + 1;
                                iArr4[i28] = 14;
                            } else if (c2 == '\r') {
                                int[] iArr5 = this.f1532e;
                                int i29 = this.i;
                                this.i = i29 + 1;
                                iArr5[i29] = 4;
                            }
                            break;
                        case 8:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 76) {
                                    i20 = 76;
                                }
                                int i30 = this.i;
                                this.i = i30 + 1;
                                iArr[i30] = 8;
                            }
                            break;
                        case 10:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 77) {
                                    i20 = 77;
                                }
                                int i31 = this.i;
                                this.i = i31 + 1;
                                iArr[i31] = 10;
                            }
                            break;
                        case 12:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 78) {
                                    i20 = 78;
                                }
                                int i32 = this.i;
                                this.i = i32 + 1;
                                iArr[i32] = 12;
                            }
                            break;
                        case 13:
                            if (this.f1533f == '0') {
                                int i33 = this.i;
                                this.i = i33 + 1;
                                iArr[i33] = 14;
                            }
                            break;
                        case 15:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 80) {
                                    i20 = 80;
                                }
                                int i34 = this.i;
                                this.i = i34 + 1;
                                iArr[i34] = 15;
                            }
                            break;
                        case 16:
                            i10 = 27;
                            i11 = 25;
                            if (this.f1533f == '\"') {
                                f(i11, i10);
                            }
                            break;
                        case 19:
                            if ((j & (-17179869185L)) == 0) {
                                break;
                            }
                        case 18:
                            i10 = 27;
                            i11 = 25;
                            f(i11, i10);
                            break;
                        case 20:
                            if (this.f1533f == '\"' && i20 > 81) {
                                i20 = 81;
                            }
                            break;
                        case 21:
                            i6 = 22;
                            i7 = 24;
                            if (this.f1533f == '\'') {
                                f(i6, i7);
                            }
                            break;
                        case 24:
                            if ((j & (-549755813889L)) == 0) {
                                break;
                            }
                        case 23:
                            i6 = 22;
                            i7 = 24;
                            f(i6, i7);
                            break;
                        case 25:
                            if (this.f1533f == '\'' && i20 > 81) {
                                i20 = 81;
                            }
                            break;
                        case 26:
                            if (this.f1533f == '-') {
                                c(20, 21);
                            }
                            break;
                        case 27:
                            if (this.f1533f == '.') {
                                i12 = 28;
                                e(i12);
                            }
                            break;
                        case 28:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 84) {
                                    i20 = 84;
                                }
                                i13 = 28;
                                i14 = 29;
                                g(i13, i14);
                            }
                            break;
                        case 30:
                            if ((j & 43980465111040L) != 0) {
                                i12 = 31;
                                e(i12);
                            }
                            break;
                        case 31:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 84) {
                                    i20 = 84;
                                }
                                i12 = 31;
                                e(i12);
                            }
                            break;
                        case 32:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 84) {
                                    i20 = 84;
                                }
                                i6 = 28;
                                i7 = 31;
                                f(i6, i7);
                            }
                            break;
                        case 33:
                            if ((j & 287948901175001088L) != 0) {
                                i13 = 33;
                                i14 = 34;
                                g(i13, i14);
                            }
                            break;
                        case 34:
                            if (this.f1533f == '.') {
                                if (i20 > 84) {
                                    i20 = 84;
                                }
                                i13 = 35;
                                i14 = 36;
                                g(i13, i14);
                            }
                            break;
                        case 35:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 84) {
                                    i20 = 84;
                                }
                                i13 = 35;
                                i14 = 36;
                                g(i13, i14);
                            }
                            break;
                        case 37:
                            if ((j & 43980465111040L) != 0) {
                                i12 = 38;
                                e(i12);
                            }
                            break;
                        case 38:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 84) {
                                    i20 = 84;
                                }
                                i12 = 38;
                                e(i12);
                            }
                            break;
                        case 39:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 84) {
                                    i20 = 84;
                                }
                                i13 = 39;
                                i14 = 40;
                                g(i13, i14);
                            }
                            break;
                        case 41:
                            if ((j & 43980465111040L) != 0) {
                                i12 = 42;
                                e(i12);
                            }
                            break;
                        case 42:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 84) {
                                    i20 = 84;
                                }
                                i12 = 42;
                                e(i12);
                            }
                            break;
                        case 43:
                            if ((j & 4294971904L) != 0) {
                                i10 = 11;
                                i11 = 8;
                                f(i11, i10);
                            }
                            break;
                        case 44:
                            if ((j & 4294971904L) != 0) {
                                i13 = 44;
                                i14 = 45;
                                g(i13, i14);
                            }
                            break;
                        case 45:
                            if (this.f1533f == ';') {
                                if (i20 > 4) {
                                    i20 = 4;
                                }
                                e(46);
                            }
                            break;
                        case 46:
                            if ((j & (-9217)) != 0) {
                                if (i20 > 4) {
                                    i20 = 4;
                                }
                                e(46);
                            }
                            break;
                        case 47:
                            if (this.f1533f == ';') {
                                if (i20 > 4) {
                                    i20 = 4;
                                }
                                i6 = 16;
                                i7 = 19;
                                f(i6, i7);
                            }
                            break;
                        case 48:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 79) {
                                    i20 = 79;
                                }
                                i6 = 3;
                                i7 = 7;
                                f(i6, i7);
                            }
                            break;
                        case 49:
                            if ((j & 287948901175001088L) != 0) {
                                if (i20 > 79) {
                                    i20 = 79;
                                }
                                i12 = 49;
                                e(i12);
                            }
                            break;
                        case 50:
                            long j2 = j & 4294971904L;
                            if (j2 != 0) {
                                g(i16, 2);
                            } else if (this.f1533f == ';') {
                                f(i15, 2);
                            }
                            if (j2 != 0) {
                                i13 = 44;
                                i14 = 45;
                                g(i13, i14);
                            } else if (this.f1533f == ';') {
                                if (i20 > 4) {
                                    i20 = 4;
                                }
                                e(46);
                            }
                            break;
                    }
                } while (i19 != i21);
            } else {
                if (c3 < 128) {
                    long j3 = 1 << (c3 & '?');
                    do {
                        int[] iArr6 = this.f1532e;
                        i19--;
                        int i35 = iArr6[i19];
                        if (i35 == 3) {
                            c(i15, 2);
                        } else if (i35 != 11) {
                            if (i35 != 29) {
                                if (i35 != 36) {
                                    if (i35 != 40) {
                                        if (i35 != 46) {
                                            if (i35 == 14) {
                                                i5 = 15;
                                                if ((j3 & 72057594054705152L) != 0) {
                                                }
                                            } else if (i35 != 15) {
                                                switch (i35) {
                                                    case 6:
                                                        char c5 = this.f1533f;
                                                        if (c5 == 'u') {
                                                            int i36 = this.i;
                                                            this.i = i36 + 1;
                                                            iArr6[i36] = 12;
                                                        } else if (c5 == 'v') {
                                                            int i37 = this.i;
                                                            this.i = i37 + 1;
                                                            iArr6[i37] = 10;
                                                        }
                                                        break;
                                                    case 7:
                                                    case 8:
                                                        if ((576460745995190270L & j3) != 0) {
                                                            if (i20 > 76) {
                                                                i20 = 76;
                                                            }
                                                            e(8);
                                                        }
                                                        break;
                                                    case 9:
                                                        if (this.f1533f == 'v') {
                                                            int i38 = this.i;
                                                            this.i = i38 + 1;
                                                            iArr6[i38] = 10;
                                                        }
                                                        break;
                                                    default:
                                                        switch (i35) {
                                                            case 17:
                                                                if (this.f1533f == '\\') {
                                                                    int i39 = this.i;
                                                                    this.i = i39 + 1;
                                                                    iArr6[i39] = 18;
                                                                }
                                                                break;
                                                            case 19:
                                                                if (((-268435457) & j3) != 0) {
                                                                }
                                                            case 18:
                                                                f(25, 27);
                                                                break;
                                                            default:
                                                                switch (i35) {
                                                                    case 22:
                                                                        if (this.f1533f == '\\') {
                                                                            int i40 = this.i;
                                                                            this.i = i40 + 1;
                                                                            iArr6[i40] = 23;
                                                                        }
                                                                        break;
                                                                    case 24:
                                                                        if (((-268435457) & j3) != 0) {
                                                                        }
                                                                    case 23:
                                                                        f(22, 24);
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                            } else if ((541165879422L & j3) != 0) {
                                                if (i20 > 80) {
                                                    i20 = 80;
                                                }
                                                i5 = 15;
                                            }
                                            e(i5);
                                        } else {
                                            if (i20 > 4) {
                                                i20 = 4;
                                            }
                                            int i41 = this.i;
                                            this.i = i41 + 1;
                                            iArr6[i41] = 46;
                                        }
                                    } else if ((j3 & 137438953504L) != 0) {
                                        c(36, 37);
                                    }
                                } else if ((j3 & 137438953504L) != 0) {
                                    c(34, 35);
                                }
                            } else if ((j3 & 137438953504L) != 0) {
                                c(32, 33);
                            }
                        } else if (this.f1533f == 'u') {
                            int i42 = this.i;
                            this.i = i42 + 1;
                            iArr6[i42] = 12;
                        }
                    } while (i19 != i21);
                } else {
                    int i43 = c3 >> '\b';
                    int i44 = c3 >> 14;
                    long j4 = 1 << (i43 & 63);
                    int i45 = (c3 & 255) >> 6;
                    long j5 = 1 << (c3 & '?');
                    while (true) {
                        i19--;
                        int i46 = this.f1532e[i19];
                        if (i46 == 3) {
                            if (d(i43, i44, i45, j4, j5)) {
                                c(0, 2);
                            }
                            if (i19 == i21) {
                                i23 = 4;
                            }
                        } else if (i46 != 46) {
                            if (i46 != 18 && i46 != 19) {
                                if (i46 != 23) {
                                    i3 = 24;
                                    if (i46 == 24) {
                                    }
                                } else {
                                    i3 = 24;
                                }
                                if (d(i43, i44, i45, j4, j5)) {
                                    i4 = 22;
                                    f(i4, i3);
                                }
                            } else if (d(i43, i44, i45, j4, j5)) {
                                i3 = 27;
                                i4 = 25;
                                f(i4, i3);
                            }
                        } else if (d(i43, i44, i45, j4, j5)) {
                            if (i20 > i23) {
                                i20 = 4;
                            }
                            int[] iArr7 = this.f1532e;
                            int i47 = this.i;
                            this.i = i47 + 1;
                            iArr7[i47] = 46;
                        }
                        if (i19 == i21) {
                            i23 = 4;
                        }
                    }
                }
                if (i20 != Integer.MAX_VALUE) {
                    this.l = i20;
                    this.k = i18;
                    i20 = Integer.MAX_VALUE;
                }
                i18++;
                i19 = this.i;
                this.i = i21;
                i21 = 50 - i21;
                if (i19 == i21) {
                    return i18;
                }
                try {
                    this.f1533f = this.f1530c.k();
                    i16 = 1;
                    i15 = 0;
                    i17 = Integer.MAX_VALUE;
                } catch (java.io.IOException unused) {
                    return i18;
                }
            }
            if (i20 != Integer.MAX_VALUE) {
                this.l = i20;
                this.k = i18;
                i20 = Integer.MAX_VALUE;
            }
            i18++;
            i19 = this.i;
            this.i = i21;
            i21 = 50 - i21;
            if (i19 == i21) {
                return i18;
            }try {

            this.f1533f = this.f1530c.k();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
            i16 = 1;
            i15 = 0;
            i17 = Integer.MAX_VALUE;
        }
    }

    private int l0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return F0(4, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'A') {
                return p0(j5, 8704L, j6, 0L);
            }
            if (cK == 'E') {
                return (2199023255552L & j5) != 0 ? G0(6, 41) : p0(j5, 36028797018963968L, j6, 0L);
            }
            if (cK == 'L') {
                return (256 & j5) != 0 ? G0(6, 8) : p0(j5, 292057827328L, j6, 0L);
            }
            if (cK == 'a') {
                return p0(j5, 0L, j6, 8L);
            }
            if (cK == 'e') {
                return (4611686018427387904L & j5) != 0 ? G0(6, 62) : p0(j5, Long.MIN_VALUE, j6, 0L);
            }
            if (cK == 'i') {
                return p0(j5, 0L, j6, 1L);
            }
            if (cK == 'o') {
                return p0(j5, 0L, j6, 128L);
            }
            if (cK == 'r') {
                return p0(j5, 0L, j6, 6L);
            }
            if (cK == 'O') {
                return p0(j5, 549755814016L, j6, 0L);
            }
            if (cK != 'P') {
                if (cK != 'T') {
                    if (cK == 'U') {
                        return p0(j5, 5120L, j6, 0L);
                    }
                } else {
                    if ((4294967296L & j5) != 0) {
                        return G0(6, 32);
                    }
                    if ((1099511627776L & j5) != 0) {
                        return G0(6, 40);
                    }
                }
            } else {
                if ((68719476736L & j5) != 0) {
                    return G0(6, 36);
                }
                if ((137438953472L & j5) != 0) {
                    return G0(6, 37);
                }
                if ((18014398509481984L & j5) != 0) {
                    return G0(6, 54);
                }
            }
            return F0(5, j5, j6);
        } catch (java.io.IOException unused) {
            K0(5, j5, j6);
            return 6;
        }
    }

    private int m() {
        char c2 = this.f1533f;
        if (c2 == '\t') {
            return y0(0, 2, 52);
        }
        if (c2 == '\f') {
            return y0(0, 3, 52);
        }
        if (c2 == ' ') {
            return y0(0, 1, 52);
        }
        if (c2 == '.') {
            return O(-4611686018427387904L, 3071L);
        }
        if (c2 == 'f') {
            return O(288230376151711744L, 0L);
        }
        if (c2 == 'n') {
            return O(72057594037927936L, 0L);
        }
        if (c2 == 't') {
            return O(144115188075855872L, 0L);
        }
        if (c2 == 'I') {
            return O(8796093022208L, 0L);
        }
        if (c2 == 'J') {
            return O(134217728L, 0L);
        }
        switch (c2) {
            case 'A':
                return O(131072L, 0L);
            case 'B':
                return O(263882790666240L, 0L);
            case 'C':
                return O(1128107587141632L, 0L);
            case 'D':
                return O(1048576L, 0L);
            case 'E':
                return O(268435456L, 0L);
            case 'F':
                return O(2252005972115456L, 0L);
            case 'G':
                return O(4503599627374080L, 0L);
            default:
                switch (c2) {
                    case 'L':
                        return O(1644167616L, 0L);
                    case 'M':
                        return O(2621472L, 0L);
                    case 'N':
                        return O(16809984L, 0L);
                    case 'O':
                        return O(9007199254740992L, 0L);
                    case 'P':
                        return O(4194304L, 0L);
                    default:
                        switch (c2) {
                            case 'R':
                                return O(34359738368L, 0L);
                            case 'S':
                                return O(54888719970562048L, 0L);
                            case 'T':
                                return O(848256040960L, 0L);
                            case 'U':
                                return O(8388608L, 0L);
                            case 'V':
                                return O(4398046511104L, 0L);
                            default:
                                return i(0, 0);
                        }
                }
        }
    }

    private int m0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return C0(5, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'E') {
                if (cK != 'L') {
                    if (cK != 'P') {
                        if (cK == 'X') {
                            return q0(j5, 36028797018963968L, j6, 0L);
                        }
                        if (cK == 'a') {
                            return q0(j5, 0L, j6, 6L);
                        }
                        if (cK == 'c') {
                            return q0(j5, 0L, j6, 136L);
                        }
                        if (cK == 'f') {
                            return q0(j5, Long.MIN_VALUE, j6, 0L);
                        }
                        if (cK == 'n') {
                            return q0(j5, 0L, j6, 1L);
                        }
                    } else {
                        if ((1024 & j5) != 0) {
                            return y0(7, 10, 1);
                        }
                        if ((4096 & j5) != 0) {
                            return y0(7, 12, 1);
                        }
                        if ((549755813888L & j5) != 0) {
                            return y0(7, 39, 1);
                        }
                    }
                } else {
                    if ((128 & j5) != 0) {
                        return y0(7, 7, 1);
                    }
                    if ((512 & j5) != 0) {
                        return y0(7, 9, 1);
                    }
                    if ((8192 & j5) != 0) {
                        return y0(7, 13, 1);
                    }
                    if ((17179869184L & j5) != 0) {
                        return y0(7, 34, 1);
                    }
                    if ((274877906944L & j5) != 0) {
                        return y0(7, 38, 1);
                    }
                }
            } else {
                if ((2048 & j5) != 0) {
                    return y0(7, 11, 1);
                }
                if ((16384 & j5) != 0) {
                    return y0(7, 14, 1);
                }
                if ((32768 & j5) != 0) {
                    return y0(7, 15, 1);
                }
            }
            return C0(6, j5, j6);
        } catch (java.io.IOException unused) {
            H0(6, j5, j6);
            return 7;
        }
    }

    private int n() {
        char c2 = this.f1533f;
        if (c2 == '\t') {
            return z0(0, 2, 51);
        }
        if (c2 == '\f') {
            return z0(0, 3, 51);
        }
        if (c2 == ' ') {
            return z0(0, 1, 51);
        }
        if (c2 == '.') {
            return P(-4611686018427387904L, 3071L);
        }
        if (c2 == 'f') {
            return P(288230376151711744L, 0L);
        }
        if (c2 == 'n') {
            return P(72057594037927936L, 0L);
        }
        if (c2 == 't') {
            return P(144115188075855872L, 0L);
        }
        if (c2 == 'I') {
            return P(8796093022208L, 0L);
        }
        if (c2 == 'J') {
            return P(134217728L, 0L);
        }
        switch (c2) {
            case 'A':
                return P(131072L, 0L);
            case 'B':
                return P(263882790666240L, 0L);
            case 'C':
                return P(1128107587141632L, 0L);
            case 'D':
                return P(1048576L, 0L);
            case 'E':
                return P(268435456L, 0L);
            case 'F':
                return P(2252005972115456L, 0L);
            case 'G':
                return P(4503599627374080L, 0L);
            default:
                switch (c2) {
                    case 'L':
                        return P(1644167616L, 0L);
                    case 'M':
                        return P(2621472L, 0L);
                    case 'N':
                        return P(16809984L, 0L);
                    case 'O':
                        return P(9007199254740992L, 0L);
                    case 'P':
                        return P(4194304L, 0L);
                    default:
                        switch (c2) {
                            case 'R':
                                return P(34359738368L, 0L);
                            case 'S':
                                return P(54888719970562048L, 0L);
                            case 'T':
                                return P(848256040960L, 0L);
                            case 'U':
                                return P(8388608L, 0L);
                            case 'V':
                                return P(4398046511104L, 0L);
                            default:
                                return j(6, 0);
                        }
                }
        }
    }

    private int n0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return D0(5, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'E') {
                if (cK != 'L') {
                    if (cK != 'P') {
                        if (cK == 'X') {
                            return r0(j5, 36028797018963968L, j6, 0L);
                        }
                        if (cK == 'a') {
                            return r0(j5, 0L, j6, 6L);
                        }
                        if (cK == 'c') {
                            return r0(j5, 0L, j6, 136L);
                        }
                        if (cK == 'f') {
                            return r0(j5, Long.MIN_VALUE, j6, 0L);
                        }
                        if (cK == 'n') {
                            return r0(j5, 0L, j6, 1L);
                        }
                    } else {
                        if ((1024 & j5) != 0) {
                            return G0(7, 10);
                        }
                        if ((4096 & j5) != 0) {
                            return G0(7, 12);
                        }
                        if ((549755813888L & j5) != 0) {
                            return G0(7, 39);
                        }
                    }
                } else {
                    if ((128 & j5) != 0) {
                        return G0(7, 7);
                    }
                    if ((512 & j5) != 0) {
                        return G0(7, 9);
                    }
                    if ((8192 & j5) != 0) {
                        return G0(7, 13);
                    }
                    if ((17179869184L & j5) != 0) {
                        return G0(7, 34);
                    }
                    if ((274877906944L & j5) != 0) {
                        return G0(7, 38);
                    }
                }
            } else {
                if ((2048 & j5) != 0) {
                    return G0(7, 11);
                }
                if ((16384 & j5) != 0) {
                    return G0(7, 14);
                }
                if ((32768 & j5) != 0) {
                    return G0(7, 15);
                }
            }
            return D0(6, j5, j6);
        } catch (java.io.IOException unused) {
            I0(6, j5, j6);
            return 7;
        }
    }

    private int o() {
        char c2 = this.f1533f;
        if (c2 == '\t') {
            return A0(0, 2, 51);
        }
        if (c2 == '\f') {
            return A0(0, 3, 51);
        }
        if (c2 == ' ') {
            return A0(0, 1, 51);
        }
        if (c2 == '.') {
            return Q(-4611686018427387904L, 3071L);
        }
        if (c2 == 'f') {
            return Q(288230376151711744L, 0L);
        }
        if (c2 == 'n') {
            return Q(72057594037927936L, 0L);
        }
        if (c2 == 't') {
            return Q(144115188075855872L, 0L);
        }
        if (c2 == 'I') {
            return Q(8796093022208L, 0L);
        }
        if (c2 == 'J') {
            return Q(134217728L, 0L);
        }
        switch (c2) {
            case 'A':
                return Q(131072L, 0L);
            case 'B':
                return Q(263882790666240L, 0L);
            case 'C':
                return Q(1128107587141632L, 0L);
            case 'D':
                return Q(1048576L, 0L);
            case 'E':
                return Q(268435456L, 0L);
            case 'F':
                return Q(2252005972115456L, 0L);
            case 'G':
                return Q(4503599627374080L, 0L);
            default:
                switch (c2) {
                    case 'L':
                        return Q(1644167616L, 0L);
                    case 'M':
                        return Q(2621472L, 0L);
                    case 'N':
                        return Q(16809984L, 0L);
                    case 'O':
                        return Q(9007199254740992L, 0L);
                    case 'P':
                        return Q(4194304L, 0L);
                    default:
                        switch (c2) {
                            case 'R':
                                return Q(34359738368L, 0L);
                            case 'S':
                                return Q(54888719970562048L, 0L);
                            case 'T':
                                return Q(848256040960L, 0L);
                            case 'U':
                                return Q(8388608L, 0L);
                            case 'V':
                                return Q(4398046511104L, 0L);
                            default:
                                return k(6, 0);
                        }
                }
        }
    }

    private int o0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return E0(5, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'E') {
                if (cK != 'L') {
                    if (cK != 'P') {
                        if (cK == 'X') {
                            return s0(j5, 36028797018963968L, j6, 0L);
                        }
                        if (cK == 'a') {
                            return s0(j5, 0L, j6, 6L);
                        }
                        if (cK == 'c') {
                            return s0(j5, 0L, j6, 136L);
                        }
                        if (cK == 'f') {
                            return s0(j5, Long.MIN_VALUE, j6, 0L);
                        }
                        if (cK == 'n') {
                            return s0(j5, 0L, j6, 1L);
                        }
                    } else {
                        if ((1024 & j5) != 0) {
                            return G0(7, 10);
                        }
                        if ((4096 & j5) != 0) {
                            return G0(7, 12);
                        }
                        if ((549755813888L & j5) != 0) {
                            return G0(7, 39);
                        }
                    }
                } else {
                    if ((128 & j5) != 0) {
                        return G0(7, 7);
                    }
                    if ((512 & j5) != 0) {
                        return G0(7, 9);
                    }
                    if ((8192 & j5) != 0) {
                        return G0(7, 13);
                    }
                    if ((17179869184L & j5) != 0) {
                        return G0(7, 34);
                    }
                    if ((274877906944L & j5) != 0) {
                        return G0(7, 38);
                    }
                }
            } else {
                if ((2048 & j5) != 0) {
                    return G0(7, 11);
                }
                if ((16384 & j5) != 0) {
                    return G0(7, 14);
                }
                if ((32768 & j5) != 0) {
                    return G0(7, 15);
                }
            }
            return E0(6, j5, j6);
        } catch (java.io.IOException unused) {
            J0(6, j5, j6);
            return 7;
        }
    }

    private int p() {
        char c2 = this.f1533f;
        if (c2 == '\t') {
            return B0(0, 2, 50);
        }
        if (c2 == '\f') {
            return B0(0, 3, 50);
        }
        if (c2 == ' ') {
            return B0(0, 1, 50);
        }
        if (c2 == '.') {
            return R(-4611686018427387904L, 3071L);
        }
        if (c2 == '[') {
            return G0(0, 88);
        }
        if (c2 == ']') {
            return G0(0, 89);
        }
        if (c2 == 'f') {
            return R(288230376151711744L, 0L);
        }
        if (c2 == 'n') {
            return R(72057594037927936L, 0L);
        }
        if (c2 == 't') {
            return R(144115188075855872L, 0L);
        }
        if (c2 == 'I') {
            return R(8796093022208L, 0L);
        }
        if (c2 == 'J') {
            return R(134217728L, 0L);
        }
        switch (c2) {
            case 'A':
                return R(131072L, 0L);
            case 'B':
                return R(263882790666240L, 0L);
            case 'C':
                return R(1128107587141632L, 0L);
            case 'D':
                return R(1048576L, 0L);
            case 'E':
                return R(268435456L, 0L);
            case 'F':
                return R(2252005972115456L, 0L);
            case 'G':
                return R(4503599627374080L, 0L);
            default:
                switch (c2) {
                    case 'L':
                        return R(1644167616L, 0L);
                    case 'M':
                        return R(2621472L, 0L);
                    case 'N':
                        return R(16809984L, 0L);
                    case 'O':
                        return R(9007199254740992L, 0L);
                    case 'P':
                        return R(4194304L, 0L);
                    default:
                        switch (c2) {
                            case 'R':
                                return R(34359738368L, 0L);
                            case 'S':
                                return R(54888719970562048L, 0L);
                            case 'T':
                                return R(848256040960L, 0L);
                            case 'U':
                                return R(8388608L, 0L);
                            case 'V':
                                return R(4398046511104L, 0L);
                            default:
                                return l(6, 0);
                        }
                }
        }
    }

    private int p0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return F0(5, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'E') {
                if (cK != 'L') {
                    if (cK != 'P') {
                        if (cK == 'X') {
                            return t0(j5, 36028797018963968L, j6, 0L);
                        }
                        if (cK == 'a') {
                            return t0(j5, 0L, j6, 6L);
                        }
                        if (cK == 'c') {
                            return t0(j5, 0L, j6, 136L);
                        }
                        if (cK == 'f') {
                            return t0(j5, Long.MIN_VALUE, j6, 0L);
                        }
                        if (cK == 'n') {
                            return t0(j5, 0L, j6, 1L);
                        }
                    } else {
                        if ((1024 & j5) != 0) {
                            return G0(7, 10);
                        }
                        if ((4096 & j5) != 0) {
                            return G0(7, 12);
                        }
                        if ((549755813888L & j5) != 0) {
                            return G0(7, 39);
                        }
                    }
                } else {
                    if ((128 & j5) != 0) {
                        return G0(7, 7);
                    }
                    if ((512 & j5) != 0) {
                        return G0(7, 9);
                    }
                    if ((8192 & j5) != 0) {
                        return G0(7, 13);
                    }
                    if ((17179869184L & j5) != 0) {
                        return G0(7, 34);
                    }
                    if ((274877906944L & j5) != 0) {
                        return G0(7, 38);
                    }
                }
            } else {
                if ((2048 & j5) != 0) {
                    return G0(7, 11);
                }
                if ((16384 & j5) != 0) {
                    return G0(7, 14);
                }
                if ((32768 & j5) != 0) {
                    return G0(7, 15);
                }
            }
            return F0(6, j5, j6);
        } catch (java.io.IOException unused) {
            K0(6, j5, j6);
            return 7;
        }
    }

    private int q(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return C0(8, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'e') {
                return cK != 'i' ? C0(9, j5, j6) : u(j5, 0L, j6, 8L);
            }
            return u(j5, Long.MIN_VALUE, j6, 1L);
        } catch (java.io.IOException unused) {
            H0(9, j5, j6);
            return 10;
        }
    }

    private int q0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return C0(6, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'T') {
                if (cK == 'a') {
                    return u0(j5, 0L, j6, 128L);
                }
                if (cK == 'e') {
                    return u0(j5, 0L, j6, 1L);
                }
                if (cK == 'i') {
                    return u0(j5, Long.MIN_VALUE, j6, 0L);
                }
                if (cK == 'k') {
                    return u0(j5, 0L, j6, 8L);
                }
                if (cK == 'm') {
                    return u0(j5, 0L, j6, 2L);
                }
                if (cK == 'r') {
                    return u0(j5, 0L, j6, 4L);
                }
            } else if ((36028797018963968L & j5) != 0) {
                return y0(8, 55, 1);
            }
            return C0(7, j5, j6);
        } catch (java.io.IOException unused) {
            H0(7, j5, j6);
            return 8;
        }
    }

    private int r(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return D0(8, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'e') {
                return cK != 'i' ? D0(9, j5, j6) : v(j5, 0L, j6, 8L);
            }
            return v(j5, Long.MIN_VALUE, j6, 1L);
        } catch (java.io.IOException unused) {
            I0(9, j5, j6);
            return 10;
        }
    }

    private int r0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return D0(6, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'T') {
                if (cK == 'a') {
                    return v0(j5, 0L, j6, 128L);
                }
                if (cK == 'e') {
                    return v0(j5, 0L, j6, 1L);
                }
                if (cK == 'i') {
                    return v0(j5, Long.MIN_VALUE, j6, 0L);
                }
                if (cK == 'k') {
                    return v0(j5, 0L, j6, 8L);
                }
                if (cK == 'm') {
                    return v0(j5, 0L, j6, 2L);
                }
                if (cK == 'r') {
                    return v0(j5, 0L, j6, 4L);
                }
            } else if ((36028797018963968L & j5) != 0) {
                return G0(8, 55);
            }
            return D0(7, j5, j6);
        } catch (java.io.IOException unused) {
            I0(7, j5, j6);
            return 8;
        }
    }

    private int s(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return E0(8, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'e') {
                return cK != 'i' ? E0(9, j5, j6) : w(j5, 0L, j6, 8L);
            }
            return w(j5, Long.MIN_VALUE, j6, 1L);
        } catch (java.io.IOException unused) {
            J0(9, j5, j6);
            return 10;
        }
    }

    private int s0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return E0(6, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'T') {
                if (cK == 'a') {
                    return w0(j5, 0L, j6, 128L);
                }
                if (cK == 'e') {
                    return w0(j5, 0L, j6, 1L);
                }
                if (cK == 'i') {
                    return w0(j5, Long.MIN_VALUE, j6, 0L);
                }
                if (cK == 'k') {
                    return w0(j5, 0L, j6, 8L);
                }
                if (cK == 'm') {
                    return w0(j5, 0L, j6, 2L);
                }
                if (cK == 'r') {
                    return w0(j5, 0L, j6, 4L);
                }
            } else if ((36028797018963968L & j5) != 0) {
                return G0(8, 55);
            }
            return E0(7, j5, j6);
        } catch (java.io.IOException unused) {
            J0(7, j5, j6);
            return 8;
        }
    }

    private int t(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return F0(8, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'e') {
                return cK != 'i' ? F0(9, j5, j6) : x(j5, 0L, j6, 8L);
            }
            return x(j5, Long.MIN_VALUE, j6, 1L);
        } catch (java.io.IOException unused) {
            K0(9, j5, j6);
            return 10;
        }
    }

    private int t0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return F0(6, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'T') {
                if (cK == 'a') {
                    return x0(j5, 0L, j6, 128L);
                }
                if (cK == 'e') {
                    return x0(j5, 0L, j6, 1L);
                }
                if (cK == 'i') {
                    return x0(j5, Long.MIN_VALUE, j6, 0L);
                }
                if (cK == 'k') {
                    return x0(j5, 0L, j6, 8L);
                }
                if (cK == 'm') {
                    return x0(j5, 0L, j6, 2L);
                }
                if (cK == 'r') {
                    return x0(j5, 0L, j6, 4L);
                }
            } else if ((36028797018963968L & j5) != 0) {
                return G0(8, 55);
            }
            return F0(7, j5, j6);
        } catch (java.io.IOException unused) {
            K0(7, j5, j6);
            return 8;
        }
    }

    private int u(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return C0(9, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'd') {
                if (cK == 'f') {
                    return y(j5, 0L, j6, 1L);
                }
                if (cK == 'z') {
                    return y(j5, 0L, j6, 8L);
                }
            } else if ((Long.MIN_VALUE & j5) != 0) {
                return G0(11, 63);
            }
            return C0(10, j5, j6);
        } catch (java.io.IOException unused) {
            H0(10, j5, j6);
            return 11;
        }
    }

    private int u0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return C0(7, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'd') {
                return q(j5, 0L, j6, 1L);
            }
            if (cK != 'g') {
                if (cK != 'l') {
                    if (cK == 'n') {
                        return q(j5, Long.MIN_VALUE, j6, 0L);
                    }
                    if (cK == 's') {
                        return (2 & j6) != 0 ? G0(9, 65) : q(j5, 0L, j6, 8L);
                    }
                } else if ((128 & j6) != 0) {
                    return G0(9, 71);
                }
            } else if ((4 & j6) != 0) {
                return G0(9, 66);
            }
            return C0(8, j5, j6);
        } catch (java.io.IOException unused) {
            H0(8, j5, j6);
            return 9;
        }
    }

    private int v(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return D0(9, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'd') {
                if (cK == 'f') {
                    return z(j5, 0L, j6, 1L);
                }
                if (cK == 'z') {
                    return z(j5, 0L, j6, 8L);
                }
            } else if ((Long.MIN_VALUE & j5) != 0) {
                return G0(11, 63);
            }
            return D0(10, j5, j6);
        } catch (java.io.IOException unused) {
            I0(10, j5, j6);
            return 11;
        }
    }

    private int v0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return D0(7, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'd') {
                return r(j5, 0L, j6, 1L);
            }
            if (cK != 'g') {
                if (cK != 'l') {
                    if (cK == 'n') {
                        return r(j5, Long.MIN_VALUE, j6, 0L);
                    }
                    if (cK == 's') {
                        return (2 & j6) != 0 ? G0(9, 65) : r(j5, 0L, j6, 8L);
                    }
                } else if ((128 & j6) != 0) {
                    return G0(9, 71);
                }
            } else if ((4 & j6) != 0) {
                return G0(9, 66);
            }
            return D0(8, j5, j6);
        } catch (java.io.IOException unused) {
            I0(8, j5, j6);
            return 9;
        }
    }

    private int w(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return E0(9, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'd') {
                if (cK == 'f') {
                    return A(j5, 0L, j6, 1L);
                }
                if (cK == 'z') {
                    return A(j5, 0L, j6, 8L);
                }
            } else if ((Long.MIN_VALUE & j5) != 0) {
                return G0(11, 63);
            }
            return E0(10, j5, j6);
        } catch (java.io.IOException unused) {
            J0(10, j5, j6);
            return 11;
        }
    }

    private int w0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return E0(7, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'd') {
                return s(j5, 0L, j6, 1L);
            }
            if (cK != 'g') {
                if (cK != 'l') {
                    if (cK == 'n') {
                        return s(j5, Long.MIN_VALUE, j6, 0L);
                    }
                    if (cK == 's') {
                        return (2 & j6) != 0 ? G0(9, 65) : s(j5, 0L, j6, 8L);
                    }
                } else if ((128 & j6) != 0) {
                    return G0(9, 71);
                }
            } else if ((4 & j6) != 0) {
                return G0(9, 66);
            }
            return E0(8, j5, j6);
        } catch (java.io.IOException unused) {
            J0(8, j5, j6);
            return 9;
        }
    }

    private int x(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return F0(9, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'd') {
                if (cK == 'f') {
                    return B(j5, 0L, j6, 1L);
                }
                if (cK == 'z') {
                    return B(j5, 0L, j6, 8L);
                }
            } else if ((Long.MIN_VALUE & j5) != 0) {
                return G0(11, 63);
            }
            return F0(10, j5, j6);
        } catch (java.io.IOException unused) {
            K0(10, j5, j6);
            return 11;
        }
    }

    private int x0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return F0(7, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK == 'd') {
                return t(j5, 0L, j6, 1L);
            }
            if (cK != 'g') {
                if (cK != 'l') {
                    if (cK == 'n') {
                        return t(j5, Long.MIN_VALUE, j6, 0L);
                    }
                    if (cK == 's') {
                        return (2 & j6) != 0 ? G0(9, 65) : t(j5, 0L, j6, 8L);
                    }
                } else if ((128 & j6) != 0) {
                    return G0(9, 71);
                }
            } else if ((4 & j6) != 0) {
                return G0(9, 66);
            }
            return F0(8, j5, j6);
        } catch (java.io.IOException unused) {
            K0(8, j5, j6);
            return 9;
        }
    }

    private int y(long j, long j2, long j3, long j4) {
        long j5 = j4 & j3;
        if (((j2 & j) | j5) == 0) {
            return C0(10, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'e') {
                if (cK == 'i') {
                    return C(j5, 1L);
                }
            } else if ((8 & j5) != 0) {
                return G0(12, 67);
            }
            return C0(11, 0L, j5);
        } catch (java.io.IOException unused) {
            H0(11, 0L, j5);
            return 12;
        }
    }

    private int y0(int i, int i2, int i3) {
        this.l = i2;
        this.k = i;
        try {
            this.f1533f = this.f1530c.k();
            return i(i3, i + 1);
        } catch (java.io.IOException unused) {
            return i + 1;
        }
    }

    private int z(long j, long j2, long j3, long j4) {
        long j5 = j4 & j3;
        if (((j2 & j) | j5) == 0) {
            return D0(10, j, j3);
        }
        try {
            char cK = this.f1530c.k();
            this.f1533f = cK;
            if (cK != 'e') {
                if (cK == 'i') {
                    return D(j5, 1L);
                }
            } else if ((8 & j5) != 0) {
                return G0(12, 67);
            }
            return D0(11, 0L, j5);
        } catch (java.io.IOException unused) {
            I0(11, 0L, j5);
            return 12;
        }
    }

    private int z0(int i, int i2, int i3) {
        this.l = i2;
        this.k = i;
        try {
            this.f1533f = this.f1530c.k();
            return j(i3, i + 1);
        } catch (java.io.IOException unused) {
            return i + 1;
        }
    }

    public f b() {
        int i;
        boolean z;
        int i2;
        java.lang.String strD;
        java.lang.String strD2 = null;
        f fVar = null;
        int iM = 0;
        while (true) {
            try {
                this.f1533f = this.f1530c.a();
                int i3 = this.f1534g;
                if (i3 == 0) {
                    this.l = Integer.MAX_VALUE;
                    this.k = 0;
                    iM = m();
                } else if (i3 == 1) {
                    this.l = Integer.MAX_VALUE;
                    this.k = 0;
                    iM = n();
                } else if (i3 == 2) {
                    this.l = Integer.MAX_VALUE;
                    this.k = 0;
                    iM = o();
                } else if (i3 == 3) {
                    this.l = Integer.MAX_VALUE;
                    this.k = 0;
                    iM = p();
                }
                if (this.l == Integer.MAX_VALUE) {
                    int iJ = this.f1530c.j();
                    int i4 = this.f1530c.i();
                    try {
                        this.f1530c.k();
                        this.f1530c.f(1);
                        i = iJ;
                        i2 = i4;
                        z = false;
                    } catch (java.io.IOException unused) {
                        strD2 = iM <= 1 ? "" : this.f1530c.d();
                        char c2 = this.f1533f;
                        if (c2 == '\n' || c2 == '\r') {
                            i = iJ + 1;
                            z = true;
                            i2 = 0;
                        } else {
                            i2 = i4 + 1;
                            i = iJ;
                            z = true;
                        }
                    }
                    if (z) {
                        strD = strD2;
                    } else {
                        this.f1530c.f(1);
                        strD = iM > 1 ? this.f1530c.d() : "";
                    }
                    throw new lasm.c(z, this.f1534g, i, i2, strD, this.f1533f, 0);
                }
                int i5 = this.k;
                if (i5 + 1 < iM) {
                    this.f1530c.f((iM - i5) - 1);
                }
                long[] jArr = s;
                int i6 = this.l;
                if ((jArr[i6 >> 6] & (1 << (i6 & 63))) != 0) {
                    f fVarH = h();
                    fVarH.h = fVar;
                    int i7 = r[this.l];
                    if (i7 != -1) {
                        this.f1534g = i7;
                    }
                    return fVarH;
                }
                if (((1 << (i6 & 63)) & u[i6 >> 6]) != 0) {
                    f fVarH2 = h();
                    if (fVar != null) {
                        fVarH2.h = fVar;
                        fVar.f1552g = fVarH2;
                    }
                    fVar = fVarH2;
                }
                int i8 = r[this.l];
                if (i8 != -1) {
                    this.f1534g = i8;
                }
            } catch (java.io.IOException unused2) {
                this.l = 0;
                f fVarH3 = h();
                fVarH3.h = fVar;
                return fVarH3;
            }
        }
    }

    protected f h() {
        java.lang.String strD = p[this.l];
        if (strD == null) {
            strD = this.f1530c.d();
        }
        int iH = this.f1530c.h();
        int iG = this.f1530c.g();
        int iJ = this.f1530c.j();
        int i = this.f1530c.i();
        f fVarA = f.a(this.l, strD);
        fVarA.f1547b = iH;
        fVarA.f1549d = iJ;
        fVarA.f1548c = iG;
        fVarA.f1550e = i;
        return fVarA;
    }
}
