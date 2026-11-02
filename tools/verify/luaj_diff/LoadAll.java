import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LoadAll {
    public static void main(String[] argv) throws Exception {
        ZipFile z = new ZipFile(new File(argv[0]));
        List<String> names = new ArrayList<>();
        Enumeration<? extends ZipEntry> e = z.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze = e.nextElement();
            if (ze.getName().endsWith(".class")) {
                names.add(ze.getName().substring(0, ze.getName().length() - 6).replace('/', '.'));
            }
        }
        int ok = 0, bad = 0;
        for (String n : names) {
            try {
                Class.forName(n, false, LoadAll.class.getClassLoader());
                ok++;
            } catch (Throwable t) {
                bad++;
                System.out.println("FAIL " + n + " -> " + t);
            }
        }
        System.out.println("loaded=" + ok + " failed=" + bad);
    }
}
