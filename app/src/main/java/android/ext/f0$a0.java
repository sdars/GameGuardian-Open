package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$a0 extends android.ext.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f803a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f0$a0(android.ext.f0 f0Var, java.lang.String str) {
        super(str);
        this.f803a = f0Var;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0177 A[Catch: all -> 0x0189, TRY_LEAVE, TryCatch #3 {all -> 0x0189, blocks: (B:37:0x0171, B:39:0x0177), top: B:76:0x0171 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0185  */
    /* JADX WARN: Code duplicated, block: B:47:0x0193 A[Catch: all -> 0x01a5, TRY_LEAVE, TryCatch #1 {all -> 0x01a5, blocks: (B:45:0x018d, B:47:0x0193), top: B:74:0x018d }] */
    /* JADX WARN: Code duplicated, block: B:49:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:55:0x01af A[Catch: all -> 0x01c1, TRY_LEAVE, TryCatch #0 {all -> 0x01c1, blocks: (B:53:0x01a9, B:55:0x01af), top: B:72:0x01a9 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:68:0x0202  */
    /* JADX WARN: Code duplicated, block: B:85:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x01a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x01be A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x0202, please report this as an issue */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        boolean zEquals;
        java.lang.String string;
        int i;
        int i2;
        int i3;
        java.lang.String str;
        android.ext.InOut inOut = this.f803a.f793b;
        try {
            java.lang.String strH = android.ext.e0.h();
            android.ext.f0 f0Var = this.f803a;
            android.ext.f0$n0 f0_n0O0 = f0Var.O0(strH);
            f0Var.f792a = f0_n0O0;
            android.ext.e2.f745a = "";
            inOut.o(f0_n0O0.f918c, f0_n0O0.f917b);
            inOut.n(true);
            android.ext.MainService.instance.q0();
            android.ext.e1.o(f0_n0O0.f916a, f0_n0O0.f919d);
            byte[] bArrK = inOut.k();
            if (bArrK == null) {
                str = "DI: null";
            } else if (bArrK.length != 7) {
                str = "DI: " + bArrK.length;
            } else {
                android.ext.w wVar = new android.ext.w(bArrK);
                byte bE = wVar.e();
                android.ext.InOut.p(bE == 8);
                byte bE2 = wVar.e();
                if (bE2 != 4) {
                    android.ext.e1.i("DI: QE " + ((int) bE2));
                }
                this.f803a.f796e = wVar.f();
                str = "DI: " + ((int) bE) + " " + ((int) bE2) + " " + this.f803a.f796e;
            }
            android.ext.e1.d(str);
            android.ext.w wVar2 = new android.ext.w(inOut.k());
            wVar2.e();
            byte[] bArr = new byte[wVar2.e()];
            wVar2.c(bArr);
            this.f803a.f798g = new java.lang.String(bArr);
            android.ext.e1.d("InOut: x64: " + android.ext.InOut.m + "; QE_ALIGN: 4; " + this.f803a.f796e + "; " + this.f803a.f798g);
            this.f803a.m.start();
            android.ext.MainService.instance.q0();
            inOut.m();
            this.f803a.v0((byte) 0);
        } catch (android.ext.f0$l0 e2) {
            android.ext.e1.l("start daemon failed", e2);
            java.lang.String str2 = "" + e2.getMessage();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            try {
                java.lang.String str3 = android.os.Build.CPU_ABI;
                sb.append(str3);
                sb.append("; ");
                zEquals = "armeabi".equals(str3);
            } catch (java.lang.Throwable thAbi1) {
                android.ext.e1.s("Failed get ABI", thAbi1);
                zEquals = false;
            }
            try {
                java.lang.String str4 = android.os.Build.CPU_ABI2;
                sb.append(str4);
                sb.append("; ");
                if ("armeabi".equals(str4)) {
                    zEquals = true;
                }
            } catch (java.lang.Throwable thAbi2) {
                android.ext.e1.s("Failed get ABI", thAbi2);
            }
            try {
                for (java.lang.String str5 : android.os.Build.SUPPORTED_ABIS) {
                    sb.append(str5);
                    sb.append("; ");
                    if ("armeabi".equals(str5)) {
                        zEquals = true;
                    }
                }
            } catch (java.lang.Throwable thAbi3) {
                android.ext.e1.s("Failed get ABI", thAbi3);
            }
            try {
                for (java.lang.String str6 : android.os.Build.SUPPORTED_32_BIT_ABIS) {
                    sb.append(str6);
                    sb.append("; ");
                    if ("armeabi".equals(str6)) {
                        zEquals = true;
                    }
                }
            } catch (java.lang.Throwable thAbi4) {
                android.ext.e1.s("Failed get ABI", thAbi4);
            }
            try {
                for (java.lang.String str7 : android.os.Build.SUPPORTED_64_BIT_ABIS) {
                    sb.append(str7);
                    sb.append("; ");
                    if ("armeabi".equals(str7)) {
                        zEquals = true;
                    }
                }
            } catch (java.lang.Throwable thAbi5) {
                android.ext.e1.s("Failed get ABI", thAbi5);
            }
            if (zEquals && android.ext.b2.d("ydwa", "raw") == 0) {
                str2 = str2 + "\n\n" + android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.try_arm_version) + ": " + android.ext.i.f999a;
            }
            string = sb.toString();
            if (string.contains("mips")) {
                str2 = str2 + "\n\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.mips_arch);
            }
            java.lang.String str8 = str2 + "\n\nABIs: " + string + '\n' + ((java.lang.Object) android.ext.e0.f730g) + '\n' + android.os.Build.VERSION.SDK_INT + '\n' + ((java.lang.Object) android.ext.e0.h);
            android.ext.e1.d("Supported ABIs: " + string);
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.failed_load_daemon)).setMessage(str8).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
            inOut.n(false);
            android.ext.MainService.instance.q0();
            android.ext.MainService.instance.q0();
        } catch (java.lang.Throwable th6) {
            android.ext.e1.l("start daemon failed", th6);
            android.ext.n2.i(new android.ext.f0$a0$a(this));
            inOut.n(false);
            android.ext.MainService.instance.q0();
        }
        android.ext.f0.r();
    }
}
