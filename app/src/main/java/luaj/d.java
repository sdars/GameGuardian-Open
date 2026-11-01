package luaj;

/* JADX INFO: loaded from: classes.dex */
public class d extends java.lang.RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f1708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected java.lang.String f1709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected java.lang.String f1710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f1711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected java.lang.String f1712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected java.lang.Throwable f1713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    luaj.LuaValue f1714g;
    protected java.lang.String h;
    public java.lang.String i;

    public d(java.lang.String str) {
        super(str);
        this.i = null;
        this.f1708a = 1;
    }

    public d(java.lang.String str, int i) {
        super(str);
        this.i = null;
        this.f1708a = i;
    }

    public d(java.lang.String str, int i, java.lang.String str2) {
        super(str2);
        this.i = null;
        this.f1708a = 1;
        this.f1710c = str;
        this.f1711d = i;
        d();
    }

    public d(java.lang.String str, java.lang.Throwable th) {
        super(str);
        this.i = null;
        this.f1713f = th;
        this.f1708a = 1;
    }

    public d(java.lang.Throwable th) {
        super("vm error: " + th);
        this.i = null;
        this.f1713f = th;
        this.f1708a = 1;
    }

    public d(luaj.LuaValue luaValue) {
        super(luaValue.g0());
        this.i = null;
        this.f1714g = luaValue;
        this.f1708a = 1;
    }

    private java.lang.String a() {
        java.lang.String strC;
        java.lang.String strSubstring = this.f1710c;
        if (strSubstring == null || this.f1711d < 0) {
            return this.f1709b + '\n';
        }
        try {
            int i = 1;
            if (strSubstring.length() > 0 && strSubstring.charAt(0) == '@') {
                strSubstring = strSubstring.substring(1);
            }
            java.io.File file = new java.io.File(strSubstring);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(file.exists() ? new java.io.BufferedInputStream(new java.io.FileInputStream(file)) : new java.io.ByteArrayInputStream(strSubstring.getBytes())));
            while (i < this.f1711d && bufferedReader.readLine() != null) {
                i++;
            }
            strC = i == this.f1711d ? c(bufferedReader.readLine()) : "failed read line";
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed read source", th);
            strC = "failed read source";
        }
        return this.f1709b + "\n`" + strC + '`';
    }

    private java.lang.String c(java.lang.String str) {
        if (str == null || str.length() <= 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public luaj.LuaValue b() {
        luaj.LuaValue luaValue = this.f1714g;
        if (luaValue != null) {
            return luaValue;
        }
        java.lang.String message = getMessage();
        if (message != null) {
            return luaj.LuaValue.K2(message);
        }
        return null;
    }

    public void d() {
        this.f1709b = c(this.f1710c) + ":" + this.f1711d;
    }

    @Override // java.lang.Throwable
    public java.lang.Throwable getCause() {
        return this.f1713f;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        java.lang.String str = this.f1712e;
        if (str != null) {
            java.lang.String str2 = this.i;
            if (str2 == null || str.startsWith(str2)) {
                return this.f1712e;
            }
            return this.i + this.f1712e;
        }
        java.lang.String message = this.h;
        if (message == null) {
            message = super.getMessage();
        }
        if (message == null) {
            return null;
        }
        if (this.f1709b != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str3 = this.i;
            sb.append((str3 == null || message.startsWith(str3)) ? "" : this.i);
            sb.append(a());
            sb.append('\n');
            sb.append(message);
            return sb.toString();
        }
        java.lang.String str4 = this.i;
        if (str4 == null || message.startsWith(str4)) {
            return message;
        }
        return this.i + message;
    }
}
