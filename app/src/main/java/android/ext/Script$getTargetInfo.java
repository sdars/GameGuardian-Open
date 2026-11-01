package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getTargetInfo extends android.ext.Script$ApiFunction {
    Script$getTargetInfo() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
java.lang.Throwable e = null;
java.lang.Throwable th = null;
        luaj.LuaValue luaValue;
        android.content.pm.ActivityInfo[] activityInfoArr;
        luaj.LuaValue luaValue2 = luaj.LuaValue.f1673c;
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        if (z1_d != null) {
            java.lang.String str = z1_d.f1434c;
            try {
                android.content.pm.PackageInfo packageInfoA0 = android.ext.Tools.A0(str, 1);
                if (packageInfoA0 == null) {
                    return luaValue2;
                }
                luaj.LuaTable luaTable = new luaj.LuaTable();
                luaTable.b2("packageName", z1_d.f1434c);
                luaTable.b2("cmdLine", z1_d.f1432a);
                luaTable.b2("name", z1_d.f1433b);
                luaTable.b2("nativeLibraryDir", z1_d.f1435d);
                luaTable.a2("pid", z1_d.f1437f);
                luaTable.a2("uid", z1_d.f1438g);
                luaTable.c2("x64", z1_d.n ? luaj.LuaValue.f1674d : luaj.LuaValue.f1675e);
                luaTable.a2("RSS", z1_d.o);
                luaTable.Z1("firstInstallTime", packageInfoA0.firstInstallTime);
                luaTable.Z1("lastUpdateTime", packageInfoA0.lastUpdateTime);
                java.lang.String str2 = packageInfoA0.packageName;
                if (str2 != null) {
                    luaTable.b2("packageName", str2);
                }
                java.lang.String str3 = packageInfoA0.sharedUserId;
                if (str3 != null) {
                    luaTable.b2("sharedUserId", str3);
                }
                luaTable.a2("sharedUserLabel", packageInfoA0.sharedUserLabel);
                luaTable.a2("versionCode", packageInfoA0.versionCode);
                java.lang.String str4 = packageInfoA0.versionName;
                if (str4 != null) {
                    luaTable.b2("versionName", str4);
                }
                android.content.pm.PackageManager packageManagerB0 = android.ext.Tools.B0();
                if (packageInfoA0.activities == null || packageManagerB0 == null) {
                    luaValue = luaValue2;
                } else {
                    luaj.LuaTable luaTable2 = new luaj.LuaTable();
                    android.content.pm.ActivityInfo[] activityInfoArr2 = packageInfoA0.activities;
                    int length = activityInfoArr2.length;
                    int i = 0;
                    int i2 = 1;
                    while (i < length) {
                        android.content.pm.ActivityInfo activityInfo = activityInfoArr2[i];
                        if (activityInfo == null) {
                            luaValue = luaValue2;
                            activityInfoArr = activityInfoArr2;
                        } else {
                            luaValue = luaValue2;
                            try {
                                luaj.LuaTable luaTable3 = new luaj.LuaTable();
                                activityInfoArr = activityInfoArr2;
                                try {
                                    java.lang.String str5 = activityInfo.name;
                                    if (str5 != null) {
                                        luaTable3.h2("name", str5);
                                    }
                                    luaTable3.h2("label", activityInfo.loadLabel(packageManagerB0).toString());
                                    int i3 = i2 + 1;
                                    try {
                                        luaTable2.e2(i2, luaTable3);
                                        i2 = i3;
                                    } catch (java.lang.Throwable th_c) {
                                        th = th_c;
                                        i2 = i3;
                                        android.ext.e1.s("Failed get activity info", th_c);
                                    }
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                activityInfoArr = activityInfoArr2;
                            }
                        }try {

                        try {                            if (android.ext.GgNoop.never) {
                        throw new android.content.pm.PackageManager.NameNotFoundException();
                    }

                            i++;
                            luaValue2 = luaValue;
                            activityInfoArr2 = activityInfoArr;
                        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
                            e = e2;
                        };
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
                    }
                    luaValue = luaValue2;
                    luaTable.c2("activities", luaTable2);
                }
                if (packageManagerB0 != null) {
                    try {
                        luaTable.b2("installer", packageManagerB0.getInstallerPackageName(str));
                    } catch (java.lang.Throwable th4) {
                        android.ext.e1.s("Failed get installer", th4);
                    }
                    try {
                        luaTable.a2("enabledSetting", packageManagerB0.getApplicationEnabledSetting(str));
                    } catch (java.lang.Throwable th5) {
                        android.ext.e1.s("Failed get enabledSetting", th5);
                    }
                }
                android.content.pm.ApplicationInfo applicationInfo = packageInfoA0.applicationInfo;
                if (applicationInfo != null) {
                    java.lang.String str6 = applicationInfo.backupAgentName;
                    if (str6 != null) {
                        luaTable.b2("backupAgentName", str6);
                    }
                    java.lang.String str7 = applicationInfo.className;
                    if (str7 != null) {
                        luaTable.b2("className", str7);
                    }
                    java.lang.String str8 = applicationInfo.dataDir;
                    if (str8 != null) {
                        luaTable.b2("dataDir", str8);
                    }
                    luaTable.a2("descriptionRes", applicationInfo.descriptionRes);
                    luaTable.a2("flags", applicationInfo.flags);
                    luaTable.a2("icon", applicationInfo.icon);
                    luaTable.a2("labelRes", applicationInfo.labelRes);
                    luaTable.a2("logo", applicationInfo.logo);
                    java.lang.String str9 = applicationInfo.manageSpaceActivityName;
                    if (str9 != null) {
                        luaTable.b2("manageSpaceActivityName", str9);
                    }
                    java.lang.String str10 = applicationInfo.name;
                    if (str10 != null) {
                        luaTable.b2("name", str10);
                    }
                    java.lang.String str11 = applicationInfo.nativeLibraryDir;
                    if (str11 != null) {
                        luaTable.b2("nativeLibraryDir", str11);
                    }
                    java.lang.String str12 = applicationInfo.packageName;
                    if (str12 != null) {
                        luaTable.b2("packageName", str12);
                    }
                    java.lang.String str13 = applicationInfo.permission;
                    if (str13 != null) {
                        luaTable.b2("permission", str13);
                    }
                    java.lang.String str14 = applicationInfo.processName;
                    if (str14 != null) {
                        luaTable.b2("processName", str14);
                    }
                    java.lang.String str15 = applicationInfo.publicSourceDir;
                    if (str15 != null) {
                        luaTable.b2("publicSourceDir", str15);
                    }
                    java.lang.String str16 = applicationInfo.sourceDir;
                    if (str16 != null) {
                        luaTable.b2("sourceDir", str16);
                    }
                    luaTable.a2("targetSdkVersion", applicationInfo.targetSdkVersion);
                    java.lang.String str17 = applicationInfo.taskAffinity;
                    if (str17 != null) {
                        luaTable.b2("taskAffinity", str17);
                    }
                    luaTable.a2("theme", applicationInfo.theme);
                    luaTable.a2("uid", applicationInfo.uid);
                    java.lang.String strA0 = android.ext.Tools.a0(applicationInfo);
                    if (strA0 != null) {
                        luaTable.b2("label", strA0);
                    }
                }
                return luaTable;
            } catch (android.content.pm.PackageManager.NameNotFoundException e3) {
                e = e3;
                luaValue = luaValue2;
            }
            android.ext.e1.s("Pkg not found: " + str, e);
        } else {
            luaValue = luaValue2;
        }
        return luaValue;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getTargetInfo() -> table || nil";
    }
}
