import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import luaj.Globals;

/**
 * Dump the compiled proto (bytecode) of a lua chunk.
 *
 * The member names differ between the two classpaths (jadx renamed the
 * members of luaj.h), so the fields are looked up by a list of candidates.
 */
public final class ProtoDump {

    public static void main(String[] argv) throws Exception {
        byte[] raw = Files.readAllBytes(Paths.get(argv[0]));
        Globals globals = new Globals();
        globals.X = true;
        installCompiler(globals);
        luaj.h proto = globals.N3(new ByteArrayInputStream(raw), "=dump");
        dump(proto, 0);
    }

    private static void dump(luaj.h proto, int depth) throws Exception {
        String pad = new String(new char[depth * 2]).replace('\0', ' ');
        int[] code = (int[]) field(proto, "f1724b", "b");
        luaj.LuaValue[] consts = (luaj.LuaValue[]) field(proto, "f1723a", "a");
        int[] lines = (int[]) field(proto, "f1726d", "d");
        System.out.println(pad + "proto name=" + proto.b()
                + " h=" + proto.h + " i=" + proto.i + " j=" + proto.j
                + " k=" + proto.k + " l=" + proto.l);
        System.out.println(pad + "code len=" + (code == null ? -1 : code.length));
        if (code != null) {
            for (int i = 0; i < code.length; i++) {
                System.out.println(pad + "  [" + i + "] " + Integer.toHexString(code[i])
                        + " op=" + (code[i] >>> 23)
                        + (lines != null && i < lines.length ? " line=" + lines[i] : ""));
            }
        }
        if (consts != null) {
            for (int i = 0; i < consts.length; i++) {
                System.out.println(pad + "  const[" + i + "] " + consts[i]);
            }
        }
        luaj.h[] protos = (luaj.h[]) field(proto, "f1725c", "c");
        if (protos != null) {
            for (luaj.h child : protos) {
                dump(child, depth + 1);
            }
        }
    }

    private static Object field(Object o, String... names) throws Exception {
        for (String n : names) {
            try {
                Field f = o.getClass().getField(n);
                return f.get(o);
            } catch (NoSuchFieldException ignored) {
            }
        }
        throw new NoSuchFieldException(names[0]);
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
                    return false;
                }
            }
        }
        return false;
    }
}
