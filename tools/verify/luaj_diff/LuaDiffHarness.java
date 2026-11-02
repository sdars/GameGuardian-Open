import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

import luaj.Globals;
import luaj.LuaValue;

/**
 * Behavioural differential harness for the pure-source luaj VM.
 *
 * The same harness is executed twice:
 *   - against build/app_classes   (our pure-source reconstruction)
 *   - against tmp/analysis/.../classes.jar (dex2jar dump of the original dex)
 *
 * Both runs must print byte-identical stdout, which proves the mechanically
 * translated LuaClosure.Y2 compiler is behaviourally equivalent.
 *
 * The identity hash of a table (``table(1a2b3c)``) is the JVM's
 * Object.hashCode of the LuaTable instance.  It depends on the allocation
 * and class loading history of the process, so two different class paths
 * can never produce the same value even when they behave identically.  The
 * harness therefore canonicalises that one value; everything else is
 * compared byte for byte.
 *
 * usage: LuaDiffHarness <file.lua>
 */
public final class LuaDiffHarness {

    public static void main(String[] argv) throws Exception {
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
        java.io.PrintStream real = System.out;
        System.setOut(new java.io.PrintStream(buffer, true, "UTF-8"));
        try {
            run(argv);
        } finally {
            System.out.flush();
            System.setOut(real);
            real.print(canonicalize(buffer.toString("UTF-8")));
            real.flush();
        }
    }

    private static void run(String[] argv) throws Exception {
        if (argv.length < 1) {
            System.out.println("usage: LuaDiffHarness <file.lua>");
            System.exit(2);
            return;
        }

        byte[] raw = Files.readAllBytes(Paths.get(argv[0]));

        Globals globals = new Globals();
        // Globals.X gates the full part of the base library (print, pcall,
        // load, ...): android.ext.Script.F3() switches it off, the script
        // runner switches it on.
        globals.X = true;
        // The luaj compiler lives in the obfuscated root package: gg_g.h in the
        // pure-source tree, g.h in the original dex dump.  Both expose the same
        // static entry point M(luaj.Globals) which installs both the compiler
        // (Globals.k0) and the closure factory (Globals.j0).
        if (!installCompiler(globals)) {
            System.out.println("### ERROR could not locate the luaj compiler");
            return;
        }
        // library order is identical to android.ext.Script.F3()
        globals.t1(new luaj.lib.BaseLib());
        globals.t1(new luaj.lib.Bit32Lib());
        globals.t1(new luaj.lib.TableLib());
        globals.t1(new luaj.lib.StringLib());
        globals.t1(new luaj.lib.Utf8Lib());
        globals.t1(new luaj.lib.MathLib());
        globals.t1(new luaj.lib.OsLib());

        try {
            LuaValue chunk = globals.O3(new ByteArrayInputStream(raw), "=diff", "t", globals);
            LuaValue result = chunk.call();
            System.out.println("### RETURN " + describe(result));
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            String msg = t.getMessage();
            if (msg == null) {
                msg = "";
            }
            System.out.println("### ERROR " + t.getClass().getName() + " | " + msg);
        }
        System.out.flush();
    }

    private static String canonicalize(String s) {
        return s.replaceAll("table\\([0-9a-fA-F]+\\)", "table(ID)");
    }

    private static boolean installCompiler(Globals globals) {
        String[] candidates = { "gg_g.h", "g.h" };
        for (String name : candidates) {
            Class<?> cls;
            try {
                cls = Class.forName(name);
            } catch (Throwable t) {
                continue;
            }
            for (Method m : cls.getMethods()) {
                if (!m.getName().equals("M")) {
                    continue;
                }
                Class<?>[] p = m.getParameterTypes();
                if (p.length != 1 || !p[0].isAssignableFrom(Globals.class)) {
                    continue;
                }
                try {
                    m.invoke(null, globals);
                    return true;
                } catch (Throwable t) {
                    System.out.println("### ERROR compiler install failed: " + t);
                    return false;
                }
            }
        }
        return false;
    }

    private static String describe(LuaValue v) {
        if (v == null) {
            return "null";
        }
        if (v instanceof luaj.LuaNil) {
            return "nil";
        }
        if (v instanceof luaj.LuaTable) {
            return "table";
        }
        return v.getClass().getSimpleName() + ":" + v.g0();
    }
}
