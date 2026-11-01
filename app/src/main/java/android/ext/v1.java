package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class v1 {
    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb;
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        if (z1_d == null) {
            sb = new java.lang.StringBuilder();
            sb.append(b(null, str));
            sb.append("/file");
        } else {
            java.lang.String str4 = z1_d.f1434c;
            java.lang.String string = android.ext.Tools.M0().getString(str4 + str2, null);
            if (string != null) {
                return string;
            }
            sb = new java.lang.StringBuilder();
            sb.append(b(null, str));
            sb.append('/');
            sb.append(str4);
        }
        sb.append(str3);
        return sb.toString();
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = android.ext.Tools.K0() + "/Notes";
        if (str == null) {
            return android.ext.Tools.M0().getString(str2, str3);
        }
        new android.ext.g2().k(str2, str, str3).commit();
        return null;
    }

    public static void c(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.io.File file = new java.io.File(str.trim());
        java.lang.String parent = file.getParent();
        if (str2 != null && parent != null && parent.length() > 0) {
            b(parent, str2);
        }
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        if (z1_d != null) {
            java.lang.String str5 = z1_d.f1434c;
            new android.ext.g2().k(str5 + str3, file.getAbsolutePath(), b(null, str2) + '/' + str5 + str4).commit();
        }
    }
}
