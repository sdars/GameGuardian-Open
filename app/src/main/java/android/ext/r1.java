package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class r1 {
    public static int a(java.lang.Object obj, java.lang.Object obj2) {
        int iB;
        java.lang.String string = obj.toString();
        java.lang.String string2 = obj2.toString();
        int length = string.length();
        int length2 = string2.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            char cCharAt = i >= length ? (char) 0 : string.charAt(i);
            char cCharAt2 = i2 >= length2 ? (char) 0 : string2.charAt(i2);
            int i3 = 0;
            while (true) {
                if (cCharAt != ' ' && cCharAt != '0') {
                    break;
                }
                i3 = cCharAt == '0' ? i3 + 1 : 0;
                i++;
                cCharAt = i >= length ? (char) 0 : string.charAt(i);
            }
            int i4 = 0;
            while (true) {
                if (cCharAt2 != ' ' && cCharAt2 != '0') {
                    break;
                }
                i4 = cCharAt2 == '0' ? i4 + 1 : 0;
                i2++;
                cCharAt2 = i2 >= length2 ? (char) 0 : string2.charAt(i2);
            }
            if (cCharAt <= '9' && cCharAt2 <= '9' && '0' <= cCharAt && '0' <= cCharAt2 && (iB = b(string.substring(i), string2.substring(i2))) != 0) {
                return iB;
            }
            if (cCharAt == 0 && cCharAt2 == 0) {
                return i3 - i4;
            }
            if (cCharAt < cCharAt2) {
                return -1;
            }
            if (cCharAt > cCharAt2) {
                return 1;
            }
            i++;
            i2++;
        }
    }

    private static int b(java.lang.String str, java.lang.String str2) {
        int length = str.length();
        int length2 = str2.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            char cCharAt = i >= length ? (char) 0 : str.charAt(i);
            char cCharAt2 = i2 >= length2 ? (char) 0 : str2.charAt(i2);
            boolean z = cCharAt > '9' || '0' > cCharAt;
            boolean z2 = cCharAt2 > '9' || '0' > cCharAt2;
            if (z && z2) {
                return i3;
            }
            if (z) {
                return -1;
            }
            if (z2) {
                return 1;
            }
            if (cCharAt == 0 && cCharAt2 == 0) {
                return i3;
            }
            if (i3 == 0) {
                if (cCharAt < cCharAt2) {
                    i3 = -1;
                } else if (cCharAt > cCharAt2) {
                    i3 = 1;
                }
            }
            i++;
            i2++;
        }
    }
}
