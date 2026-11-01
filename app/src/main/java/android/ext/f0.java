package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0 {
    public static volatile boolean v = false;
    public static volatile boolean w = false;
    public static volatile boolean x = false;
    static android.ext.f0$n0 y;
    private static final java.util.List z = new java.util.ArrayList();
    private static boolean A = true;
    static volatile java.lang.String B = null;
    private static volatile java.lang.String C = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.ext.f0$n0 f792a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    java.util.concurrent.Exchanger f794c = new java.util.concurrent.Exchanger();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f795d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile int f796e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile int f797f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile java.lang.String f798g = "???";
    private volatile int h = 0;
    private volatile int i = 0;
    private volatile long j = 0;
    private volatile long k = -1;
    private volatile long l = 0;
    java.lang.Thread m = new android.ext.f0$d0(this, "mReaderThread");
    private volatile int n = 1;
    private volatile int o = 1;
    private volatile long p = 0;
    private final java.util.ArrayList q = new java.util.ArrayList();
    private final java.util.ArrayList r = new java.util.ArrayList();
    private final java.util.ArrayList s = new java.util.ArrayList();
    long t = 0;
    private java.lang.Integer u = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final android.ext.InOut f793b = new android.ext.InOut();

    private int A(byte b2) {
        android.ext.h2[] h2VarArr;
        java.util.ArrayList arrayList = this.s;
        synchronized (arrayList) {
            try {
                h2VarArr = (android.ext.h2[]) arrayList.toArray(new android.ext.h2[arrayList.size()]);
                arrayList.clear();
                arrayList.trimToSize();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        int length = h2VarArr.length;
        if (length != 0) {
            android.ext.n2.j(new android.ext.f0$r(this, h2VarArr, b2));
        }
        return length;
    }

    private boolean[] I(int i) {
        return (i == 1 ? android.ext.MainService.instance.o0 : android.ext.MainService.instance.n0).b();
    }

    private java.lang.String[] K(boolean z2, java.lang.String str, java.io.File file) {
        java.lang.String[] strArr = new java.lang.String[5];
        strArr[0] = str;
        strArr[1] = android.ext.Tools.C0();
        strArr[2] = file.getAbsolutePath();
        strArr[3] = T();
        strArr[4] = android.ext.Config.C ? "1" : "0";
        if (z2) {
            return strArr;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("exec");
        for (int i = 0; i < 5; i++) {
            java.lang.String str2 = strArr[i];
            sb.append(' ');
            sb.append(str2);
        }
        return new java.lang.String[]{sb.toString()};
    }

    static android.ext.f0$j0 M0(java.util.List list, boolean z2) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            android.ext.c cVar = (android.ext.c) list.get(i);
            if (cVar != null) {
                arrayList.add(new android.ext.f0$m0(android.ext.e.a(cVar.f672a, z2), cVar.f674c));
            }
        }
        android.ext.f0$m0[] f0_m0Arr = (android.ext.f0$m0[]) arrayList.toArray(new android.ext.f0$m0[arrayList.size()]);
        java.util.Arrays.sort(f0_m0Arr);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(f0_m0Arr.length);
        android.ext.f0$m0 f0_m0 = null;
        for (android.ext.f0$m0 f0_m1 : f0_m0Arr) {
            if (f0_m1 != null) {
                if (f0_m0 == null || f0_m0.f907a != f0_m1.f907a) {
                    arrayList2.add(f0_m1);
                    f0_m0 = f0_m1;
                } else {
                    f0_m0.f908b = f0_m1.f908b | f0_m0.f908b;
                }
            }
        }
        int size2 = arrayList2.size();
        long[] jArr = new long[size2];
        int[] iArr = new int[size2];
        int i2 = 0;
        for (int i3 = 0; i3 < size2; i3++) {
            android.ext.f0$m0 f0_m2 = (android.ext.f0$m0) arrayList2.get(i3);
            jArr[i3] = f0_m2.f907a;
            int i4 = f0_m2.f908b;
            iArr[i3] = i4;
            i2 |= i4;
        }
        android.ext.f0$j0 f0_j0 = new android.ext.f0$j0(jArr, iArr);
        f0_j0.f889c = i2 & 127;
        return f0_j0;
    }

    private void R0() {
        this.f795d = false;
    }

    /* JADX WARN: Code duplicated, block: B:155:0x030c A[Catch: all -> 0x033e, TryCatch #17 {all -> 0x033e, blocks: (B:151:0x02e9, B:152:0x0303, B:155:0x030c, B:159:0x0339, B:158:0x0317, B:162:0x0342), top: B:217:0x02e9 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x0316  */
    /* JADX WARN: Code duplicated, block: B:158:0x0317 A[Catch: all -> 0x033e, TryCatch #17 {all -> 0x033e, blocks: (B:151:0x02e9, B:152:0x0303, B:155:0x030c, B:159:0x0339, B:158:0x0317, B:162:0x0342), top: B:217:0x02e9 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x0367 A[Catch: all -> 0x0392, TryCatch #13 {all -> 0x0392, blocks: (B:163:0x034b, B:165:0x0367, B:178:0x0395, B:168:0x0370, B:170:0x037b, B:172:0x0381, B:174:0x038d, B:179:0x0398), top: B:210:0x034b }] */
    /* JADX WARN: Code duplicated, block: B:167:0x036f  */
    /* JADX WARN: Code duplicated, block: B:168:0x0370 A[Catch: all -> 0x0392, TryCatch #13 {all -> 0x0392, blocks: (B:163:0x034b, B:165:0x0367, B:178:0x0395, B:168:0x0370, B:170:0x037b, B:172:0x0381, B:174:0x038d, B:179:0x0398), top: B:210:0x034b }] */
    /* JADX WARN: Code duplicated, block: B:170:0x037b A[Catch: all -> 0x0392, TryCatch #13 {all -> 0x0392, blocks: (B:163:0x034b, B:165:0x0367, B:178:0x0395, B:168:0x0370, B:170:0x037b, B:172:0x0381, B:174:0x038d, B:179:0x0398), top: B:210:0x034b }] */
    /* JADX WARN: Code duplicated, block: B:231:0x0395 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static java.lang.String S0(java.lang.String str) {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.io.File file;
        java.lang.String str5;
        java.lang.String string = null;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        java.lang.String str9;
        java.lang.String strTrim;
        java.lang.StringBuilder sb;
        int i;
        java.lang.String str10;
        java.lang.String string2;
        int i2 = 0;
        java.lang.String str11;
        java.io.File file2;
        java.lang.String str12;
        java.lang.String str13;
        java.lang.String str14 = str;
        java.lang.String str15 = "\n";
        try {
            java.io.File file3 = new java.io.File(str14);
            if (!file3.exists() || !file3.canExecute()) {
                return null;
            }
            java.lang.String name = file3.getName();
            int i3 = 5;
            java.lang.String[] strArr = {"/system/bin", "/system/xbin", "/sbin/.magisk/mirror/data", "/sbin/.magisk/modules", "/sbin"};
            int i4 = 0;
            while (true) {
                java.lang.String str16 = "exit";
                str3 = "; chmod 0755 ";
                if (i4 < i3) {
                    try {
                        java.io.File file4 = new java.io.File(strArr[i4], name);
                        if (file4.exists() && file4.canExecute() && file3.length() == file4.length()) {
                            return file4.getAbsolutePath();
                        }
                        i4++;
                        i3 = 5;
                    } catch (java.lang.Throwable th_c) {
                        th = th_c;
                        str4 = "/sbin";
                        str15 = "\n";
                        file = file3;
                        str3 = "; chmod 0755 ";
                        string = null;
                        str14 = str14;
                        str5 = "exit";
                    }
                } else {
                    try {
                        java.lang.String[] strArrSplit = android.ext.e2.n("exec mount", 10).split("\n");
                        int length = strArrSplit.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                str6 = null;
                                str7 = null;
                                break;
                            }
                            int i6 = length;
                            java.lang.String str17 = strArrSplit[i5];
                            if (str17 != null && str17.contains(" /system ")) {
                                java.lang.String[] strArrSplit2 = str17.trim().split(" ");
                                int length2 = strArrSplit2.length;
                                int i7 = 0;
                                java.lang.String str18 = null;
                                while (true) {
                                    if (i7 >= length2) {
                                        strTrim = null;
                                        break;
                                    }
                                    java.lang.String[] strArr2 = strArrSplit2;
                                    strTrim = strArrSplit2[i7].trim();
                                    int i8 = length2;
                                    if (!"on".equals(strTrim) && !"type".equals(strTrim) && !"/system".equals(strTrim)) {
                                        if (str18 != null) {
                                            break;
                                        }
                                        str18 = strTrim;
                                    }
                                    i7++;
                                    length2 = i8;
                                    strArrSplit2 = strArr2;
                                }
                                str7 = strTrim;
                                str6 = str18;
                                break;
                            }
                            i5++;
                            length = i6;
                            strArrSplit = strArrSplit;
                        }
                        if (str6 == null) {
                            return null;
                        }
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        str4 = "/sbin";
                        file = file3;
                        try {
                            java.lang.String[] strArr3 = new java.lang.String[2];
                            try {
                                strArr3[0] = "rw";
                                strArr3[1] = "ro";
                                int i9 = 0;
                                for (int i10 = 2; i9 < i10; i10 = 2) {
                                    try {
                                        java.lang.String str19 = strArr3[i9];
                                        java.lang.String[] strArr4 = strArr3;
                                        str8 = str16;
                                        try {
                                            java.lang.String[] strArr5 = new java.lang.String[4];
                                            try {
                                                strArr5[0] = "";
                                                strArr5[1] = "/system/bin/";
                                                int i11 = i9;
                                                strArr5[2] = "/system/xbin/";
                                                strArr5[3] = "/system/sbin/";
                                                int i12 = 0;
                                                for (int i13 = 4; i12 < i13; i13 = 4) {
                                                    try {
                                                        java.lang.String str20 = strArr5[i12];
                                                        str9 = str3;
                                                        java.lang.String[] strArr6 = strArr5;
                                                        try {
                                                            java.lang.String[] strArr7 = new java.lang.String[2];
                                                            try {
                                                                strArr7[0] = str19 + ",remount";
                                                                strArr7[1] = "remount," + str19;
                                                                int i14 = 0;
                                                                while (i14 < 2) {
                                                                    java.lang.String str21 = strArr7[i14];
                                                                    java.lang.String[] strArr8 = strArr7;
                                                                    java.lang.String[] strArr9 = {null, str7};
                                                                    java.lang.String str22 = str7;
                                                                    int i15 = 0;
                                                                    for (int i16 = 2; i15 < i16; i16 = 2) {
                                                                        java.lang.String str23 = strArr9[i15];
                                                                        sb2.append(str20);
                                                                        java.lang.String str24 = str20;
                                                                        sb2.append("mount -o ");
                                                                        sb2.append(str21);
                                                                        if (str23 != null) {
                                                                            sb2.append(" -t ");
                                                                            sb2.append(str23);
                                                                        }
                                                                        sb2.append(" ");
                                                                        sb2.append(str6);
                                                                        sb2.append(" /system; ");
                                                                        i15++;
                                                                        str20 = str24;
                                                                    }
                                                                    i14++;
                                                                    str7 = str22;
                                                                    strArr7 = strArr8;
                                                                }
                                                                i12++;
                                                                strArr5 = strArr6;
                                                                str3 = str9;
                                                            } catch (java.lang.Throwable th2) {
                                                                th = th2;
                                                                str14 = str;
                                                                str15 = "\n";
                                                                str5 = str8;
                                                                str3 = str9;
                                                                string = null;
                                                                android.ext.e1.l("Failed remount 2 " + str14 + str15 + string, th);
                                                                sb = new java.lang.StringBuilder();
                                                                i = 0;
                                                                while (i < 5) {
                                                                    str12 = strArr[i];
                                                                    str13 = str4;
                                                                    if (!str12.startsWith(str13)) {
                                                                        java.io.File file5 = new java.io.File(str12, name);
                                                                        sb.append("cp -f ");
                                                                        sb.append(str14);
                                                                        sb.append(" ");
                                                                        sb.append(file5.getAbsolutePath());
                                                                        sb.append(str3);
                                                                        sb.append(file5.getAbsolutePath());
                                                                        sb.append("; ");
                                                                    }
                                                                    i++;
                                                                    str4 = str13;
                                                                }
                                                                str10 = str4;
                                                                sb.append(str5);
                                                                string2 = sb.toString();
                                                                java.lang.String str25 = string2 + str15 + android.ext.e2.n(string2, 15);
                                                                for (i2 = 0; i2 < 5; i2++) {
                                                                    str11 = strArr[i2];
                                                                    if (!str11.startsWith(str10)) {
                                                                        file2 = new java.io.File(str11, name);
                                                                        if (file2.exists()) {
                                                                            continue;
                                                                        }
                                                                    }
                                                                }
                                                                android.ext.e1.i("Failed remount 3 " + str14 + str15 + str25);
                                                                return null;
                                                            }
                                                        } catch (java.lang.Throwable th3) {
                                                            th = th3;
                                                            str14 = str;
                                                            str15 = "\n";
                                                            str5 = str8;
                                                            str3 = str9;
                                                            string = null;
                                                            android.ext.e1.l("Failed remount 2 " + str14 + str15 + string, th);
                                                            sb = new java.lang.StringBuilder();
                                                            i = 0;
                                                            while (i < 5) {
                                                                str12 = strArr[i];
                                                                str13 = str4;
                                                                if (!str12.startsWith(str13)) {
                                                                    java.io.File file6 = new java.io.File(str12, name);
                                                                    sb.append("cp -f ");
                                                                    sb.append(str14);
                                                                    sb.append(" ");
                                                                    sb.append(file6.getAbsolutePath());
                                                                    sb.append(str3);
                                                                    sb.append(file6.getAbsolutePath());
                                                                    sb.append("; ");
                                                                }
                                                                i++;
                                                                str4 = str13;
                                                            }
                                                            str10 = str4;
                                                            sb.append(str5);
                                                            string2 = sb.toString();
                                                            java.lang.String str26 = string2 + str15 + android.ext.e2.n(string2, 15);
                                                            while (i2 < 5) {
                                                                str11 = strArr[i2];
                                                                if (!str11.startsWith(str10)) {
                                                                    file2 = new java.io.File(str11, name);
                                                                    if (file2.exists()) {
                                                                        continue;
                                                                    }
                                                                }
                                                            }
                                                            android.ext.e1.i("Failed remount 3 " + str14 + str15 + str26);
                                                            return null;
                                                        }
                                                    } catch (java.lang.Throwable th4) {
                                                        th = th4;
                                                        str9 = str3;
                                                    }
                                                }
                                                java.lang.String str27 = str7;
                                                java.lang.String str28 = str3;
                                                try {
                                                    sb2.append("blockdev --set");
                                                    sb2.append(str19);
                                                    sb2.append(" ");
                                                    sb2.append(str6);
                                                    sb2.append("; ");
                                                    if (str19.equals("rw")) {
                                                        int i17 = 0;
                                                        while (i17 < 5) {
                                                            java.lang.String str29 = strArr[i17];
                                                            if (str29.startsWith("/system")) {
                                                                java.io.File file7 = new java.io.File(str29, name);
                                                                sb2.append("cp -f ");
                                                                str14 = str;
                                                                try {
                                                                    sb2.append(str14);
                                                                    sb2.append(" ");
                                                                    sb2.append(file7.getAbsolutePath());
                                                                    str3 = str28;
                                                                    try {
                                                                        sb2.append(str3);
                                                                        sb2.append(file7.getAbsolutePath());
                                                                        sb2.append("; ");
                                                                    } catch (java.lang.Throwable th5) {
                                                                        th = th5;
                                                                        str15 = "\n";
                                                                        str5 = str8;
                                                                        string = null;
                                                                        android.ext.e1.l("Failed remount 2 " + str14 + str15 + string, th);
                                                                        sb = new java.lang.StringBuilder();
                                                                        i = 0;
                                                                        while (i < 5) {
                                                                            str12 = strArr[i];
                                                                            str13 = str4;
                                                                            if (!str12.startsWith(str13)) {
                                                                                java.io.File file8 = new java.io.File(str12, name);
                                                                                sb.append("cp -f ");
                                                                                sb.append(str14);
                                                                                sb.append(" ");
                                                                                sb.append(file8.getAbsolutePath());
                                                                                sb.append(str3);
                                                                                sb.append(file8.getAbsolutePath());
                                                                                sb.append("; ");
                                                                            }
                                                                            i++;
                                                                            str4 = str13;
                                                                        }
                                                                        str10 = str4;
                                                                        sb.append(str5);
                                                                        string2 = sb.toString();
                                                                        java.lang.String str210 = string2 + str15 + android.ext.e2.n(string2, 15);
                                                                        while (i2 < 5) {
                                                                            str11 = strArr[i2];
                                                                            if (!str11.startsWith(str10)) {
                                                                                file2 = new java.io.File(str11, name);
                                                                                if (file2.exists()) {
                                                                                    continue;
                                                                                }
                                                                            }
                                                                        }
                                                                        android.ext.e1.i("Failed remount 3 " + str14 + str15 + str210);
                                                                        return null;
                                                                    }
                                                                } catch (java.lang.Throwable th6) {
                                                                    th = th6;
                                                                    str3 = str28;
                                                                    str15 = "\n";
                                                                    str5 = str8;
                                                                    string = null;
                                                                    android.ext.e1.l("Failed remount 2 " + str14 + str15 + string, th);
                                                                    sb = new java.lang.StringBuilder();
                                                                    i = 0;
                                                                    while (i < 5) {
                                                                        str12 = strArr[i];
                                                                        str13 = str4;
                                                                        if (!str12.startsWith(str13)) {
                                                                            java.io.File file9 = new java.io.File(str12, name);
                                                                            sb.append("cp -f ");
                                                                            sb.append(str14);
                                                                            sb.append(" ");
                                                                            sb.append(file9.getAbsolutePath());
                                                                            sb.append(str3);
                                                                            sb.append(file9.getAbsolutePath());
                                                                            sb.append("; ");
                                                                        }
                                                                        i++;
                                                                        str4 = str13;
                                                                    }
                                                                    str10 = str4;
                                                                    sb.append(str5);
                                                                    string2 = sb.toString();
                                                                    java.lang.String str211 = string2 + str15 + android.ext.e2.n(string2, 15);
                                                                    while (i2 < 5) {
                                                                        str11 = strArr[i2];
                                                                        if (!str11.startsWith(str10)) {
                                                                            file2 = new java.io.File(str11, name);
                                                                            if (file2.exists()) {
                                                                                continue;
                                                                            }
                                                                        }
                                                                    }
                                                                    android.ext.e1.i("Failed remount 3 " + str14 + str15 + str211);
                                                                    return null;
                                                                }
                                                            } else {
                                                                str3 = str28;
                                                            }
                                                            i17++;
                                                            str28 = str3;
                                                        }
                                                    }
                                                    i9 = i11 + 1;
                                                    str14 = str;
                                                    str3 = str28;
                                                    str7 = str27;
                                                    strArr3 = strArr4;
                                                    str16 = str8;
                                                } catch (java.lang.Throwable th7) {
                                                    th = th7;
                                                    str14 = str;
                                                }
                                            } catch (java.lang.Throwable th8) {
                                                th = th8;
                                                str14 = str14;
                                                str3 = str3;
                                            }
                                        } catch (java.lang.Throwable th9) {
                                            th = th9;
                                            str15 = "\n";
                                            str5 = str8;
                                            string = null;
                                            android.ext.e1.l("Failed remount 2 " + str14 + str15 + string, th);
                                            sb = new java.lang.StringBuilder();
                                            i = 0;
                                            while (i < 5) {
                                                str12 = strArr[i];
                                                str13 = str4;
                                                if (!str12.startsWith(str13)) {
                                                    java.io.File file10 = new java.io.File(str12, name);
                                                    sb.append("cp -f ");
                                                    sb.append(str14);
                                                    sb.append(" ");
                                                    sb.append(file10.getAbsolutePath());
                                                    sb.append(str3);
                                                    sb.append(file10.getAbsolutePath());
                                                    sb.append("; ");
                                                }
                                                i++;
                                                str4 = str13;
                                            }
                                            str10 = str4;
                                            sb.append(str5);
                                            string2 = sb.toString();
                                            java.lang.String str212 = string2 + str15 + android.ext.e2.n(string2, 15);
                                            while (i2 < 5) {
                                                str11 = strArr[i2];
                                                if (!str11.startsWith(str10)) {
                                                    file2 = new java.io.File(str11, name);
                                                    if (file2.exists()) {
                                                        continue;
                                                    }
                                                }
                                            }
                                            android.ext.e1.i("Failed remount 3 " + str14 + str15 + str212);
                                            return null;
                                        }
                                    } catch (java.lang.Throwable th10) {
                                        th = th10;
                                        str8 = str16;
                                    }
                                }
                                str14 = str14;
                                str3 = str3;
                                str5 = str16;
                                try {
                                    sb2.append(str5);
                                    string = sb2.toString();
                                    try {
                                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                        sb3.append(string);
                                        str15 = "\n";
                                        try {
                                            sb3.append(str15);
                                            sb3.append(android.ext.e2.n(string, 15));
                                            string = sb3.toString();
                                            for (int i18 = 0; i18 < 5; i18++) {
                                                java.io.File file11 = new java.io.File(strArr[i18], name);
                                                if (file11.exists() && file11.canExecute() && file.length() == file11.length()) {
                                                    return file11.getAbsolutePath();
                                                }
                                            }
                                            android.ext.e1.i("Failed remount 1 " + str14 + str15 + string);
                                            break;
                                        } catch (java.lang.Throwable th11) {
                                            th = th11;
                                            android.ext.e1.l("Failed remount 2 " + str14 + str15 + string, th);
                                        }
                                    } catch (java.lang.Throwable th12) {
                                        th = th12;
                                        str15 = "\n";
                                    }
                                } catch (java.lang.Throwable th13) {
                                    th = th13;
                                    str15 = "\n";
                                    string = null;
                                }
                            } catch (java.lang.Throwable th14) {
                                th = th14;
                                str5 = "exit";
                            }
                        } catch (java.lang.Throwable th15) {
                            th = th15;
                            str14 = str14;
                            str15 = "\n";
                            str3 = "; chmod 0755 ";
                            str5 = "exit";
                        }
                    } catch (java.lang.Throwable th16) {
                        th = th16;
                        str4 = "/sbin";
                        file = file3;
                    }
                    str5 = "exit";
                    string = null;
                }
                try {
                    android.ext.e1.l("Failed remount 2 " + str14 + str15 + string, th);
                } catch (java.lang.Throwable th17) {
                    th = th17;
                    str2 = string;
                }
            }
            sb = new java.lang.StringBuilder();
            i = 0;
            while (i < 5) {
                str12 = strArr[i];
                str13 = str4;
                if (!str12.startsWith(str13)) {
                    java.io.File file12 = new java.io.File(str12, name);
                    sb.append("cp -f ");
                    sb.append(str14);
                    sb.append(" ");
                    sb.append(file12.getAbsolutePath());
                    sb.append(str3);
                    sb.append(file12.getAbsolutePath());
                    sb.append("; ");
                }
                i++;
                str4 = str13;
            }
            str10 = str4;
            sb.append(str5);
            string2 = sb.toString();
            try {
                java.lang.String str213 = string2 + str15 + android.ext.e2.n(string2, 15);
                while (i2 < 5) {
                    str11 = strArr[i2];
                    if (!str11.startsWith(str10)) {
                        file2 = new java.io.File(str11, name);
                        if (file2.exists() && file2.canExecute() && file.length() == file2.length()) {
                            return file2.getAbsolutePath();
                        }
                    }
                }
                android.ext.e1.i("Failed remount 3 " + str14 + str15 + str213);
                return null;
            } catch (java.lang.Throwable th18) {
                th = th18;
                str2 = string2;
            }
        } catch (java.lang.Throwable th19) {
            th = th19;
            str14 = str14;
            str15 = "\n";
            str2 = null;
        }
        android.ext.e1.l("Failed remount 4 " + str14 + str15 + str2, th);
        return null;
    }

    public static java.lang.String T() {
        return android.ext.w0.a(android.ext.h0.c(), "S!H!A!-!3!8!4".replace("!", ""));
    }

    private void c0() {
        android.ext.MainService.instance.Q();
        android.ext.MainService.instance.l();
    }

    private static boolean j(android.ext.f0$n0 f0_n0, java.io.File file) throws java.io.IOException {
        boolean z2 = false;
        if (f0_n0 == null || f0_n0.f916a == null) {
            return false;
        }
        java.io.InputStream inputStream = f0_n0.f918c;
        boolean z3 = k(f0_n0.f919d, "android-daemon err") && k(inputStream, "android-daemon out");
        if (!android.ext.Config.C && z3) {
            new android.ext.g2().putInt("root-ok", (int) (((1 * 16338.7f) - 183.7f) + 0.5f)).commit();
        }
        if (z3) {
            int i = inputStream.read();
            if (i == 49 || i == 48) {
                inputStream.read();
            }
            if (i == 49) {
                try {
                    java.io.OutputStream outputStream = f0_n0.f917b;
                    try {
                        android.ext.e1.d("IF 0");
                        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(new java.io.File(file, "o"));
                        android.ext.e1.d("IF 1");
                        java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(new java.io.File(file, "e"));
                        android.ext.e1.d("IF 2");
                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(new java.io.File(file, "i"));
                        android.ext.e1.d("IF 3");
                        f0_n0.f917b = fileOutputStream;
                        f0_n0.f918c = fileInputStream;
                        f0_n0.f919d = fileInputStream2;
                        z2 = true;
                    } catch (java.lang.Throwable th) {
                        android.ext.e1.l("Fifo fail", th);
                    }
                    outputStream.write(z2 ? 89 : 78);
                    outputStream.write(10);
                    outputStream.flush();
                    android.ext.InOut.o = z2;
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.l("Fifo fail 2", th2);
                }
            } else if (i != 48) {
                android.ext.e1.p("Odd fifo: " + i);
            }
        }
        return z3;
    }

    private static boolean k(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[4096];
        android.ext.e1.d("Start: " + str);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = inputStream.read();
            if (i3 == -1) {
                break;
            }
            byte b2 = (byte) i3;
            if (i >= 4096) {
                break;
            }
            int i4 = i + 1;
            bArr[i] = b2;
            if (b2 == bytes[i2]) {
                i2++;
                if (i2 == bytes.length) {
                    android.ext.e1.d("Good: " + str);
                    return true;
                }
            } else {
                i2 = 0;
            }
            if (inputStream.available() == 0) {
                for (int i5 = 0; i5 < 30; i5++) {
                    try {
                        java.lang.Thread.sleep(100L);
                    } catch (java.lang.InterruptedException unused) {
                    }
                    if (inputStream.available() != 0) {
                        break;
                    }
                }
            }
            if (inputStream.available() == 0) {
                android.ext.e2.f745a += "No more data: " + i4 + '\n';
                i = i4;
                break;
            }
            i = i4;
        }
        java.lang.String str2 = "Fail: '" + str + "' " + i + " '" + new java.lang.String(bArr, 0, i) + '\'';
        android.ext.e2.f745a += str2 + '\n';
        android.ext.e1.d(str2);
        return false;
    }

    public static void m0(java.lang.Runnable runnable) {
        java.util.List list = z;
        synchronized (list) {
            try {
                if (A) {
                    list.add(runnable);
                } else {
                    new android.ext.g0(runnable, "runAfterDaemonStart").start();
                }
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }

    static void r() {
        java.util.List list = z;
        synchronized (list) {
            try {
                A = false;
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    new android.ext.g0((java.lang.Runnable) it.next(), "waitForDaemonStart").start();
                }
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }

    private int u(byte b2) {
        java.lang.Object[] array;
        java.util.ArrayList arrayList = this.q;
        synchronized (arrayList) {
            try {
                array = arrayList.toArray(new java.lang.Object[arrayList.size()]);
                arrayList.clear();
                arrayList.trimToSize();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        int length = array.length;
        if (length != 0) {
            android.ext.n2.j(new android.ext.f0$o(this, array, b2));
        }
        return length;
    }

    private void v() {
        if (this.f795d && this.f796e > 0) {
            java.io.File file = new java.io.File(android.ext.Tools.q0(), "stop.tmp");
            try {
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                fileOutputStream.write(java.nio.ByteBuffer.allocate(4).order(java.nio.ByteOrder.LITTLE_ENDIAN).putInt(this.f796e).array());
                fileOutputStream.close();
                if (file.renameTo(new java.io.File(android.ext.Tools.q0(), "stop"))) {
                    return;
                }
                android.ext.e1.s("Failed rename stop file: " + file, new java.lang.RuntimeException());
                this.f795d = false;
                file.delete();
            } catch (java.io.IOException e2) {
                android.ext.e1.s("Failed make stop file: " + file, e2);
                this.f795d = false;
            }
        }
    }

    private int y(byte b2) {
        android.ext.h2[] h2VarArr;
        java.util.ArrayList arrayList = this.r;
        synchronized (arrayList) {
            try {
                h2VarArr = (android.ext.h2[]) arrayList.toArray(new android.ext.h2[arrayList.size()]);
                arrayList.clear();
                arrayList.trimToSize();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        int length = h2VarArr.length;
        if (length != 0) {
            android.ext.n2.j(new android.ext.f0$p(this, h2VarArr, b2));
            if ((android.ext.Config.A & 128) != 0 && !x) {
                x = true;
                android.ext.n2.i(new android.ext.f0$q(this));
            }
        }
        return length;
    }

    private void y0(byte b2, long j, long j2, int i, int i2, long j3, long j4, long j5) {
        long jH = android.ext.c.h(j, i2);
        long jH2 = android.ext.c.h(j2, i2);
        android.ext.e1.d("sendSearchNumber: " + jH + "; " + jH2 + " x" + i + " as " + java.lang.Integer.toHexString(i2) + " in " + java.lang.Long.toHexString(j3) + '-' + java.lang.Long.toHexString(j4) + ", " + java.lang.Long.toString(j5));
        android.ext.n2.j(new android.ext.f0$n(this, b2, jH, jH2, i, i2, j3, j4, j5));
        android.ext.i2.l = null;
    }

    private void z0(byte b2, long j, long j2, int i, long j3, long j4, long j5) {
        y0(b2, j, j2, 0, i, j3, j4, j5);
    }

    public void A0(byte b2, java.lang.String str) {
        byte[] bytes = str.getBytes();
        if (bytes.length == 0) {
            return;
        }
        if (bytes.length <= 4000) {
            android.ext.n2.j(new android.ext.f0$i0(this, bytes, b2));
            return;
        }
        android.ext.e1.i("path big: " + bytes.length + " > 4000");
    }

    public void B() {
        C((byte) 0);
    }

    public void B0(java.lang.String str) {
        A0((byte) 0, str);
    }

    public void C(byte b2) {
        if (u(b2) + y(b2) + A(b2) > 0) {
            android.ext.MainService.instance.F0();
        }
    }

    public void C0(byte b2, int i, java.lang.String str, java.lang.String str2) {
        android.ext.n2.j(new android.ext.f0$h0(this, str, str2, b2, i));
        x0(b2);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008c A[PHI: r6
      0x008c: PHI (r6v5 java.lang.String) = (r6v4 java.lang.String), (r6v17 java.lang.String), (r6v18 java.lang.String) binds: [B:40:0x00a9, B:37:0x009b, B:31:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    public void D(byte b2, long j, long j2, int i, int i2, int i3, long j3, long j4, long j5) {
        java.lang.String str;
        int i4;
        java.lang.String strF;
        java.lang.String strF2;
        boolean z2;
        java.lang.String strReplace;
        int i5 = i & 127;
        java.lang.CharSequence charSequenceV = android.ext.c.v(i5);
        boolean z3 = (i & 8388608) != 0;
        boolean z4 = !z3 && j == 0;
        java.lang.String strK = android.ext.c.K(0L, j, i5);
        if (z3) {
            strK = strK + '~' + android.ext.c.K(0L, j2, i5);
        }
        if (i2 == 67108864) {
            str = "N > O+D";
            if (z4) {
                i4 = catch_.me_.if_.you_.can_.R.string.fuzzy_larger;
                strF = android.ext.b2.f(i4);
            } else {
                strF = str;
            }
            strF2 = strF;
            z2 = false;
        } else if (i2 == 134217728) {
            str = "N < O+D";
            if (z4) {
                i4 = catch_.me_.if_.you_.can_.R.string.fuzzy_smaller;
                strF = android.ext.b2.f(i4);
            } else {
                strF = str;
            }
            strF2 = strF;
            z2 = false;
        } else if (i2 != 268435456) {
            if (this.i == 0) {
                this.i = i3;
            }
            this.h = i3 - 1;
            this.j = j3;
            this.k = j4;
            this.l = j5;
            str = "N = O+D";
            strF2 = z4 ? android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fuzzy_equal) : "N = O+D";
            z2 = true;
        } else {
            str = "N ≠ O+D";
            if (z4) {
                i4 = catch_.me_.if_.you_.can_.R.string.fuzzy_inequal;
                strF = android.ext.b2.f(i4);
            } else {
                strF = str;
            }
            strF2 = strF;
            z2 = false;
        }
        if (z4) {
            strReplace = strF2 + " (" + str.replace("+D", "") + ')';
        } else {
            strReplace = strF2.replace("+D", " + (" + strK + ')');
        }
        java.lang.CharSequence charSequenceD = new android.ext.y().b("%s %s", strReplace, charSequenceV).d();
        if (z2) {
            android.ext.MainService.instance.i0(charSequenceD, -1L, 1L, this.i - this.h, this.i, 0L);
        } else {
            android.ext.MainService.instance.h0(charSequenceD);
        }
        z0(b2, j, j2, i | Integer.MIN_VALUE | i2, j3, j4, j5);
    }

    public void D0(int i, java.lang.String str, java.lang.String str2) {
        C0((byte) 0, i, str, str2);
    }

    public void E(long j, long j2, int i, int i2, int i3, long j3, long j4, long j5) {
        D((byte) 0, j, j2, i, i2, i3, j3, j4, j5);
    }

    public void E0(byte b2) {
        F0(b2, this.n, this.o);
    }

    public void F(byte b2, int i, long j, long j2, long j3) {
        android.ext.MainService.instance.h0(new android.ext.y().b("%s %s", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.search_unknown_value), android.ext.c.v(i & 127)).d());
        z0(b2, 0L, 0L, i | Integer.MIN_VALUE, j, j2, j3);
    }

    public void F0(byte b2, int i, int i2) {
        c0();
        boolean[] zArrI = I(0);
        long j = this.p;
        this.n = i;
        this.o = i2;
        android.ext.n2.j(new android.ext.f0$e(this, b2, zArrI, i, i2, j));
        this.p = 0L;
    }

    public void G() {
        H((byte) 0);
    }

    public void G0(byte b2, int i) {
        c0();
        android.ext.n2.j(new android.ext.f0$f(this, b2, i, I(i)));
    }

    public void H(byte b2) {
        u0(b2, (byte) 57);
    }

    public void H0(int i) {
        G0((byte) 0, i);
    }

    public void I0(byte b2, int i) {
        c0();
        android.ext.n2.j(new android.ext.f0$g(this, b2, i, I(i)));
    }

    public int J() {
        return this.f796e;
    }

    public void J0(int i) {
        I0((byte) 0, i);
    }

    public void K0(byte b2) {
        L0((byte) 0, b2);
    }

    public void L() {
        M((byte) 0);
    }

    public void L0(byte b2, byte b3) {
        android.ext.n2.j(new android.ext.f0$u(this, b2, b3));
    }

    public void M(byte b2) {
        u0(b2, (byte) 58);
    }

    public void N(byte b2, long j, int i) {
        android.ext.n2.j(new android.ext.f0$h(this, b2, j, i));
    }

    public void N0() {
        new android.ext.f0$a0(this, "DaemonLoader").start();
    }

    public void O(long j, int i) {
        N((byte) 0, j, i);
    }

    public android.ext.f0$n0 O0(java.lang.String str) throws android.ext.f0$l0 {
        java.lang.String strS0;
        try {
            boolean z2 = android.ext.Config.C;
            java.io.File fileQ0 = android.ext.Tools.q0();
            java.lang.String[] strArrK = K(z2, str, fileQ0);
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                java.lang.String[] strArr = {"i", "o", "e"};
                for (int i = 0; i < 3; i++) {
                    new java.io.File(fileQ0, strArr[i]).delete();
                }
                if (z2) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("try: direct");
                    for (java.lang.String str2 : strArrK) {
                        sb.append(' ');
                        sb.append(str2);
                    }
                    android.ext.e1.d(sb.toString());
                }
                java.lang.Process processI = z2 ? android.ext.Tools.I(strArrK) : android.ext.e2.r(strArrK[0], null, true);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Daemon process: ");
                sb2.append(processI);
                sb2.append("; pid=");
                sb2.append(processI == null ? "n/a" : java.lang.Integer.valueOf(android.ext.Tools.D0(processI)));
                android.ext.e1.d(sb2.toString());
                android.ext.f0$n0 f0_n0 = new android.ext.f0$n0();
                f0_n0.f916a = processI;
                if (processI != null) {
                    f0_n0.f917b = processI.getOutputStream();
                    f0_n0.f918c = processI.getInputStream();
                    f0_n0.f919d = processI.getErrorStream();
                }
                if (j(f0_n0, fileQ0)) {
                    y = f0_n0;
                    this.f797f = android.ext.Tools.D0(processI);
                    if (!e0()) {
                        break;
                    }
                    android.ext.n2.h(new android.ext.f0$v(this));
                    return f0_n0;
                }
                if (!z3) {
                    java.lang.String strRemoveNewLinesChars = android.ext.Tools.removeNewLinesChars("h{hf#lg");
                    android.ext.e1.d("Test 1 start");
                    if (z2) {
                        strRemoveNewLinesChars = "id";
                    }
                    android.ext.e2.o(strRemoveNewLinesChars, 45, z2 ? "" : null);
                    android.ext.e2.f745a = "";
                    android.ext.e1.d("Test 1 end");
                    android.ext.Tools.q(new java.io.File(str), 493);
                    android.ext.Tools.r(str, "0755");
                    z3 = true;
                } else if (android.ext.Config.C) {
                    if (!z2) {
                        i(str, z3);
                        java.lang.Thread.sleep(1000L);
                        java.lang.String str3 = android.ext.e2.f745a + android.ext.e2.g(processI);
                        android.ext.e2.f745a = str3;
                        android.ext.e1.d(str3);
                        android.ext.r.k = true;
                        android.ext.e1.i("Show error alert");
                        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.daemon_failed)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.failed_run_daemon) + "\n\n" + android.ext.e2.f745a).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.exit), new android.ext.p0(400)).setNeutralButton("SU", new android.ext.f0$k(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), (android.content.DialogInterface.OnClickListener) null));
                        return null;
                    }
                    strArrK = K(false, str, fileQ0);
                    z2 = false;
                } else {
                    if (z4 || (strS0 = S0(str)) == null) {
                        i(str, z3);
                        java.lang.Thread.sleep(1000L);
                        java.lang.String str4 = android.ext.e2.f745a + android.ext.e2.g(processI);
                        android.ext.e2.f745a = str4;
                        android.ext.e1.d(str4);
                        android.ext.r.k = true;
                        android.ext.e1.i("Show error alert");
                        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.daemon_failed)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.failed_run_daemon) + "\n\n" + android.ext.e2.f745a).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.exit), new android.ext.p0(400)).setNeutralButton("SU", new android.ext.f0$k(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), (android.content.DialogInterface.OnClickListener) null));
                        return null;
                    }
                    strArrK = K(z2, strS0, fileQ0);
                    z4 = true;
                }
            }
        } catch (android.ext.f0$l0 e2_c_c_c) {
            throw e2_c_c_c;
        } catch (java.lang.Exception e3) {
            android.ext.e1.l("" + e3.getMessage(), e3);
            android.ext.Tools.J1(e3.getMessage());
        }
        return null;
    }

    public long P(byte b2, long j, int i) {
        if (!this.f793b.h()) {
            return -1L;
        }
        android.ext.n2.j(new android.ext.f0$g0(this, b2, j, i));
        java.util.concurrent.Exchanger exchanger = this.f794c;
        while (true) {
            try {
                android.ext.w wVar = new android.ext.w((byte[]) exchanger.exchange(null, 500L, java.util.concurrent.TimeUnit.MILLISECONDS));
                wVar.l(3);
                if (wVar.g() == j) {
                    wVar.l(4);
                    return wVar.h();
                }
                continue;
            } catch (java.lang.InterruptedException unused) {
            } catch (java.util.concurrent.TimeoutException unused2) {
                return -1L;
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("getMemoryContent failed", th);
                return -1L;
            }
        }
    }

    public void P0() {
        Q0((byte) 0);
    }

    public long Q(long j, int i) {
        return P((byte) 0, j, i);
    }

    public void Q0(byte b2) {
        android.ext.n2.j(new android.ext.f0$b0(this, b2));
        try {
            java.lang.Thread.sleep(3L);
        } catch (java.lang.InterruptedException unused) {
        }
    }

    public void R(byte b2, int[] iArr, long[] jArr) {
        if (iArr.length == jArr.length) {
            android.ext.n2.j(new android.ext.f0$f0(this, iArr, b2, jArr));
            return;
        }
        throw new java.lang.RuntimeException("Size mismatch: " + iArr.length + " != " + jArr.length);
    }

    public void S(int[] iArr, long[] jArr) {
        R((byte) 0, iArr, jArr);
    }

    public void T0() {
        u0((byte) 0, (byte) 51);
    }

    public void U() {
        V((byte) 0);
    }

    public void U0(byte b2, int i, long j, long j2, double d2, double d3) {
        c0();
        android.ext.n2.j(new android.ext.f0$d(this, b2, i, I(1), j, j2, d2, d3));
    }

    public void V(byte b2) {
        u0(b2, (byte) 56);
    }

    public void V0(int i, long j, long j2, double d2, double d3) {
        U0((byte) 0, i, j, j2, d2, d3);
    }

    public void W() {
        X((byte) 0);
    }

    void W0(boolean[] zArr) {
        android.ext.InOut inOut = this.f793b;
        for (boolean z2 : zArr) {
            inOut.s(z2 ? (byte) 1 : (byte) 0);
        }
    }

    public void X(byte b2) {
        u0(b2, (byte) 60);
    }

    public void Y(byte b2, int i, int i2, int i3, long j, long j2, long j3, int i4, long j4, int i5, int i6, int i7, double d2, int i8) {
        android.ext.n2.j(new android.ext.f0$e0(this, b2, i, i2, i3, j, j2, j3, i4, j4, i5, i6, i7, d2, i8));
    }

    public double Z() {
        return ((double) this.n) / ((double) this.o);
    }

    public void a(android.ext.c cVar, int i) {
        java.lang.Object f0_k0 = cVar;
        if (i != 0) {
            f0_k0 = new android.ext.f0$k0(cVar, i);
        }
        synchronized (this.q) {
            try {
                this.q.add(f0_k0);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }

    public java.lang.CharSequence a0() {
        int iD0;
        java.lang.String str;
        java.lang.String str2;
        int i;
        if (this.f793b.h()) {
            if (android.ext.Config.C) {
                iD0 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.daemon_user);
                str = "$";
            } else if (android.ext.Config.vSpaceReal) {
                iD0 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.daemon_vroot);
                str = "@";
            } else {
                iD0 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.daemon_root);
                str = "#";
            }
            return android.ext.Tools.t(str, iD0);
        }
        android.ext.f0$n0 f0_n0 = this.f792a;
        if (f0_n0 == null || f0_n0.f916a == null) {
            if (android.ext.Config.C) {
                str2 = "!";
            } else {
                str2 = android.ext.Config.vSpaceReal ? "I" : "?";
            }
            i = catch_.me_.if_.you_.can_.R.color.daemon_bad;
        } else {
            if (android.ext.Config.C) {
                str2 = "V";
            } else {
                str2 = android.ext.Config.vSpaceReal ? "U" : "W";
            }
            i = catch_.me_.if_.you_.can_.R.color.daemon_wait;
        }
        return android.ext.Tools.t(str2, android.ext.Tools.d0(i));
    }

    public void b(android.ext.h2 h2Var) {
        synchronized (this.r) {
            try {
                this.r.add(h2Var);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }

    public int b0() {
        return this.f797f;
    }

    public void c(android.ext.h2 h2Var) {
        synchronized (this.s) {
            try {
                this.s.add(h2Var);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }

    public void d(byte b2, long j) {
        this.p += j;
        E0(b2);
    }

    public boolean d0() {
        boolean z2 = (v || this.f793b.h()) ? false : true;
        if (z2) {
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.daemon_fail)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.wait_daemon)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
        }
        return !z2;
    }

    public void e(long j) {
        d((byte) 0, j);
    }

    public boolean e0() {
        java.lang.Process process;
        java.lang.Integer numValueOf;
        java.lang.String str;
        java.lang.String string;
        android.ext.f0$n0 f0_n0 = y;
        if (f0_n0 == null || (process = f0_n0.f916a) == null) {
            return false;
        }
        try {
            numValueOf = java.lang.Integer.valueOf(process.exitValue());
        } catch (java.lang.IllegalThreadStateException unused) {
            numValueOf = null;
        }
        if (numValueOf == null && C == null && B == null) {
            return true;
        }
        if (!android.ext.r.k && !android.ext.f1.f952b) {
            if (numValueOf == null || (!(numValueOf.intValue() == 9 || numValueOf.intValue() == 15 || numValueOf.intValue() == 137) || android.ext.Config.h == 0)) {
                str = null;
            } else {
                android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_ram).f42d = 0;
                android.ext.Config.k();
                str = "Found SIGKILL/SIGTERM/SIGKILL_OOM: " + numValueOf;
            }
            if (str != null) {
                android.ext.e1.i(str);
                android.ext.n2.i(new android.ext.f0$c0(this));
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int iD0 = android.ext.Tools.D0(process);
            sb.append('\n');
            sb.append(this.f798g);
            sb.append(" ( ");
            sb.append(android.os.Process.myPid());
            sb.append(" / ");
            sb.append(iD0);
            sb.append(" / ");
            sb.append(this.f796e);
            sb.append(" )\n");
            sb.append(numValueOf);
            sb.append(" / ");
            sb.append(C);
            sb.append(" / ");
            sb.append(B);
            sb.append('\n');
            sb.append(android.ext.MainService.instance.m0 / 1024);
            sb.append(" / ");
            sb.append(android.ext.Tools.r0());
            sb.append(" / ");
            sb.append(android.ext.MainService.instance.l0 / 1024);
            sb.append('\n');
            java.lang.String strH = android.ext.e0.h();
            sb.append(strH);
            sb.append('\n');
            sb.append(android.ext.w0.a(strH, "S$H$A$-$3$8$4".replace("$", "")));
            sb.append('\n');
            java.io.File file = new java.io.File(strH);
            sb.append(file.length());
            sb.append('\n');
            sb.append(android.ext.w0.a(file, "S#H#A#-#3#8#4".replace("#", "")));
            if (numValueOf != null) {
                sb.append("\nOutput:\n");
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(f0_n0.f919d));
                while (true) {
                    try {
                        try {
                            java.lang.String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            try {
                                sb.append(line);
                                sb.append('\n');
                            } catch (java.lang.OutOfMemoryError e2) {
                                android.ext.e1.s("Failed get err for daemon exit", e2);
                                sb.append(e2);
                                sb.append('\n');
                            }
                        } catch (java.io.IOException e3) {
                            android.ext.e1.l("checkProcess", e3);
                        }
                    } catch (java.lang.OutOfMemoryError e4) {
                        android.ext.e1.s("Failed get err for daemon exit", e4);
                        sb.append(e4);
                        sb.append('\n');
                    }
                }
            }
            sb.append("\nDEBUG:\n");
            sb.append(android.ext.h0.f(false));
            try {
                string = sb.toString();
            } catch (java.lang.OutOfMemoryError e5) {
                android.ext.e1.s("Failed get string for daemon exit", e5);
                string = e5.toString();
            }
            java.lang.String str2 = string;
            try {
                android.ext.e1.i("Daemon closed" + str2);
            } catch (java.lang.OutOfMemoryError e6) {
                android.ext.e1.s("Failed out string for daemon exit", e6);
            }
            if (!android.ext.n0.d(str2) && str == null) {
                try {
                    if (str2.contains("backtrace:") && str2.contains(this.f798g) && !str2.contains("SIGPIPE")) {
                        android.ext.n0.i(str2);
                    }
                } catch (java.lang.OutOfMemoryError e7) {
                    android.ext.e1.s("Failed send string for daemon exit", e7);
                }
            }
            try {
                str2 = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.daemon_unexpected_closed) + '\n' + str2;
            } catch (java.lang.OutOfMemoryError e8) {
                android.ext.e1.s("Failed out string for daemon exit", e8);
            }
            android.ext.r.k = true;
            android.ext.e1.i("Show error alert");
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.daemon_exited)).setMessage(str2).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.exit), new android.ext.p0(500)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), (android.content.DialogInterface.OnClickListener) null));
            this.f793b.n(false);
            android.ext.MainService.instance.q0();
            if (numValueOf != null && (numValueOf.intValue() == 9 || numValueOf.intValue() == 15 || numValueOf.intValue() == 137)) {
                android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.daemon_exited)).setMessage(android.ext.b2.f(numValueOf.intValue() == 137 ? catch_.me_.if_.you_.can_.R.string.daemon_killed_oom : catch_.me_.if_.you_.can_.R.string.daemon_killed)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
            }
        }
        return false;
    }

    public void f(byte b2, long j, int i) {
        android.ext.n2.j(new android.ext.f0$a(this, b2, i, j));
    }

    public void f0(byte b2, java.util.List list) {
        android.ext.f0$j0 f0_j0M0 = M0(list, android.ext.e0.m());
        if (f0_j0M0.f887a.length == 0) {
            return;
        }
        if (f0_j0M0.f889c == 0) {
            l(b2);
            return;
        }
        android.ext.n2.j(new android.ext.f0$s(this, f0_j0M0, b2));
        android.ext.MainService.N0(f0_j0M0.f889c, b2);
        android.ext.i2.l = null;
    }

    public void g(long j, int i) {
        f((byte) 0, j, i);
    }

    public void g0() {
        android.ext.e1.d("messageFailed");
        e0();
        android.ext.MainService.instance.s();
    }

    public void h() {
        this.f795d = true;
        v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.ext.f0] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.StringBuilder] */
    void h0(byte[] bArr) throws java.lang.Throwable {
/* gg-shared-throwable */ java.lang.Throwable e = null;
        java.lang.String r15;
        byte b2 = 0;
        android.ext.MainService mainService;
        android.ext.TimersEditor timersEditor;
        int i;
        f0 r16 = this;
        java.lang.String size = ", size: ";
        byte b3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        try {
            android.ext.w wVar = new android.ext.w(bArr);
            byte bE = wVar.e();
            try {
                byte bE2 = wVar.e();
                try {
                    try {
                        switch (bE) {
                            case 16:
                                b2 = bE;
                                size = ", size: ";
                                android.ext.MainService.instance.l0(wVar);
                                break;
                            case 17:
                                long jG = wVar.g();
                                long jG2 = wVar.g();
                                int iF = wVar.f();
                                if (iF == 0 && r16.h > 0 && bE2 == 0) {
                                    long j = bE2;
                                    int iD = android.ext.MainService.D() & 127;
                                    int i2 = r16.h;
                                    long j2 = r16.j;
                                    long j3 = r16.k;
                                    long j4 = r16.l;
                                    b2 = bE;
                                    size = ", size: ";
                                    E(j, 0L, iD, 536870912, i2, j2, j3, j4);
                                } else {
                                    b2 = bE;
                                    java.lang.String obj = ", size: ";
                                    android.ext.MainService.instance.o0(bE2, jG, jG2, iF);
                                    size = obj;
                                    if (iF == 0) {
                                        android.ext.MainService.instance.X(bE2, null);
                                        size = obj;
                                    }
                                }
                                break;
                            case 18:
                                m();
                                android.ext.MainService.instance.r0();
                                break;
                            case 19:
                                m();
                                android.ext.MainService.instance.k0(wVar.f());
                                break;
                            case 20:
                            default:
                                android.ext.e1.p("Unknown message: " + ((int) bE) + ", size: " + bArr.length);
                                break;
                            case 21:
                                android.ext.MainService.instance.i0(null, wVar.g(), wVar.g(), -1, -1, wVar.g());
                                v();
                                break;
                            case 22:
                                android.ext.MainService.instance.t0.h(wVar);
                                if (bE2 != 0) {
                                    android.ext.Script.C3(wVar);
                                    mainService = android.ext.MainService.instance;
                                    mainService.X(bE2, null);
                                }
                                break;
                            case 23:
                                android.ext.d dVar = android.ext.MainService.instance.u0;
                                new android.ext.d$a();
                                while (true) {
                                    int iF2 = wVar.f();
                                    if (iF2 == 0) {
                                        if (z3) {
                                            android.ext.MainService.instance.e0();
                                        }
                                        break;
                                    } else {
                                        long jG3 = wVar.g();
                                        long jH = wVar.h();
                                        if ((16777216 & iF2) == 0 && dVar.c(jG3, iF2, jH)) {
                                            z3 = true;
                                        }
                                    }
                                }
                                break;
                            case 24:
                                android.ext.z1.o(wVar);
                                break;
                            case 25:
                                if (android.ext.Config.vSpaceReal && !android.ext.Config.C) {
                                    z2 = true;
                                }
                                android.ext.x2.u(wVar, z2);
                                break;
                            case 26:
                                android.ext.MainService.instance.O0(wVar.f(), wVar.f());
                                break;
                            case 27:
                                android.ext.MainService.instance.P0(wVar);
                                break;
                            case 28:
                                int iF3 = wVar.f();
                                int iE = wVar.e();
                                int[] iArr = iE > 0 ? new int[iE] : null;
                                for (int i3 = 0; i3 < iE; i3++) {
                                    iArr[i3] = wVar.f();
                                }
                                android.ext.MainService.instance.p0(bE2, iF3, iArr);
                                if (iF3 == 7) {
                                    R0();
                                }
                                break;
                            case 29:
                                android.ext.RegionList.h(wVar);
                                break;
                            case 30:
                                if (wVar.f() == 1) {
                                    timersEditor = android.ext.MainService.instance.o0;
                                    i = 19;
                                } else {
                                    timersEditor = android.ext.MainService.instance.n0;
                                    i = 44;
                                }
                                int i4 = i * 4;
                                boolean[] zArr = new boolean[i4];
                                for (int i5 = 0; i5 < i4; i5++) {
                                    zArr[i5] = wVar.e() != 0;
                                }
                                timersEditor.i(zArr);
                                mainService = android.ext.MainService.instance;
                                mainService.X(bE2, null);
                                break;
                            case 31:
                                long jG4 = wVar.g();
                                if (bE2 != 0) {
                                    android.ext.Script.Y2(jG4);
                                    mainService = android.ext.MainService.instance;
                                    mainService.X(bE2, null);
                                } else {
                                    android.ext.MainService.instance.h(jG4);
                                }
                                break;
                        }
                    } catch (java.nio.BufferUnderflowException e2) {
                        e = e2;
                        b3 = b2;
                        r15 = size;
                        android.ext.e1.l("Failed process message: " + b3 + r15 + bArr.length, e);
                    }
                } catch (java.nio.BufferUnderflowException e3) {
                    e = e3;
                    b3 = bE;
                    r15 = ", size: ";
                    android.ext.e1.l("Failed process message: " + b3 + r15 + bArr.length, e);
                }
            } catch (java.nio.BufferUnderflowException e4) {
                e = e4;
                b2 = bE;
                size = ", size: ";
            }
        } catch (java.nio.BufferUnderflowException e5) {
            e = e5;
        }
    }

    void i(java.lang.String str, boolean z2) throws android.ext.f0$l0 {
        int i;
        java.lang.String str2;
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            i = catch_.me_.if_.you_.can_.R.string.file_not_found;
        } else if (file.isFile()) {
            java.lang.String[] strArr = {"ls", "-l", android.ext.Tools.F0(str)};
            try {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(android.ext.Tools.I(strArr).getInputStream()));
                android.ext.e1.p("ls for '" + str + "' got: " + bufferedReader.readLine());
                bufferedReader.close();
            } catch (java.lang.Exception e2) {
                android.ext.e1.l("run '" + java.util.Arrays.toString(strArr) + "' error", e2);
            }
            i = !file.canExecute() ? catch_.me_.if_.you_.can_.R.string.not_execute : 0;
        } else {
            i = catch_.me_.if_.you_.can_.R.string.not_file;
        }
        if (i != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.ext.Tools.N1(i));
            sb.append(": '");
            sb.append(str);
            sb.append("'\n\n");
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.check_install));
            if (i == 2131296817) {
                str2 = "\n\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.sdcard_install);
            } else {
                str2 = "";
            }
            sb.append(str2);
            throw new android.ext.f0$l0(sb.toString());
        }
    }

    public void i0(byte b2, java.util.List list) {
        android.ext.f0$j0 f0_j0M0 = M0(list, false);
        if (f0_j0M0.f887a.length == 0) {
            return;
        }
        android.ext.n2.j(new android.ext.f0$t(this, f0_j0M0, b2));
    }

    public void j0(java.util.List list) {
        i0((byte) 0, list);
    }

    public void k0() {
        l0((byte) 0);
    }

    public void l(byte b2) {
        u0(b2, (byte) 44);
        android.ext.i2.l = null;
    }

    public void l0(byte b2) {
        this.n = 1;
        this.o = 1;
        this.p = 0L;
        android.ext.y2.i();
        this.f793b.r();
        u0(b2, (byte) 42);
        android.ext.i2.l = null;
    }

    public void m() {
        this.h = 0;
        this.i = 0;
    }

    public void n() {
        o((byte) 0);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0034 A[LOOP:1: B:20:0x0032->B:21:0x0034, LOOP_END] */
    public void n0(byte b2, int i, int i2, int[] iArr, long[] jArr, long[] jArr2, long j, long j2, long j3) {
        int length;
        byte[] bArr;
        boolean z2 = (i & 4194304) != 0;
        if (z2 && i2 != jArr.length) {
            z2 = false;
        }
        if (z2) {
            for (int i3 : iArr) {
                if (((i3 | i) & (-4194306)) == 0) {
                }
            }
            if (z2) {
                length = jArr.length;
                bArr = new byte[length];
                for (int i4 = 0; i4 < length; i4++) {
                    bArr[i4] = (byte) jArr[i4];
                }
                s0(b2, 1, bArr, j, j2, j3);
                return;
            }
        } else if (z2) {
            length = jArr.length;
            bArr = new byte[length];
            for (int i4 = 0; i4 < length; i4++) {
                bArr[i4] = (byte) jArr[i4];
            }
            s0(b2, 1, bArr, j, j2, j3);
            return;
        }
        android.ext.n2.j(new android.ext.f0$i(this, iArr, b2, i, i2, j, j2, j3, jArr, jArr2));
        android.ext.i2.l = null;
    }

    public void o(byte b2) {
        u0(b2, (byte) 46);
    }

    public void o0(byte b2, long j, long j2, int i, long j3, long j4, long j5) {
        android.ext.e1.d("searchMask: " + java.lang.Long.toHexString(j) + ':' + java.lang.Long.toHexString(j2) + " as " + java.lang.Integer.toHexString(i) + " in " + java.lang.Long.toHexString(j3) + '-' + java.lang.Long.toHexString(j4) + ", " + java.lang.Long.toString(j5));
        gg_a.e eVarB = android.ext.c.B();
        java.lang.CharSequence charSequence = null;
        for (int i2 = 0; i2 < eVarB.size(); i2++) {
            int iKeyAt = eVarB.keyAt(i2);
            if (iKeyAt != 0 && (i & iKeyAt) == iKeyAt) {
                charSequence = (java.lang.CharSequence) eVarB.valueAt(i2);
            }
        }
        java.lang.String hexString = java.lang.Long.toHexString(j);
        java.util.Locale locale = java.util.Locale.US;
        java.lang.String upperCase = hexString.toUpperCase(locale);
        java.lang.String upperCase2 = java.lang.Long.toHexString(j2).toUpperCase(locale);
        if (upperCase.length() < upperCase2.length()) {
            upperCase = new java.lang.String(new char[upperCase2.length() - upperCase.length()]).replace((char) 0, '0') + upperCase;
        } else if (upperCase.length() > upperCase2.length()) {
            upperCase2 = new java.lang.String(new char[upperCase.length() - upperCase2.length()]).replace((char) 0, '0') + upperCase2;
        }
        android.ext.MainService.instance.h0(new android.ext.y().b("%s %s %s; %s: %s; %s: %s", android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.address), charSequence, upperCase, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.mask), upperCase2, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.type), android.ext.c.v(i & 127)).d());
        android.ext.n2.j(new android.ext.f0$j(this, b2, j, j2, i, j3, j4, j5));
        android.ext.i2.l = null;
    }

    public void p(byte b2, long j, long j2, int i) {
        android.ext.n2.j(new android.ext.f0$c(this, b2, j, j2, i));
    }

    public void p0(byte b2, long j, int i, int i2, long j2, long j3, long j4) {
        java.lang.CharSequence charSequence;
        gg_a.e eVarB = android.ext.c.B();
        if ((i2 & 33554432) != 0) {
            charSequence = "" + eVarB.get(536870912) + '*';
        } else {
            java.lang.CharSequence charSequence2 = null;
            for (int i3 = 0; i3 < eVarB.size(); i3++) {
                int iKeyAt = eVarB.keyAt(i3);
                if (iKeyAt != 0 && (i2 & iKeyAt) == iKeyAt) {
                    charSequence2 = (java.lang.CharSequence) eVarB.valueAt(i3);
                }
            }
            charSequence = charSequence2;
        }
        android.ext.c cVar = new android.ext.c(0L, j, i2 & 127);
        android.ext.y yVar = new android.ext.y();
        java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[3];
        charSequenceArr[0] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.value);
        charSequenceArr[1] = charSequence;
        java.lang.Object[] objArr = new java.lang.Object[3];
        objArr[0] = cVar.J();
        objArr[1] = i != 0 ? " X" + i : "";
        objArr[2] = cVar.u();
        charSequenceArr[2] = android.ext.Tools.t(android.ext.Tools.L1("%s%s %s", objArr), cVar.m());
        yVar.b("%s %s %s", charSequenceArr);
        android.ext.MainService.instance.h0(yVar.d());
        y0(b2, j, 0L, i, i2, j2, j3, j4);
    }

    public void q(long j, long j2, int i) {
        p((byte) 0, j, j2, i);
    }

    public void q0(byte b2, short s, int i, long j, long j2, long j3) {
        java.lang.String hexString = java.lang.Integer.toHexString(s);
        android.ext.e1.d("searchPointer: " + hexString + " as " + java.lang.Integer.toHexString(i) + " in " + java.lang.Long.toHexString(j) + '-' + java.lang.Long.toHexString(j2) + ", " + java.lang.Long.toString(j3));
        android.ext.MainService mainService = android.ext.MainService.instance;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("-> ");
        sb.append(hexString);
        mainService.h0(sb.toString());
        android.ext.n2.j(new android.ext.f0$l(this, b2, s, i, j, j2, j3));
        android.ext.i2.l = null;
    }

    public void r0(byte b2, long j, long j2, int i, int i2, long j3, long j4, long j5) {
        gg_a.e eVarB = android.ext.c.B();
        int i3 = (i2 & 33554432) != 0 ? i2 & (-33554433) : i2;
        java.lang.CharSequence charSequence = null;
        for (int i4 = 0; i4 < eVarB.size(); i4++) {
            int iKeyAt = eVarB.keyAt(i4);
            if (iKeyAt != 0 && (i3 & iKeyAt) == iKeyAt) {
                charSequence = (java.lang.CharSequence) eVarB.valueAt(i4);
            }
        }
        int i5 = i3 & 127;
        android.ext.c cVar = new android.ext.c(0L, j, i5);
        android.ext.c cVar2 = new android.ext.c(0L, j2, i5);
        android.ext.y yVar = new android.ext.y();
        java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[3];
        charSequenceArr[0] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.value);
        charSequenceArr[1] = charSequence;
        java.lang.Object[] objArr = new java.lang.Object[4];
        objArr[0] = cVar.J();
        objArr[1] = cVar2.J();
        objArr[2] = i == 0 ? "" : " X" + i;
        objArr[3] = cVar.u();
        charSequenceArr[2] = android.ext.Tools.t(android.ext.Tools.L1("%s ~ %s%s %s", objArr), cVar.m());
        yVar.b("%s %s %s", charSequenceArr);
        android.ext.MainService.instance.h0(yVar.d());
        y0(b2, j, j2, i, i3 | 8388608, j3, j4, j5);
    }

    public void s() {
        t((byte) 0);
    }

    public void s0(byte b2, int i, byte[] bArr, long j, long j2, long j3) {
        java.lang.String string = android.ext.x0.b(null, i, bArr, bArr.length, true, true, null).toString();
        if (string.length() > 48) {
            string = string.substring(0, 48) + "...";
        }
        android.ext.e1.d("searchText: [" + bArr.length + "] = " + string + " in " + java.lang.Long.toHexString(j) + '-' + java.lang.Long.toHexString(j2) + ", " + java.lang.Long.toString(j3));
        if (bArr.length == 0) {
            return;
        }
        if (bArr.length == 1) {
            p0(b2, bArr[0], 0, 536870913, j, j2, j3);
            return;
        }
        android.ext.MainService.instance.h0(android.ext.Tools.L1("%s[%d] = %s", android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.text), java.lang.Integer.valueOf(bArr.length), string));
        android.ext.n2.j(new android.ext.f0$m(this, b2, i, j, j2, j3, bArr));
        android.ext.i2.l = null;
    }

    public void t(byte b2) {
        u0(b2, (byte) 49);
    }

    void t0() {
        android.ext.InOut inOut = this.f793b;
        if (C != null) {
            android.ext.e1.i("Last send error: " + C);
            inOut.d();
            return;
        }
        try {
            inOut.l();
            C = null;
        } catch (java.lang.Throwable th) {
            inOut.d();
            android.ext.e1.l("Send error", th);
            C = th.toString();
            android.ext.n2.d().post(new android.ext.f0$z(this));
        }
    }

    void u0(byte b2, byte b3) {
        android.ext.n2.j(new android.ext.f0$y(this, b2, b3));
    }

    void v0(byte b2) {
        android.ext.n2.j(new android.ext.f0$x(this, b2));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x0044  */
    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0067  */
    /* JADX WARN: Code duplicated, block: B:19:0x006e  */
    /* JADX WARN: Code duplicated, block: B:21:0x008a  */
    /* JADX WARN: Instruction removed from duplicated block: B:15:0x004b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:19:0x006e, please report this as an issue */
    public void w(byte b2, long j, long j2, int i, java.lang.String str, java.lang.String str2) {
        java.lang.String string = null;
        java.lang.StringBuilder sb;
        java.lang.String strReplace;
        byte[] bytes;
        byte[] bytes2;
        if (!str.contains("/emulated/legacy")) {
            if (str.contains("/emulated/0")) {
                sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append('|');
                strReplace = str.replace("/emulated/0", "/emulated/legacy");
            } else {
                string = str;
            }
            bytes = string.getBytes();
            if (bytes.length == 0) {
                return;
            }
            if (bytes.length > 4000) {
                android.ext.e1.i("path big: " + bytes.length + " > 4000");
                return;
            }
            bytes2 = str2.getBytes();
            if (bytes2.length > 4000) {
                android.ext.n2.j(new android.ext.f0$b(this, bytes, bytes2, b2, j, j2, i, str));
                return;
            }
            android.ext.e1.i("pkg big: " + bytes2.length + " > 4000");
        }
        sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append('|');
        strReplace = str.replace("/emulated/legacy", "/emulated/0");
        sb.append(strReplace);
        string = sb.toString();
        bytes = string.getBytes();
        if (bytes.length == 0) {
            return;
        }
        if (bytes.length > 4000) {
            android.ext.e1.i("path big: " + bytes.length + " > 4000");
            return;
        }
        bytes2 = str2.getBytes();
        if (bytes2.length > 4000) {
            android.ext.n2.j(new android.ext.f0$b(this, bytes, bytes2, b2, j, j2, i, str));
            return;
        }
        android.ext.e1.i("pkg big: " + bytes2.length + " > 4000");
    }

    public void w0() {
        x0((byte) 0);
    }

    public void x(long j, long j2, int i, java.lang.String str, java.lang.String str2) {
        w((byte) 0, j, j2, i, str, str2);
    }

    public void x0(byte b2) {
        if (this.u == null || android.ext.Config.h != this.u.intValue()) {
            if (this.u != null) {
                android.ext.MainService.instance.m();
            }
            this.u = java.lang.Integer.valueOf(android.ext.Config.h);
        }
        java.lang.String absolutePath = android.ext.Tools.q0().getAbsolutePath();
        android.ext.n2.j(new android.ext.f0$w(this, b2, absolutePath.getBytes(), absolutePath));
    }

    public void z() {
        this.f793b.r();
        if (this.f796e <= 0) {
            return;
        }
        java.io.File file = new java.io.File(android.ext.Tools.q0(), "OOM.tmp");
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            fileOutputStream.write(java.nio.ByteBuffer.allocate(4).order(java.nio.ByteOrder.LITTLE_ENDIAN).putInt(this.f796e).array());
            fileOutputStream.close();
            if (file.renameTo(new java.io.File(android.ext.Tools.q0(), "OOM"))) {
                return;
            }
            android.ext.e1.s("Failed rename OOM file: " + file, new java.lang.RuntimeException());
            file.delete();
        } catch (java.io.IOException e2) {
            android.ext.e1.s("Failed make OOM file: " + file, e2);
        }
    }
}
