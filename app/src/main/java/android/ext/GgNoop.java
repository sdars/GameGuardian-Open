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

    /**
     * Rethrow a failure without changing its runtime type.
     *
     * <p>The dex runtime propagates a failure with the type it was raised
     * with; the java sources of the reconstruction have to satisfy javac,
     * which only knows checked exceptions.  A call of a method that declares
     * a checked exception is therefore wrapped into a
     * {@link java.lang.RuntimeException} - that changes the type of the
     * failure and every dex handler that catches the original type stops
     * matching.</p>
     *
     * <p>This helper throws the failure with its original type (the "sneaky
     * throw" idiom): the cast is unchecked, so the bytecode only carries
     * the erasure of the type variable and the failure leaves the method
     * unchanged.  The type parameter is fixed to
     * {@link java.lang.RuntimeException} at the call site, so javac does not
     * ask the caller to handle a checked exception.</p>
     *
     * @param t the failure to rethrow
     * @return never returns, the method always throws
     * @throws E the type of the failure, at the call site always
     *             {@link java.lang.RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public static <E extends Throwable> RuntimeException rethrow(Throwable t) throws E {
        throw (E) t;
    }
}
