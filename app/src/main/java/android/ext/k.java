package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f1041a = "locale";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile java.lang.String f1042b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static java.lang.String f1043c = "crashed-vm";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static java.lang.String f1044d = "crashed-vm2";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile java.util.Locale f1045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static java.util.List f1046f = new java.util.ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final java.util.regex.Pattern f1047g;

    static {
        java.util.regex.Pattern patternCompile;
        try {
            patternCompile = java.util.regex.Pattern.compile("~~~([-_A-Za-z0-9]{1,10})~~~");
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            patternCompile = null;
        }
        f1047g = patternCompile;
    }

    public static void a(java.lang.String str) {
        java.util.Locale localeD = d(str);
        java.util.Locale.setDefault(localeD);
        gg_a.b.g(null, localeD);
        k(android.ext.r.p);
        k(android.ext.r.o);
        k(android.ext.MainService.context);
        android.ext.e1.d("Loaded locale: " + str);
        l();
        if (str.equals(f1042b)) {
            return;
        }
        f1042b = str;
        android.ext.b2.a();
    }

    public static java.lang.String b() {
        try {
            return android.ext.Tools.M0().getString(f1041a, java.util.Locale.getDefault().toString());
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed get locale", th);
            return "";
        }
    }

    public static java.util.Locale c() {
        return d(b());
    }

    public static java.util.Locale d(java.lang.String str) {
        java.lang.String[] strArrSplit = str.split("[-_]");
        return strArrSplit.length > 1 ? new java.util.Locale(strArrSplit[0], strArrSplit[1]) : new java.util.Locale(str);
    }

    public static java.lang.String[] e() {
        java.util.Locale[] availableLocales;
        java.lang.String[] locales = gg_d.b.f1511a;
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        if (!sharedPreferencesM0.getBoolean(f1043c, false)) {
            sharedPreferencesM0.edit().putBoolean(f1043c, true).commit();
            locales = android.ext.Tools.f0().getAssets().getLocales();
            sharedPreferencesM0.edit().remove(f1043c).commit();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String strSubstring = "";
        arrayList.add("");
        for (java.lang.String str : locales) {
            if (str != null && !arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        if (sharedPreferencesM0.getBoolean(f1044d, false)) {
            availableLocales = null;
        } else {
            sharedPreferencesM0.edit().putBoolean(f1044d, true).commit();
            availableLocales = java.util.Locale.getAvailableLocales();
            sharedPreferencesM0.edit().remove(f1044d).commit();
        }
        if (availableLocales != null) {
            for (java.util.Locale locale : availableLocales) {
                if (locale != null) {
                    java.lang.String country = locale.getCountry();
                    java.lang.String language = locale.getLanguage();
                    java.lang.String str2 = (country == null || country.length() == 0) ? language : language + '_' + country;
                    if (country != null && country.length() != 0) {
                        language = language + '-' + country;
                    }
                    if (!arrayList.contains(str2) && !arrayList.contains(language)) {
                        arrayList.add(language);
                    }
                }
            }
        }
        if (f1047g != null) {
            try {
                java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(android.ext.Tools.f0().getPackageResourcePath());
                java.io.InputStream inputStream = zipFile.getInputStream(zipFile.getEntry("resources.arsc"));
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    java.lang.String str3 = new java.lang.String(bArr, 0, i, java.nio.charset.Charset.forName("US-ASCII"));
                    if (str3.indexOf(126) != -1) {
                        java.util.regex.Matcher matcher = f1047g.matcher(strSubstring + str3);
                        while (matcher.find()) {
                            java.lang.String strGroup = matcher.group(1);
                            java.lang.String strReplace = strGroup.replace('_', '-');
                            if (!arrayList.contains(strGroup) && !arrayList.contains(strReplace)) {
                                arrayList.add(strReplace);
                            }
                        }
                    }
                    strSubstring = str3.substring(0, java.lang.Math.min(40, str3.length()));
                }
                inputStream.close();
                zipFile.close();
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("Failed load locales from apk", th);
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public static java.util.Locale f() {
        java.util.Locale locale = f1045e;
        if (locale != null) {
            return locale;
        }
        java.util.Locale localeC = c();
        f1045e = localeC;
        return localeC;
    }

    public static void g() {
        try {
            a(b());
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed load locale", th);
        }
    }

    public static void h(java.lang.Class cls) {
        f1046f.add(cls);
    }

    public static void i(java.lang.String str) {
        new android.ext.g2().putString(f1041a, str).commit();
        a(str);
    }

    public static void j(java.util.Locale locale) {
        f1045e = locale;
    }

    private static void k(android.content.Context context) {
        if (context == null) {
            return;
        }
        context.getResources();
    }

    private static void l() {
        for (java.lang.Class cls : (java.util.Collection<java.lang.Class>) f1046f) {
            try {
                cls.getMethod("updateLocale", null).invoke(null, null);
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed call updateLocale for " + cls.getName(), th);
            }
        }
    }
}
