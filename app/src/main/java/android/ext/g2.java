package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class g2 implements android.content.SharedPreferences.Editor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final android.content.SharedPreferences.Editor f988a;

    public g2() {
        this.f988a = android.ext.Tools.M0().edit();
    }

    public g2(android.content.SharedPreferences.Editor sharedPreferences$Editor) {
        this.f988a = sharedPreferences$Editor;
    }

    @Override // android.content.SharedPreferences$Editor
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public android.ext.g2 clear() {
        this.f988a.clear();
        return this;
    }

    @Override // android.content.SharedPreferences$Editor
    public void apply() {
        this.f988a.apply();
    }

    @Override // android.content.SharedPreferences$Editor
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public android.ext.g2 putBoolean(java.lang.String str, boolean z) {
        this.f988a.putBoolean(str, z);
        return this;
    }

    public android.ext.g2 c(java.lang.String str, boolean z, boolean z2) {
        if (z == z2) {
            this.f988a.remove(str);
        } else {
            this.f988a.putBoolean(str, z);
        }
        return this;
    }

    @Override // android.content.SharedPreferences$Editor
    public boolean commit() {
        return this.f988a.commit();
    }

    @Override // android.content.SharedPreferences$Editor
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public android.ext.g2 putFloat(java.lang.String str, float f2) {
        this.f988a.putFloat(str, f2);
        return this;
    }

    public android.ext.g2 e(java.lang.String str, float f2, float f3) {
        if (f2 == f3) {
            this.f988a.remove(str);
        } else {
            this.f988a.putFloat(str, f2);
        }
        return this;
    }

    @Override // android.content.SharedPreferences$Editor
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public android.ext.g2 putInt(java.lang.String str, int i) {
        this.f988a.putInt(str, i);
        return this;
    }

    public android.ext.g2 g(java.lang.String str, int i, int i2) {
        if (i == i2) {
            this.f988a.remove(str);
        } else {
            this.f988a.putInt(str, i);
        }
        return this;
    }

    @Override // android.content.SharedPreferences$Editor
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public android.ext.g2 putLong(java.lang.String str, long j) {
        this.f988a.putLong(str, j);
        return this;
    }

    public android.ext.g2 i(java.lang.String str, long j, long j2) {
        if (j == j2) {
            this.f988a.remove(str);
        } else {
            this.f988a.putLong(str, j);
        }
        return this;
    }

    @Override // android.content.SharedPreferences$Editor
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public android.ext.g2 putString(java.lang.String str, java.lang.String str2) {
        this.f988a.putString(str, str2);
        return this;
    }

    public android.ext.g2 k(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str2.equals(str3)) {
            this.f988a.remove(str);
        } else {
            this.f988a.putString(str, str2);
        }
        return this;
    }

    @Override // android.content.SharedPreferences$Editor
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public android.ext.g2 putStringSet(java.lang.String str, java.util.Set set) {
        this.f988a.putStringSet(str, set);
        return this;
    }

    @Override // android.content.SharedPreferences$Editor
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public android.ext.g2 remove(java.lang.String str) {
        this.f988a.remove(str);
        return this;
    }
}
