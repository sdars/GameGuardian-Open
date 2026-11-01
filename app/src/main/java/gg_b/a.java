package gg_b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends java.io.PrintStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.StringBuilder f1486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private java.nio.ByteBuffer f1487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private java.nio.CharBuffer f1488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private java.nio.charset.CharsetDecoder f1489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final java.util.Formatter f1490e;

    protected a() {
        super(new a$a());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        this.f1486a = sb;
        this.f1490e = new java.util.Formatter(sb, (java.util.Locale) null);
    }

    private void a(boolean z) {
        int length = this.f1486a.length();
        int i = 0;
        while (i < length) {
            int iIndexOf = this.f1486a.indexOf("\n", i);
            if (iIndexOf == -1) {
                break;
            }
            b(this.f1486a.substring(i, iIndexOf));
            i = iIndexOf + 1;
        }
        if (!z) {
            this.f1486a.delete(0, i);
            return;
        }
        if (i < length || length == 0) {
            b(this.f1486a.substring(i));
        }
        this.f1486a.setLength(0);
    }

    @Override // java.io.PrintStream, java.lang.Appendable
    public synchronized java.io.PrintStream append(char c2) {
        try {
            print(c2);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
        return this;
    }

    @Override // java.io.PrintStream, java.lang.Appendable
    public synchronized java.io.PrintStream append(java.lang.CharSequence charSequence) {
        try {
            this.f1486a.append(charSequence);
            a(false);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
        return this;
    }

    @Override // java.io.PrintStream, java.lang.Appendable
    public synchronized java.io.PrintStream append(java.lang.CharSequence charSequence, int i, int i2) {
        try {
            this.f1486a.append(charSequence, i, i2);
            a(false);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
        return this;
    }

    protected abstract void b(java.lang.String str);

    @Override // java.io.PrintStream
    public boolean checkError() {
        return false;
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        try {
            a(true);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public java.io.PrintStream format(java.lang.String str, java.lang.Object... objArr) {
        return format(java.util.Locale.getDefault(), str, objArr);
    }

    @Override // java.io.PrintStream
    public synchronized java.io.PrintStream format(java.util.Locale locale, java.lang.String str, java.lang.Object... objArr) {
        try {
            if (str == null) {
                throw new java.lang.NullPointerException("format");
            }
            this.f1490e.format(locale, str, objArr);
            a(false);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
        return this;
    }

    @Override // java.io.PrintStream
    public synchronized void print(char c2) {
        try {
            this.f1486a.append(c2);
            if (c2 == '\n') {
                a(false);
            }
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void print(double d2) {
        try {
            this.f1486a.append(d2);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void print(float f2) {
        try {
            this.f1486a.append(f2);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void print(int i) {
        try {
            this.f1486a.append(i);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void print(long j) {
        try {
            this.f1486a.append(j);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void print(java.lang.Object obj) {
        try {
            this.f1486a.append(obj);
            a(false);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void print(java.lang.String str) {
        try {
            this.f1486a.append(str);
            a(false);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void print(boolean z) {
        try {
            this.f1486a.append(z);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void print(char[] cArr) {
        try {
            this.f1486a.append(cArr);
            a(false);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public java.io.PrintStream printf(java.lang.String str, java.lang.Object... objArr) {
        return format(str, objArr);
    }

    @Override // java.io.PrintStream
    public java.io.PrintStream printf(java.util.Locale locale, java.lang.String str, java.lang.Object... objArr) {
        return format(locale, str, objArr);
    }

    @Override // java.io.PrintStream
    public synchronized void println() {
        try {
            a(true);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void println(char c2) {
        try {
            this.f1486a.append(c2);
            a(true);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void println(double d2) {
        try {
            this.f1486a.append(d2);
            a(true);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void println(float f2) {
        try {
            this.f1486a.append(f2);
            a(true);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void println(int i) {
        try {
            this.f1486a.append(i);
            a(true);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void println(long j) {
        try {
            this.f1486a.append(j);
            a(true);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void println(java.lang.Object obj) {
        try {
            this.f1486a.append(obj);
            a(true);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void println(java.lang.String str) {
        try {
            if (this.f1486a.length() != 0 || str == null) {
                this.f1486a.append(str);
                a(true);
            } else {
                int length = str.length();
                int i = 0;
                while (i < length) {
                    int iIndexOf = str.indexOf(10, i);
                    if (iIndexOf == -1) {
                        break;
                    }
                    b(str.substring(i, iIndexOf));
                    i = iIndexOf + 1;
                }
                if (i < length) {
                    b(str.substring(i));
                }
            }
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void println(boolean z) {
        try {
            this.f1486a.append(z);
            a(true);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    public synchronized void println(char[] cArr) {
        try {
            this.f1486a.append(cArr);
            a(true);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.PrintStream
    protected void setError() {
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.PrintStream, java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        java.nio.charset.CoderResult coderResultDecode;
        try {
            if (this.f1489d == null) {
                this.f1487b = java.nio.ByteBuffer.allocate(80);
                this.f1488c = java.nio.CharBuffer.allocate(80);
                java.nio.charset.CharsetDecoder charsetDecoderNewDecoder = java.nio.charset.Charset.defaultCharset().newDecoder();
                java.nio.charset.CodingErrorAction codingErrorAction = java.nio.charset.CodingErrorAction.REPLACE;
                this.f1489d = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
            }
            int i3 = i2 + i;
            while (i < i3) {
                int iMin = java.lang.Math.min(this.f1487b.remaining(), i3 - i);
                this.f1487b.put(bArr, i, iMin);
                i += iMin;
                this.f1487b.flip();
                do {
                    coderResultDecode = this.f1489d.decode(this.f1487b, this.f1488c, false);
                    this.f1488c.flip();
                    this.f1486a.append((java.lang.CharSequence) this.f1488c);
                    this.f1488c.clear();
                } while (coderResultDecode.isOverflow());
                this.f1487b.compact();
            }
            a(false);
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }
}
