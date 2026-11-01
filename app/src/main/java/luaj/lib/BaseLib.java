package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class BaseLib extends luaj.lib.TwoArgFunction implements luaj.lib.f {
    luaj.Globals T;
    luaj.lib.BaseLib$c U = null;
    byte[] V = null;

    static luaj.LuaString d3(luaj.LuaValue luaValue) {
        luaj.LuaValue luaValueX1 = luaValue.x1(luaj.LuaValue.B);
        if (luaValueX1.l1()) {
            luaj.LuaValue luaValueB2 = luaValue.B2();
            return !luaValueB2.l1() ? luaValueB2.G0() : luaj.LuaValue.K2(luaValue.g0());
        }
        luaj.LuaValue luaValueCall = luaValueX1.call(luaValue);
        luaj.LuaValue luaValueB3 = luaValueCall.B2();
        if (!luaValueB3.l1()) {
            return luaValueB3.G0();
        }
        throw new luaj.d("'__tostring' must return a string, got '" + luaValueCall.D2() + "' ('" + luaValueCall + "')");
    }

    java.io.InputStream Y2(luaj.LuaString luaString, java.lang.String str, boolean z, java.io.InputStream inputStream) {
        luaj.lib.BaseLib$c baseLib$c = this.U;
        if (baseLib$c != null) {
            if (z) {
                if (str != null) {
                    try {
                        byte[] bArr = this.V;
                        if (bArr == null) {
                            bArr = new byte[8192];
                            this.V = bArr;
                        }
                        java.io.FileDescriptor fileDescriptorOpen = android.system.Os.open(str, android.system.OsConstants.O_RDONLY, 438);
                        int i = 0;
                        while (true) {
                            int i2 = android.system.Os.read(fileDescriptorOpen, bArr, 0, bArr.length);
                            if (i2 <= 0) {
                                break;
                            }
                            baseLib$c.f1739b.write(bArr, 0, i2);
                            i += i2;
                        }
                        android.system.Os.close(fileDescriptorOpen);
                        if (i > 0) {
                            baseLib$c.f1741d.writeInt(i);
                        }
                    } catch (java.lang.Throwable th) {
                        android.ext.e1.g("Failed write log file from " + str, th);
                    }
                }
            } else {
                if (luaString == null) {
                    return new luaj.lib.BaseLib$a(this, inputStream, baseLib$c);
                }
                try {
                    int i3 = luaString.R;
                    if (i3 > 0) {
                        baseLib$c.f1739b.write(luaString.P, luaString.Q, i3);
                        baseLib$c.f1741d.writeInt(i3);
                    }
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.s("Failed write log file", th2);
                }
            }
        }
        return inputStream;
    }

    public void Z2() {
        luaj.lib.BaseLib$c baseLib$c = this.U;
        if (baseLib$c != null) {
            baseLib$c.a();
        }
    }

    public luaj.Varargs a3(java.lang.String str, java.lang.String str2, luaj.LuaValue luaValue) {
        java.io.InputStream inputStreamU = this.T.e0.u(str);
        if (inputStreamU == null) {
            return luaj.LuaValue.N2(luaj.LuaValue.f1673c, luaj.LuaValue.K2("cannot open " + str + ": No such file or directory"));
        }
        try {
            java.lang.String absolutePath = this.T.R3(str).getAbsolutePath();
            luaj.Varargs varargsB3 = b3(inputStreamU, '@' + absolutePath, str2, luaValue);
            if (varargsB3 instanceof luaj.LuaClosure) {
                ((luaj.LuaClosure) varargsB3).U = absolutePath;
            }
            if (this.U != null && (varargsB3 instanceof luaj.LuaFunction)) {
                Y2(null, str, true, null);
            }
            try {
                inputStreamU.close();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            return varargsB3;
        } catch (java.lang.Throwable th) {
            try {
                java.lang.String message = th.getMessage();
                if (message == null) {
                    message = th.getClass().getName();
                }
                luaj.Varargs varargsN2 = luaj.LuaValue.N2(luaj.LuaValue.f1673c, luaj.LuaValue.K2(message));
                try {
                    inputStreamU.close();
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                }
                return varargsN2;
            } catch (java.lang.Throwable th2) {
                try {
                    inputStreamU.close();
                } catch (java.lang.Exception e4) {
                    e4.printStackTrace();
                }
                throw th2;
            }
        }
    }

    public luaj.Varargs b3(java.io.InputStream inputStream, java.lang.String str, java.lang.String str2, luaj.LuaValue luaValue) {
        try {
            if (inputStream != null) {
                return this.T.O3(inputStream, str, str2, luaValue);
            }
            return luaj.LuaValue.N2(luaj.LuaValue.f1673c, luaj.LuaValue.K2("not found: " + str));
        } catch (java.lang.Exception e2) {
            return luaj.LuaValue.N2(luaj.LuaValue.f1673c, luaj.LuaValue.K2(e2.getMessage()));
        }
    }

    public void c3(java.lang.String str) {
        try {
            this.U = new luaj.lib.BaseLib$c(this, str);
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("Failed prepare log loads for " + str, th);
        }
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.Globals globalsZ0 = luaValue2.z0();
        this.T = globalsZ0;
        globalsZ0.e0 = this;
        globalsZ0.g0 = this;
        if (globalsZ0.X) {
            luaValue2.i2("_G", luaValue2);
            luaValue2.h2("_VERSION", "Lua 5.3 (with Luaj 3.0.1)");
            luaValue2.i2("assert", new luaj.lib.BaseLib$_assert());
            luaValue2.i2("assert2", new luaj.lib.BaseLib$assert2());
            luaValue2.i2("collectgarbage", new luaj.lib.BaseLib$collectgarbage());
            luaValue2.i2("dofile", new luaj.lib.BaseLib$dofile(this));
            luaValue2.i2("error", new luaj.lib.BaseLib$error());
            luaValue2.i2("getmetatable", new luaj.lib.BaseLib$getmetatable());
            luaValue2.i2("load", new luaj.lib.BaseLib$load(this));
            luaValue2.i2("loadfile", new luaj.lib.BaseLib$loadfile(this));
            luaValue2.i2("pcall", new luaj.lib.BaseLib$pcall(this));
            luaValue2.i2("print", new luaj.lib.BaseLib$print(this, this));
        }
        luaValue2.i2("rawequal", new luaj.lib.BaseLib$rawequal());
        luaValue2.i2("rawget", new luaj.lib.BaseLib$rawget());
        luaValue2.i2("rawlen", new luaj.lib.BaseLib$rawlen());
        luaValue2.i2("rawset", new luaj.lib.BaseLib$rawset());
        luaValue2.i2("select", new luaj.lib.BaseLib$select());
        if (globalsZ0.X) {
            luaValue2.i2("setmetatable", new luaj.lib.BaseLib$setmetatable());
        }
        luaValue2.i2("tonumber", new luaj.lib.BaseLib$tonumber());
        luaValue2.i2("tostring", new luaj.lib.BaseLib$tostring());
        luaValue2.i2("type", new luaj.lib.BaseLib$type());
        if (globalsZ0.X) {
            luaValue2.i2("xpcall", new luaj.lib.BaseLib$xpcall(this));
        }
        luaj.lib.BaseLib$next baseLib$next = new luaj.lib.BaseLib$next();
        luaValue2.i2("next", baseLib$next);
        luaValue2.i2("pairs", new luaj.lib.BaseLib$pairs(baseLib$next));
        luaValue2.i2("ipairs", new luaj.lib.BaseLib$ipairs());
        return luaValue2;
    }

    @Override // luaj.lib.f
    public java.io.InputStream u(java.lang.String str) {
        java.io.File fileR3 = this.T.R3(str);
        luaj.lib.e eVar = this.T.Z;
        if (eVar == null) {
            try {
                return new luaj.lib.BaseLib$b(new java.io.FileInputStream(fileR3));
            } catch (java.io.IOException unused) {
                return null;
            }
        }
        try {            if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

            java.io.FileInputStream fileInputStreamE = luaj.lib.d.e(fileR3, eVar);
            if (fileInputStreamE == null) {
                return null;
            }
            return new luaj.lib.BaseLib$b(fileInputStreamE);
        } catch (java.io.IOException unused2) {
            return null;
        }
    }
}
