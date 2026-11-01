package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class f2 implements android.content.SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final android.content.SharedPreferences f978a;

    private f2(android.content.SharedPreferences sharedPreferences) {
        this.f978a = sharedPreferences;
    }

    public static android.content.SharedPreferences a(android.content.SharedPreferences sharedPreferences) {
        return !(sharedPreferences instanceof android.ext.f2) ? new android.ext.f2(sharedPreferences) : sharedPreferences;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(java.lang.String str) {
        try {
            return this.f978a.contains(str);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    @Override // android.content.SharedPreferences
    public android.content.SharedPreferences.Editor edit() {
        return this.f978a.edit();
    }

    @Override // android.content.SharedPreferences
    public java.util.Map getAll() {
        return this.f978a.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(java.lang.String str, boolean z) {
        try {
            return this.f978a.getBoolean(str, z);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return z;
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(java.lang.String str, float f2) {
        try {
            return this.f978a.getFloat(str, f2);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return f2;
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(java.lang.String str, int i) {
        try {
            return this.f978a.getInt(str, i);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return i;
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(java.lang.String str, long j) {
        try {
            return this.f978a.getLong(str, j);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return j;
        }
    }

    @Override // android.content.SharedPreferences
    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        try {
            return this.f978a.getString(str, str2);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return str2;
        }
    }

    @Override // android.content.SharedPreferences
    public java.util.Set getStringSet(java.lang.String str, java.util.Set set) {
        try {
            return this.f978a.getStringSet(str, set);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return set;
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener) {
        try {
            this.f978a.registerOnSharedPreferenceChangeListener(sharedPreferences$OnSharedPreferenceChangeListener);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener) {
        try {
            this.f978a.unregisterOnSharedPreferenceChangeListener(sharedPreferences$OnSharedPreferenceChangeListener);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }
}
