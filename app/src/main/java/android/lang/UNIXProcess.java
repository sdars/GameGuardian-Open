package android.lang;

/* JADX INFO: loaded from: classes.dex */
final class UNIXProcess extends java.lang.Process {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final java.util.concurrent.Executor f1474f = (java.util.concurrent.Executor) e(new android.lang.UNIXProcess$a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private java.io.OutputStream f1477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private java.io.InputStream f1478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private java.io.InputStream f1479e;
    final int pid;

    static {
        initIDs();
    }

    UNIXProcess(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, byte[] bArr4, int[] iArr, boolean z) throws java.io.IOException {
        this.pid = forkAndExec(bArr, bArr2, i, bArr3, i2, bArr4, iArr, z);try {

        try {            if (android.ext.GgNoop.never) {
                        throw new java.security.PrivilegedActionException(null);
                    }

            f(new android.lang.UNIXProcess$b(this, iArr));
        } catch (java.security.PrivilegedActionException e2) {
            throw ((java.io.IOException) e2.getException());
        };
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    private static native void destroyProcess(int i);

    public static java.lang.Object e(java.security.PrivilegedAction privilegedAction) {
        return java.security.AccessController.doPrivileged(privilegedAction);
    }

    public static java.lang.Object f(java.security.PrivilegedExceptionAction privilegedExceptionAction) {try {

        return java.security.AccessController.doPrivileged(privilegedExceptionAction);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    private native int forkAndExec(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, byte[] bArr4, int[] iArr, boolean z);

    static java.io.FileInputStream g(int i) {
        java.lang.reflect.Field declaredField;
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(j(i));
        try {
            try {
                declaredField = java.io.FileInputStream.class.getDeclaredField("isFdOwner");
            } catch (java.lang.NoSuchFieldException unused) {
                declaredField = java.io.FileInputStream.class.getDeclaredField("shouldClose");
            }
            declaredField.setAccessible(true);
            declaredField.set(fileInputStream, java.lang.Boolean.TRUE);
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("Failed set isFdOwner", th);
        }
        return fileInputStream;
    }

    static java.io.FileOutputStream h(int i) {
        java.lang.reflect.Field declaredField;
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(j(i));
        try {
            try {
                declaredField = java.io.FileOutputStream.class.getDeclaredField("isFdOwner");
            } catch (java.lang.NoSuchFieldException unused) {
                declaredField = java.io.FileOutputStream.class.getDeclaredField("shouldClose");
            }
            declaredField.setAccessible(true);
            declaredField.set(fileOutputStream, java.lang.Boolean.TRUE);
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("Failed set isFdOwner", th);
        }
        return fileOutputStream;
    }

    private static native void initIDs();

    static java.io.FileDescriptor j(int i) {
        java.io.FileDescriptor fileDescriptor = new java.io.FileDescriptor();
        try {
            java.lang.reflect.Field declaredField = java.io.FileDescriptor.class.getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            declaredField.set(fileDescriptor, java.lang.Integer.valueOf(i));
            return fileDescriptor;
        } catch (java.lang.Throwable th) {
            throw new java.lang.RuntimeException("Failed set fd", th);
        }
    }

    native int waitForProcessExit(int i);

    @Override // java.lang.Process
    public void destroy() {
        synchronized (this) {
            try {
                if (!this.f1476b) {
                    destroyProcess(this.pid);
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        try {
            this.f1477c.close();
        } catch (java.io.IOException unused) {
        }
        try {
            this.f1478d.close();
        } catch (java.io.IOException unused2) {
        }
        try {
            this.f1479e.close();
        } catch (java.io.IOException unused3) {
        }
    }

    @Override // java.lang.Process
    public synchronized int exitValue() {
        try {
            if (!this.f1476b) {
                throw new java.lang.IllegalThreadStateException("process hasn't exited");
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
        return this.f1475a;
    }

    @Override // java.lang.Process
    public java.io.InputStream getErrorStream() {
        return this.f1479e;
    }

    @Override // java.lang.Process
    public java.io.InputStream getInputStream() {
        return this.f1478d;
    }

    @Override // java.lang.Process
    public java.io.OutputStream getOutputStream() {
        return this.f1477c;
    }

    void i(int[] iArr) {
        this.f1477c = iArr[0] == -1 ? android.lang.UNIXProcess$e.f1484a : new android.lang.UNIXProcess$g(iArr[0]);
        this.f1478d = iArr[1] == -1 ? android.lang.UNIXProcess$d.f1483a : new android.lang.UNIXProcess$f(iArr[1]);
        this.f1479e = iArr[2] == -1 ? android.lang.UNIXProcess$d.f1483a : new android.lang.UNIXProcess$f(iArr[2]);
        f1474f.execute(new android.lang.UNIXProcess$c(this));
    }

    void k(int i) {
        synchronized (this) {
            try {
                this.f1475a = i;
                this.f1476b = true;
                notifyAll();
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        java.io.InputStream inputStream = this.f1478d;
        if (inputStream instanceof android.lang.UNIXProcess$f) {
            ((android.lang.UNIXProcess$f) inputStream).b();
        }
        java.io.InputStream inputStream2 = this.f1479e;
        if (inputStream2 instanceof android.lang.UNIXProcess$f) {
            ((android.lang.UNIXProcess$f) inputStream2).b();
        }
        java.io.OutputStream outputStream = this.f1477c;
        if (outputStream instanceof android.lang.UNIXProcess$g) {
            ((android.lang.UNIXProcess$g) outputStream).a();
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Process[pid=");
        sb.append(this.pid);
        if (this.f1476b) {
            sb.append(", hasExited=true, exitcode=");
            sb.append(this.f1475a);
            sb.append(']');
        } else {
            sb.append(", hasExited=false]");
        }
        return sb.toString();
    }

    @Override // java.lang.Process
    public synchronized int waitFor() {
        while (!this.f1476b) {
            try {
                wait();
            } catch (java.lang.Throwable th) {try {

                throw th;
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
            }
        }
        return this.f1475a;
    }
}
