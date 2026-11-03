import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Regression harness for android.ext.t1.h(CharSequence).
 *
 * The reference implementation (ref_h) is a direct transcription of the
 * original commercial smali: build/puresrc/original/android/ext/t1.smali,
 * method "h(Ljava/lang/CharSequence;)[B" (lines 1007-1336) plus its private
 * helper "a([BLjava/lang/String;)[B" (line 348).
 *
 * Every case must produce byte-identical output on both sides.
 */
public final class T1ParseTest {

    /* ---- reference: original smali, transcribed ---- */

    private static byte[] ref_a(byte[] acc, String str) {
        String s = str.replace(" ", "").replace("\t", "").replace("\r", "").replace("\n", "");
        if (s.length() < 2) {
            return acc;
        }
        int len = s.length() & ~1;
        byte[] out = Arrays.copyOf(acc, len / 2 + acc.length);
        int base = acc.length;
        for (int i = 0; i < len; i += 2) {
            out[base + i / 2] = (byte) Integer.parseInt(s.substring(i, i + 2), 16);
        }
        return out;
    }

    private static byte[] ref_h(String s) {
        byte[] acc = new byte[0];
        if (s.length() < 1) {
            return acc;
        }
        char c = s.charAt(0);
        if (c == ';') {
            return s.substring(1).getBytes(StandardCharsets.UTF_16LE);
        }
        if (c == 'H' || c == 'h') {
            return ref_a(acc, s.substring(1));
        }
        if (c == 'Q' || c == 'q') {
            int i = 1;
            char quote = 0;
            int seg = 1;
            while (i < s.length()) {
                char ch = s.charAt(i);
                String piece = null;
                boolean isQuote = (quote != 0) ? (ch == quote) : (ch == '\'' || ch == '"');
                if (isQuote) {
                    if (seg != i) {
                        piece = s.substring(seg, i);
                    }
                    if (quote != 0) {
                        ch = 0;
                    }
                    seg = i + 1;
                } else {
                    if (i == s.length() - 1) {
                        piece = s.substring(seg);
                    }
                    ch = quote;
                }
                if (piece != null && piece.length() > 0) {
                    if (quote != 0) {
                        Charset cs = (quote == '"') ? StandardCharsets.UTF_16LE : StandardCharsets.UTF_8;
                        byte[] bytes = piece.getBytes(cs);
                        byte[] out = Arrays.copyOf(acc, acc.length + bytes.length);
                        System.arraycopy(bytes, 0, out, acc.length, bytes.length);
                        acc = out;
                    } else {
                        acc = ref_a(acc, piece);
                    }
                }
                i++;
                quote = ch;
            }
            return acc;
        }
        return s.substring(1).getBytes(StandardCharsets.UTF_8);
    }

    /* ---- driver ---- */

    private static String hex(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (byte x : b) {
            sb.append(String.format("%02X", x));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] cases = {
                "",
                ":Trebuchet",
                ":hello world",
                ":中文",
                ";Trebuchet",
                ";hello",
                "Hdeadbeef",
                "hdeadbeef",
                "HDEADBEEF",
                "h00ff10",
                "Q'utf8'\"utf16\"",
                "Q\"abc\"'def'",
                "q'abc'\"def\"",
                "Q1234'text'",
                "Q'Trebuchet'\"Trebuchet\"",
                "Q",
                "q",
                ":",
                ";",
                "H",
                "777",
                "0x1F",
                "Trebuchet",
                "~A1",
        };
        int bad = 0;
        for (String c : cases) {
            byte[] got;
            byte[] want;
            try {
                got = android.ext.t1.h(c);
            } catch (Throwable t) {
                got = null;
                System.out.println("EXCEPTION  " + c + " -> " + t);
            }
            try {
                want = ref_h(c);
            } catch (Throwable t) {
                want = null;
            }
            boolean same = got != null && want != null && Arrays.equals(got, want);
            if (!same) {
                bad++;
            }
            System.out.println((same ? "OK   " : "FAIL ") + pad(c) + " got=" + (got == null ? "null" : hex(got))
                    + " want=" + (want == null ? "null" : hex(want)));
        }
        System.out.println(bad == 0 ? "ALL PASS (" + cases.length + " cases)" : "FAILURES: " + bad);
        if (bad != 0) {
            System.exit(1);
        }
    }

    private static String pad(String s) {
        StringBuilder sb = new StringBuilder("\"");
        sb.append(s).append('"');
        while (sb.length() < 28) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
