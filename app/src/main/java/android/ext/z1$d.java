package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class z1$d implements java.lang.Comparable<android.ext.z1$d> {
    private static java.lang.ref.WeakReference q;
    public static final int r = android.ext.Tools.e0(catch_.me_.if_.you_.can_.R.color.process_pid, -5570561);
    public static final int s = android.ext.Tools.e0(catch_.me_.if_.you_.can_.R.color.process_name, -1);
    public static final int t = android.ext.Tools.e0(catch_.me_.if_.you_.can_.R.color.process_size, -5570646);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f1432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public java.lang.String f1433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public java.lang.String f1434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public java.lang.String f1435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile android.graphics.drawable.Drawable f1436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1438g;
    public int h;
    public boolean i;
    public boolean j;
    public long k;
    public boolean l;
    public int m;
    public boolean n;
    public int o;
    volatile boolean p;

    public z1$d(android.ext.z1$c z1_c, int i, int i2, java.lang.String str, int i3, boolean z, int i4) {
        this.p = false;
        this.f1432a = str;
        this.f1433b = z1_c.f1428d;
        this.f1434c = z1_c.f1427c;
        java.lang.String str2 = z1_c.f1429e;
        this.f1435d = str2 == null ? "" : str2;
        this.f1436e = null;
        this.f1437f = i;
        this.f1438g = i2;
        this.h = z1_c.h ? i2 : z1_c.f1426b;
        this.l = str.equals(z1_c.f1427c);
        this.i = z1_c.f1430f;
        this.j = z1_c.f1431g;
        this.m = i3;
        this.n = z;
        this.o = i4;
        if (z1_c.h) {
            this.p = true;
        }
    }

    private java.lang.String e() {
        if (this.l) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(" (");
        sb.append(this.f1432a.replace(this.f1434c + ':', ""));
        sb.append(')');
        return sb.toString();
    }

    void i(int i) {
        android.graphics.drawable.Drawable drawableR1;
        if (this.p) {
            return;
        }
        android.graphics.drawable.Drawable drawableL = android.ext.z1.l(this.f1434c);
        if (drawableL != null) {
            synchronized (android.ext.z1.f1415f) {
                if (i != 0) {
                    try {
                        if (i != android.ext.z1.f1416g) {
                            return;
                        }
                    } catch (java.lang.Throwable th_c_c_c) {
                        throw th_c_c_c;
                    }
                }
                this.f1436e = drawableL;
                this.p = true;
                return;
            }
        }
        try {
            drawableR1 = android.ext.Tools.R1(android.ext.Tools.G0(android.ext.Tools.X(android.ext.Tools.Y(this.f1434c)), android.ext.Tools.H()));
        } catch (java.lang.Throwable unused) {
            android.ext.e1.p("Failed load icon for " + this.f1434c);
            drawableR1 = null;
        }
        synchronized (android.ext.z1.f1415f) {
            if (i != 0) {
                try {
                    if (i != android.ext.z1.f1416g) {
                        return;
                    }
                } catch (java.lang.Throwable th2_c_c_c) {
                    throw th2_c_c_c;
                }
            }
            this.f1436e = drawableR1;
            if (drawableR1 != null) {
                android.ext.z1.r(this.f1434c, drawableR1);
            }
            this.p = true;
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(android.ext.z1$d z1_d) {
        int i = this.m;
        int i2 = z1_d.m;
        if (i == i2) {
            boolean z = this.j;
            if (z == z1_d.j) {
                boolean z2 = this.i;
                if (z2 == z1_d.i) {
                    long j = this.k;
                    long j2 = z1_d.k;
                    if (j == j2) {
                        boolean z3 = this.l;
                        if (z3 == z1_d.l) {
                            if ((f() > 0) == (z1_d.f() > 0)) {
                                int i3 = this.f1437f;
                                int i4 = z1_d.f1437f;
                                if (i3 == i4) {
                                    return 0;
                                }
                                if (i3 > i4) {
                                    return -1;
                                }
                            } else if (f() <= 0) {
                                return -1;
                            }
                        } else if (z3) {
                            return -1;
                        }
                    } else if (j > j2) {
                        return -1;
                    }
                } else if (!z2) {
                    return -1;
                }
            } else if (z) {
                return -1;
            }
        } else if (i > i2) {
            return -1;
        }
        return 1;
    }

    public java.lang.String d() {
        return "ProcessInfo [cmdline=" + this.f1432a + ", name=" + this.f1433b + ", packageName=" + this.f1434c + ", icon=" + this.f1436e + ", pid=" + this.f1437f + ", uid=" + this.f1438g + ", isSystem=" + this.i + ", isGame=" + this.j + ", weight=" + this.k + ", main=" + this.l + ", order=" + this.m + ", x64=" + this.n + ", rss=" + this.o + ", getTracer()=" + g() + ", getTrace()=" + f() + ']';
    }

    public int f() {
        android.util.SparseIntArray sparseIntArray = android.ext.z1.h;
        int iIndexOfValue = sparseIntArray.indexOfValue(this.f1437f);
        return iIndexOfValue >= 0 ? sparseIntArray.keyAt(iIndexOfValue) : iIndexOfValue;
    }

    public int g() {
        return android.ext.z1.h.get(this.f1437f);
    }

    public void h() {
        i(0);
    }

    public void j(android.widget.TextView textView) {
        android.graphics.drawable.Drawable drawableL;
        if (textView == null) {
            return;
        }
        boolean z = this.p;
        android.graphics.drawable.Drawable drawableO0 = this.f1436e;
        if (drawableO0 == null && (drawableL = android.ext.z1.l(this.f1434c)) != null) {
            this.f1436e = drawableL;
            z = true;
            this.p = true;
            drawableO0 = drawableL;
        }
        if (drawableO0 == null) {
            java.lang.ref.WeakReference weakReference = q;
            if (weakReference != null) {
                drawableO0 = (android.graphics.drawable.Drawable) weakReference.get();
            }
            if (drawableO0 == null) {
                drawableO0 = android.ext.Tools.o0(catch_.me_.if_.you_.can_.R.drawable.empty);
                q = new java.lang.ref.WeakReference(drawableO0);
            }
        }
        android.ext.Tools.c(textView, drawableO0, 48);
        if (z) {
            return;
        }
        android.ext.n2.h(new android.ext.z1$d$a(this, textView));
    }

    public void k() {
        android.content.pm.ApplicationInfo applicationInfoY;
        if (this.f1438g == this.h) {
            return;
        }
        android.ext.e1.p("vs app: " + this.h + " != " + this.f1438g);
        try {
            java.lang.String strM = android.ext.z1.i.m(this.f1438g);
            if (strM == null || (applicationInfoY = android.ext.Tools.Y(strM)) == null || applicationInfoY.nativeLibraryDir == null) {
                return;
            }
            android.ext.e1.p("vs: " + this.f1435d + " => " + applicationInfoY.nativeLibraryDir);
            this.f1435d = applicationInfoY.nativeLibraryDir;
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed get vs info for " + this.f1438g, th);
        }
    }

    public java.lang.CharSequence l() {
        android.ext.y yVar = new android.ext.y();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (g() > 0) {
            sb.append('#');
        }
        if (f() > 0) {
            sb.append('!');
        }
        if (!android.ext.Config.C && this.f1438g != this.h) {
            sb.append('v');
        }
        if (this.f1437f > 1) {
            sb.append('[');
            sb.append(java.lang.Integer.toString(this.f1437f));
            sb.append("] ");
        }
        yVar.a(android.ext.Tools.t(sb.toString(), r));
        yVar.a(android.ext.Tools.t(this.f1433b + e(), s));
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        if (this.n) {
            sb2.append(" [x64]");
        }
        if (this.o != 0) {
            sb2.append(" [");
            sb2.append(android.ext.Tools.U(android.ext.Tools.f0(), ((long) this.o) * 1024));
            sb2.append(']');
        }
        yVar.a(android.ext.Tools.t(sb2.toString(), t));
        return yVar.d();
    }

    public java.lang.String toString() {
        return l().toString();
    }
}
