package gg_e;

/* JADX INFO: loaded from: classes.dex */
public class d extends java.lang.RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[][] f1536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public java.lang.String[] f1537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected java.lang.String f1538d;

    public d() {
        this.f1538d = java.lang.System.getProperty("line.separator", "\n");
    }

    public d(f fVar, int[][] iArr, java.lang.String[] strArr) {
        super(b(fVar, iArr, strArr));
        this.f1538d = java.lang.System.getProperty("line.separator", "\n");
        this.f1535a = fVar;
        this.f1536b = iArr;
        this.f1537c = strArr;
    }

    public d(java.lang.String str) {
        super(str);
        this.f1538d = java.lang.System.getProperty("line.separator", "\n");
    }

    public d(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.f1538d = java.lang.System.getProperty("line.separator", "\n");
    }

    static java.lang.String a(java.lang.String str) {
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

    private static java.lang.String b(f fVar, int[][] iArr, java.lang.String[] strArr) {
        java.lang.StringBuilder sb;
        java.lang.String str;
        int[] iArr2;
        java.lang.String property = java.lang.System.getProperty("line.separator", "\n");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int length = 0;
        for (int i = 0; i < iArr.length; i++) {
            int[] iArr3 = iArr[i];
            if (length < iArr3.length) {
                length = iArr3.length;
            }
            int i2 = 0;
            while (true) {
                iArr2 = iArr[i];
                if (i2 >= iArr2.length) {
                    break;
                }
                stringBuffer.append(strArr[iArr2[i2]]);
                stringBuffer.append(' ');
                i2++;
            }
            if (iArr2[iArr2.length - 1] != 0) {
                stringBuffer.append("...");
            }
            stringBuffer.append(property);
            stringBuffer.append("    ");
        }
        f fVar2 = fVar.f1552g;
        java.lang.String str2 = "Encountered \"";
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                str2 = str2 + " ";
            }
            if (fVar2.f1546a == 0) {
                str2 = str2 + strArr[0];
                break;
            }
            str2 = (((str2 + " " + strArr[fVar2.f1546a]) + " \"") + a(fVar2.f1551f)) + " \"";
            fVar2 = fVar2.f1552g;
        }
        java.lang.String str3 = (str2 + "\" at line " + fVar.f1552g.f1547b + ", column " + fVar.f1552g.f1548c) + "." + property;
        if (iArr.length == 1) {
            sb = new java.lang.StringBuilder();
            sb.append(str3);
            str = "Was expecting:";
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(str3);
            str = "Was expecting one of:";
        }
        sb.append(str);
        sb.append(property);
        sb.append("    ");
        return sb.toString() + stringBuffer.toString();
    }
}
