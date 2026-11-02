package android.ext;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Behavioural differential harness for the three methods that used to be
 * shipped as a smali overlay and are plain java source now:
 *
 *   android.ext.m.e(android.ext.n, int[], long, java.lang.String, int)
 *   android.ext.n$a.a(android.ext.n, long, java.lang.String, int)
 *
 * The harness is compiled once and executed twice: once with the original
 * dex (dex2jar dump = the reference implementation) and once with the pure
 * source reconstruction.  Both runs see the same inputs and their output
 * has to be byte identical.
 *
 * The harness lives in package android.ext so that it can reach the package
 * private members of the reconstruction.  It uses reflection for the state
 * read back, because the reconstruction renamed the fields (c -> f1081c and
 * so on, see tools/repair/member_renames.json); the alias tables below map
 * both spellings onto one canonical name.
 */
public final class OverlayDiffHarness {

    private static final String[] REGION_ALIASES = {"text", "len", "cursor", "d", "e"};
    private static final String[][] REGION_FIELDS = {
        {"a", "f1088a"},
        {"b", "f1089b"},
        {"c", "f1090c"},
        {"d", "f1091d"},
        {"e", "f1092e"},
    };

    private static final String[][] N_FIELDS = {
        {"a", "f1079a"},
        {"b", "f1080b"},
    };

    private OverlayDiffHarness() {
    }

    private static Object read(Object owner, String[] names) {
        if (owner == null) {
            return null;
        }
        for (Field f : owner.getClass().getDeclaredFields()) {
            for (String nm : names) {
                if (f.getName().equals(nm)) {
                    try {
                        f.setAccessible(true);
                        return f.get(owner);
                    } catch (Exception ignored) {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    private static String render(Object v) {
        if (v == null) {
            return "null";
        }
        if (v instanceof int[]) {
            int[] a = (int[]) v;
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < a.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(Integer.toHexString(a[i]));
            }
            return sb.append(']').toString();
        }
        return String.valueOf(v);
    }

    /** Dump the observable state of the n instance (the region descriptor). */
    private static void dumpN(Object nObj) {
        for (int i = 0; i < N_FIELDS.length; i++) {
            System.out.println("  n." + N_FIELDS[i][0] + "=" + render(read(nObj, N_FIELDS[i])));
        }
        Object region = null;
        for (Field f : nObj.getClass().getDeclaredFields()) {
            if (f.getType().getName().equals("android.ext.n$d")) {
                try {
                    f.setAccessible(true);
                    region = f.get(nObj);
                } catch (Exception ignored) {
                    region = null;
                }
            }
        }
        if (region == null) {
            System.out.println("  region=null");
            return;
        }
        for (int i = 0; i < REGION_FIELDS.length; i++) {
            Object v = read(region, REGION_FIELDS[i]);
            String s = render(v);
            if (v instanceof String && ((String) v).length() > 64) {
                s = ((String) v).substring(0, 64);
            }
            System.out.println("  region." + REGION_ALIASES[i] + "=" + s);
        }
    }

    private static String exc(Throwable t) {
        if (t == null) {
            return "none";
        }
        StringBuilder sb = new StringBuilder(t.getClass().getName());
        String m = t.getMessage();
        if (m != null) {
            sb.append(':').append(m.replace('\n', ' '));
        }
        return sb.toString();
    }

    // ------------------------------------------------------------------ m.e

    private static void runME(String text, long addr, int flag, int bufLen) {
        System.out.println("M case textLen=" + text.length() + " addr=" + addr + " flag=" + flag
                + " bufLen=" + bufLen + " text=" + brief(text));
        n nObj = new n();
        int[] buf = new int[bufLen];
        int res = Integer.MIN_VALUE;
        Throwable err = null;
        try {
            res = m.e(nObj, buf, addr, text, flag);
        } catch (Throwable t) {
            err = t;
        }
        System.out.println("  res=" + res + " exc=" + exc(err));
        System.out.println("  buf=" + render(buf));
        dumpN(nObj);
    }

    // -------------------------------------------------------------- n$a.a

    private static void runNaA(String text, long addr, int flag) {
        System.out.println("N case textLen=" + text.length() + " addr=" + addr + " flag=" + flag
                + " text=" + brief(text));
        n nObj = new n();
        int res = Integer.MIN_VALUE;
        Throwable err = null;
        try {
            res = n$a.a(nObj, addr, text, flag);
        } catch (Throwable t) {
            err = t;
        }
        System.out.println("  res=" + res + " exc=" + exc(err));
        dumpN(nObj);
    }

    private static String brief(String s) {
        String t = s.replace("\n", "\\n").replace("\t", "\\t");
        if (t.length() <= 96) {
            return t;
        }
        return t.substring(0, 96) + "...";
    }

    public static void main(String[] args) {
        String[] fixed = {
            "",
            " ",
            "0",
            "00000000",
            "d5033fbf",
            "D5033FBF",
            "d5033f9f",
            "d5033ddf",
            "d5033fbf d5033f9f d5033ddf",
            "00000000 00000000 00000000 00000000",
            "1c000000",
            "ff ff ff ff",
            "-1 -2 3",
            "D5033FBF\nD5033F9F\n",
            "d5033fbf\tD5033f9f",
            "zzz",
            "0x1234",
            "1234567890abcdef",
            "d5033fbfd5033f9fd5033ddfd5033fbfd5033f9f",
            "d5033fbf,00000000,d5033f9f",
        };
        for (String s : fixed) {
            for (int flag = 0; flag <= 2; flag++) {
                runME(s, 0x7f0000001000L, flag, 64);
            }
        }

        Random rnd = new Random(20261102L);
        char[] alphabet = "0123456789abcdefABCDEF \t\n,-+xXzZ".toCharArray();
        for (int i = 0; i < 400; i++) {
            int len = rnd.nextInt(160);
            StringBuilder sb = new StringBuilder(len);
            for (int j = 0; j < len; j++) {
                sb.append(alphabet[rnd.nextInt(alphabet.length)]);
            }
            int flag = rnd.nextInt(4);
            long addr = rnd.nextLong() & 0x0000FFFFFFFFFFFFL;
            runME(sb.toString(), addr, flag, 16 + rnd.nextInt(80));
        }

        for (String s : fixed) {
            for (int flag = 0; flag <= 2; flag++) {
                runNaA(s, 0x7f0000001000L, flag);
            }
        }
        for (int i = 0; i < 200; i++) {
            int len = rnd.nextInt(96);
            StringBuilder sb = new StringBuilder(len);
            for (int j = 0; j < len; j++) {
                sb.append(alphabet[rnd.nextInt(alphabet.length)]);
            }
            runNaA(sb.toString(), rnd.nextLong() & 0x0000FFFFFFFFFFFFL, rnd.nextInt(4));
        }
        System.out.println("DONE");
    }
}
