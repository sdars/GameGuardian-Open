    public void l0(android.ext.w wVar) throws java.lang.Throwable {
        android.ext.Tools$a0 tools$a0 = android.ext.Tools.J0(this.G);
        byte b2 = wVar.b();
        long[] jArr = null;
        int[] iArr = null;
        int i = 0;
        boolean z2;
        int iK;
        gg_d.a aVar = this.s0;
        android.ext.c cVar = new android.ext.c();
        int i9 = android.ext.b0.i();
        try {
            wVar.j();
            iK = (wVar.k() - wVar.a()) - 1;
            wVar.f();
            synchronized (aVar) {
                /* dex :try_start_1 - remember whether the checked data was
                   already saved before it is invalidated */
                z2 = S0;
                S0 = false;
                if (!z2) {
                    /* dex :try_start_2 - collect the addresses of the ranges
                       that are currently marked */
                    try {
                        int i10 = aVar.i();
                        long[] jArr2 = new long[i10];
                        int[] iArr2 = new int[i10];
                        android.ext.c cVar2 = new android.ext.c();
                        int i11 = 0;
                        for (int i12 = 0; i12 < i10; i12++) {
                            if (aVar.c(i12)) {
                                aVar.f(i12, cVar2);
                                jArr2[i11] = cVar2.f672a;
                                int i13 = i11 + 1;
                                iArr2[i11] = android.ext.c.w(cVar2.f674c);
                                i11 = i13;
                            }
                        }
                        jArr = jArr2;
                        iArr = iArr2;
                        i = i11;
                    } catch (java.lang.OutOfMemoryError e) {
                        /* dex :catch_0 -> :goto_2 */
                        android.ext.e1.l("Failed save checked data", e);
                        jArr = null;
                        iArr = null;
                        i = 0;
                    }
                }
                /* dex :goto_3 */
                aVar.d();
                int i2 = iK / (android.ext.InOut.n + 12);
                if (b2 == 0 && i2 > i9) {
                    i2 = i9;
                }
                aVar.e(i2);
                int i3 = 0;
                /* dex :goto_4 */
                while (iK - wVar.a() > 10 && (b2 != 0 || aVar.i() < i9)) {
                    /* dex :goto_5 */
                    long jG = wVar.g();
                    long jH = wVar.h();
                    int iF = wVar.f();
                    cVar.f672a = jG;
                    cVar.f674c = iF;
                    boolean flag;
                    if (jArr != null) {
                        /* dex :goto_6 - look for the address in the saved set */
                        int iW = android.ext.c.w(iF);
                        flag = z2;
                        while (i3 < i) {
                            long j = jArr[i3];
                            if (j == jG) {
                                int i8 = iArr[i3];
                                if (i8 == iW) {
                                    i3 = i3 + 1;
                                    flag = true;
                                    break;
                                } else if (i8 > iW) {
                                    break;
                                }
                            } else if (!android.ext.Tools.S1(j, jG)) {
                                break;
                            }
                            i3++;
                        }
                    } else {
                        flag = z2;
                    }
                    aVar.a(jG, jH, iF, flag);
                }
                /* dex :goto_b */
                aVar.k();
                if (b2 != 0) {
                    int i4 = aVar.i();
                    java.util.ArrayList arrayList = new java.util.ArrayList(i4);
                    for (int i5 = 0; i5 < i4; i5++) {
                        android.ext.c cVarF = aVar.f(i5, null);
                        if (cVarF != null) {
                            arrayList.add(cVarF);
                        }
                    }
                    arrayList.trimToSize();
                    android.ext.Script.d3(b2, arrayList);
                }
            }
        } catch (java.io.UncheckedIOException e) {
            /* dex :catch_1 / :catch_3 -> :goto_10 - the dex catches a plain java.io.IOException here; the buffer based reader of android.ext.w can only raise the unchecked variant, so the handler keeps the matching unchecked type. */
            android.ext.e1.l("Failed read", e);
        } catch (java.lang.OutOfMemoryError e) {
            /* dex :catch_2 / :catch_4 -> :goto_11 */
            int i14 = this.s0.i();
            this.s0.d();
            this.s0.k();
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R$string.out_of_memory_error);
            android.ext.e1.s("list.size() = " + i14 + "; show count = " + android.ext.b0.i(), e);
        }
        /* dex :goto_12 */
        this.V(this.G.getAdapter());
        this.b1();
        if (b2 == 0) {
            this.B++;
        }
        android.ext.Tools.A1(this.G, tools$a0);
        instance.p1();
        this.X(b2, null);
    }
