package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class IoLib$IoLibV extends luaj.lib.VarArgFunction {
    private luaj.lib.IoLib$File T;
    public luaj.lib.IoLib U;
    private boolean V;
    private luaj.Varargs W;

    public IoLib$IoLibV() {
    }

    public IoLib$IoLibV(luaj.lib.IoLib$File ioLib$File, java.lang.String str, int i, luaj.lib.IoLib ioLib) {
        this.T = ioLib$File;
        this.S = str;
        this.R = i;
        this.U = ioLib;
    }

    public IoLib$IoLibV(luaj.lib.IoLib$File ioLib$File, java.lang.String str, int i, luaj.lib.IoLib ioLib, boolean z, luaj.Varargs varargs) {
        this(ioLib$File, str, i, ioLib);
        this.V = z;
        this.W = varargs.M();
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        java.lang.StringBuilder sb;
        java.lang.String str;
        java.lang.String string = null;
        try {
            switch (this.R) {
                case 0:
                    return this.U.e3(varargs.w());
                case 1:
                    return this.U.f3();
                case 2:
                    return this.U.g3(varargs.w());
                case 3:
                    return this.U.h3(varargs);
                case 4:
                    return this.U.i3(varargs.E(1), varargs.Z(2, "r"));
                case 5:
                    return this.U.j3(varargs.w());
                case 6:
                    return this.U.k3(varargs.E(1), varargs.Z(2, "r"));
                case 7:
                    return this.U.l3(varargs);
                case 8:
                    return this.U.m3();
                case 9:
                    return this.U.n3(varargs.w());
                case 10:
                    return this.U.o3(varargs);
                case 11:
                    return this.U.X2(varargs.w());
                case 12:
                    return this.U.Y2(varargs.w());
                case 13:
                    return this.U.Z2(varargs);
                case 14:
                    return this.U.a3(varargs.w(), varargs.e0(2));
                case 15:
                    return this.U.b3(varargs.w(), varargs.Z(2, "cur"), varargs.Y(3, 0));
                case 16:
                    return this.U.c3(varargs.w(), varargs.E(2), varargs.Y(3, 8192));
                case 17:
                    return this.U.d3(varargs.w(), varargs.e0(2));
                case 18:
                    return this.U.p3(this.T, this.V, this.W);
                default:
                    return luaj.LuaValue.f1676f;
            }
        }  catch (luaj.c e3) {
            int i = this.R;
            java.lang.String[] strArr = luaj.lib.IoLib.d0;
            if (i >= strArr.length) {
                if (i >= strArr.length + luaj.lib.IoLib.e0.length) {
                    string = i == 18 ? "(io.lines iterator)" : e3.l;
                } else {
                    sb = new java.lang.StringBuilder();
                    sb.append("file:");
                    str = strArr[this.R - strArr.length];
                }
                luaj.c cVar = new luaj.c(e3.j, string, e3.k);
                cVar.initCause(e3);
                throw cVar;
            }
            sb = new java.lang.StringBuilder();
            sb.append("io.");
            str = strArr[this.R];
            sb.append(str);
            string = sb.toString();
            luaj.c cVar2 = new luaj.c(e3.j, string, e3.k);
            cVar2.initCause(e3);
            throw cVar2;
        }
    }
}
