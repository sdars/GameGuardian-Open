package android.ext;

/* JADX INFO: loaded from: classes.dex */
class r$e implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.r f1216a;

    r$e(android.ext.r rVar) {
        this.f1216a = rVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:27:0x0065 A[PHI: r4
      0x0065: PHI (r4v6 android.ext.Config$p) = (r4v2 android.ext.Config$p), (r4v8 android.ext.Config$p) binds: [B:33:0x0093, B:26:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Config$p config$pB;
        int i2 = 1;
        switch (i) {
            case 0:
                android.ext.r0.d(android.ext.m2.f1074a);
                android.ext.r.I();
                break;
            case 1:
                config$pB = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.selinux);
                if ((android.ext.Config.A & 4) != 0) {
                    i2 = 0;
                }
                config$pB.f42d = i2;
                android.ext.Config.k();
                android.ext.r.I();
                break;
            case 2:
                new android.ext.z(this.f1216a).J();
                break;
            case 3:
                android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_float_type).f42d = -1;
                android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_float_flags).f42d = -1;
                android.ext.Config.k();
                android.ext.r.I();
                break;
            case 4:
                config$pB = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_use_notification);
                if ((android.ext.Config.B & 256) != 0) {
                    i2 = 0;
                }
                config$pB.f42d = i2;
                android.ext.Config.k();
                android.ext.r.I();
                break;
            case 5:
                android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_hot_key).b();
                break;
            case 6:
                this.f1216a.T();
                break;
            case 7:
                android.ext.Config.f30c = 0L;
                android.ext.Config.k();
                android.ext.r.I();
                break;
            case 8:
                android.ext.ConfigListAdapter.b();
                break;
            case 9:
                android.ext.r.H();
                break;
            case 10:
                android.ext.r.O();
                break;
            case 11:
                android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_prevent_unload).b();
                break;
            case 12:
                android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_acceleration).b();
                break;
            case 13:
                android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_vspace_root).b();
                break;
            case 14:
                android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_number_locale).b();
                break;
            default:
                android.ext.r.I();
                break;
        }
    }
}
