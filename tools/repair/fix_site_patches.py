#!/usr/bin/env python3
"""The hand reconstructions of the places where jadx lost the control flow.

Every entry below was verified against the smali of the original dex - the
comment in front of each patch names the dex construct it restores.
"""
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from fix_misc import replace_guarded          # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

PATCHES = [
    # --- android/ext/AddressArrayAdapter.java ---------------------------
    # dex: "invoke-virtual {v}, Landroid/widget/LinearLayout;->setOrientation(I)V"
    #      the flag is a boolean, the setter wants an int.
    ('android/ext/AddressArrayAdapter.java',
     '        d3Var2.o.setOrientation(!z2);',
     '        d3Var2.o.setOrientation(z2 ? 0 : 1);'),

    # --- android/ext/SavedListAdapter.java ------------------------------
    ('android/ext/SavedListAdapter.java',
     '        savedListAdapter$b.o.setOrientation(!z);',
     '        savedListAdapter$b.o.setOrientation(z ? 0 : 1);'),

    # --- android/ext/EditorListener$b.java ------------------------------
    # dex: the handler catches NumberFormatException, so the exception has to
    #      be handed over as such - the shared register only holds Throwable.
    ('android/ext/EditorListener$b.java',
     '                                android.ext.j2.i(e, this.h.f());',
     '                                android.ext.j2.i(e2, this.h.f());'),

    # --- android/ext/b1.java --------------------------------------------
    # dex: "invoke-virtual {p0, p1}, Landroid/app/Activity;->startActivityForResult"
    #      "r" is the local AlertDialog, the Activity is android.ext.r.n.
    ('android/ext/b1.java',
     '                r.n.startActivityForResult(intent, i);',
     '                android.ext.r.n.startActivityForResult(intent, i);'),

    # --- android/ext/Script.java ----------------------------------------
    # dex: a static initialiser may not "return" - the jump leaves the loop.
    ('android/ext/Script.java',
     """            if (i >= iArr2.length) {
                w0 = null;
                return;
            } else {""",
     """            if (i >= iArr2.length) {
                w0 = null;
                break;
            } else {"""),
    # dex: "invoke-virtual {p3, p5}, Lluaj/LuaValue;->I1(Ljava/lang/String;)"
    #      both branches produce a String.
    ('android/ext/Script.java',
     """            if (z) {
                luaValue = luaValue2.I1(null);
            } else {
                strB0 = luaValue2.B0();
            }
            if (luaValue == 0) {
                luaValue = strB0;
                return 0L;
            }
            luaValue = strB0;
            java.lang.String strD3 = D3(luaValue);""",
     """            if (z) {
                strB0 = luaValue2.I1(null);
            } else {
                strB0 = luaValue2.B0();
            }
            if (strB0 == null) {
                return 0L;
            }
            java.lang.String strD3 = D3(strB0);"""),

    # --- android/ext/n0.java --------------------------------------------
    # dex: the StackOverflowError handler is ":goto_3 -> e1.a(v0)"; jadx
    #      emitted the handler body a second time inside the loop.
    ('android/ext/n0.java',
     """                        sb.append(line);
                        sb.append('\\n');
                        android.ext.e1.a(e);
                    }""",
     """                        sb.append(line);
                        sb.append('\\n');
                    }"""),

    # --- android/ext/z.java ---------------------------------------------
    # dex: ":goto_6 -> e1.a(p0)" is the catchall handler, jadx also inlined it
    #      at the end of the try block.
    ('android/ext/z.java',
     """                android.ext.e1.a(th);
            }
        } catch (java.lang.Throwable th3) {""",
     """            }
        } catch (java.lang.Throwable th3) {"""),

    # --- android/ext/e2.java --------------------------------------------
    # dex: the exception register survives the handler, so it has to be a
    #      local of the method.
    ('android/ext/e2.java',
     """    public static java.lang.Process r(java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.String str3;""",
     """    public static java.lang.Process r(java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.Throwable th = null;
        java.lang.String str3;"""),
    ('android/ext/e2.java',
     """                } catch (java.lang.Throwable th) {
                    for (th = th; th != null; th = th.getCause()) {""",
     """                } catch (java.lang.Throwable th_c) {
                    th = th_c;
                    for (th = th; th != null; th = th.getCause()) {"""),

    # --- android/ext/c.java ---------------------------------------------
    # dex: the value is narrowed depending on the tag and the result is
    #      compared with the original one afterwards.
    ('android/ext/c.java',
     """    public static long h(long j2, int i2) {
        int i3;
        long j3;
        int i4 = i2 & 127;
        if (i4 == 1) {
            i3 = (byte) j2;
        } else {
            if (i4 != 2) {
                if (i4 == 4 || i4 == 8) {
                    i3 = (int) j2;
                } else {
                    j3 = j2;
                }
                if (j2 != j3) {
                    android.ext.e1.d("fixValue[" + i2 + ", " + java.lang.Integer.toHexString(i2) + "]: " + j2 + '[' + java.lang.Long.toHexString(j2) + "] -> " + j3 + '[' + java.lang.Long.toHexString(j3) + ']');
                }
                return j3;
            }
            i3 = (short) j2;
        }
        j3 = i3;
        if (j2 != j3) {""",
     """    public static long h(long j2, int i2) {
        long j3;
        int i4 = i2 & 127;
        if (i4 == 1) {
            j3 = (byte) j2;
        } else if (i4 == 2) {
            j3 = (short) j2;
        } else if (i4 == 4 || i4 == 8) {
            j3 = (int) j2;
        } else {
            j3 = j2;
        }
        if (j2 != j3) {"""),

    # --- android/ext/Script$makeRequest.java ----------------------------
    # dex: the stream is initialised in its declaration, jadx kept a second
    #      assignment that runs before the declaration.
    ('android/ext/Script$makeRequest.java',
     """        java.net.HttpURLConnection httpURLConnection = null;
        errorStream = null;
        java.io.InputStream errorStream = null;""",
     """        java.net.HttpURLConnection httpURLConnection = null;
        java.io.InputStream errorStream = null;"""),

    # --- android/ext/ConfigListAdapter.java ----------------------------
    # dex: ":cond_5 -> return v1" is reached from the handler as well, the
    #      flag keeps the value it had before the failure.
    ('android/ext/ConfigListAdapter.java',
     """        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    static void m() {""",
     """        } catch (java.lang.Throwable th2) {
            th = th2;
            return z;
        }
    }

    static void m() {"""),

    # --- android/ext/f0.java --------------------------------------------
    # dex: the copy loop is the same as the one in the branch above.
    ('android/ext/f0.java',
     """            while (i4 < length) {
                bArr[i4] = (byte) jArr[i4];
            }""",
     """            for (int i4 = 0; i4 < length; i4++) {
                bArr[i4] = (byte) jArr[i4];
            }"""),

    # --- android/ext/n$g.java -------------------------------------------
    # dex: the loop limit register is 8, jadx lost its declaration.
    ('android/ext/n$g.java',
     """        int i3;
        short s = (short) i;""",
     """        int i3;
        int i16 = 8;
        short s = (short) i;"""),
    # the loop of the "case 'M'" branch keeps its own counter
    ('android/ext/n$g.java',
     """                for (int i16 = 8; i3 < i16; i16 = 8) {""",
     """                for (int i16Loop = 8; i3 < i16Loop; i16Loop = 8) {"""),

    # --- android/ext/x2.java --------------------------------------------
    # dex: ":goto_6" is the single handler of the read loop, jadx emitted it
    #      twice - once in the catch and once after the try.
    ('android/ext/x2.java',
     """                                                            e = e2;
                                                            android.ext.e1.s("Failed read data from " + file3, e);
                                                        }
                                                        fileOutputStream.close();""",
     """                                                        }
                                                        fileOutputStream.close();"""),
    # dex: ":cond_d" loads the constant "Un: drain owns recovery".
    ('android/ext/x2.java',
     """        if (android.ext.s1.n()) {
            android.ext.e1.d(str);
            return;
        }""",
     """        if (android.ext.s1.n()) {
            android.ext.e1.d("Un: drain owns recovery");
            return;
        }"""),

    # --- android/ext/MainService.java -----------------------------------
    # dex: the register of the second copy of the initialisation code.
    ('android/ext/MainService.java',
     """                activityManager = (android.app.ActivityManager) b("activity");
            } catch (java.lang.Throwable th2) {""",
     """                android.app.ActivityManager activityManager = (android.app.ActivityManager) b("activity");
            } catch (java.lang.Throwable th2) {"""),

    # --- android/ext/j.java ---------------------------------------------
    # dex: ":cond_3" sets the flag to false and continues at ":goto_1", the
    #      iterator is only entered when the process is known.
    ('android/ext/j.java',
     """                    if (this.f1019a == null) {
                        z = false;
                        break;
                    }
                    java.util.Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        } else if (((android.ext.z1$d) it.next()).f1437f == this.f1019a.f1437f) {
                            z = true;
                            break;
                        }
                    }""",
     """                    if (this.f1019a != null) {
                        java.util.Iterator it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            } else if (((android.ext.z1$d) it.next()).f1437f == this.f1019a.f1437f) {
                                z = true;
                                break;
                            }
                        }
                    } else {
                        z = false;
                    }"""),

    # --- android/ext/z1.java --------------------------------------------
    # dex: ":cond_7" assigns the package name and continues at ":goto_4",
    #      the process list is only scanned when there is one.
    ('android/ext/z1.java',
     """            if (list == null) {
                str2 = str;
                break;
            }
            java.util.Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = str;
                    break;
                }
                android.app.ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo = (android.app.ActivityManager.RunningAppProcessInfo) it.next();
                if (activityManager$RunningAppProcessInfo != null && activityManager$RunningAppProcessInfo.pid == i2 && (strArr = activityManager$RunningAppProcessInfo.pkgList) != null && strArr.length > 0) {
                    str2 = strArr[0];
                    z = true;
                    break;
                }
            }""",
     """            if (list != null) {
                java.util.Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str2 = str;
                        break;
                    }
                    android.app.ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo = (android.app.ActivityManager.RunningAppProcessInfo) it.next();
                    if (activityManager$RunningAppProcessInfo != null && activityManager$RunningAppProcessInfo.pid == i2 && (strArr = activityManager$RunningAppProcessInfo.pkgList) != null && strArr.length > 0) {
                        str2 = strArr[0];
                        z = true;
                        break;
                    }
                }
            } else {
                str2 = str;
            }"""),

    # --- android/ext/w.java ---------------------------------------------
    # dex: ":cond_2 / :goto_1" - the comparison loop is only entered when the
    #      candidate string has the expected length.
    ('android/ext/w.java',
     """        if (str == null || str.length() != i) {
            str = null;
            break;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (str.charAt(i2) != bArr[iPosition + i2]) {
                str = null;
                break;
            }
        }""",
     """        if (str == null || str.length() != i) {
            str = null;
        } else {
            for (int i2 = 0; i2 < i; i2++) {
                if (str.charAt(i2) != bArr[iPosition + i2]) {
                    str = null;
                    break;
                }
            }
        }"""),

    # --- gg_a/d.java ----------------------------------------------------
    # dex: the method returns the inflated View, "Inflate" is the resource id.
    ('gg_a/d.java',
     """                            Inflate = xmlPullParser == null ? layoutInflaterCloneInContext.inflate((int) Inflate, viewGroup, z) : layoutInflaterCloneInContext.inflate(xmlPullParser, viewGroup, z);
                            return Inflate;""",
     """                            return xmlPullParser == null ? layoutInflaterCloneInContext.inflate(Inflate, viewGroup, z) : layoutInflaterCloneInContext.inflate(xmlPullParser, viewGroup, z);"""),

    # --- gg_a/g.java ----------------------------------------------------
    # dex: an abstract View subclass without a constructor.
    ('gg_a/g.java',
     """public abstract class g extends android.view.View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */""",
     """public abstract class g extends android.view.View {

    protected g(android.content.Context context) {
        super(context);
    }

    /* JADX INFO: renamed from: a, reason: collision with root package name */"""),

    # --- gg_g/c.java ----------------------------------------------------
    # dex: one register, jadx declared it twice.
    ('gg_g/c.java',
     """        if (i2 != 11) {
            z = true;
            boolean z = true;""",
     """        if (i2 != 11) {
            boolean z = true;"""),

    # --- luaj/Globals.java ----------------------------------------------
    # dex: "invoke-virtual {v}, Ljava/io/PushbackInputStream;->unread([BII)V"
    ('luaj/Globals.java',
     '                inputStream.unread(bArr, 0, i);',
     '                ((java.io.PushbackInputStream) inputStream).unread(bArr, 0, i);'),

    # --- luaj/lib/StringLib$unpack.java --------------------------------
    # dex: ":pswitch_2" reads a double, ":pswitch_1" reads a long/double pair.
    ('luaj/lib/StringLib$unpack.java',
     """                case 9:
                    jE3 = luaj.lib.StringLib.e3(stringLib$c, luaStringH, i4, false);
                    arrayList.add(luaValueI2);
                    break;""",
     """                case 9:
                    jE3 = luaj.lib.StringLib.e3(stringLib$c, luaStringH, i4, false);
                    arrayList.add(luaj.LuaDouble.J2(java.lang.Double.longBitsToDouble(jE3)));
                    break;"""),
    ('luaj/lib/StringLib$unpack.java',
     """                    luaj.LuaValue luaValueI2 = luaj.lib.StringLib.e3(stringLib$c, luaStringH, i4 + 8, false) == 1 ? luaj.LuaLong.I2(jE3) : luaj.LuaDouble.J2(java.lang.Double.longBitsToDouble(jE3));""",
     """                    long jUnpackFlag = luaj.lib.StringLib.e3(stringLib$c, luaStringH, i4 + 8, false);
                    luaj.LuaValue luaValueI2 = jUnpackFlag == 1 ? luaj.LuaLong.I2(jE3) : luaj.LuaDouble.J2(java.lang.Double.longBitsToDouble(jE3));"""),
]


def main():
    n = 0
    for rel, old, new in PATCHES:
        path = os.path.join(SRC, rel)
        if not os.path.exists(path):
            print('MISSING', rel)
            continue
        text = open(path, encoding='utf-8').read()
        text, hits = replace_guarded(text, old, new)
        if not hits:
            print('NOT FOUND in %s: %r' % (rel, old.splitlines()[0][:70]))
            continue
        open(path, 'w', encoding='utf-8').write(text)
        n += 1
    print('site patches applied:', n)


if __name__ == '__main__':
    main()
