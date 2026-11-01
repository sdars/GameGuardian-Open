package android.ext;

/* JADX INFO: loaded from: classes.dex */
class x0$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.text.Editable f1308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1309b = 1;

    public x0$a(android.text.Editable editable) {
        this.f1308a = editable;
        while (this.f1309b < editable.length()) {
            char cCharAt = editable.charAt(this.f1309b);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return;
            } else {
                this.f1309b++;
            }
        }
    }

    void a(java.lang.String str) {
        if (this.f1309b <= this.f1308a.length()) {
            this.f1308a.insert(this.f1309b, str);
        }
        this.f1309b += str.length();
    }

    void b(int i, java.lang.String str) {
        int i2 = this.f1309b;
        c(i);
        if (this.f1309b <= this.f1308a.length()) {
            this.f1308a.replace(i2, this.f1309b, str);
        }
        this.f1309b += str.length() - (this.f1309b - i2);
    }

    void c(int i) {
        char cCharAt;
        int i2 = i * 2;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f1309b;
            while (true) {
                this.f1309b = i4 + 1;
                if (this.f1309b >= this.f1308a.length() || !((cCharAt = this.f1308a.charAt(this.f1309b)) == ' ' || cCharAt == '\t')) {
                    break;
                } else {
                    i4 = this.f1309b;
                }
            }
        }
    }
}
