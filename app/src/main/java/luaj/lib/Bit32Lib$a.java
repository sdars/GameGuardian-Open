package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class Bit32Lib$a implements luaj.lib.LibFunction$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ luaj.lib.Bit32Lib f1747a;

    Bit32Lib$a(luaj.lib.Bit32Lib bit32Lib) {
        this.f1747a = bit32Lib;
    }

    @Override // luaj.lib.LibFunction$a
    public luaj.lib.LibFunction a() {
        return new luaj.lib.Bit32Lib$Bit32LibV();
    }
}
