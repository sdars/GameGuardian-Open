package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class IoLib$a implements luaj.lib.LibFunction$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ luaj.lib.IoLib f1769a;

    IoLib$a(luaj.lib.IoLib ioLib) {
        this.f1769a = ioLib;
    }

    @Override // luaj.lib.LibFunction$a
    public luaj.lib.LibFunction a() {
        return new luaj.lib.IoLib$IoLibV();
    }
}
