package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class g extends java.util.zip.ZipOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.ext.g$a f980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private java.util.zip.ZipEntry f981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final java.util.zip.CRC32 f982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f984f;

    public g(java.io.OutputStream outputStream) {
        super(new android.ext.g$a(new java.io.BufferedOutputStream(outputStream, 65536)));
        this.f979a = false;
        this.f981c = null;
        this.f982d = new java.util.zip.CRC32();
        this.f983e = 0;
        this.f984f = null;
        this.f980b = android.ext.g$a.f985c;
        setComment("");
    }

    public static java.lang.String a(java.util.zip.ZipEntry zipEntry) {
        if (zipEntry == null) {
            return "null";
        }
        return zipEntry.getName() + ", method: " + zipEntry.getMethod() + ", crc: 0x" + java.lang.Long.toHexString(zipEntry.getCrc()) + ", size: " + zipEntry.getSize() + ", compressed size: " + zipEntry.getCompressedSize();
    }

    @Override // java.util.zip.ZipOutputStream
    public void closeEntry() throws java.io.IOException {
        try {
            java.util.zip.ZipEntry zipEntry = this.f981c;
            if (zipEntry != null && zipEntry.getMethod() == 0) {
                if (this.f981c.getCrc() != this.f982d.getValue()) {
                    android.ext.e1.p("CRC mismatch: " + a(this.f981c) + " != " + this.f982d.getValue());
                    this.f981c.setCrc(this.f982d.getValue());
                }
                if (this.f981c.getSize() != this.f983e) {
                    android.ext.e1.p("Size mismatch: " + a(this.f981c) + " != " + this.f983e);
                    this.f981c.setSize((long) this.f983e);
                }
                if (this.f981c.getCompressedSize() != this.f981c.getSize()) {
                    android.ext.e1.p("CompressedSize mismatch: " + a(this.f981c) + " != " + this.f981c.getSize());
                    java.util.zip.ZipEntry zipEntry2 = this.f981c;
                    zipEntry2.setCompressedSize(zipEntry2.getSize());
                }
            }
            super.closeEntry();
            this.f979a = false;
            this.f981c = null;
            this.f982d.reset();
            this.f983e = 0;
        } catch (java.util.zip.ZipException e2) {
            throw new java.lang.RuntimeException("Failed close entry: " + a(this.f981c), e2);
        }
    }

    @Override // java.util.zip.ZipOutputStream
    public void putNextEntry(java.util.zip.ZipEntry zipEntry) throws java.io.IOException {
        zipEntry.setComment("");
        this.f981c = zipEntry;
        if (this.f979a) {
            closeEntry();
        }
        if (zipEntry.getMethod() == 0) {
            flush();
            int length = this.f980b.f987b + 30 + zipEntry.getName().getBytes("UTF-8").length;
            int i = android.ext.h3.b(zipEntry.getName()) ? 4096 : 4;
            zipEntry.setExtra(new byte[(i - (length % i)) % i]);
            zipEntry.setCompressedSize(zipEntry.getSize());
        }
        super.putNextEntry(zipEntry);
        this.f979a = true;
        this.f982d.reset();
        this.f983e = 0;
    }

    @Override // java.util.zip.ZipOutputStream
    public void setComment(java.lang.String str) {
        super.setComment("");
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        byte[] bArr = this.f984f;
        if (bArr == null) {
            bArr = new byte[1];
            this.f984f = bArr;
        }
        bArr[0] = (byte) (i & 255);
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.util.zip.ZipOutputStream, java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        super.write(bArr, i, i2);
        this.f982d.update(bArr, i, i2);
        this.f983e += i2;
    }
}
