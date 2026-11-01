package android.ext;

/* JADX INFO: loaded from: classes.dex */
class t1$a extends java.lang.NumberFormatException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.ArrayList f1258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private java.lang.String f1259b;

    public t1$a(java.lang.String str) {
        super(str);
        this.f1258a = null;
        this.f1259b = null;
    }

    void a(long j) {
        c(android.ext.Tools.L1(android.ext.b2.g("__d__"), java.lang.Long.valueOf(j)));
    }

    void b(java.lang.Object obj) {
        c(android.ext.Tools.L1(android.ext.b2.g("__d__"), obj));
    }

    void c(java.lang.String str) {
        java.util.ArrayList arrayList = this.f1258a;
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
            this.f1258a = arrayList;
        }
        arrayList.add(str);
    }

    void d() {
        java.lang.String message;
        boolean z;
        if (this.f1259b == null && (message = getMessage()) != null) {
            int iIndexOf = message.indexOf(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.locale_ui));
            if (iIndexOf > 0) {
                message = message.substring(0, iIndexOf);
                z = true;
            } else {
                z = false;
            }
            java.util.ArrayList<java.lang.String> arrayList = this.f1258a;
            if (arrayList != null) {
                java.util.Collections.sort(arrayList, new android.ext.t1$a$a(this));
                for (java.lang.String str : arrayList) {
                    if (str != null) {
                        java.lang.String strE3 = android.ext.Script.E3(str);
                        if (!str.equals(strE3) && message.indexOf(str) >= 0) {
                            message = message.replace(str, strE3);
                            z = true;
                        }
                    }
                }
            }
            if (iIndexOf > 0) {
                message = message + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.locale_script) + " (en_US):\n" + android.ext.Tools.L1(android.ext.t1.z(catch_.me_.if_.you_.can_.R.string.locale_desc), '.', ',');
            }
            if (z) {
                this.f1259b = message;
            }
        }
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        java.lang.String str = this.f1259b;
        return str != null ? str : super.getMessage();
    }
}
