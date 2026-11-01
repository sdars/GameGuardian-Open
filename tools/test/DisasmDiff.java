import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Random;

/**
 * Differential test for the split of android.ext.m.g.
 *
 * The disassembler was cut into many methods because the class file format
 * does not allow more than 65535 bytes of bytecode per method.  This test
 * loads the original class and the split class in two separate class
 * loaders and compares the output of the disassembler for a large number of
 * random inputs.  Both versions have to produce the same text for every
 * input.
 *
 *     java -cp android.jar:. DisasmDiff <classes-orig> <classes-split>
 */
public class DisasmDiff {

    private static Method load(URLClassLoader cl) throws Exception {
        Class<?> c = cl.loadClass("android.ext.m");
        return c.getMethod("g", int[].class, long.class, int.class, StringBuilder.class);
    }

    private static String call(Method m, int[] arr, long j, int i) {
        StringBuilder sb = new StringBuilder();
        try {
            Object o = m.invoke(null, arr, j, i, sb);
            return String.valueOf(o) + "|" + sb;
        } catch (Throwable t) {
            Throwable c = t.getCause() == null ? t : t.getCause();
            return "EX:" + c.getClass().getName() + ":" + c.getMessage();
        }
    }

    public static void main(String[] args) throws Exception {
        URL jar = new File(args[2]).toURI().toURL();
        URLClassLoader la = new URLClassLoader(
                new URL[]{new File(args[0]).toURI().toURL(), jar}, null);
        URLClassLoader lb = new URLClassLoader(
                new URL[]{new File(args[1]).toURI().toURL(), jar}, null);
        Method ma = load(la);
        Method mb = load(lb);
        int rounds = args.length > 3 ? Integer.parseInt(args[3]) : 20000;
        Random r = new Random(20261102L);
        int diffs = 0;
        for (int t = 0; t < rounds; t++) {
            int[] arr = new int[8];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = r.nextInt();
            }
            long j = r.nextLong();
            int i = r.nextInt();
            String sa = call(ma, arr.clone(), j, i);
            String sb = call(mb, arr.clone(), j, i);
            if (!sa.equals(sb)) {
                if (diffs < 5) {
                    System.out.println("DIFF round " + t + " j=" + j + " i=" + i);
                    System.out.println("  orig: " + sa);
                    System.out.println("  split: " + sb);
                }
                diffs++;
            }
        }
        System.out.println("rounds=" + rounds + " diffs=" + diffs);
        if (diffs != 0) {
            System.exit(1);
        }
    }
}
