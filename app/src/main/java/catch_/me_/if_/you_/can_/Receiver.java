package catch_.me_.if_.you_.can_;

/**
 * The broadcast receiver the original APK declares in its manifest.
 *
 * android.ext.w2 builds the intents of the notification actions with
 * {@code setClassName(pkg, pkg + ".Receiver")}, so the class has to exist
 * under the application id or every tap on a notification action ends in a
 * ClassNotFoundException.  The original smali
 * (build/puresrc/original/catch_/me_/if_/you_/can_/Receiver.smali) is a
 * final class that only extends android.ext.w2, so this is its exact
 * counterpart.
 */
public final class Receiver extends android.ext.w2 {
}
