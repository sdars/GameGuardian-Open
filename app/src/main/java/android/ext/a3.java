package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class a3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f573c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f572b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f571a = new int[32];

    public a3(int i) {
        this.f573c = i;
    }

    private void b() {
        int i = this.f572b;
        int[] iArr = this.f571a;
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(i * 4);
        byteBufferAllocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        for (int i2 = 0; i2 < i; i2++) {
            byteBufferAllocate.putInt(iArr[i2]);
        }
        java.lang.String strEncodeToString = android.util.Base64.encodeToString(byteBufferAllocate.array(), 11);
        new android.ext.g2().putString("used-" + this.f573c, strEncodeToString).commit();
    }

    public void a(int i) {
        int i2 = this.f572b;
        int[] iArrCopyOf = this.f571a;
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArrCopyOf[i3] == i) {
                return;
            }
        }
        if (i2 == iArrCopyOf.length) {
            iArrCopyOf = java.util.Arrays.copyOf(iArrCopyOf, iArrCopyOf.length + 32);
            this.f571a = iArrCopyOf;
        }
        iArrCopyOf[i2] = i;
        this.f572b = i2 + 1;
        b();
    }
}
