package lasm;

/* JADX INFO: loaded from: classes.dex */
public class c extends java.lang.Error {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1644c;

    public c(java.lang.String str, int i) {
        super(str);
        this.f1642a = i;
    }

    public c(boolean z, int i, int i2, int i3, java.lang.String str, char c2, int i4) {
        this(a(z, i, i2, i3, str, c2), i4);
        this.f1643b = i2;
        this.f1644c = i3;
    }

    protected static java.lang.String a(boolean z, int i, int i2, int i3, java.lang.String str, char c2) {
        java.lang.String str2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Lexical error at line ");
        sb.append(i2);
        sb.append(", column ");
        sb.append(i3);
        sb.append(".  Encountered: ");
        if (z) {
            str2 = "<EOF> ";
        } else {
            str2 = "\"" + b(java.lang.String.valueOf(c2)) + "\" (" + ((int) c2) + "), ";
        }
        sb.append(str2);
        sb.append("after : \"");
        sb.append(b(str));
        sb.append("\"");
        return sb.toString();
    }

    protected static final java.lang.String b(java.lang.String str) {
        java.lang.String str2 = null;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != 0) {
                if (cCharAt == '\"') {
                    str2 = "\\\"";
                } else if (cCharAt == '\'') {
                    str2 = "\\'";
                } else if (cCharAt == '\\') {
                    str2 = "\\\\";
                } else if (cCharAt == '\f') {
                    str2 = "\\f";
                } else if (cCharAt != '\r') {
                    switch (cCharAt) {
                        case '\b':
                            str2 = "\\b";
                            break;
                        case '\t':
                            str2 = "\\t";
                            break;
                        case '\n':
                            str2 = "\\n";
                            break;
                        default:
                            char cCharAt2 = str.charAt(i);
                            if (cCharAt2 < ' ' || cCharAt2 > '~') {
                                java.lang.String str3 = "0000" + java.lang.Integer.toString(cCharAt2, 16);
                                str2 = "\\u" + str3.substring(str3.length() - 4, str3.length());
                            } else {
                                stringBuffer.append(cCharAt2);
                            }
                            break;
                    }
                } else {
                    str2 = "\\r";
                }
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return super.getMessage();
    }
}
