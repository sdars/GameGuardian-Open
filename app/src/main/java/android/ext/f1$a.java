package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$a implements java.lang.Runnable {
    f1$a() {
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @Override // java.lang.Runnable
    public void run() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            android.ext.f1.B(r0, r1)
            android.ext.b1$c0 r2 = android.ext.b1.j0()
            boolean r2 = r2.f610a
            android.ext.r r3 = android.ext.r.n
            r4 = 0
            if (r2 == 0) goto L1a
            boolean r5 = android.ext.Config.vSpaceReal
            if (r5 == 0) goto L18
            boolean r5 = android.ext.Config.D
            if (r5 == 0) goto L1a
        L18:
            r5 = 1
            goto L1b
        L1a:
            r5 = 0
        L1b:
            r3.f1206d = r5
            if (r2 == 0) goto L43
            boolean r0 = android.ext.ConfigListAdapter.k()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Install64: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            android.ext.e1.d(r1)
            if (r0 == 0) goto L3e
            android.ext.f1.M()
            goto Lba
        L3e:
            android.ext.f1.L()
            goto Lba
        L43:
            android.ext.r.q = r4
            boolean r2 = android.ext.f1.f954d
            if (r2 == 0) goto L52
            r0 = 8
            android.ext.f1.B(r0, r1)
        L4e:
            android.ext.f1.D()
            goto Lba
        L52:
            boolean r2 = android.ext.u.c()
            r3 = 2
            if (r2 == 0) goto L5a
            goto L5b
        L5a:
            r0 = 2
        L5b:
            android.ext.f1.f(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            if (r2 != 0) goto L9b
            r0.<init>()
            java.lang.String r2 = "Not instr: "
            r0.append(r2)
            int r2 = android.os.Process.myUid()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.ext.e1.d(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = ""
            r0.append(r2)
            int r2 = android.ext.Config.z
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.ext.f1.B(r3, r0)
            android.ext.f1$a$a r0 = new android.ext.f1$a$a
            r0.<init>(r6)
            android.ext.n2.i(r0)
            r0 = 4
            android.ext.f1.B(r0, r1)
            goto Lba
        L9b:
            r0.<init>()
            java.lang.String r2 = "Use instr: "
            r0.append(r2)
            int r2 = android.os.Process.myUid()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.ext.e1.d(r0)
            r0 = 9
            android.ext.f1.B(r0, r1)
            android.ext.f1.O()
            goto L4e
        Lba:
            return
        */
        android.ext.f1.B(1, (java.lang.String) null);
        boolean z = android.ext.b1.j0().f610a;
        android.ext.r rVar = android.ext.r.n;
        boolean z2 = z && (!android.ext.Config.vSpaceReal || android.ext.Config.D);
        rVar.f1206d = z2;
        if (z) {
            boolean z3 = android.ext.ConfigListAdapter.k();
            android.ext.e1.d("Install64: " + z3);
            if (z3) {
                android.ext.f1.M();
            } else {
                android.ext.f1.L();
            }
            return;
        }
        android.ext.r.q = false;
        if (android.ext.f1.f954d) {
            android.ext.f1.B(8, (java.lang.String) null);
            android.ext.f1.D();
            return;
        }
        boolean z4 = android.ext.u.c();
        android.ext.f1.f(z4 ? (byte) 1 : (byte) 2);
        if (!z4) {
            android.ext.e1.d("Not instr: " + android.os.Process.myUid());
            android.ext.f1.B(2, "" + android.ext.Config.z);
            android.ext.n2.i(new android.ext.f1$a$a(this));
            android.ext.f1.B(4, (java.lang.String) null);
            return;
        }
        android.ext.e1.d("Use instr: " + android.os.Process.myUid());
        android.ext.f1.B(9, (java.lang.String) null);
        android.ext.f1.O();
        android.ext.f1.D();
    }
}
