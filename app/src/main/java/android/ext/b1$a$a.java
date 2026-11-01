package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$a$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.b1$a f603a;

    b1$a$a(android.ext.b1$a b1_a) {
        this.f603a = b1_a;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i != -2) {
            int i2 = -1;
            if (i == -1) {
                int length = this.f603a.f599a == 1 ? android.ext.b1.L % this.f603a.f600b.length : 0;
                for (android.content.Intent intent : this.f603a.f600b) {
                    i2++;
                    if (i2 >= length) {
                        try {
                            if (this.f603a.f599a == 1) {
                                android.ext.b1.L++;
                            }
                            r.n.startActivityForResult(intent, this.f603a.f599a);
                            break;
                        } catch (java.lang.Throwable th) {
                            android.ext.e1.l("intent fail", th);
                        }
                    }
                }
            }
        } else {
            android.ext.b1.C.j &= ~this.f603a.f599a;
        }
        android.ext.b1.B.r = null;
    }
}
