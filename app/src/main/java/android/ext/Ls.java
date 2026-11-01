package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Ls {
    public static void main(java.lang.String[] strArr) {
        java.io.File[] fileArrListFiles = new java.io.File(strArr[0]).listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file : fileArrListFiles) {
                if (file != null) {
                    java.lang.System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
