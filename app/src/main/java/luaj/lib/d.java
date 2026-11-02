package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile java.lang.reflect.Field f1792a;

    public static java.lang.String a(java.io.File file) {
        try {
            return file.getCanonicalPath();
        } catch (java.io.IOException unused) {
            return file.getAbsolutePath();
        }
    }

    public static boolean b(java.io.FileDescriptor fileDescriptor, luaj.lib.e eVar, boolean z) {
        if (eVar == null) {
            return true;
        }
        java.lang.String strG = g(fileDescriptor);
        if (strG == null) {
            return false;
        }
        return !eVar.m(strG, z);
    }

    static int c(java.io.FileDescriptor fileDescriptor) throws java.lang.NoSuchFieldException {
        java.lang.reflect.Field declaredField;
        java.lang.reflect.Field field = f1792a;
        if (field == null) {
            try {
                declaredField = java.io.FileDescriptor.class.getDeclaredField("descriptor");
            } catch (java.lang.NoSuchFieldException unused) {
                declaredField = java.io.FileDescriptor.class.getDeclaredField("fd");
            }
            field = declaredField;
            field.setAccessible(true);
            f1792a = field;
        }try {

        return field.getInt(fileDescriptor);
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    public static java.lang.String d(java.lang.String str) {
        if (!str.startsWith("/data/data/")) {
            return str;
        }
        return "/data/user/0/" + str.substring(11);
    }

    public static java.io.FileInputStream e(java.io.File file, luaj.lib.e eVar) {
        if (eVar == null) {try {

            return new java.io.FileInputStream(file);
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        }
        java.lang.String strA = a(file);
        if (eVar.m(strA, true)) {
            return null;
        }java.io.FileInputStream fileInputStream;
        try {
        fileInputStream = new java.io.FileInputStream(new java.io.File(strA));;
        } catch (java.lang.Throwable ggEx2) {
            throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
        }try {

        if (b(fileInputStream.getFD(), eVar, true)) {
            return fileInputStream;
        };
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        try {
            fileInputStream.close();
        } catch (java.io.IOException unused) {
        }
        return null;
    }

    public static java.io.RandomAccessFile f(java.io.File file, luaj.lib.e eVar) throws java.io.IOException {
        if (eVar == null) {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            randomAccessFile.setLength(0L);
            return randomAccessFile;
        }
        java.lang.String strA = a(file);
        if (eVar.m(strA, false)) {
            return null;
        }
        java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(new java.io.File(strA), "rw");
        if (b(randomAccessFile2.getFD(), eVar, false)) {
            randomAccessFile2.setLength(0L);
            return randomAccessFile2;
        }
        try {
            randomAccessFile2.close();
        } catch (java.io.IOException unused) {
        }
        return null;
    }

    public static java.lang.String g(java.io.FileDescriptor fileDescriptor) {
        try {
            return h("/proc/self/fd/" + c(fileDescriptor));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.String h(java.lang.String str) {
        try {
            try {
                return java.nio.file.Files.readSymbolicLink(java.nio.file.Paths.get(str, new java.lang.String[0])).toString();
            } catch (java.lang.Throwable unused) {
                return android.system.Os.readlink(str);
            }
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }
}
