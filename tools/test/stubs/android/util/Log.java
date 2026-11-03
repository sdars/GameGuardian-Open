package android.util;

/**
 * Host-side stub for android.util.Log so that the JVM regression harness can
 * run the app classes outside of a device. Never shipped in the APK.
 */
public final class Log {

    public static int v(String tag, String msg) {
        return 0;
    }

    public static int d(String tag, String msg) {
        return 0;
    }

    public static int i(String tag, String msg) {
        return 0;
    }

    public static int w(String tag, String msg) {
        return 0;
    }

    public static int e(String tag, String msg) {
        return 0;
    }

    public static int e(String tag, String msg, Throwable tr) {
        return 0;
    }

    public static int wtf(String tag, String msg) {
        return 0;
    }

    public static int wtf(String tag, String msg, Throwable tr) {
        return 0;
    }

    public static String getStackTraceString(Throwable tr) {
        return "";
    }

    public static int println(int priority, String tag, String msg) {
        return 0;
    }

    public static boolean isLoggable(String tag, int level) {
        return false;
    }
}
