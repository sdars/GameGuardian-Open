package android.ext;

/* JADX INFO: loaded from: classes.dex */
public final class Script$OsExit extends luaj.d {
    final int j;

    public Script$OsExit(int i) {
        super("called os.exit(" + i + ')');
        this.j = i;
    }
}
