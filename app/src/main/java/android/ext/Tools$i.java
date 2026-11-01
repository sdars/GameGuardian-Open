package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$i implements java.lang.Runnable {
    Tools$i() {
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        java.lang.Throwable thB1;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Context info. act - ");
        sb.append(android.ext.Tools.v0(android.ext.r.p));
        sb.append("; app - ");
        sb.append(android.ext.Tools.v0(android.ext.r.o));
        sb.append("; dae - ");
        sb.append(android.ext.Tools.v0(android.ext.MainService.context));
        sb.append("; bad - ");
        java.lang.Throwable thB2 = android.ext.Tools.b1(android.ext.r.p);
        if (thB2 != null) {
            arrayList.add(thB2);
            i = 1;
        } else {
            i = 0;
        }
        java.lang.Throwable thB3 = android.ext.Tools.b1(android.ext.r.o);
        if (thB3 != null) {
            i += 10;
            arrayList.add(thB3);
        }
        if (android.ext.MainService.context != null && (thB1 = android.ext.Tools.b1(android.ext.MainService.context)) != null) {
            i += 100;
            arrayList.add(thB1);
        }
        sb.append(i);
        java.lang.String string = sb.toString();
        if (i > 0) {
            java.lang.RuntimeException runtimeException = new java.lang.RuntimeException(string);
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                runtimeException.addSuppressed((java.lang.Throwable) it.next());
            }
            android.ext.n0.h(java.lang.Thread.currentThread(), runtimeException, false);
        }
        android.ext.e1.d(string);
    }
}
