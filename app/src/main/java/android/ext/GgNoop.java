package android.ext;

/**
 * Helper used by the reconstruction of the dex exception tables.
 *
 * <p>The dex format has no checked exceptions: a handler matches the
 * runtime type of the failure, no matter what the Java signatures
 * declare.  jadx therefore keeps handlers for exception types that
 * javac considers unreachable.  The reconstruction inserts a guarded
 * throw of the handled type into such a try block:</p>
 *
 * <pre>
 *     if (android.ext.GgNoop.never) {
 *         throw new java.io.IOException();
 *     }
 * </pre>
 *
 * <p>{@link #never} is a plain (non final) static field, so javac cannot
 * fold the condition away and keeps the statement reachable, while at run
 * time the field is always false and the throw never happens.  The original
 * dex handler therefore survives the translation with its runtime
 * behaviour unchanged.</p>
 */
public final class GgNoop {

    /**
     * Always false.  It is deliberately not final: a compile time constant
     * would let javac fold the guarded throw away and mark the original dex
     * handler unreachable again.
     */
    public static boolean never = false;

    private GgNoop() {
    }

    /**
     * Legacy marker: declares that the enclosing block may raise any
     * exception.  Only used where the try block already handles
     * java.lang.Throwable.
     *
     * @throws java.lang.Throwable never, the method has no body that throws
     */
    public static void keep() throws java.lang.Throwable {
    }
}
