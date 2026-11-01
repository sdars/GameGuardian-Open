package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class Bit32Lib$b implements luaj.lib.LibFunction$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ luaj.lib.Bit32Lib f1748a;

    Bit32Lib$b(luaj.lib.Bit32Lib bit32Lib) {
        this.f1748a = bit32Lib;
    }

    @Override // luaj.lib.LibFunction$a
    public luaj.lib.LibFunction a() {
        return new luaj.lib.Bit32Lib$Bit32Lib2();
    }
}
