package luaj;

/* JADX INFO: loaded from: classes.dex */
public class c extends luaj.d {
    public final int j;
    public final java.lang.String k;
    public final java.lang.String l;

    public c(int i, java.lang.String str, java.lang.String str2) {
        super((java.lang.String) null);
        this.j = i;
        this.k = str2;
        this.l = e(str);
        this.h = f();
    }

    c(luaj.c cVar) {
        super((java.lang.String) null, cVar);
        this.j = cVar.j - 1;
        this.k = cVar.k;
        this.l = cVar.l;
        this.h = f();
    }

    private java.lang.String e(java.lang.String str) {
        java.lang.StackTraceElement[] stackTrace;
        if (str != null || (stackTrace = getStackTrace()) == null) {
            return str;
        }
        int length = stackTrace.length;
        for (int i = 1; i < length; i++) {
            java.lang.String className = stackTrace[i].getClassName();
            if (className != null) {
                if (className.endsWith("LuaClosure")) {
                    return str;
                }
                if (className.contains("Lib$")) {
                    return luaj.LuaFunction.U2(className);
                }
            }
        }
        return str;
    }

    private java.lang.String f() {
        java.lang.StringBuilder sb;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        if (this.l == null) {
            sb = new java.lang.StringBuilder();
            if (this.j == 0) {
                str3 = "calling method on bad self";
            } else {
                str3 = "bad argument #" + this.j + ": ";
            }
            sb.append(str3);
            str2 = this.k;
        } else {
            sb = new java.lang.StringBuilder();
            if (this.j == 0) {
                str = "calling '" + this.l + "' on bad self";
            } else {
                str = "bad argument #" + this.j + " to '" + this.l + "'";
            }
            sb.append(str);
            sb.append(" (");
            sb.append(this.k);
            str2 = ")";
        }
        sb.append(str2);
        return sb.toString();
    }
}
