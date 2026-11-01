package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$g implements java.lang.Runnable {
    f1$g() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
            java.lang.String string = sharedPreferencesM0.getString("improve-translate", "");
            java.lang.String str = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.version_number) + ':' + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.lang_code);
            if (str.equals(string)) {
                return;
            }
            if (android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.front_text).contains(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.improve_translation_en))) {
                android.ext.n2.i(new android.ext.f1$g$b(this, new android.ext.f1$g$a(this, sharedPreferencesM0, str)));
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("checkAutoTranslation", th);
        }
    }
}
