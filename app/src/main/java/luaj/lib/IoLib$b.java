package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class IoLib$b implements luaj.lib.LibFunction$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ luaj.lib.IoLib f1770a;

    IoLib$b(luaj.lib.IoLib ioLib) {
        this.f1770a = ioLib;
    }

    @Override // luaj.lib.LibFunction$a
    public luaj.lib.LibFunction a() {
        return new luaj.lib.IoLib$IoLibV();
    }
}
