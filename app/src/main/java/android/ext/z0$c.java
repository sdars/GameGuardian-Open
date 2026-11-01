package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z0$c implements android.content.DialogInterface.OnClickListener {
    z0$c() {
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003 A[PHI: r0
      0x0003: PHI (r0v2 byte) = (r0v0 byte), (r0v1 byte) binds: [B:3:0x0001, B:6:0x0007] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        byte b2 = 1;
        if (i == 1) {
            android.ext.b1.y = b2;
        } else {
            b2 = 2;
            if (i == 2) {
                android.ext.b1.y = b2;
            }
        }
        if (dialogInterface instanceof android.app.AlertDialog) {
            ((android.app.AlertDialog) dialogInterface).dismiss();
        }
    }
}
